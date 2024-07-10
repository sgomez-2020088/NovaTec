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

Create table Compras (
  numeroDocumento int not null,
  fechaDocumento date not null,
  descripcion varchar(60) not null,
  totalDocumento decimal(10,2) default 0.00,
  primary key PK_numeroDocumento (numeroDocumento)
);

Create table Clientes (
  codigoCliente int not null auto_increment,
  NITCliente varchar(10) not null,
  nombresCliente varchar(50) not null,
  apellidosCliente varchar(50) not null,
  direccionCliente varchar(150) not null,
  telefonoCliente varchar(8) not null,
  emailCliente varchar(100) not null,
  username varchar(50) not null,
  contrasena varchar(50) not null,
  primary key PK_codigoCliente (codigoCliente)
);

Create table CargoEmpleado (
  codigoCargoEmpleado int not null auto_increment,
  nombreCargo varchar(45) not null,
  descripcionCargo varchar(45) not null,
  primary key PK_codigoCargoEmpleado (codigoCargoEmpleado)
);