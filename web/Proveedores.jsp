<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Página Proveedores</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" crossorigin="anonymous">
    <link href="style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <div class="d-flex">
        <div class="card col-sm-4">
            <div class="card-body"> 
                <form action="Controlador?menu=Proveedores" method="POST">

                    <div class="form-group">
                        <label><strong>NIT:</strong></label>
                        <input type="text" value="${proveedores.getNITProveedor()}" name="txtNITProveedor" class="form-control">
                    </div>
                    <div class="form-group">
                        <label><strong>Nombres:</strong></label>
                        <input type="text" value="${proveedores.getNombresProveedor()}" name="txtNombresProveedor" class="form-control">
                    </div>
                    <div class="form-group">
                        <label><strong>Apellidos:</strong></label>
                        <input type="text" value="${proveedores.getApellidosProveedor()}" name="txtApellidosProveedor" class="form-control">
                    </div>
                    <div class="form-group">
                        <label><strong>Direccion:</strong></label>
                        <input type="text" value="${proveedores.getDireccionProveedor()}" name="txtDireccionProveedor" class="form-control">
                    </div>
                    <div class="form-group">
                        <label><strong>Razon Social:</strong></label>
                        <input type="text" value="${proveedores.getRazonSocial()}" name="txtRazonSocial" class="form-control">
                    </div>
                    <div class="form-group">
                        <label><strong>Contacto:</strong></label>
                        <input type="text" value="${proveedores.getContactoPrincipal()}" name="txtContactoPrincipal" class="form-control">
                    </div>
                    <div class="form-group">
                        <label><strong>Pagina web:</strong></label>
                        <input type="text" value="${proveedores.getPaginaWeb()}" name="txtPaginaWeb" class="form-control">
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
                        <th>RAZON SOCIAL</th>
                        <th>CONTACTO</th>
                        <th>PAGINA WEB</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="proveedores" items="${proveedoress}">
                        <tr>
                            <td>${proveedores.getCodigoProveedor()}</td>
                            <td>${proveedores.getNITProveedor()}</td>
                            <td>${proveedores.getNombresProveedor()}</td>
                            <td>${proveedores.getApellidosProveedor()}</td>
                            <td>${proveedores.getDireccionProveedor()}</td>
                            <td>${proveedores.getRazonSocial()}</td>
                            <td>${proveedores.getContactoPrincipal()}</td>
                            <td>${proveedores.getPaginaWeb()}</td>
                            <td>
                                <a class="btn btn-warning" href="Controlador?menu=Proveedores&accion=Editar&codigoProveedor=${proveedores.getCodigoProveedor()}">Editar</a>
                                <a class="btn btn-danger" href="Controlador?menu=Proveedores&accion=Eliminar&codigoProveedor=${proveedores.getCodigoProveedor()}">Eliminar</a>
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
