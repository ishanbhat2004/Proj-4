package Project;

import java.util.ArrayList;

/**
 * Customer
 *
 * type of user
 * server
 *
 * @author Brice, lab LC03
 * @version Nov 15, 2022
 */

public class Customer extends User {
    public static ArrayList<Customer> customers = new ArrayList<Customer>();
    private double balance;
    private ArrayList<CartItem> cart;
    private ArrayList<CartItem> purchasedItems;

    public Customer(String email, String password, double balance, ArrayList<CartItem> cart, ArrayList<CartItem> purchasedItems) { // to import users
        super(email, password);
        this.balance = balance;
        this.cart = cart;
        this.purchasedItems = purchasedItems;
        customers.add(this);
    }

    public Customer(String email, String password) {
        super(email, password);
        this.balance = 0;
        this.cart = new ArrayList<CartItem>();
        this.purchasedItems = new ArrayList<CartItem>();
        customers.add(this);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<CartItem> getCart() {
        return cart;
    }

    public void setCart(ArrayList<CartItem> cart) {
        this.cart = cart;
    }

    public ArrayList<CartItem> getPurchasedItems() {
        return purchasedItems;
    }

    public void setPurchasedItems(ArrayList<CartItem> purchasedItems) {
        this.purchasedItems = purchasedItems;
    }

}
