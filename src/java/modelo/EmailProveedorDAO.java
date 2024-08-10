
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

    public List listar(){
        String sql = "select * from EmailProveedor";
        List<EmailProveedor>listaEmailProveedor  = new ArrayList<>();
        
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
                listaEmailProveedor.add(ep);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return listaEmailProveedor;
    }
    
    //Agregar
    public int agregar(EmailProveedor epp){
        String sql = "insert into EmailProveedor (emailProveedor, descripcion, codigoProveedor)"
                + " values (?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, epp.getEmailProveedor());
            ps.setString(2, epp.getDescripcion());
            ps.setInt(3, epp.getCodigoProveedor());
            ps.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    // buscar por código
    public EmailProveedor listarCodigoEmailProveedor(int id){
        EmailProveedor epp = new EmailProveedor();
        
        String sql = "select * from EmailProveedor where codigoEmailProveedor =" +id;
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                epp.setEmailProveedor(rs.getString(2));
                epp.setDescripcion(rs.getString(3));
                epp.setCodigoProveedor(rs.getInt(4));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return epp;
    }
    
    // Método Editar
    
    public int actualizar(EmailProveedor ep) {
        String sql = "Update EmailProveedor set emailProveedor = ?,descripcion = ? where codigoEmailProveedor = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, ep.getEmailProveedor());
            ps.setString(2, ep.getDescripcion());
            ps.setInt(3, ep.getCodigoEmailProveedor());
            ps.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return resp;
    }


    
    // eliminar
    public void eliminar(int id){
        String sql = "delete from EmailProveedor where codigoEmailProveedor ="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
