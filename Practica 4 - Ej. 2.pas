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


function socioMasGrande (a: arbol): integer; 
var
	maxSocio: integer;
begin
	if (a <> nil) then
		socioMasGrande (a^.hi);
		socioMasGrande (a^.hd);
		socioMasGrande:= 
end;

var
	a: arbol;
	v: vector;
begin
	a:= nil;
	Randomize;
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
	write ('El numero de socio mas grande es: ' , socioMasGrande(a));
end.
