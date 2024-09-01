{2. Escribir un programa que:
a. Implemente un módulo que genere aleatoriamente información de ventas de un comercio. 
Para cada venta generar código de producto, fecha y cantidad de unidades vendidas. Finalizar con el código de producto 0. Un producto puede estar en más de una venta. 
Se pide:
i. Generar y retornar un árbol binario de búsqueda de ventas ordenado por código de producto. Los códigos repetidos van a la derecha.
ii. Generar y retornar otro árbol binario de búsqueda de productos vendidos ordenado por código de producto. Cada nodo del árbol debe contener el código de producto y 
la cantidad total de unidades vendidas.
iii. Generar y retornar otro árbol binario de búsqueda de productos vendidos ordenado por código de producto. Cada nodo del árbol debe contener el código de producto y
 la lista de las ventas realizadas del producto.
Nota: El módulo debe retornar TRES árboles.
b. Implemente un módulo que reciba el árbol generado en i. y una fecha y retorne la cantidad total de productos vendidos en la fecha recibida.
c. Implemente un módulo que reciba el árbol generado en ii. y retorne el código de producto con mayor cantidad total de unidades vendidas.
d. Implemente un módulo que reciba el árbol generado en iii. y retorne el código de producto con mayor cantidad de ventas.}

program prueba;
const
	max = 5;
type

	// -------------------- arbol1 ---------------
	fecha = record
		dia: integer;
		mes: integer;
		anio: integer;
	end;
	
	venta = record
		codigo: integer;
		fecha: fecha;
		cantidad: integer;
	end;
	
	arbol1 = ^nodo;
	nodo = record
		dato: venta;
		hi: arbol1;
		hd: arbol1;
	end;
	// -------------------- arbol1 ---------------
	
	// -------------------- arbol 2 ---------------
	producto = record
		codigo: integer;
		total: integer;
	end;
	
	arbol2 = ^nodo2;
	nodo2 = record
		dato2: producto;
		hi2: arbol2;
		hd2: arbol2;
	end;
	//------------------- arbol2 ----------------
	
	// ------------------ arbol 3 ---------------
	
	lista = ^nodolista;
	nodolista = record
		ele: venta;
		sig: lista;
	end;
	
	produylista = record
		codigo: integer;
		listaa: lista;
	end;
	
	arbol3 = ^nodo3;
	nodo3 = record
		dato3: produylista;
		hi3: arbol3;
		hd3: arbol3;
	end;
		
	// ------------------ arbol 3 ---------------
	
//-----------------------genera Informacion random para cargar en los arboles ------------
procedure generarInformacion (var v: venta);
begin
	v.codigo:= random (100);
	v.fecha.dia:= random (31) + 1;
	v.fecha.mes:= random (12) + 1;
	v.fecha.anio:= random (25) + 2000;
	v.cantidad:= random (max);
end;
//-----------------------genera Informacion random para cargar en los arboles ------------

//-----------------------cargar arbol 1 ------------------------
procedure cargarArbol1 (var a1: arbol1; v: venta);
begin
	if (a1 = nil) then begin
		new (a1);
		a1^.dato:= v;
		a1^.hi:= nil;
		a1^.hd:= nil
	end
	else begin
		if (v.codigo < a1^.dato.codigo) then
			cargarArbol1 (a1^.hi, v)
		else
			cargarArbol1 (a1^.hd, v);
	end;
end;
//-----------------------cargar arbol 1 ------------------------

//-----------------------cargar arbol 2 ------------------------
procedure cargarArbol2 (var a2: arbol2; v: venta);
begin
	if (a2 = nil) then begin
		new (a2);
		a2^.dato2.codigo:= v.codigo;
		a2^.dato2.total:= v.cantidad;
		a2^.hi2:= nil;
		a2^.hd2:= nil;
	end
	else begin
		if (v.codigo = a2^.dato2.codigo) then 
			a2^.dato2.total:= a2^.dato2.total + v.cantidad
		else begin
			if (v.codigo < a2^.dato2.codigo) then
				cargarArbol2 (a2^.hi2, v)
			else
				cargarArbol2 (a2^.hd2, v);
		end;
	end;
end;
//-----------------------cargar arbol 2 ------------------------

//-----------------------cargar arbol 3 ------------------------

//----------------------- agrega adelante en la lista de ventas ------------------------

procedure agregarAdelante (var l: lista; v: venta);
var
	nuevo: lista;
