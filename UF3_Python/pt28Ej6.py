def carregar_dades(archivo):
    cadena = "{"
    lista = []
    f = open(archivo)
    for i in f:
        cadena += (i.replace("\n",","))
    f.close()
    return cadena+"}"
carregar_dades("prueba7.txt")

def guardar_dades(archivo):
    f = open(archivo,"w")
    datosAEscribir = carregar_dades("prueba7.txt")
    f.write(datosAEscribir)
    f.close()
guardar_dades("prueba8.txt")