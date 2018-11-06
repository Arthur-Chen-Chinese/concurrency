package com.my.concurrency.models;

import com.my.concurrency.dao.CustomerMapper;
import com.my.concurrency.forms.MainForm;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Queue;

public class CheckoutThread implements Runnable {
    private MainForm mf;
    private int numOfCheckout;
    private ArrayList<JPanel> waitingLineList;
    private Queue[] customerWaitingLists;

    public CheckoutThread(MainForm mf, int numOfCheckout, ArrayList<JPanel> waitingLineList, Queue[] customerWaitingLists) {
        this.mf = mf;
        this.numOfCheckout = numOfCheckout;
        this.waitingLineList = waitingLineList;
        this.customerWaitingLists = customerWaitingLists;
    }

    @Override
    public void run() {
        while (true) {
            Customer customerPolled;
            synchronized (customerWaitingLists) {
                customerPolled = (Customer) customerWaitingLists[numOfCheckout - 1].poll();
            }
            if (customerPolled == null) {
                mf.updateCheckout(numOfCheckout, MainForm.CheckoutAvaiableStatus);
            } else {
                customerPolled.setCheckStartTime(new Date());
                mf.updateWaitingLine(numOfCheckout, null);
                mf.updateCheckout(numOfCheckout, MainForm.CheckoutBusyStatus);
                int totalTime = 0;
                Integer numOfProducts = customerPolled.getNumOfProducts();
                for (int i = 0; i < numOfProducts; i++) {
                    totalTime += FastForward.generateTimeByFast(FastForward.TimeToCheckout);
                }
                try {
                    Thread.sleep(totalTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                customerPolled.setCheckEndTime(new Date());
                customerPolled.setFinishedTime(new Date());

                InputStream config = null;
                try {
                    config = Resources.getResourceAsStream("SqlMapConfig.xml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
                SqlSession sqlSession = sqlSessionFactory.openSession();

                CustomerMapper cm = sqlSession.getMapper(CustomerMapper.class);
                cm.insert(customerPolled);

                sqlSession.commit();
                sqlSession.close();
            }
        }

    }
}
