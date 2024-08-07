
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class TipoProductoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    

    //método listar
    
    public List listar(){
        String sql = "select * from tipoProducto";
        List<TipoProducto>listaTipoProducto  = new ArrayList<>();
        
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                TipoProducto tp = new TipoProducto();
                tp.setCodigoTipoProducto(rs.getInt(1));
                tp.setDescripcion(rs.getString(2));
                listaTipoProducto.add(tp);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return listaTipoProducto;
    }
    
    //Agregar
    public int agregar(TipoProducto tp){
        String sql = "insert into TipoProducto (descripcion) values (?)";
        
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, tp.getCodigoTipoProducto());
            ps.setString(2, tp.getDescripcion());
            ps.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    // buscar por código
    
    public TipoProducto listarCodigoTipoProducto(int id){
        TipoProducto tp = new TipoProducto();
        
        String sql = "select * from TipoProducto where codigoTipoProducto =" +id;
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                tp.setCodigoTipoProducto(rs.getInt(1));
                tp.setDescripcion(rs.getString(2));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return tp;
    }
    
    // Método Editar
    
    public int actualizar(TipoProducto tp) {
        String sql = "Update TipoProducto set descripcion = ? where codigoTipoProducto = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, tp.getDescripcion());
            ps.setInt(2, tp.getCodigoTipoProducto());
            ps.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    // eliminar
    public void eliminar(int id){
        String sql = "delete from TipoProducto where codigoTipoProducto ="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
