{3.- Implementar un programa que invoque a los siguientes módulos.
a. Un módulo recursivo que retorne un vector de 20 números enteros “random” mayores a 300 y menores a 1550 (incluidos ambos).
b. Un módulo que reciba el vector generado en a) y lo retorne ordenado. (Utilizar lo realizado
en la práctica anterior)
c. Un módulo que realice una búsqueda dicotómica en el vector, utilizando el siguiente encabezado:
Procedure busquedaDicotomica (v: vector; ini,fin: indice; dato:integer; var pos: indice);
Nota: El parámetro “pos” debe retornar la posición del dato o -1 si el dato no se encuentra en el vector.}

program ej3p2;
const
	max = 1550;
	min = 300;
	dimF = 20;
type
	vector = array [1..dimF] of integer;
	
procedure generarVectorRecursivo (var v: vector; i: integer);
var
	r: integer;
begin
	r:= min + random (max - min + 1);
	if (i < dimF) then begin
		v[i]:= r;
		generarVectorRecursivo (v, i + 1)
	end;
end;	
	
procedure ordenarVectorseleccion (var v: vector);
var
  i,j,pos, act: integer;
begin
  for i:= 1 to (dimF-1) do begin 
    pos := i;
    for j := (i+1) to dimF do begin
      if (v[j] < v[pos]) then 
        pos:= j;
    end;
    act := v[pos];
    v[pos]:= v[i];
    v[i] := act;
  end;
end;

procedure busquedaDicotomica (v: vector; ini,fin: integer; dato:integer; var pos: integer);
var
	medio: integer;
begin
	ini:= 1;
	fin:= dimF;
	medio:= (ini + fin) DIV 2;
	while (v[medio] <> dato) and (ini<=fin) do
		begin
			if (dato < v[medio]) then
				fin:= medio - 1
			else 
				ini:= medio + 1;
			medio:= (ini + fin) DIV 2;
		end;
	if (ini <= fin) and (v[medio] = dato) then
		pos:= medio
	else
		pos:= -1;
end;

procedure imprimirVector (v: vector; i: integer);
begin
	if (i <= dimF) then begin
		write('| ',v[i],' ');
		imprimirVector (v, i + 1);
	end
	else writeln('|');
end;

var
	v: vector;
	i, ini, fin, dato, pos: integer;
begin
	i:= 1;
	ini:= 1;
	fin:= 20;
	Randomize;
	generarVectorRecursivo (v,i);
	writeln ('El vector desordenado: ');
	writeln;
	imprimirVector (v,i); //DESORDENADO;
	ordenarVectorSeleccion (v);
	writeln ('El vector ordenado: ');
	writeln;
	imprimirVector (v,i); //ORDENADO;
	writeln;
	write ('Ingrese el dato a buscar: ');
	readln (dato);
	busquedaDicotomica (v,ini,fin,dato,pos);
	write ('La posicion del dato dentro del vector es: ' , pos)
end.
