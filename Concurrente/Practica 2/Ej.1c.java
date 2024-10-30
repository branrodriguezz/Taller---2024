{c. Modifique el ejercicio anterior para que ahora participen 6 robots
{○ Robot 1: Avenida 1, entre las calles 1 y 10}
{○ Robot 2: Avenida 2, entre las calles 11 y 20}
{○ Robot 3: Avenida 3, entre las calles 21 y 30}
{○ Robot 4: Avenida 4, entre las calles 31 y 40}
{○ Robot 5: Avenida 5, entre las calles 41 y 50}
{○ Robot 6: Avenida 6, entre las calles 51 y 60}
{○ Fiscalizador: Avenida 2, calle 1}

programa p2ej1c
procesos
  proceso enviarMensajes (ES max: numero; ES maxRobot: numero)
  variables
    quien, flores: numero
  comenzar
  
    EnviarMensaje (1, robot1)
    EnviarMensaje (2, robot2)
    EnviarMensaje (3, robot3)
    EnviarMensaje (4, robot4)
    EnviarMensaje (5, robot5)
    EnviarMensaje (6, robot6)
    
    repetir 6
      RecibirMensaje (quien, *)
      si (quien = 1)
        RecibirMensaje (flores, robot1)
      sino
        si (quien = 2)
          RecibirMensaje (flores, robot2)
        sino
          si (quien = 3)
            RecibirMensaje (flores, robot3)
          sino
            si (quien = 4)
              RecibirMensaje (flores, robot4)
            sino
              si (quien = 5)
                RecibirMensaje (flores, robot5)
              sino 
                RecibirMensaje (flores, robot6)
                
      si (flores >= max)
        max:= flores
        maxRobot:= quien
      
  fin
  
  proceso juntarFlores (ES f: numero)
  comenzar
    mientras (HayFlorEnLaEsquina)
      tomarFlor
      f:= f + 1
  fin
  
  proceso recorrerAvenida (ES flores: numero)
  comenzar
  
    flores:= 0
    repetir 9
      juntarFlores (flores)
      mover
    juntarFlores (flores)
    
  fin
  
  
  proceso tareaJuntador 
  variables
    soy, flores: numero
  comenzar
    
    RecibirMensaje (soy, robot7)
    recorrerAvenida (flores)
    EnviarMensaje (soy, robot7)
    EnviarMensaje (flores, robot7)
    
  fin
  
areas

  areaCompartida: AreaC (1,1,6,60)
  
robots
  robot juntador
  comenzar
  
    tareaJuntador
    
  fin
  
  robot jefe
  variables
    max, robotMax: numero
  comenzar
  
    max:= -1
    robotMax:= 0
    enviarMensajes (max, robotMax)
    Informar ("El ganador fue ", robotMax)
    Informar ("La cantidad de flores que junto fue ", max)

  fin
  
variables

  robot1, robot2, robot3, robot4, robot5, robot6: juntador
  robot7: jefe
  
comenzar

  AsignarArea (robot1, areaCompartida)
  AsignarArea (robot2, areaCompartida)
  AsignarArea (robot3, areaCompartida)
  AsignarArea (robot4, areaCompartida)
  AsignarArea (robot5, areaCompartida)
  AsignarArea (robot6, areaCompartida)
  AsignarArea (robot7, areaCompartida)
  Iniciar (robot1, 1, 1)
  Iniciar (robot2, 2, 11)
  Iniciar (robot3, 3, 21)
  Iniciar (robot4, 4, 31)
  Iniciar (robot5, 5, 41)
  Iniciar (robot6, 6, 51)
  Iniciar (robot7, 2, 1)
 
fin
