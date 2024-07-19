package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class FacturaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    //Elementos Del CRUD
    //Método listar
    public List listar(){
        String sql = "Select * from factura";
        List<Factura> listaFactura = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Factura fc = new Factura();
                fc.setNumeroFactura(rs.getInt(1));
                fc.setEstado(rs.getString(2));
                fc.setTotalFactura(rs.getDouble(3));
                fc.setFechaFactura(rs.getDate(4));
                fc.setCodigoCliente(rs.getInt(5));
                fc.setCodigoEmpleado(rs.getInt(6));
                listaFactura.add(fc);
            }
                    
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return listaFactura;
    }

    //Método Agregar
    public int agregar(Factura fc){
        String sql = "insert into Factura(numeroFactura, estado, totalFactura, fechaFactura, codigoCliente, codigoEmpleado) values(?, ?, ?, ?, ?, ?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1,fc.getNumeroFactura());
            ps.setString(2,fc.getEstado());
            ps.setDouble(3,fc.getTotalFactura());
            ps.setDate(4,(Date) fc.getFechaFactura());
            ps.setInt(5,fc.getCodigoCliente());
            ps.setInt(6,fc.getCodigoEmpleado());
            ps.executeUpdate();
        } catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    //Buscar por código
    public Factura listarNumeroFactura (int numFactura){
        Factura fc = new Factura();
        String sql = "Select * from Factura where numeroFactura = " + numFactura;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                fc.setEstado(rs.getString(2));
                fc.setTotalFactura(rs.getDouble(3));
                fc.setFechaFactura(rs.getDate(4));
                fc.setCodigoCliente(rs.getInt(5));
                fc.setCodigoEmpleado(rs.getInt(6));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
        return fc;
    }
    
    //Método Actualizar
    public int actualizar(Factura fc){
        String sql = "Update Factura set estado = ?,"
                + "totalFactura = ?, fechaFactura = ?,"
                + "where numeroFactura = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, fc.getEstado());
            ps.setDouble(2, fc.getTotalFactura());
            ps.setDate(3, (Date)fc.getFechaFactura());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    //Método Eliminar
    public void eliminar(int numFactura){
        String sql = "Delete from factura where numeroFactura = " + numFactura;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
