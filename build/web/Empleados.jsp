<%-- 
    Document   : Empleados
    Created on : 12/07/2024, 03:43:30 PM
    Author     : diegd
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Empleados</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link href="style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Empleados" method="POST" encrypte="multipart/form-data">
                        <div class="form-group">
                            <label><strong>Nombres:</strong></label>
                            <input type="text" value="${empleado.getNombresEmpleado()}" name="txtNombresEmpleado" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Apellidos:</strong></label>
                            <input type="text" value="${empleado.getApellidosEmpleado()}" name="txtApellidosEmpleado" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>DPI:</strong></label>
                            <input type="text" value="${empleado.getDPIEmpleado()}" name="txtDPIEmpleado" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Sueldo:</strong></label>
                            <input type="text" value="${empleado.getSueldo()}" name="txtSueldo" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Direccion:</strong></label>
                            <input type="text" value="${empleado.getDireccionEmpleado()}" name="txtDireccionEmpleado" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Usuario:</strong></label>
                            <input type="text" value="${empleado.getUsuario()}" name="txtUsuario" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Turno:</strong></label>
                            <input type="text" value="${empleado.getTurno()}" name="txtTurno" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Codigo CargoEmpleado:</strong></label>
                            <input type="text" value="${empleado.getCodigoCargoEmpleado()}" name="txtCodigoCargoEmpleado" class="form-control">
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
            <th>CÓDIGO</th>
            <th>NOMBRES</th>
            <th>APELLIDOS</th>
            <th>DPI</th>
            <th>SUELDO</th>
            <th>DIRECCIÓN</th>
            <th>USUARIO</th>
            <th>TRUNO</th>
            <th>COD.CARGO EMPLEADO</th>
            <th>ACCIONES</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="empleado" items="${empleados}">
            <tr>
                <td>${empleado.codigoEmpleado}</td>
                <td>${empleado.nombresEmpleado}</td>
                <td>${empleado.apellidosEmpleado}</td>
                <td>${empleado.DPIEmpleado}</td>
                <td>${empleado.sueldo}</td>
                <td>${empleado.direccionEmpleado}</td>
                <td>${empleado.usuario}</td>
                <td>${empleado.turno}</td>
                <td>${empleado.codigoCargoEmpleado}</td>
                <td>
                    <a class="btn btn-warning" href="Controlador?menu=Empleados&accion=Editar&codigoEmpleado=${empleado.codigoEmpleado}">Editar</a>
                    <a class="btn btn-danger" href="Controlador?menu=Empleados&accion=Eliminar&codigoEmpleado=${empleado.codigoEmpleado}">Eliminar</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    </body>
</html>

