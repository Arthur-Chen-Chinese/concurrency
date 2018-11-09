package com.my.concurrency.db;


import com.my.concurrency.dao.CustomerMapper;
import com.my.concurrency.models.Customer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DbHelper {
    private SqlSession sqlSession;

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
//        sqlSession.commit();
    }

    @Override
    protected void finalize() throws Throwable {
        sqlSession.commit();
        sqlSession.close();
        super.finalize();
    }
}