package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
        String sql = "select * from empleado";
        List<Empleado> listaEmpleado = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Empleado em = new Empleado();
                em.setCodigoEmpleado(rs.getInt(1));
                em.setNombresEmpleado(rs.getString(2));
                em.setApellidosEmpleado(rs.getString(3));
                em.setDPIEmpleado(rs.getString(4));
                em.setSueldo(rs.getDouble(5));
                em.setDireccionEmpleado(rs.getString(6));
                em.setUsuario(rs.getString(7));
                em.setTurno(rs.getString(8));
                em.setCodigoCargoEmpleado(rs.getInt(9));
                listaEmpleado.add(em);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaEmpleado;
    }
    
    //AGREGAR
    public int agregar(Empleado emp){
        String sql = "insert into Empleado (nombresEmpleado, apellidosEmpleado, DPIEmpleado, sueldo, direccionEmpleado, usuario, turno, codigoCargoEmpleado) values(?,?,?,?,?,?,?,?,?)";
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
        String sql = "Select * from Empleado where codigoEmpleado="+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                emp.setNombresEmpleado(rs.getString(2));
                emp.setApellidosEmpleado(rs.getString(3));
                emp.setDPIEmpleado(rs.getString(4));
                emp.setSueldo(rs.getDouble(5));
                emp.setDireccionEmpleado(rs.getString(6));
                emp.setUsuario(rs.getString(7));
                emp.setTurno(rs.getString(8));
                emp.setCodigoCargoEmpleado(rs.getInt(9));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return emp;
    }
    
    //ACTUALIZAR
    public int actualizar(Empleado emp){
        String sql = "Update Empleado set nombresEmpleado = ?, apellidosEmpleado = ?, DPIEmpleado = ?, sueldo = ?, direccionEmpleado = ?, usuario = ?, turno = ?, codigoCargoEmpleado = ?";
        try{
            con = cn.Conexion();
            ps.setString(1, emp.getNombresEmpleado());
            ps.setString(2, emp.getApellidosEmpleado());
            ps.setString(3, emp.getDPIEmpleado());
            ps.setDouble(4, emp.getSueldo());
            ps.setString(5, emp.getDireccionEmpleado());
            ps.setString(6, emp.getUsuario());
            ps.setString(7, emp.getTurno());
            ps.setInt(8, emp.getCodigoCargoEmpleado());
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    //ELIMINAR
    public void eliminar(int id){
        String sql = "delete from empleado where codigoEmpleado="+id;
        try{
            con = cn.Conexion();
            ps = con.prepareCall(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
