{Una agencia dedicada a la venta de autos ha organizado su stock y, tiene la información de los autos en venta. Implementar un programa que:
a) Genere la información de los autos (patente, año de fabricación (2010..2018), marca y modelo, finalizando con marca ‘MMM’) 
y los almacene en dos estructuras de datos:
i. Una estructura eficiente para la búsqueda por patente.
ii. Una estructura eficiente para la búsqueda por marca. Para cada marca se deben
almacenar todos juntos los autos pertenecientes a ella.
b) Invoque a un módulo que reciba la estructura generado en a) i y una marca y retorne la
cantidad de autos de dicha marca que posee la agencia.
c) Invoque a un módulo que reciba la estructura generado en a) ii y una marca y retorne
la cantidad de autos de dicha marca que posee la agencia.
d) Invoque a un módulo que reciba el árbol generado en a) i y retorne una estructura con
la información de los autos agrupados por año de fabricación.
e) Invoque a un módulo que reciba el árbol generado en a) i y una patente y devuelva el
modelo del auto con dicha patente.
f) Invoque a un módulo que reciba el árbol generado en a) ii y una patente y devuelva el
modelo del auto con dicha patente.}

program ej2p5;
const
	dimF = 5;
type
	rangoAnio = 2010..2018;
	vectorPatente = array [1..dimF] of string;
	vectorMarca = array [1..dimF] of string;
	vectorModelo = array [2010..2018] of string;
	auto = record
		patente: string;
		anioFab: rangoAnio;
		marca: string;
		modelo: string;
	end;
	
	arbol = ^nodo;
	nodo = record
		dato: auto;
		hi: arbol;
		hd: arbol;
	end;
	
	lista = ^nodoLista;
	nodoLista = record
		ele: auto;
		sig: lista;
	end;
	
	vectorAnioFab = array [rangoAnio] of lista;
	
	arbol2 = ^nodoArbol;
	nodoArbol = record
		dato2: lista;
		hi2: arbol2;
		hd2: arbol2;
	end;

procedure generarInformacion (var a: auto);
var
	vp: array [1..dimF] of string = ('ABC123','DEF456','GHI789','JKL012','MNO345');
	vm: array [1..9] of string = ('FORD','PEUGEOT','NISSAN','HYUNDAI','MMM', 'JJJ', 'LLL', 'NNN', 'OOP');
	vmo: array [1..dimF] of string = ('FERRARI','COROLLA','KA','FIESTA','208');
begin
	a.patente:= vp[random (dimF) + 1];
	a.anioFab:= random (9) + 2010;
	a.marca:= vm[random (9) + 1];
	a.modelo:= vmo[random (dimF) + 1];
end;

procedure cargarArbol1 (var a1: arbol; a: auto);
begin
	if (a1 = nil) then begin
		new (a1);
		a1^.dato:= a;
		a1^.hi:= nil;
		a1^.hd:= nil;
	end
	else begin
		if (a.patente < a1^.dato.patente) then
			cargarArbol1 (a1^.hi, a)
		else 
			cargarArbol1 (a1^.hd, a);
	end;
end;

procedure agregarAdelante (var l: lista; a: auto);
var 
	nuevo: lista;
begin
	new (nuevo);
	nuevo^.ele:= a;
	nuevo^.sig:= nil;
	if (l = nil) then
		l:= nuevo
	else begin
		nuevo^.sig:= l;
		l:= nuevo;
	end;
end;

procedure cargarArbol2 (var a2: arbol2; a: auto);
begin
	if (a2 = nil) then begin
		new (a2);
		a2^.dato2:= nil;
		agregarAdelante (a2^.dato2, a);
		a2^.hi2:= nil;
		a2^.hd2:= nil;
	end
	else begin
		if (a.marca = a2^.dato2^.ele.marca) then 
			agregarAdelante (a2^.dato2, a)
		else begin
			if (a.marca < a2^.dato2^.ele.marca) then
				cargarArbol2 (a2^.hi2, a)
			else
				cargarArbol2 (a2^.hd2, a);
		end;
	end;
