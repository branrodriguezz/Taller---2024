{Realice un programa en el que un robot fiscalizador controla el acceso de 4 robots recolectores al cuadrante encerrado entre las esquinas (25,25) y (75,75) . Para ello, el robot fiscalizador avisa a un robot recolector aleatorio que puede ingresar al área. El robot que recibe la autorización de acceso calcula una esquina aleatoria dentro del área, limpia dicha esquina de flores y papeles, regresa a su esquina y avisa al robot fiscalizador que ya finalizó.}
{Se realizarán en total 10 accesos al cuadrante entre los 4 robots recolectores. Al finalizar, el robot fiscalizador deberá indicar al robot ganador que se posicione en la esquina (50,50).{
{El robot fiscalizador inicia en la esquina (1,1) y los robots recolectores inician en las esquinas (25,1) (30,1) (35,1) y (40,1) respectivamente.}

programa p1ej4
procesos
  proceso limpiarEsquina (ES cant: numero)
  variables
    f,p: numero
    av,ca: numero
  comenzar
    f:= 0
    p:= 0
    Random (av, 25, 75)
    Random (ca, 25, 75)
    Pos (av, ca)
    mientras (HayFlorEnLaEsquina)
      tomarFlor
      f:= f + 1
    mientras (HayPapelEnLaEsquina)
      tomarPapel
      p:= p + 1
      
    cant:= f + p
  fin
  
  proceso identificacion 
  comenzar
    EnviarMensaje (1, r1)
    EnviarMensaje (2, r2)
    EnviarMensaje (3, r3)
    EnviarMensaje (4, r4)
  fin
  
  proceso accesoAleatorio
  variables
    id: numero
    aux: boolean
  comenzar
    Random(id,1,4)
    si (id = 1)
      EnviarMensaje (V, r1) {le envio que todavia puede seguir accediendo}
      RecibirMensaje (aux, r1) {recibo el valor en el que quedo aux luego de la instruccion}
    sino
      si (id = 2)
        EnviarMensaje (V, r2)
        RecibirMensaje (aux, r2)
      sino
        si (id = 3)
          EnviarMensaje (V, r3)
          RecibirMensaje (aux, r3)
        sino 
          EnviarMensaje (V, r4)
          RecibirMensaje (aux, r4)
  fin
  
  proceso noPermitirMasAccesos 
  comenzar
  
    EnviarMensaje (F, r1)
    EnviarMensaje (F, r2)
    EnviarMensaje (F, r3)
    EnviarMensaje (F, r4)
    
  fin
  
  proceso calculoMaximo (ES max: numero; ES maxRobot: numero)
  variables
    id: numero
    cantT: numero
  comenzar
    max:= -1
    repetir 4
      RecibirMensaje (id, *)
      si (id = 1)
        RecibirMensaje (cantT, r1)
      sino
        si (id = 2)
          RecibirMensaje (cantT, r2)
        sino
          si (id = 3)
            RecibirMensaje (cantT, r3)
          sino
            RecibirMensaje (cantT, r4)
       
      si (cantT > max)
        max:= cantT
        maxRobot:= id
    
  fin
  
  proceso elijoGanador (E maxR: numero)
  variables
    ganaste: boolean
  comenzar
    ganaste:= V
    si (maxR = 1)
      EnviarMensaje (V, r1) {le aviso que gane al robot ganador unicamente poniendolo en true y el resto false}
      EnviarMensaje (F, r2)
      EnviarMensaje (F, r3)
      EnviarMensaje (F, r4)
    sino
      si (maxR = 2)
        EnviarMensaje (F, r1)
        EnviarMensaje (V, r2)
        EnviarMensaje (F, r3)
        EnviarMensaje (F, r4)
      sino
        si (maxR = 3)
          EnviarMensaje (F, r1)
          EnviarMensaje (F, r2)
          EnviarMensaje (V, r3)
          EnviarMensaje (F, r4)
        sino
          EnviarMensaje (F, r1)
          EnviarMensaje (F, r2)
          EnviarMensaje (F, r3)
          EnviarMensaje (V, r4)
          
  fin
  
  proceso tareaRecolector
  variables
    sigo: boolean
    id, cantTotal: numero
    ca,av: numero
  comenzar
    cantTotal:= 0
    ca:= PosCa
    av:= PosAv
    RecibirMensaje (id, rf) {recibo el numero del robot}
    RecibirMensaje (sigo, rf) {recibo la variable booleana que me habilita a limpiar la esquina hasta que sea falsa}
    mientras (sigo)
      limpiarEsquina (cantTotal)
      Pos (av, ca)
      EnviarMensaje (sigo, rf) {pregunto si sigo, sino llegue a 10}
      RecibirMensaje (sigo, rf) {me responden verdadero o falso}
      
    EnviarMensaje (id, rf) {mandan todos sus cantidades y su id}
    EnviarMensaje (cantTotal, rf)
    
    RecibirMensaje (sigo, rf) {recibo mensaje de los accesos no mas permitidos que estan todos en falsos ya}
    si (sigo = V)
      Pos (50,50) { a esta altura ya se quien es el ganador}
  fin
  
areas

  areaFiscalizador: AreaP (1,1,1,1)
  areaRecolectores: AreaPC (25,1,40,1)
  areaCuadrante: AreaPC (25,25,75,75)
  
robots
  robot recolector
  comenzar
    tareaRecolector
  fin
  
  robot fiscalizador
  variables
    max, maxRobot: numero
  comenzar
    identificacion
    repetir 10
      accesoAleatorio 
    noPermitirMasAccesos
    calculoMaximo (max, maxRobot)
    elijoGanador (maxRobot)
  fin
  
variables

  r1, r2, r3, r4: recolector
  rf: fiscalizador
  
comenzar
  AsignarArea (r1, areaRecolectores)
  AsignarArea (r1, areaCuadrante)
  AsignarArea (r2, areaRecolectores)
  AsignarArea (r2, areaCuadrante)
  AsignarArea (r3, areaRecolectores)
  AsignarArea (r3, areaCuadrante)
  AsignarArea (r4, areaRecolectores)
  AsignarArea (r4, areaCuadrante)
  AsignarArea (rf, areaFiscalizador)
  
  Iniciar (r1, 25, 1)
  Iniciar (r2, 30, 1)
  Iniciar (r3, 35, 1)
  Iniciar (r4, 40, 1)
  Iniciar (rf, 1, 1)
fin
