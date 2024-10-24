{a) Modifique el programa anterior para que el mismo robot realice lo mismo en las avenidas 1, 3 y 5.}
programa p1ej1a
procesos
  proceso juntarFlores(ES flores: numero)
  comenzar
    flores:= 0
    mientras (HayFlorEnLaEsquina)
      tomarFlor 
      flores:= flores + 1
  fin
  
  proceso recorrerAvenida(E numAv: numero; ES cantTotalFlores: numero; ES esquinasSinFlores: numero)
  variables
    flores : numero
  comenzar
    Pos(numAv, 1)
    repetir 99
      juntarFlores (flores)
      si (flores = 0) 
        esquinasSinFlores:= esquinasSinFlores + 1
      cantTotalFlores:= cantTotalFlores + flores
      mover
      
    juntarFlores (flores)
    si (flores = 0) 
      esquinasSinFlores:= esquinasSinFlores + 1
    cantTotalFlores:= cantTotalFlores + flores
    
    repetir cantTotalFlores  {preguntar}
      depositarFlor
  fin 
  
areas
  ciudad1: AreaP (1,1,1,100)
  ciudad2: AreaP (3,1,3,100)
  ciudad3: AreaP (5,1,5,100)
robots
  robot robot1
  variables
    cantTotalFlores : numero
    esquinasSinFlores : numero
    numAv: numero
  comenzar
    numAv := 1
    repetir 3
      esquinasSinFlores:= 0
      cantTotalFlores:= 0
      recorrerAvenida(numAv, cantTotalFlores, esquinasSinFlores)
      numAv:= numAv + 2
      Informar (cantTotalFlores)
      Informar (esquinasSinFlores)
  fin
  
variables
  r1: robot1
comenzar
  AsignarArea (r1, ciudad1)
  AsignarArea (r1, ciudad2)
  AsignarArea (r1, ciudad3)
  Iniciar (r1, 1, 1)
fin
