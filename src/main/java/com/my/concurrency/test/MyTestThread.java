package com.my.concurrency.test;

import java.util.Date;

public class MyTestThread implements Runnable {
    private boolean stop = false;

    @Override
    public void run() {
        int num = 0;
        while (!stop) {
            System.out.println("---------------Loop " + num + "---------------");
            System.out.println(new Date());
            System.out.println(new Date());
            System.out.println(new Date());
            System.out.println(new Date());
            System.out.println(new Date());
            System.out.println("---------------Sleep starts---------------");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("---------------Sleep ends---------------");
            System.out.println(new Date());
            System.out.println(new Date());
            System.out.println(new Date());
            System.out.println(new Date());
            System.out.println(new Date());
            num++;
        }
    }

    public void stopThread() {
        this.stop = true;
    }
}
