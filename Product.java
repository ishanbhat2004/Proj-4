package Project;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Product
 *
 * contains information about a product
 * in a store owned by a seller
 * sales stat now included - to make things easier 
 * server
 *
 * @author Brice, lab LC03
 * @version Nov 15, 2022
 */

public class Product {
    private int id;
    public static AtomicInteger nextPId = new AtomicInteger(0);
    private String name;
    private double price;
    private int quantity;
    private int sales;
    private String description;
    private Store store;
    private Seller seller;
    boolean available;

    public Product(String name, double price, int quantity, String description, Store store, Seller seller) {
        this.id = nextPId.getAndIncrement();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.sales = 0;
        this.description = description;
        this.store = store;
        this.seller = seller;
        this.available = true;
    }

    // overload constructor without store and seller but with sales and available - for importing products
    public Product(int id, String name, double price, int quantity, String description, int sales, boolean available) { //store and seller need to be set when importing sellers
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.sales = sales;
        this.available = available;
    }

    public void setNextPId(int id) {
        nextPId.set(id);
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSales() {
        return this.sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Store getStore() {
        return this.store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Seller getSeller() {
        return this.seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public boolean getAvailable() {
        return this.available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}