package com.my.concurrency.threads;

import com.my.concurrency.db.DbHelper;
import com.my.concurrency.forms.MainForm;
import com.my.concurrency.models.Checkout;
import com.my.concurrency.models.Customer;
import com.my.concurrency.models.FastForward;
import com.my.concurrency.models.History;

import java.util.ArrayList;
import java.util.Date;
import java.util.Queue;

public class CheckoutThread implements Runnable {
    /**
     * The point references to mainForm, which is used to update GUI
     */
    private MainForm mf;
    /**
     * The order in the checkouts  sequence
     */
    private int orderOfCheckout;
    /**
     * The order of normal checkouts
     */
    private int orderOfNormalCheckout;
    /**
     * The order of 5OrLess checkouts
     */
    private int orderOf5OrLessCheckout = 0;
    /**
     * The checkout assigned to the thread
     */
    private Checkout checkout;
    /**
     * The waiting line lists of the corresponding checkouts
     */
    private ArrayList<Queue<Customer>> waitLineLists;
    /**
     * The flag shows whether the checkout assigned to the thread is 5OrLess
     */
    private boolean is5OrLess;
    /**
     * The flag to stop the thread
     */
    private boolean stop = false;
    /**
     * The history reference
     */
    private History history;


    /**
     * The constructor of checkout thread
     *
     * @param mf                          the point references to mainForm, which is used to update GUI
     * @param orderOf5OrLessCheckout      the order of 5Orless checkout
     * @param orderOfNormalCheckout       the order of normal checkout
     * @param orderOfCheckout             The order in the checkouts  sequence
     * @param checkout                    The checkout assigned to the thread
     * @param customerWaitingLists        The waiting line lists of the normal checkouts
     * @param customer5OrLessWaitingLists The waiting line lists of the 5OrLess checkouts
     * @param is5OrLess                   The flag shows whether the checkout assigned to the thread is 5OrLess
     * @param history                     The history reference
     */
    public CheckoutThread(MainForm mf, int orderOf5OrLessCheckout, int orderOfNormalCheckout, int orderOfCheckout, Checkout checkout, ArrayList<Queue<Customer>> customerWaitingLists, ArrayList<Queue<Customer>> customer5OrLessWaitingLists, boolean is5OrLess, History history) {
        this.mf = mf;
        this.orderOfCheckout = orderOfCheckout;
        this.orderOfNormalCheckout = orderOfNormalCheckout;
        this.orderOf5OrLessCheckout = is5OrLess ? orderOf5OrLessCheckout : 0;
        this.checkout = checkout;
        this.is5OrLess = is5OrLess;
        this.waitLineLists = is5OrLess ? customer5OrLessWaitingLists : customerWaitingLists;
        this.history = history;
    }

    /**
     * The method is to tell the while loop in run() to stop
     */
    public void stopThread() {
        this.stop = true;
    }

    /**
     * The run() method defines the functionality of checkout Thread
     * The method simulates that a checkout get a customer from the corresponding waiting line(synchronized)
     * and sleep() for a time which equals to the sum of time of products in the customer's trolley
     * then,store the customer to the database
     */
    @Override
    public void run() {
        while (!stop) {
            Customer customerPolled;
            synchronized (waitLineLists) {
                if (is5OrLess) {
                    customerPolled = (Customer) waitLineLists.get(orderOf5OrLessCheckout - 1).poll();
                } else {
                    customerPolled = (Customer) waitLineLists.get(orderOfNormalCheckout - 1).poll();
                }
            }
            if (customerPolled == null) {
                mf.updateCheckout(orderOfCheckout, MainForm.CheckoutAvaiableStatus);
                mf.updateWaitingLine(orderOfCheckout, null);
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
