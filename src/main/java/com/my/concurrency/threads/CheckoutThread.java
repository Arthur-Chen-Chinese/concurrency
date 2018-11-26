package com.my.concurrency.threads;

import com.my.concurrency.db.DbHelper;
import com.my.concurrency.forms.MainForm;
import com.my.concurrency.models.Checkout;
import com.my.concurrency.models.Customer;
import com.my.concurrency.models.FastForward;
import com.my.concurrency.models.History;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Queue;

public class CheckoutThread implements Runnable {
    private MainForm mf;
    private int orderOfCheckout;
    private int numOfCheckout;
    private int numOf5OrLessCheckout = 0;
    private Checkout checkout;
    private ArrayList<Queue<Customer>> waitLineLists;
    private boolean is5OrLess;
    private boolean stop = false;
    private History history;


    public void stopThread() {
        this.stop = true;
    }

    public CheckoutThread(MainForm mf, int numOf5OrLessCheckout, int numOfCheckout, int orderOfCheckout, Checkout checkout, ArrayList<JPanel> waitingLineList, ArrayList<Queue<Customer>> customerWaitingLists, ArrayList<Queue<Customer>> customer5OrLessWaitingLists, boolean is5OrLess, History history) {
        this.mf = mf;
        this.orderOfCheckout = orderOfCheckout;
        this.numOfCheckout = numOfCheckout;
        this.numOf5OrLessCheckout = is5OrLess ? numOf5OrLessCheckout : 0;
        this.checkout = checkout;
        this.is5OrLess = is5OrLess;
        this.waitLineLists = is5OrLess ? customer5OrLessWaitingLists : customerWaitingLists;
        this.history = history;
    }

    @Override
    public void run() {
        while (!stop) {
            Customer customerPolled;
            synchronized (waitLineLists) {
                if (is5OrLess) {
                    customerPolled = (Customer) waitLineLists.get(numOf5OrLessCheckout - 1).poll();
                } else {
                    customerPolled = (Customer) waitLineLists.get(numOfCheckout - 1).poll();
                }
            }
            if (customerPolled == null) {
                mf.updateCheckout(orderOfCheckout, MainForm.CheckoutAvaiableStatus);
            } else {
                customerPolled.setCheckStartTime(new Date());
                customerPolled.setCheckStartNanosec(System.nanoTime());

                System.out.println("5orless " + is5OrLess + " " + orderOfCheckout + " " + customerPolled);
                mf.updateWaitingLine(orderOfCheckout, null);
                mf.updateCheckout(orderOfCheckout, MainForm.CheckoutBusyStatus);
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

                DbHelper dbHelper = new DbHelper(history);
                dbHelper.updateCustomer(customerPolled);

                history.setCusEndId(customerPolled.getId());
                checkout.setNumOfCheckedItems(checkout.getNumOfCheckedItems() + customerPolled.getNumOfProducts());
                checkout.setNumOfCheckedCustomers(checkout.getNumOfCheckedCustomers() + 1);
            }
        }
        checkout.setFinishedTime(new Date());

    }
}
