

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
  primary key PK_codigoCliente (codigoCliente)
);

Create table CargoEmpleado (
  codigoCargoEmpleado int not null auto_increment,
  nombreCargo varchar(45) not null,
  descripcionCargo varchar(45) not null,
  primary key PK_codigoCargoEmpleado (codigoCargoEmpleado)
);

Create table TelefonoProveedor (
  codigoTelefonoProveedor int not null auto_increment,
  numeroPrincipal varchar(8) not null,
  numeroSecundario varchar(8),
  observaciones varchar(45),
  codigoProveedor int not null,
  primary key PK_codigoTelefonoProveedor (codigoTelefonoProveedor),
  constraint FK_TelefonoProveedor_Proveedores 
	foreign key (codigoProveedor) references Proveedores (codigoProveedor)
);

Create table Productos (
  codigoProducto varchar(15) not null,
  descripcionProducto varchar(45) not null,
  precioUnitario decimal(10,2) default 0.00,
  precioDocena decimal(10,2) default 0.00,
  precioMayor decimal(10,2) default 0.00,
  imagenProducto longblob,
  existencia int default 0,
  codigoTipoProducto int not null,
  codigoProveedor int not null,
  primary key PK_codigoProducto (codigoProducto),
  constraint FK_Productos_Proveedores
	foreign key (codigoProveedor) references proveedores (codigoProveedor),
  constraint FK_Productos_TipoProducto 
	foreign key (codigoTipoProducto) references TipoProducto (codigoTipoProducto)
);

Create table DetalleCompra (
  codigoDetalleCompra int not null auto_increment,
  costoUnitario decimal(10,2) not null,
  cantidad int not null,
  codigoProducto varchar(15) not null,
  numeroDocumento int not null,
  primary key PK_codigoDetalleCompra (codigoDetalleCompra),
  constraint FK_DetalleCompra_Compras
	foreign key (numeroDocumento) references compras (numeroDocumento),
  constraint FK_DetalleCompra_Productos
	foreign key (codigoProducto) references productos (codigoProducto)
);

Create table EmailProveedor (
  codigoEmailProveedor int not null auto_increment,
  emailProveedor varchar(50) not null,
  descripcion varchar(100) not null,
  codigoProveedor int not null,
  primary key PK_codigoEmailProveedor (codigoEmailProveedor),
  constraint FK_EmailProveedor_Proveedores
	foreign key (codigoProveedor) references Proveedores (codigoProveedor)
);

Create table Empleados (
  codigoEmpleado int not null auto_increment,
  nombresEmpleado varchar(50) not null,
  apellidosEmpleado varchar(50) not null,
  DPIEmpleado varchar(15) not null,
  sueldo decimal(10,2) not null,
  direccionEmpleado varchar(150) not null,
  usuario varchar (20) not null,
  turno varchar(15) not null,
  codigoCargoEmpleado int not null,
  primary key PK_codigoEmpleado (codigoEmpleado),
  constraint FK_Empleados_CargoEmpleado foreign key (codigoCargoEmpleado) references CargoEmpleado (codigoCargoEmpleado)
);


Create table Factura (
  numeroFactura int not null,
  estado varchar(50) not null,
  totalFactura decimal(10,2) Default 0.00,
  fechaFactura date not null,
  codigoCliente int not null,
  codigoEmpleado int not null,
  primary key PK_numeroFactura (numeroFactura),
  constraint FK_Factura_Clientes
	foreign key (codigoCliente) references Clientes (codigoCliente),
  constraint FK_Factura_Empleados foreign key (codigoEmpleado) references Empleados (codigoEmpleado)
);

Create table Carrito (
  codigoCarrito int not null auto_increment,
  codigoCliente int not null,
  primary key PK_codigoCarrito (codigoCarrito),
  constraint FK_Carrito_Clientes 
	foreign key (codigoCliente) references clientes (codigoCliente)
);

Create table DetalleCarrito (
  codigoDetalleCarrito int not null auto_increment,
  codigoCarrito int not null,
  codigoProducto varchar(15) not null,
  cantidad int not null,
  Total decimal(10,2) default 0.00,
  primary key PK_codigoDetalleCarrito (codigoDetalleCarrito),
  constraint FK_DetalleCarrito_Carrito
	foreign key (codigoCarrito) references carrito (codigoCarrito),
  constraint FK_DetalleCarrito_Productos
	foreign key (codigoProducto) references productos (codigoProducto)
);

alter user 'root'@'localhost' IDENTIFIED WITH mysql_native_Password by 'admin';


insert into TipoProducto(descripcion) values('Monitores');
insert into TipoProducto(descripcion) values('Ordenadores');
select * from TipoProducto;
select * from proveedores;



select * from emailProveedor;
insert into CargoEmpleado(nombreCargo, descripcionCargo) values('Gerente de contabilidad','Supervisa la contabilidad');


insert into Empleados (nombresEmpleado, apellidosEmpleado, DPIEmpleado, sueldo, direccionEmpleado, usuario, turno, codigoCargoEmpleado) 
	values ('Sergio','Gomez','123',12000,'zona 7','sgomez','Nocturno',1);
insert into Empleados (nombresEmpleado, apellidosEmpleado, DPIEmpleado, sueldo, direccionEmpleado, usuario, turno, codigoCargoEmpleado) 
	values ('Ricardo','Galindo','1234',12000,'zona 3','saurio','Nocturno',1);


