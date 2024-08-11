/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static java.awt.SystemColor.menu;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelo.CargoEmpleado;
import modelo.CargoEmpleadoDAO;
import modelo.Cliente;
import modelo.ClientesDAO;
import modelo.Compra;
import modelo.CompraDAO;
import modelo.DetalleCompra;
import modelo.DetalleCompraDAO;
import modelo.EmailProveedor;
import modelo.EmailProveedorDAO;
import modelo.Empleado;
import modelo.EmpleadoDAO;
import modelo.Producto;
import modelo.ProductoDAO;
import modelo.Proveedores;
import modelo.ProveedoresDAO;
import modelo.TelefonoProveedor;
import modelo.TelefonoProveedorDAO;
import modelo.TipoProducto;
import modelo.TipoProductoDAO;


@MultipartConfig
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
    Cliente cliente = new Cliente();
    ClientesDAO clientesDao = new ClientesDAO();
    Compra compra = new Compra();
    CompraDAO compraDao = new CompraDAO();
    DetalleCompra detalleCompra = new DetalleCompra();
    DetalleCompraDAO detalleCompraDao = new DetalleCompraDAO();
    CargoEmpleado cargoEmpleado = new CargoEmpleado();
    CargoEmpleadoDAO cargoEmpleadoDao = new CargoEmpleadoDAO();
    Producto producto = new Producto();
    ProductoDAO productoDao = new ProductoDAO();

    int numeroDocumento;
    int codTipoProducto, codProveedores, codEmailProveedor, codTelefonoProveedor, codDetalleCompra, codCargoEmpleado, codEmpleado; 
    int codClientes;
    String codProducto;

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
        }else if(menu.equals("Home")) {
            request.getRequestDispatcher("Home.jsp").forward(request, response);
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
                    proveedoresDao.actualizar(proveedores);
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
            switch(accion){
                case "Listar":
                    List listaCompra = compraDao.listar();
                    request.setAttribute("compras", listaCompra);
                    break;
                case "Agregar":
                    numeroDocumento = Integer.parseInt(request.getParameter("txtNumeroDocumento"));
                    String fechaDocumento = request.getParameter("txtFechaDocumento");
                    String descripcion = request.getParameter("txtDescripcion");
                    compra.setNumeroDocumento(numeroDocumento);
                    compra.setFechaDocumento(fechaDocumento);
                    compra.setDescripcion(descripcion);
                    compraDao.agregar(compra);
                    request.getRequestDispatcher("Controlador?menu=Compra&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    numeroDocumento = Integer.parseInt(request.getParameter("numeroDocumento"));
                    Compra c = compraDao.listarNumeroDocumento(numeroDocumento);
                    request.setAttribute("compra", c);
                    request.getRequestDispatcher("Controlador?menu=Compra&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String fechaDoc = request.getParameter("txtFechaDocumento");
                    String desc = request.getParameter("txtDescripcion");
                    compra.setFechaDocumento(fechaDoc);
                    compra.setDescripcion(desc);
                    compra.setNumeroDocumento(numeroDocumento);
                    compraDao.actualizar(compra);
                    request.getRequestDispatcher("Controlador?menu=Compra&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    numeroDocumento = Integer.parseInt(request.getParameter("numeroDocumento"));
                    compraDao.elimninar(numeroDocumento);
                    request.getRequestDispatcher("Controlador?menu=Compra&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Compra.jsp").forward(request, response);
        }else if(menu.equals("Clientes")) {
            switch(accion){
                case "Listar":
                    List<Cliente> listaClientes = clientesDao.listar();
                    request.setAttribute("clientes", listaClientes);
                    request.getRequestDispatcher("Clientes.jsp").forward(request, response);
                break;

                case "Agregar":
                    String NIT = request.getParameter("txtNITCliente");
                    String nombres = request.getParameter("txtNombresCliente");
                    String apellidos = request.getParameter("txtApellidosCliente");
                    String direccion = request.getParameter("txtDireccionCliente");
                    String telefono = request.getParameter("txtTelefonoCliente");
                    String email = request.getParameter("txtEmailCliente");
                    cliente.setNITCliente(NIT);
                    cliente.setNombresCliente(nombres);
                    cliente.setApellidosCliente(apellidos);
                    cliente.setDireccionCliente(direccion);
                    cliente.setTelefonoCliente(telefono);
                    cliente.setEmailCliente(email);
                    clientesDao.agregar(cliente);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                break;
                case "Editar":
                    codClientes = Integer.parseInt(request.getParameter("codigoCliente"));
                    Cliente c = clientesDao.ListarCodigoClientes(codClientes);
                    request.setAttribute("cliente", c);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                break;
                case "Actualizar":
                    String NITCl = request.getParameter("txtNITCliente");
                    String nombresCl = request.getParameter("txtNombresCliente");
                    String apellidosCl = request.getParameter("txtApellidosCliente");
                    String direccionCl = request.getParameter("txtDireccionCliente");
                    String telefonoCl = request.getParameter("txtTelefonoCliente");
                    String emailCl = request.getParameter("txtEmailCliente");
                    cliente.setNITCliente(NITCl);
                    cliente.setNombresCliente(nombresCl);
                    cliente.setApellidosCliente(apellidosCl);
                    cliente.setDireccionCliente(direccionCl);
                    cliente.setTelefonoCliente(telefonoCl);
                    cliente.setEmailCliente(emailCl);
                    cliente.setCodigoClientes(codClientes);
                    clientesDao.actualizar(cliente);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                break;
                case "Eliminar":
                    codClientes = Integer.parseInt(request.getParameter("codigoCliente"));
                    clientesDao.eliminar(codClientes);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                break;
        }
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }else if(menu.equals("CargoEmpleado")) {
            switch(accion){
                case "Listar":
                    List listaCargoEmpleados = cargoEmpleadoDao.listar();
                    request.setAttribute("cargoEmpleados", listaCargoEmpleados);
                    break;

                case "Agregar":                  
                    String nombre = request.getParameter("txtNombreCargo");
                    String descripcion = request.getParameter("txtDescripcionCargo");
                    cargoEmpleado.setNombreCargo(nombre);
                    cargoEmpleado.setDescripcionCargo(descripcion);
                    cargoEmpleadoDao.agregar(cargoEmpleado);
                    request.getRequestDispatcher("Controlador?menu=CargoEmpleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    codCargoEmpleado = Integer.parseInt(request.getParameter("codigoCargoEmpleado"));
                    CargoEmpleado ce = cargoEmpleadoDao.listarCodigoCargoEmpleado(codCargoEmpleado);
                    request.setAttribute("cargoEmpleado", ce);
                    request.getRequestDispatcher("Controlador?menu=CargoEmpleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    
                    String nom = request.getParameter("txtNombreCargo");
                    String desc = request.getParameter("txtDescripcionCargo");

                    cargoEmpleado.setNombreCargo(nom);
                    cargoEmpleado.setDescripcionCargo(desc);
                    cargoEmpleado.setCodigoCargoEmpleado(codCargoEmpleado);
                    cargoEmpleadoDao.actualizar(cargoEmpleado);
                    request.getRequestDispatcher("Controlador?menu=CargoEmpleado&accion=Listar").forward(request, response);
                    break;

                case "Eliminar":
                    codCargoEmpleado = Integer.parseInt(request.getParameter("codigoCargoEmpleado"));
                    cargoEmpleadoDao.eliminar(codCargoEmpleado);
                    request.getRequestDispatcher("Controlador?menu=CargoEmpleado&accion=Listar").forward(request, response);
                    break;

            }
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
            switch(accion){
                case"Listar":
                    List listaProductos = productoDao.listar();
                    request.setAttribute("productos", listaProductos);
                break;
                case "Agregar":
                    String codiProducto = request.getParameter("txtCodigoProducto");
                    String descriProducto = request.getParameter("txtDescripcionProducto");
                    double preciUnitario = Double.parseDouble(request.getParameter("txtPrecioUnitario")) ;
                    int exist = Integer.parseInt(request.getParameter("txtExistencia")) ;
                    int codiTipoProducto = Integer.parseInt(request.getParameter("txtCodigoTipoProducto"));
                    int codiProveedor = Integer.parseInt(request.getParameter("txtCodigoProveedor"));
                    
                    Part part = request.getPart("imagenProducto1");
                    InputStream inputStream = part.getInputStream();
                    
            
                    producto.setCodigoProducto(codiProducto);
                    producto.setDescripcionProducto(descriProducto);
                    producto.setPrecioUnitario(preciUnitario);
                    producto.setExistencia(exist);
                    producto.setCodigoTipoProducto(codiTipoProducto);
                    producto.setCodigoProveedor(codiProveedor);
                    
                    if(part !=null && part.getSize()>0){
                        producto.setImagenProducto(inputStream);
                     }else{
                         producto.setImagenProducto(null);
                    }
                    
                    productoDao.agregar(producto);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    
                    
                    codProducto = request.getParameter("codigoProducto");
                    Producto t = productoDao.listarCodigoProducto(codProducto);
                    request.setAttribute("producto", t);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String descripcionProductoA = request.getParameter("txtDescripcionProducto");
                    double precioUnitarioA = Double.parseDouble(request.getParameter("txtPrecioUnitario"));
                    int existenciaA = Integer.parseInt(request.getParameter("txtExistencia"));
                    
                    Part parte = request.getPart("imagenProducto1");
                    InputStream inputSt = parte.getInputStream();
                    
                    producto.setDescripcionProducto(descripcionProductoA);
                    producto.setPrecioUnitario(precioUnitarioA);
                    producto.setExistencia(existenciaA);
                    producto.setCodigoProducto(codProducto);
                    
                    if(parte !=null && parte.getSize()>0){
                         producto.setImagenProducto(inputSt);
                    }else{
                        Producto productoExistente = productoDao.listarCodigoProducto(codProducto);
                        producto.setImagenProducto(productoExistente.getImagenProducto());
                    }
                    
                    productoDao.actualizar(producto);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codProducto = request.getParameter("codigoProducto");
                    productoDao.eliminar(codProducto);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
            }


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
            switch(accion){
            case "Listar":
                    List listaEmpleado = empleadoDao.listar();
                    request.setAttribute("empleados", listaEmpleado);
                    break;
                case "Agregar":
                    String nombres = request.getParameter("txtNombresEmpleado");
                    String apellidos = request.getParameter("txtApellidosEmpleado");
                    String DPI = request.getParameter("txtDPIEmpleado");
                    Double sueldo = Double.parseDouble(request.getParameter("txtSueldo"));
                    String direccion = request.getParameter("txtDireccionEmpleado");
                    String usuario = request.getParameter("txtUsuario");
                    String turno = request.getParameter("txtTurno");
                    //codCargoEmpleado = Integer.parseInt(request.getParameter("txtCodigoCargoEmpleado"));
                    String tipoCargoEmpleado = request.getParameter("txtCodigoCargoEmpleado");

                    Part part = request.getPart("imagenEmpleado");
                    InputStream inputStream = part.getInputStream();
 
                    empleado.setNombresEmpleado(nombres);
                    empleado.setApellidosEmpleado(apellidos);
                    empleado.setDPIEmpleado(DPI);
                    empleado.setSueldo(sueldo);
                    empleado.setDireccionEmpleado(direccion);
                    empleado.setUsuario(usuario);
                    empleado.setTurno(turno);
                    //empleado.setCodigoCargoEmpleado(codCargoEmpleado);
                    empleado.setCodigoCargoEmpleado(Integer.parseInt(tipoCargoEmpleado));
  
                    
                    if(part !=null && part.getSize()>0){
                        empleado.setImgEmpleado(inputStream);
                    }else{
                        empleado.setImgEmpleado(null);
                    }
                    
                    
                    empleadoDao.agregar(empleado);
                    request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    codEmpleado = Integer.parseInt(request.getParameter("codigoEmpleado"));
                    Empleado e = empleadoDao.listarCodigoEmpleado(codEmpleado);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nomb = request.getParameter("txtNombresEmpleado");
                    String apell = request.getParameter("txtApellidosEmpleado");
                    String DPIEm = request.getParameter("txtDPIEmpleado");
                    Double suel = Double.parseDouble(request.getParameter("txtSueldo"));
                    String direc = request.getParameter("txtDireccionEmpleado");
                    String usu = request.getParameter("txtUsuario");
                    String tur = request.getParameter("txtTurno");

                    Part parte = request.getPart("imagenEmpleado");
                    InputStream inputSt = parte.getInputStream();
 
                    empleado.setNombresEmpleado(nomb);
                    empleado.setApellidosEmpleado(apell);
                    empleado.setDPIEmpleado(DPIEm);
                    empleado.setSueldo(suel);
                    empleado.setDireccionEmpleado(direc);
                    empleado.setUsuario(usu);
                    empleado.setTurno(tur);
                    //empleado.setCodigoCargoEmpleado(codCargoEmpleado);
                    empleado.setCodigoEmpleado(codEmpleado);
  
                    
                    if(parte !=null && parte.getSize()>0){
                        empleado.setImgEmpleado(inputSt);
                    }else{
                        Empleado empleadoExistente = empleadoDao.listarCodigoEmpleado(codEmpleado);
                        empleado.setImgEmpleado(empleadoExistente.getImgEmpleado());
                    }
                    
                    
                    empleadoDao.actualizar(empleado);
                    request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
                case "Eliminar":
                    codEmpleado = Integer.parseInt(request.getParameter("codigoEmpleado"));
                    empleadoDao.eliminar(codEmpleado);
                    request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
                    break;
            }request.getRequestDispatcher("Empleados.jsp").forward(request, response);
        }else if(menu.equals("Factura")) {
            request.getRequestDispatcher("Factura.jsp").forward(request, response);
        }else if(menu.equals("DetalleCarrito")) {
            request.getRequestDispatcher("DetalleCarrito.jsp").forward(request, response);
        }else if(menu.equals("Carrito")) {
            request.getRequestDispatcher("Carrito.jsp").forward(request, response);
        }else if(menu.equals("DetalleCompra")) {
            switch(accion){
                case "Listar":
                    List listaDetalleCompras = detalleCompraDao.listar();
                    request.setAttribute("detalleCompras", listaDetalleCompras);
                    break;
                case "Agregar":
                    Double costoUnitario = Double.parseDouble(request.getParameter("txtCostoUnitario"));
                    int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
                    String codigoProducto = request.getParameter("txtCodigoProducto");
                    int numeroDocumento = Integer.parseInt(request.getParameter("txtNumeroDocumento"));
                    detalleCompra.setCostoUnitario(costoUnitario);
                    detalleCompra.setCantidad(cantidad);
                    detalleCompra.setCodigoProducto(codigoProducto);
                    detalleCompra.setNumeroDocumento(numeroDocumento);
                    detalleCompraDao.agregar(detalleCompra);
                    request.getRequestDispatcher("Controlador?menu=DetalleCompra&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    codDetalleCompra = Integer.parseInt(request.getParameter("codigoDetalleCompra"));
                    DetalleCompra dc = detalleCompraDao.ListarDetalleCompra(codDetalleCompra);
                    request.setAttribute("detalleCompra", dc);
                    request.getRequestDispatcher("Controlador?menu=DetalleCompra&accion=Listar").forward(request, response);
                break;
                case "Actualizar":
                    Double costoUni = Double.parseDouble(request.getParameter("txtCostoUnitario"));
                    int canti = Integer.parseInt(request.getParameter("txtCantidad"));

                    detalleCompra.setCostoUnitario(costoUni);
                    detalleCompra.setCantidad(canti);

                    detalleCompra.setCodigoDetalleCompra(codDetalleCompra);
                    detalleCompraDao.actualizar(detalleCompra);


                    request.getRequestDispatcher("Controlador?menu=DetalleCompra&accion=Listar").forward(request, response);
                    
                break;
                case "Eliminar":
                    codDetalleCompra = Integer.parseInt(request.getParameter("codigoDetalleCompra"));
                    detalleCompraDao.eliminar(codDetalleCompra);
                    request.getRequestDispatcher("Controlador?menu=DetalleCompra&accion=Listar").forward(request, response);
                
                break;
            }   
            
            request.getRequestDispatcher("DetalleCompra.jsp").forward(request, response);
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
