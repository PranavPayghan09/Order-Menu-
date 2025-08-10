

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Order_menu {
    static ArrayList<String> cart = new ArrayList<>();
    static int totalCartBill = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Food Ordering System");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel title = new JLabel("Welcome to Delicious Bites!");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(Color.RED);

        JLabel categoryLabel = new JLabel("Select Category:");
        String[] categories = {"Pizza", "Pasta"};
        JComboBox<String> categoryBox = new JComboBox<>(categories);

        JLabel typeLabel = new JLabel("Select Type:");
        JComboBox<String> typeBox = new JComboBox<>();

        JLabel sizeLabel = new JLabel("Select Size:");
        JComboBox<String> sizeBox = new JComboBox<>();

        JLabel itemLabel = new JLabel("Select Item:");
        JComboBox<String> itemBox = new JComboBox<>();

        JLabel quantityLabel = new JLabel("Enter Quantity:");
        JTextField quantityField = new JTextField(5);

        JTextArea orderSummary = new JTextArea(10, 40);
        orderSummary.setEditable(false);
        orderSummary.setFont(new Font("Arial", Font.PLAIN, 14));
        orderSummary.setForeground(Color.BLUE);

        JButton addToCartButton = new JButton("Add to Cart");
        addToCartButton.setBackground(Color.ORANGE);
        addToCartButton.setForeground(Color.WHITE);

        JButton orderButton = new JButton("Place Order");
        orderButton.setBackground(Color.GREEN);
        orderButton.setForeground(Color.WHITE);

        categoryBox.addActionListener(e -> {
            typeBox.removeAllItems();
            if (categoryBox.getSelectedItem().equals("Pizza")) {
                typeBox.addItem("Veg");
                typeBox.addItem("Non-Veg");
            } else {
                typeBox.addItem("White Sauce");
                typeBox.addItem("Red Sauce");
            }
            typeBox.setSelectedIndex(0);
        });

        typeBox.addActionListener(e -> {
            sizeBox.removeAllItems();
            if (categoryBox.getSelectedItem().equals("Pizza")) {
                sizeBox.addItem("Small");
                sizeBox.addItem("Medium");
                sizeBox.addItem("Large");
            } else {
                sizeBox.addItem("Full Plate");
                sizeBox.addItem("Half Plate");
            }
            sizeBox.setSelectedIndex(0);
        });

        sizeBox.addActionListener(e -> {
            itemBox.removeAllItems();
            if (categoryBox.getSelectedItem().equals("Pizza")) {
                if (typeBox.getSelectedItem().equals("Veg")) {
                    itemBox.addItem("Corn & Cheese - ₹100");
                    itemBox.addItem("Farmhouse - ₹110");
                    itemBox.addItem("Margherita - ₹90");
                } else {
                    itemBox.addItem("Hot & Spicy Chicken - ₹149");
                    itemBox.addItem("Chicken Fiesta - ₹189");
                    itemBox.addItem("Tandoori Chicken - ₹229");
                }
            } else {
                if (typeBox.getSelectedItem().equals("White Sauce")) {
                    itemBox.addItem("Full Plate - ₹110");
                    itemBox.addItem("Half Plate - ₹60");
                } else {
                    itemBox.addItem("Full Plate - ₹130");
                    itemBox.addItem("Half Plate - ₹70");
                }
            }
            itemBox.setSelectedIndex(0);
        });

        addToCartButton.addActionListener(e -> {
            int quantity = Integer.parseInt(quantityField.getText());
            int price = Integer.parseInt(itemBox.getSelectedItem().toString().split("- ₹")[1].trim());
            int total = price * quantity;
            totalCartBill += total;
            String cartItem = categoryBox.getSelectedItem() + " | " + typeBox.getSelectedItem() + " | " + sizeBox.getSelectedItem() + " | " + itemBox.getSelectedItem() + " | Qty: " + quantity + " | ₹" + total;
            cart.add(cartItem);
            orderSummary.append(cartItem + "\n");
        });

        orderButton.addActionListener(e -> {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime deliveryTime = now.plus(1, ChronoUnit.HOURS);
            orderSummary.append("\nTotal Cart Bill: ₹" + totalCartBill + "\n");
            orderSummary.append("\nThank you for your order!\n");
            orderSummary.append("Delivery Expected at: " + deliveryTime);
        });

        frame.add(title);
        frame.add(categoryLabel);
        frame.add(categoryBox);
        frame.add(typeLabel);
        frame.add(typeBox);
        frame.add(sizeLabel);
        frame.add(sizeBox);
        frame.add(itemLabel);
        frame.add(itemBox);
        frame.add(quantityLabel);
        frame.add(quantityField);
        frame.add(addToCartButton);
        frame.add(orderButton);
        frame.add(new JScrollPane(orderSummary));

        categoryBox.setSelectedIndex(0);
        frame.setVisible(true);
    }
}
