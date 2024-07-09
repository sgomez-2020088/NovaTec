drop database if exists DBNovaTec;
create database DBNovaTec;

use DBNovaTec;

Create table CargoEmpleado (
  codigoCargoEmpleado int not null Auto_increment,
  nombreCargo varchar(45) not null,
  descripcionCargo varchar(45) not null,
  Primary key (codigoCargoEmpleado)
);

Create table Clientes (
  codigoCliente int not null Auto_increment,
  NITCliente varchar(10) not null,
  nombresCliente varchar(50) not null,
  apellidosCliente varchar(50) not null,
  direccionCliente varchar(150) not null,
  telefonoCliente varchar(8) not null,
  emailCliente varchar(100) not null,
  username varchar(50) not null,
  contrasena varchar(50) not null,
  Primary key (codigoCliente)
);

Create table TipoProducto (
  codigoTipoProducto int not null Auto_increment,
  descripcion varchar(45) not null,
  Primary key (codigoTipoProducto)
);

Create table Compras (
  numeroDocumento int not null,
  fechaDocumento DATE not null,
  descripcion varchar(60) not null,
  totalDocumento decimal(10,2) Default 0.00,
  Primary key (numeroDocumento)
);

Create table Proveedores (
  codigoProveedor int not null Auto_increment,
  NITProveedor varchar(10) not null,
  nombresProveedor varchar(60) not null,
  apellidosProveedor varchar(60) not null,
  direccionProveedor varchar(60) not null,
  razonSocial varchar(60) not null,
  contactoPrincipal varchar(100) not null,
  paginaWeb varchar(50) not null,
  Primary key (codigoProveedor)
);

Create table Carrito (
  codigoCarrito int not null Auto_increment,
  codigoCliente int not null,
  Primary key (codigoCarrito),
  Foreign key (codigoCliente) References clientes (codigoCliente)
);

Create table Productos (
  codigoProducto varchar(15) not null,
  descripcionProducto varchar(45) not null,
  precioUnitario decimal(10,2) Default 0.00,
  precioDocena decimal(10,2) Default 0.00,
  precioMayor decimal(10,2) Default 0.00,
  imagenProducto Blob,
  existencia int Default 0,
  codigoTipoProducto int not null,
  codigoProveedor int not null,
  Primary key (codigoProducto),
  Foreign key (codigoProveedor) References proveedores (codigoProveedor),
  Foreign key (codigoTipoProducto) References tipoproducto (codigoTipoProducto)
);

Create table DetalleCarrito (
  codigoDetalleCarrito int not null Auto_increment,
  codigoCarrito int not null,
  codigoProducto varchar(15) not null,
  cantidad int not null,
  Total decimal(10,2) default 0.00,
  Primary key (codigoDetalleCarrito),
  Foreign key (codigoCarrito) References carrito (codigoCarrito),
  Foreign key (codigoProducto) References productos (codigoProducto)
);

Create table DetalleCompra (
  codigoDetalleCompra int not null Auto_increment,
  costoUnitario decimal(10,2) not null,
  cantidad int not null,
  codigoProducto varchar(15) not null,
  numeroDocumento int not null,
  Primary key (codigoDetalleCompra),
  Foreign key (numeroDocumento) References compras (numeroDocumento),
  Foreign key (codigoProducto) References productos (codigoProducto)
);

Create table Empleados (
  codigoEmpleado int not null,
  nombresEmpleado varchar(50) not null,
  apellidosEmpleado varchar(50) not null,
  sueldo decimal(10,2) not null,
  direccionEmpleado varchar(150) not null,
  turno varchar(15) not null,
  codigoCargoEmpleado int not null,
  Primary key (codigoEmpleado),
  Foreign key (codigoCargoEmpleado) References cargoempleado (codigoCargoEmpleado)
);

Create table Factura (
  numeroFactura int not null,
  estado varchar(50) not null,
  totalFactura decimal(10,2) Default 0.00,
  fechaFactura DATE not null,
  codigoCliente int not null,
  codigoEmpleado int not null,
  Primary key (numeroFactura),
  Foreign key (codigoCliente) References clientes (codigoCliente),
  Foreign key (codigoEmpleado) References empleados (codigoEmpleado)
);

Create table EmailProveedor (
  codigoEmailProveedor int not null Auto_increment,
  emailProveedor varchar(50) not null,
  descripcion varchar(100) not null,
  codigoProveedor int not null,
  Primary key (codigoEmailProveedor),
  Foreign key (codigoProveedor) References proveedores (codigoProveedor)
);

Create table TelefonoProveedor (
  codigoTelefonoProveedor int not null Auto_increment,
  numeroPrincipal varchar(8) not null,
  numeroSecundario varchar(8),
  observaciones varchar(45),
  codigoProveedor int not null,
  Primary key (codigoTelefonoProveedor),
  Foreign key (codigoProveedor) References proveedores (codigoProveedor)
);