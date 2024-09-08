program ej4p5;
const
	dimF = 5;
type
	reclamo = record
		codigo: integer;
		dni: integer;
		anio: integer;
		tipoReclamo: string;
	end;
	
	reclamito = record
		codigo: integer;
		anio: integer;
		tipoReclamo: string;
	end;
	
	lista = ^nodo;
	nodo = record
		ele: reclamito;
		sig: lista;
	end;
	
	arbolito = record
		dni: integer;
		cantidad: integer;
		reclamos: lista;
	end;
	
	arbol = ^nodoArbol;
	nodoArbol = record
		dato: arbolito;
		hi: arbol;
		hd: arbol;
	end;
	
	listaReclamos = ^nodoR;
	nodoR = record
		ele: integer;
		sig: listaReclamos;
	end;
	
	vectorReclamos = array [1..dimF] of string;
	
	
procedure generarInformacion (var r: reclamo);
var
	vr: array [1..dimF] of string = ('Mala atencion','Operacion mal efectuada','Cobros indebidos','Fallos en el servicio','Producto daniado');
begin
	r.dni:= random(10);
	if(r.dni <> 0) then begin
		r.codigo:=random(100)*100;
		r.anio:=random(2024-2000+1)+2000;
		r.tipoReclamo:= vr [random (dimF) + 1];
	end;
end;

procedure agregarAdelante (var l: lista; ri: reclamito);
var
	nuevo: lista;
begin
	new (nuevo);
	nuevo^.ele:= ri;
	nuevo^.sig:= nil;
	if (l = nil) then
		l:= nuevo
	else begin
		nuevo^.sig:= l;
		l:= nuevo;
	end;
end;

procedure cargarArbol (var a: arbol; r: reclamo);
var
	ri: reclamito;
begin
	if (a = nil) then begin
		new (a);
		a^.dato.dni:= r.dni;
		a^.dato.reclamos:= nil;
		a^.dato.cantidad:= 1;
		ri.codigo:= r.codigo;
		ri.anio:= r.anio;
		ri.tipoReclamo:= r.tipoReclamo;
		agregarAdelante (a^.dato.reclamos, ri);
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else begin
		if (r.dni = a^.dato.dni) then begin
			a^.dato.cantidad:= a^.dato.cantidad + 1;
			agregarAdelante (a^.dato.reclamos, ri);
		end
		else begin
			if (r.dni < a^.dato.dni) then
				cargarArbol (a^.hi, r)
			else
				cargarArbol (a^.hd, r);
		end;
	end;
end;

procedure cargarInformacion (var a: arbol);
var
	r: reclamo;
begin
	generarInformacion (r);
	while (r.codigo <> 0) do begin
		cargarArbol (a, r);
		generarInformacion (r);
	end;
end;

procedure imprimirListaReclamos (l: lista);
begin
	if (l <> nil) then begin
		writeln;
		write ('| CODIGO: ', l^.ele.codigo, '|');
		writeln;
		write ('| ANIO: ', l^.ele.anio, '|');
		writeln;
		write ('| TIPO DE RECLAMO: ', l^.ele.tipoReclamo, '|');
		writeln;
		imprimirListaReclamos (l^.sig);
	end;
end;

procedure imprimir (a: arbol);
begin
	if (a <> nil) then begin
		imprimir (a^.hi);
		writeln;
		write ('| DNI: ', a^.dato.dni, '|');
		writeln;
		write ('| CANTIDAD DE RECLAMOS: ', a^.dato.cantidad, '|');
		writeln;
		imprimirListaReclamos (a^.dato.reclamos);
		writeln;
		imprimir (a^.hd);
	end;
end;

function cantidadDeReclamos (a: arbol; dni: integer): integer;
begin
	if (a <> nil) then begin
		if (dni = a^.dato.dni) then
			cantidadDeReclamos:= a^.dato.cantidad
		else begin
			if (dni < a^.dato.dni) then
				cantidadDeReclamos:= cantidadDeReclamos (a^.hi,dni)
			else
				cantidadDeReclamos:= cantidadDeReclamos (a^.hd,dni);
		end;
	end
	else
		cantidadDeReclamos:= 0;
end;

function cantidadDeReclamosEntre (a: arbol; dniIni, dniFin: integer): integer;
begin
	if (a <> nil) then begin
		if (a^.dato.dni > dniIni) then
			if (a^.dato.dni < dniFin) then
				cantidadDeReclamosEntre:= a^.dato.cantidad + cantidadDeReclamosEntre (a^.hi, dniIni, dniFin) + cantidadDeReclamosEntre (a^.hd, dniIni, dniFin)
			else 
				cantidadDeReclamosEntre:= cantidadDeReclamosEntre (a^.hi, dniIni, dniFin)
		else
			cantidadDeReclamosEntre:= cantidadDeReclamosEntre (a^.hd, dniIni, dniFin);
	end
	else
		cantidadDeReclamosEntre:= 0;
end;

procedure agregarAdelante (codigoo: integer; var lr: listaReclamos);
var
	nuevo: listaReclamos;
begin
	new (nuevo);
	nuevo^.ele:= codigoo;
	nuevo^.sig:= nil;
	if (lr = nil) then 
		lr:= nuevo
	else begin
		nuevo^.sig:= lr;
		lr:= nuevo;
	end;
end;

procedure recorroLista (l: lista; anio: integer; var lr: listaReclamos);
begin
	while (l <> nil) do begin
		if (anio = l^.ele.anio) then 
			agregarAdelante (l^.ele.codigo, lr);
		l:= l^.sig;
	end;
end;

procedure codigosEnEseAnio (a: arbol; anio: integer; var lr: listaReclamos);
begin
	if (a <> nil) then begin	
		codigosEnEseAnio (a^.hi, anio, lr);
		recorroLista (a^.dato.reclamos,anio, lr);
		codigosEnEseAnio (a^.hd, anio, lr);
	end;
end;

procedure informar (c,dni: integer; c1: integer; dniIni,dniFin: integer; anio: integer; lr: listaReclamos);
begin
	writeln;
	write ('La cantidad de reclamos efectuados por el dni ' ,dni, ' es: ' ,c);
	writeln;
	write ('La cantidad de reclamos efectuados entre el dni ',dniIni , ' y el dni ' , dniFin, ' es de: ', c1);
	writeln;
	write ('La lista de codigos de los reclamos realizados en el anio ' ,anio ,' quedo de la siguiente manera: ' );
	
	while (lr <> nil) do begin
		writeln;
		write ('| CODIGO : ' ,lr^.ele , '|');
		lr:= lr^.sig;
	end;
end;

var
	a: arbol;
	c,c1, dni, dniIni, dniFin, anio: integer;
	lr: listaReclamos;
begin
	Randomize;
	a:= nil;
	c:= 0;
	c1:= 0;
	cargarInformacion (a);
	imprimir (a); //extra
	write ('Ingrese un dni: ');
	readln (dni);
	c:= cantidadDeReclamos (a,dni);
	writeln;
	write ('Ingrese un dni inicial: ');
	readln (dniIni);
	writeln;
	write ('Ingrese un dni final: ');
	readln (dniFin);
	writeln;
	c1:= cantidadDeReclamosEntre (a,dniIni,dniFin);
	writeln;
	write ('Ingrese un anio: ');
	readln (anio);
	writeln;
	codigosEnEseAnio (a, anio, lr);
	informar (c,dni,c1,dniIni,dniFin, anio, lr);
end.
