package com.my.concurrency.models;

import java.util.Random;

public class FastForward {
    /**
     * The unit is millisecond
     */
    private final static int timeToCheckoutFrom = 500;
    private static int timeToCheckoutTo = 1000;
    private static int timeToGenerateACustomer = 12000;

    /**
     * The unit is single.
     */
    private static int time = 1;

    public static int TimeToCheckout = 0;
    public static int TimeToGenerateACustomer = 1;

    public static int getTimeToCheckoutFrom() {
        return timeToCheckoutFrom;
    }

    public static int getTimeToCheckoutTo() {
        return timeToCheckoutTo;
    }

    public static void setTimeToCheckoutTo(int timeToCheckoutTo) {
        FastForward.timeToCheckoutTo = timeToCheckoutTo;
    }

    public static int getTimeToGenerateACustomer() {
        return timeToGenerateACustomer;
    }

    public static void setTimeToGenerateACustomer(int timeToGenerateACustomer) {
        FastForward.timeToGenerateACustomer = timeToGenerateACustomer;
    }

    public static int getTime() {
        return time;
    }

    public static void setTime(int time) {
        FastForward.time = time;
    }



    public static int generateTimeByFast(int generateType) {
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
        //time forward
        time /= FastForward.time;
        return time;
    }
}
