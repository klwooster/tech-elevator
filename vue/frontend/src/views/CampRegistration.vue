<template>
  <div id="main">
    <application-details v-bind:applicationdata="application" v-bind:isInEditMode="isEditMode" />
    <applicant-details v-bind:isNewApp="true" v-on:create-application="submitApplication" v-bind:applicationdata="application" v-bind:isInEditMode="isEditMode"/>
  </div>
</template>

<script>
import APIService from '@/service/APIService';
import ApplicationDetails from '@/components/ApplicationDetails.vue'
import ApplicantDetails from '@/components/ApplicantDetails.vue'
import router from '@/router';

export default {
  name: 'camp-registration',
  components: {
    ApplicationDetails,
    ApplicantDetails
  },
  data() {
    return {
        isEditMode: true,
        application: {
            applicationId: "",
            applicantId: "",
            accountId: "",
            guardianId: "",
            emergencyContactId: "",
            dietaryPreference: "",
            dietaryRestrictions: "",
            mobilityIssues: "",
            medicalConcerns: "",
            mealPlan: "",
            program: "",
            dormAssignment: "",
            tshirtSize: "",
            applicant: {
                personId: "",
                firstName: "",
                lastName: "",
                preferredName: "",
                dateOfBirth: "",
                email: "",
                phone: "",
                accountId: ""
            },
            guardian: {
                personId: "",
                firstName: "",
                lastName: "",
                preferredName: "",
                dateOfBirth: "",
                email: "",
                phone: "",
                accountId: ""
            },
            emergencyContact: {
                personId: "",
                firstName: "",
                lastName: "",
                preferredName: "",
                dateOfBirth: "",
                email: "",
                phone: "",
                accountId: ""
            }
        },
      responseObject: ""
    }
        
  },
  methods: { 
    submitApplication () {
        APIService.createApplication(this.application)
        .then(response => response.json())
        .then(result => {
            this.responseObject = result;
            console.log('Creation was successful' + this.responseObject);
            router.push({ name: 'camphome'});
          })
        .catch(err => console.error(err))
    }
  }
};
</script>

<style scoped>
   #main {
            flex-basis: 85%;
            width: 85%;
            flex-shrink: 0;
            flex-grow: 0;
            padding: 5% 0px 20px 0px;
            margin-left: auto;
            margin-right: auto;
            display: flex;
            flex-direction: row;
            flex-wrap: wrap;
            justify-content: space-between;
        }
</style>