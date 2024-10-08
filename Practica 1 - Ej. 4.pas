{Una librería requiere el procesamiento de la información de sus productos. De cada producto se conoce el código del producto, 
código de rubro (del 1 al 8) y precio.
Implementar un programa que invoque a módulos para cada uno de los siguientes puntos:
a. Lea los datos de los productos y los almacene ordenados por código de producto y agrupados por rubro, en una estructura de datos adecuada. 
El ingreso de los productos finaliza cuando se lee el precio 0.
b. Una vez almacenados, muestre los códigos de los productos pertenecientes a cada rubro.
c. Genere un vector (de a lo sumo 30 elementos) con los productos del rubro 3. Considerar que puede haber más o menos de 30 productos del rubro 3. 
Si la cantidad de productos del rubro 3 es mayor a 30, almacenar los primeros 30 que están en la lista e ignore el resto.
d. Ordene, por precio, los elementos del vector generado en c) utilizando alguno de los dos métodos vistos en la teoría.
e. Muestre los precios del vector resultante del punto d).
f. Calcule el promedio de los precios del vector resultante del punto d).}

program p1ej4;
const
  dimF = 30;
type
  rangorubros = 1..8;
  rangorubro3 = 1..dimF;
  producto = record
    cod: integer;
    rubro: rangorubros;
    precio: real;
  end;
  lista = ^nodo;
  nodo = record
    ele: producto;
    sig: lista;
  end;
  vector = array [rangorubros] of lista;
  vectorubro3 = array [rangorubro3] of producto;

procedure leerproducto (var p: producto);
begin
  readln (p.cod);
  readln (p.rubro);
  readln (p.precio);
end;

procedure inicializarVector (var v: vector);
var
  i: integer;
begin 
  for i:= 1 to 8 do 
    v[i]:= nil;
end;

procedure insertarordenado (var l:lista; p:producto);
var
  act,ant, nuevo: lista;
begin
  new (nuevo);
  nuevo^.ele:= p;
  nuevo^.sig:= nil;
  if (l = nil) then 
    l:= nuevo
  else begin
    act:= l;
    ant:= l;
    while (act <> nil) and (act^.ele.cod < nuevo^.ele.cod) do begin
      ant:= act;
      act:= act^.sig;
    end;
    if (act = l) then begin
      nuevo^.sig:= l;
      l:= nuevo;
    end
    else begin
      ant^.sig:= nuevo;
      nuevo^.sig:= act;
    end;
  end;
end;

procedure cargarVector (var v: vector);
var
  p: producto;
begin 
  leerproducto (p);
  while (p.precio <> 0) do begin 
    insertarordenado (v[p.rubro], p);
    leerproducto (p);
   end;
end;

procedure mostrarcodigos (l: lista);
begin
  while (l <> nil) do
    writeln (l^.ele.cod);
    l:= l^.sig;
end;
  
procedure mostrarProductos (v: vector);
var
  i: integer;
begin
  for i:= 1 to 8 do 
    mostrarcodigos (v[i]);
end;

procedure generarVectorRubro3 (l: lista; var vt: vectorubro3; var dimL: integer);
begin
    while (dimL <= dimF) and (l <> nil) do begin
      dimL:= dimL + 1;
      vt[dimL]:= l^.ele;
      l:= l^.sig;
    end;
end; 

procedure ordenarPorPrecio (var vt: vectorubro3; dimL: integer); //insercion
var
  i,j: integer;
  act: producto;
begin
  for i:= 2 to dimL do begin
    act:= vt[i];
    j:= i-1;
    while (j > 0) and (vt[j].precio > vt[i].precio) do
      begin
        vt[j+1]:= vt[j];
        j:= j - 1;
      end;
    vt[j+1]:= act; //no me guarda solo el precio? Quiero que guarde todo el registro;
   end;
end;

var
  i: integer;
  v: vector;
  vt: vectorubro3;
  dimL: integer;
  total: real;
begin
  dimL:= 0;
  total:= 0;
  inicializarVector (v); 
  cargarVector (v); //inciso A;
  mostrarProductos (v); //inciso B;
  generarVectorRubro3 (v[3],vt, dimL); //inciso C; 
  ordenarPorPrecio (vt,dimL); //inciso D;
  for i:= 1 to dimL do begin
    writeln ('El precio del producto: ' , i, ' es ' , vt[i].precio);// inciso E;
    total:= total + vt[i].precio;
  end;
  writeln ('El promedio resultante del vector es: ' , (total/dimL)); //inciso F;
end.