begin
	new (nuevo);
	nuevo^.ele:= v;
	nuevo^.sig:= nil;
	if (l = nil) then
		l:= nuevo
	else begin
		nuevo^.sig:= l;
		l:= nuevo;
	end;	
end;
//----------------------- agrega adelante en la lista de ventas ------------------------

//-----------------------cargar arbol 3 ------------------------
procedure cargarArbol3 (var a3: arbol3; v: venta);
begin
	if (a3 = nil) then begin
		new (a3);
		a3^.dato3.codigo:= v.codigo;
		a3^.dato3.listaa:= nil;
		agregarAdelante (a3^.dato3.listaa, v);
		a3^.hi3:= nil;
		a3^.hd3:= nil;
	end
	else begin
		if (v.codigo = a3^.dato3.codigo) then begin
			agregarAdelante (a3^.dato3.listaa, v);
		end
		else begin
			if (v.codigo < a3^.dato3.codigo) then
				cargarArbol3 (a3^.hi3, v)
			else
				cargarArbol3 (a3^.hd3, v);
		end;
	end;
end;
//-----------------------cargar arbol 3 ------------------------

//--------------generar arboles ------------
procedure generarArboles (var a1: arbol1; var a2: arbol2; var a3: arbol3); //tiene que ser recursivo?
var
	v: venta;
begin
	generarInformacion (v);
	while (v. codigo <> 0) do begin
		cargarArbol1 (a1, v);
		cargarArbol2 (a2, v);
		cargarArbol3 (a3, v);
		generarInformacion (v);
	end;
end;
//---------------generar arboles ------------

//------------imprime lista del arbol 3 ----------

procedure imprimirLista (l: lista);
begin
	while (l <> nil) do begin
		write ('Venta de la fecha:');
		write (' | ' ,l^.ele.fecha.dia,'/' ,l^.ele.fecha.mes, '/' ,l^.ele.fecha.anio, ' | ');
		write ('| Cantidad vendida: ' , l^.ele.cantidad , ' | ');
		l:= l^.sig;
	end;
	writeln;
end;

//------------imprime lista del arbol 3 ----------

//------------imprime arbol 3 ----------

procedure impresion3 (pl: produylista);
begin
	writeln;
	write ('Producto con codigo: ' ,pl.codigo, '   ');
	imprimirLista (pl.listaa);
end;

//------------imprime arbol 3 ----------

//------------imprime arbol 3 ----------
procedure imprimirArbol3 (a3: arbol3);
begin
	if (a3 <> nil) then begin
		imprimirArbol3 (a3^.hi3);
		impresion3 (a3^.dato3);
		imprimirArbol3 (a3^.hd3);
	end;
end;
//------------imprime arbol 3 ----------

//------------imprime arbol 2 ----------
procedure impresion2 (p: producto);
begin
	writeln;
	write ('El codigo de producto : ' , p.codigo);
	writeln;
	writeln ('Tiene un total de productos vendidos: ' , p.total);
	writeln;
end;

procedure imprimirArbol2 (a2: arbol2);
begin
	if (a2 <> nil) then begin
		imprimirArbol2 (a2^.hi2);
		impresion2 (a2^.dato2);
		imprimirArbol2 (a2^.hd2);
	end;
end;
//-----------imprime arbol 2 --------------

//-----------imprime arbol1 --------------
procedure impresion (v: venta);
begin
	write ('El codigo : ' , v.codigo);
	writeln;
	write ('La fecha es: ' );
	writeln (v.fecha.dia, ' | ', v.fecha.mes, ' | ' , v.fecha.anio);
	writeln ('La cantidad de productos vendidos es: ', v.cantidad);
	writeln;
end;

procedure imprimirArbol1 (a1: arbol1);
begin
	if (a1 <> nil) then begin
		imprimirArbol1 (a1^.hi);
		impresion (a1^.dato);
		imprimirArbol1 (a1^.hd);
	end;
end;
//-----------imprime arbol1 --------------

//------------impresion de arboles ----------
procedure imprimirArboles (a1: arbol1; a2: arbol2; a3: arbol3);
begin
	writeln;
	write ('El arbol 1 es: (en orden) ');
	writeln;
	imprimirArbol1 (a1);
	writeln;
	write ('El arbol 2 es: (en orden) ');
	writeln; 
	imprimirArbol2 (a2);
	writeln;
	write ('El arbol 3 es: (en orden) ');
	imprimirArbol3 (a3);
	writeln;
