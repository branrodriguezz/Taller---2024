{b) Modifique el programa anterior para que el trabajo sea realizado por 3 robots: uno realiza la avenida 1, otro realiza la avenida 3 y otro la avenida 5. Cada robot debe iniciar en las esquina (1,1), (3,1) y (5,1) respectivamente.}

programa p1ej1b
procesos
  proceso juntarFlores (ES flores: numero)
  comenzar
    flores:= 0
    mientras (HayFlorEnLaEsquina)
      tomarFlor
      flores:= flores + 1
  fin
  
  proceso recorrerAvenidas (ES cantTotalFlores: numero; ES esquinasSinFlores: numero)
  variables
    flores : numero  
  comenzar
    Informar (PosAv, PosCa)
    repetir 99
      juntarFlores (flores)
      cantTotalFlores:= cantTotalFlores + flores
      si (flores = 0)
        esquinasSinFlores:= esquinasSinFlores + 1
      mover
      
    juntarFlores (flores)
    cantTotalFlores := cantTotalFlores + flores
    si (flores = 0)
      esquinasSinFlores:= esquinasSinFlores + 1
      
    repetir cantTotalFlores
      depositarFlor  
  fin
  
areas

  ciudad: AreaC (1,1,5,100)
  
robots
  robot tipo1
  
  variables
  
    cantTotalFlores: numero
    esquinasSinFlores: numero
    
  comenzar
    cantTotalFlores:= 0
    esquinasSinFlores:= 0
    recorrerAvenidas (cantTotalFlores, esquinasSinFlores)
    Informar (cantTotalFlores)
    Informar (esquinasSinFlores)
    
  fin
 
variables

  r1: tipo1
  r2: tipo1
  r3: tipo1
  
comenzar

  AsignarArea (r1,ciudad)
  AsignarArea (r2,ciudad)
  AsignarArea (r3,ciudad)
  Iniciar(r1, 1, 1)
  Iniciar(r2, 3, 1)
  Iniciar(r3, 5, 1)
  
fin
