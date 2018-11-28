package com.my.concurrency.threads;

import com.my.concurrency.db.DbHelper;
import com.my.concurrency.forms.MainForm;
import com.my.concurrency.models.Customer;
import com.my.concurrency.models.History;

import java.util.ArrayList;
import java.util.Date;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class AssigningThread implements Runnable {
    /**
     * The point references to mainForm, which is used to update GUI
     */
    private MainForm mf;
    /**
     * customer already in normal waitingLines in supermarket
     */
    private ArrayList<Queue<Customer>> customerWaitingLineLists;
    /**
     * customer already in 5OrLess waitingLines in supermarket
     */
    private ArrayList<Queue<Customer>> customer5OrLessWaitingLineLists;
    /**
     * The list of customers generated
     */
    private BlockingQueue<Customer> customerList;
    /**
     * The number of 5OrLess checkouts
     */
    private int numOf5OrLess;
    /**
     * The number of total checkouts
     */
    private int numOfCheckout;
    /**
     * The flag to stop the thread
     */
    private boolean stop = false;
    /**
     * The history reference
     */
    private History history;

    /**
     * The constructor of assigning thread
     *
     * @param mf                              the point references to mainForm, which is used to update GUI
     * @param customerWaitingLineLists        customer already in normal waitingLines in supermarket, passed from mainForm
     * @param customer5OrLessWaitingLineLists customer already in 5OrLess waitingLines in supermarket, passed from mainForm
     * @param customerList                    The list of customers generated
     * @param numOf5OrLess                    The number of 5OrLess checkouts
     * @param numOfCheckout                   The number of total checkouts
     * @param history                         The history reference
     */
    public AssigningThread(MainForm mf, ArrayList<Queue<Customer>> customerWaitingLineLists, ArrayList<Queue<Customer>> customer5OrLessWaitingLineLists, BlockingQueue<Customer> customerList, int numOf5OrLess, int numOfCheckout, History history) {
        this.mf = mf;
        this.customerWaitingLineLists = customerWaitingLineLists;
        this.customer5OrLessWaitingLineLists = customer5OrLessWaitingLineLists;
        this.customerList = customerList;
        this.numOf5OrLess = numOf5OrLess;
        this.numOfCheckout = numOfCheckout;
        this.history = history;
    }

    /**
     * The method is to tell the while loop in run() to stop
     */
    public void stopThread() {
        this.stop = true;
    }

    /**
     * The run() method defines the functionality of Assigning Thread
     * The method take customer from customerList where the generated customer is stored
     * and assign the customer to the WaitingLineList(or 5OrLess WaitingLineList) according to the number of items the customer had
     * if all the waitingLine are full, the customer leaves the store
     */
    @Override
    public void run() {
        while (!stop) {
            try {
                Customer customerToken = customerList.take();//if take successfully, check whether the all waitlines are full or not
                Integer numOfProducts = customerToken.getNumOfProducts();
                boolean leave_flag = true;
                int num = 0;
                //check if the all wait lines are full or not
                synchronized (customerWaitingLineLists) {
                    synchronized (customer5OrLessWaitingLineLists) {
                        if (numOfProducts < 6 && numOf5OrLess > 0) {
                            for (int i = 0; i < numOf5OrLess; i++) {
                                Queue<Customer> q = customer5OrLessWaitingLineLists.get(i);
                                if (q.size() < 6) {
                                    q.offer(customerToken);
                                    num = i + 1;
                                    System.out.println("customer " + customerToken.getId() + " is assign to checkout" + num);
                                    leave_flag = false;
                                    break;
                                }
                            }
                        }
                        if (leave_flag != false) {
                            num = numOf5OrLess;
                            for (int i = 0; i < numOfCheckout - numOf5OrLess; i++) {
                                Queue<Customer> q = customerWaitingLineLists.get(i);
                                if (q.size() < 6) {
                                    q.offer(customerToken);
                                    num += i + 1;
                                    System.out.println("customer " + customerToken.getId() + " is assign to checkout" + num);
                                    leave_flag = false;
                                    break;
                                }
                            }
                        }
                    }
                }
                if (leave_flag) {
                    //customer leaves
                    customerToken.setCheckoutId(0);
                    customerToken.setCheckStartTime(new Date(0));
                    customerToken.setCheckEndTime(new Date(0));
                    customerToken.setFinishedTime(new Date());
                    customerToken.setLostFlag(new Byte("1"));
                    DbHelper dbHelper = new DbHelper(history);
                    dbHelper.updateCustomer(customerToken);
                } else {
                    mf.updateWaitingLine(num, customerToken);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
