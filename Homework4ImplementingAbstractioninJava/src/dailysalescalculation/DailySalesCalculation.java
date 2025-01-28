package dailysalescalculation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Abstract class for items
abstract class Item {
    protected String itemName;
    protected double price;

    public Item(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }

    public abstract double calculateTotal();
}

// Class for phones
class Phone extends Item {
    private int quantitySold;

    public Phone(String itemName, double price, int quantitySold) {
        super(itemName, price);
        this.quantitySold = quantitySold;
    }

    @Override
    public double calculateTotal() {
        return price * quantitySold;
    }
}

// Class for repair services
class Repair extends Item {
    private int hours;

    public Repair(String itemName, double price, int hours) {
        super(itemName, price);
        this.hours = hours;
    }

    @Override
    public double calculateTotal() {
        return price * hours;
    }
}

public class DailySalesCalculation {

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Daily Sales Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create panels
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));

        // Phone input fields
        JLabel phoneLabel = new JLabel("Phones - Price (₱):");
        JTextField phonePriceField = new JTextField("");
        JLabel phoneQuantityLabel = new JLabel("Quantity Sold:");
        JTextField phoneQuantityField = new JTextField("");

        // Repair input fields
        JLabel repairLabel = new JLabel("Repair - Price per Hour (₱):");
        JTextField repairPriceField = new JTextField("");
        JLabel repairHoursLabel = new JLabel("Number of Hours:");
        JTextField repairHoursField = new JTextField("");

        // Output fields
        JLabel phoneTotalLabel = new JLabel("Total Sales for Phones (₱):");
        JLabel phoneTotalOutput = new JLabel("0.0");
        JLabel repairTotalLabel = new JLabel("Total Sales for Repairs (₱):");
        JLabel repairTotalOutput = new JLabel("0.0");

        // Calculate button
        JButton calculateButton = new JButton("Calculate Total Sales");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Parse input for phones
                    double phonePrice = Double.parseDouble(phonePriceField.getText());
                    int phoneQuantity = Integer.parseInt(phoneQuantityField.getText());

                    // Parse input for repair services
                    double repairPrice = Double.parseDouble(repairPriceField.getText());
                    int repairHours = Integer.parseInt(repairHoursField.getText());

                    // Create items
                    Phone phone = new Phone("Phone", phonePrice, phoneQuantity);
                    Repair repair = new Repair("Repair", repairPrice, repairHours);

                    // Calculate totals
                    double phoneTotal = phone.calculateTotal();
                    double repairTotal = repair.calculateTotal();

                    // Display totals
                    phoneTotalOutput.setText(String.format("₱%.2f", phoneTotal));
                    repairTotalOutput.setText(String.format("₱%.2f", repairTotal));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add components to panel
        panel.add(phoneLabel);
        panel.add(phonePriceField);
        panel.add(phoneQuantityLabel);
        panel.add(phoneQuantityField);
        panel.add(repairLabel);
        panel.add(repairPriceField);
        panel.add(repairHoursLabel);
        panel.add(repairHoursField);
        panel.add(phoneTotalLabel);
        panel.add(phoneTotalOutput);
        panel.add(repairTotalLabel);
        panel.add(repairTotalOutput);

        // Add panel and button to frame
        frame.add(panel, BorderLayout.CENTER);
        frame.add(calculateButton, BorderLayout.SOUTH);

        // Set frame visibility
        frame.setVisible(true);
    }
}