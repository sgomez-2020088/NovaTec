<%-- 
    Document   : EmailProveedor
    Created on : 12/07/2024, 10:25:34 PM
    Author     : Sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página EmailProveedor</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">    </head>

    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    
                    <form action="Controlador?menu=EmailProveedor" method="POST">
                        <div class="form-group">
                            <label><strong>Codigo:</strong></label>
                            <input type="text" value="" name="txtCodigoEmailProveedor" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Email:</strong></label>
                            <input type="text" value="" name="txtEmailProveedor" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Descripcion:</strong></label>
                            <input type="text" value="" name="txtDescripcion" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Codigo Proveedor:</strong></label>
                            <input type="text" value="" name="txtCodigoProveedor" class="form-control">
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
                            <th>EMAIL</th>
                            <th>DESCRIPCION</th>
                            <th>CODIGO PROVEEDOR</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="emailProveedor" items="${emailProveedores}">
                        <tr>
                            <td>${EmailProveedor.getCodigoProveedor()}</td>
                            <td>${EmailProveedor.getEmailProveedor()}</td>
                            <td>${EmailProveedor.getDescripcion()}</td>
                            <td>${EmailProveedor.getCodigoProveedor()}</td>
                            <td>
                                <a class="btn btn-warning" href="Controlador?menu=EmailProveedor&accion=Editar&codigoEmailProveedor=">Editar</a>
                                <a class="btn btn-danger" href="Controlador?menu=EmailProveedor&accion=Eliminar&codigoEmailProveedor=">Eliminar</a>
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
