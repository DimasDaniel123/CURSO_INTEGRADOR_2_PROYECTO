package Modelo;

import Conexion.Conexion;
import Modelo.paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class pacienteDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean registrarPaciente(paciente pa){
        String sql= "INSERT INTO pacientes (nombre,apaterno,amaterno,edad,sexo,lugar,direccion,telefono,dni) VALUES (?,?,?,?,?,?,?,?,?)";
        
        try {
            con =  cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pa.getNombre());
            ps.setString(2, pa.getApaterno());
            ps.setString(3, pa.getAmaterno());
            ps.setInt(4, pa.getEdad());
            ps.setString(5, pa.getSexo());
            ps.setString(6, pa.getLugar());
            ps.setString(7, pa.getDireccion());
            ps.setString(8, pa.getTelefono());
            ps.setInt(9, pa.getDni());
            ps.execute();
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
    
        public List listarpaciente(){
        List<paciente> listaPa = new ArrayList();
        String sql = "SELECT * FROM pacientes";
        try {

           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()) {               
                paciente pa = new paciente();
                pa.setId(rs.getInt("id"));
                pa.setNombre(rs.getString("nombre"));
                pa.setApaterno(rs.getString("apaterno"));
                pa.setAmaterno(rs.getString("amaterno"));
                pa.setEdad(rs.getInt("edad"));
                pa.setSexo(rs.getString("sexo"));
                pa.setLugar(rs.getString("lugar"));
                pa.setDireccion(rs.getString("direccion"));
                pa.setTelefono(rs.getString("telefono"));
                pa.setDni(rs.getInt("dni"));
                listaPa.add(pa);
                
            }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
        return listaPa;
    }





   public paciente BuscarPaciente(int dni){
       paciente cl = new paciente();
       String sql = "SELECT * FROM paciente WHERE dni = ?";
       try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           ps.setInt(1, dni);
           rs = ps.executeQuery();
           if (rs.next()) {
               cl.setId(rs.getInt("id"));
               cl.setNombre(rs.getString("nombre"));
               cl.setTelefono(rs.getString("telefono"));
               cl.setDireccion(rs.getString("direccion"));
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return cl;
   }
    
}