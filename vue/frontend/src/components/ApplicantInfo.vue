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
          <span class="applicant-data">{{application.applicationId}}</span>
          <span class="applicant-data">{{application.applicantId}}</span>
          <span class="applicant-data">{{application.accountId}}</span>
          <span class="applicant-data">{{application.guardianId}}</span>
          <span class="applicant-data">{{application.emergencyContactId}}</span>
          <span class="applicant-data">{{application.dietaryPreference}}</span>
          <span class="applicant-data">{{application.dietaryRestrictions}}</span>
          <span class="applicant-data">{{application.mobilityIssues}}</span>
          <span class="applicant-data">{{application.medicalConcerns}}</span>
          <span class="applicant-data">{{application.mealPlan}}</span>
          <span class="applicant-data">{{application.program}}</span>
          <span class="applicant-data">{{application.dormAssignment}}</span>
          <span class="applicant-data">{{application.tshirtSize}}</span>
          <span class="applicant-data">{{application.applicant.firstName}}</span>
          <span class="applicant-data">{{application.applicant.lastName}}</span>
          <span class="applicant-data">{{application.applicant.email}}</span>
          <span class="applicant-data">{{application.applicant.phone}}</span>
          <span class="applicant-data">{{application.guardian.firstName}}</span>
          <span class="applicant-data">{{application.guardian.lastName}}</span>
          <span class="applicant-data">{{application.emergencyContact.firstName}}</span>
          <span class="applicant-data">{{application.emergencyContact.lastName}}</span>
          <span class="applicant-data">{{application.emergencyContact.phone}}</span>
          <!-- <span class="applicant-data">{{application.notes.}}</span> -->
      </div>
  </div>
</template>

<script>
import APIService from '@/service/APIService';


export default {
  name: 'applicant-info',

  data() {
    return {
        application: null
    }
        
  },
  methods: { 
      showApplicant() {
          APIService.getById(applicantId).then(application => this.application = application);
      },

      
  },
  created() {
          this.showApplicant();
  }
};
</script>

<style>
   
</style>