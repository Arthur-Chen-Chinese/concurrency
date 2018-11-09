package com.my.concurrency.threads;

import com.my.concurrency.db.DbHelper;
import com.my.concurrency.forms.MainForm;
import com.my.concurrency.models.Checkout;
import com.my.concurrency.models.Customer;
import com.my.concurrency.models.FastForward;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Queue;

public class CheckoutThread implements Runnable {
    private MainForm mf;
    private int numOfCheckout;
    private Checkout checkout;
    private ArrayList<JPanel> waitingLineList;
    private ArrayList<Queue<Customer>> waitingList;
    private boolean is5OrLess;

    public CheckoutThread(MainForm mf, int numOfCheckout, Checkout checkout, ArrayList<JPanel> waitingLineList, ArrayList<Queue<Customer>> customerWaitingLists, ArrayList<Queue<Customer>> customer5OrLessWaitingLists, boolean is5OrLess) {
        this.mf = mf;
        this.numOfCheckout = numOfCheckout;
        this.checkout = checkout;
        this.waitingLineList = waitingLineList;
        this.waitingList = is5OrLess ? customer5OrLessWaitingLists : customerWaitingLists;
        this.is5OrLess = is5OrLess;
    }

    @Override
    public void run() {
        while (true) {
            Customer customerPolled;
            synchronized (waitingList) {
                customerPolled = (Customer) waitingList.get(numOfCheckout - 1).poll();
            }
            if (customerPolled == null) {
                mf.updateCheckout(numOfCheckout, MainForm.CheckoutAvaiableStatus);
            } else {
                customerPolled.setCheckStartTime(new Date());
                mf.updateWaitingLine(numOfCheckout, null);
                mf.updateCheckout(numOfCheckout, MainForm.CheckoutBusyStatus);
                int totalTime = 0;
                Integer numOfProducts = customerPolled.getNumOfProducts();
                for (int i = 0; i < numOfProducts; i++) {
                    totalTime += FastForward.generateTimeByFast(FastForward.TimeToCheckout);
                }
                try {
                    Thread.sleep(totalTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                customerPolled.setCheckoutId(checkout.getId());
                customerPolled.setLostFlag(new Byte("0"));
                customerPolled.setCheckEndTime(new Date());
                customerPolled.setFinishedTime(new Date());

                DbHelper dbHelper = new DbHelper();
                dbHelper.insertACustomer(customerPolled);
            }
        }

    }
}
