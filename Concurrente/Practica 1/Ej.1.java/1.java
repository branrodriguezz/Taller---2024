{1) Realice un programa para que un robot junte todas las flores de la avenida 1 y las deposite al final de dicha avenida. Al finalizar, debe informar la cantidad de flores depositadas y la cantidad de esquinas sin flores que encontró durante el recorrido.}

programa p1ej1
procesos
  proceso juntarFlores(ES flores: numero)
  comenzar
    flores:= 0
    mientras (HayFlorEnLaEsquina)
      tomarFlor 
      flores:= flores + 1
  fin
  proceso recorrerAvenida(E numAv: numero, ES cantTotalFlores, ES esquinasSinFlores)
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
    {}
    juntarFlores (flores)
    si (flores = 0) 
      esquinasSinFlores:= esquinasSinFlores + 1
    cantTotalFlores:= cantTotalFlores + flores
    {}
    repetir cantTotalFlores 
      depositarFlor
    
  fin
areas
  ciudad: AreaP (1,1,1,100) {esta bien si pongo un area privada y de ese tamaño?}
robots
  robot robot1
  variables
    cantTotalFlores: numero
    esquinasSinFlores : numero
  comenzar
    esquinasSinFlores:= 0
    cantTotalFlores:= 0
    recorrerAvenida(1, cantTotalFlores, esquinasSinFlores)
    Informar (cantTotalFlores)
    Informar (esquinasSinFlores) 
  fin
variables
  R_info: robot1
comenzar
  AsignarArea(R_info, ciudad)
  Iniciar(R_info, 1,1)
fin
