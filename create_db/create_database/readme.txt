ONLY USE THIS TO INSERT INITIAL VALUES
THIS SCRIPT DROPS ALL TABLES OF THE OLD DATABASE

Requirements:
	Python	>= 3.7.X
	SQLite	>= 3.31.0


To create the database, ensure corresponding csv files are in data file and execute create_db.py.
This will back up the existing database, then create a new database (library_db.sqlite)
The database will be created according the create_db.txt
Initial data will be imported from data/books.csv and data/borrowers.csv

When database is created, run move_db.py to move the database to its correct location
After this, feel free to delete the whole /create_database/ folder


NOTE: for demonstration purposes, a premade database is included in event of something going wrong
