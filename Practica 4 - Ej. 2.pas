{Descargar el programa ImperativoEjercicioClase3.pas de la clase anterior e incorporar lo necesario para:
i. Informar el número de socio más grande. Debe invocar a un módulo recursivo que retorne dicho valor.
ii. Informar los datos del socio con el número de socio más chico. Debe invocar a un módulo recursivo que retorne dicho socio.
iii. Leer un valor entero e informar si existe o no existe un socio con ese valor. Debe invocar a un módulo recursivo que reciba el valor leído y 
retornar verdadero o falso.
iv. Leer e informar la cantidad de socios cuyos códigos se encuentran comprendidos entre los valores leídos. Debe invocar a un módulo recursivo que 
reciba los valores leídos y retorne la cantidad solicitada.}

program ej2p4;
const
	min = 1;
	max = 100;
	minV = 1;
	dimF = 5;
type
	vector = array [1..dimF] of string;
	socio = record
		num: integer;
		nombre: string;
		edad: integer;
	end;
	
	arbol = ^nodo;
	nodo = record
		dato: socio;
		hi: arbol;
		hd: arbol;
	end;
	
procedure cargarVectorNombres (var v: vector);
var
	i: integer;
	name: string;
begin
	for i:= 1 to dimF do begin
		write('Ingrese un nombre: ');
		readln (name);
		v[i]:= name;
	end;
end;

procedure agregar (var a: arbol; s: socio);
begin
	if (a = nil) then begin
		new (a);
		a^.dato:= s;
		a^.hi:= nil; 
		a^.hd:= nil;
	end
	else begin
		if (s.num <= a^.dato.num) then 
			agregar (a^.hi, s)
		else 
			agregar (a^.hd, s);
	end;
end;

procedure generarSocio (var s: socio; v: vector);
begin
	s.num:= random (100);
	s.nombre:= v [minV + random (dimF - minV + 1)];
	s.edad:= min + random (max - min + 1);
end; 

procedure cargarArbol (var a: arbol; v: vector);
var
	s: socio;
begin
	generarSocio (s,v);
	if (s.num <> 0) then begin
		agregar (a, s);
		cargarArbol (a,v);
	end;	
end;

procedure imprimirVector (v: vector);
var
	i: integer;
begin
	for i:= 1 to dimF do 
		write ('|', v[i], '|');
end;

procedure imprimir (s: socio);
begin
	write ('Numero de socio:  ' , s.num);
	writeln;
	write ('Nombre :  ' , s.nombre);
	writeln;
	write ('Edad: ' ,s.edad);
	writeln;
end;

procedure informarArbolCreciente (a: arbol);
begin
	if (a <> nil) then begin
		informarArbolCreciente (a^.hi);
		imprimir (a^.dato);
		informarArbolCreciente (a^.hd);
	end;
end;


procedure socioMasGrande (a: arbol; var maxSocio: integer); 
begin
	if (a <> nil) then begin
		if (a^.hd <> nil) then //chequeo que no me quede sin elementos del lado derecho del arbol porque estan los + grandes
			socioMasGrande (a^.hd,maxSocio) //llamo solo con los de la derecha
		else maxSocio:= a^.dato.num; //salgo del if y retorno el valor maximo si el lado derecho es igual a nil
	end;
end;

procedure socioMasChico (a: arbol; var socioMinimo: socio);
begin
	if (a <> nil) then begin
		if (a^.hi <> nil) then
			socioMasChico (a^.hi, socioMinimo)
		else socioMinimo:= a^.dato;
	end;
end;

function esta (a: arbol; valor: integer): boolean;
begin
	if (a <> nil) then begin
		if (a^.dato.num = valor) then
			esta:= true
		else begin
			if (valor < a^.dato.num) then
				esta:= esta (a^.hi, valor)
			else 
				esta:= esta (a^.hd, valor);
		end;
	end
	else
		esta:= false;
end;

procedure cantidadDeSociosEntre (a: arbol; var cantS: integer; valorini: integer; valorfin: integer);
begin
	if (a <> nil) then begin
		if (a^.dato.num >= valorini) and (a^.dato.num <= valorfin) then begin
			cantidadDeSociosEntre (a^.hi, cantS, valorini, valorfin);
			cantidadDeSociosEntre (a^.hd, cantS, valorini, valorfin);
			cantS:= cantS + 1;
		end
		else begin
			if (a^.dato.num < valorini) then
				cantidadDeSociosEntre (a^.hd, cantS, valorini, valorfin)
			else
				cantidadDeSociosEntre (a^.hi, cantS, valorini, valorfin);
		end;
	end;
end;

var
	a: arbol;
	v: vector;
	maxSocio: integer;
	socioMinimo: socio;
	valor: integer;
	cantS: integer;
	valorini,valorfin: integer;
begin
	a:= nil;
	Randomize;
	maxSocio:= -1;
	socioMinimo.num:= 0;
	socioMinimo.nombre:= '';
	socioMinimo.edad:= 0;
	cantS:= 0;
	cargarVectorNombres (v);
	cargarArbol (a, v);
	write ('El vector de nombres es: ');
	imprimirVector (v); //extra
	writeln;
	writeln ('////////////////////////////////////////////////////////');
	write ('El arbol en orden creciente es: ');
	writeln;
	informarArbolCreciente (a); //inciso b1
	writeln;
	writeln ('////////////////////////////////////////////////////////');
	socioMasGrande(a,maxSocio);
	write ('El numero de socio mas grande es: ', maxSocio);
	writeln;
	writeln ('////////////////////////////////////////////////////////');
	socioMasChico (a,socioMinimo);
	write ('Los datos del numero de socio mas chico es: ', socioMinimo.num, '|' ,socioMinimo.nombre , '|' , socioMinimo.edad);
	writeln;
	writeln ('////////////////////////////////////////////////////////');
	writeln;
	write ('Ingrese un valor a buscar');
	readln (valor);
	if (esta(a, valor)) then
		write ('El valor esta dentro del arbol')
	else
		write ('El valor no esta dentro del arbol');
	writeln;
	write ('Ingrese el valor inicial del rango: ');
	readln (valorini);
	writeln;
	write ('Igrese el valor final del rango: ');
	readln (valorfin);
	cantidadDeSociosEntre (a, cantS,valorini,valorfin);
	write ('La cantidad de socios que estan dentro del rango es: ', cantS);
end.
