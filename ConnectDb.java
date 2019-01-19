package salesData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDb  {


	public  Connection conn;
	private Statement st;
	public ResultSet rs;
	private String name;
	
           public  ConnectDb() {
        	   
        	   
	try {
		//Class.forName("com.mysql.jbdc.Driver");
	    conn =
	       DriverManager.getConnection("jdbc:mysql://localhost:3306/dbsales","root","");
        st=
	    conn.createStatement();
        

	
	} catch (Exception ex) {
		System.out.println("erro: "+ex);
		
	}

}
           public void getData() {
        	
        	   try {
        		   String query= "SELECT * FROM data ";
        		   
        		   rs=st.executeQuery(query);
        		   System.out.println("connect with dbsales.data");
        		   while (rs.next()) {
        			    name=rs.getString("name");
        			   
        			   
        			   System.out.println(name);
        			   
        			   		
        			  
        		   }
        	   }
        	   catch (Exception ex) {
        		   System.out.println("erro cant connect db "+ex);
        	   }
           }
       
}
