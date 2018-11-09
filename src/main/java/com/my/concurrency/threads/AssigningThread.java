package com.my.concurrency.threads;

import com.my.concurrency.db.DbHelper;
import com.my.concurrency.forms.MainForm;
import com.my.concurrency.models.Customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class AssigningThread implements Runnable {
    private MainForm mf;
    private ArrayList<Queue<Customer>> customerWaitingLists;
    private ArrayList<Queue<Customer>> customer5OrLessWaitingLists;
    private BlockingQueue<Customer> customerList;


    public AssigningThread(MainForm mf, ArrayList<Queue<Customer>> customerWaitingLists, ArrayList<Queue<Customer>> customer5OrLessWaitingLists, BlockingQueue<Customer> customerList) {
        this.mf = mf;
        this.customerWaitingLists = customerWaitingLists;
        this.customer5OrLessWaitingLists = customer5OrLessWaitingLists;
        this.customerList = customerList;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Customer customerToken = customerList.take();//if take successfully, check whether the all wait lines are full or not
                Integer numOfProducts = customerToken.getNumOfProducts();
                boolean leave_flag = true;
                int numOfCheckout = 0;
                //check if the all wait lines are full or not
                synchronized (customerWaitingLists) {
                    synchronized (customer5OrLessWaitingLists) {
                        if (numOfProducts < 6 && customer5OrLessWaitingLists.size() > 0) {
                            for (int i = 0; i < customer5OrLessWaitingLists.size(); i++) {
                                Queue<Customer> q = customer5OrLessWaitingLists.get(i);
                                if (q.size() < 6) {
                                    q.offer(customerToken);
                                    numOfCheckout = i + 1;
                                    leave_flag = false;
                                }
                            }
                        }
                        if (leave_flag != false) {
                            for (int i = 0; i < customerWaitingLists.size(); i++) {
                                Queue<Customer> q = customerWaitingLists.get(i);
                                if (q.size() < 6) {
                                    q.offer(customerToken);
                                    numOfCheckout = i + 1;
                                    leave_flag = false;
                                }
                            }
                        }
                    }
                }
                mf.updateWaitingLine(numOfCheckout, customerToken);
                if (leave_flag) {
                    //customer leaves
                    customerToken.setCheckoutId(0);
                    customerToken.setCheckStartTime(new Date(0));
                    customerToken.setCheckEndTime(new Date(0));
                    customerToken.setFinishedTime(new Date());
                    customerToken.setLostFlag(new Byte("1"));
                    DbHelper dbHelper = new DbHelper();
                    dbHelper.insertACustomer(customerToken);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
