package com.my.concurrency.test;

import com.my.concurrency.dao.CheckoutMapper;
import com.my.concurrency.models.Checkout;
import com.my.concurrency.models.CheckoutExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class TestAdvancedQuery {
    public static void main(String[] args) throws IOException {

        InputStream config = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        CheckoutMapper cm = sqlSession.getMapper(CheckoutMapper.class);
        Checkout checkout = new Checkout();
        checkout.setName("Thread-0");
        checkout.setNumOfCheckedCustomers(45);
        checkout.setNumOfCheckedItems(56);
        checkout.setStartedTime(new Date());
        Date finishedTime = new Date();
        finishedTime.setYear(finishedTime.getYear() + 1);
        checkout.setFinishedTime(finishedTime);
        int num = cm.insert(checkout);
        CheckoutExample checkoutExample = new CheckoutExample();
        checkoutExample.or().andIdEqualTo(5);
        long count = cm.countByExample(checkoutExample);
        System.out.println(count);

        sqlSession.commit();
        sqlSession.close();
    }
}
