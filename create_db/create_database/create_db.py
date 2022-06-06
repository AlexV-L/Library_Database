import csv
import sqlite3

isVerbose = True

csv_books = 'data/books.csv'
csv_borrowers = 'data/borrowers.csv'

library_db = sqlite3.connect('library_db.sqlite')
if isVerbose:
    print("Backing up existing database to library_db_backup.sqlite...")
library_db.backup(sqlite3.connect('library_db_backup.sqlite'))
db_cur = library_db.cursor()

create_db_query = open('data/create_db.txt', encoding='utf8').read().split(';')

for query in create_db_query:
    db_cur.execute(query)

unnormalized_books = csv.reader(open(csv_books, encoding='utf8'), dialect='excel-tab')
unnormalized_borrowers = csv.reader(open(csv_borrowers, encoding='utf8'), dialect='excel')

for row in unnormalized_books:
    # fetching all data from the books csv
    row.reverse()
    isbn10 = row.pop()
    isbn13 = int(row.pop())
    title = row.pop()
    authors = row.pop().split(",")
    cover = row.pop()
    publisher = row.pop()
    pages = int(row.pop())
    # creating entries in the books table
    db_cur.execute("INSERT INTO BOOKS VALUES (:isbn13, :title)",
                   {"isbn13": isbn13, "title": title})
    if isVerbose:
        print("Inserting book " + title + " with ISBN " + str(isbn13))
    for author in authors:
        # creating entries in the authors table, skipping duplicates
        try:
            db_cur.execute("INSERT INTO AUTHORS (name) VALUES (:author)",
                           {"author": author})
            if isVerbose:
                print("Inserting author " + author + ", generating new author_id")
        except sqlite3.IntegrityError:
            if isVerbose:
                print("Duplicate author " + author + " found, skipping.")
    for author in authors:
        # creating relationship book_authors for each book author
        db_cur.execute("SELECT author_id FROM AUTHORS WHERE name=:author",
                       {"author": author})
        author_id = db_cur.fetchall()[-1][0]
        db_cur.execute("INSERT INTO BOOK_AUTHORS VALUES (:author_id, :isbn)",
                       {"author_id": author_id, "isbn": isbn13})
        if isVerbose:
            print("Linking author with id " + str(author_id) + " to book with ISBN " + str(isbn13))

for row in unnormalized_borrowers:
    # fetching all data from the borrower csv
    row.reverse()
    ID = int(row.pop()[2:8])
    ssn = row.pop()
    ssn = int(ssn[0:3] + ssn[4:6] + ssn[7:11])
    first_name = row.pop()
    last_name = row.pop()
    email = row.pop()
    address = row.pop()
    city = row.pop()
    state = row.pop()[0:2]
    phone = row.pop()
    phone = int(phone[1:4] + phone[6:9] + phone[10:14])
    # create new entry in address, saving address id
    db_cur.execute("INSERT INTO ADDRESSES (address, city, state_ab) VALUES (:address, :city, :state_ab)",
                   {"address": address, "city": city, "state_ab": state})
    db_cur.execute("SELECT address_id FROM ADDRESSES WHERE address=:address AND city=:city AND state_ab=:state_ab",
                   {"address": address, "city": city, "state_ab": state})
    address_id = db_cur.fetchall()[-1][0]
    if isVerbose:
        print("Assigned address " + address + ", " + city + " " + state + " address_id " + str(address_id))
    # create new entry in bname, saving bname id
    db_cur.execute("INSERT INTO BNAMES (fname, lname) VALUES (:fname, :lname)",
                   {"fname": first_name, "lname": last_name})
    db_cur.execute("SELECT bname_id FROM BNAMES WHERE fname=:fname AND lname=:lname",
                   {"fname": first_name, "lname": last_name})
    bname_id = db_cur.fetchall()[-1][0]
    if isVerbose:
        print("Assigned name " + last_name + ", " + first_name + " bname_id " + str(address_id))
    # create new entry in borrowers
    db_cur.execute("INSERT INTO BORROWERS VALUES (:card_id, :ssn, :bname_id, :address_id, :phone)",
                   {"card_id": ID, "ssn": ssn, "bname_id": bname_id, "address_id": address_id, "phone": phone})
    if isVerbose:
        print("Inserting borrower with ID " + str(ID) + ", SSN " + str(ssn) + ", bname_id " + str(
            bname_id) + ", address_id " + str(address_id) + ", and phone " + str(phone))

library_db.commit()

library_db.close()
