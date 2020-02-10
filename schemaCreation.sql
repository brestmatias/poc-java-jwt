CREATE TABLE IF NOT EXISTS stock (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255) NULL,
    type VARCHAR(255) NULL,
    color VARCHAR(255) NULL,
	size VARCHAR(255) NULL,
	quantity INT NULL,
    prize decimal null
)  ENGINE=INNODB;