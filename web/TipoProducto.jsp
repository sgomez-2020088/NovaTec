<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Página TipoProducto</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" crossorigin="anonymous">
    <link href="style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <div class="d-flex">
        <div class="card col-sm-4">
            <div class="card-body"> 
                <form action="Controlador?menu=TipoProducto" method="POST">
                    <div class="form-group">
                        <label><strong>Descripción:</strong></label>
                        <input type="text" value="${tipoProducto.getDescripcion()}" name="txtDescripcion" class="form-control">
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
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="tipoProducto" items="${tipoProductos}">
                        <tr>
                            <td>${tipoProducto.getCodigoTipoProducto()}</td>
                            <td>${tipoProducto.getDescripcion()}</td>
                            <td>
                                <a class="btn btn-warning" href="Controlador?menu=TipoProducto&accion=Editar&codigoTipoProducto=${tipoProducto.getCodigoTipoProducto()}">Editar</a>
                                <a class="btn btn-danger" href="Controlador?menu=TipoProducto&accion=Eliminar&codigoTipoProducto=${tipoProducto.getCodigoTipoProducto()}">Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" crossorigin="anonymous"></script>
</body>
</html>
