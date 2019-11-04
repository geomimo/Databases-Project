create table Transactions (
	cust_id VARCHAR(40) REFERENCES customers(id),
	ticket_id VARCHAR(40) REFERENCES tickets(id),
	ticket_num INT,
	ticket_price NUMERIC(4,2),
	date DATE,
	PRIMARY KEY (cust_id, ticket_id, date)
);