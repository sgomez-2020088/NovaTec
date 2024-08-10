<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Página Compra</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" crossorigin="anonymous">
    <link href="style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <div class="d-flex">
        <div class="card col-sm-4">
            <div class="card-body">
                <form action="Controlador?menu=Compra" method="POST">
                        <div class="form-group">
                            <label><strong>No.Documento:</strong></label>
                            <input type="text" value="${compra.getNumeroDocumento()}" name="txtNumeroDocumento" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Fecha:</strong></label>
                            <input type="date" value="${compra.getFechaDocumento()}" name="txtFechaDocumento" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Descripcion:</strong></label>
                            <input type="text" value="${compra.getDescripcion()}" name="txtDescripcion" class="form-control">
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
                        <th>NO. DOCUMENTO</th>
                        <th>FECHA</th>
                        <th>DESCRIPCION</th>
                        <th>TOTAL</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="compra" items="${compras}">
                        <tr>    
                            <td>${compra.getNumeroDocumento()}</td>
                            <td>${compra.getFechaDocumento()}</td>
                            <td>${compra.getDescripcion()}</td>
                            <td>${compra.getTotalDocumento()}</td>
                            <td>
                                <a class="btn btn-warning" href="Controlador?menu=Compra&accion=Editar&numeroDocumento=${compra.getNumeroDocumento()}">Editar</a>
                                <a class="btn btn-danger" href="Controlador?menu=Compra&accion=Eliminar&numeroDocumento=${compra.getNumeroDocumento()}">Eliminar</a>
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