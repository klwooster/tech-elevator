SELECT p.person_id, p.first_name, p.last_name, p.preferred_name, p.date_of_birth, p.email, p.phone, a.account_id
FROM person p, account a, application app 
WHERE p.person_id = a.person_id 
AND p.person_id = app.applicant_id
AND app.program = 'camp1'