{Realice un programa con 2 equipos:}
{- El equipo A, compuesto por los robots A1 y A2, debe juntar papeles de las primeras 20 esquinas de la calle 1}
{- El equipo B, compuesto por los robots B1 y B2, debe juntar flores de las primeras 20 esquinas de la calle 5}
{Los robots A1 y B1 deberán realizar las 10 primeras esquinas de su recorrido, y al finalizar avisarán a los robots A2 y B2 respectivamente para que continúen con las siguientes 10 esquinas. El segundo robot de cada equipo debe informar la cantidad de elementos recogidos en las 20 esquinas.}
{Inicialice los 4 robots en las esquinas que considere más apropiadas según el trayecto que le corresponde realizar a cada uno.}

programa p2ej3
procesos
  proceso juntarFlores (ES f: numero)
  comenzar
    mientras (HayFlorEnLaEsquina)
      tomarFlor
      f:= f + 1
  fin
  
  proceso juntarPapeles (ES p: numero)
  comenzar
    mientras (HayPapelEnLaEsquina)
      tomarPapel
      p:= p + 1
  fin
  
  proceso realizarTareaA1 
  variables
    papeles, papelesTotal: numero
  comenzar
    papeles:= 0
    papelesTotal:= 0
    repetir 9
      juntarPapeles (papeles)
      mover
      
    juntarPapeles (papeles)
    EnviarMensaje (papeles, r2)
    RecibirMensaje (papelesTotal, r2)
    Pos (21,1)
    papeles:= 0
    repetir 9
      juntarPapeles (papeles)
      mover
    juntarPapeles (papeles)
    papelesTotal:= papelesTotal + papeles
    EnviarMensaje (papelesTotal, r2)
  fin
  

  proceso realizarTareaA2 (ES papelesTotal: numero)
  variables
    papelesNuevo, papelesTotal: numero
  comenzar
    papelesTotal:= 0
    RecibirMensaje (papelesTotal, r1)
    papelesNuevo:= 0
    repetir 9
      juntarPapeles (papelesNuevo)
      mover
    juntarPapeles (papelesNuevo)
    papelesTotal:= papelesTotal + papelesNuevo
    EnviarMensaje (papelesTotal, r1)
    RecibirMensaje (papelesTotal, r1)
    Pos (31,1)
    papelesNuevo:= 0
    repetir 9
      juntarPapeles (papelesNuevo)
      mover
    juntarPapeles (papelesNuevo)
    papelesTotal:= papelesTotal + papelesNuevo
  fin

  proceso realizarTareaB1
  variables
    flores, floresTotal: numero
  comenzar
    flores:= 0
    floresTotal:= 0
    repetir 9
      juntarFlores (flores)
      mover
      
    juntarFlores (flores)
    EnviarMensaje (flores, r4)
    RecibirMensaje (floresTotal, r4)
    Pos (21,5)
    flores:= 0
    repetir 9
      juntarFlores (flores)
      mover
    juntarFlores (flores)
    floresTotal:= floresTotal + flores
    EnviarMensaje (floresTotal, r4)
    
  fin
  
  proceso realizarTareaB2 (ES floresTotal: numero)
  variables
    floresNuevo, floresTotal: numero
  comenzar 
    floresTotal:= 0
    RecibirMensaje (floresTotal, r3)
    floresNuevo:= 0
    repetir 9
      juntarFlores (floresNuevo)
      mover
    juntarFlores (floresNuevo)
    floresTotal:= floresTotal + floresNuevo
    EnviarMensaje (floresTotal, r3)
    RecibirMensaje (floresTotal, r3)
    Pos (31,5)
    floresNuevo:= 0
    repetir 9
      juntarFlores (floresNuevo)
      mover
    juntarFlores (floresNuevo)
    floresTotal:= floresTotal + floresNuevo
  fin
  
areas

  areaA: AreaPC (1,1, 40,1)
  areaB: AreaPC (1,5, 40,5)

robots

  robot robot1
  comenzar
    derecha
    realizarTareaA1 
  fin
  
  robot robot2
  variables
    papelesTotal: numero
  comenzar
    papelesTotal:= 0
    derecha
    realizarTareaA2 (papelesTotal)
    Informar ("La cantidad total de papeles del equipo A es", papelesTotal)
  fin
  
  robot robot3
  comenzar
    derecha
    realizarTareaB1 
  fin
  
  robot robot4
  variables
    floresTotal: numero
  comenzar
    floresTotal:= 0
    derecha
    realizarTareaB2 (floresTotal)
    Informar ("La cantidad total de flores del equipo B es", floresTotal)
  fin
  
  
variables

  r1: robot1
  r2: robot2
  r3: robot3
  r4: robot4
  
comenzar
  AsignarArea(r1, areaA)
  AsignarArea(r2, areaA)
  AsignarArea(r3, areaB)
  AsignarArea(r4, areaB)
  Iniciar (r1, 1,1)
  Iniciar (r2, 11,1)
  Iniciar (r3, 1,5)
  Iniciar (r4, 11, 5)
fin
