package com.triobites.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class InfoSaveFrame extends JFrame {

    private DefaultTableModel tableModel;

    public InfoSaveFrame() {
        setTitle("Customer Info - Trio Bites");
        setSize(900, 400); // Wider frame for a more spacious UI
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on screen

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(30, 58, 138));
        headerPanel.setPreferredSize(new Dimension(900, 80));
        JLabel headerLabel = new JLabel("Trio Bites - Customer Info");
        headerLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
        headerLabel.setForeground(new Color(251, 191, 36));
        headerPanel.add(headerLabel);

        // Input Panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        inputPanel.setBackground(new Color(245, 245, 245));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel nameLabel = createStyledLabel("Customer Name:");
        JTextField nameField = createStyledTextField();
        JLabel phoneLabel = createStyledLabel("Phone Number:");
        JTextField phoneField = createStyledTextField();
        JLabel addressLabel = createStyledLabel("Address:");
        JTextField addressField = createStyledTextField();

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(nameLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        inputPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(phoneLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        inputPanel.add(phoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(addressLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        inputPanel.add(addressField, gbc);

        JButton saveButton = createStyledButton("Save Info");
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        inputPanel.add(saveButton, gbc);
        saveButton.setBackground(new Color(30, 58, 138));
        saveButton.setForeground(new Color(251, 191, 36));

        // Table Panel
        JPanel tablePanel = new JPanel();
        tablePanel.setBackground(new Color(240, 248, 255));
        tablePanel.setLayout(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(34, 45, 65), 2),
                "Saved Customer Info",
                0,
                0,
                new Font("Arial", Font.BOLD, 16),
                new Color(34, 45, 65)
        ));

        tableModel = new DefaultTableModel(new String[]{"Name", "Phone", "Address"}, 0);
        JTable infoTable = new JTable(tableModel);
        infoTable.setFont(new Font("Arial", Font.PLAIN, 14));
        infoTable.setRowHeight(25);
        JScrollPane tableScrollPane = new JScrollPane(infoTable);
        tableScrollPane.setPreferredSize(new Dimension(850, 300));

        tablePanel.add(tableScrollPane, BorderLayout.CENTER);

        // Adding Action to Save Button
        saveButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String phone = phoneField.getText().trim();
            String address = addressField.getText().trim();

            if (name.isEmpty() || phone.isEmpty() || address.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            tableModel.addRow(new Object[]{name, phone, address});

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("customer_info.txt", true))) {
                writer.write(name + "," + phone + "," + address);
                writer.newLine();
                JOptionPane.showMessageDialog(this, "Information saved successfully!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving information: " + ex.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
            }

            nameField.setText("");
            phoneField.setText("");
            addressField.setText("");
        });

        // Main Layout
        setLayout(new BorderLayout());
        add(headerPanel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.WEST);
        add(tablePanel, BorderLayout.CENTER);
    }

    private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setForeground(new Color(34, 45, 65));
        return label;
    }

    private JTextField createStyledTextField() {
        JTextField textField = new JTextField(20);
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setBorder(BorderFactory.createLineBorder(new Color(34, 45, 65), 1));
        return textField;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(new Color(34, 139, 34));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return button;
    }
}
