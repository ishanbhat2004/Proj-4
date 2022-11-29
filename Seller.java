package Project;

import java.util.ArrayList;

/**
 * Seller
 *
 * type of user
 * server
 * 
 * @author Brice, lab LC03
 * @version Nov 15, 2022
 */
public class Seller extends User {
    public static ArrayList<Seller> sellers = new ArrayList<Seller>();
    private ArrayList<Store> stores;

    public Seller(String email, String password, ArrayList<Store> stores) { // to import users
        super(email, password);
        this.stores = stores;
        sellers.add(this);
    }

    public Seller(String email, String password) {
        super(email, password);
        this.stores = new ArrayList<Store>();
        sellers.add(this);
    }

    public ArrayList<Store> getStores() {
        return stores;
    }

    public void setStores(ArrayList<Store> stores) {
        this.stores = stores;
    }

    public void addStore(Store store) {
        this.stores.add(store);
    }

    public void removeStore(Store store) {
        this.stores.remove(store);
    }
    
}
