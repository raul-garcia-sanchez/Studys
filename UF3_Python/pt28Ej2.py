numBytesLeer = int(input("Cuantos bytes desea leer del fichero? "))
f = open("prueba1.txt","r")
bytesLeidos = f.read(numBytesLeer)
f.close()
f2 = open("prueba2.txt","w")
f2.write(bytesLeidos)
f2.close()
print("Se han copiado los datos")