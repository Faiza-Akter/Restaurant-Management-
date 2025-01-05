package com.triobites.models;

import java.io.*;
import java.util.List;

public class SerializationHelper {

    public static void saveOrdersToFile(List<Order> orders, String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(orders);
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Order> loadOrdersFromFile(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<Order>) ois.readObject();
        }
    }
}
