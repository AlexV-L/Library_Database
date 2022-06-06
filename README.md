# Library_Database
Small Project with SQL simulating a Library.

- BOOKS Table
	- ISBN
		- ISBN was assumed to be stored as ISBN13 rather than ISBN10. ISBN10 has a base 11 digit within a larger base 10 number, posing a unique problem to storing it. With this in mind, ISBN13 was chosen instead
		
		- ISBNs are assumed to be unique
		
- AUTHORS table
	- Author_id
		- An author_id is generated for each author name present in the database.
		- It is assumed for two authors of the same name still have unique IDs.
		
- BOOK_ AUTHORS table
	- Relationship table allowing for multiple authors to write a single book and one author to have written multiple books
	
	- BNAMES table
		- Compound data used for BORROWERS table. Consists of a first and last name
		- For repeated names, a new ID is created for each. It is assumed that the constraints within BORROWERS will prevent two accounts sharing a name pointing to the same BNAMES entry.
	
	- ADDRESSES table
		- Compound data used for ADDRESSES table. Consists of an address, city, and state abbreviation.
		- There are no restrictions on address or city, but the state abbreviation is assumed to be only two characters, both uppercase. Needless to say, it is assumed this system will only operate within the USA
	- BORROWERS table
		- Card_id
			- For each new borrower, a unique Card_id is generated. This card_id increments with each new entry.
		- SSN
			- Stored as a 9-digit integer. No dashes.
			- Assumed unique
		- BName_id
		- Address_id
		- Phone
			- Stored as a 10-digit integer. No dashes

	- BOOK_LOANS table
		- Loan_id
			- For each new loan, a unique loan_id is generated. This loan_id increments with each new entry.
		- ISBN
			- See above
		- Card_id
		- Date_out
			- Stored as an integer, representing the number of seconds that have passed since 00:00:00 UTC on 1 January 1970. Referred to as UNIX Epoch Time.
		- Due_date
			- Above entry, but with 1209600 added. This represents the amount of seconds in 14 days.
		- Date_in
			- Stored as an integer in UNIX Epoch Time.
	- FINES table
		- Loan_id
			- Refers to loan_id on BOOK_LOANS
		- Fine_amt
			- Stored as an integer with 2 digits trailing the decimal. This is done as the amount only increments 0.25 at a time.
			- The calculation for the current fine amount is beyond the capabilities of SQLite, and is left for the main program.
		- Paid
			- Boolean variable representing if the FINES entry has been paid or not