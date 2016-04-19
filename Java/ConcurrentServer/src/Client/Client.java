
package client;

import java.net.*;
import java.io.*;

/**
 * Class client
 *
 * Prompt the user to read the name of a file and request it from the
 * server. Continue until the user enters a blank string.
 *
 * @author William
 */
public class Client {

    private String name ;
    private InetAddress serverIP ;
    private int port ;

    public Client(InetAddress ip, int port, String n) {
        name = n ;
        this.port = port ;
        serverIP = ip ;
    }

    public void start() {
        String fname ;
        boolean finished = false ;

        System.out.println(name + " is running. client " + Main.VERSION) ;
        while (!finished) {
            fname = getFilename();
            if (fname != null && fname.length() > 0) {
                System.out.println("--------------------------------------") ;
                System.out.println(name + " requesting filename: " + fname) ;
                System.out.println("--------------------------------------") ;
                requestFile(fname) ;
            } else {
                finished = true ;
            }
        }
        System.out.println(name + " is stopping") ;
    }

    private void requestFile(String fname) {
        try {
            Socket s = new Socket(serverIP, port);

            // open the streams
            PrintWriter p = new PrintWriter(s.getOutputStream(), true);
            BufferedReader r = new BufferedReader (new InputStreamReader(s.getInputStream())) ;

            // send the request
            p.println(fname) ;
            // System.out.println(name + ": File request sent: " + fname) ;

            // read the reply and print it line by line
            String line = r.readLine() ;
            while (line != null) {
                System.out.println(name + ": " + line) ;
                line = r.readLine() ;
            }
            p.close();
            r.close();
            s.close();
        } catch (Exception e) {
            System.out.println(name + " I/O error") ;
            System.out.println(e.toString()) ;
        }
    }

    private String getFilename() {
        String fname = null ;

        BufferedReader b = new BufferedReader(new InputStreamReader(System.in)) ;
        System.out.print("Enter the file name>") ;
        try {
            fname = b.readLine();
            System.out.println("Looking for file: '"+fname+"'...");
        }
        catch (IOException e) {
            System.out.println(name + " error getting filename") ;
            System.out.println(e.toString()) ;
        }

        return fname ;
    }
}
