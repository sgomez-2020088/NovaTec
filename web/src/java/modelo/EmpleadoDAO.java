
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmpleadoDAO {
      
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
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
}
