package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    //LISTAR
    public List listar(){
        String sql = "Select * from Productos";
        List<Producto> listaProducto = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Producto pr = new Producto();
                pr.setCodigoProducto(rs.getInt(1));
                pr.setDescripcionProducto(rs.getString(2));
                pr.setPrecioUnitario(rs.getDouble(3));
                pr.setPrecioDocena(rs.getDouble(4));
                pr.setPrecioMayor(rs.getDouble(5));
                //pr.setImagen(rs.getBlob(6));
                pr.setExistencia(rs.getInt(6));
                pr.setCodigoProveedor(rs.getInt(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProducto;
    }
    
    //AGREGAR
    public int agregar(Producto pr){
        String sql = "Insert into Productos (descripcionProducto, precioUnitario, precioDocena, precioMayor, existencia, codigoProveedor) values(?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getDescripcionProducto());
            ps.setDouble(2, pr.getPrecioUnitario());
            ps.setDouble(3, pr.getPrecioDocena());
            ps.setDouble(4, pr.getPrecioMayor());
            ps.setInt(5, pr.getExistencia());
            ps.setInt(6, pr.getCodigoProveedor());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    //BUSCAR POR CÓDIGO
    public Producto listarCodigoProducto(int id){
        Producto pr = new Producto();
        String sql = "Select * from Productos where codigoProducto = ?" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                pr.setDescripcionProducto(rs.getString(2));
                pr.setPrecioUnitario(rs.getDouble(3));
                pr.setPrecioDocena(rs.getDouble(4));
                pr.setPrecioMayor(rs.getDouble(5));
                //pr.setImagen(rs.getBlob(6));
                pr.setExistencia(rs.getInt(6));
                pr.setCodigoProveedor(rs.getInt(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pr;
    }
    
    //EDITAR
    public int actualizar(Producto pr){
        String sql = "Update Productos set descripcionProducto = ?, set precioUnitario = ?, set precioDocena = ?, set precioMayor = ?, set existencia = ?, where codigoProducto = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getDescripcionProducto());
            ps.setDouble(2, pr.getPrecioUnitario());
            ps.setDouble(3, pr.getPrecioDocena());
            ps.setDouble(4, pr.getPrecioMayor());
            ps.setInt(5, pr.getExistencia());
            ps.setInt(6, pr.getCodigoProveedor());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    //ELIMINAR
    public void eliminar(int id){
        String sql = "Delete from Productos where codigoProducto = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
