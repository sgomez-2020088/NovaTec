
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class CarritoDAO {
    Conexion cn = new Conexion();
    Connection con; 
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    //Elementos del CRUD
    
    //Método Listar
    
    public List listar(){
        String sql = "select * from Carrito";
        List<Carrito> listaCarrito = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Carrito car = new Carrito();
                car.setCodigoCarrtio(rs.getInt(1));
                car.setCodigoCliente(rs.getInt(2));
                listaCarrito.add(car);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return listaCarrito;
    }
    
    
    //Método Agregar
    
   public int agregar(Carrito car){
       String sql = "insert into Carrito (codigoCliente) values (?)";
       try{
           con = cn.Conexion();
           ps = con.prepareStatement(sql);
           ps.setInt(1, car.getCodigoCliente());
           ps.executeUpdate();
       }catch(Exception e){
           e.printStackTrace();
       }
       
       return resp;
   }
   
   //Método Buscar
   
   public Carrito listaCodigoCarrtio(int id){
       Carrito car = new Carrito();
       String sql = "select * from Carrito where codigoCarrito="+id;
       try{
           con = cn.Conexion();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               car.setCodigoCliente(rs.getInt(2));
           }
       }catch(Exception e){
           e.printStackTrace();
       }
       
       return car;
   }
    
   //Métdo Eliminar
   
   public void eliminar(int id){
       String sql = "delete from Carrito where codigoCarrito="+id;
       try{
           con = cn.Conexion();
           ps = con.prepareStatement(sql);
           ps.executeUpdate();
       }catch(Exception e){
           e.printStackTrace();
       }
   }
   
}
