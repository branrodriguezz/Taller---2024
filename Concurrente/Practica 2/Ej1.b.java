{Dos robots compiten para ver cuál junta más flores. El primer robot recoge todas las flores de la avenida 1 entre las calles 1 y 10. El segundo robot recoge todas las flores de la avenida 2, entre las calles 11 y 20.}
{Al finalizar el recorrido, el robot que recogió mayor cantidad de flores debe informar la diferencia de flores que obtuvo respecto al robot perdedor (el que obtuvo menos flores). Los robots inician en las esquinas (1, 1) y (2, 11) respectivamente.}
{b. Modifique el ejercicio anterior, considerando que ahora habrá un robot fiscalizador, que será responsable de informar la diferencia de flores que obtuvo el ganador con respecto al perdedor. El robot fiscalizador se ubica en la esquina (2,1)}

programa p2ej1
procesos
  proceso juntarFlores(ES f: numero)
  comenzar
    mientras (HayFlorEnLaEsquina)
      tomarFlor
      f:= f + 1
  fin
areas

  area1: AreaP (1,1,1,10)
  area2: AreaP (2,11,2,20)
  area3: AreaP (2,1,2,1)
  
robots
  robot juntador
  variables
    avenida, calleini, callefin, calles, soy, flores: numero
    
  comenzar
    flores:= 0
    calles:= 0
    RecibirMensaje (soy, robot3)
    RecibirMensaje (avenida, robot3)
    RecibirMensaje (calleini, robot3)
    RecibirMensaje (callefin, robot3)
 
    calles:= (callefin - calleini)
    repetir calles
      juntarFlores (flores)
      mover
    juntarFlores (flores)
    
    EnviarMensaje (soy, robot3)
    EnviarMensaje (flores, robot3)
  fin
  
  robot jefe
  variables
    max, maxRobot, min, minRobot, diferencia, quien, flores: numero
  comenzar
    diferencia:= 0
    min:= 999
    max:= -1
    EnviarMensaje (1, robot1)
    EnviarMensaje (1, robot1)
    EnviarMensaje (1, robot1)
    EnviarMensaje (10, robot1)
    
    EnviarMensaje (2, robot2)
    EnviarMensaje (2, robot2)
    EnviarMensaje (11, robot2)
    EnviarMensaje (20, robot2)
    
    repetir 2 
      RecibirMensaje (quien, *)
      si (quien = 1)
        RecibirMensaje (flores, robot1)
      sino 
        RecibirMensaje (flores, robot2)
        
      si (flores >= max)
        max:= flores
        maxRobot:= quien
      
      si (flores <= min)
        min:= flores
        minRobot:= quien
    
    diferencia:= max - min
    
    Informar("La diferencia del ganador", maxRobot)
    Informar ("Fue de", diferencia)
    
  fin
  
variables

  robot1: juntador
  robot2: juntador
  robot3: jefe
  
comenzar
  AsignarArea(robot1, area1)
  AsignarArea(robot2, area2)
  AsignarArea (robot3, area3)
  Iniciar(robot1, 1,1 )
  Iniciar(robot2, 2,11 )
  Iniciar(robot3, 2, 1 )
  
fin
