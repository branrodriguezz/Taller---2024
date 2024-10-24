{3) Realice un programa en el que 3 robots realicen escaleras de 4 escalones. El tamaño de cada escalón se incrementa en un 1 respecto al escalón anterior. El primer escalón será de 1x1, el segundo de 2x2, y así sucesivamente, como se muestra a continuación: Al finalizar el recorrido, cada robot debe informar la cantidad de escalones en los que la cantidad de papeles superó en 1 a la cantidad de flores. Las esquinas deben quedar sin modificar.}

programa p1ej3
procesos
  proceso izquierda
  comenzar
    repetir 3
      derecha
  fin
  
  proceso escalon (E alto: numero; E largo: numero; ES flores: numero; ES papeles: numero)
  comenzar
    flores:= 0
    papeles:= 0
    
    repetir alto
      mientras (HayFlorEnLaEsquina) 
        tomarFlor
        flores:= flores + 1
      mientras (HayFlorEnLaBolsa) {repetir flores depositar no me funciona, xq?}
        depositarFlor
        
      mientras (HayPapelEnLaEsquina)
        tomarPapel
        papeles:= papeles + 1
      mientras (HayPapelEnLaBolsa)
        depositarPapel
      mover
      
    derecha
    repetir largo
      mientras (HayFlorEnLaEsquina)
        tomarFlor
        flores:= flores + 1
      mientras (HayFlorEnLaBolsa)
        depositarFlor
        
      mientras (HayPapelEnLaEsquina)
        tomarPapel
        papeles:= papeles + 1
      mientras (HayPapelEnLaBolsa)
        depositarPapel
        
      mover
    izquierda
      
  fin
  
  proceso escalera (ES cantEscalones: numero)
  variables
    flores: numero
    papeles: numero
    alto: numero
    largo: numero
  comenzar
    alto:= 1
    largo:= 1
    repetir 4
      escalon(alto, largo, flores, papeles)
      alto:= alto + 1
      largo:= largo + 1
      si (papeles - flores = 1)
        cantEscalones:= cantEscalones + 1
  fin
  
areas

  ciudad: AreaC (12,6, 32, 24) 
  
robots
  
  robot tipo1
  variables
    cantEscalones: numero {papeles > flores solo x 1}
  comenzar
    cantEscalones:= 0
    escalera (cantEscalones)
    Informar (cantEscalones)
    
  fin
  
variables

  r1: tipo1
  r2: tipo1
  r3: tipo1
  
comenzar

  AsignarArea (r1, ciudad)
  AsignarArea (r2, ciudad)
  AsignarArea (r3, ciudad)
  Iniciar (r1, 12, 14)
  Iniciar (r2, 17, 10)
  Iniciar (r3, 22, 6)

fin
