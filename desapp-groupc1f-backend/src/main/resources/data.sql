--SECCIÓN CUENTAS USUARIOS 

insert into Account	values (1, 'calle falsa 123', 'pepe@gmail.com', 'Berazategui', 'Pepe', '112233', 'ApellidoPepe', 'usCust');
insert into Account values (2, 'calle falsa 123', 'jose@gmail.com', 'Quilmes', 'Jose','11223344', 'ApellidoJose', 'usProv');

--SECCIÓN BILLETERAS
insert into CUSTOMER_WALLET values (1, 100.0);
insert into PROVIDER_WALLET values (1, 10.0);


--SECCIÓN TIPOS DE USUARIOS
insert into Customer values (1, 'TOKENCust', 2, 2, 1, 1);
insert into Provider values (1, 'TOKENProv', 2, 1, 2, 1);


--SECCIÓN HISTORIAL DE PEDIDOS
insert into ORDER_HISTORY values (1, 2, 1, 1, null);


--SECCIÓN INFORMACIÓN DELIVERY
insert into DELIVERY_INFO values (1, 1);


--SECCIÓN DELIVERY--HORARIO DE ATENCIÓN
insert into DELIVERY_INFO_HOURS_ATTENTION values (1, '10:00:00');


--SECCIÓN DELIVERY--TIPO DE CAMBIO HABILITADO
insert into DELIVERY_INFO_SHIFTS_AVAILABLE values (1, 'Morning');


--SECCIÓN MENUS
insert into Menu values (1, '00:15:00', 50.0, 'Descripcion 1', 20, 'Nombre menu 1', 2, 100, '2019-10-20', '2019-11-10', 1);
