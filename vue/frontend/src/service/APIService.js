export default {

     listApplicants() {
        console.log('getting applicants');
        return fetch('http://localhost:8080/AuthenticationApplication/api/applicants')
        .then((response) => {
            return response.json();
        });
     },

     getById(applicantId) {
         console.log('getting applicant');
         return fetch(`http://localhost:8080/AuthenticationApplication/api/applicants/${applicantId}`)
         .then((response) => {
             return response.json();
         });
     }


 }