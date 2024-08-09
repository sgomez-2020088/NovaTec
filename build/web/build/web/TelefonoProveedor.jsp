<%-- 
    Document   : TelefonoProveedor
    Created on : 11/07/2024, 10:08:51 PM
    Author     : jonat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teléfono Proveedor</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">    </head>

    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    
                    <form action="Controlador?menu=TelefonoProveedor" method="POST">
                        <div class="form-group">
                            <label><strong>Numero Principal:</strong></label>
                            <input type="text" value="" name="txtNumeroPrincipal" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Numero Secundario:</strong></label>
                            <input type="text" value="" name="txtNumeroSecundario" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Observaciones:</strong></label>
                            <input type="text" value="" name="txtObservaciones" class="form-control">
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
                            <th>NUM. PRINCIPAL</th>
                            <th>NUM. SECUNDARIO</th>
                            <th>OBSERVACIONES</th>
                            <th>CODIGO PROVEEDOR</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="telefonoProveedor" items="${telefonoProveedores}">
                        <tr>
                            <td>${TelefonoProveedor.getCodigoTelefonoProveedor()}</td>
                            <td>${TelefonoProveedor.getNumeroPrincipal()}</td>
                            <td>${TelefonoProveedor.getNumeroSecundario()}</td>
                            <td>${TelefonoProveedor.getObservaciones()}</td>
                            <td>${TelefonoProveedor.getCodigoProveedor()}</td>

                            <td>
                                <a class="btn btn-warning" href="Controlador?menu=TelefonoProveedor&accion=Editar&codigoTelefonoProveedor=">Editar</a>
                                <a class="btn btn-danger" href="Controlador?menu=TelefonoProveedor&accion=Eliminar&codigoTelefonoProveedor=">Eliminar</a>
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