package com.triobites.ui;

import com.triobites.models.Dish;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MenuFrame extends JFrame {

    private List<Dish> menuList;
    private JTable menuTable;
    private DefaultTableModel tableModel;

    public MenuFrame() {
        setTitle("Menu - Trio Bites");
        setSize(600, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        menuList = new ArrayList<>();
        
        menuList.add(Dish.FRENCHFRIES);
        menuList.add(Dish.BUFFALOWINGS);
        menuList.add(Dish.MOZZARELLASTICKS);
        menuList.add(Dish.SEAFOODPLATTER);
        menuList.add(Dish.BUTTERCHICKEN);
        menuList.add(Dish.ALFREDOPASTA);
        menuList.add(Dish.CHOCOLATEBROWNIES);
        menuList.add(Dish.ARABIANDELIGHT);
        menuList.add(Dish.KUNAFA);
        menuList.add(Dish.CLASSICMOJITO);
        menuList.add(Dish.WATERMELONSQUASH);
        menuList.add(Dish.COFFEE);

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(30, 58, 138));
        JLabel headerLabel = new JLabel("Menu");
        headerLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        headerLabel.setForeground(new Color(251, 191, 36));
        headerPanel.add(headerLabel);

        // Menu Table
        String[] columns = {"Dish Name", "Category", "Price"};
        tableModel = new DefaultTableModel(columns, 0);

        updateTable();

        menuTable = new JTable(tableModel);
        menuTable.setRowHeight(25);
        menuTable.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane tableScrollPane = new JScrollPane(menuTable);

        // Buttons Panel for Add, Delete, Update
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());

        JButton addButton = new JButton("Add Dish");
        addButton.setBackground(new Color(30, 58, 138));
        addButton.setForeground(new Color(251, 191, 36));
        addButton.addActionListener(e -> showAddDishDialog());

        JButton updateButton = new JButton("Update Dish");
        updateButton.setBackground(new Color(30, 58, 138));
        updateButton.setForeground(new Color(251, 191, 36));
        updateButton.addActionListener(e -> showUpdateDishDialog());

        JButton deleteButton = new JButton("Delete Dish");
        deleteButton.setBackground(new Color(30, 58, 138));
        deleteButton.setForeground(new Color(251, 191, 36));
        deleteButton.addActionListener(e -> deleteSelectedDish());

        buttonsPanel.add(addButton);
        buttonsPanel.add(updateButton);
        buttonsPanel.add(deleteButton);

        // Adding Components to Frame
        setLayout(new BorderLayout());
        add(headerPanel, BorderLayout.NORTH);
        add(tableScrollPane, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
    }

    private void updateTable() {
        // Clear the table before updating
        tableModel.setRowCount(0);

        // Add the updated menu list to the table
        for (Dish dish : menuList) {
            tableModel.addRow(new Object[]{dish.getName(), dish.getCategory(), dish.getPrice()});
        }
    }

    private void showAddDishDialog() {
        JTextField nameField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField priceField = new JTextField();

        Object[] message = {
            "Dish Name:", nameField,
            "Category:", categoryField,
            "Price:", priceField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Add New Dish", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String category = categoryField.getText();
            String priceStr = priceField.getText();

            if (name != null && category != null && priceStr != null) {
                try {
                    int price = Integer.parseInt(priceStr);
                    Dish newDish = new Dish(name, category, price);
                    menuList.add(newDish);
                    updateTable();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid price format!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void showUpdateDishDialog() {
        int selectedRow = menuTable.getSelectedRow();

        if (selectedRow >= 0) {
            Dish selectedDish = menuList.get(selectedRow);
            JTextField nameField = new JTextField(selectedDish.getName());
            JTextField categoryField = new JTextField(selectedDish.getCategory());
            JTextField priceField = new JTextField(String.valueOf(selectedDish.getPrice()));

            Object[] message = {
                "Dish Name:", nameField,
                "Category:", categoryField,
                "Price:", priceField
            };

            int option = JOptionPane.showConfirmDialog(this, message, "Update Dish", JOptionPane.OK_CANCEL_OPTION);

            if (option == JOptionPane.OK_OPTION) {
                String name = nameField.getText();
                String category = categoryField.getText();
                String priceStr = priceField.getText();

                if (name != null && category != null && priceStr != null) {
                    try {
                        int price = Integer.parseInt(priceStr);
                        Dish updatedDish = new Dish(name, category, price); // Create a new Dish object
                        menuList.set(selectedRow, updatedDish); // Replace old dish with new one
                        updateTable();
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Invalid price format!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a dish to update.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteSelectedDish() {
        int selectedRow = menuTable.getSelectedRow();

        if (selectedRow >= 0) {
            menuList.remove(selectedRow);
            updateTable();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a dish to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
