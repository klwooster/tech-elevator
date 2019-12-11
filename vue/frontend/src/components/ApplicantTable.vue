<template>
  <div id="applicant-list" class="list">
      <div class="list-header">
          <span class="applicant-data">ID</span>
          <span class="applicant-data">First Name</span>
          <span class="applicant-data">Last Name</span>
          <span class="applicant-data">Preferred Name</span>
          <span class="applicant-data">Date of Birth</span>
          <span class="applicant-data">Email</span>
          <span class="applicant-data">Phone</span>
          <span class="applicant-data">Account #</span>
      </div>
      <div class="list-row" v-for="applicant in applicants" :key="applicant.personId">
          <span class="applicant-data">{{applicant.personId}}</span>
          <span class="applicant-data">{{applicant.firstName}}</span>
          <span class="applicant-data">{{applicant.lastName}}</span>
          <span class="applicant-data">{{applicant.preferredName}}</span>
          <span class="applicant-data">{{applicant.dateOfBirth}}</span>
          <span class="applicant-data">{{applicant.email}}</span>
          <span class="applicant-data">{{applicant.phone}}</span>
          <span class="applicant-data">{{applicant.accountId}}</span>
      </div>
  </div>
</template>

<script>
export default {
  name: 'applicant-table',
//   props: {
//       api_url: String
//   },
  data() {
    return {
        applicants: [],
        api_url: 'http://localhost:8080/AuthenticationApplication/api/applicants'
        /*moved the api link here instead of ApplicantList because the browser was showing the api_url as undefinied*/
    };
  },
  methods: { 
      showApplicants() {
          console.log('getting ready to get applicants');
          fetch(this.api_url)
          .then(response => response.json())
          .then(data => (this.applicants = data))
          .catch(err => console.error(err));
      },

      
  },
  created() {
          this.showApplicants();
  }
};
</script>

<style>
    .list {
        display: block;
        background: red; 
        font-family: Arial, Helvetica, sans-serif;
        color: darkslategrey;
        font-size: 14px;
        text-align: left;
        margin-top: auto;
        margin-bottom: auto;
    }

    .list-header {
        font-weight: bold; 
    }

    .list-row {
        width: 95%;
        display: flex;
        flex-direction: row;
        flex-wrap: nowrap;
    }

    .applicant-data {
        flex-basis: 25%;
        flex-grow: 0;
        flex-shrink: 0;
    }

    .applicant-status {
        flex-basis: 15%;
    }
</style>