end;
//------------impresion de arboles ----------

//------------- busca la fecha y suma la cant de productos -------------

procedure buscardeEsaFecha (a1: arbol1; fechaa: fecha; var cantProductos: integer);
begin
	if (a1 <> nil) then begin
		buscardeEsaFecha (a1^.hi, fechaa, cantProductos);
		if (a1^.dato.fecha.dia = fechaa.dia) and (a1^.dato.fecha.mes = fechaa.mes) and (a1^.dato.fecha.anio = fechaa.anio) then
			cantProductos:= cantProductos + a1^.dato.cantidad;
		buscardeEsaFecha (a1^.hd, fechaa, cantProductos);
	end;
end;
//------------- busca la fecha y suma la cant de productos -------------

//------------- buscar cod max (sin terminar) ---------------------------
{function buscarcodMax (a2: arbol2; maxi: integer): integer;
begin
	if (a2 <> nil) then begin
		if (a2^.hd2 = nil) then begin
			buscarcodMax:= a2^.dato2.codigo;
		end
		else begin
			buscarcodMax:= buscarcodMax (a2^.hd2,maxi);
		end;
	end;
end;}
//------------- buscar cod max (sin terminar) ---------------------------

//------------- buscar cod max con un proceso dentro de la funcionn ---------------------------

procedure buscarlo (a2: arbol2; var max: integer; var maxCodigo: integer);
begin
	if (a2 <> nil) then begin
		if (a2^.dato2.total > max) then begin
			max:= a2^.dato2.total;
			maxCodigo:= a2^.dato2.codigo;
		end;
		buscarlo (a2^.hi2, max, maxCodigo);
		buscarlo (a2^.hd2, max, maxCodigo);
	end;
end;

function buscarcodMax (a2: arbol2): integer;
var
	max, maxCodigo: integer;
begin
	max:= -1;
	maxCodigo:= -1;
	buscarlo (a2, max, maxCodigo);
	buscarcodMax:= maxCodigo;
end;

//------------- buscar cod max con un proceso dentro de la function  ---------------------------


//------------------ busca codigo maximo del que tiene mayor cantidad de ventas del arbol 3 ---------------------
procedure cuentoVentas (l: lista; var vent: integer);
begin
	if (l <> nil) then begin
		vent:= vent + 1;
		cuentoVentas (l^.sig, vent);
	end;
end;

procedure calculoMax (vent: integer; cod: integer; var codMax: integer; var maxVentas: integer);
begin
	if (vent > maxVentas) then begin
		maxVentas:= vent;
		codMax:= cod;
	end;
end;

procedure mayorCantidadVentas (a3: arbol3; var maxCod: integer; var maxVentas: integer); //que pasa aca si dos codigos de venta tiene la misma cantidad de ventas?
var
	vent: integer;
begin
	if (a3 <> nil) then begin
		mayorCantidadVentas (a3^.hi3, maxCod, maxVentas);
		vent:= 0;
		cuentoVentas (a3^.dato3.listaa, vent);
		calculoMax (vent, a3^.dato3.codigo, maxCod, maxVentas);
		mayorCantidadVentas (a3^.hd3, maxCod, maxVentas);
	end;
end;
//------------------ busca codigo maximo del que tiene mayor cantidad de ventas del arbol 3 ---------------------

// programa principal
var
	a1: arbol1;
	a2: arbol2;
	a3: arbol3;
	fechaa: fecha;
	cantProductos: integer;
	codMax, maxVentas: integer;
begin
	a1:= nil;
	a2:= nil;
	a3:= nil;
	cantProductos:= 0;
	maxVentas:= -1;
	codMax:= -1;
	Randomize;
	generarArboles (a1,a2,a3);
	imprimirArboles(a1,a2,a3);
	write ('Ingrese una dia: ');
	read (fechaa.dia);
	write ('Ingrese un mes: ');
	read (fechaa.mes);
	write ('Ingrese una anio: ');
	read (fechaa.anio);
	buscardeEsaFecha (a1, fechaa, cantProductos);
	writeln;
	write ('La cantidad total de productos vendidos en esa fecha es: ' , cantProductos);
	writeln;
	write ('El codigo de producto con mayor cantidad total de unidades vendidas es: ' , buscarcodMax (a2));
	mayorCantidadVentas (a3, codMax, maxVentas);
	writeln;
	write ('El codigo de producto con mayor cantidad de ventas es: ' , codMax);
end.
