package com.triobites.ui;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        setTitle("Trio Bites - Login");
        setSize(450, 350); // Increased size for a spacious layout
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame
        setLayout(new BorderLayout());

        // Header Panel
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(new Color(30, 58, 138));
        headerPanel.setPreferredSize(new Dimension(450, 60));

        JLabel titleLabel = new JLabel("Welcome To Trio Bites");
        titleLabel.setForeground(new Color(251, 191, 36));
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
        headerPanel.add(titleLabel);

        // Center Panel for Login Form
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null); // Absolute layout for precise positioning
        formPanel.setBackground(new Color(249, 250, 251));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Username Label and Field
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        usernameLabel.setForeground(new Color(30, 58, 138));
        usernameLabel.setBounds(50, 40, 120, 25);

        JTextField usernameField = new JTextField();
        usernameField.setFont(new Font("Arial", Font.PLAIN, 16));
        usernameField.setBounds(180, 40, 200, 30);
        usernameField.setBorder(BorderFactory.createLineBorder(new Color(30, 58, 138), 2));

        // Password Label and Field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 18));
        passwordLabel.setForeground(new Color(30, 58, 138));
        passwordLabel.setBounds(50, 90, 120, 25);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordField.setBounds(180, 90, 200, 30);
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(30, 58, 138), 2));

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 18));
        loginButton.setBackground(new Color(251, 191, 36));
        loginButton.setForeground(new Color(30, 58, 138));
        loginButton.setBounds(150, 150, 150, 40);
        loginButton.setFocusPainted(false);
        loginButton.setBorder(BorderFactory.createLineBorder(new Color(30, 58, 138), 2));
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Add Action Listener for Login Button
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Check username and password
            if ("Triobites".equals(username) && "12345".equals(password)) {
                JOptionPane.showMessageDialog(this, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose(); // Close the login frame
                SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true)); // Open MainFrame
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Add components to the form panel
        formPanel.add(usernameLabel);
        formPanel.add(usernameField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);
        formPanel.add(loginButton);

        // Footer Panel
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        footerPanel.setBackground(new Color(30, 58, 138));
        footerPanel.setPreferredSize(new Dimension(450, 40));

        JLabel footerLabel = new JLabel("Powered by Trio Bites Team");
        footerLabel.setForeground(new Color(249, 250, 251));
        footerLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        footerPanel.add(footerLabel);

        // Adding Panels to Frame
        add(headerPanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}
