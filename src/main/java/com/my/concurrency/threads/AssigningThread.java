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
    private MainForm mf;
    private ArrayList<Queue<Customer>> customerWaitingLists;
    private ArrayList<Queue<Customer>> customer5OrLessWaitingLists;
    private BlockingQueue<Customer> customerList;
    private int numOf5OrLess;
    private int numOfCheckout;
    private boolean stop = false;
    private History history;

    public AssigningThread(MainForm mf, ArrayList<Queue<Customer>> customerWaitingLists, ArrayList<Queue<Customer>> customer5OrLessWaitingLists, BlockingQueue<Customer> customerList, int numOf5OrLess, int numOfCheckout, History history) {
        this.mf = mf;
        this.customerWaitingLists = customerWaitingLists;
        this.customer5OrLessWaitingLists = customer5OrLessWaitingLists;
        this.customerList = customerList;
        this.numOf5OrLess = numOf5OrLess;
        this.numOfCheckout = numOfCheckout;
        this.history = history;
    }

    public void stopThread() {
        this.stop = true;
    }

    @Override
    public void run() {
        while (!stop) {
            try {
                Customer customerToken = customerList.take();//if take successfully, check whether the all waitlines are full or not
                Integer numOfProducts = customerToken.getNumOfProducts();
                boolean leave_flag = true;
                int num = 0;
                //check if the all wait lines are full or not
                synchronized (customerWaitingLists) {
                    synchronized (customer5OrLessWaitingLists) {
                        if (numOfProducts < 6 && numOf5OrLess > 0) {
                            for (int i = 0; i < numOf5OrLess; i++) {
                                Queue<Customer> q = customer5OrLessWaitingLists.get(i);
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
                                Queue<Customer> q = customerWaitingLists.get(i);
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
                    history.setCusEndId(customerToken.getId());
                } else {
                    mf.updateWaitingLine(num, customerToken);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
