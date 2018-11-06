/*
 * Created by JFormDesigner on Tue Nov 06 02:43:44 GMT 2018
 */

package com.my.concurrency.test;

import javax.swing.*;
import java.awt.*;

/**
 * @author Brainrain
 */
public class TestFom extends JFrame {
    public static TestFom tf;

    public void setIcon() {
        if (count % 2 == 0) {
            label1.setIcon(icon1);
        } else {
            label1.setIcon(icon2);
        }
        System.out.println(count);
        count++;
    }

    public TestFom() {
        tf = this;
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
//        ImageIcon imageIcon = new ImageIcon("src\\main\\resources\\pics\\checkout_unavailable.png");
//        label1.setIcon(imageIcon);
//
//        label1.setIcon(new ImageIcon(MainForm.picPathCheckoutAvaiable));
//        new Thread() {
//            @Override
//            public void run() {
//                int count = 0;
//                while (true) {
//                    if (count % 2 == 0) {
//                        tf.setIcon();
//                    } else {
//                        tf.setIcon();
//                    }
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }.start();
        try {

            panel1.remove(0);
            panel1.repaint();
            Thread.sleep(1000);
            panel1.remove(1);
            panel1.repaint();
            Thread.sleep(1000);
            panel1.remove(2);
            panel1.repaint();
            Thread.sleep(1000);
            panel1.remove(3);
            panel1.repaint();
            Thread.sleep(1000);
            panel1.remove(4);
            panel1.repaint();

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    int count = 0;
    private ImageIcon icon1 = new ImageIcon("src\\main\\resources\\pics\\checkout_unavailable.png");
    private ImageIcon icon2 = new ImageIcon("src\\main\\resources\\pics\\checkout_available.png");


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new GridLayout(1, 5));

            //---- label1 ----
            label1.setText("1");
            panel1.add(label1);

            //---- label2 ----
            label2.setText("2");
            panel1.add(label2);

            //---- label3 ----
            label3.setText("3");
            panel1.add(label3);

            //---- label4 ----
            label4.setText("4");
            panel1.add(label4);

            //---- label5 ----
            label5.setText("5");
            panel1.add(label5);
        }
        contentPane.add(panel1);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
