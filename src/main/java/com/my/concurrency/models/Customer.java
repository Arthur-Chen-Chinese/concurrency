package com.my.concurrency.models;

import java.util.Date;

public class Customer {
    private Integer id;

    private Date arrivedTime;

    private Date finishedTime;

    private Integer numOfProducts;

    private Byte lostFlag;

    private Date checkStartTime;

    private Date checkEndTime;

    private Integer checkoutId;

    private Long arrivedNanosec;

    private Long checkStartNanosec;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getArrivedTime() {
        return arrivedTime;
    }

    public void setArrivedTime(Date arrivedTime) {
        this.arrivedTime = arrivedTime;
    }

    public Date getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(Date finishedTime) {
        this.finishedTime = finishedTime;
    }

    public Integer getNumOfProducts() {
        return numOfProducts;
    }

    public void setNumOfProducts(Integer numOfProducts) {
        this.numOfProducts = numOfProducts;
    }

    public Byte getLostFlag() {
        return lostFlag;
    }

    public void setLostFlag(Byte lostFlag) {
        this.lostFlag = lostFlag;
    }

    public Date getCheckStartTime() {
        return checkStartTime;
    }

    public void setCheckStartTime(Date checkStartTime) {
        this.checkStartTime = checkStartTime;
    }

    public Date getCheckEndTime() {
        return checkEndTime;
    }

    public void setCheckEndTime(Date checkEndTime) {
        this.checkEndTime = checkEndTime;
    }

    public Integer getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutId(Integer checkoutId) {
        this.checkoutId = checkoutId;
    }

    public Long getArrivedNanosec() {
        return arrivedNanosec;
    }

    public void setArrivedNanosec(Long arrivedNanosec) {
        this.arrivedNanosec = arrivedNanosec;
    }

    public Long getCheckStartNanosec() {
        return checkStartNanosec;
    }

    public void setCheckStartNanosec(Long checkStartNanosec) {
        this.checkStartNanosec = checkStartNanosec;
    }
}