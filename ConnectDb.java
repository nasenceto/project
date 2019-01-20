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
	private String date;
	private int id;
	
           public  ConnectDb() {
        	   
        	   
	try {
		//Class.forName("com.mysql.jbdc.Driver");
	    conn =
	       DriverManager.getConnection("jdbc:mysql://localhost:3306/dbsales?characterEncoding=UTF-8","root","");
        st=
	    conn.createStatement();
        

	
	} catch (Exception ex) {
		System.out.println("erro: "+ex);
		
	}

}
           public void getData() {
        	
        	   try {
        		   String query= "SELECT * FROM person ";
        		   
        		   rs=st.executeQuery(query);
        		   System.out.println("connect with person");
        		   while (rs.next()) {
        			   id= rs.getInt("id");
        			    name=rs.getString("name");
        			    
        			    date=rs.getString("date");
        			   
        			   
        			   System.out.println(id+" "+name+" "+date);
        			   
        			   
        			   		
        			  
        		   }
        	   }
        	   catch (Exception ex) {
        		   System.out.println("erro cant connect db "+ex);
        	   }
           }
       
}
