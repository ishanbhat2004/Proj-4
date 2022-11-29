
/**
 * CartItem
 *
 * makes storing Products to cart
 * way easier
 * server
 * 
 * @author Brice, lab LC03
 * @version Nov 15, 2022
 */
package Project;
public class CartItem {
    private Product product;
    private int quantity;
    private double price;
    private double total;
    private boolean bought;
    
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.price = product.getPrice();
        this.total = this.price * this.quantity;
    }

    // overload constructor for importing cart items
    public CartItem(Product product, int quantity, double price, double total, boolean bought) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
        this.bought = bought;
    }
    
    public Product getProduct() {
        return product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public double updateTotal() {
        //if it is bought then dont update total
        if (this.bought) {
            return this.total;
        }
        this.price = this.product.getPrice();
        this.total = this.price * this.quantity;
        return this.total;
    }
    
    public String toString() {
        return "Product: " + this.product.getName() + " Quantity: " + this.quantity + " Price: " + this.price + " Total: " + this.total;
    }
    
}
