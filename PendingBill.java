package Assignment;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

class PendingBill implements Serializable {
    // Attributes
    private static final long serialVersionUID = 1L;
    private String cashierName;
    private String branch;
    private String customerName;
    private List<GroceryItem> itemList;
    private double totalDiscount;
    private double totalPrice;
    private LocalDateTime dateAndTime;

    //Constructor
    public PendingBill(String cashier, String branchName, String customer, List<GroceryItem> items, double discount, double price, LocalDateTime date) {
        cashierName = cashier;
        branch = branchName;
        customerName = customer;
        itemList = items;
        totalDiscount = discount;
        totalPrice = price;
        dateAndTime = date;
    }
    // Getters
    public String getCashierName() {
        return cashierName;
    }

    public String getBranch() {
        return branch;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<GroceryItem> getItemList() {
        return itemList;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }
    //  To display information, I override the toString method
    public String toString() {
        String str = "Cashier: " + cashierName + "\nBranch: " + branch + "\nCustomer: " + customerName + "\nItem List:\n";
        for (GroceryItem item : itemList) {
            str += item + "\n";
        }
        str += "Total Discount: " + totalDiscount + "\nTotal Price: " + totalPrice + "\nDate and Time: " + dateAndTime + "\n";
        return str;
    }
}
