{Realice un programa en el que dos robots se encargan de limpiar las ciudad. La ciudad se dividió en 4 áreas: las impares (1 y 3) deben limpiarse de flores; y las pares (2 y 4) deben limpiarse de papeles. Un robot debe encargarse de las áreas impares y otro robot de las pares. Modularice el recorrido de cada área
{- - - -}
{Área 1: desde la avenida 1 hasta la avenida 25 Área 2: desde la avenida 26 hasta la avenida 50 Área 3: desde la avenida 51 hasta la avenida 75 Área 4: desde la avenida 76 hasta la avenida 100
}

programa p1ej4
procesos
  proceso juntarPapeles 
  comenzar
    mientras (HayPapelEnLaEsquina)
      tomarPapel
  fin
  
  proceso recorrerAvenidaImpar (E numAv: numero)
  comenzar
    Pos (numAv, 1)
    repetir 99
      juntarPapeles
      mover
  fin
  
  proceso recorrerAvenidaPar (E numAv: numero)
  comenzar
    Pos (numAv, 1)
    repetir 99
      juntarPapeles
      mover
  fin
  
  
  proceso recorrerAreasImpares
  variables
    numAv: numero
  comenzar
    numAv:= 1
    repetir 25
      recorrerAvenidaImpar (numAv)
      numAv:= numAv + 1
    numAv:= 51
    Pos (numAv, 1)
    repetir 25
      recorrerAvenidaImpar (numAv)
      numAv:= numAv + 1
  fin
  
  proceso recorrerAreasPares
  variables
    numAv: numero
  comenzar
    numAv:= 26
    repetir 25
      recorrerAvenidaPar (numAv)
      numAv:= numAv + 1
    numAv:= 76
    Pos (numAv, 1)
    repetir 25
      recorrerAvenidaPar (numAv)
      numAv:= numAv + 1
  fin
  
areas

  area1: AreaP (1,1,25,100)
  area2: AreaP (26,1,50,100)
  area3: AreaP (51,1,75,100)
  area4: AreaP (76,1,100,100)
  
robots
  robot robot1
  comenzar
    recorrerAreasImpares
  fin
  
  robot robot2
  comenzar
    recorrerAreasPares
  fin
  
variables

  r1: robot1
  r2: robot2
  
comenzar

  AsignarArea(r1, area1)
  AsignarArea(r2, area2)
  AsignarArea(r1, area3)
  AsignarArea(r2, area4)
  
  Iniciar(r1, 1,1) {si vos inicias, es necesario el pos?, se inicia una sola vez un robot?}
  Iniciar(r2, 26,1)

fin
