<template>
  <div id="main">
    <application-details v-bind:applicationdata="application" />
    <applicant-details v-bind:applicationdata="application" />
  </div>
</template>

<script>
import APIService from '@/service/APIService';
import ApplicationDetails from '@/components/ApplicationDetails.vue'
import ApplicantDetails from '@/components/ApplicantDetails.vue'

export default {
  name: 'applicant-info',
  components: {
    ApplicationDetails,
    ApplicantDetails
  },
  data() {
    return {
        application: null
    }
        
  },
  methods: { 
      showApplicant(applicantId) {
          APIService.getById(applicantId).then(application => this.application = application);
      },

      updateApplication() {
        APIService.updateApplication(applicantId)
        .then(response => {
          if(response.ok) {
            console.log('Save was successful');
          }
        })
      }

  },
  created() {
      this.showApplicant(this.$route.params.applicantId);
  }
};
</script>

<style>
   #main {
            flex-basis: 85%;
            width: 85%;
            flex-shrink: 0;
            flex-grow: 0;
            padding: 20px 0px 20px 0px;
            margin-left: auto;
            margin-right: auto;
            display: flex;
            flex-direction: row;
            flex-wrap: wrap;
            justify-content: space-between;
        }
</style>