<template>
  <div id="main">
    <application-details v-bind:applicationdata="application" v-bind:isInEditMode="isEditMode" />
    <applicant-details v-bind:applicationdata="application" v-bind:isInEditMode="isEditMode" v-on:toggle-edit-mode="edit" />
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
        application: null,
        isEditMode: false
    }
        
  },
  methods: { 
      showApplicant(applicantId) {
          APIService.getById(applicantId).then(application => this.application = application);
      },
      edit() {
            this.isEditMode = !this.isEditMode;
        }
  },
  created() {
      this.showApplicant(this.$route.params.applicantId);
  }
};
</script>

<style scoped>
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