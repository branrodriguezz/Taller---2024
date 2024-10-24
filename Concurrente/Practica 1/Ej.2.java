{2) Realice un programa en el que 4 robots limpien de papeles el perímetro de un cuadrado de lado 20 en sentido horario, como se muestra en la figura: El vértice inferior izquierdo del cuadrado se ubica en la esquina (10,10). Al finalizar, cada robot debe informar la cantidad de papeles juntados en su lado. Al realizar este programa, analizar: a) ¿Cómo deben declararse la o las áreas? b) ¿Existe riesgo de colisión?}
programa p1ej2
procesos
  proceso juntarPapeles(ES pap:numero)
  comenzar
    mientras(HayPapelEnLaEsquina)
      tomarPapel
      pap:= pap + 1
  fin
  proceso izquierda
  comenzar
    repetir 3
      derecha
  fin
  
  proceso hacerTarea
  variables
    papeles: numero
  comenzar
    papeles:= 0
    repetir 19
      juntarPapeles(papeles)
      mover
    Informar (papeles)
  fin
areas
  ciudad1: AreaP (10,10, 10, 29)
  ciudad2: AreaP (10,30, 29, 30)
  ciudad3: AreaP (30,11, 30, 30)
  ciudad4: AreaP (11,10, 30, 10)
  
robots
  robot tipo
  comenzar
    hacerTarea
  fin
  
  robot tipo2
  comenzar
    derecha
    hacerTarea
  fin
  
  robot tipo3
  comenzar
    repetir 2 {por que?}
      derecha
    hacerTarea
  fin
  robot tipo4
  comenzar
    izquierda
    hacerTarea
  fin
  
variables

  r1: tipo
  r2: tipo2
  r3: tipo3
  r4: tipo4
  
comenzar

  AsignarArea (r1, ciudad1)
  AsignarArea (r2, ciudad2)
  AsignarArea (r3, ciudad3)
  AsignarArea (r4, ciudad4)
  Iniciar(r1, 10,10)                                                                                  
  Iniciar(r2, 10, 30)
  Iniciar (r3, 30, 30)
  Iniciar (r4, 30, 10)
                                                                                         
fin