end;

procedure cargarArboles (var a1: arbol; var a2: arbol2);
var
	a: auto;
begin
	generarInformacion (a);
	while (a.marca <> 'MMM') do begin
		cargarArbol1 (a1,a);
		cargarArbol2 (a2,a); 
		generarInformacion (a);
	end;
end;

procedure imprimirArbol1 (a1: arbol);
begin
	if (a1 <> nil) then begin
		imprimirArbol1 (a1^.hi);
		writeln;
		writeln;
		write ('| Patente: ', a1^.dato.patente, '|');
		writeln;
		write ('| Anio: ', a1^.dato.anioFab, '|');
		writeln;
		write ('| Marca: ', a1^.dato.marca, '|');
		writeln;
		write ('| Modelo: ', a1^.dato.modelo, '|');
		writeln;
		writeln;
		imprimirArbol1 (a1^.hd);
	end;
end;

procedure imprimirLista (l: lista);
begin
	if (l <> nil) then begin
		writeln;
		write ('| Patente: ', l^.ele.patente, '|');
		writeln;
		write ('| Anio: ', l^.ele.anioFab, '|');
		writeln;
		write ('| Modelo: ', l^.ele.modelo, '|');
		writeln;
		writeln;
		imprimirLista (l^.sig);
	end;
	
end;

procedure imprimirArbol2 (a2: arbol2);
begin
	if (a2 <> nil) then begin
		imprimirArbol2 (a2^.hi2);
		writeln;
		write ('| Lista de autos de la marca: ', a2^.dato2^.ele.marca, '|');
		writeln;
		imprimirLista (a2^.dato2);
		imprimirArbol2 (a2^.hd2);
	end;
	
end;

procedure imprimirArboles (a1: arbol; a2: arbol2);
begin
	writeln;
	write ('El arbol 1 quedo de la siguiente manera: ');
	imprimirArbol1 (a1);
	writeln;
	write ('El arbol 2 quedo de la siguiente manera: ');
	writeln;
	imprimirArbol2 (a2);
end;

function dichaMarca (a1: arbol; marca: string): integer;
begin
	if (a1 <> nil) then begin
		if (a1^.dato.marca = marca) then
			dichaMarca:= 1 + dichaMarca (a1^.hi, marca) + dichaMarca (a1^.hd, marca)
		else
			dichaMarca:= dichaMarca(a1^.hi,marca) + dichaMarca(a1^.hd,marca);
	end
	else
		dichaMarca:= 0;
end;

function listaa (l: lista): integer;
begin
	if (l <> nil) then
		listaa:= 1 + listaa (l^.sig)
	else
		listaa:= 0;
end;

function dichaMarcaa (a2: arbol2; marca2: string): integer;
begin
	if (a2 <> nil) then begin
		if (a2^.dato2^.ele.marca = marca2) then
			dichaMarcaa:=  listaa(a2^.dato2) {+ dichaMarcaa (a2^.hi2, marca2) + dichaMarcaa (a2^.hd2, marca2)} //NO ES NECESARIO BUSCAR EN OTROS NODOS SI YA ENCONTRE LA MARCA
		else begin
			if (marca2 < a2^.dato2^.ele.marca) then
				dichaMarcaa:= dichaMarcaa (a2^.hi2, marca2)
			else
				dichaMarcaa:= dichaMarcaa (a2^.hd2, marca2);
		end;
	end
	else
		dichaMarcaa:= 0;
end;

procedure inicializarVectorAnioFab (var va: vectorAnioFab);
var
	i: integer;
begin	
	for i:= 2010 to 2018 do 
		va[i]:= nil;
end;

procedure agregarAdelantex (var ln: lista; a: auto);
var
	nuevo: lista;
