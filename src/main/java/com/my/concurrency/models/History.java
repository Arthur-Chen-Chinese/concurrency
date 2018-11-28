package com.my.concurrency.models;

/**
 * A class to record all the information about simulation, including checkouts, customers, configuration,
 * so that statistic can be done using this class.
 */
public class History {
    /**
     * History id
     */
    private Integer id;

    /**
     * The first customer id
     */
    private Integer cusStartId;

    /**
     * The last customer id
     */
    private Integer cusEndId = 0;

    /**
     * The first checked checkout id
     */
    private Integer checkoutStartId;

    /**
     * The last checked checkout id
     */
    private Integer checkoutEndId;

    /**
     * The number of checkouts
     */
    private Integer numOfCheckouts;

    /**
     * The number of products in the trolley
     */
    private Integer numOfProductsInTrolley;

    /**
     * The maximum time of checking a item, whose unit is millisecond
     */
    private Integer timeForEachProduct;

    /**
     * The number of 5OrLess Checkouts
     */
    private Integer numOf5OrLessCheckouts;

    /**
     * The rate of generating a customer
     */
    private Integer customerGenerationRate;

    /**
     * Get History id
     *
     * @return history id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set History id
     * @param id id to be set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get the first checked customer id
     * @return the first customer id
     */
    public Integer getCusStartId() {
        return cusStartId;
    }

    /**
     * Set the checked first customer id
     * @param cusStartId id to be set
     */
    public void setCusStartId(Integer cusStartId) {
        this.cusStartId = cusStartId;
    }

    /**
     * Get the last checked customer id
     * @return the last checked customer id
     */
    public Integer getCusEndId() {
        return cusEndId;
    }

    /**
     * Set the last checked customer id
     * @param cusEndId id to be set
     */
    public void setCusEndId(Integer cusEndId) {
        this.cusEndId = cusEndId;
    }

    /**
     * Get the first checkout id
     * @return the first checkout id
     */
    public Integer getCheckoutStartId() {
        return checkoutStartId;
    }

    /**
     * Set the first checkout id
     * @param checkoutStartId the first checkout id
     */
    public void setCheckoutStartId(Integer checkoutStartId) {
        this.checkoutStartId = checkoutStartId;
    }

    /**
     * Get the last checkout id
     * @return the last checkout id
     */
    public Integer getCheckoutEndId() {
        return checkoutEndId;
    }

    /**
     * Set the last checkout id
     * @param checkoutEndId id to be set
     */
    public void setCheckoutEndId(Integer checkoutEndId) {
        this.checkoutEndId = checkoutEndId;
    }

    /**
     * Get the number of checkouts
     * @return the number of checkouts
     */
    public Integer getNumOfCheckouts() {
        return numOfCheckouts;
    }

    /**
     * Set the number of checkouts
     * @param numOfCheckouts the number of checkouts
     */
    public void setNumOfCheckouts(Integer numOfCheckouts) {
        this.numOfCheckouts = numOfCheckouts;
    }

    /**
     * Get the number of products in the trolley
     * @return the number of products in the trolley
     */
    public Integer getNumOfProductsInTrolley() {
        return numOfProductsInTrolley;
    }

    /**
     * Set the number of products in the trolley
     * @param numOfProductsInTrolley the number of products in the trolley
     */
    public void setNumOfProductsInTrolley(Integer numOfProductsInTrolley) {
        this.numOfProductsInTrolley = numOfProductsInTrolley;
    }

    /**
     * Get the maximum time of checking a item
     * @return the maximum time of checking a item
     */
    public Integer getTimeForEachProduct() {
        return timeForEachProduct;
    }

    /**
     * Set the maximum time of checking a item
     * @param timeForEachProduct the maximum time of checking a item
     */
    public void setTimeForEachProduct(Integer timeForEachProduct) {
        this.timeForEachProduct = timeForEachProduct;
    }

    /**
     * Get the number of 5OrLess Checkouts
     * @return the number of 5OrLess Checkouts
     */
    public Integer getNumOf5OrLessCheckouts() {
        return numOf5OrLessCheckouts;
    }

    /**
     * Set  the number of 5OrLess Checkouts
     * @param numOf5OrLessCheckouts  the number of 5OrLess Checkouts
     */
    public void setNumOf5OrLessCheckouts(Integer numOf5OrLessCheckouts) {
        this.numOf5OrLessCheckouts = numOf5OrLessCheckouts;
    }

    /**
     * Get the rate of generating a customer
     *
     * @return the rate of generating a customer
     */
    public Integer getCustomerGenerationRate() {
        return customerGenerationRate;
    }

    /**
     * Set the rate of generating a customer
     *
     * @param customerGenerationRate the rate of generating a customer
     */
    public void setCustomerGenerationRate(Integer customerGenerationRate) {
        this.customerGenerationRate = customerGenerationRate;
    }
}