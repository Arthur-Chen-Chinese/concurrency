package com.my.concurrency.models;

import java.util.Date;

public class Checkout {
    private Integer id;

    private String name;

    private Date startedTime;

    private Date finishedTime;

    private Integer numOfCheckedCustomers;

    private Integer numOfCheckedItems;

    /**
     * Get id of the checkout
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set id of the checkout
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get name of the checkout
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of the checkout
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * Get start time of the checkout
     *
     * @return startedTime the time when the checkout start running
     */
    public Date getStartedTime() {
        return startedTime;
    }

    /**
     * Set startedTime of the checkout
     *
     * @param startedTime the time when the checkout starts running
     */
    public void setStartedTime(Date startedTime) {
        this.startedTime = startedTime;
    }

    /**
     * Get finish time of the checkout
     *
     * @return finishedTime the time when the checkout stops
     */
    public Date getFinishedTime() {
        return finishedTime;
    }

    /**
     * Set finish time  of the checkout
     *
     * @param finishedTime the time when the checkout stops
     */
    public void setFinishedTime(Date finishedTime) {
        this.finishedTime = finishedTime;
    }

    /**
     * Get the number of customers checkouted by the checkout
     *
     * @return the number of customers checkouted by the checkout
     */
    public Integer getNumOfCheckedCustomers() {
        return numOfCheckedCustomers;
    }

    /**
     * Set the number of customers checkouted by the checkout
     *
     * @param numOfCheckedCustomers the number of customers checkouted by the checkout
     */
    public void setNumOfCheckedCustomers(Integer numOfCheckedCustomers) {
        this.numOfCheckedCustomers = numOfCheckedCustomers;
    }

    /**
     * Get the number of items checkouted by the checkout
     *
     * @return the number of items checkouted by the checkout
     */
    public Integer getNumOfCheckedItems() {
        return numOfCheckedItems;
    }

    /**
     * Set the number of items checkouted by the checkout
     *
     * @param numOfCheckedItems the number of items checkouted by the checkout
     */
    public void setNumOfCheckedItems(Integer numOfCheckedItems) {
        this.numOfCheckedItems = numOfCheckedItems;
    }
}