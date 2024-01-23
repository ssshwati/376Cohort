package com.BankSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankSystemUI extends JFrame {
    private BankSystemUtility bankSystemUtility;

    public BankSystemUI() {
        bankSystemUtility = new BankSystemUtility();
        
        setTitle("Bank System");
        setSize(400, 300);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();

//        setLocationRelativeTo(null);
//        setVisible(true);
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        JButton acceptCustomerDataButton = new JButton("Accept Customer Data");
        JButton assignBankAccountButton = new JButton("Assign Bank Account");
        JButton showBalanceDataButton = new JButton("Show Balance Data");
        JButton sortCustomersButton = new JButton("Sort Customers");
        JButton persistanceButton = new JButton("Persistence");
        JButton showAllCustomersButton = new JButton("Show All Customers");
        JButton searchCustomersButton = new JButton("Search Customers");
        JButton withdrawButton = new JButton("Withdraw");
        JButton depositButton = new JButton("Deposit");
        JButton exitButton = new JButton("Exit");

        panel.add(acceptCustomerDataButton);
        panel.add(assignBankAccountButton);
        panel.add(showBalanceDataButton);
        panel.add(sortCustomersButton);
        panel.add(persistanceButton);
        panel.add(showAllCustomersButton);
        panel.add(searchCustomersButton);
        panel.add(withdrawButton);
        panel.add(depositButton);
        panel.add(exitButton);

        acceptCustomerDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bankSystemUtility.acceptCustomerData();
            }
        });

        assignBankAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bankSystemUtility.assignBankAccount();
            }
        });

        // Add action listeners for other buttons...

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bankSystemUtility.dao.saveAllCustomers(bankSystemUtility.customerList);
                System.out.println("Exiting the program. Goodbye!");
                System.exit(0);
            }
        });

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BankSystemUI();
            }
        });
    }
}
