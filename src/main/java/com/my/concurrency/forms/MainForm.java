/*
 * Created by JFormDesigner on Thu Nov 01 17:17:35 GMT 2018
 */

package com.my.concurrency.forms;

import com.my.concurrency.models.Customer;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author Brainrain
 */
public class MainForm extends JFrame {

    private ArrayList<JLabel> checkoutList = new ArrayList<>();
    private ArrayList<JPanel> waitingLineList = new ArrayList<>();
    private Customer customerLists[][];
    private Customer customerWaitingLists[][];
    public final static String picPathCheckoutAvaiable = "src\\main\\resources\\pics\\checkout_available.png";
    public final static String picPathCheckoutUnavaiable = "src\\main\\resources\\pics\\checkout_unavailable.png";
    public final static String picPathCheckoutBusy = "src\\main\\resources\\pics\\checkout_busy.png";
    public final static String picPathCustomer = "src\\main\\resources\\pics\\customer.png";

    public MainForm() {
        initComponents();
        initCustomompnents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initCustomompnents() {

        for (int i = 0; i < 8; i++) {
            JLabel lbCheckout = new JLabel(new ImageIcon(picPathCheckoutUnavaiable));
            checkoutList.add(lbCheckout);
            pnlCheckoutsPlaceHolder.add(lbCheckout);
        }

        //init the no. of checkout comboBox
        for (int i = 1; i <= 8; i++) {
            cbNoOfCheckouts.addItem(i);
        }

        //init the no. of checkout comboBox
        String s = "0.5 - ";
        for (int i = 1; i <= 6; i++) {
            String tiemRange = s + i + "s";
            cbTimeToCheckAProduct.addItem(tiemRange);
        }

        //init the no. of 5 or less comboBox
        for (int i = 1; i < 8; i++) {
            cbNoOf5OrLess.addItem(i);
        }

        //init the customer arrival rate comboBox
        String postfixOfRate = " customers per hour";
        for (int i = 0; i < 300; i++) {
            cbCustomerArrivalRate.addItem(i + 1 + postfixOfRate);
        }

        String postfixOfFastForward = " X";
        for (int i = 0; i < 5; i++) {
            cbFastForward.addItem(((2 << i)) + postfixOfFastForward);
        }


    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        label18 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();
        label15 = new JLabel();
        label16 = new JLabel();
        label17 = new JLabel();
        pnlCheckoutsPlaceHolder = new JPanel();
        label8 = new JLabel();
        panel9 = new JPanel();
        panel11 = new JPanel();
        label9 = new JLabel();
        panel12 = new JPanel();
        panel13 = new JPanel();
        panel14 = new JPanel();
        panel15 = new JPanel();
        panel16 = new JPanel();
        panel17 = new JPanel();
        panel10 = new JPanel();
        panel18 = new JPanel();
        panel6 = new JPanel();
        btnStartSimulating = new JButton();
        btnEndandShowStatistics = new JButton();
        panel3 = new JPanel();
        label1 = new JLabel();
        cbNoOfCheckouts = new JComboBox();
        label2 = new JLabel();
        cbNoOfProducts = new JTextField();
        label3 = new JLabel();
        cbTimeToCheckAProduct = new JComboBox();
        label4 = new JLabel();
        cbNoOf5OrLess = new JComboBox();
        label5 = new JLabel();
        cbCustomerArrivalRate = new JComboBox();
        label7 = new JLabel();
        cbFastForward = new JComboBox();
        panel2 = new JPanel();
        panel8 = new JPanel();
        scrollPane1 = new JScrollPane();
        table2 = new JTable();
        scrollPane2 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setTitle("Supermaket Simulator");
        setResizable(false);
        Container contentPane = getContentPane();

        //======== tabbedPane1 ========
        {

            //======== panel1 ========
            {

                //======== panel4 ========
                {
                    panel4.setBorder(LineBorder.createBlackLineBorder());

                    //======== panel5 ========
                    {
                        panel5.setBorder(LineBorder.createBlackLineBorder());
                        panel5.setLayout(new GridLayout(9, 1));

                        //---- label18 ----
                        label18.setText("#");
                        label18.setHorizontalAlignment(SwingConstants.CENTER);
                        label18.setBorder(new MatteBorder(0, 0, 2, 0, Color.black));
                        panel5.add(label18);

                        //---- label10 ----
                        label10.setText("1");
                        label10.setHorizontalAlignment(SwingConstants.CENTER);
                        panel5.add(label10);

                        //---- label11 ----
                        label11.setText("2");
                        label11.setHorizontalAlignment(SwingConstants.CENTER);
                        panel5.add(label11);

                        //---- label12 ----
                        label12.setText("3");
                        label12.setHorizontalAlignment(SwingConstants.CENTER);
                        panel5.add(label12);

                        //---- label13 ----
                        label13.setText("4");
                        label13.setHorizontalAlignment(SwingConstants.CENTER);
                        panel5.add(label13);

                        //---- label14 ----
                        label14.setText("5");
                        label14.setHorizontalAlignment(SwingConstants.CENTER);
                        panel5.add(label14);

                        //---- label15 ----
                        label15.setText("6");
                        label15.setHorizontalAlignment(SwingConstants.CENTER);
                        panel5.add(label15);

                        //---- label16 ----
                        label16.setText("7");
                        label16.setHorizontalAlignment(SwingConstants.CENTER);
                        panel5.add(label16);

                        //---- label17 ----
                        label17.setText("8");
                        label17.setHorizontalAlignment(SwingConstants.CENTER);
                        panel5.add(label17);
                    }

                    //======== pnlCheckoutsPlaceHolder ========
                    {
                        pnlCheckoutsPlaceHolder.setBorder(LineBorder.createBlackLineBorder());
                        pnlCheckoutsPlaceHolder.setLayout(new GridLayout(9, 1));

                        //---- label8 ----
                        label8.setText("Checkout");
                        label8.setFont(new Font("Segoe UI", label8.getFont().getStyle(), 11));
                        label8.setBorder(new MatteBorder(0, 0, 2, 0, Color.black));
                        pnlCheckoutsPlaceHolder.add(label8);
                    }

                    //======== panel9 ========
                    {
                        panel9.setBorder(LineBorder.createBlackLineBorder());
                        panel9.setLayout(new GridLayout(9, 1));

                        //======== panel11 ========
                        {
                            panel11.setLayout(new GridLayout(1, 1));

                            //---- label9 ----
                            label9.setText("Waiting Line");
                            label9.setHorizontalAlignment(SwingConstants.CENTER);
                            label9.setBorder(new MatteBorder(0, 0, 2, 0, Color.black));
                            panel11.add(label9);
                        }
                        panel9.add(panel11);

                        //======== panel12 ========
                        {
                            panel12.setLayout(new GridLayout(1, 6));
                        }
                        panel9.add(panel12);

                        //======== panel13 ========
                        {
                            panel13.setLayout(new GridLayout(1, 6));
                        }
                        panel9.add(panel13);

                        //======== panel14 ========
                        {
                            panel14.setLayout(new GridLayout(1, 6));
                        }
                        panel9.add(panel14);

                        //======== panel15 ========
                        {
                            panel15.setLayout(new GridLayout(1, 6));
                        }
                        panel9.add(panel15);

                        //======== panel16 ========
                        {
                            panel16.setLayout(new GridLayout(1, 6));
                        }
                        panel9.add(panel16);

                        //======== panel17 ========
                        {
                            panel17.setLayout(new GridLayout(1, 6));
                        }
                        panel9.add(panel17);

                        //======== panel10 ========
                        {
                            panel10.setLayout(new GridLayout(1, 6));
                        }
                        panel9.add(panel10);

                        //======== panel18 ========
                        {
                            panel18.setLayout(new GridLayout(1, 6));
                        }
                        panel9.add(panel18);
                    }

                    GroupLayout panel4Layout = new GroupLayout(panel4);
                    panel4.setLayout(panel4Layout);
                    panel4Layout.setHorizontalGroup(
                            panel4Layout.createParallelGroup()
                                    .addGroup(panel4Layout.createSequentialGroup()
                                            .addComponent(panel5, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(pnlCheckoutsPlaceHolder, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                            .addGap(0, 0, 0)
                                            .addComponent(panel9, GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                                            .addGap(0, 0, 0))
                    );
                    panel4Layout.setVerticalGroup(
                            panel4Layout.createParallelGroup()
                                    .addComponent(panel5, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                                    .addComponent(pnlCheckoutsPlaceHolder, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                                    .addComponent(panel9, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                    );
                }

                //======== panel6 ========
                {
                    panel6.setLayout(new GridLayout(2, 1));

                    //---- btnStartSimulating ----
                    btnStartSimulating.setText("Start Simulating");
                    btnStartSimulating.setToolTipText("Start");
                    panel6.add(btnStartSimulating);

                    //---- btnEndandShowStatistics ----
                    btnEndandShowStatistics.setText("End and Show Statistics");
                    panel6.add(btnEndandShowStatistics);
                }

                //======== panel3 ========
                {

                    //---- label1 ----
                    label1.setText("No. of checkouts (1-8)");

                    //---- label2 ----
                    label2.setText("No. of products in a trolley (1-200)");

                    //---- cbNoOfProducts ----
                    cbNoOfProducts.setText("30");

                    //---- label3 ----
                    label3.setText("Time to check a product (0.5-6s)");

                    //---- label4 ----
                    label4.setText("No. of \"5 or less\" checkouts (0-7)");

                    //---- label5 ----
                    label5.setText("Customer arrival rate");

                    //---- label7 ----
                    label7.setText("Fast forwarde");

                    GroupLayout panel3Layout = new GroupLayout(panel3);
                    panel3.setLayout(panel3Layout);
                    panel3Layout.setHorizontalGroup(
                            panel3Layout.createParallelGroup()
                                    .addGroup(panel3Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(panel3Layout.createParallelGroup()
                                                    .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(cbNoOfCheckouts)
                                                    .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                                                            .addGap(0, 0, Short.MAX_VALUE)
                                                            .addGroup(panel3Layout.createParallelGroup()
                                                                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(cbCustomerArrivalRate, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)))
                                                    .addGroup(panel3Layout.createSequentialGroup()
                                                            .addGroup(panel3Layout.createParallelGroup()
                                                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(cbNoOfProducts, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(cbTimeToCheckAProduct, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(cbNoOf5OrLess, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(label7, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(cbFastForward, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
                                                            .addGap(0, 0, Short.MAX_VALUE)))
                                            .addContainerGap())
                    );
                    panel3Layout.setVerticalGroup(
                            panel3Layout.createParallelGroup()
                                    .addGroup(panel3Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(label1)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cbNoOfCheckouts, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(label2)
                                            .addGap(6, 6, 6)
                                            .addComponent(cbNoOfProducts, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(label3)
                                            .addGap(6, 6, 6)
                                            .addComponent(cbTimeToCheckAProduct, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(label4)
                                            .addGap(6, 6, 6)
                                            .addComponent(cbNoOf5OrLess, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(label5)
                                            .addGap(6, 6, 6)
                                            .addComponent(cbCustomerArrivalRate, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(label7)
                                            .addGap(6, 6, 6)
                                            .addComponent(cbFastForward, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                            .addContainerGap(50, Short.MAX_VALUE))
                    );
                }

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                        panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(panel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panel1Layout.createParallelGroup()
                                                .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(panel6, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap())
                );
                panel1Layout.setVerticalGroup(
                        panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(panel6, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42))
                                .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(panel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addContainerGap())
                );
            }
            tabbedPane1.addTab("Simulator", panel1);

            //======== panel2 ========
            {

                //======== panel8 ========
                {

                    GroupLayout panel8Layout = new GroupLayout(panel8);
                    panel8.setLayout(panel8Layout);
                    panel8Layout.setHorizontalGroup(
                            panel8Layout.createParallelGroup()
                                    .addGap(0, 365, Short.MAX_VALUE)
                    );
                    panel8Layout.setVerticalGroup(
                            panel8Layout.createParallelGroup()
                                    .addGap(0, 290, Short.MAX_VALUE)
                    );
                }

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(table2);
                }

                //======== scrollPane2 ========
                {
                    scrollPane2.setViewportView(table1);
                }

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                        panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(panel2Layout.createParallelGroup()
                                                .addGroup(panel2Layout.createSequentialGroup()
                                                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 547, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(panel8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE))
                                        .addContainerGap())
                );
                panel2Layout.setVerticalGroup(
                        panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                                .addComponent(panel8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
                );
            }
            tabbedPane1.addTab("Statistics", panel2);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tabbedPane1)
                                .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tabbedPane1)
                                .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JPanel panel4;
    private JPanel panel5;
    private JLabel label18;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private JLabel label15;
    private JLabel label16;
    private JLabel label17;
    private JPanel pnlCheckoutsPlaceHolder;
    private JLabel label8;
    private JPanel panel9;
    private JPanel panel11;
    private JLabel label9;
    private JPanel panel12;
    private JPanel panel13;
    private JPanel panel14;
    private JPanel panel15;
    private JPanel panel16;
    private JPanel panel17;
    private JPanel panel10;
    private JPanel panel18;
    private JPanel panel6;
    private JButton btnStartSimulating;
    private JButton btnEndandShowStatistics;
    private JPanel panel3;
    private JLabel label1;
    private JComboBox cbNoOfCheckouts;
    private JLabel label2;
    private JTextField cbNoOfProducts;
    private JLabel label3;
    private JComboBox cbTimeToCheckAProduct;
    private JLabel label4;
    private JComboBox cbNoOf5OrLess;
    private JLabel label5;
    private JComboBox cbCustomerArrivalRate;
    private JLabel label7;
    private JComboBox cbFastForward;
    private JPanel panel2;
    private JPanel panel8;
    private JScrollPane scrollPane1;
    private JTable table2;
    private JScrollPane scrollPane2;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
