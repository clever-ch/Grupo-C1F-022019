--SECCIÓN CUENTAS USUARIOS 
insert into Account	values (1, 'calle falsa 123', 'pepe@gmail.com', 'Berazategui', 'Pepe', '112233', 'ApellidoPepe', 'Montoto');
insert into Account values (2, 'calle falsa 123', 'jose@gmail.com', 'Quilmes', 'Jose','11223344', 'ApellidoJose', 'Yo');
insert into Account values (3, 'calle 32423', 'jose@gmail.com', 'Lomas', 'Juan','654645', 'ApellidoJuan', 'Acc');
insert into Account values (4, 'calle  65', 'jose@gmail.com', 'Banfield', 'Carlos','767463', 'ApellidoCarlos', 'Beti');
insert into Account values (5, 'calle falsa 123', 'jose@gmail.com', 'Capital', 'Pedro','564546', 'ApellidoPedro', 'car');
insert into Account values (6, 'calle 123', 'jose@gmail.com', 'Bera', 'Sebastian','4564564', 'ApellidoSebastian', 'Sebas');
insert into Account values (7, 'calle falsa 123', 'jose@gmail.com', 'Lanus', 'Damian','46456', 'ApellidoDamian', 'usProv');

--SECCIÓN BILLETERAS
insert into CUSTOMER_WALLET values (1, 10000.0, null);
insert into PROVIDER_WALLET values (1, 100.0, null);


--SECCIÓN TIPOS DE USUARIOS
insert into Customer values (1, 'cWs2CcO0C2YpPSfXoA964e03J1U2', 1, 1, 1, 1);
update CUSTOMER_WALLET set customer_id=1;
insert into Provider values (1, '', 1, 1, 2, 1);
update PROVIDER_WALLET set provider_id=1;

--SECCIÓN HISTORIAL DE PEDIDOS
insert into ORDER_HISTORY values (1, 2, 1, 1, null);


--SECCIÓN INFORMACIÓN DELIVERY
insert into DELIVERY_INFO values (1, 1);


--SECCIÓN DELIVERY--HORARIO DE ATENCIÓN
insert into DELIVERY_INFO_HOURS_ATTENTION values (1, '10:00:00');


--SECCIÓN DELIVERY--TIPO DE CAMBIO HABILITADO
insert into DELIVERY_INFO_SHIFTS_AVAILABLE values (1, 'Morning');


--SECCIÓN MENUS
insert into Menu values (1, '00:15:00', 50.0, 'Riquisimo pollo al horno con verduras', 20, 'Pollo al horno con vegetales', 2, 100, '2019-10-20', '2019-11-10', 1);
insert into Menu values (2, '00:15:00', 60.0, 'Exquisita carne al horno con papas', 20, 'Carne al horno con papas', 2, 150, '2019-10-20', '2019-11-10', 1);