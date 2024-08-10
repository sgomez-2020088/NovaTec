

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
Select * from Factura;
Select * from Factura where numeroFactura = 1001;

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


select * from emailProveedor;
insert into CargoEmpleado(nombreCargo, descripcionCargo) values('Gerente de contabilidad','Supervisa la contabilidad');


insert into Empleados (nombresEmpleado, apellidosEmpleado, DPIEmpleado, sueldo, direccionEmpleado, usuario, turno, codigoCargoEmpleado) 
	values ('Sergio','Gomez','123',12000,'zona 7','sgomez','Nocturno',1);
insert into Empleados (nombresEmpleado, apellidosEmpleado, DPIEmpleado, sueldo, direccionEmpleado, usuario, turno, codigoCargoEmpleado) 
	values ('Ricardo','Galindo','1234',12000,'zona 3','saurio','Nocturno',1);



-- Datos de ejemplo para la tabla TipoProducto
INSERT INTO TipoProducto (descripcion)
VALUES
('Electrónicos'),
('Ropa');


-- Datos de ejemplo para la tabla Proveedores
INSERT INTO Proveedores (NITProveedor, nombresProveedor, apellidosProveedor, direccionProveedor, razonSocial, contactoPrincipal, paginaWeb)
VALUES
('1234567890', 'Tecno', 'S.A.', 'Avenida Reforma 1-01, Zona 9, Ciudad de Guatemala', 'Tecno S.A.', 'Juan Pérez', 'www.tecno.com.gt'),
('9876543210', 'Distribuciones', 'Global', 'Calzada Roosevelt 10-20, Zona 7, Ciudad de Guatemala', 'Distribuciones Global S.A.', 'Ana López', 'www.global.com.gt');


-- Datos de ejemplo para la tabla Compras
INSERT INTO Compras (numeroDocumento, fechaDocumento, descripcion, totalDocumento)
VALUES
(1001, '2024-07-15', 'Compra de electrodomésticos', 1500.50),
(1002, '2024-07-16', 'Compra de ropa', 800.00);


-- Datos de ejemplo para la tabla Clientes
INSERT INTO Clientes (NITCliente, nombresCliente, apellidosCliente, direccionCliente, telefonoCliente, emailCliente)
VALUES
('1234567890', 'Carlos', 'Gómez', 'Zona 1, Ciudad de Guatemala', '12345678', 'carlos.gomez@example.com'),
('9876543210', 'Lucía', 'Rodríguez', 'Zona 10, Ciudad de Guatemala', '87654321', 'lucia.rodriguez@example.com');


-- Datos de ejemplo para la tabla CargoEmpleado
INSERT INTO CargoEmpleado (nombreCargo, descripcionCargo)
VALUES
('Gerente', 'Responsable de la gestión de la empresa'),
('Vendedor', 'Encargado de las ventas');


-- Datos de ejemplo para la tabla TelefonoProveedor
INSERT INTO TelefonoProveedor (numeroPrincipal, numeroSecundario, observaciones, codigoProveedor)
VALUES
('55554444', '55554445', 'Horario de oficina', 1),
('55553333', '55553334', 'Disponible 24/7', 2);


-- Datos de ejemplo para la tabla Productos
INSERT INTO Productos (codigoProducto, descripcionProducto, precioUnitario, precioDocena, precioMayor, imagenProducto, existencia, codigoTipoProducto, codigoProveedor)
VALUES
('P001', 'Televisor LED 55"', 500.00, 5800.00, 450.00, NULL, 100, 1, 1),
('P002', 'Camiseta de Algodón', 15.00, 160.00, 13.00, NULL, 200, 2, 2);


-- Datos de ejemplo para la tabla DetalleCompra
INSERT INTO DetalleCompra (costoUnitario, cantidad, codigoProducto, numeroDocumento)
VALUES
(480.00, 10, 'P001', 1001),
(14.00, 50, 'P002', 1002);


-- Datos de ejemplo para la tabla EmailProveedor
INSERT INTO EmailProveedor (emailProveedor, descripcion, codigoProveedor)
VALUES
('contacto@tecno.com.gt', 'Email principal', 1),
('soporte@global.com.gt', 'Email de soporte', 2);


-- Datos de ejemplo para la tabla Empleados
INSERT INTO Empleados (nombresEmpleado, apellidosEmpleado, DPIEmpleado, sueldo, direccionEmpleado, usuario, turno, codigoCargoEmpleado)
VALUES
('Juan', 'Pérez', '1234567890101', 4500.00, 'Zona 5, Ciudad de Guatemala', 'jperez', 'Mañana', 1),
('Ana', 'García', '9876543210101', 3500.00, 'Zona 9, Ciudad de Guatemala', 'agarcia', 'Tarde', 2);


-- Datos de ejemplo para la tabla Factura
INSERT INTO Factura (numeroFactura, estado, totalFactura, fechaFactura, codigoCliente, codigoEmpleado)
VALUES
(1001, 'Pagada', 230.75, '2024-07-20', 1, 1),
(1002, 'Pendiente', 150.50, '2024-07-21', 2, 2);


-- Datos de ejemplo para la tabla Carrito
INSERT INTO Carrito (codigoCliente)
VALUES
(1),
(2);


-- Datos de ejemplo para la tabla DetalleCarrito
INSERT INTO DetalleCarrito (codigoCarrito, codigoProducto, cantidad, Total)
VALUES
(1, 'P001', 2, 1000.00),
(2, 'P002', 5, 75.00);
