dictDatos = {}
def cargarDatos(archivo):
    f = open(archivo)
    linia = f.readline().replace("\n","")
    while linia != "":
        key = linia[0:6].replace(" ","")
        linia = linia [6:]
        lista = []
        for i in (31,21):
            lista.append(linia[:i])
            linia = linia[i:].replace("\n","")
        lista.append(linia)
        dictDatos[key] = lista
        linia = f.readline()
cargarDatos("Cara.txt")
cargarDatos("Dura.txt")




