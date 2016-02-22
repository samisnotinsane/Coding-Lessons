import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by sameenislam on 03/02/2016.
 */
public class Main {

    private Connection c = null;
    Statement stmt = null;

    public static void main(String[] args) throws Exception {
        connectToAndQueryDatabase();
        System.out.println("Opened database successfully");
    }

    public static void connectToAndQueryDatabase() throws Exception {

        // create conn. if DB doesn't exist. Else, connect to it.
        Connection con = DriverManager.getConnection("jdbc:sqlite:test.db");
//        stmt = c.createStatement();



    }
}
