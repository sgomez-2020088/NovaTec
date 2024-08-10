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
import javax.servlet.http.Part;

public class EmpleadoDAO {
      
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public Empleado validar(String usuario, String DPIEmpleado){
        Empleado empleado = new Empleado();
        String sql ="select * from Empleados where usuario = ? and DPIEmpleado = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1,usuario);
            ps.setString(2, DPIEmpleado);
            rs = ps.executeQuery();
            while(rs.next()){
                empleado.setCodigoEmpleado(rs.getInt("codigoEmpleado"));
                empleado.setNombresEmpleado(rs.getString("nombresEmpleado"));
                empleado.setApellidosEmpleado("apellidosEmpleado");
                empleado.setDPIEmpleado(rs.getString("DPIEmpleado"));
                empleado.setUsuario(rs.getString("usuario"));
            }          
        }catch(Exception e){
            e.printStackTrace();
        }   
        return empleado;
    }
    
    //MÉTODOS DEL CRUD
    
    //LISTAR
    public List listar(){
        String sql = "select * from Empleados";
        List<Empleado> listaEmpleado = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Empleado em = new Empleado();
                em.setCodigoEmpleado(rs.getInt("codigoEmpleado"));
                em.setNombresEmpleado(rs.getString("nombresEmpleado"));
                em.setApellidosEmpleado(rs.getString("apellidosEmpleado"));
                em.setDPIEmpleado(rs.getString("DPIEmpleado"));
                em.setSueldo(rs.getDouble("sueldo"));
                em.setDireccionEmpleado(rs.getString("direccionEmpleado"));
                em.setUsuario(rs.getString("usuario"));
                em.setTurno(rs.getString("turno"));
                em.setCodigoCargoEmpleado(rs.getInt("codigoCargoEmpleado")); // Asegúrate de que esto es correcto
                listaEmpleado.add(em);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaEmpleado;
    }
   
    //AGREGAR
    public int agregar(Empleado emp){
        String sql = "insert into Empleados (nombresEmpleado, apellidosEmpleado, DPIEmpleado, sueldo, direccionEmpleado, usuario, turno, codigoCargoEmpleado) values(?,?,?,?,?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getNombresEmpleado());
            ps.setString(2, emp.getApellidosEmpleado());
            ps.setString(3, emp.getDPIEmpleado());
            ps.setDouble(4, emp.getSueldo());
            ps.setString(5, emp.getDireccionEmpleado());
            ps.setString(6, emp.getUsuario());
            ps.setString(7, emp.getTurno());
            ps.setInt(8, emp.getCodigoCargoEmpleado());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    //BUSCAR
    public Empleado listarCodigoEmpleado(int id){
        Empleado emp = new Empleado();
        String sql = "Select * from Empleados where codigoEmpleado="+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                
                emp.setCodigoEmpleado(rs.getInt("codigoEmpleado"));
                emp.setNombresEmpleado(rs.getString("nombresEmpleado"));
                emp.setApellidosEmpleado(rs.getString("apellidosEmpleado"));
                emp.setDPIEmpleado(rs.getString("DPIEmpleado"));
                emp.setSueldo(rs.getDouble("sueldo"));
                emp.setDireccionEmpleado(rs.getString("direccionEmpleado"));
                emp.setUsuario(rs.getString("usuario"));
                emp.setTurno(rs.getString("turno"));
                emp.setCodigoCargoEmpleado(rs.getInt("codigoCargoEmpleado")); // Asegúrate de que esto es correcto

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return emp;
    }
    
    //MÉTODO EDITAR
    public int actualizar(Empleado emp){
        String sql = "update Empleados set nombresEmpleado = ?, apellidosEmpleado = ?, DPIEmpleado = ?, sueldo = ?, direccionEmpleado = ?, usuario = ?, turno = ? where codigoEmpleado = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getNombresEmpleado());
            ps.setString(2, emp.getApellidosEmpleado());
            ps.setString(3, emp.getDPIEmpleado());
            ps.setDouble(4, emp.getSueldo());
            ps.setString(5, emp.getDireccionEmpleado());
            ps.setString(6, emp.getUsuario());
            ps.setString(7, emp.getTurno());
            ps.setInt(8, emp.getCodigoEmpleado());

            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    
  
    //ELIMINAR
    public void eliminar(int id){
        String sql = "delete from Empleados where codigoEmpleado="+id;
        try{
            con = cn.Conexion();
            ps = con.prepareCall(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
