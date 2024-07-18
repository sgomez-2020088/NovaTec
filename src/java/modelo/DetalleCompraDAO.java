package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DetalleCompraDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    // listar
    
    public List listar(){
        String sql = "Select * from DetalleCompra";
            List<DetalleCompra> listaDetalleCompra = new ArrayList();
            try{
                con = cn.Conexion();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()){
                    DetalleCompra dc = new DetalleCompra();
                    dc.setCodigoDetalleCompra(rs.getInt(1));
                    dc.setCostoUnitario(rs.getDouble(2));
                    dc.setCantidad(rs.getInt(3));
                    dc.setCodigoProducto(rs.getString(4));
                    dc.setNumeroDocumento(rs.getInt(5));
                    listaDetalleCompra.add(dc);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            return listaDetalleCompra;
    }
    
    // Agregar
    
    public int agregar (DetalleCompra dtc){
        String sql = "insert into DetalleCompra (costoUnitario, cantidad, codigoProducto, numeroDocumento) values (?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, dtc.getCostoUnitario());
            ps.setInt(2, dtc.getCantidad());
            ps.setString(3, dtc.getCodigoProducto());
            ps.setInt(4, dtc.getNumeroDocumento());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    // Buscar por Codigo
    
    public DetalleCompra ListarDetalleCompra(int id){
        DetalleCompra dtc = new DetalleCompra();
        String sql = "select * from DetalleCompra where codigoDetalleCompra = "+ id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                dtc.setCostoUnitario(rs.getDouble(2));
                dtc.setCantidad(rs.getInt(3));
                dtc.setCodigoProducto(rs.getString(4));
                dtc.setNumeroDocumento(rs.getInt(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return dtc;
    }
    
    // Editar 
    
    public int actualizar (DetalleCompra dtc){
        String sql = "Update DetalleCompra set costoUnitario = ?, cantidad = ? where codigoDetalleCompra = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, dtc.getCostoUnitario());
            ps.setInt(2, dtc.getCantidad());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    //Eliminar
    
    public void eliminar (int id){
        String sql = "delete from DetalleCompra where codigoDetalleCompra =" + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}