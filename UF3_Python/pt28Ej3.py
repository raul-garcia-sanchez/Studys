f = open("prueba3.txt")
for i in f:
    print(i.replace("\"","").replace("[","").replace("]",""))
f.close()