{1.- Descargar el programa ImperativoEjercicioClase2.pas que contiene parte del código del siguiente enunciado a resolver. Implementar lo indicado en el código.
Implementar un programa que invoque a los siguientes módulos.
a. Un módulo recursivo que retorne un vector de a lo sumo 15 números enteros “random” mayores a 10 y menores a 155 (incluidos ambos). La carga finaliza con el valor 20.
b. Un módulo no recursivo que reciba el vector generado en a) e imprima el contenido del vector.
c. Un módulo recursivo que reciba el vector generado en a) e imprima el contenido del vector.
d. Un módulo recursivo que reciba el vector generado en a) y devuelva la suma de los valores pares contenidos en el vector.
e. Un módulo recursivo que reciba el vector generado en a) y devuelva el máximo valor del vector.
f. Un módulo recursivo que reciba el vector generado en a) y un valor y devuelva verdadero si dicho valor se encuentra en el vector o falso en caso contrario.
g. Un módulo que reciba el vector generado en a) e imprima, para cada número contenido en el vector, sus dígitos en el orden en que aparecen en el número.
 Debe implementarse un módulo recursivo que reciba el número e imprima lo pedido. Ejemplo si se lee el valor 142, se debe imprimir 1 4 2.}

program ej1p2;
const
	dimF = 15;
	min = 10;
	maxi = 155;
type
	vector = array [1..dimF] of integer;
	
procedure cargarVectorRecursivo (var v: vector; var dimL: integer);
var
	r: integer;
begin
	r:= min + random (maxi - min + 1);
	if (r <> 20) and (dimL < dimF) then begin
		dimL:= dimL + 1;
		v[dimL]:= r;
		cargarVectorRecursivo (v, dimL);
	end;
end;

procedure imprimirVectorNorecursivo (v: vector; dimL: integer);
var
	i: integer;
begin
	for i:= 1 to dimL do 
		write (' | ' , v[i] , ' | ');
end;

procedure imprimirVectorRecursivo (v: vector; dimL: integer);
begin
	if (dimL > 0) then begin
		imprimirVectorRecursivo (v, dimL - 1);
		write (' | ' , v[dimL] , ' | ');
	end;
end;

function sumaContenidosPares (v: vector; pos: integer; dimL: integer): integer;
begin
	if (pos > dimL) then 
		sumaContenidosPares:= 0
	else begin
		if ((v[pos] MOD 2) = 0) then
			sumaContenidosPares:= v [pos] + sumaContenidosPares (v, pos + 1, dimL)
		else 
			sumaContenidosPares:= sumaContenidosPares (v, pos + 1, dimL);
	end;
end;
 
procedure maximoRecursivo (v: vector; dimL: integer; var max: integer); //por que conservo el max?
Begin
    If (dimL > 0) then begin
        If (v[dimL] > max) then
            max:= v[dimL];
        maximoRecursivo(v, dimL-1,max);
    end;
end;

function estaEnelVector (v: vector; dimL: integer; valor: integer): boolean;
begin
	if (dimL <= 0) then 
		estaEnelVector:= false
	else begin
		if (v[dimL] = valor) then
			estaEnelVector:= true
		else
			estaEnelVector:= estaEnelVector (v, dimL - 1, valor);
	end;
end;

procedure imprimirValorRecursivo (num: integer);
var 
	dig: integer;
begin
	if (num <> 0) then begin
		imprimirValorRecursivo (num DIV 10);
		dig:= num MOD 10;
		write (dig);
		write ('  ');
	end;
end;

procedure imprimirVector (v: vector; dimL: integer);
var
	i: integer;
begin
	for i:= 1 to dimL do begin
		imprimirValorRecursivo(v[i]);
		write ('| ');
	end;
end;

var
	v: vector;
	dimL: integer;
	sumaPares,pos: integer;
	valor, max: integer;
begin
	dimL:= 0;
	sumaPares:= 0;
	pos:= 1;
	Randomize;
	cargarVectorRecursivo(v,dimL); //INCISO A;
	writeln ('El vector es: (de manera no recursiva)');
	imprimirVectorNorecursivo (v, dimL); //INCISO B;
	writeln;
	writeln ('El vector es: (de manera recursiva)');
	imprimirVectorRecursivo (v, dimL); //INCISO C;
	sumaPares:= sumaPares + sumaContenidosPares (v, pos, dimL); //INCISO D;
	writeln;
	writeln ('La suma de los valores pares contenidos en el vector es: ' , sumaPares);
	maximoRecursivo (v, dimL, max); //INCISO E;
	writeln ('El maximo valor del vector es: ' , max);
	write ('Ingrese el valor a buscar: ');
	readln (valor);
	if (estaEnelVector (v, dimL, valor)) then //INCISO F;
		writeln ('El elemento buscado si esta en el vector')
	else
		writeln ('El elemento buscado no esta en el vector');
	writeln ('El vector por digitos se ve asi: ');
	imprimirVector (v, dimL); //INCISO G;
end.
