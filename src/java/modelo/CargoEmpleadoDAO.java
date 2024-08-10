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
        String sql = "select * from cargoEmpleado";
        List<CargoEmpleado> listaCargoEmpleado = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                CargoEmpleado cargoEmpleado = new CargoEmpleado();
                cargoEmpleado.setCodigoCargoEmpleado(rs.getInt(1));
                cargoEmpleado.setDescripcionCargo(rs.getString(2));
                cargoEmpleado.setNombreCargo(rs.getString(3));
                listaCargoEmpleado.add(cargoEmpleado);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaCargoEmpleado;
    }
    public int agregar(CargoEmpleado cargoEmpleado){
        String sql = "insert into CargoEmpleado(nombreCargo, descripcionCargo) values(?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cargoEmpleado.getDescripcionCargo());
            ps.setString(2, cargoEmpleado.getNombreCargo());
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    public CargoEmpleado listarCodigoCargoEmpleado(int id){
        CargoEmpleado cargoEmpleado = new CargoEmpleado();
        String sql = "select * from CargoEmpleado where codigoCargoEmpleado =" + id;
        try{
            con  = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                cargoEmpleado.setDescripcionCargo(rs.getString(2));
                cargoEmpleado.setNombreCargo(rs.getString(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return cargoEmpleado;
    }
    public int actualizar(CargoEmpleado cargo){
        String sql = "Update cargoEmpleado set descripcionCargo = ?, nombreCargo = ? where codigoCargoEmpleado = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cargo.getDescripcionCargo());
            ps.setString(2, cargo.getNombreCargo());
            ps.setInt(3, cargo.getCodigoCargoEmpleado());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    public void eliminar(int id){
        String sql = "delete from cargoEmpleado where codigoCargoEmpleado =" + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeQuery();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}