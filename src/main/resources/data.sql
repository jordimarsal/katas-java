DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL
);

INSERT INTO users (username, password, first_name, last_name) VALUES
  ('admin', 'admin', 'Jordi','MP' );
INSERT INTO users (username, password, first_name, last_name) VALUES
  ('jordi', 's0m3Hard_r', 'Jordi', 'MP');
INSERT INTO users (username, password, first_name, last_name) VALUES
  ('guest', 'guest', 'Some', 'One');

