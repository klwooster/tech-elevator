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
          <span><router-link :to="{name: 'applicantinfo' , params:{id: applicant.personId}}">{{applicant.firstName}}</router-link></span>
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
import APIService from '@/service/APIService';

export default {
  name: 'applicant-table',
  
  data() {
    return {
        applicants: [],
    };
  },
  methods: { 
      getApplicants() {
          APIService.listApplicants().then(applicants => this.applicants = applicants);
      }
  },
  created() {
          this.getApplicants();
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
