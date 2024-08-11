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
                pr.setCodigoProducto(rs.getString(1));
                pr.setDescripcionProducto(rs.getString(2));
                pr.setPrecioUnitario(rs.getDouble(3));
                pr.setImagenProducto(rs.getBinaryStream(4));
                pr.setExistencia(rs.getInt(5));
                pr.setCodigoTipoProducto(rs.getInt(6));
                pr.setCodigoProveedor(rs.getInt(7));
                listaProducto.add(pr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProducto;
    }
    
    //IMAGEN
    public void imagen (String idProducto, HttpServletResponse response){
        String sql = "Select imagenProducto from Productos where codigoProducto = " + idProducto;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedoutputStream = null;
        response.setContentType("image/*");
        try {
            outputStream = response.getOutputStream();
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
               inputStream = rs.getBinaryStream("imagenProducto");
            }
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedoutputStream = new BufferedOutputStream(outputStream);
            int i=0;
            while((i = bufferedInputStream.read())!=-1){
                bufferedoutputStream.write(i);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //AGREGAR
    public int agregar(Producto pr){
        String sql = "Insert into Productos (codigoProducto, descripcionProducto, precioUnitario, imagenProducto, existencia, codigoTipoProducto, codigoProveedor) values(?,?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, pr.getCodigoProducto());
            ps.setString(2, pr.getDescripcionProducto());
            ps.setDouble(3, pr.getPrecioUnitario());
            ps.setBlob(4, pr.getImagenProducto());
            ps.setInt(5, pr.getExistencia());
            ps.setInt(6, pr.getCodigoTipoProducto());
            ps.setInt(7, pr.getCodigoProveedor());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    //BUSCAR POR CÓDIGO
    public Producto listarCodigoProducto(String id){
        Producto pr = new Producto();
        String sql = "Select * from Productos where codigoProducto = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                pr.setCodigoProducto(rs.getString(1));
                pr.setDescripcionProducto(rs.getString(2));
                pr.setPrecioUnitario(rs.getDouble(3));
                pr.setImagenProducto(rs.getBinaryStream(4));
                pr.setExistencia(rs.getInt(5));
                pr.setCodigoTipoProducto(rs.getInt(6));
                pr.setCodigoProveedor(rs.getInt(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pr;
    }
    
    //EDITAR
    public int actualizar(Producto pr){
        String sql = "Update Productos set descripcionProducto = ?, precioUnitario = ?, imagenProducto = ?, existencia = ? where codigoProducto = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getDescripcionProducto());
            ps.setDouble(2, pr.getPrecioUnitario());
            ps.setBlob(3, pr.getImagenProducto());
            ps.setInt(4, pr.getExistencia());
            ps.setString(5, pr.getCodigoProducto());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    //ELIMINAR
    public void eliminar(String id){
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