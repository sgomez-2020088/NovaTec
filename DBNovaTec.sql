/*
*	NovaTec
*	IN5AM
*  FILA 2
*    FECHA DE CREACIÓN:
*		05/07/2024
*	FECHA DE MODIFICACIÓN
*		09/07/2024
*/

drop database if exists DBNovaTec;
create database DBNovaTec;

use DBNovaTec;

Create table TipoProducto (
  codigoTipoProducto int not null auto_increment,
  descripcion varchar(45) not null,
  primary key PK_codigoTipoProducto (codigoTipoProducto)
);

Create table Proveedores (
  codigoProveedor int not null auto_increment,
  NITProveedor varchar(10) not null,
  nombresProveedor varchar(60) not null,
  apellidosProveedor varchar(60) not null,
  direccionProveedor varchar(60) not null,
  razonSocial varchar(60) not null,
  contactoPrincipal varchar(100) not null,
  paginaWeb varchar(50) not null,
  primary key PK_codigoProveedor (codigoProveedor)
);









