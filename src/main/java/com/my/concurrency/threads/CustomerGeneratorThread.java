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
    private History history;
    private boolean stop = false;


    public CustomerGeneratorThread(MainForm mf, BlockingQueue<Customer> customerList, int numOfProducts, History history) {
        this.mf = mf;
        this.customerList = customerList;
        this.numOfProducts = numOfProducts;
        this.history = history;
    }

    public void stopThread() {
        this.stop = true;
    }

    @Override
    public void run() {

        //generate a new customer
        Customer customer = new Customer();
        customer.setLostFlag(new Byte("0"));
        customer.setArrivedTime(new Date());
        customer.setArrivedNanosec(System.nanoTime());
        int randomNumOfProducts = (int) (1 + Math.random() * (numOfProducts));
        customer.setNumOfProducts(randomNumOfProducts);
        DbHelper dbHelper = new DbHelper(history);
        dbHelper.insertACustomer(customer);
        history.setCusStartId(customer.getId());

        //put the new customer into the pool where customer is waiting to be assigned to a certain checkout thread
        boolean isSuccessful = customerList.offer(customer);
        if (!isSuccessful) {
            //failing to put customer into the pool means the customerList is full, so the customer leaves
            customer.setCheckoutId(0);
            customer.setCheckStartTime(new Date(0));
            customer.setCheckEndTime(new Date(0));
            customer.setFinishedTime(new Date());
            customer.setLostFlag(new Byte("1"));

            dbHelper.updateCustomer(customer);
            history.setCusEndId(customer.getId());
        }
        int timeToSleep = FastForward.generateTimeByFast(FastForward.TimeToGenerateACustomer);
        try {
            Thread.sleep(timeToSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (!stop) {
            //generate a new customer
            customer = new Customer();
            customer.setLostFlag(new Byte("0"));
            customer.setArrivedTime(new Date());
            randomNumOfProducts = (int) (1 + Math.random() * (numOfProducts));
            customer.setNumOfProducts(randomNumOfProducts);
            customer.setArrivedNanosec(System.nanoTime());
            dbHelper.insertACustomer(customer);


            //put the new customer into the pool where customer is waiting to be assigned to a certain checkout thread
            isSuccessful = customerList.offer(customer);
            if (!isSuccessful) {
                //failing to put customer into the pool means the customerList is full, so the customer leaves
                customer.setCheckoutId(0);
                customer.setCheckStartTime(new Date(0));
                customer.setCheckEndTime(new Date(0));
                customer.setFinishedTime(new Date());
                customer.setLostFlag(new Byte("1"));

                dbHelper.updateCustomer(customer);
                history.setCusEndId(customer.getId());
            }
            timeToSleep = FastForward.generateTimeByFast(FastForward.TimeToGenerateACustomer);
            try {
                Thread.sleep(timeToSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
