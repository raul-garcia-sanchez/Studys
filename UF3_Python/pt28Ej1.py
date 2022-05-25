numLinias = int(input("Cuantas linias desea leer? "))
f = open("prueba1.txt","r")
for i in range(numLinias):
    print(f.readline().replace("\n",""))
f.close()

