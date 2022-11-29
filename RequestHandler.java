package Project;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * RequestHandler
 *
 * handles String requests from client threads
 * and sends back responses 
 * server
 *
 * @author Brice, lab LC03
 * @version Nov 18, 2022
 */

public class RequestHandler implements Runnable {

    private Socket client;
    private DataInputStream in;
    private DataOutputStream out;

    boolean running = true;

    public RequestHandler(Socket client) {
        this.client = client;
    }
    
    @Override
    public void run() {
        // make input and output streams
        try {
            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // loop for requests
        do {
            // wait for request
            String request = "";
            try {
                request = in.readUTF();
                //print request with client info: "client: request"
                System.out.println(client.getInetAddress() + ": " + request);
            } catch (Exception e) {
                e.printStackTrace();
                request = "0";
            }

            // process request
            if (request.equals("0")){
                running = false;
            } else {
                String response = processRequest(request);
                // send response
                try {
                    out.writeUTF(response);
                } catch (Exception e) {
                    e.printStackTrace();
                } 
            }
        } while (running);
        
    }

    public static String processRequest(String input) {
        //no spaces meant to be in the input other than inside parameters labeled param
        // format: "s/c<id><requestNum><param1>...<paramN>" possibly just one param tho
        // s/c = seller/customer
        /* seller requests:

         */
        /* customer requests:
          
         */
        // one other possible format: "1/2s/c<email><password>"
        
        // 1/2 = sign up/log in
        // s/c = seller/customer

        switch (input.charAt(0)) {
            case '1':
                // sign up
                // format: "1s/c<email><password>"
                // return "1" if successful, "0" if not
                if (input.charAt(1) == 's') {
                    // make seller
                    Seller seller = new Seller(input.substring(input.indexOf('<') + 1, input.indexOf('>')), input.substring(input.lastIndexOf('<') + 1, input.lastIndexOf('>')));
                    return "1";
                } else {
                    // make customer
                    Customer customer = new Customer(input.substring(input.indexOf('<') + 1, input.indexOf('>')), input.substring(input.lastIndexOf('<') + 1, input.lastIndexOf('>')));
                    return "1";
                }
            case '2':
                // log in
                // format: "2<email><password>"
                // return "1" if successful, "0" if not
                // seller
                for (Seller seller : Seller.sellers) {
                    if (seller.getEmail().equals(input.substring(input.indexOf('<') + 1, input.indexOf('>'))) && seller.getPassword().equals(input.substring(input.lastIndexOf('<') + 1, input.lastIndexOf('>')))) {
                        return "1";
                    }
                }
                // customer
                for (Customer customer : Customer.customers) {
                    if (customer.getEmail().equals(input.substring(input.indexOf('<') + 1, input.indexOf('>'))) && customer.getPassword().equals(input.substring(input.lastIndexOf('<') + 1, input.lastIndexOf('>')))) {
                        return "1";
                    }
                }
                return "0";
            case 's':
                // seller request
                // format: "s id|request
                return "1";
            case 'c':
                // customer request
                // format: "c id|request
                return "1";
        }
        return "0";
            
    }
}
