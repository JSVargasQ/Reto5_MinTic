#crear, consultar, modificar, eliminar
CREATE SCHEMA fereterria;

USE fereterria;

CREATE TABLE inventarioProductos (
	referencia INT PRIMARY KEY,
	nombre varchar (50) NOT NULL,
    categoria varchar (50) NOT NULL,
    valorCompra INT,
    valorVenta INT,
    cantidadProducto INT
    );

INSERT INTO inventarioProductos (referencia, nombre, categoria, valorCompra, valorVenta, cantidadProducto) 
	VALUES (1001, "Martillo", "Herramienta", 30000, 40000, 10);
   
INSERT INTO inventarioProductos (referencia, nombre, categoria, valorCompra, valorVenta, cantidadProducto) 
	VALUES (1002, "Destornillador", "Herramienta", 20000, 25000, 5);

INSERT INTO inventarioProductos (referencia, nombre, categoria, valorCompra, valorVenta, cantidadProducto) 
	VALUES (1003, "Baldosa cuadrada x metro", "Piso", 10000, 20000, 15);
    
INSERT INTO inventarioProductos (referencia, nombre, categoria, valorCompra, valorVenta, cantidadProducto) 
	VALUES (1004, "Tubo 3/8 x metro", "PVC", 5000, 7000, 100);
        
select * from inventarioProductos;      