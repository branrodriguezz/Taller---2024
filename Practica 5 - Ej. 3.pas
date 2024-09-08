{3. Un supermercado requiere el procesamiento de sus productos. De cada producto se conoce código, rubro (1..10), stock y precio unitario. Se pide:
a) Generar una estructura adecuada que permita agrupar los productos por rubro. A su vez, para cada rubro, se requiere que la búsqueda de un producto por 
código sea lo más eficiente posible. El ingreso finaliza con el código de producto igual a 0.
b) Implementar un módulo que reciba la estructura generada en a), un rubro y un código de producto y retorne si dicho código existe o no para ese rubro.
c) Implementar un módulo que reciba la estructura generada en a), y retorne, para cada rubro, el código y stock del producto con mayor código.
d) Implementar un módulo que reciba la estructura generada en a), dos códigos y retorne, para cada rubro, la cantidad de productos con códigos entre los dos 
valores ingresados.}

program ej3p5;
const
	dimF = 10;
type
	rango = 1..10;
	producto = record
		codigo: integer;
		rubro: rango;
		stock: integer;
		precio: real;
	end;
	
	arbol = ^nodo;
	nodo = record
		dato: producto;
		hi: arbol;
		hd: arbol;
	end;
	
	codigostock = record
		codi: integer;
		stocki: integer;
	end;
	
	vectorRubro = array [1..dimF] of arbol;
	vectorMaximos = array [1..dimF] of codigostock;
	vectorContador = array [1..dimF] of integer;
	
procedure inicializarVectorMaximos (var vm: vectorMaximos);
var
	i: integer;
begin
	for i:= 1 to dimF do
		vm[i].codi:= -1;
end;

procedure inicializarVectorRubro (var v: vectorRubro); //contiene arboles
var
	i: integer;
begin
	for i:= 1 to dimF do
		v[i]:= nil;
end;

procedure generarInformacion (var p: producto);
begin
	p.codigo:= random (100);
	p.rubro:= random (10) + 1;
	p.stock:= random (100);
	p.precio:= random (1000);
end;

procedure cargarArbol (var a: arbol; p: producto);
begin
	if (a = nil) then begin
		new (a);
		a^.dato:= p;
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else begin
		if (p.codigo < a^.dato.codigo) then
			cargarArbol(a^.hi, p)
		else
			cargarArbol (a^.hd, p);
	end
end;

procedure cargar (var v: vectorRubro);
var
	p: producto;
begin
	generarInformacion (p);
	while (p.codigo <> 0) do begin
		cargarArbol (v[p.rubro], p);
		generarInformacion (p);
	end;
end;

procedure imprimirArbol (a: arbol);
begin
	if (a <> nil) then begin
		imprimirArbol (a^.hi);
		writeln;
		write ('| CODIGO ', a^.dato.codigo, '|');
		writeln;
		write ('| STOCK ', a^.dato.stock, '|');
		writeln;
		write ('| PRECIO ', a^.dato.precio:0:2, '|');
		writeln;
		imprimirArbol (a^.hd);
	end;
end;

procedure imprimirArboles (v: vectorRubro);
var
	i: integer;
begin
	for i:= 1 to dimF do begin
		if (v[i] <> nil) then begin //chequeo antes de imprimir algo que no tiene nada, si el arbol de ese rubro esta es distinto de nil
			writeln;
			write ('Los productos del rubro ', i, ' : ');
			writeln;
			imprimirArbol (v[i]);
		end;
	end;
end;

function existe (a: arbol; cod: integer): boolean;
begin
	if (a <> nil) then begin
		if (cod = a^.dato.codigo) then
			existe:= true
		else begin
			if (cod < a^.dato.codigo) then
				existe:= existe (a^.hi, cod)
			else 
				existe:= existe (a^.hd, cod);
		end;
	end
	else 
		existe:= false;
end;

