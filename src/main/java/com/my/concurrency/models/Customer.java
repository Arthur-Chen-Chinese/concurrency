package com.my.concurrency.models;

import java.util.Date;

/**
 * The the Customer class records id, arrive time, finish time, the number of  product in trolley, check start time, check end time, checkout id, arrive nanosecond and check start nanosecond.
 */
public class Customer {
    /**
     * the customer id
     */
    private Integer id;
    /**
     * the customer arrive time
     */
    private Date arrivedTime;
    /**
     * the customer finish time
     */
    private Date finishedTime;
    /**
     * the number of products in the trolley
     */
    private Integer numOfProducts;
    /**
     * the flag shows whether the customer leaves the store
     */
    private Byte lostFlag;
    /**
     * the time when the checkout starts checking the customer
     */
    private Date checkStartTime;
    /**
     * the time when the check is completed
     */
    private Date checkEndTime;
    /**
     * the id of the checkout checking the customer
     */
    private Integer checkoutId;
    /**
     * A long to records System.nanoTime() when the customer arrives the store
     * Use System.nanoTime() to avoid the negative number result when calculate the wait time of a customer
     */
    private Long arrivedNanosec;
    /**
     * A long to records System.nanoTime() when the customer start to be checked
     * Use System.nanoTime() to avoid the negative number result when calculate the wait time of a customer
     */
    private Long checkStartNanosec;

    /**
     * Get id of the Customer
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set id of  the Customer
     *
     * @param id the customer id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get arrive time of he Customer
     * *t
     *
     * @return the arrive time
     */
    public Date getArrivedTime() {
        return arrivedTime;
    }

    /**
     * Set arrive time of  the Customer
     *
     * @param arrivedTime the arrive time
     */
    public void setArrivedTime(Date arrivedTime) {
        this.arrivedTime = arrivedTime;
    }

    /**
     * Get finished time of the Customer
     *
     * @return finished time
     */
    public Date getFinishedTime() {
        return finishedTime;
    }

    /**
     * Set finished time  of  the Customer
     *
     * @param finishedTime finished time
     */
    public void setFinishedTime(Date finishedTime) {
        this.finishedTime = finishedTime;
    }

    /**
     * Get the number of products in the trolley
     *
     * @return the number of products in the trolley
     */
    public Integer getNumOfProducts() {
        return numOfProducts;
    }

    /**
     * Set the number of products in the trolley
     *
     * @param numOfProducts the number of products in the trolley
     */
    public void setNumOfProducts(Integer numOfProducts) {
        this.numOfProducts = numOfProducts;
    }

    /**
     * Get the flag which shows whether the customer leaves the store
     *
     * @return lostFlag
     */
    public Byte getLostFlag() {
        return lostFlag;
    }

    /**
     * Set the flag which shows whether the customer leaves the store
     *
     * @param lostFlag the flag shows whether the customer leaves the store
     */
    public void setLostFlag(Byte lostFlag) {
        this.lostFlag = lostFlag;
    }

    /**
     * Get the time when the checkout starts checking the customer
     *
     * @return the time when the checkout starts checking the customer
     */
    public Date getCheckStartTime() {
        return checkStartTime;
    }

    /**
     * Set the time when the checkout starts checking the customer
     *
     * @param checkStartTime the time when the checkout starts checking the customer
     */
    public void setCheckStartTime(Date checkStartTime) {
        this.checkStartTime = checkStartTime;
    }

    /**
     * Get the time when the check is completed
     *
     * @return the time when the check is completed
     */
    public Date getCheckEndTime() {
        return checkEndTime;
    }

    /**
     * Set the time when the check is completed
     *
     * @param checkEndTime the time when the check is completed
     */
    public void setCheckEndTime(Date checkEndTime) {
        this.checkEndTime = checkEndTime;
    }

    /**
     * Get the id of the checkout checking the customer
     *
     * @return
     */
    public Integer getCheckoutId() {
        return checkoutId;
    }

    /**
     * Set the id of the checkout checking the customer
     *
     * @param checkoutId the id of the checkout checking the customer
     */
    public void setCheckoutId(Integer checkoutId) {
        this.checkoutId = checkoutId;
    }

    /**
     * Get a long which records System.nanoTime() when the customer arrives the store
     * Use System.nanoTime() to avoid the negative number result when calculate the wait time of a customer
     *
     * @return the System.nanoTime() when the customer arrives the store
     */
    public Long getArrivedNanosec() {
        return arrivedNanosec;
    }

    /**
     * Set the System.nanoTime() when the customer arrives the store
     * Use System.nanoTime() to avoid the negative number result when calculate the wait time of a customer
     * @param arrivedNanosec the System.nanoTime() when the customer arrives the store
     */
    public void setArrivedNanosec(Long arrivedNanosec) {
        this.arrivedNanosec = arrivedNanosec;
    }

    /**
     * Get a long which records System.nanoTime() when the customer start to be checked
     * Use System.nanoTime() to avoid the negative number result when calculate the wait time of a customer
     * @return a long which records System.nanoTime() when the customer start to be checked
     */
    public Long getCheckStartNanosec() {
        return checkStartNanosec;
    }

    /**
     * Set a long which records System.nanoTime() when the customer start to be checked
     * Use System.nanoTime() to avoid the negative number result when calculate the wait time of a customer
     * @param checkStartNanosec a long which records System.nanoTime() when the customer start to be checked
     */
    public void setCheckStartNanosec(Long checkStartNanosec) {
        this.checkStartNanosec = checkStartNanosec;
    }
}