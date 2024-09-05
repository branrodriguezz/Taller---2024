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

function busquedaDicotomica (v: vector; inf: integer; sup: integer; codigo: integer): integer;
var 
	medio: integer;
begin
	if (inf <= sup) then begin
		medio:= (inf + sup) DIV 2;
		if (codigo < v[medio].codigo) then busquedaDicotomica (v, inf, medio - 1, codigo)
		else 
			if (codigo > v[medio].codigo) then busquedaDicotomica (v, medio + 1, sup, codigo)
			else busquedaDicotomica:= medio;
  end
	else
		busquedaDicotomica:= 0;
end;

function llamadaBusquedaDicotomica (v: vector; dimL: integer; codigo: integer): integer;
var
	inf, sup: integer;
begin
	inf:= 1;
	sup:= dimL;
	llamadaBusquedaDicotomica:= busquedaDicotomica (v, inf, sup, codigo);
end;

procedure montoTotal (v: vector; dimL: integer; var total: real);
begin
	if (dimL > 0) then begin
		total:= total + v[dimL].valor;
		montoTotal (v,dimL - 1, total);
	end;
end;

var
	v: vector;
	dimL: integer;
	codigo: integer;
	i: integer;
	total: real;
begin
	dimL:= 0;
	i:= 0;
	total:= 0;
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
	write ('Ingrese un codigo a buscar: ');
	readln (codigo);
	writeln; 
	writeln;
	i:= llamadaBusquedaDicotomica (v,dimL, codigo);
	if ( i <> 0) then
		write ('El dni del codigo buscado es: ' , v[i].dni)
	else
		write ('No se encontro la oficina');
	writeln;
	writeln;
	montoTotal (v, dimL, total);
	write ('El monto total de las expensas es: ', total:0:2);
end.
