package com.my.concurrency.models;

import java.util.Date;

public class Checkout {
    private Integer id;

    private String name;

    private Date startedTime;

    private Date finishedTime;

    private Integer numOfCheckedCustomers;

    private Integer numOfCheckedItems;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getStartedTime() {
        return startedTime;
    }

    public void setStartedTime(Date startedTime) {
        this.startedTime = startedTime;
    }

    public Date getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(Date finishedTime) {
        this.finishedTime = finishedTime;
    }

    public Integer getNumOfCheckedCustomers() {
        return numOfCheckedCustomers;
    }

    public void setNumOfCheckedCustomers(Integer numOfCheckedCustomers) {
        this.numOfCheckedCustomers = numOfCheckedCustomers;
    }

    public Integer getNumOfCheckedItems() {
        return numOfCheckedItems;
    }

    public void setNumOfCheckedItems(Integer numOfCheckedItems) {
        this.numOfCheckedItems = numOfCheckedItems;
    }
}