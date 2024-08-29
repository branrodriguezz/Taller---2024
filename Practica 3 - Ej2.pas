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
c. Implemente un módulo que reciba el árbol generado en ii. y retorne el código de producto
con mayor cantidad total de unidades vendidas.
c. Implemente un módulo que reciba el árbol generado en iii. y retorne el código de producto con mayor cantidad de ventas.}

program ej1p3;
Type
	venta = record
		cod: integer;
		fecha: integer;
		cant: integer;
	end;
	
	arbol1 = ^nodo;
	nodo = record
		dato: venta;
		hi: arbol1;
		hd: arbol1;
	end;
	
	producto = record
		cod: integer;
		total: integer;
	end;
	
	arbol2 = ^nodo2;
	nodo2 = record
		dato2: producto;
		hi2: arbol2;
		hd2: arbol2;
	end;
	
	lista = ^nodolista;
	nodolista = record
		ele: venta;
		sig: lista;
	end;
	
	arbol3 = ^nodo3;
	nodo3 = record
		dato3: lista; //en la lista ya esta el codigo de producto
		hi3: arbol3;
		hd3: arbol3;
	end;

procedure generarInformacion (var v: venta);
begin
	v.cod:= random (100); //un producto puede estar en mas de una venta
	v.fecha:= random (31) + 1;
	v.cant:= random (100);
end;

procedure agregar (var a1: arbol1; v: venta);
begin
	if (a1 = nil) then begin
		new (a1);
		a1^.dato:= v;
		a1^.hi:= nil; 
		a1^.hd:= nil;
	end
	else begin
		if (v.cod < a1^.dato.cod) then 
			agregar (a1^.hi, v) 
		else 
			agregar (a1^.hd, v);
	end;
end;

procedure cargarArbol1 (var a1: arbol1);
var
	v: venta;
begin
	generarInformacion (v);
	if (v.cod <> 0) then begin
		agregar (a1, v);
		cargarArbol1 (a1);
	end;
end;

procedure agregar (var a2: arbol2; p: producto);
begin
	if (a2 = nil) then begin
		new (a2);
		a2^.dato2:= p;
		a2^.hi2:= nil; 
		a2^.hd2:= nil;
	end
	else begin
		if (p.cod <= a2^.dato2.cod) then 
			agregar (a2^.hi2, p)
		else 
			agregar (a2^.hd2, p);
	end;
end;

procedure cargarArbol2 (a1: arbol1; var a2: arbol2);
var
	act: integer;
	p: producto;
	cantv: integer;
begin
	if (a1 <> nil) then begin
		cantv:= 0; //dudoso
		act:= a1^.dato.cod;
		if (act = a1^.dato.cod) then begin //aplico corte de control
			cantv:= cantv + 1; 
			cargarArbol2 (a1^.hi,a2);
			cargarArbol2 (a1^.hd,a2);
		end;
		p.cod:= act; p.total:= cantv;
		agregar (a2,p);
		cargarArbol2 (a1, a2);
	end;
end;

procedure cargarArbol3 (var a3: arbol3);
var 
begin
end;

procedure generarArboles (var a1: arbol1; var a2: arbol2; var a3: arbol3);
begin
	cargarArbol1 (a1);
	cargarArbol2 (a1,a2); 
	cargarArbol3 (a3);
end;

var
	a1: arbol1;
	a2: arbol2;
begin
	a1:= nil;
	a2:= nil;
	Randomize;
	generarArboles (a1,a2); //inciso A
end.
