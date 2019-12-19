INSERT INTO person (first_name,last_name, preferred_name,date_of_birth,email,phone)
VALUES('Michael','MQue','Mike','1971-3-12','fake@fake.com','614-882-3546');

INSERT INTO person (first_name,last_name, preferred_name,date_of_birth,email,phone)
VALUES('Bob','Smith','Bob','1980-01-12','bsmith@fake.com','614-213-7654');

INSERT INTO person (first_name,last_name, preferred_name,date_of_birth,email,phone)
VALUES('Jim','Dpe','Jim','2000-10-15','jdpe12@fake.com','');

INSERT INTO person (first_name,last_name, preferred_name,date_of_birth,email,phone)
VALUES('Jenny','Tutone','Jen','2005-03-24','catdog280@fake.com','614-867-5309');

INSERT INTO person (first_name,last_name, preferred_name,date_of_birth,email,phone)
VALUES('Bill','Johnson','William','1994-06-08','BJohnson@fake.com','614-895-1111');

INSERT INTO person (first_name,last_name, preferred_name,date_of_birth,email,phone)
VALUES('John','Johnson','Jonathan','2013-05-11','jj@fake.com','614-888-8888');

INSERT INTO person (first_name,last_name, preferred_name,date_of_birth,email,phone)
VALUES('Katrina','Jones','Kat','2003-11-02','KLo@fake.com','614-333-3333');

INSERT INTO person (first_name,last_name, preferred_name,date_of_birth,email,phone)
VALUES('Ian','Smithgensen','Ian','2012-08-10','IanS@fake.com','614-222-2222');

INSERT INTO person (first_name,last_name, preferred_name,date_of_birth,email,phone)
VALUES('Kelly','Daum','Kells','1991-03-23','kd@fake.com','614-334-5556');

INSERT INTO person (first_name,last_name, preferred_name,date_of_birth,email,phone)
VALUES('Jackie','McCarty','Jackie','2010-04-01','jmac@fake.com','614-990-9999');

INSERT INTO account (person_id)
VALUES (1);
INSERT INTO account (person_id)
VALUES (2);
INSERT INTO account (person_id)
VALUES (3);
INSERT INTO account (person_id)
VALUES (4);
INSERT INTO account (person_id)
VALUES (5);
INSERT INTO account (person_id)
VALUES (6);
INSERT INTO account (person_id)
VALUES (7);
INSERT INTO account (person_id)
VALUES (8);
INSERT INTO account (person_id)
VALUES (9);
INSERT INTO account (person_id)
VALUES (10);

INSERT INTO application (applicant_id ,account_id,guardian_id,emergency_contact_id,dietary_preference ,dietary_restrictions,mobility_issues,medical_concerns,meal_plan,program, program_id, dorm_assignment,tshirt_size)
VALUES (1,1,2,3,'omnivore','no peanuts','Likes to nap','None','Delux','anawanna', 3,'Three','L');

INSERT INTO application (applicant_id ,account_id,guardian_id,emergency_contact_id,dietary_preference ,dietary_restrictions,mobility_issues,medical_concerns,meal_plan,program, program_id, dorm_assignment,tshirt_size)
VALUES (2,2,2,3,'vegetarian','none','none','none','Light','anawanna', 3, 'Three','M');

INSERT INTO application (applicant_id ,account_id,guardian_id,emergency_contact_id,dietary_preference ,dietary_restrictions,mobility_issues,medical_concerns,meal_plan,program, program_id, dorm_assignment,tshirt_size)
VALUES (3,3,2,3,'vegan','no meat','none','none','Standard','crystal', 2, 'Two','S');

INSERT INTO application (applicant_id ,account_id,guardian_id,emergency_contact_id,dietary_preference ,dietary_restrictions,mobility_issues,medical_concerns,meal_plan,program, program_id, dorm_assignment,tshirt_size)
VALUES (4,4,2,3,'omnivore','no avocado','none','none','Light','crystal', 2, 'Two','XS');

INSERT INTO application (applicant_id ,account_id,guardian_id,emergency_contact_id,dietary_preference ,dietary_restrictions,mobility_issues,medical_concerns,meal_plan,program, program_id, dorm_assignment,tshirt_size)
VALUES (5,5,2,3,'omnivore','gluten free','none','none','Delux','anawanna', 3, 'Three','XXXL');

INSERT INTO application (applicant_id ,account_id,guardian_id,emergency_contact_id,dietary_preference ,dietary_restrictions,mobility_issues,medical_concerns,meal_plan,program, program_id, dorm_assignment,tshirt_size)
VALUES (6,6,2,3,'vegan','no cilantro','none','none','Light','north', 1, 'One','XS');

INSERT INTO application (applicant_id ,account_id,guardian_id,emergency_contact_id,dietary_preference ,dietary_restrictions,mobility_issues,medical_concerns,meal_plan,program, program_id, dorm_assignment,tshirt_size)
VALUES (7,7,2,3,'vegetarian','no gluten','broken leg','none','Delux','crystal', 2, 'Two','M');

INSERT INTO application (applicant_id ,account_id,guardian_id,emergency_contact_id,dietary_preference ,dietary_restrictions,mobility_issues,medical_concerns,meal_plan,program, program_id, dorm_assignment,tshirt_size)
VALUES (8,8,2,3,'omnivore','none','Wheelchair','none','Standard','north', 1, 'One','XS');

INSERT INTO application (applicant_id ,account_id,guardian_id,emergency_contact_id,dietary_preference ,dietary_restrictions,mobility_issues,medical_concerns,meal_plan,program, program_id, dorm_assignment,tshirt_size)
VALUES (9,9,2,3,'vegetarian','none','none','none','Light','anawanna',3, 'Three','M');

INSERT INTO application (applicant_id ,account_id,guardian_id,emergency_contact_id,dietary_preference ,dietary_restrictions,mobility_issues,medical_concerns,meal_plan,program, program_id, dorm_assignment,tshirt_size)
VALUES (10,10,2,3,'omnivore','none','none','none','Standard','north',1, 'One','XS');

INSERT INTO notes (note_body,create_date,application_id)
VALUES ('So excited to get started!',NOW()::timestamp,1);

INSERT INTO notes (note_body,create_date,application_id)
VALUES ('Oh, I forgot to tell you I can not eat bananas.',NOW()::timestamp,1);

INSERT INTO notes (note_body,create_date,application_id)
VALUES ('My son Jim is so excited, we love this camp!',NOW()::timestamp,3);

INSERT INTO notes (note_body,create_date,application_id)
VALUES ('This will be the highlight of my year',NOW()::timestamp,5);

INSERT INTO notes (note_body,create_date,application_id)
VALUES ('Little Johnny is not the best swimmer, please keep a close watch on him.',NOW()::timestamp,6);

INSERT INTO notes (note_body,create_date,application_id)
VALUES ('I would like to volunteer to chaperone for the kids this year.', NOW()::timestamp ,10);

