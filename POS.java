package Assignment;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class POS implements Serializable {
    // Attributes

    private static final long serialVersionUID = 1L;
    private Map<String, Double> itemCodeToPrice; // Map to store item codes and their prices
    private Map<String, GroceryItem> itemCodeToItem;  // Map to store item codes and their corresponding GroceryItem objects
    private List<PendingBill> pendingBills;  // List to store pending bills


    // Constructor
    public POS() {
        itemCodeToPrice = new HashMap<>();
        itemCodeToItem = new HashMap<>();
        pendingBills = new ArrayList<>();
    }

    // Method to add an item to the POS system
    public void addItem(GroceryItem item, String itemCode) {
        itemCodeToPrice.put(itemCode, item.getPrice());
        itemCodeToItem.put(itemCode, item);
    }

    // Method to remove an item from the POS system

    public void removeItem(String itemCode) throws ItemCodeNotFound {
        if (!itemCodeToPrice.containsKey(itemCode)) {
            throw new ItemCodeNotFound("Item code not found: " + itemCode);
        }
        itemCodeToPrice.remove(itemCode);
        itemCodeToItem.remove(itemCode);
    }

    // Method to generate a bill for a customer

    public void generateBill(String cashier, String branchName, String customer, List<String> itemCodes, double discount) throws ItemCodeNotFound {
        List<GroceryItem> items = new ArrayList<>();
        double totalPrice = 0;
        for (String itemCode : itemCodes) {
            if (!itemCodeToPrice.containsKey(itemCode)) {
                throw new ItemCodeNotFound("Item code not found: " + itemCode);
            }
            items.add(itemCodeToItem.get(itemCode));
            totalPrice += itemCodeToPrice.get(itemCode);
        }
        double totalDiscount = totalPrice * discount;
        totalPrice -= totalDiscount;
        LocalDateTime date = LocalDateTime.now();
        PendingBill bill = new PendingBill(cashier, branchName, customer, items, totalDiscount, totalPrice, date);
        pendingBills.add(bill);
    }

    // Method to retrieve the list of pending bills

    public List<PendingBill> getPendingBills() {
        return pendingBills;
    }
    // Method to save the current state of the POS system to a file

    public void save(String fileName) {
        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(this);
            out.close();
            file.close();
            System.out.println("Serialized data is saved in " + fileName);
        } catch (IOException ex) {
            System.out.println("Error saving data to file: " + fileName);
            ex.printStackTrace();
        }
    }
    // Method to load the state of the POS system from a file

    public static POS load(String fileName) {
        POS pos = null;
        try {
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);
            pos = (POS) in.readObject();
            in.close();
            file.close();
            System.out.println("Serialized data is loaded from " + fileName);
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error loading data from file: " + fileName);
            ex.printStackTrace();
        }
        return pos;
    }
    // Method to retrieve the details of a specific item  (Given in the problem description)

    public GroceryItem getItemDetails() {
        try {
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);
            String itemCode = br.readLine();
            if (!itemCodeToItem.containsKey(itemCode)) {
                throw new ItemCodeNotFound("Item code not found: " + itemCode);
            }
            GroceryItem item = itemCodeToItem.get(itemCode);
            br.close();
            r.close();
            return item;
        } catch (IOException | ItemCodeNotFound e) {
            e.printStackTrace();
            return null;
        }
    }


}
