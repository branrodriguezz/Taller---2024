{El administrador de un edificio de oficinas tiene la información del pago de las expensas de dichas oficinas. Implementar un programa con:
a) Un módulo que retorne un vector, sin orden, con a lo sumo las 300 oficinas que administra. Se deben cargar, para cada oficina, el código de identificación, 
DNI del propietario y valor de la expensa. La lectura finaliza cuando llega el código de identificación 0.
b) Un módulo que reciba el vector retornado en a) y retorne dicho vector ordenado por código de identificación de la oficina. Ordenar el vector aplicando 
uno de los métodos vistos en la cursada.
c) Un módulo que realice una búsqueda dicotómica. Este módulo debe recibir el vector generado en b) y un código de identificación de oficina. 
En el caso de encontrarlo, debe retornar la posición del vector donde se encuentra y en caso contrario debe retornar 0. Luego el programa debe informar el
 DNI del propietario o un cartel indicando que no se encontró la oficina.
d) Un módulo recursivo que retorne el monto total de las expensas.}

program ej1p5;
const
	dimF = 300;
type
	oficina = record
		codigo: integer;
		dni: integer;
		valor: real;
	end;
	vector = array [1..dimF] of oficina;

procedure leerInformacion (var o: oficina); //hay q leerlo o generarlo randommmm?
begin
	write ('Ingrese codigo de identificacion: ');
	readln (o.codigo);
	if (o.codigo <> 0) then begin
		write ('Ingrese DNI del propietario: ');
		readln (o.dni);
		write ('Ingrese el valor de la expensa: ');
		readln (o.valor);
		writeln;
	end;
end;

procedure agregoVector (var v: vector; o: oficina; var dimL: integer);
begin
	if (dimL < dimF) then begin
		dimL:= dimL + 1;
		v [dimL]:= o;
	end;
end;

procedure cargarVector (var v: vector; var dimL: integer);
var
	o: oficina;
begin
	leerInformacion (o);
	while (o.codigo <> 0) do begin
		agregoVector (v,o, dimL);
		leerInformacion (o);
	end;
end;

procedure imprimirOficina (o: oficina);
begin
	writeln;
	writeln;
	write ('| Codigo de la oficina: ', o.codigo, '|');
	writeln;
	write ('| DNI del propietario: ', o.dni, '|');
	writeln;
	write ('| Valor de la expensa: ',o.valor:0:2, '|');
	writeln;
	writeln;
end;

procedure imprimirVector (v: vector; dimL: integer);
begin
	if (dimL > 0) then begin
		imprimirOficina (v [dimL]);
		imprimirVector (v, dimL - 1);
	end;
end;

procedure ordenarVector (var v: vector; dimL: integer); //como seria recursivo?
var
	i,j: integer;
	actual: oficina;
begin
	for i:= 2 to dimL do begin
		actual:= v [i];
		j:= i-1;
		while (j > 0) and (v[j].codigo < actual.codigo) do begin
			v [j+1]:= v [j];
			j:= j-1;
		end;
		v [j+1]:= actual;
	end;
end;

var
	v: vector;
	dimL: integer;
begin
	dimL:= 0;
	cargarVector (v, dimL);
	writeln;
	writeln;
	write ('El vector se ve de la siguiente manera: ');
	writeln;
	writeln;
	imprimirVector (v, dimL); //extra
	ordenarVector (v, dimL);
	write ('El vector ordenado por codigo se ve de la siguiente manera: ');
	imprimirVector (v, dimL);//extra
	writeln;
	writeln;
	busquedaDicotomica (v, dimL);
end.
