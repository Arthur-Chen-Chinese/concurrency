package com.my.concurrency.db;


import com.my.concurrency.dao.CheckoutMapper;
import com.my.concurrency.dao.CustomerMapper;
import com.my.concurrency.models.Checkout;
import com.my.concurrency.models.Customer;
import com.my.concurrency.models.History;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DbHelper {
    private SqlSession sqlSession;
    private History history;

    public DbHelper() {
    }

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

    public void insertACustomer(Customer customer) {
        sqlSession = getSqlSession();
        CustomerMapper cm = sqlSession.getMapper(CustomerMapper.class);
        cm.insertAndGetId(customer);
        sqlSession.commit();
    }

    public void insertACheckout(Checkout checkout) {
        sqlSession = getSqlSession();
        CheckoutMapper cm = sqlSession.getMapper(CheckoutMapper.class);
        cm.insertAndGetId(checkout);
        sqlSession.commit();
    }

    public void updateCustomer(Customer customer) {
        sqlSession = getSqlSession();
        CustomerMapper cm = sqlSession.getMapper(CustomerMapper.class);
        cm.updateByPrimaryKey(customer);
        if (history.getCusEndId() < customer.getId()) {
            history.setCusEndId(customer.getId());
        }
        sqlSession.commit();
    }

    public void updateCheckout(Checkout checkout) {
        sqlSession = getSqlSession();
        CheckoutMapper cm = sqlSession.getMapper(CheckoutMapper.class);
        cm.updateByPrimaryKey(checkout);
        sqlSession.commit();
    }


    @Override
    protected void finalize() throws Throwable {
        sqlSession.commit();
        sqlSession.close();
        super.finalize();
    }
}