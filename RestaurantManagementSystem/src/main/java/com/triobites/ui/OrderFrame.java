package com.triobites.ui;

import com.triobites.models.Dish;
import com.triobites.models.Order;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.function.Consumer;

public class OrderFrame extends JFrame {

    private Consumer<Order> onOrderPlaced;

    public OrderFrame(Consumer<Order> onOrderPlaced) {
        this.onOrderPlaced = onOrderPlaced;

        setTitle("Place Order - Trio Bites");
        setSize(500, 400); // Increased size for better spacing
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center frame on screen

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(30, 58, 138));
        headerPanel.setPreferredSize(new Dimension(500, 80));
        JLabel headerLabel = new JLabel("Place Order");
        headerLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
        headerLabel.setForeground(new Color(251, 191, 36));
        headerPanel.add(headerLabel);

        // Order Details Panel
        JPanel orderPanel = new JPanel();
        orderPanel.setLayout(new GridBagLayout());
        orderPanel.setBackground(new Color(30, 58, 138));
        orderPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel dishLabel = createStyledLabel("Dish:");

        // Here, we're dynamically creating the dish list
        Dish frenchFries = new Dish("French Fries", "Appetizer", 200);
        Dish buffaloWings = new Dish("Buffalo Wings", "Appetizer", 350);
        Dish mozzarellaSticks = new Dish("Mozzarella Sticks", "Appetizer", 450);
        Dish seafoodPlatter = new Dish("Seafood Platter", "Main", 1000);
        Dish butterChicken = new Dish("Butter Chicken", "Main", 350);
        Dish alfredoPasta = new Dish("Alfredo Pasta", "Main", 400);
        Dish chocolateBrownies = new Dish("Chocolate Brownies", "Sweet", 350);
        Dish arabianDelight = new Dish("Arabian Delight", "Sweet", 550);
        Dish kunafa = new Dish("Kunafa", "Sweet", 500);
        Dish classicMojito = new Dish("Classic Mojito", "Drink", 280);
        Dish watermelonSquash = new Dish("Watermelon Squash", "Drink", 280);
        Dish coffee = new Dish("Coffee", "Drink", 120);

        Dish[] dishes = {frenchFries, buffaloWings, mozzarellaSticks, seafoodPlatter,butterChicken,alfredoPasta,
            chocolateBrownies,arabianDelight,kunafa,classicMojito,watermelonSquash,coffee};
        JComboBox<Dish> dishComboBox = new JComboBox<>(dishes);
        dishComboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        dishComboBox.setPreferredSize(new Dimension(200, 30));

        JLabel quantityLabel = createStyledLabel("Quantity:");
        JSpinner quantitySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        quantitySpinner.setFont(new Font("Arial", Font.PLAIN, 14));
        quantitySpinner.setPreferredSize(new Dimension(200, 30));

        JButton placeOrderButton = createStyledButton("Place Order");
        placeOrderButton.addActionListener(e -> {
            Dish selectedDish = (Dish) dishComboBox.getSelectedItem();
            int quantity = (int) quantitySpinner.getValue();

            Order order = new Order(selectedDish, quantity, new Date());
            onOrderPlaced.accept(order); // Pass order to BillingFrame
            JOptionPane.showMessageDialog(this, "Order placed successfully!");
            dispose();
        });

        // Adding Components to the GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        orderPanel.add(dishLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        orderPanel.add(dishComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        orderPanel.add(quantityLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        orderPanel.add(quantitySpinner, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        orderPanel.add(placeOrderButton, gbc);

        // Adding Components to Frame
        setLayout(new BorderLayout());
        add(headerPanel, BorderLayout.NORTH);
        add(orderPanel, BorderLayout.CENTER);
    }

    private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setForeground(new Color(251, 191, 36));
        return label;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(new Color(251, 191, 36));
        button.setForeground(new Color(30, 58, 138));
        button.setBorder(BorderFactory.createLineBorder(new Color(30, 58, 138), 2));
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(150, 40));
        return button;
    }
}
