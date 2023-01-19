CREATE TABLE IF  NOT EXISTS product(
     id SERIAL,
     description VARCHAR(100) NOT NULL,
     brand VARCHAR(100) NOT NULL,
     stock INT NOT NULL,
     PRIMARY KEY (id)
   );