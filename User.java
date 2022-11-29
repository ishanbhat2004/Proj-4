package Project;

/**
 * User
 *
 * has types: Customer, Seller
 * server
 *
 * @author Brice, lab LC03
 * @version Nov 15, 2022
 */
public class User {
    private String email;
    private String password;

    public User(String email, String password) { 
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
