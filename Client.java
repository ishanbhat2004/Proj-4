package Project;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Client
 *
 * client access to app
 *
 * @author Brice, lab LC03
 * @version Nov 15, 2022
 */

public class Client implements Runnable {
    private FrameHandler frameHandler;
    private static Socket socket;
    private static InputStream in;
    private static OutputStream out;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Client());
        
    }

    @Override
    public void run() {
        frameHandler = new FrameHandler();
        //connect to server
        boolean retry = false;
        boolean connected = false;
        do {
            try {
                socket = new Socket("localhost", 1974);
                in = socket.getInputStream();
                out = socket.getOutputStream();
                connected = true;
            } catch (Exception e) {
                // display error message on 
                retry = retryServerError();
                e.printStackTrace();
            }
        } while (retry);
        if (!connected) {
            frameHandler.close();
        }
    }

    public static void signUp(String email, String password, char userType) {
        // send request to server format: "1s/c<email><password>" using out
        try {
            out.write(("1" + userType + "<" + email + "><" + password + ">").getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } 
        // wait for response
        String response = "";
        try {
            response = new String(in.readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
            serverError();
        }

    }

    public static void login(String email, String password) {
        // send

    }

    public static boolean retryServerError() {
        // display error message on option pane
        int result = JOptionPane.showConfirmDialog(null, "Could not connect to server. Would you like to retry?", "Server Error", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }

    public static void serverError() {
        // display error message on option pane
        JOptionPane.showMessageDialog(null, "Could not connect to server.", "Server Error", JOptionPane.ERROR_MESSAGE);
    }

}


