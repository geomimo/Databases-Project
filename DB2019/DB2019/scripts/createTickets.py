import random



file = open("..\\update\\providersExport", "r")
inp = file.read()
ls1 = inp.split("\n")
file.close()
file = open("..\\update\\ticketsExport", "r")
inp = file.read()
ls2 = inp.split("\n")
file.close()

l1 = []
for i  in range(len(ls1)-1):
    l1.append(ls1[i].split(";"))

l2 = []
for i  in range(len(ls2)):
    l2.append(ls2[i].split(";"))

file = open("..\\update\\ticketsUpdate.txt", "w")

for r in range(len(l2)-1):
    n = random.randint(0,19)
    if "'" in l2[r][1]:
        continue
    out = "insert into tickets values ('" + l2[r][0] + "', '" + l2[r][1] + "', '" + l2[r][2] + "', '" + l2[r][3] + "', '" + l2[r][4] + "', " + l2[r][5] + ", " + l2[r][6] + ", '" + l2[r][7] + "', '" + l1[n] [0] + "');\n"

    file.write(out)

print "Done!"
