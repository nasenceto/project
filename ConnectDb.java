package salesData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDb {


	private  Connection con;
	private Statement st;
	private ResultSet rs;
	
           public  ConnectDb() {
        	   
        	   
	try {
		Class.forName("com.mysql.jbdc.Driver");
	    con =
	       DriverManager.getConnection("jdbc:mysql://localhost/dbsales","root","1234");
        st=
	    con.createStatement();
        

	
	} catch (SQLException ex) {
	    // handle any errors
	    System.out.println("SQLException: " + ex.getMessage());
	    System.out.println("SQLState: " + ex.getSQLState());
	    System.out.println("VendorError: " + ex.getErrorCode());
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
