{Realice un programa en el que cuatro robots realizan las siguientes actividades:}
{● El robot 1 debe limpiar de flores las primeras 15 esquinas de las calles 75 y 80. Al finalizar cada calle, debe depositar todas las flores en la última esquina.}
{● El robot 2 debe limpiar de papeles las últimas 20 esquinas de las avenidas 75 y 80. Al finalizar cada avenida debe depositar todos los papeles en la primera esquina.}
{● El robot 3 debe limpiar de flores las últimas 30 esquinas de las calles 10 y 15. Al finalizar cada calle, debe depositar todas las flores en la última esquina.}
{● El robot 4 debe limpiar de papeles las primeras 10 esquinas de las avenidas 10 y 15. Al finalizar cada avenida debe depositar todos los papeles en la primera esquina.}

programa p1ej5
procesos
  
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
      papeles:= papeles + 1 {contadores, necesarios?}
  fin
  
  proceso recorridoRobot1 
  variables
    flores: numero
  comenzar
    flores:= 0
    repetir 15
      juntarFlores (flores)
      mover
    repetir flores {preguntar por el mientras hay flor en la bolsa y esto}
      depositarFlor 
  fin
  
  proceso recorridoRobot2
  variables
    papeles: numero
  comenzar
    papeles:= 0
    repetir 20
      juntarPapeles (papeles)
      mover
    repetir papeles
      depositarPapel 
  fin
  
  proceso recorridoRobot3
  variables
    flores: numero
  comenzar
    flores:= 0
    repetir 30
      juntarFlores (flores)
      mover
    repetir flores
      depositarFlor
  fin
  
  proceso recorridoRobot4
  variables
    papeles: numero
  comenzar
    papeles:= 0
    repetir 10
      juntarPapeles (papeles)
      mover
    repetir papeles
      depositarPapel
  fin
  
  
areas

  area1: AreaP (1, 80, 16, 80)
  area12: AreaP (1, 75, 16, 75)
  
  area2: AreaP (75, 80, 75, 100)
  area22: AreaP (80, 80, 80, 100)
  
  area3: AreaP (70, 15, 100, 15)
  area32: AreaP (70, 10, 100, 10)
  
  area4: AreaP (10, 1, 10, 11)
  area42: AreaP (15, 1, 15, 11)
  
robots

  robot robot1
  comenzar
    derecha
    recorridoRobot1
    Pos (1, 75)
    recorridoRobot1
  fin
  
  robot robot2
  comenzar
    recorridoRobot2
    Pos (80,80)
    recorridoRobot2
  fin
  
  robot robot3
  comenzar
    derecha
    recorridoRobot3
    Pos (70,10)
    recorridoRobot3
  fin
  
  robot robot4
  comenzar  
    recorridoRobot4
    Pos (15,1)
    recorridoRobot4
  fin
  
variables
  
  r1: robot1
  r2: robot2
  r3: robot3
  r4: robot4
  
comenzar
  AsignarArea (r1, area1) {preguntar areas}
  AsignarArea (r1, area12)
  
  AsignarArea(r2, area2)
  AsignarArea(r2, area22)
  
  AsignarArea(r3, area3)
  AsignarArea(r3, area32)
  
  AsignarArea(r4, area4)
  AsignarArea(r4, area42)
  
  Iniciar (r1, 1, 80) {si inicio hace falta q posicione el robot en alguna pos inicial?}
  Iniciar (r2, 75, 80)
  Iniciar (r3, 70, 15)
  Iniciar (r4, 10, 1)
  
fin

