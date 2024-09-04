{4. Una biblioteca nos ha encargado procesar la información de los préstamos realizados durante el año 2021. De cada préstamo se conoce el ISBN del libro, 
el número de socio, día y mes del préstamo y cantidad de días prestados. Implementar un programa con:
a. Un módulo que lea préstamos y retorne 2 estructuras de datos con la información de los préstamos. La lectura de los préstamos finaliza con ISBN 0. 
Las estructuras deben ser eficientes para buscar por ISBN.
i. En una estructura cada préstamo debe estar en un nodo. Los ISBN repetidos insertarlos a la derecha.
ii. En otra estructura, cada nodo debe contener todos los préstamos realizados al ISBN. (prestar atención sobre los datos que se almacenan).
b. Un módulo recursivo que reciba la estructura generada en i. y retorne el ISBN más grande.
c. Un módulo recursivo que reciba la estructura generada en ii. y retorne el ISBN más pequeño.
d. Un módulo recursivo que reciba la estructura generada en i. y un número de socio. El módulo debe retornar la cantidad de préstamos realizados a dicho socio.
e. Un módulo recursivo que reciba la estructura generada en ii. y un número de socio. El módulo debe retornar la cantidad de préstamos realizados a dicho socio.
f. Un módulo que reciba la estructura generada en i. y retorne una nueva estructura ordenada ISBN, donde cada ISBN aparezca una vez junto a la 
cantidad total de veces que se prestó.
g. Un módulo que reciba la estructura generada en ii. y retorne una nueva estructura ordenada ISBN, donde cada ISBN aparezca una vez junto a la 
cantidad total de veces que se prestó.
h. Un módulo recursivo que reciba la estructura generada en g. y muestre su contenido.
i. Un módulo recursivo que reciba la estructura generada en i. y dos valores de ISBN. El módulo debe retornar la cantidad total de préstamos realizados a los ISBN
comprendidos entre los dos valores recibidos (incluidos).
j. Un módulo recursivo que reciba la estructura generada en ii. y dos valores de ISBN. El
módulo debe retornar la cantidad total de préstamos realizados a los ISBN comprendidos entre los dos valores recibidos (incluidos).}

program ej4p4;
type
//------------------ el arbol 1 contiene un registro de prestamos -------------------------
	fecha = record
		dia: integer;
		mes: integer;
		anio: integer;
	end;
	
	prestamo = record
		isbn: integer;
		num: integer;
		fecha: fecha;
		cantPres: integer;
	end;
	
	arbol = ^nodoArbol;
	nodoArbol = record
		dato: prestamo;
		hi: arbol;
		hd: arbol;
	end;
//------------------ el arbol 1 contiene un registro de prestamos -------------------------

//------------------ el arbol 2 contiene una lista de prestamos -------------------------
	lista = ^nodolista;
	nodolista = record
		ele: prestamo;
		sig: lista;
	end;
	
	arbol2 = ^nodo2;
	nodo2 = record
		dato2: lista;
		hi2: arbol2;
		hd2: arbol2;
	end;
//------------------ el arbol 2 contiene una lista de prestamos -------------------------

//------------------ la lista contiene isbn y la cantidad de veces que se presto  -------------------------
	isbnpres = record
		isbn: integer;
		cantidad: integer;
	end;
	
	listaNueva = ^nodoNuevo;
	nodoNuevo = record
		ele: isbnpres;
		sig: listaNueva;
	end;
//------------------ la lista contiene isbn y la cantidad de veces que se presto -------------------------

//------------------ la lista g contiene isbn y la cantidad de veces que se presto -------------------------
	listag = ^nodog;
	nodog = record
		ele: isbnpres;
		sig: listag;
	end;
//------------------ la lista g contiene isbn y la cantidad de veces que se presto -------------------------

procedure leerInformacion (var p: prestamo);
begin
	writeln;
	write ('Ingrese un isbn: ');
	readln (p.isbn);
	if (p.isbn <> 0) then begin
		write ('Ingrese numero de socio: ');
		readln (p.num);
		write ('Ingrese un dia: ');
		readln (p.fecha.dia);
		write ('Ingrese un mes: ');
		readln (p.fecha.mes);
		p.fecha.anio:= 2021; //necesario???
		write ('Ingrese la cantidad de dias que se presto: ');
		readln (p.cantPres);
	end;