begin
	new (nuevo);
	nuevo^.ele:= a;
	if (ln = nil) then
		ln:= nuevo
	else begin
		nuevo^.sig:= ln;
		ln:= nuevo;
	end;
end;

procedure generarNuevaEstructura1 (a1: arbol; var va: vectorAnioFab);
begin
	if (a1 <> nil) then begin
		generarNuevaEstructura1 (a1^.hi, va);
		agregarAdelantex (va[a1^.dato.anioFab], a1^.dato);
		generarNuevaEstructura1 (a1^.hd, va);
	end;
end;

procedure imprimirListaAutitos (ln: lista);
begin
	if (ln <> nil) then begin
		writeln;
		writeln;
		write ('| Patente: ', ln^.ele.patente, '|');
		writeln;
		write ('| Marca: ', ln^.ele.marca, '|');
		writeln;
		write ('| Modelo: ', ln^.ele.modelo, '|');
		writeln;
		writeln;
		imprimirListaAutitos (ln^.sig);
	end;
end;

procedure imprimirNuevaEstructura1 (va: vectorAnioFab);
var
	i: integer;
begin
	for i:= 2010 to 2018 do begin
		writeln;
		if (va [i] <> nil) then begin
			write ('La lista de autos del anio  ', i , ' es: ' );
			imprimirListaAutitos (va[i]);
		end;
	end;
end;

procedure devolverModelo (a1: arbol; patent: string; var modelo: string);
begin
	if (a1 <> nil) then begin
		if (patent = a1^.dato.patente) then
			modelo:= a1^.dato.modelo
		else begin
			if (patent < a1^.dato.patente) then
				devolverModelo (a1^.hi, patent, modelo)
			else
				devolverModelo (a1^.hd, patent,modelo);
		end;
	end;
end;

procedure devolverModelo2 (a2: arbol2; patent2: string; var modelo2: string);
begin
	if (a2 <> nil) then begin
		devolverModelo2 (a2^.hi2, patent2, modelo2);
		if (patent2 = a2^.dato2^.ele.patente) then
			modelo2:= a2^.dato2^.ele.modelo;
		devolverModelo2 (a2^.hd2, patent2, modelo2);
	end;
end;

var
	a1: arbol;
	a2: arbol2;
	marca, marca2: string;
	m, m2: integer;
	va: vectorAnioFab;
	patent, patent2, modelo, modelo2: string;
begin
	Randomize;
	a1:= nil;
	a2:= nil;
	modelo:= '';
	cargarArboles (a1,a2);
	imprimirArboles (a1,a2); //extra
	writeln;
	writeln;
	write ('Ingrese una marca: ');
	readln (marca);
	writeln;
	m:= dichaMarca (a1,marca); //inciso b
	writeln;
	writeln;
	write ('La cantidad de autos de la marca: ' , marca , ' es: ' ,m);
	writeln;
	writeln;
	write ('Ingrese una marca: ');
	readln (marca2);
	writeln;
	writeln;
	m2:= dichaMarcaa (a2, marca2); //inciso c
	writeln;
	writeln;
	write ('La cantidad de autos de la marca 2: ', marca2 , ' es: ' , m2);
	writeln;
	inicializarVectorAnioFab (va);
	generarNuevaEstructura1 (a1, va); //inciso d
	writeln;
	writeln;
	write ('La nueva estructura generada  con la información de los autos agrupados por año de fabricación: ');
	writeln;
	imprimirNuevaEstructura1 (va); //extra
	writeln;
	writeln;
	write ('Ingrese una patente: ');
	readln (patent);
	devolverModelo (a1, patent, modelo); //inciso e
	writeln;
	writeln;
	write ('El modelo de auto con la patente ingresada previamente es: ', modelo);
	writeln;
	writeln;
	write ('Ingrese una patente: ');
	readln (patent2);
	devolverModelo2 (a2, patent2, modelo2); //inciciso f
	writeln;
	writeln;
	write ('El modelo de auto con la patente ingresada previamente es: ', modelo2);
end.
