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
		//Class.forName("com.mysql.jbdc.Driver");
	    con =
	       DriverManager.getConnection("jdbc:mysql://localhost:3306/dbsales","root","1234");
        st=
	    con.createStatement();
        

	
	} catch (Exception ex) {
		System.out.println("erro: "+ex);
		
	}

}
           public void getData() {
        	
        	   try {
        		   String query= "SELECT * FROM dbsales.data ";
        		   
        		   rs=st.executeQuery(query);
        		   System.out.println("connect with dbsales.data");
        		   while (rs.next()) {
        			   String name=rs.getString("name");
        			   String product=rs.getString("product");
        			   int id=rs.getInt(1);
        			   System.out.println(id+" : "+name+" : "+product+"  ");
        			   
        			   		
        			  
        		   }
        	   }
        	   catch (Exception ex) {
        		   System.out.println("erro cant connect db "+ex);
        	   }
           }
}