end;

procedure cargarArbol1 (var a1: arbol; p: prestamo);
begin
	if (a1 = nil) then begin
		new (a1);
		a1^.dato:= p;
		a1^.hi:= nil;
		a1^.hd:= nil;
	end
	else begin
		if (p.isbn < a1^.dato.isbn) then
			cargarArbol1 (a1^.hi, p)
		else
			cargarArbol1 (a1^.hd, p);
	end;
end;

procedure agregarAdelante (var l: lista; p: prestamo);
var
	nuevo: lista;
begin 
	new (nuevo);
	nuevo^.ele:= p;
	nuevo^.sig:= nil;
	if (l = nil) then 
		l:= nuevo
	else begin
		nuevo^.sig:= l;
		l:= nuevo;
	end;
end;

procedure cargarArbol2 (var a2: arbol2; p: prestamo);
begin
	if (a2 = nil) then begin
		new (a2);
		a2^.dato2:= nil;
		agregarAdelante (a2^.dato2, p);
		a2^.hi2:= nil;
		a2^.hd2:= nil;
	end
	else begin
		if (a2^.dato2^.ele.isbn = p.isbn) then
			agregarAdelante (a2^.dato2 , p)
		else begin
			if (p.isbn <= a2^.dato2^.ele.isbn) then
				cargarArbol2 (a2^.hi2, p)
			else
				cargarArbol2 (a2^.hd2, p);
		end;
	end;
end;


procedure generarArboles (var a1: arbol; var a2: arbol2);
var
	p: prestamo;
begin
	leerInformacion (p);
	while (p.isbn <> 0) do begin
		cargarArbol1 (a1,p);
		cargarArbol2 (a2,p);
		leerInformacion (p);
	end;
end;

procedure imprimirPrestamo (p: prestamo);
begin	
	writeln;
	write ('| ISBN ', p.isbn, '|');
	write ('| Numero de socio ' , p.num, '|');
	write ('| Fecha ' , p.fecha.dia , '/' , p.fecha.mes , '/' , p.fecha.anio, '|');
	write ('| Cantidad de dias prestado ' , p.cantPres, '|');
end;

procedure imprimirArbol1 (a1: arbol);
begin
	if (a1 <> nil) then begin
		imprimirArbol1 (a1^.hi);
		imprimirPrestamo (a1^.dato);
		imprimirArbol1 (a1^.hd);
	end;
end;

procedure imprimirRegistro (p: prestamo);
begin	
	write ('| N. Socio ',p.num, '|');
	write ('| Fecha ' , p.fecha.dia , '/' , p.fecha.mes , '/' , p.fecha.anio, '|');
	write ('| Cantidad de dias prestado ' , p.cantPres, '|');
end;

procedure imprimirLista (l: lista);
begin
	if (l <> nil) then begin
		writeln;
		imprimirRegistro (l^.ele);
		imprimirLista (l^.sig);
	end;
end;

procedure imprimirArbol2 (a2: arbol2);
begin
	if (a2 <> nil) then begin
		imprimirArbol2 (a2^.hi2);
		writeln;
		write ('| ISBN: ',a2^.dato2^.ele.isbn, '|');
		write ('| Lista: |');
		writeln;
		imprimirLista (a2^.dato2);
		writeln;
		imprimirArbol2 (a2^.hd2);
	end;
end;

procedure imprimirArboles (a1: arbol; a2: arbol2);
begin
	writeln;
	write ('El arbol de prestamos es el siguiente: ');
	imprimirArbol1 (a1);
	writeln;
	writeln;
	write ('El arbol de cada isbn con su lista de prestamos es: ');
	writeln;
	imprimirArbol2 (a2);
end;

function isbnMasGrande (a1: arbol): integer;
begin
	if (a1 <> nil) then begin
		if (a1^.hd <> nil) then
			isbnMasGrande:= isbnMasGrande (a1^.hd)
		else
			isbnMasGrande:= a1^.dato.isbn;
	end;
end;

function isbnMasPequenio (a2: arbol2): integer;
begin
	if (a2 <> nil) then begin
		if (a2^.hi2 <> nil) then
			isbnMasPequenio:= isbnMasPequenio (a2^.hi2)
		else
			isbnMasPequenio:= a2^.dato2^.ele.isbn;
	end;
end;

