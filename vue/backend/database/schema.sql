BEGIN TRANSACTION;

DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS application;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id serial PRIMARY KEY,
  username varchar(255) NOT NULL UNIQUE,     -- Username
  password varchar(32) NOT NULL,      -- Password
  salt varchar(256) NOT NULL,          -- Password Salt
  role varchar(255) NOT NULL default('user')
);

CREATE TABLE address (
    address_id serial,
    address_line1 VARCHAR(40) NOT NULL,
    address_line2 VARCHAR(40),
    city VARCHAR(25) NOT NULL,
    state VARCHAR(15) NOT NULL,
    zip_code int,

    constraint pk_address_id primary key (address_id)
);

CREATE TABLE account (
    account_id serial,
    address_id int,
    email VARCHAR(40),
    phone_number int,
    status VARCHAR(8),

    constraint pk_account_id primary key (account_id),
    constraint fk_address_id foreign key (address_id) references address (address_id)
);

CREATE TABLE person (
    person_id serial,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(25) NOT NULL,
    date_of_birth date,
    account_id int,
    primary_applicant boolean,

    constraint pk_person_id primary key (person_id),
    constraint fk_account_id foreign key (account_id) references account (account_id)
);

COMMIT TRANSACTION;
