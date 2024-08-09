<%-- 
    Document   : Clientes
    Created on : 11-jul-2024, 22:42:24
    Author     : Esvin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Clientes</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">    </head>

    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    
                    <form action="Controlador?menu=Cliente" method="POST">
                        <div class="form-group">
                            <label><strong>NIT:</strong></label>
                            <input type="text" value="" name="txtNITCliente" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Nombres:</strong></label>
                            <input type="text" value="" name="txtNombresCliente" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Apellidos:</strong></label>
                            <input type="text" value="" name="txtApellidosCliente" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Direccion:</strong></label>
                            <input type="text" value="" name="txtDireccionCliente" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Telefono:</strong></label>
                            <input type="text" value="" name="txtTelefonoCliente" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Email:</strong></label>
                            <input type="text" value="" name="txtEmailCliente" class="form-control">
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
                            <th>NIT</th>
                            <th>NOMBRES</th>
                            <th>APELLIDOS</th>
                            <th>DIRECCION</th>
                            <th>TELEFONO</th>
                            <th>EMAIL</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="cliente" items="${clientes}">
                        <tr>
                            <td>${Clientes.getCodigoCliente()}</td>
                            <td>${Clientes.getNITCliente()}</td>
                            <td>${Clientes.getNombresCliente()}</td>
                            <td>${Clientes.getApellidosCliente()}</td>
                            <td>${Clientes.getDireccionCliente()}</td>
                            <td>${Clientes.getTelefonoCliente()}</td>
                            <td>${Clientes.getEmailCliente()}</td>
                            <td>
                                <a class="btn btn-warning" href="Controlador?menu=Cliente&accion=Editar&codigoCliente=">Editar</a>
                                <a class="btn btn-danger" href="Controlador?menu=Cliente&accion=Eliminar&codigoCliente=">Eliminar</a>
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
