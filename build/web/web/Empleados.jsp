<%-- 
    Document   : Empleados
    Created on : 12/07/2024, 03:43:30 PM
    Author     : diegd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Empleados</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">    </head>

    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    
                    <form action="Controlador?menu=Empleado" method="POST">
                        <div class="form-group">
                            <label><strong>Codigo:</strong></label>
                            <input type="text" value="" name="txtCodigoEmpleado" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Nombres:</strong></label>
                            <input type="text" value="" name="txtNombresEmpleado" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Apellidos:</strong></label>
                            <input type="text" value="" name="txtApellidosEmpleado" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>DPI:</strong></label>
                            <input type="text" value="" name="txtDPIEmpleado" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Sueldo:</strong></label>
                            <input type="text" value="" name="txtSueldo" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Direccion:</strong></label>
                            <input type="text" value="" name="txtDireccionEmpleado" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Usuario:</strong></label>
                            <input type="text" value="" name="txtUsuario" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>turno:</strong></label>
                            <input type="text" value="" name="txtTurno" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Codigo CargoEmpleado:</strong></label>
                            <input type="text" value="" name="txtCodigoCargoEmpleado" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>CODIGO</th>
                            <th>NOMBRES</th>
                            <th>APELLIDOS</th>
                            <th>DPI</th>
                            <th>SUELDO</th>
                            <th>DIRECCION</th>
                            <th>USUARIO</th>
                            <th>TURNO</th>
                            <th>COD. CARGOEMPLEADO</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="empleado" items="${empleados}">
                        <tr>
                            <td>${Empleado.getCodigoEmpleado()}</td>
                            <td>${Empleado.getNombresEmpleado()}</td>
                            <td>${Empleado.getApellidosEmpelado()}</td>
                            <td>${Empleado.getDPIEmpleado()}</td>
                            <td>${Empleado.getSuelo()}</td>
                            <td>${Empleado.getDireccionEmpleado()}</td>
                            <td>${Empleado.getUsuario()}</td>
                            <td>${Empleado.getTurno()}</td>
                            <td>${Empleado.getCodigoCargoEmpleado()}</td>

                            <td>
                                <a class="btn btn-warning" href="Controlador?menu=Empleado&accion=Editar&codigoEmpleado=">Editar</a>
                                <a class="btn btn-danger" href="Controlador?menu=Empleado&accion=Eliminar&codigoEmpleado=">Eliminar</a>
                            </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>

    </body>
</html>
