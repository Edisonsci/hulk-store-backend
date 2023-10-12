INSERT INTO Categoria (codigo, descripcion) VALUES ('1', 'Camisetas');
INSERT INTO categoria (codigo, descripcion) VALUES ('2', 'Vasos');
INSERT INTO categoria (codigo, descripcion) VALUES ('3', 'Comics');
INSERT INTO categoria (codigo, descripcion) VALUES ('4', 'Juguetes');
INSERT INTO categoria (codigo, descripcion) VALUES ('5', 'Accesorios');

insert into rol (rol, descripcion) values ('ROL ADMINISTRADOR', 'ROL ADMINISTRADOR');
insert into rol (rol, descripcion) values ('ROL VENDEDOR', 'ROL VENDEDOR');
insert into rol (rol, descripcion) values ('ROL EMPLEADO', 'ROL EMPLEADO');

INSERT INTO producto (nombre, descripcion, url, precio, cantidad, fecha, categoria_id) VALUES('Iron Man', 'Tony Stark / Iron Man en la película','https://img-cdn.hipertextual.com/files/2019/10/hipertextual-marvel-anuncia-iron-man-2020-2019897141.jpg',29,7,NOW(),3);
INSERT INTO producto (nombre, descripcion, url, precio, cantidad, fecha, categoria_id) VALUES('Hulk','Hulk Marvel Avengers: Infinity War','https://images-na.ssl-images-amazon.com/images/I/61TOFMEhRKL._SY450_.jpg',3,3,NOW(),4);
INSERT INTO producto (nombre, descripcion, url, precio, cantidad, fecha, categoria_id) VALUES('Thor','Thor - Marvel Avengers Assemble','https://sammacleod.files.wordpress.com/2016/02/thor.jpeg',15,19,NOW(),5);
INSERT INTO producto (nombre, descripcion, url, precio, cantidad, fecha, categoria_id) VALUES('Capitan America','Capitán América  es Steven "Steve" Rogers','https://cdn2.actitudfem.com/media/files/styles/large/public/field/image/marvel-podria-tener-a-su-primer-superheroe-gay-capitan_america.jpg',52,7,NOW(),5);
INSERT INTO producto (nombre, descripcion, url, precio, cantidad, fecha, categoria_id) VALUES('Spider-Man','Spider-Man: Far From Home','https://media.metrolatam.com/2019/06/07/spidermanfarfrom-b23dc3aa3d34a4b847dfdc537ef0377b-600x400.jpg',23,15,NOW(),1);
INSERT INTO producto (nombre, descripcion, url, precio, cantidad, fecha, categoria_id) VALUES('Superboy','descripcion','https://comicvine1.cbsistatic.com/uploads/scale_small/1/14487/6640750-superboy.jpg',13,15,NOW(),1);
INSERT INTO producto (nombre, descripcion, url, precio, cantidad, fecha, categoria_id) VALUES('Ciclope','Cíclope X Men Comic','https://www.jing.fm/clipimg/detail/243-2431017_cclope-x-men-comic-png-download-cyclops-marvel.png',25,120,NOW(),2);
INSERT INTO producto (nombre, descripcion, url, precio, cantidad, fecha, categoria_id) VALUES('Magneto','Marvel E2297 Legends Magneto','https://images-na.ssl-images-amazon.com/images/I/81-WFEliPTL._SY355_.jpg',65,9,NOW(),1);
INSERT INTO producto (nombre, descripcion, url, precio, cantidad, fecha, categoria_id) VALUES('Dr. Doom','Marvel película de Doctor Doom','https://img.europapress.es/fotoweb/fotonoticia_20191008135848_640.jpg',35,32,NOW(),2);
INSERT INTO producto (nombre, descripcion, url, precio, cantidad, fecha, categoria_id) VALUES('Daredevil','Daredevil volverá','https://i.blogs.es/30e8d2/daredevil-no-ha-acabado-marvel/450_1000.jpg',10,11,NOW(),3);


insert into usuario (apellidos, correo, direccion, fecha, nombres, password, rol, telefono) values ('Administrador', 'admin@tienda1.com', 'Quito', NOW(), 'Usuario', '1234', 1, 0994055064);
insert into usuario (apellidos, correo, direccion, fecha, nombres, password, rol, telefono) values ('Ventas', 'ventas@tienda1.com', 'Quito', NOW(), 'Usuario', '1234', 2, 0994055064);
insert into usuario (apellidos, correo, direccion, fecha, nombres, password, rol, telefono) values ('Empleado', 'empleado@tienda1.com', 'Quito', NOW(), 'Usuario', '1234', 3, 0994055064);

