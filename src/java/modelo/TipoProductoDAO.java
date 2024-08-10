
package modelo;

import config.Conexion;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;


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
    
    public int agregar(TipoProducto tip){
        String sql = "insert into TipoProducto (Descripcion) values (?)";
        
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, tip.getDescripcion());
            ps.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    // buscar por código
    
    public TipoProducto listarCodigoTipoProducto(int id){
        TipoProducto tip = new TipoProducto();
        
        String sql = "select * from TipoProducto where codigoTipoProducto =" +id;
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                tip.setDescripcion(rs.getString(2));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return tip;
    }
    
    // Método Editar
    
    public int actualizar(TipoProducto tip) {
        String sql = "Update TipoProducto set descripcion = ? where codigoTipoProducto = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, tip.getDescripcion());
            ps.setInt(2, tip.getCodigoTipoProducto());
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
