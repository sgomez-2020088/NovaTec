package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CompraDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    //Métodos CRUD
    //Método Listar
    public List listar(){
        String sql = "select * from Compras";
        List<Compra> listaCompra = new ArrayList();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Compra com = new Compra();
                com.setNumeroDocumento(rs.getInt(1));
                com.setFechaDocumento(rs.getDate(2));
                com.setDescripcion(rs.getString(3));
                com.setTotalDocumento(rs.getDouble(4));
                listaCompra.add(com);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaCompra;
    }
    
    //Método agregar
    public int agregar(Compra com){
        String sql = "insert into Compras(numeroDocumento, fechaDocumento, descripcion, totalDocumento) values(?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, com.getNumeroDocumento());
            ps.setDate(2, (Date) com.getFechaDocumento());
            ps.setString(3, com.getDescripcion());
            ps.setDouble(4, com.getTotalDocumento());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    //Método buscar numero documento
    public Compra listarNumeroDocumento(int id){
        Compra com = new Compra();
        String sql = "select * from Compras where numeroDocumento =" + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                com.setNumeroDocumento(rs.getInt(1));
                com.setDescripcion(rs.getString(2));
                com.setFechaDocumento(rs.getDate(3));
                com.setTotalDocumento(rs.getDouble(4));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return com;
    }
    
    //Método actualizar
    public int actualizar(Compra com){
        String sql = "update Compras set fechaDocumento = ?, descripcion = ?, totalDocumento = ? where numeroDocumento = ?;";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setDate(1, (Date) com.getFechaDocumento());
            ps.setString(2, com.getDescripcion());
            ps.setDouble(3, com.getTotalDocumento());
            ps.setInt(4, com.getNumeroDocumento());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    //Método eliminar
    public void elimninar(int id){
        String sql = "delete from Compras where numeroDocumento =" + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}