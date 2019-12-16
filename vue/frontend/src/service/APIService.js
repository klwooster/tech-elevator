// import axios from 'axios';

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
    },
    updateApplication(application, applicantId) {
        console.log('making updates....');
        return fetch(`http://localhost:8080/AuthenticationApplication/api/applicants/${applicantId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(application)
        });
    },
    createApplication(application) {
        console.log('creating application....');
        return fetch(`http://localhost:8080/AuthenticationApplication/api/register`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(application)
        });
    },
    getHistoryById(id) {
        console.log('getting account history....');
        return fetch(`http://localhost:8080/AuthenticationApplication/api/history/${id}`)
            .then((response) => {
                return response.json();
            });
    }
}