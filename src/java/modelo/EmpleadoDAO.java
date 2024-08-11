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
                em.setCodigoEmpleado(rs.getInt(1));
                em.setNombresEmpleado(rs.getString(2));
                em.setApellidosEmpleado(rs.getString(3));
                em.setDPIEmpleado(rs.getString(4));
                em.setSueldo(rs.getDouble(5));
                em.setDireccionEmpleado(rs.getString(6));
                em.setUsuario(rs.getString(7));
                em.setTurno(rs.getString(8));
                em.setImgEmpleado(rs.getBinaryStream(9));
                em.setCodigoCargoEmpleado(rs.getInt(10)); // Asegúrate de que esto es correcto
                listaEmpleado.add(em);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaEmpleado;
    }
   
    //AGREGAR
    public int agregar(Empleado emp){
        String sql = "insert into Empleados (nombresEmpleado, apellidosEmpleado, DPIEmpleado, sueldo, direccionEmpleado, usuario, turno, imgEmpleado, codigoCargoEmpleado) values(?,?,?,?,?,?,?,?,?)";
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
            ps.setBlob(8, emp.getImgEmpleado());
            ps.setInt(9, emp.getCodigoCargoEmpleado());
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
                
                emp.setCodigoEmpleado(rs.getInt(1));
                emp.setNombresEmpleado(rs.getString(2));
                emp.setApellidosEmpleado(rs.getString(3));
                emp.setDPIEmpleado(rs.getString(4));
                emp.setSueldo(rs.getDouble(5));
                emp.setDireccionEmpleado(rs.getString(6));
                emp.setUsuario(rs.getString(7));
                emp.setTurno(rs.getString(8));
                emp.setImgEmpleado(rs.getBinaryStream(9));
                emp.setCodigoCargoEmpleado(rs.getInt(10)); // Asegúrate de que esto es correcto

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return emp;
    }
    
    // LISTAR IMAGEN
    public void listarImagen(int id, HttpServletResponse response){
        String sql = "Select imgEmpleado from Empleados where codigoEmpleado="+id;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        response.setContentType("image/*");
        
        try{
            outputStream = response.getOutputStream();
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                inputStream = rs.getBinaryStream("imgEmpleado");
            }
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            int i=0;
            while((i=bufferedInputStream.read())!=-1){
                bufferedOutputStream.write(i);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //MÉTODO EDITAR
    public int actualizar(Empleado emp){
        String sql = "update Empleados set nombresEmpleado = ?, apellidosEmpleado = ?, DPIEmpleado = ?, sueldo = ?, direccionEmpleado = ?, usuario = ?, turno = ?, imgEmpleado = ? where codigoEmpleado = ?";
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
            ps.setBlob(8, emp.getImgEmpleado());
            ps.setInt(9, emp.getCodigoEmpleado());

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