procedure chequeoMaximoDeEseArbol (a: arbol; var cs: codigostock);
begin
	if (a <> nil) then begin
		if (a^.hd <> nil ) then
			chequeoMaximoDeEseArbol (a^.hd, cs)
		else begin
			cs.codi:= a^.dato.codigo;
			cs.stocki:= a^.dato.stock;
		end;
	end;
end;

procedure retornarMayoresCodigos (v: vectorRubro; var vm: vectorMaximos; dimL: integer);
begin
	if (dimL > 0) then begin
		chequeoMaximoDeEseArbol (v[dimL], vm [dimL]);
		retornarMayoresCodigos (v,vm,dimL - 1);
	end;
end;

procedure imprimirCodigoMax (vm: vectorMaximos);
var
	i: integer;
begin
	for i:= 1 to dimF do begin
		write ('El rubro : ' ,i);
		writeln;
		write ('Tiene como maximo al codigo: ', vm[i].codi, ' y stock : ', vm[i].stocki);
		writeln;
		writeln;
	end;
end;

procedure inicializarVectorContador (var vc: vectorContador);
var
	i: integer;
begin
	for i:= 1 to dimF do 
		vc[i]:= 0;
end;

function chequeoArbol (a: arbol; codigoIni, codigoFin: integer): integer;
begin
	if (a <> nil) then begin
		if (a^.dato.codigo > codigoIni) and (a^.dato.codigo < codigoFin) then
			chequeoArbol:= 1 + chequeoArbol (a^.hi, codigoIni, codigoFin) + chequeoArbol (a^.hd, codigoIni, codigoFin)
		else begin
			if (a^.dato.codigo < codigoIni) then
				chequeoArbol:= chequeoArbol (a^.hd, codigoIni, codigoFin)
			else
				chequeoArbol:= chequeoArbol (a^.hi, codigoIni, codigoFin);
		end;
	end
	else
		chequeoArbol:= 0;
end;

procedure entreEsosDos (v: vectorRubro; codigoIni, codigoFin: integer; var vc: vectorContador; dimL: integer);
begin
	if (dimL > 0) then begin
		vc[dimL]:= chequeoArbol (v[dimL], codigoIni,codigoFin);
		entreEsosDos (v,codigoIni, codigoFin, vc, dimL - 1);
	end;
end;

procedure imprimirVectorContador (vc: vectorContador);
var
	i: integer;
begin
	for i:= 1 to dimF do begin
		if (vc[i] <> 0) then begin
			write ('La cantidad de productos del rubro: ',i,' comprendido entre los dos codigos ingresados es: ', vc[i]);
			writeln;
		end;
	end;
end;

var
	v: vectorRubro;
	cod, rubro: integer;
	vm: vectorMaximos;
	dimL: integer;
	codigoini, codigofin: integer;
	vc: vectorContador;
begin
	dimL:= dimF;
	Randomize;
	inicializarVectorRubro (v);
	cargar (v);
	imprimirArboles (v); //extra
	writeln;
	write ('Ingrese un rubro: ');
	readln (rubro);
	writeln;
	write ('Ingrese un codigo de producto: ');
	readln (cod);
	writeln;
	if (existe (v [rubro], cod)) then //retorno si existe
		write ('El codigo de producto existe para este rubro')
	else
		write ('No existe en este rubro');
	writeln;
	inicializarVectorMaximos (vm);
	retornarMayoresCodigos (v, vm, dimL);
	writeln;
	imprimirCodigoMax (vm); //extra
	writeln;
	inicializarVectorContador (vc);
	write ('Ingrese el codigo inicial: ');
	readln (codigoini);
	writeln;
	write ('Ingrese el codigo final: ');
	readln (codigofin);
	entreEsosDos (v,codigoini, codigofin, vc, dimL); 
	writeln;
	write ('El vector de cantidades por rubro quedo de la siguiente manera: ');
	writeln;
	writeln;
	imprimirVectorContador (vc); //extra
end.
