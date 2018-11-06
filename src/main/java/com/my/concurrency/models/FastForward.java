package com.my.concurrency.models;

import java.util.Random;

public class FastForward {
    /**
     * The unit is millisecond
     */
    private final int timeToCheckoutFrom = 500;
    private int timeToCheckoutTo = 1000;
    private int timeToGenerateACustomer = 12000;

    /**
     * The unit is single.
     */
    private int fast = 1;

    public static int TimeToCheckout = 0;
    public static int TimeToGenerateACustomer = 1;

    public int getTimeToCheckoutFrom() {
        return timeToCheckoutFrom;
    }

    public int getTimeToCheckoutTo() {
        return timeToCheckoutTo;
    }

    public void setTimeToCheckoutTo(int timeToCheckoutTo) {
        this.timeToCheckoutTo = timeToCheckoutTo;
    }

    public int getTimeToGenerateACustomer() {
        return timeToGenerateACustomer;
    }

    public void setTimeToGenerateACustomer(int timeToGenerateACustomer) {
        this.timeToGenerateACustomer = timeToGenerateACustomer;
    }

    public int getFast() {
        return fast;
    }

    public void setFast(int fast) {
        this.fast = fast;
    }

    public int generateTimeByFast(int generateType) {
        int time = 0;
        Random random = new Random(System.currentTimeMillis());
        switch (generateType) {
            case 0:
                time = (int) (timeToCheckoutFrom + Math.random() * (timeToCheckoutTo - timeToCheckoutFrom + 1));
                break;
            case 1:
                time = timeToGenerateACustomer;
                break;
        }
        //fast forward
        time /= fast;
        return time;
    }
}
