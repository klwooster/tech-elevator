<template>
  <div id="main">
    <application-details applicationdata="application" />
    <applicant-details applicationdata="application" />
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
      }
  },
  created() {
          this.showApplicant();
  }
};
</script>

<style>
   
</style>