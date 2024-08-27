 {2.- Escribir un programa que:
a. Implemente un módulo recursivo que genere y retorne una lista de números enteros “random” en el rango 100-200. Finalizar con el número 100.
b. Un módulo recursivo que reciba la lista generada en a) e imprima los valores de la lista en el mismo orden que están almacenados.
c. Implemente un módulo recursivo que reciba la lista generada en a) e imprima los valores de la lista en orden inverso al que están almacenados.
d. Implemente un módulo recursivo que reciba la lista generada en a) y devuelva el mínimo valor de la lista.
e. Implemente un módulo recursivo que reciba la lista generada en a) y un valor y devuelva verdadero si dicho valor se encuentra en la lista o falso en caso contrario.}

program ej2p2;
const
	min = 100;
	max = 200;
type
	lista = ^nodo;
	nodo = record
		ele: integer;
		sig: lista;
	end;

procedure generarLista (var l: lista);
var 
	nuevo: lista;
	r: integer;
begin
	r:= min + random (max - min + 1);
	if (r <> 100) then begin
		new (nuevo);
		nuevo^.ele:= r;
		nuevo^.sig:= nil;
		if (l = nil) then 
			l:= nuevo
		else begin
			nuevo^.sig:= l;
			l:= nuevo;
		end;
		generarLista (l);
	end;
end;

procedure imprimirListaOrden (l: lista);
begin
	if (l <> nil) then begin
		write (l^.ele);
		write(' | ');
		imprimirListaOrden (l^.sig);
	end;
end;

procedure imprimirListaOrdenInverso (l: lista);
begin
	if (l <> nil) then begin
		imprimirListaOrdenInverso (l^.sig);
		write(' | ');
		write (l^.ele);
		write(' | ');
	end;
end;

procedure minimoElemento (l: lista; var minimo: integer);
begin
	if (l <> nil) then begin
        if (l^.ele < minimo) then
            minimo:= l^.ele;
        minimoElemento(l^.sig, minimo);
    end;
end;

function estaEnlaLista (l: lista; valor: integer): boolean;
begin
	if (l = nil) then
		estaEnlaLista:= false
	else begin
		if (l^.ele = valor) then
			estaEnlaLista:= true
		else
			estaEnlaLista:= estaEnlaLista (l^.sig, valor);
	end;
end;

var
	l: lista;
	minimo, valor: integer;
begin
	l:= nil;
	Randomize;
	minimo:= 999;
	generarLista (l); //INCISO A;
	writeln ('La lista en orden ingresado es la siguiente: ' );
	imprimirListaOrden (l); //INCISO B;
	writeln;
	writeln ('La lista en orden inverso al ingresado es la siguiente: ' );
	imprimirListaOrdenInverso (l); //INCISO C;
	writeln;
	minimoElemento (l, minimo); //INCISO D;
	write ('El minimo elemento de esta lista es: ' , minimo);
	writeln;
	write ('Ingrese un valor a buscar: ');
	readln (valor);
	if (estaEnlaLista (l, valor)) then //INCISO E;
		write ('El valor buscado si esta en la lista')
	else
		write ('El valor buscado no esta en la lista');
end.
