package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    //Elementos del CRUD
    //MÉTODO LISTAR
    public List listar(){
        String sql = "Select * from Factura";
        List<Factura> listaFactura = new ArrayList();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Factura fc = new Factura();
                fc.setNumeroFactura(rs.getInt(1));
                fc.setEstado(rs.getString(2));
                fc.setTotalFactura(rs.getDouble(3));
                fc.setFechaFactura(rs.getString(4));
                fc.setCodigoCliente(rs.getInt(5));
                fc.setCodigoEmpleado(rs.getInt(6));
                listaFactura.add(fc);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaFactura;
    }
    
    //MÉTODO AGREGAR
    public int agregar(Factura fact){
        String sql ="insert into Factura (numeroFactura, estado, totalFactura, fechaFactura, codigoCliente, codigoEmpleado)" +
        "values (?,?,?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, fact.getNumeroFactura());
            ps.setString(2, fact.getEstado());
            ps.setDouble(3, fact.getTotalFactura());
            ps.setString(4, fact.getFechaFactura());
            ps.setInt(5, fact.getCodigoCliente());
            ps.setInt(6, fact.getCodigoEmpleado());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    //MÉTODO BUSCAR POR CÓDIGO
    public Factura listarFacturaPorCodigo (int id){
        Factura f = new Factura();
        String sql = "Select * from Factura where numeroFactura ="+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                f.setNumeroFactura(rs.getInt(1));
                f.setEstado(rs.getString(2));
                f.setTotalFactura(rs.getDouble(3));
                f.setFechaFactura(rs.getString(4));
                f.setCodigoCliente(rs.getInt(5));
                f.setCodigoEmpleado(rs.getInt(6));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return f;
    }
    
    //MÉTODO EDITAR
    public int actualizar(Factura fact){
        String sql = "update Factura set estado = ?, totalFactura = ?, fechaFactura = ? where numeroFactura = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, fact.getEstado());
            ps.setDouble(2, fact.getTotalFactura());
            ps.setString(3, fact.getFechaFactura());
            ps.setInt(4, fact.getNumeroFactura());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return resp;
    }
    
    //MÉTODO ELIMINAR
    public void eliminar (int id){
        String sql = "delete from factura where numeroFactura = "+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

