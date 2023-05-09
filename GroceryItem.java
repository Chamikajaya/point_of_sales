package Assignment;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

class ItemCodeNotFound extends Exception {  // Custom exception handler
    public ItemCodeNotFound(String errorMessage) {
        super(errorMessage);
    }
}


public class GroceryItem implements Serializable {
    // Attributes
    private static final long serialVersionUID = 1L;
    private String itemName;
    private double itemPrice;
    private double itemWeight;
    private Date dateOfManufacture;
    private Date dateOfExpiry;
    private String manufacturerName;
    // Constructor
    public GroceryItem(String name, double price, double weight, Date manufactureDate, Date expiryDate, String manufacturer) {
        itemName = name;
        itemPrice = price;
        itemWeight = weight;
        dateOfManufacture = manufactureDate;
        dateOfExpiry = expiryDate;
        manufacturerName = manufacturer;
    }
    // getters
    public String getName() {
        return itemName;
    }

    public double getPrice() {
        return itemPrice;
    }

    public double getWeight() {
        return itemWeight;
    }

    public Date getManufactureDate() {
        return dateOfManufacture;
    }

    public Date getExpiryDate() {
        return dateOfExpiry;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }
    // to display information
    @Override
    public String toString() {
        return itemName + "\t" + itemPrice + "\t" + itemWeight + "\t" + dateOfManufacture + "\t" + dateOfExpiry + "\t" + manufacturerName;
    }
}


