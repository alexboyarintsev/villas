CREATE TABLE villas (
	id          BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	name        VARCHAR(100) NOT NULL,
	cover       VARCHAR(100) NOT NULL,
	price       DECIMAL      NOT NULL,	
	description TEXT         NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE galleries (
	id           BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	villa_id     BIGINT UNSIGNED NOT NULL,
	picture_name VARCHAR(100)    NOT NULL,
	CONSTRAINT fk_galleries_villas FOREIGN KEY (villa_id) REFERENCES villas(id),
	PRIMARY KEY (id)
);

CREATE TABLE addresses (
	id       BIGINT UNSIGNED   NOT NULL AUTO_INCREMENT,
	zip      BIGINT UNSIGNED   NOT NULL,
	country  VARCHAR(100)      NOT NULL,
	city     VARCHAR(100)      NOT NULL,
	street   VARCHAR(100)      NOT NULL,
	building SMALLINT UNSIGNED NOT NULL,
	app      SMALLINT UNSIGNED NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE customers (
	id          BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	first_name  VARCHAR(100)    NOT NULL,
	last_name   VARCHAR(100)    NOT NULL,
	passport_no VARCHAR(100)    NOT NULL UNIQUE,
	email       VARCHAR(100)    NOT NULL, /*passport may be used as ID */
	phone       VARCHAR(100)    NOT NULL,
	address     BIGINT UNSIGNED NOT NULL,
	CONSTRAINT fk_customers_addresses FOREIGN KEY (address) REFERENCES addresses(id),
	PRIMARY KEY (id)
);

CREATE TABLE reservations (
	id           BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	customer_id  BIGINT UNSIGNED NOT NULL,
	villa_id     BIGINT UNSIGNED NOT NULL,
	date_placed  DATE            NOT NULL,
	date_start   DATE            NOT NULL,
	date_finish  DATE            NOT NULL,
	total_days   INT    UNSIGNED NOT NULL,
	total_price  DECIMAL         NOT NULL,
	CONSTRAINT fk_reservations_villas    FOREIGN KEY (villa_id)    REFERENCES villas(id),
	CONSTRAINT fk_reservations_customers FOREIGN KEY (customer_id) REFERENCES customers(id),
	PRIMARY KEY (id)
);
