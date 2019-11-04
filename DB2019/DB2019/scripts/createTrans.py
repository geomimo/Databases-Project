import random

import math
import time

#Code from  https://stackoverflow.com/questions/553303/generate-a-random-date-between-two-other-dates
def strTimeProp(start, end, format, prop):

    stime = time.mktime(time.strptime(start, format))
    etime = time.mktime(time.strptime(end, format))

    ptime = stime + prop * (etime - stime)

    return time.strftime(format, time.localtime(ptime))


def randomDate(start, end, prop):
    return strTimeProp(start, end, '%d/%m/%Y', prop)





file = open("..\\update\\customersExport", "r")
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
for i  in range(len(ls2)-1):
    l2.append(ls2[i].split(";"))



file = open("..\\update\\transactionsUpdate.txt", "w")

for i in range(len(l1)):
    r = random.randint(0,len(l2)-1)

    out = "insert into transactions (cust_id, ticket_id, ticket_num, ticket_price, date) " + "values ('" + l1[i][0] + "','" + l2[r][0] + "'," + str(random.randint(1,200)) + ", " + l2[r][5] + ", '" + randomDate('2/3/2019', '2/5/2019', random.random()) + "');\n"
    file.write(out)

for i in range(100):
    r1 = random.randint(0,len(l1)-1)
    r2 = random.randint(0,len(l2)-1)

    out = "insert into transactions (cust_id, ticket_id, ticket_num, ticket_price, date) " + "values ('" + l1[r1][0] + "','" + l2[r2][0] + "'," + str(random.randint(1,200)) + ", " + l2[r2][5] +", '" + randomDate('2/3/2019', '2/5/2019', random.random()) + "');\n"
    file.write(out)

print "Done!"
