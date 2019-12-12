<template>
    <div id="applicant-table" class="list">
        <div class="row" v-for="applicant in applicantsFiltered" :key="applicant.personId" v-on:click="viewApplicantDetails(applicant.personId)">
            <a href="#"><p>{{applicant.personId}}</p>
            <p>{{applicant.firstName}}</p>
            <p>{{applicant.lastName}}</p>
            <p>{{applicant.accountId}}</p></a>
        </div>
    </div>
</template>

<script>
import router from '@/router';

export default {
  name: 'applicant-table',
  props: [ 'applicants', 'filterProperties' ],

  methods: { 
      viewApplicantDetails(id) {
          router.push({ name: 'applicantinfo', params: { applicantId: id } })
      },
      sortList() {
          if(this.filterProperties.sortTarget == 'applicantId') {
              this.applicants = this.sortByApplicantId();
          } else if(this.filterProperties.sortTarget == 'firstName') {
              this.applicants = this.sortByFirstName();
          } else if(this.filterProperties.sortTarget == 'lastName') {
              this.applicants = this.sortByLastName();
          } else if(this.filterProperties.sortTarget == 'accountId') {
              this.applicants = this.sortByAccountId();
          } else {
              this.applicants = this.applicants;
          }

          if(!this.filterProperties.sortAsc) {
              this.applicants.reverse();
          }
      },
      sortByApplicantId() {
          return this.applicants.sort((a, b) => {
                  if(a.applicantId > b.applicantId) {
                      return -1;
                  } else if (b.applicantId > a.applicantId) {
                      return 1;
                  } else {
                      return 0;
                  }
              })
      },
      sortByFirstName() {
          return this.applicants.sort((a, b) => {
                  if(String(a.firstName) > String(b.firstName)) {
                      return -1;
                  } else if (String(b.firstName) > String(a.firstName)) {
                      return 1;
                  } else {
                      return 0;
                  }
              })
      },
      sortByLastName() {
          return this.applicants.sort((a, b) => {
                  if(String(a.lastName) > String(b.lastName)) {
                      return -1;
                  } else if (String(b.lastName) > String(a.lastName)) {
                      return 1;
                  } else {
                      return 0;
                  }
              })
      },
      sortByAccountId() {
          return this.applicants.sort((a, b) => {
                  if(String(a.accountId) > String(b.accountId)) {
                      return -1;
                  } else if (String(b.accountId) > String(a.accountId)) {
                      return 1;
                  } else {
                      return 0;
                  }
              })
      }
  },
   computed: {
      applicantsFiltered() {
          this.sortList();
          if (this.filterProperties.filterData == '') {
                return this.applicants;
          } else if (this.filterProperties.filterType == 'applicantId') {
                return this.applicants.filter(applicant => 
                    String(applicant.personId).toLowerCase().startsWith(this.filterProperties.filterData.toLowerCase))
          } else if (this.filterProperties.filterType == 'firstName') {
                return this.applicants.filter(applicant => 
                    String(applicant.firstName).toLowerCase().startsWith(this.filterProperties.filterData.toLowerCase()))
          } else if (this.filterProperties.filterType == 'lastName') {
                return this.applicants.filter(applicant => 
                    String(applicant.lastName).toLowerCase().startsWith(this.filterProperties.filterData.toLowerCase))
          } else if (this.filterProperties.filterType == 'accountId') {
                return this.applicants.filter(applicant => 
                    String(applicant.accountId).toLowerCase().startsWith(this.filterProperties.filterData.toLowerCase))
          } else {
              return this.applicants;
          }
      }
   }
};
</script>

<style scoped>
        .list {
            flex-basis: 100%;
        }
        .list>h1 {
            font-family: 'Playfair Display', serif;
            font-style: italic;
            font-size: 2.3em;
            margin: 5px 0px 20px -15px;
        }
        
        .row:nth-of-type(odd) {
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
