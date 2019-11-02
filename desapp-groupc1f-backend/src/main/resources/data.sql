--SECCIÓN CUENTAS USUARIOS 

insert into Account	values(1, 'calle falsa 123', 'pepe@gmail.com', 'Berazategui', 'Pepe', '112233', 'ApellidoPepe', 'usCust');
insert into Account values (2, 'usProv', 'Jose', 'ApellidoJose', 'jose@gmail.com', '11223344', 'Quilmes', 'calle falsa 123');


--SECCIÓN BILLETERAS
insert into CUSTOMER_WALLET values (1, 100.0);
insert into PROVIDER_WALLET values (1, 10.0);


--SECCIÓN TIPOS DE USUARIOS
insert into Customer values (1, 'TOKENCust', 2, 2, 1, 1);
insert into Provider values (1, 'TOKENProv', 2, 1, 2, 1);


--SECCIÓN HISTORIAL DE PEDIDOS
insert into ORDER_HISTORY values (1, 2, 1, 1, null);

