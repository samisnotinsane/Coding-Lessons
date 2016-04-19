package server;

import java.net.*;
import java.io.*;

/**
 * A server that accepts requests for a text file and sends them back.
 *
 * @author William
 * @version 1
 */
class Server {

    /**
     * Create a server that listens on port p
     *
     * @param p the port number
     */
    public Server(int p) {
        port = p ;
    }

    // the port
    private int port ;

    /**
     * Start the server. The server accepts connections on the specified socket number.
     * Each request has a file name on a line. The server reads the file
     * and sends it back, line by line. If the file does not exist, nothing
     * is returned.
     */
    public void startServer() {
        System.out.println("server started: " + Main.VERSION) ;
        try {
            ServerSocket s = new ServerSocket(port);

            // accept connections on this socket
            while (true) {
                System.out.println("Server running...");
                Socket temp = s.accept(); // blocks execution until a conn. is established
                System.out.println("Request accepted...");
                serveFile(temp) ;
            }
            // s.close() ;
        }
        catch (IOException e) {
            System.out.println("Exception in server:1") ;
            System.out.println(e.toString()) ;
        }
        System.out.println("Closing server...");
    }

    /**
     * Serve the file
     *
     * @param socket Socket to use - connection from client
     */
    private void serveFile(Socket socket) {
        BufferedReader socket_reader = null ;
        BufferedReader freader = null ;
        PrintWriter pwriter = null ;

        try {
            // Create a reader on the socket and read the file name
            socket_reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String filename = socket_reader.readLine(); // gets input from client

            // open the file and the printer writer
            freader = new BufferedReader(new FileReader(filename)) ;
            System.out.println("server: opened file name: " + filename) ;
            pwriter = new PrintWriter(socket.getOutputStream(), true) ;

            // read from the file
            int l = 0 ;
            String line = freader.readLine() ;
            while (line != null) {
                pwriter.println(line) ;
                 System.out.print(l + " ") ; l ++ ;
                line = freader.readLine() ;
            }
            System.out.println("server: Finished reading file " + filename);
            socket_reader.close();
            freader.close() ;
            pwriter.close() ;
            socket.close();

        } catch (Exception e) {
            System.out.println("Exception in server:2") ;
            System.out.println(e.toString()) ;
            try {
                // closing the socket causes the read in the client to complete
                if (socket_reader != null) socket_reader.close();
                if (freader != null) freader.close() ;
                if (pwriter != null) pwriter.close() ;
                if (socket != null) socket.close();
            } catch (Exception e1) {
                // give up
            }
        }
    }
}
