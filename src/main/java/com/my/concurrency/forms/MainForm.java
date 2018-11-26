/*
 * Created by JFormDesigner on Thu Nov 01 17:17:35 GMT 2018
 */

package com.my.concurrency.forms;

import com.my.concurrency.db.DbHelper;
import com.my.concurrency.models.Checkout;
import com.my.concurrency.models.Customer;
import com.my.concurrency.models.FastForward;
import com.my.concurrency.models.History;
import com.my.concurrency.threads.AssigningThread;
import com.my.concurrency.threads.CheckoutThread;
import com.my.concurrency.threads.CustomerGeneratorThread;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.*;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.regex.Pattern;


public class MainForm extends JFrame {

    private ArrayList<JLabel> checkoutLabelList;
    private ArrayList<Checkout> checkoutList;
    private ArrayList<Checkout> checkout5OrLessList;
    private ArrayList<JPanel> waitingLineList;
    private BlockingQueue<Customer> customerList;   //customer generated
    private ArrayList<Queue<Customer>> customerWaitingLists;   //customer already in supermarket
    private ArrayList<Queue<Customer>> customer5OrLessWaitingLists;   //customer already in 5OrLess waitingLine supermarket
    private History history;
    private CheckoutThread[] checkoutThreadList;
    private AssigningThread assigningThread;
    private CustomerGeneratorThread customerGeneratorThread;
    private ArrayList<Thread> allThreads = new ArrayList<>();
    public final static String picPathCheckoutAvaiable = "src\\main\\resources\\pics\\checkout_available.png";
    public final static String picPathCheckoutUnavaiable = "src\\main\\resources\\pics\\checkout_unavailable.png";
    public final static String picPathCheckoutBusy = "src\\main\\resources\\pics\\checkout_busy.png";
    public final static String picPathCustomer = "src\\main\\resources\\pics\\customer.png";
    public static int CheckoutAvaiableStatus = 0;
    public static int CheckoutUnavaiableStatus = 1;
    public static int CheckoutBusyStatus = 2;
    private ImageIcon iconCheckoutUnavaiable;
    private ImageIcon iconCheckoutAvaiable;
    private ImageIcon iconCheckoutBusy;
    private ImageIcon iconCustomer;
    private DbHelper dbHelper;
    private int numOfCheckout;
    private int numOf5OrLess;

