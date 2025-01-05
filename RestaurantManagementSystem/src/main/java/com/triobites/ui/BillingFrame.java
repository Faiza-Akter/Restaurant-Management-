package com.triobites.ui;

import com.triobites.models.Order;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BillingFrame extends JFrame {

    private List<Order> orderList = new ArrayList<>();
    private DefaultTableModel tableModel;

    public BillingFrame() {
        setTitle("Billing - Trio Bites");
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(30, 58, 138));
        JLabel headerLabel = new JLabel("Billing");
        headerLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        headerLabel.setForeground(new Color(251, 191, 36));
        headerPanel.add(headerLabel);

        // Table for displaying orders
        tableModel = new DefaultTableModel(new String[]{"Dish", "Quantity", "Order Date", "Total"}, 0);
        JTable orderTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(orderTable);

        // Calculate Button
        JButton calculateButton = new JButton("Calculate Total");
        calculateButton.setFont(new Font("Arial", Font.BOLD, 16));
        calculateButton.setBackground(new Color(251, 191, 36));
        calculateButton.setForeground(new Color(30, 58, 138));
        calculateButton.setBorder(BorderFactory.createLineBorder(new Color(30, 58, 138), 2));
        calculateButton.addActionListener(e -> {
            int total = orderList.stream().mapToInt(Order::calculateTotal).sum();
            JOptionPane.showMessageDialog(this, "Total Amount: " + total + " Tk");
        });

        // Adding Components to Frame
        setLayout(new BorderLayout());
        add(headerPanel, BorderLayout.NORTH);
        add(tableScrollPane, BorderLayout.CENTER);
        add(calculateButton, BorderLayout.SOUTH);
    }

    public void addOrder(Order order) {
        orderList.add(order);
        tableModel.addRow(new Object[]{order.getDish().getName(), order.getQuantity(), order.getOrderDate(), order.calculateTotal()});
    }
}
