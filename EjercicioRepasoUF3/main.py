def ficheroADiccionario(fichero):
    f = open(fichero)
    lista = []
    for i in f:
        lista.append(i.split("!"))
    f.close()
    listaDni = []
    listaNombres = []
    listaPuntuaciones = []
    listaClasificacion = []
    for j in lista:
        listaDni.append([j][0][0].split(":"))
        listaNombres.append(j[1].split(":"))
        listaPuntuaciones.append(j[2].split(":"))
        listaClasificacion.append(j[3].replace("\n","").split(":"))
    cadena = "{"+"\n"
    for k in range(len(lista)):
        cadena += listaDni[k][1]+":"+"{"+listaNombres[k][0]+":"+listaNombres[k][1]+","+listaPuntuaciones[k][0]+":"+"["+listaPuntuaciones[k][1]+"]"+","+listaClasificacion[k][0]+":"+listaClasificacion[k][1]+"}"+"\n"
    cadena += "}"
    return cadena

#print(ficheroADiccionario("datosJugadores.txt"))

def ficheroGuardoDiccionario(fichero,diccionario):
    f = open(fichero,"w")
    f.write(diccionario)

ficheroGuardoDiccionario("diccionarioDatosJugadores.txt",ficheroADiccionario("datosJugadores.txt"))

def ficheroADiccionario2(fichero):
    f = open(fichero)
    lista = []
    for i in f:
        lista.append(i.split("!"))
    f.close()
    listaDni = []
    listaNombres = []
    listaPuntuaciones = []
    listaClasificacion = []
    for j in range(len(lista)):
        for i in range(0, 4):
            if "dni" in lista[j][i]:
                listaDni.append(lista[j][i].split(":"))
            if "nombre" in lista[j][i]:
                listaNombres.append(lista[j][i].split(":"))
            if "puntuaciones" in lista[j][i]:
                listaPuntuaciones.append(lista[j][i].split(":"))
            if "clasificacion" in lista[j][i]:
                listaClasificacion.append(lista[j][i].split(":"))
    cadena = "{" + "\n"
    for k in range(len(lista)):
        cadena += listaDni[k][1].replace("\n","") + ":" + "{" + listaNombres[k][0].replace("\n","") + ":" + listaNombres[k][1].replace("\n","") + "," + listaPuntuaciones[k][0].replace("\n","") + ":" + "[" + listaPuntuaciones[k][1].replace("\n","") + "]" + "," + listaClasificacion[k][0].replace("\n","") + ":" + listaClasificacion[k][1].replace("\n","") + "}" + "\n"
    cadena += "}"
    return cadena

#print(ficheroADiccionario2("datosJugadores2.txt"))

def ficheroGuardoDiccionario2(fichero,diccionario):
    f = open(fichero,"w")
    f.write(diccionario)
ficheroGuardoDiccionario2("diccionarioDatosJugadores2.txt",ficheroADiccionario2("datosJugadores2.txt"))