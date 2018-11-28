package com.my.concurrency.threads;

import com.my.concurrency.db.DbHelper;
import com.my.concurrency.forms.MainForm;
import com.my.concurrency.models.Customer;
import com.my.concurrency.models.FastForward;
import com.my.concurrency.models.History;

import java.util.Date;
import java.util.concurrent.BlockingQueue;

public class CustomerGeneratorThread implements Runnable {
    /**
     * The point references to mainForm, which is used to update GUI
     */
    private MainForm mf;
    /**
     * The list of customers generated
     */
    private BlockingQueue<Customer> customerList;
    /**
     * The maximum number of products in the trolley
     */
    private int numOfProducts;
    /**
     * The history reference
     */
    private History history;
    /**
     * The flag to stop the thread
     */
    private boolean stop = false;

    /**
     * @param mf            the point references to mainForm, which is used to update GUI
     * @param customerList  The list of customers generated
     * @param numOfProducts The maximum number of products in the trolley
     * @param history       The history reference
     */
    public CustomerGeneratorThread(MainForm mf, BlockingQueue<Customer> customerList, int numOfProducts, History history) {
        this.mf = mf;
        this.customerList = customerList;
        this.numOfProducts = numOfProducts;
        this.history = history;
    }

    /**
     * The method is to tell the while loop in run() to stop
     */
    public void stopThread() {
        this.stop = true;
    }

    /**
     * The run() method defines the functionality of CustomerGenerator Thread
     * The method simulates that a customer arrives at the store after a interval generated by FastForward.generateTimeByFast()
     * The customer generated will be stored in the customerLists waiting for the assigning thread to assign the customer to a certain checkout
     * If the customerList(capacity is 100) is full, the customer leaves the store.
     */
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
            System.out.println("customer " + customer.getId() + " leaves the store");
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
                System.out.println("customer " + customer.getId() + " leaves the store");
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
