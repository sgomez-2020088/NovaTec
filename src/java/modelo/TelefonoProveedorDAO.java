package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TelefonoProveedorDAO { 

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    
    //Listar
    public List listar(){
        String sql = "select * from TelefonoProveedor";
        List<TelefonoProveedor>listaTelefonoProveedor = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                TelefonoProveedor tp = new TelefonoProveedor();
                tp.setCodigoProveedor(rs.getInt(1));
                tp.setNumeroPrincipal(rs.getString(2));
                tp.setNumeroSecundario(rs.getString(3));
                tp.setObservaciones(rs.getString(4));
                tp.setCodigoProveedor(rs.getInt(5));
                listaTelefonoProveedor.add(tp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listaTelefonoProveedor;
    }
    
    //Agregar
    
    public int agregar(TelefonoProveedor tlp){
        String sql = "insert into TelefonoProveedor (numeroPrincipal, numeroSecundario, obaservaciones, codigoProveedor) values (?,?,?,?);";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, tlp.getNumeroPrincipal());
            ps.setString(2, tlp.getNumeroSecundario());
            ps.setString(3, tlp.getObservaciones());
            ps.setInt(4, tlp.getCodigoTelefonoProveedor());
            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        return resp; 
    }
    
    //Buscar
    public  TelefonoProveedor listarCodigoTelefonoProveedor(int id){
        TelefonoProveedor tlp = new TelefonoProveedor();
        String sql = "select * from TelefonoProveedor where codigoTelefonoProveedor =" + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                tlp.setNumeroPrincipal(rs.getString(2));
                tlp.setNumeroSecundario(rs.getString(3));
                tlp.setObservaciones(rs.getString(4));
                tlp.setCodigoProveedor(rs.getInt(5));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return tlp;
    }
    
    //Actualizar
    public int actualizar(TelefonoProveedor tlp){
        String sql = "Update TelefonoProveedor set numeroPrincipal = ?, numeroSecundario = ?, observaciones = ? where codigoProveedor = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, tlp.getNumeroPrincipal());
            ps.setString(2, tlp.getNumeroSecundario());
            ps.setString(3, tlp.getObservaciones());
            ps.setInt(4, tlp.getCodigoTelefonoProveedor());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    //Eliminar
    
    public void eliminar(int id) {
        String sql = "delete from TelefonoProveedor where codigoTelefonoProveedor ="+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
} 
