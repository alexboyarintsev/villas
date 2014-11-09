DROP DATABASE IF EXISTS villas;
CREATE DATABASE villas;
USE villas;


CREATE TABLE villas (
	id          BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	name        VARCHAR(100) NOT NULL,
	price       DECIMAL      NOT NULL,	
	description TEXT         NOT NULL,
  PRIMARY KEY (id)
) ENGINE=INNODB;

CREATE TABLE galleries (
  id           BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  villa_id     BIGINT UNSIGNED NOT NULL,
	image_name   VARCHAR(100)    NOT NULL,
	cover        TINYINT         NOT NULL, # 1 or 0
	thumb        TINYINT         NOT NULL, # 1 or 0
	image        MEDIUMBLOB      NOT NULL,
	extension   VARCHAR(5)       NOT NULL,
  PRIMARY KEY (id)
#   CONSTRAINT fk_galleries_villas FOREIGN KEY (villa_id) REFERENCES villas(id)
) ENGINE=INNODB;

# CREATE TABLE addresses (
# 	id       BIGINT UNSIGNED   NOT NULL AUTO_INCREMENT,
# 	zip      BIGINT UNSIGNED   NOT NULL,
# 	country  VARCHAR(100)      NOT NULL,
# 	city     VARCHAR(100)      NOT NULL,
# 	street   VARCHAR(100)      NOT NULL,
# 	building SMALLINT UNSIGNED NOT NULL,
# 	app      SMALLINT UNSIGNED NOT NULL,
# 	PRIMARY KEY (id)
# );

CREATE TABLE customers (
	id          BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	first_name  VARCHAR(100)    NOT NULL,
	last_name   VARCHAR(100)    NOT NULL,
	passport_no VARCHAR(100)    NOT NULL, /*make unique later*/
	email       VARCHAR(100)    NOT NULL, /*passport may be used as ID */
	phone       VARCHAR(100)    NOT NULL,
# 	address     BIGINT UNSIGNED NOT NULL,
# 	CONSTRAINT fk_customers_addresses FOREIGN KEY (address) REFERENCES addresses(id),
	PRIMARY KEY (id)
) ENGINE=INNODB;

CREATE TABLE reservations (
	id           BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	customer_id  BIGINT UNSIGNED NOT NULL,
	villa_id     BIGINT UNSIGNED NOT NULL,
	date_placed  DATE            NOT NULL,
	date_start   DATE            NOT NULL,
	date_finish  DATE            NOT NULL,
	total_days   INT    UNSIGNED NOT NULL,
  price        DECIMAL         NOT NULL,
	total_price  DECIMAL         NOT NULL,
  status       TINYINT         NOT NULL, /*-1 -declined, 0-pending, 1-approved*/
	CONSTRAINT fk_reservations_villas    FOREIGN KEY (villa_id)    REFERENCES villas(id),
	CONSTRAINT fk_reservations_customers FOREIGN KEY (customer_id) REFERENCES customers(id),
	PRIMARY KEY (id)
) ENGINE=INNODB;
