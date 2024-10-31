{Dos robots compiten para ver cuál junta más flores. El primer robot recoge todas las flores de la avenida 1 entre las calles 1 y 10.}{ El segundo robot recoge todas las flores de la avenida 2, entre las calles 11 y 20.}
{Al finalizar el recorrido, el robot que recogió mayor cantidad de flores debe informar la diferencia de flores que obtuvo respecto al robot perdedor (el que obtuvo menos flores). Los robots inician en las esquinas (1, 1) y (2, 11) respectivamente.}

programa p2ej1c
procesos
  proceso juntarFlores (ES f: numero)
  comenzar
    mientras (HayFlorEnLaEsquina)
      tomarFlor
      f:= f + 1
  fin
 
  proceso realizarTareaFlores (ES flores: numero)
  comenzar
    flores:= 0
    repetir 9
      juntarFlores (flores)
      mover
    juntarFlores (flores)
  fin
  
areas

  area1: AreaP(1,1,1,10)
  area2: AreaP(2,11,2,20)
  
robots

  robot robot1
  variables
  
    flores, floresR2, floresT: numero
    gane: boolean
    
  comenzar
  
    realizarTareaFlores (flores)
    EnviarMensaje (flores, robot2)
    RecibirMensaje (gane, robot2)
    si (gane = V)
      RecibirMensaje (floresR2, robot2)
      floresT:= (flores - floresR2)
      Informar ("Gano R1 con diferencia de", floresT)
  fin
  
  robot robot2
  variables
    flores, floresR1, floresT: numero
    ganaste: boolean
  comenzar
  
    realizarTareaFlores (flores)
    RecibirMensaje (floresR1, robot1)
    si (floresR1 > flores)
      EnviarMensaje (ganaste, robot1)
      EnviarMensaje (flores, robot2)
    sino
      floresT:= (flores - floresR1)
      Informar ("Gano R2 con diferencia de", floresT)
  fin
  
variables

  ro1: robot1
  ro2: robot2
  
comenzar

  AsignarArea (ro1, area1)
  AsignarArea (ro2, area2)
  Iniciar (ro1, 1, 1)
  Iniciar (ro2, 2, 11)

fin
