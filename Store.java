package Project;

import java.util.ArrayList;

/**
 * Store
 *
 * contains products 
 * owned by a seller
 * server
 *
 * @author Brice, lab LC03
 * @version Nov 15, 2022
 */

public class Store {
    private String name;
    private Seller seller;
    private ArrayList<Product> products;
    
    public Store(String name, String description, Seller seller) {
        this.name = name;
        this.seller = seller;
        this.products = new ArrayList<Product>();
    }
    
    public void addProduct(Product product) {
        this.products.add(product);
    }
    
    public void updateProduct(Product product) {
        //maybe put in product class
    }
    
    public ArrayList<Product> getProducts() {
        return this.products;
    }
    
    public String getName() {
        return this.name;
    }
    
    public Seller getSeller() {
        return this.seller;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setSeller(Seller seller) {
        this.seller = seller;
    }
    
    public String toString() {
        return this.name + " - owned by" + this.seller;
    }
    
}
