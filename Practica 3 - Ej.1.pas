{1. Descargar el programa ImperativoEjercicioClase3.pas que contiene parte del código del siguiente enunciado a resolver. Implementar lo indicado en el código.
Escribir un programa que:
a. Implemente un módulo que almacene información de socios de un club en un árbol binario de búsqueda. De cada socio se debe almacenar número de socio, nombre y edad. 
La carga finaliza con el número de socio 0 y el árbol debe quedar ordenado por número de socio. La información de cada socio debe generarse aleatoriamente.
b. Una vez generado el árbol, realice módulos independientes que reciban el árbol como parámetro y que :
i. Informar los datos de los socios en orden creciente.
ii. Informar los datos de los socios en orden decreciente.
iii. Informar el número de socio con mayor edad. Debe invocar a un módulo recursivo que retorne dicho valor.
iv. Aumentar en 1 la edad de los socios con edad impar e informar la cantidad de socios que se les aumentó la edad.
vi. Leer un nombre e informar si existe o no existe un socio con ese nombre. Debe invocar a un módulo recursivo que reciba el nombre leído y retorne verdadero o falso.
vii. Informar la cantidad de socios. Debe invocar a un módulo recursivo que retorne dicha cantidad.
viii. Informar el promedio de edad de los socios. Debe invocar a un módulo recursivo que retorne el promedio de las edades de los socios.}

program ej1p3;
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

procedure informarArbolDecreciente (a: arbol);
begin
	if (a <> nil) then begin
		informarArbolDecreciente (a^.hd);
		imprimir (a^.dato);
		informarArbolDecreciente (a^.hi);
	end;
end;

procedure actualizarMaximo(var maxValor,maxElem : integer; nuevoValor, nuevoElem : integer);
begin
	if (nuevoValor >= maxValor) then
		begin
			maxValor := nuevoValor;
			maxElem := nuevoElem;
		end;
end;
	
procedure buscarMaxEdad (a: arbol; var maxEdad: integer; var maxNum: integer);
begin
	if (a <> nil) then
	   begin
		  actualizarMaximo(maxEdad,maxNum,a^.dato.edad,a^.dato.num);
		  buscarMaxEdad(a^.hi, maxEdad,maxNum);
		  buscarMaxEdad(a^.hd, maxEdad,maxNum);
	   end; 
end;

function cumple (var edad: integer): boolean;
begin
	if (edad MOD 2 <> 0) then begin
		edad:= edad + 1;
		cumple:= true
	end
	else
		cumple:= false;
end;

procedure aumentarEdadSocioImpar (a: arbol; var cant: integer);
begin
	if (a <> nil) then begin
		if (cumple (a^.dato.edad)) then 
			cant:= cant + 1;
		aumentarEdadSocioImpar (a^.hi, cant);
		aumentarEdadSocioImpar (a^.hi, cant);
	end;
end;

function estaEnelArbol (a: arbol; nombre: string): boolean;
begin
	if (a = nil) then 
		estaEnelArbol:= false
	else begin
		if (a^.dato.nombre = nombre) then
			estaEnelArbol:= true
		else begin
			estaEnelArbol:= estaEnelArbol (a^.hi, nombre);
			estaEnelArbol:= estaEnelArbol (a^.hd, nombre);
		end;
	end;
end;

procedure cantidadDeSocios (a: arbol; var socios: integer);
begin
	if (a <> nil) then begin
		cantidadDeSocios (a^.hi,socios);
		cantidadDeSocios (a^.hd,socios);
		socios:= socios + 1;
	end;
end;

procedure promedioSocios (a: arbol; var edades: integer);
begin
	if (a <> nil) then begin
		edades:= edades + a^.dato.edad;
		promedioSocios (a^.hi, edades);
		promedioSocios (a^.hd, edades);
	end;
end;

var
	a: arbol;
	v: vector;
	maxEdad, maxNum, cant, socios, edades: integer;
	nombre: string;
begin
	a:= nil;
	maxEdad:= -1;
	maxNum:= -1;
	cant:= 0;
	socios:= 0;
	edades:= 0;
	Randomize;
	cargarVectorNombres (v);
	cargarArbol (a,v);
	writeln;
	write ('El vector de nombres es: ');
	imprimirVector (v); //extra
	writeln;
	write ('El arbol en orden creciente es: ');
	writeln;
	informarArbolCreciente (a); //inciso b1
	writeln;
	write ('El arbol en orden decreciente es: ');
	writeln;
	informarArbolDecreciente (a); //inciso b2
	writeln;
	buscarMaxEdad (a, maxEdad, maxNum);
	write ('El numero de socio con mayor edad es: ', maxNum); //inciso b3 aca se pueden repetir los numeros de socios? 
	writeln;
	aumentarEdadSocioImpar (a, cant); //inciso b4 //revisar!11!
	write ('El arbol luego de la actualizacion de las edades es: ');
	writeln;
	informarArbolCreciente (a);
	writeln;
	write ('La cantidad de socios que se les aumento la edad es: ' , cant); //revisar!!!!
	writeln;
	write ('Ingrese el nombre del socio a buscar: ');
	readln (nombre);
	if (estaEnelArbol (a,nombre)) then //inciso b5 , controlar!!1!
		write ('El nombre de socio buscado si se encuentra en el arbol')
	else
		write ('El nombre de socio buscado no se encuentra en el arbol');
	writeln;
	cantidadDeSocios (a, socios); //inciso b6
	write ('La cantidad total de socios es: ' ,socios);
	writeln;
	promedioSocios (a, edades); //inciso b7
	write ('El promedio de edad de los socios es: ' , (edades/socios):0:2);
end.
