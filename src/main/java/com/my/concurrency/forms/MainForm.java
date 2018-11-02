/*
 * Created by JFormDesigner on Thu Nov 01 17:17:35 GMT 2018
 */

package com.my.concurrency.forms;

import javax.swing.*;
import java.awt.*;

/**
 * @author Brainrain
 */
public class MainForm extends JFrame {
    public MainForm() {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();
        btnStartSimulating = new JButton();
        btnEndandShowStatistics = new JButton();
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

                    GroupLayout panel4Layout = new GroupLayout(panel4);
                    panel4.setLayout(panel4Layout);
                    panel4Layout.setHorizontalGroup(
                            panel4Layout.createParallelGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                    );
                    panel4Layout.setVerticalGroup(
                            panel4Layout.createParallelGroup()
                                    .addGap(0, 299, Short.MAX_VALUE)
                    );
                }

                //======== panel5 ========
                {

                    GroupLayout panel5Layout = new GroupLayout(panel5);
                    panel5.setLayout(panel5Layout);
                    panel5Layout.setHorizontalGroup(
                            panel5Layout.createParallelGroup()
                                    .addGap(0, 716, Short.MAX_VALUE)
                    );
                    panel5Layout.setVerticalGroup(
                            panel5Layout.createParallelGroup()
                                    .addGap(0, 228, Short.MAX_VALUE)
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

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                        panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup()
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addComponent(panel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                        .addComponent(panel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(panel6, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)))
                                        .addContainerGap())
                );
                panel1Layout.setVerticalGroup(
                        panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panel1Layout.createParallelGroup()
                                                .addComponent(panel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(panel6, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(7, Short.MAX_VALUE))
                );
            }
            tabbedPane1.addTab("text", panel1);

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
                                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
                );
            }
            tabbedPane1.addTab("text", panel2);
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
                                .addComponent(tabbedPane1, GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
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
    private JPanel panel6;
    private JButton btnStartSimulating;
    private JButton btnEndandShowStatistics;
    private JPanel panel2;
    private JPanel panel8;
    private JScrollPane scrollPane1;
    private JTable table2;
    private JScrollPane scrollPane2;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
