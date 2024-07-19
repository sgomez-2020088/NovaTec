
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EmailProveedorDAO {
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        int resp;
        
        public List Listar(){
            String sql = "select * from EmailProveedor";
            List<EmailProveedor>listaEmailProveedor = new ArrayList<>();
            try{
                con = cn.Conexion();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()){
                    EmailProveedor ep = new EmailProveedor();
                    ep.setCodigoEmailProveedor(rs.getInt(1));
                    ep.setEmailProveedor(rs.getString(2));
                    ep.setDescripcion(rs.getString(3));
                    ep.setCodigoProveedor(rs.getInt(4));
                    
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return listaEmailProveedor;
        }
        
        public int agregar(EmailProveedor ep){
            String sql = "insert into EmailProveedor(emailProveedor, descripcion, codigoProveedor)values (?,?,?)";
            try{
                con = cn.Conexion();
                ps = con.prepareStatement(sql);
                ps.setString(1, ep.getEmailProveedor());
                ps.setString(2, ep.getDescripcion());
                ps.setInt(3, ep.getCodigoProveedor());
                ps.executeUpdate();
                
            }catch (Exception e){
                e.printStackTrace();
            }
            return resp;
        }
        
        public EmailProveedor listarEmailProveedor(int id){
            EmailProveedor ep = new EmailProveedor();
            String sql = "Select * from EmailProveedor where codigoEmailProveedor =" + id;
            try{
                con = cn.Conexion();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()){
                    ep.setEmailProveedor(rs.getString(1));
                    ep.setDescripcion(rs.getString(2));
                    ep.setCodigoProveedor(rs.getInt(3));
                    
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return ep;
        }
        //EDITAR
        public int actualizar (EmailProveedor ep){
            String sql = "Update EmailProveedor set emailProveedor = ?, descripcion = ? ";
            try{
                con = cn.Conexion();
                ps= con.prepareStatement(sql);
                ps.setString(1, ep.getEmailProveedor());
                ps.setString(2, ep.getDescripcion());
                ps.executeUpdate();
            }catch (Exception e){
                e.printStackTrace();
            }
            return resp;
        }
        // ELIMINAR
        public void eliminar (int id){
            String sql = "delete from EmailProveedor where codigoEmailProveedor = " + id;
            try{
                con = cn.Conexion();
                ps = con.prepareStatement(sql);
                ps.executeUpdate();
            
            }catch (Exception e){
                e.printStackTrace();
            }
        }
}   
 