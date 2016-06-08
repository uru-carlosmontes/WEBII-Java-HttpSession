-- Database: test

-- DROP DATABASE test;

CREATE DATABASE test
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Spanish_Spain.1252'
       LC_CTYPE = 'Spanish_Spain.1252'
       CONNECTION LIMIT = -1;


CREATE TABLE _user
(
  user_id INTEGER NOT NULL,
  user_name VARCHAR(40) NOT NULL,
  last_name VARCHAR(40) NOT NULL,
  user_pass VARCHAR(100) NOT NULL,
  CONSTRAINT _user_pkey PRIMARY KEY (user_id)
)  