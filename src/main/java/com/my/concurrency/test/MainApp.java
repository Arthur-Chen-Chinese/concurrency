//package com.my.concurrency.test;
//
//import com.my.concurrency.models.Customer;
//import com.my.concurrency.threads.AssigningThread;
//import com.my.concurrency.threads.CheckoutThread;
//import com.my.concurrency.threads.CustomerGeneratorThread;
//
//import java.util.ArrayList;
//import java.util.Queue;
//import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.BlockingQueue;
//
//public class MainApp {
//    private int numOfCheckout;
//    private ArrayList<Queue<Customer>> customerWaitingLists;
//    private ArrayList<Customer> customerCheckedList;
//    private BlockingQueue<Customer> customerList;
//
//    public MainApp(int numOfCheckout, ArrayList<Queue<Customer>> customerWaitingLists, ArrayList<Customer> customerCheckedList, BlockingQueue<Customer> customerList) {
//        this.numOfCheckout = numOfCheckout;
//        this.customerWaitingLists = customerWaitingLists;
//        this.customerCheckedList = customerCheckedList;
//        this.customerList = customerList;
//        test();
//    }
//
//    public void test() {
//        CustomerGeneratorThread cgt = new CustomerGeneratorThread(customerList);
//        new Thread(cgt).start();
//
//        AssigningThread at = new AssigningThread(customerWaitingLists, customerList, numOfCheckout);
//        new Thread(at).start();
//
//        for (int i = 0; i < numOfCheckout; i++) {
//            CheckoutThread ct = new CheckoutThread(numOfCheckout, customerWaitingLists, customerCheckedList);
//            new Thread(ct).start();
//        }
//
//        //sleep for 20s ,then, get wait time of each customer
//        try {
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        synchronized (customerCheckedList) {
//            for (int i = 0; i < customerCheckedList.size(); i++) {
//                Customer c = customerCheckedList.get(i);
//                long waitTime = c.getCheckStartTime().getTime() - c.getArrivedTime().getTime();
//                System.out.println((waitTime / 1000) + " sec");
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        MainApp mainApp = new MainApp(5, new ArrayList<Queue<Customer>>(), new ArrayList<Customer>(), new ArrayBlockingQueue());
//    }
//
//}