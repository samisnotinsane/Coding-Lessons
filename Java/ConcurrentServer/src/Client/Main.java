
package client;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Main program for the client.
 *
 * @author William
 */
public class Main {

    public static final String VERSION = "version 1" ;

    /**
     * The arguments are:
     *
     *   1. server_ip_address (or localhost)
     *   2. service_port_number
     *   3. client_name
     *
     * @param args
     */
    public static void main(String[] args) {
        if (args.length == 3) {
            String clientName = args[2] ;
            int port = 0 ;
            try {
                port = Integer.parseInt(args[1]) ;
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Server port number expected: " + args[1]) ;
                System.out.println(e.toString()) ;
                System.exit(1) ;
            }
            InetAddress ip = checkIP(args[0]) ;
            // System.out.println(ip.toString()) ;

            Client c = new Client(ip, port, clientName) ;
            c.start() ;
        } else {
            System.out.println("Client " + VERSION) ;
            System.out.println("Three arguments expected: server ip, server port, client name") ;
            System.out.println("Run the program as: java -jar Client.jar N.N.N.N portNum client_name") ;
            System.exit(1) ;
        }
    }

    /**
     * Parse and check an IP address
     *
     * @param theArg The argument string
     * @return An IP address object
     */
    static InetAddress checkIP(String theArg) {
        if (theArg.equals("localhost")) {
            byte[] local = {127,0,0,1} ;
            try {
                return InetAddress.getByAddress(local);
            } catch (UnknownHostException ex) {
                System.out.println("ERROR: Server IP local host address error") ;
                System.out.println(ex.toString()) ;
                System.exit(1) ;
            }
        }

        // not local host
        String[] bytes = theArg.split("\\.") ;
        if (bytes.length == 4) {
            try {
                byte[] b = new byte[4];
                for (int i = 0; i < 4; i++) {
                    int n = Integer.parseInt(bytes[i]) ;
                    if (n >= 0 && n < 128) {
                        b[i] = (byte) n ;
                    } else if (n>=128 && n < 255) {
                        b[i] = (byte) (n-256) ;
                    } else {
                        System.out.println("ERROR: Server IP address range: "
                                + bytes[i]) ;
                        System.exit(1) ;
                    }
                }
                return InetAddress.getByAddress(b);
            } catch (UnknownHostException ex) {
                System.out.println("ERROR: Server IP address format error") ;
                System.out.println(ex.toString()) ;
                System.exit(1) ;
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Server IP numbers expected") ;
                System.out.println(e.toString()) ;
                System.exit(1) ;
            }
        } else {
            System.out.println("ERROR: Server IP format must be N.N.N.N for numbers N") ;
            System.exit(1) ;
        }
        return null ;
    }

}
