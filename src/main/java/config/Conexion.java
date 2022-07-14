
package config;
import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
    Connection con;
    String url = "jdbc:mysql://localhost:3307/bd_ventasI";
    String user="root";
    String pass="123";
    public Connection Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error: "+ e);
        }
        System.out.println("con : "+con);
        return con;
    }
    
}
