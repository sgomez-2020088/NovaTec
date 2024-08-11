
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página DetalleCompra</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link href="style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=DetalleCompra" method="POST" encrypte="multipart/form-data">
                        <div class="form-group">
                            <label><strong>Costo Unitario:</strong></label>
                            <input type="text" value="${detalleCompra.getCostoUnitario()}" name="txtCostoUnitario" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Cantidad:</strong></label>
                            <input type="text" value="${detalleCompra.getCantidad()}" name="txtCantidad" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Codigo Producto:</strong></label>
                            <input type="text" value="${detalleCompra.getCodigoProducto()}" name="txtCodigoProducto" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Numero Documento:</strong></label>
                            <input type="text" value="${detalleCompra.getNumeroDocumento()}" name="txtNumeroDocumento" class="form-control">
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
                    <th>COSTO UNITARIO</th>
                    <th>CANTIDAD</th>
                    <th>COD. PRODUCTO</th>
                    <th>NUM. DOCUMENTO</th>
                    <th>ACCIONES</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="detalleCompra" items="${detalleCompras}">
                    <tr>
                        <td>${detalleCompra.codigoDetalleCompra}</td>
                        <td>${detalleCompra.costoUnitario}</td>
                        <td>${detalleCompra.cantidad}</td>
                        <td>${detalleCompra.codigoProducto}</td>
                        <td>${detalleCompra.numeroDocumento}</td>
                        <td>
                            <a class="btn btn-warning" href="Controlador?menu=DetalleCompra&accion=Editar&codigoDetalleCompra=${detalleCompra.codigoDetalleCompra}">Editar</a>
                            <a class="btn btn-danger" href="Controlador?menu=DetalleCompra&accion=Eliminar&codigoDetalleCompra=${detalleCompra.codigoDetalleCompra}">Eliminar</a>
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
