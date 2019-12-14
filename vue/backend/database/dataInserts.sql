INSERT INTO person (first_name,last_name, preferred_name,date_of_birth,email,phone)
VALUES('Michael','MQue','Mike','3-12-71','fake@fake.com','614-882-3546');

INSERT INTO person (first_name,last_name, preferred_name,date_of_birth,email,phone)
VALUES('Bob','Smith','Bob','1-12-80','bsmith@fake.com','614-213-7654');

INSERT INTO person (first_name,last_name, preferred_name,date_of_birth,email,phone)
VALUES('Jim','Dpe','Jim','1-12-45','jdpe12@fake.com','');

INSERT INTO person (first_name,last_name, preferred_name,date_of_birth,email,phone)
VALUES('Jenny','Tutone','Jen','','80swerebad@fake.com','614-867-5309');

INSERT INTO person (first_name,last_name, preferred_name,date_of_birth,email,phone)
VALUES('Bill','Johnson','William','','BJohnson@fake.com','614-895-1111');

INSERT INTO person (first_name,last_name, preferred_name,date_of_birth,email,phone)
VALUES('John','Johnson','Jonathan','','jj@fake.com','');

INSERT INTO person (first_name,last_name, preferred_name,date_of_birth,email,phone)
VALUES('Katrina','Jones','Kat','','KLo@fake.com','');

INSERT INTO person (first_name,last_name, preferred_name,date_of_birth,email,phone)
VALUES('Ian','Smithgensen','Ian','','IanS@fake.com','');

INSERT INTO person (first_name,last_name, preferred_name,date_of_birth,email,phone)
VALUES('Kelly','Daum','Kells','','kd@fake.com','');

INSERT INTO person (first_name,last_name, preferred_name,date_of_birth,email,phone)
VALUES('Jackie','McCarty','Jackie','','jmac@fake.com','');

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

INSERT INTO application (applicant_id ,account_id,guardian_id,emergency_contact_id,dietary_preference ,dietary_restrictions,mobility_issues,medical_concerns,meal_plan,program,dorm_assignment,tshirt_size)
VALUES (1,1,2,3,'No Peanuts','Tastes Good','Likes to nap','None','Yes I plan to eat','none','Five','L');

INSERT INTO application (applicant_id ,account_id,guardian_id,emergency_contact_id,dietary_preference ,dietary_restrictions,mobility_issues,medical_concerns,meal_plan,program,dorm_assignment,tshirt_size)
VALUES (2,2,2,3,'','','Likes to nap','None','Bacon Please','none','Five','M');

INSERT INTO application (applicant_id ,account_id,guardian_id,emergency_contact_id,dietary_preference ,dietary_restrictions,mobility_issues,medical_concerns,meal_plan,program,dorm_assignment,tshirt_size)
VALUES (3,3,2,3,'None','','Likes to nap','None','Nom to the Nom','none','Five','S');

INSERT INTO application (applicant_id ,account_id,guardian_id,emergency_contact_id,dietary_preference ,dietary_restrictions,mobility_issues,medical_concerns,meal_plan,program,dorm_assignment,tshirt_size)
VALUES (4,4,2,3,'NA','Tastes Good','','None','','none','Five','XS');

INSERT INTO application (applicant_id ,account_id,guardian_id,emergency_contact_id,dietary_preference ,dietary_restrictions,mobility_issues,medical_concerns,meal_plan,program,dorm_assignment,tshirt_size)
VALUES (5,5,2,3,'No Peanuts','Tastes Good','','None','','none','Five','XL');

INSERT INTO application (applicant_id ,account_id,guardian_id,emergency_contact_id,dietary_preference ,dietary_restrictions,mobility_issues,medical_concerns,meal_plan,program,dorm_assignment,tshirt_size)
VALUES (6,6,2,3,'Peanuts','Tastes Good','NA','None','','none','Five','M');

INSERT INTO application (applicant_id ,account_id,guardian_id,emergency_contact_id,dietary_preference ,dietary_restrictions,mobility_issues,medical_concerns,meal_plan,program,dorm_assignment,tshirt_size)
VALUES (7,7,2,3,'Gluten','Tastes Good','Likes to nap','None','No healthy food please','none','Five','M');

INSERT INTO application (applicant_id ,account_id,guardian_id,emergency_contact_id,dietary_preference ,dietary_restrictions,mobility_issues,medical_concerns,meal_plan,program,dorm_assignment,tshirt_size)
VALUES (8,8,2,3,'Spam','Tastes Good','Wheelchair','None','Yes I plan to eat','none','Five','L');

INSERT INTO application (applicant_id ,account_id,guardian_id,emergency_contact_id,dietary_preference ,dietary_restrictions,mobility_issues,medical_concerns,meal_plan,program,dorm_assignment,tshirt_size)
VALUES (9,9,2,3,'Milk','Tastes Good','','None','If I see it, Ill eat it','none','Five','S');

INSERT INTO application (applicant_id ,account_id,guardian_id,emergency_contact_id,dietary_preference ,dietary_restrictions,mobility_issues,medical_concerns,meal_plan,program,dorm_assignment,tshirt_size)
VALUES (10,10,2,3,'Corn','Tastes Good','','None','Yes I plan to eat','none','Five','S');

INSERT INTO notes (note_body,create_date,application_id)
VALUES ('Notes and Stuff',null,1);

INSERT INTO notes (note_body,create_date,application_id)
VALUES ('More Notes',null,1);

INSERT INTO notes (note_body,create_date,application_id)
VALUES ('Camper still has balance',null,3);

INSERT INTO notes (note_body,create_date,application_id)
VALUES ('None',null,5);

INSERT INTO notes (note_body,create_date,application_id)
VALUES ('Something clever',null,6);

INSERT INTO notes (note_body,create_date,application_id)
VALUES ('Working on testing notes',null,10);

INSERT INTO workshops (application_id,workshop,rank)
VALUES (1,'Workshop stuff',1);
