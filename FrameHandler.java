package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * FrameHandler
 *
 * swaps between screens in app
 * client
 *
 * @author Brice, lab LC03
 * @version Nov 16, 2022
 */
public class FrameHandler {
    private JFrame frame;
    private JPanel panel;
    private JPanel loginView;
    private JPanel customerView;
    private JPanel sellerView;

    private String usualCharsAllow = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+-=,./?;':\"[]{}|\\`~";
    
    public FrameHandler() {
        frame = new JFrame("Banana Marketplace");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        loadPanels();

        panel = loginView;
        frame.add(panel);
        frame.setVisible(true);
        frame.revalidate();
    }
    
    public void swapPanel(JPanel panel) {
        frame.remove(this.panel);
        this.panel = panel;
        frame.add(this.panel);
        frame.revalidate();
        frame.repaint();
    }
    
    public void swapToLogin() {
        swapPanel(loginView);
    }
    
    public void swapToCustomer() {
        swapPanel(customerView);
    }
    
    public void swapToSeller() {
        swapPanel(sellerView);
    }

    public void loadPanels() {
        // construct loginView
        loginView = new JPanel(new GridLayout(1, 2));
        loginView.setBackground(Color.DARK_GRAY);
        // make a dual panel setup 
        // left panel has email textfield with password passwordfield under and login and sign up buttons under
        // right panel has logo and Welcome to Banana Marketplace
        JPanel loginLeftPanel = new JPanel(new GridLayout(3, 1));
        JPanel loginLeft = new JPanel();
        loginLeft.setBorder(BorderFactory.createLineBorder(Color.CYAN, 1, true));
        loginLeft.setLayout(new BoxLayout(loginLeft, BoxLayout.Y_AXIS));
        loginLeft.setBackground(Color.DARK_GRAY);
        JLabel emailLabel = new JLabel("Email", JLabel.LEFT);
        emailLabel.setForeground(Color.YELLOW);
        emailLabel.setAlignmentX(SwingConstants.LEFT);
        JTextField emailField = new JTextField(15);
        emailField.setPreferredSize(new Dimension(180, 30));
        emailField.setMaximumSize(new Dimension(emailField.getPreferredSize()));
        limitField(emailField, 245, usualCharsAllow);
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(Color.YELLOW);
        passwordLabel.setAlignmentX(SwingConstants.LEFT);
        JPasswordField passwordField = new JPasswordField(15);
        passwordField.setPreferredSize(emailField.getPreferredSize());
        passwordField.setMaximumSize(new Dimension(emailField.getPreferredSize()));
        // only allow 32 characters in password passwordField
        limitField(passwordField, 32, usualCharsAllow);

        JPanel loginButtons = new JPanel();
        loginButtons.setLayout(new BoxLayout(loginButtons, BoxLayout.X_AXIS));
        loginButtons.setBackground(Color.DARK_GRAY);
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(Color.DARK_GRAY);
        loginButton.setForeground(Color.CYAN);
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBackground(Color.DARK_GRAY);
        signUpButton.setForeground(Color.CYAN);
        loginButtons.add(loginButton);
        loginButtons.add(Box.createHorizontalStrut(5));
        loginButtons.add(signUpButton);

        loginLeft.add(emailLabel);
        loginLeft.add(emailField);
        loginLeft.add(Box.createVerticalStrut(5));
        loginLeft.add(passwordLabel);
        loginLeft.add(passwordField);
        loginLeft.add(loginButtons);

        JPanel fille = new JPanel();
        fille.setBackground(Color.DARK_GRAY);
        JPanel filler = new JPanel();
        filler.setBackground(Color.DARK_GRAY);
        loginLeftPanel.add(filler);
        loginLeftPanel.add(loginLeft);
        loginLeftPanel.add(fille);

        JPanel loginRight = new JPanel();
        loginRight.setLayout(new BoxLayout(loginRight, BoxLayout.X_AXIS));
        loginRight.setBackground(Color.DARK_GRAY);
        // make the welcome message "Welcome to the \n Banana Marketplace" bold with the "Banana" yellow with the rest of the text white
        JLabel welcomeMessage = new JLabel ("<html><center><b>Welcome to the<br>" +
            "<font color='yellow'>Banana &#127820;</font> <font color='aqua'>Marketplace</font></b></center></html>");
        welcomeMessage.setForeground(Color.WHITE);
        welcomeMessage.setFont(welcomeMessage.getFont().deriveFont(28.0f));
        loginRight.setBorder(BorderFactory.createBevelBorder(0, Color.CYAN, Color.YELLOW, Color.YELLOW, Color.CYAN));
        welcomeMessage.setHorizontalAlignment(SwingConstants.CENTER);
        // add the welcome message to the right panel in the center
        loginRight.add(Box.createHorizontalGlue());
        loginRight.add(welcomeMessage);
        loginRight.add(Box.createHorizontalGlue());

        loginView.add(loginLeftPanel);
        loginView.add(loginRight);

        //make button listeners for login and sign up buttons
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client.login(emailField.getText(), String.valueOf(passwordField.getPassword()));
                
            }
        });
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //if they contain letters not in usualCharsAllow, then dont allow them to sign up
                // if its empty, show invalid credentials error and return
                if (emailField.getText().equals("") || String.valueOf(passwordField.getPassword()).equals("")) {
                    JOptionPane.showMessageDialog(frame, "One or more fields are empty!", "Invalid Credentials", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                JPanel cSignUp = new JPanel();
                cSignUp.setLayout(new BoxLayout(cSignUp, BoxLayout.Y_AXIS));
                cSignUp.setBackground(Color.DARK_GRAY);
                cSignUp.setBorder(BorderFactory.createLineBorder(Color.CYAN, 1, true));
                JLabel cartLabel = new JLabel("<html><center><b>&#xf07a;</b></center></html>");
                cartLabel.setFont(cartLabel.getFont().deriveFont(72.0f));
                cartLabel.setForeground(Color.CYAN);
                cartLabel.setHorizontalAlignment(SwingConstants.CENTER);
                JLabel customerSignUpLabel = new JLabel("<html><center><b>Customer Sign Up</b>" + 
                    "<br>you are seeking to buy bananas</center></html>");
                customerSignUpLabel.setFont(customerSignUpLabel.getFont().deriveFont(20.0f));
                customerSignUpLabel.setForeground(Color.CYAN);
                customerSignUpLabel.setHorizontalAlignment(SwingConstants.CENTER);
                cSignUp.add(Box.createVerticalGlue());
                cSignUp.add(cartLabel);
                cSignUp.add(Box.createVerticalStrut(5));
                cSignUp.add(customerSignUpLabel);
                cSignUp.add(Box.createVerticalGlue());
                
                JPanel sSignUp = new JPanel();
                sSignUp.setLayout(new BoxLayout(sSignUp, BoxLayout.Y_AXIS));
                sSignUp.setBackground(Color.DARK_GRAY);
                sSignUp.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 1, true));
                JLabel tagLabel = new JLabel("<html><center><b>&#xf02b;</b></center></html>");
                tagLabel.setFont(tagLabel.getFont().deriveFont(72.0f));
                tagLabel.setForeground(Color.YELLOW);
                tagLabel.setHorizontalAlignment(SwingConstants.CENTER);
                JLabel sellerSignUpLabel = new JLabel("<html><center><b>Seller Sign Up</b>" +
                    "<br>you are seeking to sell bananas</center></html>");
                sellerSignUpLabel.setFont(sellerSignUpLabel.getFont().deriveFont(20.0f));
                sellerSignUpLabel.setForeground(Color.YELLOW);
                sellerSignUpLabel.setHorizontalAlignment(SwingConstants.CENTER);
                sSignUp.add(Box.createVerticalGlue());
                sSignUp.add(tagLabel);
                sSignUp.add(Box.createVerticalStrut(5));
                sSignUp.add(sellerSignUpLabel);
                sSignUp.add(Box.createVerticalGlue());

                //add action listeners to the customer and seller sign up panels
                cSignUp.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        cSignUp.setBackground(Color.CYAN);
                        cartLabel.setForeground(Color.DARK_GRAY);
                        customerSignUpLabel.setForeground(Color.DARK_GRAY);

                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        cSignUp.setBackground(Color.DARK_GRAY);
                        cartLabel.setForeground(Color.CYAN);
                        customerSignUpLabel.setForeground(Color.CYAN);
                    }
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        Client.signUp(emailField.getText(), String.valueOf(passwordField.getPassword()), 'c');
                    }
                });
                sSignUp.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        sSignUp.setBackground(Color.YELLOW);
                        tagLabel.setForeground(Color.DARK_GRAY);
                        sellerSignUpLabel.setForeground(Color.DARK_GRAY);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        sSignUp.setBackground(Color.DARK_GRAY);
                        tagLabel.setForeground(Color.YELLOW);
                        sellerSignUpLabel.setForeground(Color.YELLOW);
                    }
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        Client.signUp(emailField.getText(), String.valueOf(passwordField.getPassword()), 's');
                    }
                });
                // pace interaction to increase understanding (wait 1 second before showing the sign up options)

                loginView.removeAll();
                loginView.add(cSignUp);
                loginView.add(sSignUp);
                loginView.revalidate();
                loginView.repaint();
            }
        });
    }

    // limit to number of characters
    // limit to certain characters
    private void limitField(JTextField textField, int maxChars, String allowedChars) {
        textField.setTransferHandler(null);
        textField.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // disallow pasting
                if (textField.getText().length() >= maxChars 
                    || !allowedChars.contains(String.valueOf(c)) 
                    && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) { // no
            }
            @Override
            public void keyReleased(KeyEvent e) { // no
            }
        });

    }

    // static close method
    public void close() {
        frame.dispose();
    }
    
}
