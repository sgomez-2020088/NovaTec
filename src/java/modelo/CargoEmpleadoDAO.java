package modelo;
 
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
 
 
public class CargoEmpleadoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    //Elementos del CRUD
    public List listar(){
        String sql = "select * from CargoEmpleado";
        List<CargoEmpleado> listaCargoEmpleado = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                CargoEmpleado ce = new CargoEmpleado();
                ce.setCodigoCargoEmpleado(rs.getInt(1));
                ce.setNombreCargo(rs.getString(2));
                ce.setDescripcionCargo(rs.getString(3));
                listaCargoEmpleado.add(ce);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaCargoEmpleado;
    }
    
    
    public int agregar(CargoEmpleado cae){
        String sql = "insert into CargoEmpleado (nombreCargo,descripcionCargo) values (?,?)";
        
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cae.getNombreCargo());
            ps.setString(2, cae.getDescripcionCargo());
            ps.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    public CargoEmpleado listarCodigoCargoEmpleado(int id){
        CargoEmpleado cae = new CargoEmpleado();
        String sql = "select * from CargoEmpleado where codigoCargoEmpleado =" + id;
        try{
            con  = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                cae.setNombreCargo(rs.getString(2));
                cae.setDescripcionCargo(rs.getString(3));

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return cae;
    }
    public int actualizar(CargoEmpleado cae){
        String sql = "Update cargoEmpleado set nombreCargo = ?, descripcionCargo = ? where codigoCargoEmpleado = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cae.getNombreCargo());
            ps.setString(2, cae.getDescripcionCargo());
            ps.setInt(3, cae.getCodigoCargoEmpleado());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    public void eliminar(int id){
        String sql = "delete from CargoEmpleado where codigoCargoEmpleado =" + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    
}