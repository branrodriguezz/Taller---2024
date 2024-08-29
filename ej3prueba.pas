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

procedure cargarArbol1 (var a1: arbol1; v: venta);
begin
		agregar (a1, v);
		cargarArbol1 (a1, v);
end;

procedure cargarProducto (v: venta; var p: producto)
begin
	p.cod:= v.cod;
	p.total:= v.cant;
end; 

procedure cargarArbol2 (v: venta; var a2: arbol2
var
	p: producto;
begin
	if (a2 = nil) then begin
		new (a2);
		cargarProducto (v,p)
		a2^.dato2:= p;
		a2^.hi2:= nil; 
		a2^.hd2:= nil;
	end
	else begin
		if (p.cod < a2^.dato2.cod) then 
			cargarArbol2 (a2^.hi2);
		else 
			cargarArbol2 (a2^.hd2);
	end;
end;

procedure cargarArbol3 (var a3: arbol3);
var 
begin
end;

procedure generarArboles (var a1: arbol1; var a2: arbol2; var a3: arbol3);
var
	v: venta;
begin
	generarInformacion (v);
	if (v.cod <> 0) then begin)
		cargarArbol1 (a1);
		cargarArbol2 (v, a2); 
		cargarArbol3 (a3);
	end;
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
