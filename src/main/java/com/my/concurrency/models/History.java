package com.my.concurrency.models;

public class History {
    private Integer id;

    private Integer cusStartId;

    private Integer cusEndId = 0;

    private Integer checkoutStartId;

    private Integer checkoutEndId;

    private Integer numOfCheckouts;

    private Integer numOfProductsInTrolley;

    private Integer timeForEachProduct;

    private Integer numOf5OrLessCheckouts;

    private Integer specificRateRange;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCusStartId() {
        return cusStartId;
    }

    public void setCusStartId(Integer cusStartId) {
        this.cusStartId = cusStartId;
    }

    public Integer getCusEndId() {
        return cusEndId;
    }

    public void setCusEndId(Integer cusEndId) {
        this.cusEndId = cusEndId;
    }

    public Integer getCheckoutStartId() {
        return checkoutStartId;
    }

    public void setCheckoutStartId(Integer checkoutStartId) {
        this.checkoutStartId = checkoutStartId;
    }

    public Integer getCheckoutEndId() {
        return checkoutEndId;
    }

    public void setCheckoutEndId(Integer checkoutEndId) {
        this.checkoutEndId = checkoutEndId;
    }

    public Integer getNumOfCheckouts() {
        return numOfCheckouts;
    }

    public void setNumOfCheckouts(Integer numOfCheckouts) {
        this.numOfCheckouts = numOfCheckouts;
    }

    public Integer getNumOfProductsInTrolley() {
        return numOfProductsInTrolley;
    }

    public void setNumOfProductsInTrolley(Integer numOfProductsInTrolley) {
        this.numOfProductsInTrolley = numOfProductsInTrolley;
    }

    public Integer getTimeForEachProduct() {
        return timeForEachProduct;
    }

    public void setTimeForEachProduct(Integer timeForEachProduct) {
        this.timeForEachProduct = timeForEachProduct;
    }

    public Integer getNumOf5OrLessCheckouts() {
        return numOf5OrLessCheckouts;
    }

    public void setNumOf5OrLessCheckouts(Integer numOf5OrLessCheckouts) {
        this.numOf5OrLessCheckouts = numOf5OrLessCheckouts;
    }

    public Integer getSpecificRateRange() {
        return specificRateRange;
    }

    public void setSpecificRateRange(Integer specificRateRange) {
        this.specificRateRange = specificRateRange;
    }
}