procedure prestamosAeseSocio (a1: arbol; nsocio: integer; var cant: integer);
begin	
	if (a1 <> nil) then begin
		prestamosAeseSocio (a1^.hi,nsocio,cant);
		if (a1^.dato.num = nsocio) then
			cant:= cant + 1;		
		prestamosAeseSocio (a1^.hd,nsocio,cant);
	end;
end;

procedure chequeoLista (l: lista; var cant2: integer; nsocio2: integer);
begin
	if (l <> nil) then begin
		if (l^.ele.num = nsocio2) then
			cant2:= cant2 + 1;
		chequeoLista (l^.sig, cant2, nsocio2);
	end;
end;

procedure prestamosAeseSocioVol2 (a2: arbol2; nsocio2: integer; var cant2: integer);
begin
	if (a2 <> nil) then begin
		prestamosAeseSocioVol2 (a2^.hi2, nsocio2, cant2);
		chequeoLista (a2^.dato2, cant2, nsocio2);
		prestamosAeseSocioVol2 (a2^.hd2, nsocio2, cant2);
	end;
end;

procedure agregarAtras (var ln: listanueva; i:isbnpres);
var
	nuevo: listanueva;
begin
	new (nuevo);
	nuevo^.ele:= i;
	nuevo^.sig:= nil;
	if (ln = nil) then
		ln:= nuevo
	else begin
		nuevo^.sig:= ln;
		ln:= nuevo;
	end
end;

procedure generarLista (var ln: listanueva; i: isbnpres); //revisar el jueves
begin
		if (ln <> nil) and (i.isbn = ln^.ele.isbn) then //si se ingresa un isbn igual al anterior, le sumo una cantidad prestada
			ln^.ele.cantidad:= ln^.ele.cantidad + 1
		else begin //si se ingresa un isbn nuevo a la lista a la cantidad la inicializo en 1
			i.cantidad:= 1;
			agregarAtras (ln,i);
		end;
end;


procedure incisoF (a1: arbol; var ln: listanueva);
var
	i: isbnpres;
begin
	if (a1 <> nil) then begin
		incisoF (a1^.hd, ln);
		i.isbn:= a1^.dato.isbn;
		generarLista (ln, i);
		incisoF (a1^.hi, ln);
	end;
end;

procedure imprimirListaNueva (ln: listanueva);
begin
	if (ln <> nil) then begin
		write ('| ISBN ',ln^.ele.isbn, '|');
		write ('| Cantidad de veces prestado: ',ln^.ele.cantidad, '|');
		writeln;
		imprimirListaNueva (ln^.sig);
	end;
end;


procedure agregoListaG (var lg: listag; i: isbnpres);
var
	nuevo: listag;
begin
	new (nuevo);
	nuevo^.ele:= i;
	nuevo^.sig:= nil;
	if (lg = nil) then
		lg:= nuevo
	else begin
		nuevo^.sig:= lg;
		lg:= nuevo;
	end;
end;

procedure generarListaG (var lg: listag; i: isbnpres);
begin
	if (lg <> nil) and (i.isbn = lg^.ele.isbn) then 
		lg^.ele.cantidad:= lg^.ele.cantidad + 1
	else begin
		i.cantidad:= 1;
		agregoListaG (lg, i);
	end;
end;

procedure chequeoLista (l: lista; i: isbnpres; var lg: listag);
begin
	if (l <> nil) then begin
		generarListaG (lg, i);
		chequeoLista (l^.sig, i, lg);
	end;
end;

procedure incisog (a2: arbol2; var lg: listag);
var
	i: isbnpres;
begin
	if (a2 <> nil) then begin
		incisog (a2^.hd2, lg);
		i.isbn:= a2^.dato2^.ele.isbn;
		chequeoLista (a2^.dato2, i, lg);
		incisog (a2^.hi2, lg);
	end;
end;

procedure imprimirListaG (lg: listag);
begin
	if (lg <> nil) then begin
		write ('| ISBN ',lg^.ele.isbn, '|');
		write ('| Cantidad de veces prestado: ',lg^.ele.cantidad, '|');
		writeln;
		imprimirListaG (lg^.sig);
	end;
end;

