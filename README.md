# Trabajo Práctico :: 2019s2

## ViendasYa

Se desea construir una aplicación similar a PedidosYa pero para viandas ejecutivas donde existan proveedores de servicios y clientes que abonen previamente un saldo en la plataforma. Los proveedores se comprometen a fijar un precio para un nro mínimo y mejorar el precio si aumenta la cantidad de pedidos.

Los proveedores podrán subir su negocio/servicio para que los clientes puedan comprarlo. Un servicio se carga con los siguientes datos:
Nombre [Obligatorio]
Logo [Obligatorio]
Localidad   [Obligatorio]
Dirección y Ubicación en un mapa (Google Maps preferentemente) [Obligatorio]
Descripción del tipo de servicio o productos que brinda [Obligatorio,30<=X<=200]]
Dirección de sitio web o dirección de facebook
Email [Obligatorio, Email valido]
Teléfono de contacto [Obligatorio, Teléfono válido, +Característica]
Horario y días de atención [Obligatorio]
Localidad de Entregas. En este caso contemplar al menos una distancia máxima.

Los proveedores podrán administrar el menú vigente (agregar/actualizar/borrar). Un menú contienen la siguiente información (Un proveedor puede tener como máximo 20 menú vigentes):
Nombre del menú  [Obligatorio,4<=X<=30]
Descripción  [Obligatorio,20<=X<=40]
Categoría [Pizza-Cerveza-Hamburguesa-Sushi-Empanadas-Green-Vegano, Mínimo una opción]
Valor Delivery [Opcional,$10<=X<=$40]
Fecha de Vigencia desde y hasta [Obligatorio]
Turnos/Horarios de entrega/Envio
Tiempo promedio de entrega [Obligatorio]
Precio 
Cantidad Mínima [Obligatorio, 10<=X<=70]
Precio Cantidad Minima  (*Min1) [Obligatorio,$0<=X<=$1000]
Cantidad Mínima 2 [Opcional, 40<=X<=150]
Precio Cantidad Minima 2(*Min2)  [Opcional,$0<=X<=$1000]
Cantidad  máxima de ventas por día [Obligatorio]

Las cantidades mínimas deberán ser  mutuamente excluyentes entre los 2 segmentos. El precio *Min2 debe ser menor que *Min1 y este debe ser menor a Precio. No se permiten mas ventas que la cantidad máxima.

Los clientes se deben registrar con su usuario de Google, Facebook o utilizando una cuenta propia. Los datos del registro son:
Nombre y Apellido  [Obligatorio]
Email [Obligatorio, Email valido]
Telefono [Obligatorio]
Localidad y Dirección  [Obligatorio]

Los clientes podrán cargar credito a sus cuentas. En el marco de este alcance solo se dispondrá una entrada de credito por sistema . El proveedor tendrá la misma funcionalidad para “retirar” dinero.

El cliente podrá buscar un menú por nombre del menú (%X%), por categoría o por localidad. Podrá ordenar los resultados por precio (min/max) y por puntuación (min/max). Se deberá proveer una vista en lista y otra ubicada en un mapa. La  lista deberá mostrar nombre de pedido, descripción,  cantidad mínima, precio, cantidad minima 2, precio 2, reputación del proveedor, dirección del lugar, nombre del proveedor, cantidad restando para llegar al mínimo de los próximos 10 días. Se deberá paginar cada 20 resultados.

Los compradores podrán comprar 1 menú (o más) del mismo servicio/negocio. Para hacer un pedido se deberá seleccionar Menú, Cantidad, TipoDeEntrega, FechaDeEntrega, HoraDeEntrega. Solo se podrán hacer pedidos hasta 48 horas antes de la fecha de la entrega, contemplando para el cálculo de los fechas, solo días hábiles (sugerencia: consumir servicio público para conocer feriados).

Se deberá informar el tiempo de entrega a domicilio (tiempo máximo de los menú seleccionados + tiempo estimado en llegar) o el tiempo para retirarlo (tiempo máximo de los menú seleccionados). Una vez efectuada la compra, se debe enviar un email al proveedor y otro al comprador y descontar los saldos correspondientes del proveedor y del cliente.

Todos los días a las 00hs, se confirmaran los pedidos y se enviarán los emails correspondientes confirmando los pedidos y los precios finales. Si un cliente abonó un valor y producto de que lo pidieron mas clientes el valor es menor, se debe actualizar el saldo en la cuenta del cliente y avisar al cliente.

Una vez efectuada la compra, el cliente deberá puntuar el servicio del 1 al 5 siendo 5 la mejor puntuación y 1 la menor. El usuario solo podrá comprar si no tiene puntuaciones pendientes. Si el menú acumula 20 puntuaciones y un promedio menor a 2, el menú se da de baja. Si el proveedor acumula 10 menúes dados de baja, el proveedor entonces será dado de baja también. Tanto ante la baja de un menú como de la del proveedor, debe enviarse un mail al proveedor notificando lo sucedido.

El proveedor dispondrá de una sección donde tenga su saldo a cobrar y se proveerá un listado con los pedidos históricos con información: FechaPedido, Estado, Puntuación, Menu, Valor FechaHora de Entrega, Delivery [SI/NO]

El cliente dispondrá de una sección donde tenga su saldo  y se proveerá un listado con los pedidos históricos con información: FechaPedido, Estado, Puntuación, Menu, Valor


La aplicación deberá ser completamente responsive ya que si bien ahora no vamos a contar con una aplicación mobile, será importante que pueda visualizarse correctamente en celulares y tablets. 

Es requisito indispensable proveer la capacidad de acceder a la aplicación utilizando una cuenta existente en alguna de las herramientas o redes sociales más utilizadas (gmail, facebook, twitter, etc). 
