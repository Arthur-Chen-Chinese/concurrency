package com.my.concurrency.models;

import java.util.Random;

/**
 * The Class for speed up the simulation.
 */
public class FastForward {
    /**
     * The minimum time of checking a items, the unit is millisecond
     */
    private final static int timeToCheckoutFrom = 500;
    /**
     * The maximum time of checking a items, the unit is millisecond
     */
    private static int timeToCheckoutTo = 1000;
    /**
     * The interval between generating two customer, the unit is millisecond
     */
    private static int timeToGenerateACustomer = 12000;

    /**
     * The times of fast-forward. The unit is single.
     */
    private static int time = 1;

    /**
     * For parameter generationType passed to static method generateTimeByFast().
     * Tell generateTimeByFast() to generate a fast-forwarded time of checkout
     */
    public static final int TimeToCheckout = 0;
    /**
     * For parameter generationType passed to static method generateTimeByFast().
     * Tell generateTimeByFast() to generate a fast-forwarded time of generating customer
     */
    public static final int TimeToGenerateACustomer = 1;


    /**
     * Set the maximum time of checking a item
     *
     * @param timeToCheckoutTo the maximum time of checking a item whose unit is millisecond.
     */
    public static void setTimeToCheckoutTo(int timeToCheckoutTo) {
        FastForward.timeToCheckoutTo = timeToCheckoutTo;
    }

    /**
     * Set the time of generating a customer
     * @param timeToGenerateACustomer the time of generating a customer whose unit is millisecond.
     */
    public static void setTimeToGenerateACustomer(int timeToGenerateACustomer) {
        FastForward.timeToGenerateACustomer = timeToGenerateACustomer;
    }

    /**
     * Set the times of fast-forward
     * @param time the times of fast-forward
     */
    public static void setTime(int time) {
        FastForward.time = time;
    }


    /**
     * Generate a time according to generation type
     *
     * @param generationType the type of generated time, which is defined in the class as constant variables
     * @return the generated time
     */
    public static int generateTimeByFast(int generationType) {
        int time = 0;
        Random random = new Random(System.currentTimeMillis());
        switch (generationType) {
            case TimeToCheckout:
                time = (int) (timeToCheckoutFrom + Math.random() * (timeToCheckoutTo - timeToCheckoutFrom + 1));
                break;
            case TimeToGenerateACustomer:
                time = timeToGenerateACustomer;
                break;
        }
        //time forward
        time /= FastForward.time;
        return time;
    }
}
