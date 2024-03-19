//package com.BankSystem;
//
//import javax.swing.*;
//
//import com.Exp.CustomerNotFoundException;
//
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class BankSystemUI extends JFrame {
//    private BankSystemUtilityUI bankSystemUtility;
//
//    public BankSystemUI() {
//        bankSystemUtility = new BankSystemUtilityUI();
//
//        setTitle("BANKING SYSTEM");
//        setSize(700, 700);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        createUIComponents();
//        centerFrameOnScreen();  // Center the frame on the screen
//    }
//
//    private void createUIComponents() {
//        JPanel mainPanel = new JPanel(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//
//        JLabel titleLabel = new JLabel("BANKING SYSTEM");
//        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.gridwidth = 2;
//        gbc.insets = new Insets(10, 0, 20, 0);
//        mainPanel.add(titleLabel, gbc);
//
//        JButton[] buttons = new JButton[]{
//                new JButton("Create New Customer Data"),
//                new JButton("Assign a Bank Account to a Customer"),
//                new JButton("Display Balance or Interest Earned of a Customer"),
//                new JButton("Sort Customer Data"),
//                new JButton("Persist Customer Data"),
//                new JButton("Show All Customers"),
//                new JButton("Search Customers by Name"),
//                new JButton("Withdraw Amount"),
//                new JButton("Deposit Amount"),
//                new JButton("Exit")
//        };
//
//        gbc.gridwidth = 1;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//
//        for (int i = 0; i < buttons.length; i++) {
//            buttons[i].addActionListener(new ButtonClickListener(i + 1)); // Pass the button index as a command
//            gbc.gridx = 0;
//            gbc.gridy = i + 1;
//            gbc.insets = new Insets(5, 10, 5, 10);
//            mainPanel.add(buttons[i], gbc);
//        }
//
//        add(mainPanel);
//    }
//
//    private void centerFrameOnScreen() {
//        setLocationRelativeTo(null);
//    }
//
//    private class ButtonClickListener implements ActionListener {
//        private final int buttonIndex;
//
//        public ButtonClickListener(int buttonIndex) {
//            this.buttonIndex = buttonIndex;
//        }
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            switch (buttonIndex) {
//                case 1:
//                    bankSystemUtility.acceptCustomerData();
//                    break;
//                case 2:
//                    bankSystemUtility.assignBankAccount();
//                    break;
//                case 3:
//                    bankSystemUtility.showBalanceData();
//                    break;
//                case 4:
//                    bankSystemUtility.sortCustomers();
//                    break;
//                case 5:
//                    bankSystemUtility.persistance();
//                    break;
//                case 6:
//                    bankSystemUtility.showAllCustomers();
//                    break;
//                case 7:
//                    try {
//                        bankSystemUtility.searchCustomersByName();
//                    } catch (CustomerNotFoundException ex) {
//                        ex.printStackTrace();
//                    }
//                    break;
//                case 8:
//                    bankSystemUtility.withdraw();
//                    break;
//                case 9:
//                    bankSystemUtility.deposit();
//                    break;
//                case 10:
//                    bankSystemUtility.dao.saveAllCustomers(bankSystemUtility.customerList);
//                    System.out.println("Exiting the program. Goodbye!");
//                    System.exit(0);
//                    break;
//                default:
//                    System.out.println("Invalid choice. Please enter a number between 1 and 10.");
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            BankSystemUI bankSystemGUI = new BankSystemUI();
//            bankSystemGUI.setVisible(true);
//        });
//    }
//}
