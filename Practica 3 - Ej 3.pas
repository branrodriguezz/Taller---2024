{3. Implementar un programa que contenga:
a. Un módulo que lea información de los finales rendidos por los alumnos de la Facultad de Informática y los almacene en una estructura de datos. 
La información que se lee es legajo, código de materia, fecha y nota. La lectura de los alumnos finaliza con legajo 0. 
La estructura generada debe ser eficiente para la búsqueda por número de legajo y para cada alumno deben guardarse los finales que rindió en una lista.
b. Un módulo que reciba la estructura generada en a. y retorne la cantidad de alumnos con legajo impar.
c. Un módulo que reciba la estructura generada en a. e informe, para cada alumno, su legajo y su cantidad de finales aprobados (nota mayor o igual a 4).
c. Un módulo que reciba la estructura generada en a. y un valor real. Este módulo debe retornar los legajos y promedios de los alumnos 
cuyo promedio supera el valor ingresado.}

program ej3p3;
type
	fechaa = record
		dia: integer;
		mes: integer;
		anio: integer;
	end;
	
	final = record
		legajo: integer;
		codMateria: string;
		fecha: fechaa;
		nota: integer;
	end;
//final
	lista = ^nodo;
	nodo = record
		ele: final;
		sig: lista;
	end;
//lista de finales
	
	alumno = record
		alegajo: integer;
		finales: lista;
	end;
//alumno con su numero de legajo y su lista de finales 
	arbol = ^nodoA;
	nodoA = record
		dato: alumno;
		hi: arbol;
		hd: arbol;
	end;
//arbol de alumnos ordenado por numero de legajo con una lista de finales dados

	legajospromedios = record
		legajo: integer;
		promedio: real;
	end;
	
	listalp = ^nodolp;
	nodolp = record
		ele: legajospromedios;
		sig: listalp;
	end;
	
procedure leerinformacion (var f: final);
begin
	writeln;
	write ('Ingrese un numero de legajo: ');
	readln (f.legajo);
	if (f.legajo <> 0) then begin
		write ('Ingrese un codigo de materia: ');
		readln (f.codMateria);
		write ('Ingrese un dia: '); 
		readln (f.fecha.dia);
		write ('Ingrese un mes: '); 
		readln (f.fecha.mes);
		write ('Ingrese un anio: '); 
		readln (f.fecha.anio);
		write ('Ingrese la nota: ');
		readln (f.nota);
	end;
end;
//leo la informacion a cargar en mi arbol
procedure insertarOrdenado (var l: lista; f: final); //recursivo???
var
	nue, act, ant: lista;
begin
	new (nue);
	nue^.ele:= f;
	nue^.sig:= nil;
	if (l = nil) then
		l:= nue
	else begin
		act:= l;
		ant:= l;
		while (act <> nil) and (act^.ele.nota < nue^.ele.nota) do begin
			ant:= ant;
			act:= act^.sig;
		end;
		if (act = l) then begin
			nue^.sig:= l;
			l:= nue;
		end
		else begin
			ant^.sig:= nue;
			nue^.sig:= act;
		end;
	end;
end;

procedure agregarArbol (var a: arbol; f: final);
begin
	if (a = nil) then begin
		new (a);
		a^.dato.finales:= nil;
		a^.dato.alegajo:= f.legajo;
		insertarOrdenado (a^.dato.finales, f);
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else begin
		if (a^.dato.alegajo = f.legajo) then
			insertarOrdenado (a^.dato.finales, f)
		else begin
			if	(f.legajo < a^.dato.alegajo) then
				agregarArbol (a^.hi,f)
			else
				agregarArbol (a^.hd,f);
		end;
	end;
end;
//agrego a mi arbol

procedure cargarArbol (var a: arbol); //recursivo?
var
	f: final;
begin
	leerinformacion (f);
	while (f.legajo <> 0) do begin
		agregarArbol (a, f);
		leerinformacion (f);
	end;
