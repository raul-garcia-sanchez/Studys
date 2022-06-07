import random
def menus(tupla, titol="", capselera=""):
    while True:
        try:
            print('*' * 100)
            print(titol.center(100))
            print('*' * 100)
            print(tupla)
            opt = input('Option: ')
            if not opt.isdigit():
                raise TypeError
            elif int(opt) < 1 or int(opt) > 6:
                raise ValueError
            else:
                break
        except TypeError:
            print('La opcion escogida no es un digito')
        except ValueError:
            print('La opcion no esta entre el 1 y el 6')
    return int(opt)

def jugar():
    f = open("Combi.txt")
    id = 1
    dictCombis = {}
    listaLaberinto = []
    for i in f:
        if i != "\n":
            listaLaberinto.append(i[0:-2].split("#"))
            dictCombis[id] = listaLaberinto
        if i == "\n":
            listaLaberinto = []
            id += 1
    f.close()
    while True:
        laberintoJugar = int(input("A que laberinto desea jugar? "))
        if laberintoJugar <= len(dictCombis) and laberintoJugar >= 1:
            break
        else:
            print("Laberinto escogido no existe")
    laberintoAjugar = dictCombis[laberintoJugar]
    puntsJugador = 100
    while True:
        filaAleatoria = random.randint(0, len(laberintoAjugar) - 1)
        columnaAleatoria = random.randint(0, len(laberintoAjugar[0]) - 1)
        casilla = laberintoAjugar[filaAleatoria][columnaAleatoria]
        if casilla == " ":
            puntsJugador += 5
            laberintoAjugar[filaAleatoria][columnaAleatoria] = "V"
        elif casilla == "X":
            puntsJugador -= 2
        elif casilla == "V":
            puntsJugador -= 1
        else:
            break
    return laberintoJugar,puntsJugador

nombreJugador = input("Como se llama usted? ")
while True:
    opt = menus("1.Crear laberint.\n2.Mostrar laberints.\n3.Jugar laberint.\n4.Guardar dades partida.\n5.Jugador amb més punts al laberint 1.\n6.Salir")
    letrasDisponibles = ['X', '.', ' ']
    lista1 = []
    if opt == 1:
        filas = int(input("De cuantas filas quiere la combinación:"))
        columnas = int(input("De cuantas columnas quiere la combinación:"))
        for fila in range(1, filas + 1):
            lista2 = []
            for columna in range(1, columnas + 1):
                while True:
                    try:
                        print(
                            "Numero que quieres introducir en la fila " + str(fila) + " columna " + str(columna) + ":")
                        letra = input().upper()
                        if letra not in letrasDisponibles:
                            raise ValueError
                        lista2.append(letra)
                        break
                    except ValueError:
                        print("No es una letra valida")
            lista1.append(lista2)
        f = open("Combi.txt", "a")
        for i in range(len(lista1)):
            f.write(str(lista1[i]).replace("[", "").replace("'", "").replace(", ", "#").replace("]", "") + "#" + "\n")
        f.write("\n")
        f.close()

    elif opt == 2:
        f = open("Combi.txt")
        print("")
        for i in f:
            print(i.replace("\n",""))
        juego= jugar()
        laberintoJugado = juego[0]
        puntosJugador = juego[1]

    elif opt == 3:
        juego = jugar()
        laberintoJugado = juego[0]
        puntosJugador = juego[1]

    elif opt == 4:
        f = open("ResultadosPartida.txt")
        idPartida = 1
        for i in f:
            idPartida +=1
        f.close()
        f = open("ResultadosPartida.txt","a")
        f.write(str(idPartida)+"#"+nombreJugador+"#"+str(laberintoJugado)+"#"+str(puntosJugador)+"#"+"\n")
        f.close()

    elif opt == 5:
        f = open("ResultadosPartida.txt")
        listaPuntuaciones = []
        listaPuntos = []
        for i in f:
            listaPuntuaciones.append(i.split("#"))
        for j in listaPuntuaciones:
            if j[2] == '1':
                listaPuntos.append(int(j[3]))
        numMax = max(listaPuntos)
        jugadorMasPuntos = ""
        for k in range(len(listaPuntuaciones)):
            if listaPuntuaciones[k][3] == str(numMax) and listaPuntuaciones[k][2] == "1":
                jugadorMasPuntos = listaPuntuaciones[k][1]
        print(jugadorMasPuntos)

    elif opt == 6:
        break


