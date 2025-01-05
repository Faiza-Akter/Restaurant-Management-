package com.triobites.models;

import java.io.Serializable;

public class Dish implements Serializable {

    private String name;
    private String category;
    private int price;

    // Constructor
    public Dish(String name, String category, int price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Static predefined dishes
    public static final Dish FRENCHFRIES = new Dish("French Fries", "Appetizer", 200);
    public static final Dish BUFFALOWINGS = new Dish("Buffalo Wings", "Appetizer", 350);
    public static final Dish MOZZARELLASTICKS = new Dish("Mozzarella Sticks", "Appetizer", 450);
    public static final Dish SEAFOODPLATTER = new Dish("Seafood Platter", "Main", 1000);
    public static final Dish BUTTERCHICKEN = new Dish("Butter Chicken", "Main", 350);
    public static final Dish ALFREDOPASTA = new Dish("Alfredo Pasta", "Main", 400);
    public static final Dish CHOCOLATEBROWNIES = new Dish("Chocolate Brownies", "Sweet", 350);
    public static final Dish ARABIANDELIGHT = new Dish("Arabian Delight", "Sweet", 550);
    public static final Dish KUNAFA = new Dish("Kunafa", "Sweet", 500);
    public static final Dish CLASSICMOJITO = new Dish("Classic Mojito", "Drink", 280);
    public static final Dish WATERMELONSQUASH = new Dish("Watermelon Squash", "Drink", 280);
    public static final Dish COFFEE = new Dish("Coffee", "Drink", 120);
    

    // Getters
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    // Setters for updating the dish
    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // Overriding toString() for better display of dish details
    @Override
    public String toString() {
        return String.format("%s (%s) - %d BDT", name, category, price);
    }
}
