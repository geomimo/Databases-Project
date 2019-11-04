create table Tickets (
	id VARCHAR(40) PRIMARY KEY,
	title VARCHAR(200) NOT NULL,
	category VARCHAR(11),
	start_date DATE NOT NULL,
	end_date DATE,
	price DECIMAL(4,2),
	available INT,
	location VARCHAR(100),
	provider VARCHAR(50) REFERENCES providers(name)
);

