
package Modelo;

import Conexion.Conexion;
import Modelo.receta;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

public class recetaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement rt;
    ResultSet ra;


    public boolean registrarReceta(receta re){
        String sql= "INSERT INTO receta (id,nombre,nreceta,ncitas,recetario,alergias,estatura,peso,tiposangre,presion) VALUES (?,?,?,?,?,?,?,?,?,?)";
        
        try {
            con =  cn.getConnection();
            rt = con.prepareStatement(sql);
            rt.setInt(1,re.getId());
            rt.setString(2,re.getNombre());
            rt.setInt(3, re.getNreceta());
            rt.setInt(4, re.getNcitas());
            rt.setString(5,re.getRecetario());
            rt.setString(6,re.getAlergias());
            rt.setString(7,re.getTiposangre());
            rt.setString(8,re.getPresion());      
            rt.setString(9,re.getEstatura());
            rt.setString(10,re.getPeso());


            rt.execute();
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
    
        public List listarReceta(){
        List<receta> listaRe = new ArrayList();
        String sql = "SELECT * FROM receta";
        try {

           con = cn.getConnection();
           rt = con.prepareStatement(sql);
           ra = rt.executeQuery();
           while (ra.next()) {               
                receta re = new receta();
                re.setId(ra.getInt("id"));
                re.setNombre(ra.getString("nombre"));
                re.setNreceta(ra.getInt("nreceta"));
                re.setNcitas(ra.getInt("ncitas"));
                re.setRecetario(ra.getString("recetario"));
                re.setAlergias(ra.getString("alergias"));
                re.setTiposangre(ra.getString("tiposangre"));
                re.setPresion(ra.getString("presion"));
                re.setEstatura(ra.getString("estatura"));
                re.setPeso(ra.getString("peso"));          
                listaRe.add(re);
                
            }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
        return listaRe;
    }


}