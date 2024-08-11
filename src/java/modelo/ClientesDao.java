package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClientesDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
   //Listar
    
    public List listar(){
        String sql = "select * from clientes";
        List<Cliente> listaClientes = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Cliente cl = new Cliente();
                cl.setCodigoClientes(rs.getInt(1));
                cl.setNITCliente(rs.getString(2));
                cl.setNombresCliente(rs.getString(3));
                cl.setApellidosCliente(rs.getString(4));
                cl.setDireccionCliente(rs.getString(5));
                cl.setTelefonoCliente(rs.getString(6));
                cl.setEmailCliente(rs.getString(7));
                listaClientes.add(cl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaClientes;
    }
    
    // Agregar 
    public int agregar(Cliente clt){
        String sql = "insert into Clientes (NITCliente, nombresCliente, apellidosCliente, direccionCliente, telefonoCliente, emailCliente) values (?, ?, ?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, clt.getNITCliente());
            ps.setString(2, clt.getNombresCliente());
            ps.setString(3, clt.getApellidosCliente());
            ps.setString(4, clt.getDireccionCliente());
            ps.setString(5, clt.getTelefonoCliente());
            ps.setString(6, clt.getEmailCliente());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    // Buscar
    
    public Cliente ListarCodigoClientes(int id){
        Cliente clt = new Cliente();
        String sql = "Select * from Clientes where codigoCliente ="+ id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                clt.setNITCliente(rs.getString(2));
                clt.setNombresCliente(rs.getString(3));
                clt.setApellidosCliente(rs.getString(4));
                clt.setDireccionCliente(rs.getString(5));
                clt.setTelefonoCliente(rs.getString(6));
                clt.setEmailCliente(rs.getString(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clt;
    }
    
    //Actualizar
    
    public int actualizar (Cliente clt){
        String sql = "Update Clientes set NITCliente = ?, nombresCliente= ?, apellidosCliente= ?, direccionCliente= ?, telefonoCliente= ?, emailCliente= ? where codigoCliente = ?";
        try {
            con= cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, clt.getNITCliente());
            ps.setString(2, clt.getNombresCliente());
            ps.setString(3, clt.getApellidosCliente());
            ps.setString(4, clt.getDireccionCliente());
            ps.setString(5, clt.getTelefonoCliente());
            ps.setString(6, clt.getEmailCliente());
            ps.setInt(7, clt.getCodigoClientes());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    // Eliminar
    public void eliminar (int id){
        String sql = "delete from clientes where codigoCliente ="+ id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
