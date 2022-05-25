numLinias = 0
numPalabras = 0
numCaracters = 0
f = open("prueba4.txt","r")
for i in f:
    numLinias+=1
print("Linias = "+str(numLinias))
f.close()
f = open("prueba4.txt","r")
lista = []
count = 1
for i in f:
    for j in i:
        lista.append(j)
numCaracters = len(lista)
print("Caracters = "+str(numCaracters))
f.close()
f = open("prueba4.txt","r")
numPalabras = len(f.read().split(" "))
print("Palabras = "+str(numPalabras))
f.close()

