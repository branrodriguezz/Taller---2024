{2. Realice un programa en el que 3 robots realizan una escalera de 4 escalones cada uno. Todos los escalones tienen un ancho fijo de 1, y un alto aleatorio entre 1 y 5. Al finalizar el recorrido, cada robot deberá enviar al robot jefe la cantidad de escalones que tenían más flores que papeles.} {Una vez que los tres robots finalizaron, el robot jefe deberá informar la suma de las cantidades enviadas por los 3 robots.}
{○ El robot jefe inicia en la esquina (1,1)}
{○ El robot 1 inicia en la esquina (2,1)}
{○ El robot 2 inicia en la esquina (7,1)}
{○ El robot 3 inicia en la esquina (12,1)}

programa p2ej2
procesos
  proceso izquierda
  comenzar
    repetir 3
      derecha
  fin
  
  proceso juntarFlores (ES flores: numero)
  comenzar
    mientras (HayFlorEnLaEsquina)
      tomarFlor
      flores:= flores + 1
  fin
  
  proceso juntarPapeles (ES papeles: numero)
  comenzar
    mientras (HayPapelEnLaEsquina)
      tomarPapel
      papeles:= papeles + 1
  fin
  
  proceso escalon (ES cantFloresMayorPap: numero)
  variables
    alto, flores, papeles: numero
  comenzar
    flores:= 0
    papeles:= 0
    Random (alto, 1, 5)
    repetir alto 
      juntarFlores (flores)
      juntarPapeles (papeles)
      mover
      
    derecha
    
    juntarFlores (flores)
    juntarPapeles (papeles)
    mover
    
    izquierda
    
    si (flores > papeles)
      cantFloresMayorPap:= cantFloresMayorPap + 1
    
  fin
  
  proceso realizarEscalera 
  variables
    cantFloresMayorPap: numero
  comenzar
    cantFloresMayorPap:= 0
    repetir 4
      escalon (cantFloresMayorPap)
    EnviarMensaje (cantFloresMayorPap, r4)
  fin
  
areas
  areaCompartida: AreaPC (2,1,16,21)
  areaJefe: AreaP (1,1,1,1)
robots
  robot escalera
  comenzar
    realizarEscalera
  fin
  
  robot jefe
  variables
    totalEscalones, cantF: numero
  comenzar
    totalEscalones:= 0
    RecibirMensaje (cantF, *)
    totalEscalones:= totalEscalones + cantF
    Informar ("La cantidad total de escalones con flores mayor a papel es", totalEscalones)
  fin
  
variables

  r1: escalera
  r2: escalera
  r3: escalera
  r4: jefe
  
comenzar

  AsignarArea (r1, areaCompartida)
  AsignarArea (r2, areaCompartida)
  AsignarArea (r3, areaCompartida)
  AsignarArea (r4, areaJefe)
  Iniciar (r1,2,1)
  Iniciar (r2,7,1)
  Iniciar (r3,12,1)
  Iniciar (r4,1,1)
fin
