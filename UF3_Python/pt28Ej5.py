f = open("archivoSinCifrar.txt","r")
f2 = open("archivoCifrado.txt","w")

for i in f:
    for j in i:
        if j.isalpha():
            f2.write(chr((ord(j)+13)%26).replace("\n",""))
        else:
            f2.write(j.replace("\n",""))
