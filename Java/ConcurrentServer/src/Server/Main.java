package server;

/**
 * Simple server. Requests are answered in sequence.
 *
 * @author William
 */
public class Main {

    public static final String VERSION = "version 1" ;

    /**
     * One argument:
     *
     * 1. The number of the port
     *
     * @param args
     */
    public static void main(String[] args) {

        int port = 0 ;
        if (args.length == 1) {
            try {
                port = Integer.parseInt(args[0]) ;
            } catch (NumberFormatException e) {
                System.out.println("ERROR: server port number expected: " + args[0]) ;
                System.out.println(e.toString()) ;
                System.exit(1) ;
            }
        } else {
            System.out.println("server " + VERSION) ;
            System.out.println("One argument expected: server port") ;
            System.out.println("Run the program as: java -jar server.jar portNum") ;
            System.exit(1) ;
        }

        Server server = new Server(port) ;
        server.startServer() ;
    }

}