    public MainForm() {
        initComponents();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        waitingLineList = new ArrayList<>();
        waitingLineList.add(pnlWL1);
        waitingLineList.add(pnlWL2);
        waitingLineList.add(pnlWL3);
        waitingLineList.add(pnlWL4);
        waitingLineList.add(pnlWL5);
        waitingLineList.add(pnlWL6);
        waitingLineList.add(pnlWL7);
        waitingLineList.add(pnlWL8);
        checkoutLabelList = new ArrayList<>();
        customerList = new ArrayBlockingQueue<Customer>(100);
        customerWaitingLists = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            customerWaitingLists.add(new LinkedList<Customer>());
        }
        iconCheckoutUnavaiable = new ImageIcon(picPathCheckoutUnavaiable);
        iconCheckoutAvaiable = new ImageIcon(picPathCheckoutAvaiable);
        iconCheckoutBusy = new ImageIcon(picPathCheckoutBusy);
        iconCustomer = new ImageIcon(picPathCustomer);
        checkoutList = new ArrayList<>();
        checkout5OrLessList = new ArrayList<>();
        customer5OrLessWaitingLists = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            customer5OrLessWaitingLists.add(new LinkedList<Customer>());
        }
        history = new History();
        checkoutThreadList = new CheckoutThread[10];
        dbHelper = new DbHelper(history);
        initCustomompnents();
    }

    public synchronized Date getStandardDate() {
        return new Date();
    }

    private void initCustomompnents() {

        for (int i = 0; i < 8; i++) {
            JLabel lbCheckout = new JLabel(iconCheckoutUnavaiable);
            checkoutLabelList.add(lbCheckout);
            pnlCheckoutsPlaceHolder.add(lbCheckout);
        }

        //init the no. of checkout comboBox
        for (int i = 1; i <= 8; i++) {
            cbNoOfCheckouts.addItem(i);
        }

        //init the no. of checkout comboBox
        String s = "0.5 - ";
        for (int i = 1; i <= 6; i++) {
            String timeRange = s + i + "s";
            cbTimeToCheckAProduct.addItem(timeRange);
        }

        //init the no. of 5 or less comboBox
        for (int i = 0; i < 8; i++) {
            cbNoOf5OrLess.addItem(i);
        }

        //init the customer arrival rate comboBox
        String postfixOfRate = " customers per hour";
        for (int i = 0; i < 300; i++) {
            cbCustomerArrivalRate.addItem(i + 1 + postfixOfRate);
        }

        String postfixOfFastForward = " X";
        for (int i = 0; i < 6; i++) {
            cbFastForward.addItem(((1 << i)) + postfixOfFastForward);
        }


    }

    private void btnStartSimulatingActionPerformed(ActionEvent e) {
        //conformation of input
        String regex = "^[0-9]*$";

        boolean matchFlag = Pattern.matches(regex, tfNoOfProducts.getText());
        if (!matchFlag) {
            JOptionPane.showMessageDialog(null, "Please input a integer from 1 to 200 in \"No.of product in trolley\" input box", "标题", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            int range = Integer.parseInt(tfNoOfProducts.getText());
            if (range > 200 || range <= 0) {
                JOptionPane.showMessageDialog(null, "Please input a integer from 1 to 200 in \"No.of product in trolley\" input box", "标题", JOptionPane.ERROR_MESSAGE);
                return;
            }

        }
        //all validation are passed, create the checkout
        numOfCheckout = cbNoOfCheckouts.getSelectedIndex() + 1;
        numOf5OrLess = cbNoOf5OrLess.getSelectedIndex();
        int numOfProduct = Integer.parseInt(tfNoOfProducts.getText());
        int timeToCheckAProduct = cbTimeToCheckAProduct.getSelectedIndex() + 1;
        int customerArriveRate = cbCustomerArrivalRate.getSelectedIndex() + 1;
        int fastForward = 1 << cbFastForward.getSelectedIndex();


        //set time and timeToCheckAProduct fastforward
        FastForward.setTimeToCheckoutTo(timeToCheckAProduct * 1000);
        FastForward.setTimeToGenerateACustomer(3600 / customerArriveRate * 1000);
        FastForward.setTime(fastForward);

        //set the num of product and timeToCheckAProduct used by CustomerGenerateorThread and starts CustomerGenerateorThread
        customerGeneratorThread = new CustomerGeneratorThread(this, customerList, numOfProduct, history);
        new Thread(customerGeneratorThread).start();

        //starts Assigning Thread
        assigningThread = new AssigningThread(this, customerWaitingLists, customer5OrLessWaitingLists, customerList, numOf5OrLess, numOfCheckout, history);
        new Thread(assigningThread).start();

        //using Executor framework to manage the below threads
        //creates CheckoutThreads by numOfCheckout
        //creates CheckoutThreads by numOf5OrLess
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int num = 1;

        for (int i = 0; i < numOf5OrLess; i++) {
            Checkout checkout = new Checkout();
            checkout.setName("Checkout5OrLess - " + num);
            checkout.setStartedTime(new Date());
            checkout.setNumOfCheckedCustomers(0);
            checkout.setNumOfCheckedItems(0);
            checkoutLabelList.get(num - 1).setHorizontalTextPosition(JLabel.CENTER);
            checkoutLabelList.get(num - 1).setVerticalTextPosition(JLabel.BOTTOM);
            checkoutLabelList.get(num - 1).setText(checkout.getName());
            dbHelper.insertACheckout(checkout);
            checkoutList.add(checkout);
            CheckoutThread checkoutThread = new CheckoutThread(this, i + 1, i + 1, num, checkout, waitingLineList, customerWaitingLists, customer5OrLessWaitingLists, true, history);
//            executorService.execute(checkoutThreadList);
            checkoutThreadList[num - 1] = checkoutThread;
            Thread thread = new Thread(checkoutThread);
            allThreads.add(thread);
            thread.start();
            num++;
        }

        for (int i = 0; i < numOfCheckout - numOf5OrLess; i++) {
            Checkout checkout = new Checkout();
            checkout.setName("Checkout - " + num);
            checkout.setStartedTime(new Date());
            checkout.setNumOfCheckedCustomers(0);
            checkout.setNumOfCheckedItems(0);
            checkoutLabelList.get(num - 1).setHorizontalTextPosition(JLabel.CENTER);
            checkoutLabelList.get(num - 1).setVerticalTextPosition(JLabel.BOTTOM);
            checkoutLabelList.get(num - 1).setText(checkout.getName());
            dbHelper.insertACheckout(checkout);
            checkoutList.add(checkout);
            CheckoutThread checkoutThread = new CheckoutThread(this, i + 1, i + 1, num, checkout, waitingLineList, customerWaitingLists, customer5OrLessWaitingLists, false, history);
//            executorService.execute(checkoutThreadList);
            checkoutThreadList[num - 1] = checkoutThread;
            Thread thread = new Thread(checkoutThread);
            allThreads.add(thread);
            thread.start();
            num++;
        }


    }

    public void updateCheckout(int numOfCheckout, int checkoutStatus) {
        JLabel jLabel = checkoutLabelList.get(numOfCheckout - 1);
        switch (checkoutStatus) {
            case 0:
                jLabel.setIcon(iconCheckoutAvaiable);
                break;
            case 1:
                jLabel.setIcon(iconCheckoutUnavaiable);
                break;
            case 2:
                jLabel.setIcon(iconCheckoutBusy);
                break;
        }
        jLabel.revalidate();
    }


    public void updateWaitingLine(int orderOfCheckout, Customer customer) {
        JPanel jPanel = waitingLineList.get(orderOfCheckout - 1);
        if (customer == null) {
            jPanel.removeAll();
            Queue<Customer> customerWaitingList;
            synchronized (customerWaitingLists) {
                synchronized (customer5OrLessWaitingLists) {
                    if (orderOfCheckout <= numOf5OrLess) {
                        customerWaitingList = customer5OrLessWaitingLists.get(orderOfCheckout - 1);
                    } else {
                        customerWaitingList = customerWaitingLists.get(orderOfCheckout - numOf5OrLess - 1);
                    }
                    for (Customer cus : customerWaitingList
                    ) {
                        JLabel l = new JLabel(iconCustomer);
                        l.setHorizontalTextPosition(SwingConstants.RIGHT);
                        l.setText("" + cus.getNumOfProducts());
                        jPanel.add(l);
                    }
                }
            }
        } else {
            JLabel l = new JLabel(iconCustomer);
            l.setHorizontalTextPosition(SwingConstants.RIGHT);
            l.setText("" + customer.getNumOfProducts());
            jPanel.add(l);
        }
        jPanel.revalidate();
    }


    private void btnEndandShowStatisticsActionPerformed(ActionEvent e) {
        // TODO ends up all checkout thread and assigningThread and CustomerGeneratorThread by stopThread()
        for (int i = 0; i < numOfCheckout; i++) {
            CheckoutThread c = checkoutThreadList[i];
            c.stopThread();
        }
        customerGeneratorThread.stopThread();
        assigningThread.stopThread();
        //wait for end of all threads
        for (Thread t :
                allThreads) {
            try {
                t.join();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }

        //todo save checkouts' data and history into database
        for (
                Checkout c :
                checkoutList) {
            dbHelper.updateCheckout(c);
        }
        int numOfProduct = Integer.parseInt(tfNoOfProducts.getText());
        int timeToCheckAProduct = cbTimeToCheckAProduct.getSelectedIndex() + 1;
        int customerArriveRate = cbCustomerArrivalRate.getSelectedIndex() + 1;
        int fastForward = 1 << cbFastForward.getSelectedIndex();
        history.setCheckoutStartId(checkoutList.get(0).getId());
        history.setCheckoutEndId(checkoutList.get(checkoutList.size() - 1).getId());
        history.setNumOf5OrLessCheckouts(numOf5OrLess);
        history.setNumOfCheckouts(numOfCheckout);
        history.setNumOfProductsInTrolley(numOfProduct);
        history.setTimeForEachProduct(timeToCheckAProduct);
        history.setSpecificRateRange(customerArriveRate);
        dbHelper.insertAHistory(history);


        //todo invokes calculation method to get statistics
        //todo binds statistics with scrollTables or shows them in the JTextFields
        calculationAndShowStatistics();

        //todo jumps to statistics tab
        tabbedPane1.setSelectedIndex(1);
    }

    public void calculationAndShowStatistics() {
        long runningTime[] = new long[8];

        HashMap<Integer, String> checkoutNames = new HashMap<Integer, String>();
        HashMap<Integer, Long> processingTimeOfEachCheckout = new HashMap<>(); //integer represents checkout ID, Long represents processing time

        //obtains the checkout IDs for using later.
        for (int i = 0; i < checkoutList.size(); i++) {
            checkoutNames.put(checkoutList.get(i).getId(), checkoutList.get(i).getName());
        }
        int totalProductsProcessed = 0;

        double totalCustomerWaitTime = 0;
        double averageCustomerWaitTime = 0;

        double averageProductsPerTrolley = 0;
        int numberOfLostCustomers = 0;

        double totalCheckoutUtilisation = 0;
        double averageCheckoutUtilisation = 0;

        //obtains all checkout's running time
        for (int i = 0; i < checkoutList.size(); i++) {
            Checkout c = checkoutList.get(i);
            runningTime[i] = c.getFinishedTime().getTime() - c.getStartedTime().getTime();
        }

        List<Customer> customersByHistory = dbHelper.getCustomersByHistory(history);

        int numOfCustomerStillInTheWaitState = 0;
        for (Customer c :
                customersByHistory) {
            if (c.getLostFlag() == 1) {
                numberOfLostCustomers++;
            } else {
                Long checkStartNanosec = c.getCheckStartNanosec();
                if (checkStartNanosec == null) {
                    //if checkStartNanosec is null, means the customer is still in the waitline,not start checking,
                    //so, the customer should be excluded when it's calculating
                } else {
                    totalProductsProcessed += c.getNumOfProducts();
                    totalCustomerWaitTime += c.getCheckStartNanosec() - c.getArrivedNanosec();
                    long processingTime = c.getCheckEndTime().getTime() - c.getCheckStartTime().getTime();
                    Long processTime = processingTimeOfEachCheckout.get(c.getCheckoutId());
                    if (processTime == null) {
                        processingTimeOfEachCheckout.put(c.getCheckoutId(), processingTime);
                    } else {
                        processingTimeOfEachCheckout.put(c.getCheckoutId(), processTime + processingTime);
                    }
                }

            }
            //add data into Customer Table
            DefaultTableModel customersModel = (DefaultTableModel) tblCustomer.getModel();

            double CustomerWaitTime;
            Long checkStartNanosec = c.getCheckStartNanosec();
            if (checkStartNanosec == null) {
                //if checkStartNanosec is null, means the customer is still in the waitline,not start checking,
                //so, the customer should be excluded when it's calculating
                numOfCustomerStillInTheWaitState++;
                CustomerWaitTime = 0;
            } else {
                CustomerWaitTime = (double) ((c.getCheckStartNanosec() - c.getArrivedNanosec()) / 1000000000.0);

            }
            //Date instance created by checkout thread may be before the customer generator thread: -0.123 sec
            Object[] objects = {c.getId(), checkoutNames.get(c.getCheckoutId()), c.getLostFlag(), CustomerWaitTime + " sec", c.getNumOfProducts(), c.getArrivedTime(), c.getFinishedTime(), c.getCheckStartTime(), c.getCheckEndTime()};
            customersModel.addRow(objects);
        }
        averageCustomerWaitTime = totalCustomerWaitTime / 1000000000 / (customersByHistory.size() - numOfCustomerStillInTheWaitState);
        averageProductsPerTrolley = (double) totalProductsProcessed / (customersByHistory.size() - numOfCustomerStillInTheWaitState);

        DefaultTableModel checkoutsModel = (DefaultTableModel) tblCheckout.getModel();
        for (int i = 0; i < checkoutList.size(); i++) {
            Checkout c = checkoutList.get(i);
            Long processTime = processingTimeOfEachCheckout.get(c.getId());
            double utilization;
            if (processTime == null) {
                utilization = 0;
            } else {
                BigDecimal bdProcessTime = new BigDecimal(processTime);
                System.out.println(bdProcessTime);
                BigDecimal bdOpenTime = new BigDecimal(c.getFinishedTime().getTime() - c.getStartedTime().getTime());
                System.out.println(bdOpenTime);
                BigDecimal result = bdProcessTime.divide(bdOpenTime, 6, BigDecimal.ROUND_HALF_UP);
                System.out.println(result);
                result = result.multiply(new BigDecimal(100));
                System.out.println(result);
                utilization = result.doubleValue();
                System.out.println(utilization);

            }

            totalCheckoutUtilisation += utilization;
            Object[] objects = {c.getName(), c.getStartedTime(), c.getFinishedTime(), utilization + "%", c.getNumOfCheckedCustomers(), c.getNumOfCheckedItems()};
            checkoutsModel.addRow(objects);
        }
        averageCheckoutUtilisation = totalCheckoutUtilisation / checkoutList.size();
        //shows the data
        lbTotalProductsProcessed.setText(lbTotalProductsProcessed.getText() + totalProductsProcessed);
        lbAveCusWaitTime.setText(lbAveCusWaitTime.getText() + String.format("%.4f sec", averageCustomerWaitTime));
        lbAveChkUtili.setText(lbAveChkUtili.getText() + String.format("%.4f", averageCheckoutUtilisation) + "%");
        lbAveProPerTro.setText(lbAveProPerTro.getText() + String.format("%.4f", averageProductsPerTrolley));
        lbNumOfLostCus.setText(lbNumOfLostCus.getText() + numberOfLostCustomers);
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
        pnl = new JPanel();
        label9 = new JLabel();
        pnlWL1 = new JPanel();
        pnlWL2 = new JPanel();
        pnlWL3 = new JPanel();
        pnlWL4 = new JPanel();
        pnlWL5 = new JPanel();
        pnlWL6 = new JPanel();
        pnlWL7 = new JPanel();
        pnlWL8 = new JPanel();
        panel6 = new JPanel();
        btnStartSimulating = new JButton();
        btnEndandShowStatistics = new JButton();
        panel3 = new JPanel();
        label1 = new JLabel();
        cbNoOfCheckouts = new JComboBox();
        label4 = new JLabel();
        cbNoOf5OrLess = new JComboBox();
        label5 = new JLabel();
        cbCustomerArrivalRate = new JComboBox();
        label7 = new JLabel();
        cbFastForward = new JComboBox();
        label3 = new JLabel();
        cbTimeToCheckAProduct = new JComboBox();
        label2 = new JLabel();
        tfNoOfProducts = new JTextField();
        panel2 = new JPanel();
        panel8 = new JPanel();
        lbTotalProductsProcessed = new JLabel();
        lbAveCusWaitTime = new JLabel();
        lbAveChkUtili = new JLabel();
        lbAveProPerTro = new JLabel();
        lbNumOfLostCus = new JLabel();
        scrollPane1 = new JScrollPane();
        tblCustomer = new JTable();
        scrollPane2 = new JScrollPane();
        tblCheckout = new JTable();

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

                        //======== pnl ========
                        {
                            pnl.setLayout(new GridLayout(1, 1));

                            //---- label9 ----
                            label9.setText("Waiting Line");
                            label9.setBorder(new MatteBorder(0, 0, 2, 0, Color.black));
                            label9.setHorizontalAlignment(SwingConstants.CENTER);
                            label9.setHorizontalTextPosition(SwingConstants.RIGHT);
                            pnl.add(label9);
                        }
                        panel9.add(pnl);

                        //======== pnlWL1 ========
                        {
                            pnlWL1.setLayout(new GridLayout(1, 6));
                        }
                        panel9.add(pnlWL1);

                        //======== pnlWL2 ========
                        {
                            pnlWL2.setLayout(new GridLayout(1, 6));
                        }
                        panel9.add(pnlWL2);

                        //======== pnlWL3 ========
                        {
                            pnlWL3.setLayout(new GridLayout(1, 6));
                        }
                        panel9.add(pnlWL3);

                        //======== pnlWL4 ========
                        {
                            pnlWL4.setLayout(new GridLayout(1, 6));
                        }
                        panel9.add(pnlWL4);

                        //======== pnlWL5 ========
                        {
                            pnlWL5.setLayout(new GridLayout(1, 6));
                        }
                        panel9.add(pnlWL5);

                        //======== pnlWL6 ========
                        {
                            pnlWL6.setLayout(new GridLayout(1, 6));
                        }
                        panel9.add(pnlWL6);

                        //======== pnlWL7 ========
                        {
                            pnlWL7.setLayout(new GridLayout(1, 6));
                        }
                        panel9.add(pnlWL7);

                        //======== pnlWL8 ========
                        {
                            pnlWL8.setLayout(new GridLayout(1, 6));
                        }
                        panel9.add(pnlWL8);
                    }

                    GroupLayout panel4Layout = new GroupLayout(panel4);
                    panel4.setLayout(panel4Layout);
                    panel4Layout.setHorizontalGroup(
                            panel4Layout.createParallelGroup()
                                    .addGroup(panel4Layout.createSequentialGroup()
                                            .addComponent(panel5, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(pnlCheckoutsPlaceHolder, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                            .addGap(0, 0, 0)
                                            .addComponent(panel9, GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                                            .addGap(0, 0, 0))
                    );
                    panel4Layout.setVerticalGroup(
                            panel4Layout.createParallelGroup()
                                    .addComponent(panel5, GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                                    .addComponent(pnlCheckoutsPlaceHolder, GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                                    .addComponent(panel9, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                    );
                }

                //======== panel6 ========
                {
                    panel6.setLayout(new GridLayout(2, 1));

                    //---- btnStartSimulating ----
                    btnStartSimulating.setText("Start Simulating");
                    btnStartSimulating.setToolTipText("Start");
                    btnStartSimulating.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            btnStartSimulatingActionPerformed(e);
                        }
                    });
                    panel6.add(btnStartSimulating);

                    //---- btnEndandShowStatistics ----
                    btnEndandShowStatistics.setText("End and Show Statistics");
                    btnEndandShowStatistics.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            btnEndandShowStatisticsActionPerformed(e);
                        }
                    });
                    panel6.add(btnEndandShowStatistics);
                }

                //======== panel3 ========
                {

                    //---- label1 ----
                    label1.setText("No. of checkouts (1-8)");

                    //---- label4 ----
                    label4.setText("No. of \"5 or less\" checkouts (0-7)");

                    //---- label5 ----
                    label5.setText("Customer arrival rate");

                    //---- label7 ----
                    label7.setText("Fast Forward");

                    //---- label3 ----
                    label3.setText("Time to check a product (0.5-6s)");

                    //---- label2 ----
                    label2.setText("No. of products in a trolley (1-200)");

                    //---- tfNoOfProducts ----
                    tfNoOfProducts.setText("30");

                    GroupLayout panel3Layout = new GroupLayout(panel3);
                    panel3.setLayout(panel3Layout);
                    panel3Layout.setHorizontalGroup(
                            panel3Layout.createParallelGroup()
                                    .addGroup(panel3Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(panel3Layout.createParallelGroup()
                                                    .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(cbNoOfCheckouts)
                                                    .addGroup(panel3Layout.createSequentialGroup()
                                                            .addGroup(panel3Layout.createParallelGroup()
                                                                    .addComponent(label7, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(cbFastForward, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(cbNoOf5OrLess, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
                                                            .addGap(0, 0, Short.MAX_VALUE))
                                                    .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                                                            .addGap(0, 0, Short.MAX_VALUE)
                                                            .addGroup(panel3Layout.createParallelGroup()
                                                                    .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createParallelGroup()
                                                                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(cbCustomerArrivalRate, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
                                                                    .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createParallelGroup()
                                                                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(cbTimeToCheckAProduct, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
                                                                    .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createParallelGroup()
                                                                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(tfNoOfProducts, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)))))
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
                                            .addComponent(label4)
                                            .addGap(6, 6, 6)
                                            .addComponent(cbNoOf5OrLess, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(label2)
                                            .addGap(10, 10, 10)
                                            .addComponent(tfNoOfProducts, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                            .addGap(3, 3, 3)
                                            .addComponent(label3)
                                            .addGap(5, 5, 5)
                                            .addComponent(cbTimeToCheckAProduct, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(label5)
                                            .addGap(6, 6, 6)
                                            .addComponent(cbCustomerArrivalRate, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(label7)
                                            .addGap(6, 6, 6)
                                            .addComponent(cbFastForward, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                            .addContainerGap(138, Short.MAX_VALUE))
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
                panel2.setToolTipText("sdfsd");

                //======== panel8 ========
                {

                    //---- lbTotalProductsProcessed ----
                    lbTotalProductsProcessed.setText("Total Products Processed :");

                    //---- lbAveCusWaitTime ----
                    lbAveCusWaitTime.setText("Average Customer Wait Time: ");

                    //---- lbAveChkUtili ----
                    lbAveChkUtili.setText("Average Checkout Utilization: ");

                    //---- lbAveProPerTro ----
                    lbAveProPerTro.setText("Average Products Per Trolley: ");

                    //---- lbNumOfLostCus ----
                    lbNumOfLostCus.setText("The Number of Lost Customers: ");

                    GroupLayout panel8Layout = new GroupLayout(panel8);
                    panel8.setLayout(panel8Layout);
                    panel8Layout.setHorizontalGroup(
                            panel8Layout.createParallelGroup()
                                    .addGroup(panel8Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(panel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(lbAveChkUtili, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                                                    .addComponent(lbAveProPerTro, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                                                    .addComponent(lbNumOfLostCus, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbTotalProductsProcessed, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                                                    .addComponent(lbAveCusWaitTime, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE))
                                            .addContainerGap(21, Short.MAX_VALUE))
                    );
                    panel8Layout.setVerticalGroup(
                            panel8Layout.createParallelGroup()
                                    .addGroup(panel8Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(lbTotalProductsProcessed)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(lbAveCusWaitTime)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(lbAveChkUtili)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(lbAveProPerTro)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(lbNumOfLostCus)
                                            .addContainerGap(136, Short.MAX_VALUE))
                    );
                }

                //======== scrollPane1 ========
                {
                    scrollPane1.setBorder(new TitledBorder(new LineBorder(Color.black, 1, true), "Customers"));

                    //---- tblCustomer ----
                    tblCustomer.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    tblCustomer.setModel(new DefaultTableModel(
                            new Object[][]{
                            },
                            new String[]{
                                    "Id", "Checkout Name", "Lost", "Total Wait Time", "Products", "Arrival Time", "Leave Time", "Checkout Start Time", "Checkout End Time"
                            }
                    ) {
                        boolean[] columnEditable = new boolean[]{
                                false, false, false, false, false, false, false, false, false
                        };

                        @Override
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return columnEditable[columnIndex];
                        }
                    });
                    {
                        TableColumnModel cm = tblCustomer.getColumnModel();
                        cm.getColumn(1).setPreferredWidth(125);
                        cm.getColumn(3).setPreferredWidth(125);
                        cm.getColumn(5).setPreferredWidth(120);
                        cm.getColumn(6).setPreferredWidth(120);
                        cm.getColumn(7).setPreferredWidth(150);
                        cm.getColumn(8).setPreferredWidth(150);
                    }
                    scrollPane1.setViewportView(tblCustomer);
                }

                //======== scrollPane2 ========
                {
                    scrollPane2.setBorder(new TitledBorder(new LineBorder(Color.black, 1, true), "Checkouts"));
                    scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

                    //---- tblCheckout ----
                    tblCheckout.setBorder(null);
                    tblCheckout.setModel(new DefaultTableModel(
                            new Object[][]{
                            },
                            new String[]{
                                    "Name", "Start Time", "End Time", "Utilization (Processing Time/ Running Time)", "Num of Checked Customers", "Num of Checked Products"
                            }
                    ) {
                        boolean[] columnEditable = new boolean[]{
                                false, false, false, false, false, false
                        };

                        @Override
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return columnEditable[columnIndex];
                        }
                    });
                    {
                        TableColumnModel cm = tblCheckout.getColumnModel();
                        cm.getColumn(3).setPreferredWidth(290);
                        cm.getColumn(4).setPreferredWidth(190);
                        cm.getColumn(5).setPreferredWidth(180);
                    }
                    tblCheckout.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    scrollPane2.setViewportView(tblCheckout);
                }

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                        panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(panel2Layout.createParallelGroup()
                                                .addGroup(panel2Layout.createSequentialGroup()
                                                        .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(panel8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 1018, Short.MAX_VALUE))
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
                                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
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
    private JPanel pnl;
    private JLabel label9;
    private JPanel pnlWL1;
    private JPanel pnlWL2;
    private JPanel pnlWL3;
    private JPanel pnlWL4;
    private JPanel pnlWL5;
    private JPanel pnlWL6;
    private JPanel pnlWL7;
    private JPanel pnlWL8;
    private JPanel panel6;
    private JButton btnStartSimulating;
    private JButton btnEndandShowStatistics;
    private JPanel panel3;
    private JLabel label1;
    private JComboBox cbNoOfCheckouts;
    private JLabel label4;
    private JComboBox cbNoOf5OrLess;
    private JLabel label5;
    private JComboBox cbCustomerArrivalRate;
    private JLabel label7;
    private JComboBox cbFastForward;
    private JLabel label3;
    private JComboBox cbTimeToCheckAProduct;
    private JLabel label2;
    private JTextField tfNoOfProducts;
    private JPanel panel2;
    private JPanel panel8;
    private JLabel lbTotalProductsProcessed;
    private JLabel lbAveCusWaitTime;
    private JLabel lbAveChkUtili;
    private JLabel lbAveProPerTro;
    private JLabel lbNumOfLostCus;
    private JScrollPane scrollPane1;
    private JTable tblCustomer;
    private JScrollPane scrollPane2;
    private JTable tblCheckout;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
