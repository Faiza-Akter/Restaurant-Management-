package com.triobites.ui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private BillingFrame billingFrame;

    private enum MainButton {
        MENU("View Menu"),
        ORDER("Place Order"),
        BILLING("Billing"),
        INFO("Customer Info");

        private final String label;

        MainButton(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

    public MainFrame() {
        setTitle("Trio Bites - Restaurant Management");
        setSize(1205, 610); // Increased frame size for better spacing
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame
        setLayout(new BorderLayout());

        billingFrame = new BillingFrame();

        // Header Panel with Trio Bites Label
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(new Color(30, 58, 138));
        headerPanel.setPreferredSize(new Dimension(700, 100));

        JLabel titleLabel = new JLabel("Trio Bites");
        titleLabel.setForeground(new Color(251, 191, 36));
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        headerPanel.add(titleLabel);

        // Center Panel for Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2, 20, 20));
        buttonPanel.setBackground(new Color(249, 250, 251));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        // Add Buttons using Enum
        for (MainButton button : MainButton.values()) {
            JButton jButton = createStyledButton(button.getLabel());
            jButton.addActionListener(e -> handleButtonAction(button));
            buttonPanel.add(jButton);
        }

        // Footer Panel
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(30, 58, 138));
        footerPanel.setPreferredSize(new Dimension(700, 50));

        JLabel footerLabel = new JLabel("Powered by Trio Bites Team");
        footerLabel.setForeground(new Color(249, 250, 251));
        footerLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        footerPanel.add(footerLabel);

        // Adding Panels to Frame
        add(headerPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);
    }

    private void handleButtonAction(MainButton button) {
        switch (button) {
            case MENU:
                new MenuFrame().setVisible(true);
                break;
            case ORDER:
                new OrderFrame(billingFrame::addOrder).setVisible(true);
                break;
            case BILLING:
                billingFrame.setVisible(true);
                break;
            case INFO:
                new InfoSaveFrame().setVisible(true);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + button);
        }
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setBackground(new Color(251, 191, 36));
        button.setForeground(new Color(30, 58, 138));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(new Color(30, 58, 138), 2));
        button.setPreferredSize(new Dimension(150, 50)); // Standard button size
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true)); // Launch LoginFrame instead
    }
}
