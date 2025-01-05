package com.triobites.models;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    private Dish dish;
    private int quantity;
    private Date orderDate;

    public Order(Dish dish, int quantity, Date orderDate) {
        this.dish = dish;
        this.quantity = quantity;
        this.orderDate = orderDate;
    }

    public Dish getDish() {
        return dish;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public int calculateTotal() {
        return dish.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return String.format("Order: %s, Quantity: %d, Date: %s, Total: %d BDT",
                dish, quantity, orderDate, calculateTotal());
    }
}
