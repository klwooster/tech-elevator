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
import { isNullOrUndefined } from 'util';

export default {
  name: 'applicant-table',
  props: [ 'applicants', 'currentfilter' ],
  methods: { 
      viewApplicantDetails(id) {
          router.push({ name: 'applicantinfo', params: { applicantId: id } })
      },
      sortList() {
          if(this.currentfilter.sortTarget == 'applicantId') {
              this.applicants = this.sortByApplicantId();
          } else if(this.currentfilter.sortTarget == 'firstName') {
              this.applicants = this.sortByFirstName();
          } else if(this.currentfilter.sortTarget == 'lastName') {
              this.applicants = this.sortByLastName();
          } else if(this.currentfilter.sortTarget == 'accountId') {
              this.applicants = this.sortByAccountId();
          } else {
              return;
          }

          if(!this.currentfilter.sortAsc) {
              this.applicants.reverse();
          }
      },
      sortByApplicantId() {
              return this.applicants.sort((a, b) => {
                  if(parseInt(a.applicantId) > parseInt(b.applicantId)) {
                      return -1;
                  } else if (parseInt(b.applicantId) > parseInt(a.applicantId)) {
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
                  if(parseInt(a.accountId) > parseInt(b.accountId)) {
                      return -1;
                  } else if (parseInt(b.accountId) > parseInt(a.accountId)) {
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
          if (this.currentfilter.filterData == isNullOrUndefined || this.currentfilter.filterData == '' ) {
                return this.applicants;
          } else if (this.currentfilter.filterType === 'applicantId') {
                return this.applicants.filter(applicant => 
                    String(applicant.personId).toLowerCase().startsWith(this.currentfilter.filterData.toLowerCase()))
          } else if (this.currentfilter.filterType === 'firstName') {
                return this.applicants.filter(applicant => 
                    String(applicant.firstName).toLowerCase().startsWith(this.currentfilter.filterData.toLowerCase()))
          } else if (this.currentfilter.filterType === 'lastName') {
                return this.applicants.filter(applicant => 
                    String(applicant.lastName).toLowerCase().startsWith(this.currentfilter.filterData.toLowerCase()))
          } else if (this.currentfilter.filterType === 'accountId') {
                return this.applicants.filter(applicant => 
                    String(applicant.accountId).toLowerCase().startsWith(this.currentfilter.filterData.toLowerCase()))
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
        
        .row {
            border-radius:4px;
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
