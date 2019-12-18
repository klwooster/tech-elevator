<template>
  <div id="main">
    <application-details v-bind:applicationdata="application" v-bind:isInEditMode="isEditMode" />
    <applicant-details v-bind:applicationdata="application" v-bind:isInEditMode="isEditMode" v-on:toggle-edit-mode="edit" v-on:save-changes="updateApplication" v-on:discard-changes="edit"/>
    <application-notes v-bind:allnotes="application" v-show="isAdmin()"/>
    <div>
      <router-link v-bind:to="{name: 'applicationhistory', params: {id: application.applicationId}}">
        <button>View History</button> 
      </router-link>
    </div>
  </div>
  
</template>

<script>
import auth from '../auth'
import APIService from '@/service/APIService';
import ApplicationDetails from '@/components/ApplicationDetails.vue'
import ApplicantDetails from '@/components/ApplicantDetails.vue'
import ApplicationNotes from '@/components/ApplicationNotes.vue'

export default {
  name: 'applicant-info',
  components: {
    ApplicationDetails,
    ApplicantDetails,
    ApplicationNotes
  },
  data() {
    return {
        application: {},
        isEditMode: false
        // applicationId: ''
    }
        
  },
  methods: { 
    isAdmin() {
            this.user = auth.getUser();
            if(auth.getUser().rol == 'admin') {
                return true;
            } else {
                return false;
            }
        },
      showApplicant(applicantId) {
          APIService.getById(applicantId).then(application => {
            this.application = application;
          });
          
      },
      edit() {
            this.isEditMode = !this.isEditMode;
      },
      updateApplication() {
        APIService.updateApplication(this.application, this.application.applicant.applicantId)
        .then(response => response.json())
        .then(result => {
            console.log('Save was successful');
            this.edit();
        })
        .catch(err => console.error(err));
      },
      getApplicationId() {
        return this.application.applicationId;
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