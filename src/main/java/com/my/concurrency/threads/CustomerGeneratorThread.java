package com.my.concurrency.threads;

import com.my.concurrency.db.DbHelper;
import com.my.concurrency.forms.MainForm;
import com.my.concurrency.models.Customer;
import com.my.concurrency.models.FastForward;
import com.my.concurrency.models.History;

import java.util.Date;
import java.util.concurrent.BlockingQueue;

public class CustomerGeneratorThread implements Runnable {

    private MainForm mf;
    private BlockingQueue<Customer> customerList;
    private int numOfProducts;
    private History h;

    @Override
    public void run() {

        while (true) {
            //generate a new customer
            Customer customer = new Customer();
            customer.setLostFlag(new Byte("0"));
            customer.setArrivedTime(new Date());
            int randomNumOfProducts = (int) (1 + Math.random() * (numOfProducts));
            customer.setNumOfProducts(randomNumOfProducts);
            //put the new customer into the pool where customer is waiting to be assigned to a certain checkout thread
            boolean isSuccessful = customerList.offer(customer);
            if (!isSuccessful) {
                //failing to put customer into the pool means the customerList is full, so the customer leaves
                customer.setCheckoutId(0);
                customer.setCheckStartTime(new Date(0));
                customer.setCheckEndTime(new Date(0));
                customer.setFinishedTime(new Date());
                customer.setLostFlag(new Byte("1"));

                DbHelper dbHelper = new DbHelper();
                dbHelper.insertACustomer(customer);
            }
            int timeToSleep = FastForward.generateTimeByFast(FastForward.TimeToGenerateACustomer);
            try {
                Thread.sleep(timeToSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
