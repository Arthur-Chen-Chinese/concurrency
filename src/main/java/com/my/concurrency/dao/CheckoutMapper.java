package com.my.concurrency.dao;

import com.my.concurrency.models.Checkout;
import com.my.concurrency.models.CheckoutExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper interface for checkout, automatically generated by Mybatis-generator
 */
public interface CheckoutMapper {
    /**
     * Use Mybatis Example class to count the number of checkouts which is meet the conditions of example
     *
     * @param example CheckoutExample with selective conditions
     * @return the number of checkouts meet the conditions
     */
    long countByExample(CheckoutExample example);

    /**
     * Use Mybatis Example class to delete checkouts which is meet the conditions of example
     *
     * @param example CheckoutExample with selective conditions
     * @return the number of checkouts deleted
     */
    int deleteByExample(CheckoutExample example);

    /**
     * Delete the checkout by primary key
     *
     * @param id the primary key of checkout
     * @return the number of checkouts deleted
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * Insert a checkout
     *
     * @param record one checkout instance
     * @return the number of checkouts insert
     */
    int insert(Checkout record);

    /**
     * Insert a checkout and get the primary key (id) thereof
     *
     * @param record a checkout instance
     * @return the primary key (id) of the inserted checkout
     */
    int insertAndGetId(Checkout record);

    /**
     * insert checkout selectively
     *
     * @param record a checkout instance
     * @return the number of checkout insert
     */
    int insertSelective(Checkout record);

    /**
     * Use Mybatis Example class to get checkouts which is meet the conditions of example
     *
     * @param example CheckoutExample with selective conditions
     * @return a list of checkouts meet the conditions
     */
    List<Checkout> selectByExample(CheckoutExample example);

    /**
     * Get Checkout by id
     *
     * @param id the id of checkout
     * @return a checkout instance
     */
    Checkout selectByPrimaryKey(Integer id);

    /**
     * update checkouts selective using example
     *
     * @param record  a checkout instance
     * @param example a checkout example with where conditions
     * @return the number of affected checkout
     */
    int updateByExampleSelective(@Param("record") Checkout record, @Param("example") CheckoutExample example);

    /**
     * update checkouts by checkoutExample
     *
     * @param record  a checkout instance
     * @param example a checkout example with where conditions
     * @return the number of affected checkout
     */
    int updateByExample(@Param("record") Checkout record, @Param("example") CheckoutExample example);

    /**
     * update checkout selectively by primary key
     *
     * @param record the checkout instance to update
     * @return the number of affected checkout
     */
    int updateByPrimaryKeySelective(Checkout record);

    /**
     * update checkout by primary key
     *
     * @param record the checkout instace to update
     * @return the number of affected checkout
     */
    int updateByPrimaryKey(Checkout record);
}