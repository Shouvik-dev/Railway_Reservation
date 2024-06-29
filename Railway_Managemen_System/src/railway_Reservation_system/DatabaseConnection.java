package railway_Reservation_system;

import java.sql.*;
public class DatabaseConnection {
    public Connection con1;        
    String user = "root";
    String db_pass="1234";
    String port = "3306";
    String database_name ="railway_project";
    public Connection connect_db()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1=DriverManager.getConnection("jdbc:mysql://localhost:"+port+"/"+database_name+"?useSSL=false&allowPublicKeyRetrieval=true",user,db_pass);            
        }
        catch(Exception e)
        {
            System.out.println("Database connection problem\n"+e);        
        } 
        return con1;
    }
    public static void main(String as[])
    {
        
    }
    
}
