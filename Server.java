package Project;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server
 *
 * uh oh
 * 
 *
 * @author Brice, lab LC03
 * @version Nov 18, 2022
 */
public class Server {
    private static boolean open = true;
    private static ServerSocket serverSocket;
    public static void main(String[] args) {
        try {
            //make a local socket
            serverSocket = new ServerSocket(1974);
            //loop for connections
            do {
                //wait for a connection
                Socket socket = serverSocket.accept();
                System.out.println("Connection made");

                //make a thread to handle the connection
                RequestHandler handler = new RequestHandler(socket);
                handler.run();
            } while (open);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
