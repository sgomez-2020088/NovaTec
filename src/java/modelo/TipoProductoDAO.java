
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
    
    //LISTAR TIPOPRODUCTO
    public List Listar(){
        String sql = "Select * from TipoProducto";
        List<TipoProducto> listaTipoProducto = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                TipoProducto tp = new TipoProducto();
                tp.setCodigoTipoProducto(rs.getInt(1));
                tp.setDescripcion(rs.getString(2));
            }   
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaTipoProducto;
    }
    
    // AGREGAR TIPOPRODUCTO
    public int agregar(TipoProducto tp){
        String sql = " insert into TipoProducto(descripcion) values (?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, tp.getDescripcion());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    // BUSCAR POR CODIGO
    public TipoProducto listarTipoProducto(int id){
        TipoProducto tp = new TipoProducto();
        String sql = "selecto * from TipoProducto where codigoTipoProducto =" + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                tp.setDescripcion(rs.getString(1));
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
        return tp;
    }
    
    // EDITAR TIPOPRODUCTO
    public int actualizar(TipoProducto tp){
        String sql="Update TipoProducto set descripcion = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, tp.getDescripcion());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
    }
        return resp;   
    }
    
    //ELIMINAR TIPOPRODUCTO
    public void eliminar(int id){
        String sql = "delete from tipoProducto where codigoTipoProducto ="+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
}
