{1. Descargar el programa ImperativoEjercicioClase4.pas. y completar los módulos indicados en el código.
a. Almacenar los productos vendidos en una estructura eficiente para la búsqueda por código de producto. De cada producto deben quedar almacenados su código, 
la cantidad total de unidades vendidas y el monto total. De cada venta se cargan código de venta, código del producto vendido, cantidad de unidades vendidas 
y precio unitario. El ingreso de las ventas finaliza cuando se lee el código de venta 0.
b. Imprimir el contenido del árbol ordenado por código de producto.
c. Retornar el menor código de producto.
d. Retornar la cantidad de códigos que existen en el árbol que son menores que un valor que se recibe como parámetro.
e. Retornar el monto total entre todos los códigos de productos comprendidos entre dos valores recibidos (sin incluir) como parámetros.}

program ej1p4;
type
	venta = record
		codigoVenta: integer;
		codigoProducto: integer;
		cantUnidades: integer;
		precioUnitario: real;
    end;
    
    productoVendido = record
		codigo: integer;
		cantTotalUnidades: integer;
		montoTotal: real;
	end;
     
    arbol = ^nodoArbol;
    nodoArbol = record
		dato: productoVendido;
		HI: arbol;
		HD: arbol;
	end;
	
procedure generarInformacion (var v: venta);
begin
	writeln;
	write ('Ingrese un codigo de venta: ');
	readln (v.codigoVenta);
	if (v.codigoVenta <> 0) then begin
		write ('Ingrese un codigo de producto: ');
		readln (v.codigoProducto);
		write ('Ingrese la cantidad de unidades vendidas: ');
		readln (v.cantUnidades);
		write ('Ingrese el precio unitario del producto: ');
		readln (v.precioUnitario);
	end;
end;

procedure agregarArbol (var a: arbol; v: venta);
begin
	if (a = nil) then begin
		new (a);
		a^.dato.codigo:= v.codigoProducto;
		a^.dato.cantTotalUnidades:= v.cantUnidades;
		a^.dato.montoTotal:= (v.cantUnidades * v.precioUnitario);
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else begin
		if (a^.dato.codigo = v.codigoProducto) then begin
			a^.dato.cantTotalUnidades:= a^.dato.cantTotalUnidades + v.cantUnidades;
			a^.dato.montoTotal:= a^.dato.montoTotal + (v.cantUnidades * v.precioUnitario);
		end
		else begin
			if (v.codigoProducto < a^.dato.codigo) then
				agregarArbol (a^.hi, v)
			else
				agregarArbol (a^.hd, v);
		end;
	end;
end;

procedure cargarArbol (var a: arbol); //recursivo?
var
	v: venta;
begin
	generarInformacion (v);
	while (v.codigoVenta <> 0) do begin
		agregarArbol (a,v);
		generarInformacion (v);
	end;
end;

procedure impresion (p: productoVendido);
begin
	writeln;
	write ('| Codigo de producto: ', p.codigo, '|');
	write ('| Cantidad total de unidades vendidas: ', p.cantTotalUnidades, '|');
	write ('| Monto total: ',p.montoTotal:0:2, '|');
	writeln;
end;

procedure imprimirArbol (a: arbol);
begin
	if (a <> nil) then begin
		imprimirArbol (a^.hi);
		impresion (a^.dato);
		imprimirArbol (a^.hd);
	end;
end;
procedure buscarMin (a: arbol; var minCod: integer);
begin
	if (a <> nil) then begin
		if (a^.dato.codigo < minCod) then
			minCod:= a^.dato.codigo;
		buscarMin (a^.hi,minCod); //esta bien que busque solo por el izquierdo si me pide retornar menores?
	end;
end;

function retornarMenorCodigoProd (a: arbol): integer;
var
	minCod: integer;
begin
	minCod:= 9999;
	buscarMin (a, minCod);
	retornarMenorCodigoProd:= minCod;
end;

procedure codigosMenores (a: arbol; valor: integer; var cant: integer);
begin
	if (a <> nil) then begin
		if (a^.dato.codigo < valor) then
			cant:= cant + 1;
		codigosMenores (a^.hi,valor,cant); //por que si recorro solo para el lado izquierdo me tira datos erroneos?
		codigosMenores (a^.hd, valor, cant);
	end;
end;

procedure totalComprendidos (a: arbol; codini: integer; codfin: integer; var total: real);
begin
	if (a <> nil) then begin
		if (a^.dato.codigo > codini) and (a^.dato.codigo < codfin) then begin //chequeo que el codigo que estoy analizando sea mayor que el inicial (no lo incluyo) y menor que el final
			//osea chequeo que este entre ese rango de codigos.
			totalComprendidos (a^.hi,codini,codfin,total);
			totalComprendidos (a^.hd,codini,codfin,total);
			total:= total + a^.dato.montoTotal;
		end
		else begin
			if (a^.dato.codigo < codini) then 
				totalComprendidos (a^.hd, codini,codfin,total)
			else
				totalComprendidos (a^.hi, codini,codfin,total);
		end;
	end;
end;


var
	a: arbol;
	valor,cant,codini,codfin: integer;
	total: real;
begin
	a:= nil;
	cargarArbol (a);
	cant:= 0;
	total:= 0;
	writeln;
	write ('//-----------------El arbol quedo de la siguiente manera------------------------');
	imprimirArbol (a);
	writeln;
	write ('El menor codigo de producto es: ', retornarMenorCodigoProd(a));
	writeln;
	writeln;
	write ('Ingrese un valor de codigo: ');
	readln (valor);
	codigosMenores (a,valor, cant);
	writeln;
	write ('La cantidad de codigos menores al valor ingresado es: ' , cant);
	writeln;
	write ('Ingrese el codigo inicial: ');
	readln (codini);
	writeln;
	write ('Ingrese el codigo final: ');
	readln (codfin);
	writeln;
	totalComprendidos (a,codini, codfin, total);
	write ('El monto total entre todos los códigos de productos comprendidos entre dos valores recibidos (sin incluir) es: ' , total:0:2);
end.
