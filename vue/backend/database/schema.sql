BEGIN TRANSACTION;

DROP TABLE IF EXISTS history_changes;
DROP TABLE IF EXISTS history;
DROP TABLE IF EXISTS workshops;
DROP TABLE IF EXISTS notes;
DROP TABLE IF EXISTS application;
DROP TABLE IF EXISTS camp;
DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS person;


CREATE TABLE person (
    person_id serial,
    first_name VARCHAR(75) NOT NULL,
    last_name VARCHAR(75) NOT NULL,
    preferred_name VARCHAR(50),
    date_of_birth date,
    email VARCHAR(100),
    phone VARCHAR(13),

    constraint pk_person primary key (person_id)
);

CREATE TABLE users (
  id serial PRIMARY KEY,
  person_id int,
  username varchar(255) NOT NULL UNIQUE,     -- Username
  password varchar(32) NOT NULL,      -- Password
  salt varchar(256) NOT NULL,          -- Password Salt
  role varchar(255) NOT NULL default('user'),
  
  constraint fk_users_person foreign key (person_id) references person (person_id)
);

CREATE TABLE account (
    account_id serial,
    person_id int,

    constraint pk_account primary key (account_id, person_id),
        constraint fk_account_person foreign key (person_id) references person (person_id)
);

CREATE TABLE camp (
        camp_id serial,
        name VARCHAR(50),
        description VARCHAR(300),
        location VARCHAR(50),
        capacity int,
        min_age int,
        max_age int,
        start_date date,
        end_date date,
        image VARCHAR(100),
        
        constraint pk_camp primary key (camp_id)
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
	program_id int,
	dorm_assignment VARCHAR(50),
	tshirt_size VARCHAR(5),
	
	constraint pk_application primary key (application_id),
	constraint fk_application_person_applicant foreign key (applicant_id) references person (person_id),
        constraint fk_application_person_guardian foreign key (guardian_id) references person (person_id),
        constraint fk_application_person_emergency_contact foreign key (emergency_contact_id) references person (person_id),
        constraint fk_application_camp foreign key (program_id) references camp (camp_id)
);

CREATE TABLE notes (
	note_id serial,
	note_body VARCHAR(250),
	create_date timestamp,
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

CREATE TABLE history (
	history_id serial,
	date_of_change timestamp,
	update_made_by_id int,
	changes_made_to_id int,
	status VARCHAR(50),
	
	constraint pk_history primary key (history_id),
	constraint fk_history_person_updated_by foreign key (update_made_by_id) references person (person_id)
);

CREATE TABLE history_changes (
	history_id int,
	old_value VARCHAR(300),
	new_value VARCHAR(300),
	data_element_changed VARCHAR(100),
	
	constraint pk_history_changes primary key (history_id, data_element_changed),
	constraint fk_history_changes_history foreign key (history_id) references history (history_id)
);



COMMIT TRANSACTION;
