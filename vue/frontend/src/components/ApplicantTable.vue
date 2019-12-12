<template>
            <div class="list">
                <h1>Applicants</h1>
                <div class="row">
                    <p class="title">Applicant ID</p>
                    <p class="title">First Name</p>
                    <p class="title">Last Name</p>
                    <p class="title">Account #</p>
                </div>
                <hr>
                <div class="row" v-for="applicant in applicants" :key="applicant.personId" v-on:click="viewApplicantDetails(applicant.personId)">
                    <a href="#"><p>{{applicant.personId}}</p>
                    <p>{{applicant.firstName}}</p>
                    <p>{{applicant.lastName}}</p>
                    <p>{{applicant.accountId}}</p></a>
                </div>
            </div>
</template>

<script>
import APIService from '@/service/APIService';
import router from '@/router';

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
      },
      viewApplicantDetails(id) {
          router.push({ name: 'applicantinfo', params: { applicantId: id } })
      }
  },
  created() {
          this.getApplicants();
  }
};
</script>

<style scoped>
        .list {
            flex-basis: 70%;
        }
        
        .list>h1 {
            font-family: 'Playfair Display', serif;
            font-style: italic;
            font-size: 2.3em;
            margin: 5px 0px 20px -15px;
        }
        
        .row:nth-of-type(even) {
            background-color: #DAC3D1;
        }
        
        .row>a>p, .row>p {
            display: inline-block;
            font-size: 1.2em;
            width: 24%;
            margin: auto;
            padding: 4px;
        }
        
        .row>.title {
            font-size: 1.2em;
            text-transform: uppercase;
        }
        
        .list hr {
            border-top: 1px solid #792359;
            margin: 10px 0px 15px 0px;
        }
</style>
