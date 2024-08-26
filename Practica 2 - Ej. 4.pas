{Desafío...
4.- Realizar un programa que lea números y que utilice un módulo recursivo que escriba el equivalente en binario de un número decimal. 
El programa termina cuando el usuario ingresa el número 0 (cero).
Ayuda: Analizando las posibilidades encontramos que: Binario(N) es N si el valor es menor a 2. ¿Cómo obtenemos los dígitos que componen al número? 
¿Cómo achicamos el número para la próxima llamada recursiva? Ejemplo: si se ingresa 23, el programa debe mostrar: 10111.}

program ej4p2;
procedure moduloBinario (n: integer);
var
	b: integer;
begin
	if (n <> 0) then begin
		b:= n MOD 2;
		moduloBinario(n DIV 2);
		write (b);
	end
	else 
		write (n);
end;

var
	n: integer;
begin
	write ('Ingrese el numero: ');
	readln (n);
	writeln ('El numero en binario es: ');
	moduloBinario (n);
end.
