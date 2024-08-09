/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static java.awt.SystemColor.menu;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.EmailProveedor;
import modelo.EmailProveedorDAO;
import modelo.Empleado;
import modelo.EmpleadoDAO;
import modelo.Proveedores;
import modelo.ProveedoresDAO;
import modelo.TelefonoProveedor;
import modelo.TelefonoProveedorDAO;
import modelo.TipoProducto;
import modelo.TipoProductoDAO;

/**
 *
 * @author informatica
 */
public class Controlador extends HttpServlet {
    Empleado empleado = new Empleado();
    EmpleadoDAO empleadoDao = new EmpleadoDAO();
    TipoProducto tipoProducto = new TipoProducto();
    TipoProductoDAO tipoProductoDao = new TipoProductoDAO();
    TelefonoProveedorDAO telefonoProveedorDao = new TelefonoProveedorDAO();
    ProveedoresDAO proveedoresDao = new ProveedoresDAO();
    Proveedores proveedores = new Proveedores();
    EmailProveedor emailProveedor = new EmailProveedor();
    TelefonoProveedor telefonoProveedor = new TelefonoProveedor();
    EmailProveedorDAO emailProveedorDao = new EmailProveedorDAO();
    int codTipoProducto, codProveedores, codEmailProveedor, codTelefonoProveedor; 

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion"); 
        if(menu.equals("Principal")){
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }else if(menu.equals("TipoProducto")) {
            switch(accion){
                case"Listar":
                    List listaTipoProductos = tipoProductoDao.listar();
                    request.setAttribute("tipoProductos", listaTipoProductos);
                break;
            case "Agregar":
                    String descripcion = request.getParameter("txtDescripcion");
                    tipoProducto.setDescripcion(descripcion);
                    tipoProductoDao.agregar(tipoProducto);
                    request.getRequestDispatcher("Controlador?menu=TipoProducto&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    codTipoProducto = Integer.parseInt(request.getParameter("codigoTipoProducto"));
                    TipoProducto tp = tipoProductoDao.listarCodigoTipoProducto(codTipoProducto);
                    request.setAttribute("tipoProducto", tp);
                    request.getRequestDispatcher("Controlador?menu=TipoProducto&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String descripcionTp = request.getParameter("txtDescripcion");
                    tipoProducto.setDescripcion(descripcionTp);
                    tipoProducto.setCodigoTipoProducto(codTipoProducto);
                    tipoProductoDao.actualizar(tipoProducto);
                    request.getRequestDispatcher("Controlador?menu=TipoProducto&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codTipoProducto = Integer.parseInt(request.getParameter("codigoTipoProducto"));
                    tipoProductoDao.eliminar(codTipoProducto);
                    request.getRequestDispatcher("Controlador?menu=TipoProducto&accion=Listar").forward(request, response);
                    break;
            }request.getRequestDispatcher("TipoProducto.jsp").forward(request, response);
        }//----------------------------------------PROVEEDORES------------------------------------------------------- 
        else if(menu.equals("Proveedores")) {
            switch(accion){
                case"Listar":
                    List listaProveedoress = proveedoresDao.listar();
                    request.setAttribute("proveedoress", listaProveedoress);
                break;
            case "Agregar":
                    String NITProveedor = request.getParameter("txtNITProveedor");
                    String NombresProveedor = request.getParameter("txtNombresProveedor");
                    String ApellidosProveedor = request.getParameter("txtApellidosProveedor");
                    String DireccionProveedor = request.getParameter("txtDireccionProveedor");
                    String RazonSocial = request.getParameter("txtRazonSocial");
                    String ContactoPrincipal = request.getParameter("txtContactoPrincipal");
                    String paginaWeb = request.getParameter("txtPaginaWeb");
                    
                    proveedores.setNITProveedor(NITProveedor);
                    proveedores.setNombresProveedor(NombresProveedor);
                    proveedores.setApellidosProveedor(ApellidosProveedor);
                    proveedores.setDireccionProveedor(DireccionProveedor);
                    proveedores.setRazonSocial(RazonSocial);
                    proveedores.setContactoPrincipal(ContactoPrincipal);
                    proveedores.setPaginaWeb(paginaWeb);
                    proveedoresDao.agregar(proveedores);
                    request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    codProveedores = Integer.parseInt(request.getParameter("codigoProveedor"));
                    Proveedores p = proveedoresDao.listarCodigoProveedores(codProveedores);
                    request.setAttribute("proveedores", p);
                    request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String NITProv = request.getParameter("txtNITProveedor");
                    String nombresProv = request.getParameter("txtNombresProveedor");
                    String apellidosProv = request.getParameter("txtApellidosProveedor");
                    String direccionProv = request.getParameter("txtDireccionProveedor");
                    String razonSocialProv = request.getParameter("txtRazonSocial");
                    String contactoPrincipalProv = request.getParameter("txtContactoPrincipal");
                    String paginaWebProv = request.getParameter("txtPaginaWeb");
                    proveedores.setNITProveedor(NITProv);
                    proveedores.setNombresProveedor(nombresProv);
                    proveedores.setApellidosProveedor(apellidosProv);
                    proveedores.setDireccionProveedor(direccionProv);
                    proveedores.setRazonSocial(razonSocialProv);
                    proveedores.setContactoPrincipal(contactoPrincipalProv);
                    proveedores.setPaginaWeb(paginaWebProv); 
                    proveedores.setCodigoProveedor(codProveedores);
                    proveedoresDao.agregar(proveedores);
                    request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codProveedores = Integer.parseInt(request.getParameter("codigoProveedor"));
                    proveedoresDao.eliminar(codProveedores);
                    request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);
                    break;
            }
            
            request.getRequestDispatcher("Proveedores.jsp").forward(request, response);
        }else if(menu.equals("Compra")) {
            request.getRequestDispatcher("Compra.jsp").forward(request, response);
        }else if(menu.equals("Clientes")) {
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }else if(menu.equals("CargoEmpleado")) {
            request.getRequestDispatcher("CargoEmpleado.jsp").forward(request, response);
        }else if(menu.equals("TelefonoProveedor")) {
            switch (accion){
                case "Listar":
                    List listaTelefonoProveedores = telefonoProveedorDao.listar();
                    request.setAttribute("telefonosProveedores", listaTelefonoProveedores);
                    break;
                case "Agregar":
                    String numeroP = request.getParameter("txtNumeroPrincipal");
                    String numeroS = request.getParameter("txtNumeroSecundario");
                    String obser = request.getParameter("txtObservaciones");
                    int codPr = Integer.parseInt(request.getParameter("txtCodigoProveedor"));
                    telefonoProveedor.setNumeroPrincipal(numeroP);
                    telefonoProveedor.setNumeroSecundario(numeroS);
                    telefonoProveedor.setObservaciones(obser);
                    telefonoProveedor.setCodigoProveedor(codPr);
                    telefonoProveedorDao.agregar(telefonoProveedor);
                    request.getRequestDispatcher("Controlador?menu=TelefonoProveedor&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    codTelefonoProveedor  = Integer.parseInt(request.getParameter("codigoTelefonoProveedor"));
                    TelefonoProveedor t = telefonoProveedorDao.listarCodigoTelefonoProveedor(codTelefonoProveedor);
                    request.setAttribute("telefonoProveedor", t);
                    request.getRequestDispatcher("Controlador?menu=TelefonoProveedor&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String numeroPri = request.getParameter("txtNumeroPrincipal");
                    String numeroSec = request.getParameter("txtNumeroSecundario");
                    String observa = request.getParameter("txtObservaciones");
                    telefonoProveedor.setNumeroPrincipal(numeroPri);
                    telefonoProveedor.setNumeroSecundario(numeroSec);
                    telefonoProveedor.setObservaciones(observa);
                    telefonoProveedor.setCodigoTelefonoProveedor(codTelefonoProveedor);
                    telefonoProveedorDao.actualizar(telefonoProveedor);
                    request.getRequestDispatcher("Controlador?menu=TelefonoProveedor&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codTelefonoProveedor = Integer.parseInt(request.getParameter("codigoTelefonoProveedor"));
                    telefonoProveedorDao.eliminar(codTelefonoProveedor);
                    request.getRequestDispatcher("Controlador?menu=TelefonoProveedor&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("TelefonoProveedor.jsp").forward(request, response);
        }else if(menu.equals("Producto")) {
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }else if(menu.equals("DetalleCarrito")) {
            request.getRequestDispatcher("DetalleCarrito.jsp").forward(request, response);
        }else if(menu.equals("EmailProveedor")) {
            switch(accion){
                case"Listar":
                    List listaEmailProveedores = emailProveedorDao.listar();
                    request.setAttribute("emailProveedores", listaEmailProveedores);
                break;
            case "Agregar":
                    String EmailProveedor = request.getParameter("txtEmailProveedor");
                    String Descripcion = request.getParameter("txtDescripcion");
                    int CodigoProveedor = Integer.parseInt(request.getParameter("txtCodigoProveedor"));
                    
                    emailProveedor.setEmailProveedor(EmailProveedor);
                    emailProveedor.setDescripcion(Descripcion);
                    emailProveedor.setCodigoProveedor(CodigoProveedor);
                    emailProveedorDao.agregar(emailProveedor);
                    request.getRequestDispatcher("Controlador?menu=EmailProveedor&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    codEmailProveedor = Integer.parseInt(request.getParameter("codigoEmailProveedor"));
                    EmailProveedor ep = emailProveedorDao.listarCodigoEmailProveedor(codEmailProveedor);
                    request.setAttribute("emailProveedor", ep);
                    request.getRequestDispatcher("Controlador?menu=EmailProveedor&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                     String EmailProv = request.getParameter("txtEmailProveedor");
                    String descripEmailProv = request.getParameter("txtDescripcion");
                    int codProv = Integer.parseInt(request.getParameter("txtCodigoProveedor"));
                    emailProveedor.setEmailProveedor(EmailProv);
                    emailProveedor.setDescripcion(descripEmailProv);
                    emailProveedor.setCodigoProveedor(codProv);
                    emailProveedor.setCodigoEmailProveedor(codEmailProveedor);
                    emailProveedorDao.actualizar(emailProveedor);
                    request.getRequestDispatcher("Controlador?menu=EmailProveedor&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codEmailProveedor = Integer.parseInt(request.getParameter("codigoEmailProveedor"));
                    emailProveedorDao.eliminar(codEmailProveedor);
                    request.getRequestDispatcher("Controlador?menu=EmailProveedor&accion=Listar").forward(request, response);
                    break;
            }
            
            
            
            
            request.getRequestDispatcher("EmailProveedor.jsp").forward(request, response);
        }else if(menu.equals("Empleados")) {
            request.getRequestDispatcher("Empleados.jsp").forward(request, response);
        }else if(menu.equals("Factura")) {
            request.getRequestDispatcher("Factura.jsp").forward(request, response);
        }else if(menu.equals("DetalleCarrito")) {
            request.getRequestDispatcher("DetalleCarrito.jsp").forward(request, response);
        }else if(menu.equals("Carrito")) {
            request.getRequestDispatcher("Carrito.jsp").forward(request, response);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
