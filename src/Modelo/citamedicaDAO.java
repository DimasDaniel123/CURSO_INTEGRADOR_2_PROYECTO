
package Modelo;

import Conexion.Conexion;
import Modelo.citamedica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class citamedicaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ct;
    ResultSet rs;
    
    public boolean registrarCitaMedica(citamedica ca){
        String sql= "INSERT INTO cita (nombre,fecha,hora,servicio,consultorio,doctor,analisis) VALUES (?,?,?,?,?,?,?)";
        
        try {
            con =  cn.getConnection();
            ct = con.prepareStatement(sql);
            ct.setString(1, ca.getNombre());
            ct.setString(2, ca.getFecha());
            ct.setString(3, ca.getHora());
            ct.setString(4, ca.getServicio());
            ct.setString(5, ca.getConsultorio());
            ct.setString(6, ca.getDoctor());
            ct.setString(7, ca.getAnalisis());

            ct.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
               }
        }
        
    }
       public List listarCitaMedica(){
        List<citamedica> ListaCa = new ArrayList();
        String sql = "SELECT * FROM cita";
        try {

           con = cn.getConnection();
           ct = con.prepareStatement(sql);
           rs = ct.executeQuery();
           while (rs.next()) {               
                citamedica md = new citamedica();
                md.setId(rs.getInt("id"));
                md.setNombre(rs.getString("nombre"));
                md.setFecha(rs.getString("fecha"));
                md.setHora(rs.getString("hora"));
                md.setServicio(rs.getString("servicio"));
                md.setConsultorio(rs.getString("consultorio"));
                md.setDoctor(rs.getString("doctor"));
                md.setAnalisis(rs.getString("analisis"));
                ListaCa.add(md);

            }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
        return ListaCa;
    }
}