procedure comprendidosEntre (a1: arbol; isbnini,isbnfin: integer; var cantidad: integer);
begin
	if (a1 <> nil) then begin
		if (a1^.dato.isbn >= isbnini) and (a1^.dato.isbn <= isbnfin) then begin
			comprendidosEntre (a1^.hi, isbnini, isbnfin, cantidad);
			comprendidosEntre (a1^.hd, isbnini, isbnfin, cantidad);
			cantidad:= cantidad + 1;
		end
		else begin
			if (a1^.dato.isbn < isbnini) then
				comprendidosEntre (a1^.hd, isbnini, isbnfin, cantidad)
			else
				comprendidosEntre (a1^.hi, isbnini, isbnfin, cantidad);
		end;
	end;
end;

function verificoLista (l: lista): integer;
begin
	if (l <> nil) then 
		verificoLista:= verificoLista (l^.sig) + 1
	else
		verificoLista:= 0;
end;

function comprendidosEntrevol2 (a2: arbol2; isbnini, isbnfin: integer): integer;
begin
	if (a2 <> nil) then begin
		if (a2^.dato2^.ele.isbn >= isbnini) and (a2^.dato2^.ele.isbn <= isbnfin) then 
			comprendidosEntrevol2:= verificoLista (a2^.dato2) + comprendidosEntrevol2 (a2^.hi2, isbnini, isbnfin) + comprendidosEntrevol2 (a2^.hd2, isbnini, isbnfin)
		else begin
			if (a2^.dato2^.ele.isbn < isbnini) then
				comprendidosEntrevol2:= comprendidosEntrevol2 (a2^.hd2, isbnini, isbnfin)
			else
				comprendidosEntrevol2:= comprendidosEntrevol2 (a2^.hi2, isbnini, isbnfin);
		end;
	end
	else 
		comprendidosEntrevol2:= 0;
end;

var	
	a1: arbol;
	a2: arbol2;
	nsocio, nsocio2: integer;
	cant: integer;
	cant2: integer;
	ln: listanueva;
	lg: listag;
	isbnini, isbnfin: integer;
	cantidad: integer;
begin
	a1:= nil;
	a2:= nil;
	ln:= nil;
	lg:= nil;
	cant:= 0;
	cant2:= 0;
	cantidad:= 0;
	generarArboles (a1, a2);
	imprimirArboles (a1, a2); //extra
	writeln;
	writeln;
	write ('El isbn mas grande es: ', isbnMasGrande (a1));//inciso b
	writeln;
	writeln;
	write ('El isbn mas chico es: ', isbnMasPequenio (a2));//inciso c
	writeln;
	writeln;
	write ('Ingrese un numero de socio: ');
	readln (nsocio);
	writeln;
	writeln;
	prestamosAeseSocio (a1, nsocio, cant); //inciso d
	write ('La cantidad de prestamos realizadas a dicho socio es: ', cant); 
	writeln;
	writeln;
	write ('Ingrese un numero de socio: ');
	readln (nsocio2);
	writeln;
	writeln;
	prestamosAeseSocioVol2 (a2,nsocio2, cant2); //inciso e
	write ('La cantidad de prestamos realizadas a dicho socio es: ', cant2);
	writeln;
	writeln;
	incisof (a1,ln); //inciso f
	write ('La lista del inciso f quedo de la siguiente manera: ');
	writeln;
	imprimirListaNueva (ln);
	writeln;
	writeln;
	incisog (a2,lg); //inciso g
	write ('La lista del inciso g quedo de la siguiente manera: ');
	writeln;
	imprimirListaG (lg); //inciso h
	writeln;
	writeln;
	write ('Ingrese el valor inicial de ISBN: ');
	readln (isbnini);
	writeln;
	writeln;
	write ('Ingrese el valor final de ISBN: ');
	readln (isbnfin);
	comprendidosEntre (a1,isbnini, isbnfin, cantidad); //inciso i
	writeln;
	writeln;
	write ('La cantidad total de prestamos realizados a los ISBN comprendidos entre los dos valores ingresados es: ', cantidad);
	writeln;
	writeln;
	write ('Ingrese el valor inicial de ISBN: ');
	readln (isbnini);
	writeln;
	writeln;
	write ('Ingrese el valor final de ISBN: ');
	readln (isbnfin);
	write ('La cantidad total de prestamos realizados a los ISBN comprendidos entre los dos valores ingresados es: ', comprendidosEntrevol2 (a2,isbnini,isbnfin)); //inciso i
end.
