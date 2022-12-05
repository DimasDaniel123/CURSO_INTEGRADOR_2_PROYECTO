package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    Connection con;

    public Connection getConnection(){
        try {
            String myBD = "jdbc:mysql://localhost/proyeclinica";
            con = DriverManager.getConnection(myBD, "root", "");
            return con;
        } catch (SQLException e) {
            System.out.println("Error:" + e.toString());
        }
        return null;
    }
}
