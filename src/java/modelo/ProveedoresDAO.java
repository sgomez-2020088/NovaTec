
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProveedoresDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    

    //método listar
    
    public List listar(){
        String sql = "select * from Proveedores";
        List<Proveedores>listaProveedores  = new ArrayList<>();
        
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Proveedores p = new Proveedores();
                p.setCodigoProveedor(rs.getInt(1));
                p.setNITProveedor(rs.getString(2));
                p.setNombresProveedor(rs.getString(3));
                p.setApellidosProveedor(rs.getString(4));
                p.setDireccionProveedor(rs.getString(5));
                p.setRazonSocial(rs.getString(6));
                p.setContactoPrincipal(rs.getString(7));
                p.setPaginaWeb(rs.getString(8));
                listaProveedores.add(p);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return listaProveedores;
    }
    
    //Agregar
    
    public int agregar(Proveedores pr){
        String sql = "insert into Proveedores ( NITProveedor, nombresProveedor, apellidosProveedor, direccionProveedor, razonSocial, contactoPrincipal, paginaWeb)"
                + " values (?,?,?,?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNITProveedor());
            ps.setString(2, pr.getNombresProveedor());
            ps.setString(3, pr.getApellidosProveedor());
            ps.setString(4, pr.getDireccionProveedor());
            ps.setString(5, pr.getRazonSocial());
            ps.setString(6, pr.getContactoPrincipal());
            ps.setString(7, pr.getPaginaWeb());
            ps.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    // buscar por código
    
    public Proveedores listarCodigoProveedores(int id){
        Proveedores pr = new Proveedores();
        
        String sql = "select * from Proveedores where codigoProveedor =" +id;
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                pr.setNITProveedor(rs.getString(2));
                pr.setNombresProveedor(rs.getString(3));
                pr.setApellidosProveedor(rs.getString(4));
                pr.setDireccionProveedor(rs.getString(5));
                pr.setRazonSocial(rs.getString(6));
                pr.setContactoPrincipal(rs.getString(7));
                pr.setPaginaWeb(rs.getString(8));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return pr;
    }
    
    // Método Editar
    
    public int actualizar(Proveedores pr) {
        String sql = "Update Proveedores set NITProveedor = ?,nombresProveedor = ?, apellidosProveedor = ?, direccionProveedor = ?, razonSocial = ?, contactoPrincipal = ?, paginaWeb = ? where codigoProveedor = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNITProveedor());
            ps.setString(2, pr.getNombresProveedor());
            ps.setString(3, pr.getApellidosProveedor());
            ps.setString(4, pr.getDireccionProveedor());
            ps.setString(5, pr.getRazonSocial());
            ps.setString(6, pr.getContactoPrincipal());
            ps.setString(7, pr.getPaginaWeb());
            ps.setInt(8, pr.getCodigoProveedor());
            ps.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    // eliminar
    public void eliminar(int id){
        String sql = "delete from Proveedores where codigoProveedor ="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
