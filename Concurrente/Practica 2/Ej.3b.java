{Modifique el programa anterior para que cada equipo repita el recorrido con las siguientes 20 esquinas de sus correspondientes calles.}

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
    papeles: numero
    empeza, salto: boolean
  comenzar
    papeles:= 0
    empeza:= F
    repetir 9
      juntarPapeles (papeles)
      mover
      
    juntarPapeles (papeles)
    empeza:= V
    EnviarMensaje (empeza, r2) {preguntar si es necesario enviar que robot envia el mensaje}
    EnviarMensaje (papeles, r2)
    RecibirMensaje(salto, r2)
    si (salto = V)
      empeza:= F
      papeles:= 0
      Pos(30,1)
      repetir 9
        juntarPapeles (papeles)
        mover
      juntarPapeles (papeles)
      empeza:= V
      EnviarMensaje (empeza, r2)
      EnviarMensaje (papeles, r2)
  fin
  
  proceso realizarTareaA2 (ES papelesTotal: numero)
  variables
    papelesNuevo, papeles: numero
    empiezo, salta: boolean
  comenzar
    RecibirMensaje (empiezo, r1)
    si (empiezo = V)
      RecibirMensaje (papeles, r1)
      papelesNuevo:= 0
      repetir 9
        juntarPapeles (papelesNuevo)
        mover
      juntarPapeles (papelesNuevo)
      papelesTotal:= papeles + papelesNuevo
    salta:= V
    EnviarMensaje (salta, r1)
    RecibirMensaje (empiezo,r1)
    si (empiezo = V)
      RecibirMensaje (papeles,r1)
      papelesNuevo:= 0
      repetir 9
        juntarPapeles (papelesNuevo)
        mover
      juntarPapeles (papelesNuevo)
      papelesTotal:= papeles + papelesNuevo
    
  fin
  
  proceso realizarTareaB1
  variables
    flores: numero
    empeza: boolean 
  comenzar
    flores:= 0
    empeza:= F
    repetir 9
      juntarFlores (flores)
      mover
      
    juntarFlores (flores)
    empeza:= V
    EnviarMensaje (empeza, r4)
    EnviarMensaje (flores, r4)
  fin
  
  proceso realizarTareaB2 (ES floresTotal: numero)
  variables
    floresNuevo, flores: numero
    empiezo: boolean
  comenzar 
    RecibirMensaje (empiezo, r3)
    si (empiezo = V)
      RecibirMensaje (flores, r3)
      floresNuevo:= 0
      repetir 9
        juntarFlores (floresNuevo)
        mover
      juntarFlores (floresNuevo)
      floresTotal:= flores + floresNuevo
  fin
  
areas

  areaA: AreaPC (1,1, 40,1)
  areaB: AreaPC (1,5, 20,5)

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
