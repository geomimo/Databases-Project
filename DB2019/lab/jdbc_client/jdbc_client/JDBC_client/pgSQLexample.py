import psycopg2

#sudo pip install psycopg2
#https://wiki.postgresql.org/wiki/Python

try:
    conn = psycopg2.connect("dbname='galene' user='postgres' host='localhost' port='5433' password='123456'")
    cur = conn.cursor()
    cur.execute('SELECT 5')
    rows = cur.fetchall()
    print "\nShow me the rows:\n"
    for row in rows:
        print "   ", row[0]
except:
    print "I am unable to connect to the database"