end;
//cargo el arbol con condicion de corte
procedure imprimirLista (l: lista);
begin
	if (l <> nil) then begin
		writeln ('Final de (con codigo de materia): ', l^.ele.codMateria);
		write ('  en la fecha: |' , l^.ele.fecha.dia, '|' ,l^.ele.fecha.mes, '|' ,l^.ele.fecha.anio, '|');
		write ('  nota: ' , l^.ele.nota);
		writeln;
		imprimirLista (l^.sig);
	end;
end;

procedure imprimo (a: alumno);
begin
	writeln;
	write ('El alumno con numero de legajo ' , a.alegajo, ' tiene: ');
	writeln;
	imprimirLista (a.finales);
	writeln;
end;

procedure imprimirArbol (a: arbol);
begin
	if (a <> nil) then begin
		imprimirArbol (a^.hi);
		imprimo (a^.dato);
		imprimirArbol (a^.hd);
	end;
end;

procedure legajoImpar (a: arbol; var cant: integer);
begin
	if (a <> nil) then begin
		legajoImpar (a^.hi, cant);
		if (a^.dato.alegajo MOD 2 <> 0) then
			cant:= cant + 1;
		legajoImpar (a^.hd,cant);
	end;
end;

procedure recorrerLista (l: lista; var apro: integer);
begin
	if (l <> nil) then begin
		if (l^.ele.nota >= 4) then
			apro:= apro + 1;
		recorrerLista (l^.sig, apro);
	end;
end;

procedure finalesAprobados (a: arbol);
var
	apro: integer;
begin
	apro:= 0;
	if (a <> nil) then begin
		finalesAprobados (a^.hi);
		writeln;
		write ('El alumno con numero de legajo: ' , a^.dato.alegajo);
		writeln;
		recorrerLista (a^.dato.finales, apro);
		write ('Tiene aprobado : ' , apro , ' finales ');
		writeln;
		finalesAprobados (a^.hd);
	end;
end;

procedure contarFinalesyCalcularPromedio (l: lista; var nota: integer; var cantt: integer);
begin
	if (l <> nil) then begin
		nota:= nota + l^.ele.nota;
		cantt:= cantt + 1;
		contarFinalesyCalcularPromedio (l^.sig, nota, cantt);
	end;
end;

procedure agregarAdelante (var l: listalp; lp: legajospromedios);
var
	nue: listalp;
begin
	new (nue);
	nue^.ele:= lp;
	nue^.sig:= nil;
	if (l = nil) then
		l:= nue
	else begin
		nue^.sig:= l;
		l:= nue;
	end;
end;

procedure legajosyPromedios (a: arbol; valor: real; var l: listalp);
var
	lp: legajospromedios;
	promedio: real;
	cantt: integer;
	nota: integer;
begin
	promedio:= 0;
	cantt:= 0;
	nota:= 0;
	if (a <> nil) then begin
		legajosyPromedios (a^.hi,valor,l);
		contarFinalesyCalcularPromedio (a^.dato.finales, nota, cantt);
		promedio:= nota/cantt;
		if (promedio > valor) then begin
			lp.legajo:= a^.dato.alegajo;
			lp.promedio:= promedio;
			agregarAdelante (l,lp);
		end;
		legajosyPromedios (a^.hd,valor,l);
	end;
end;

procedure imprimirLista (l: listalp);
begin
	if (l <> nil) then begin
		write ('| Legajo ', l^.ele.legajo, '|');
		write ('| Promedio ', l^.ele.promedio:0:2, '|');
		imprimirLista (l^.sig);
	end;
end;

var
	a: arbol;
	cant: integer;
	valor: real;
	l: listalp;
begin
	a:= nil;
	l:= nil;
	cant:= 0;
	cargarArbol(a);
	writeln;
	write ('El arbol es: (en orden)');
	writeln; 
	imprimirArbol (a);
	legajoImpar (a, cant); //inciso b
	write ('La cantidad de alumnos con legajo impar es: ' ,cant);
	writeln;
	finalesAprobados (a); //inciso c;
	writeln;
	write ('Ingrese el valor: ');
	readln (valor);
	legajosyPromedios (a,valor,l); //inciso d
	writeln;
	write ('La lista de legajos y promedios es (solo de los que superan el valor ingresado): ');
	imprimirLista (l);
end.
