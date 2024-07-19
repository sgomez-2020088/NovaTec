package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DetalleCarritoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    
   //Método Listar
    
    public List<DetalleCarrito> listar(){
        String sql = "Select * from DetalleCarrito";
        List<DetalleCarrito> listaDetalleCarrito = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                DetalleCarrito detalle = new DetalleCarrito();
                detalle.setCodigoDetalleCarrito(rs.getInt(1));
                detalle.setCodigoCarrito(rs.getInt(2));
                detalle.setCodigoProducto(rs.getString(3));
                detalle.setCantidad(rs.getInt(4));
                detalle.setTotal(rs.getDouble(5));
                listaDetalleCarrito.add(detalle);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaDetalleCarrito;
    }
    
    //Método Agregar
    
    public int agregar(DetalleCarrito detalle) {
        String sql = "Insert into DetalleCarrito (codigoCarrito, codigoProducto, cantidad, Total) values (?, ?, ?, ?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, detalle.getCodigoCarrito());
            ps.setString(2, detalle.getCodigoProducto());
            ps.setInt(3, detalle.getCantidad());
            ps.setDouble(4, detalle.getTotal());
            resp = ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    //Método Buscar por código
    public DetalleCarrito buscarPorCodigo(int id){
        DetalleCarrito detalle = new DetalleCarrito();
        String sql = "select * from DetalleCarrito where codigoDetalleCarrito=" + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                detalle.setCodigoDetalleCarrito(rs.getInt(1));
                detalle.setCodigoCarrito(rs.getInt(2));
                detalle.setCodigoProducto(rs.getString(3));
                detalle.setCantidad(rs.getInt(4));
                detalle.setTotal(rs.getDouble(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return detalle;
    }
    
    //Método Actualizar 
    public int actualizar(DetalleCarrito detalle) {
        String sql = "update DetalleCarrito set codigoCarrito = ?, codigoProducto = ?, cantidad = ?, Total = ? where codigoDetalleCarrito = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, detalle.getCodigoCarrito());
            ps.setString(2, detalle.getCodigoProducto());
            ps.setInt(3, detalle.getCantidad());
            ps.setDouble(4, detalle.getTotal());
            ps.setInt(5, detalle.getCodigoDetalleCarrito());
            resp = ps.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    //Método Eliminar
    public void eliminar(int id) {
        String sql = "Delete from DetalleCarrito where codigoDetalleCarrito=" + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }    
}
