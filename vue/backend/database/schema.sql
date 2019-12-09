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

CREATE TABLE person (
    person_id serial,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(25) NOT NULL,
    preferred_name VARCHAR(25),
    date_of_birth VARCHAR(20),
    email VARCHAR(40),
    phone VARCHAR(13)

    constraint pk_person primary key (person_id)
);

CREATE TABLE account (
    account_id serial,
    person_id int,

    constraint pk_account primary key (account_id, person_id),
	constraint fk_account_person foreign key (person_id) references person (person_id)
);

CREATE TABLE application ( 
	application_id serial,
	applicant_id int NOT NULL,
	account_id int NOT NULL,
	guardian_id int,
	emergency_contact_id int,
	dietary_preference VARCHAR(15),
	dietary_restrictions VARCHAR(200),
	mobility_issues VARCHAR(200),
	medical_concerns VARCHAR(200),
	meal_plan VARCHAR(100),
	program VARCHAR(50),
	dorm_assignment VARCHAR(50),
	tshirt_size VARCHAR(5),
	
	constraint pk_application primary key (application_id),
	constraint fk_application_person foreign key (applicant_id, guardian_id, emergency_contact_id) references person (person_id)
);

CREATE TABLE notes (
	note_id serial,
	note_body VARCHAR(250),
	create_date date,
	application_id int,
	
	constraint pk_notes primary key (note_id),
	constraint fk_notes_application foreign key (application_id) references application (application_id)
);

CREATE TABLE workshops (
	application_id int,
	workshop VARCHAR(200),
	rank int,
	
	constraint pk_workshops primary key (application_id, workshop),
	constraint fk_workshops_application foreign key (application_id) references application (application_id)
);

COMMIT TRANSACTION;
