<%-- 
    Document   : Productos
    Created on : 12/07/2024, 09:52:19 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Productos</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">    </head>
        <link href="style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    
                    <form action="Controlador?menu=Producto" method="POST" enctype="multipart/form-data">
                        <div class="form-group">
                            <label><strong>Codigo:</strong></label>
                            <input type="text" value="${producto.getCodigoProducto()}" name="txtCodigoProducto" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Descripcion:</strong></label>
                            <input type="text" value="${producto.getDescripcionProducto()}" name="txtDescripcionProducto" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Precio Unitario:</strong></label>
                            <input type="text" value="${producto.getPrecioUnitario()}" name="txtPrecioUnitario" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Existencia:</strong></label>
                            <input type="text" value="${producto.getExistencia()}" name="txtExistencia" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Codigo TipoProducto:</strong></label>
                            <input type="text" value="${producto.getCodigoTipoProducto()}" name="txtCodigoTipoProducto" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Codigo Proveedor:</strong></label>
                            <input type="text" value="${producto.getCodigoProveedor()}" name="txtCodigoProveedor" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                        <hr>
                        <input type="file" name="imagenProducto" value="Subir" class="btn btn-success">
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
                            <td>${producto.getCodigoProducto()}</td>
                            <td>${producto.getDescripcionProducto()}</td>
                            <td>${producto.getPrecioUnitario()}</td>
                            <td><img src="ImgController?idProducto=${producto.getCodigoProducto()}" width="100" height="100" onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/img/novatec.png;'"></td>
                            <td>${producto.getExistencia()}</td>
                            <td>${producto.getCodigoTipoProducto()}</td>
                            <td>${producto.getCodigoProveedor()}</td>

                            <td>
                                <a class="btn btn-warning" href="Controlador?menu=Producto&accion=Editar&codigoProducto=${producto.codigoProducto}">Editar</a>
                                <a class="btn btn-danger" href="Controlador?menu=Producto&accion=Eliminar&codigoProducto=${producto.codigoProducto}">Eliminar</a>
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
