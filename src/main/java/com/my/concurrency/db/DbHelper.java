package com.my.concurrency.db;


import com.my.concurrency.dao.CheckoutMapper;
import com.my.concurrency.dao.CustomerMapper;
import com.my.concurrency.dao.HistoryMapper;
import com.my.concurrency.models.Checkout;
import com.my.concurrency.models.Customer;
import com.my.concurrency.models.CustomerExample;
import com.my.concurrency.models.History;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * A Utility to help software interaction with database
 */
public class DbHelper {
    /**
     * Sqlsession
     */
    private SqlSession sqlSession;
    /**
     * History reference
     */
    private History history;

    /**
     * Constructor of DbHelper
     *
     * @param history a history to record all the information about the current simulation
     */
    public DbHelper(History history) {
        this.history = history;
    }

    /**
     * Get the sqlSession based on the Mybatis framework
     * @return a sqlSessioin
     */
    public SqlSession getSqlSession() {
        if (sqlSession == null) {
            InputStream config = null;
            try {
                config = Resources.getResourceAsStream("SqlMapConfig.xml");
            } catch (IOException e) {
                e.printStackTrace();
            }
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
            sqlSession = sqlSessionFactory.openSession();
        }
        return sqlSession;
    }

    /**
     * Insert a customer to database using mybatis
     * @param customer the customer to be inserted
     */
    public void insertACustomer(Customer customer) {
        sqlSession = getSqlSession();
        CustomerMapper cm = sqlSession.getMapper(CustomerMapper.class);
        cm.insertAndGetId(customer);
        sqlSession.commit();
    }

    /**
     * Insert a customer to database using mybatis
     * @param checkout the checkout to be inserted
     */
    public void insertACheckout(Checkout checkout) {
        sqlSession = getSqlSession();
        CheckoutMapper cm = sqlSession.getMapper(CheckoutMapper.class);
        cm.insertAndGetId(checkout);
        sqlSession.commit();
    }

    /**
     * Update a customer to database using mybatis
     * @param customer the checkout to be updated
     */
    public void updateCustomer(Customer customer) {
        sqlSession = getSqlSession();
        CustomerMapper cm = sqlSession.getMapper(CustomerMapper.class);
        cm.updateByPrimaryKey(customer);
        if (history.getCusEndId() < customer.getId()) {
            history.setCusEndId(customer.getId());
        }
        sqlSession.commit();
    }

    /**
     * Update a checkout to database using mybatis
     * @param checkout the checkout to be updated
     */
    public void updateCheckout(Checkout checkout) {
        sqlSession = getSqlSession();
        CheckoutMapper cm = sqlSession.getMapper(CheckoutMapper.class);
        cm.updateByPrimaryKey(checkout);
        sqlSession.commit();
    }

    /**
     * Insert a history to database using mybatis
     *
     * @param history the history to be inserted
     */
    public void insertAHistory(History history) {
        sqlSession = getSqlSession();
        HistoryMapper h = sqlSession.getMapper(HistoryMapper.class);
        h.insert(history);
        sqlSession.commit();
    }

    /**
     * Get a list of Customers recorded in the history from the database
     *
     * @param history the history recording all the customers of the current simulation
     * @return a list of customers
     */
    public List<Customer> getCustomersByHistory(History history) {
        sqlSession = getSqlSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        CustomerExample customerExample = new CustomerExample();
        customerExample.or().andIdBetween(history.getCusStartId(), history.getCusEndId());

        List<Customer> customers = customerMapper.selectByExample(customerExample);
        return customers;
    }

    /**
     * Release the sql session
     * @throws Throwable exception
     */
    @Override
    protected void finalize() throws Throwable {
        sqlSession.commit();
        sqlSession.close();
        super.finalize();
    }
}