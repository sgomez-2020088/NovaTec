<%-- 
    Document   : Productos
    Created on : 12/07/2024, 09:52:19 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Productos</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">    </head>

    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    
                    <form action="Controlador?menu=Producto" method="POST">
                        <div class="form-group">
                            <label><strong>Codigo:</strong></label>
                            <input type="text" value="" name="txtCodigoProducto" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Descripcion:</strong></label>
                            <input type="text" value="" name="txtDescripcionProducto" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Precio Unitario:</strong></label>
                            <input type="text" value="" name="txtPrecioUnitario" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Precio Docena:</strong></label>
                            <input type="text" value="" name="txtPrecioDocena" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Precio Mayor:</strong></label>
                            <input type="text" value="" name="txtPrecioMayor" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Imagen:</strong></label>
                            <input type="text" value="" name="txtImagenProducto" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Existencia:</strong></label>
                            <input type="text" value="" name="txtExistencia" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Codigo TipoProducto:</strong></label>
                            <input type="text" value="" name="txtCdigoTipoProducto" class="form-control">
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
                            <th>DESCRIPCION</th>
                            <th>PRECIO UNI</th>
                            <th>PRECIO DOCE</th>
                            <th>PRECIO MAY</th>
                            <th>IMAGEN</th>
                            <th>EXISTENCIA</th>
                            <th>COD.TIPOPRODUCTO</th>
                            <th>COD.PROVEEDOR</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="producto" items="${productos}">
                        <tr>
                            <td>${Producto.getCodigoProducto()}</td>
                            <td>${Producto.getDescripcionProducto()}</td>
                            <td>${Producto.getPrecioUnitario()}</td>
                            <td>${Producto.getPrecioDocena()}</td>
                            <td>${Producto.getPrecioMayor()}</td>
                            <td>${Producto.getImagenProducto()}</td>
                            <td>${Producto.getExistencia()}</td>
                            <td>${Producto.getCodigoTipoProducto()}</td>
                            <td>${Producto.getCodigoTipoProveedor()}</td>

                            <td>
                                <a class="btn btn-warning" href="Controlador?menu=Producto&accion=Editar&codigoProducto=">Editar</a>
                                <a class="btn btn-danger" href="Controlador?menu=Producto&accion=Eliminar&codigoProducto=">Eliminar</a>
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
