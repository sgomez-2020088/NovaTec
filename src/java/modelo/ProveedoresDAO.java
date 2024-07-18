
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProveedoresDAO {
    Conexion cn = new Conexion ();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    //LISTAR PROVEEDORES
    public List Listar(){
        String sql = "select * from Proveedores";
        List<Proveedores> listaProveedor = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Proveedores p = new Proveedores();
                p.setCodigoProveedor(rs.getInt(1));
                p.setNITProveedor(rs.getString(2));
                p.setNombresProveedor(rs.getString(3));
                p.setApellidosProveedor(rs.getString(4));
                p.setDireccionProveedor(rs.getString(5));
                p.setRazonSocial(rs.getString(6));
                p.setContactoPrincipal(rs.getString(7));
                p.setPaginaWeb(rs.getString(8));
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaProveedor;
    }
    
    //AGREGAR PROVEEDORES
    public int agregar(Proveedores p){
        String sql = "insert into Proveedores(NITProveedor, nombresProveedor, apellidosProveedor, direccionProveedor, razonSocial, contactoPrincipal, paginaWeb) values (?,?,?,?,?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNITProveedor());
            ps.setString(2, p.getNombresProveedor());
            ps.setString(3, p.getApellidosProveedor());
            ps.setString(4, p.getDireccionProveedor());
            ps.setString(5, p.getRazonSocial());
            ps.setString(6, p.getContactoPrincipal());
            ps.setString(7, p.getPaginaWeb());
            ps.executeUpdate();   
        }catch (Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    
    //BUSCAR POR CODIGO
    public Proveedores listarProveedor(int id){
        Proveedores p = new Proveedores();
        String sql = "Select * from Proveedores where codigoProveedor ="+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                p.setNITProveedor(rs.getString(1));
                p.setNombresProveedor(rs.getString(2));
                p.setApellidosProveedor(rs.getString(3));
                p.setDireccionProveedor(rs.getString(4));
                p.setRazonSocial(rs.getString(5));
                p.setContactoPrincipal(rs.getString(6));
                p.setPaginaWeb(rs.getString(7));
            }        
        }catch (Exception e){
            e.printStackTrace();
        }
        return p;
    }
    
    //Editar
    public int actualizar(Proveedores p){
        String sql = "Update Proveedores set NITProveedor = ?, nombresProveedor = ?,apellidosProveedor = ?,direccionProveedor = ?,razonSocial = ?, contactoPrincipal = ?, paginaWeb = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1,p.getNITProveedor());
            ps.setString(2, p.getNombresProveedor());
            ps.setString(3, p.getApellidosProveedor());
            ps.setString(4, p.getDireccionProveedor());
            ps.setString(5, p.getRazonSocial());
            ps.setString(6, p.getContactoPrincipal());
            ps.setString(7, p.getPaginaWeb());
            ps.executeUpdate();
            
        }catch (Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    
    // ELIMINAR
    public void eliminar (int id ){
        String sql = "delete from Proveedores where codigoProveedor ="+ id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
