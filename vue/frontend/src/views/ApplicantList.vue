<template>
  <div id="main">
      <applicant-filters v-bind:currentfilter="filters" />
      <applicant-table v-bind:applicants="applicantList" v-bind:currentfilter="filters"/>
  </div>
</template>

<script>
import ApplicantTable from '@/components/ApplicantTable.vue';
import ApplicantFilters from '@/components/ApplicantFilters.vue';
import APIService from '@/service/APIService';

export default {
  name: 'applicant-list',
  components: {
      ApplicantTable,
      ApplicantFilters
  },
  data() {
      return {
          applicantList: [],
          filters: {
              filterType: '',
              filterData: '',
              sortAsc: true,
              sortTarget: ''
          }
      }
  },
  methods: {
      getApplicants() {
          APIService.listApplicants().then(applicantData => this.applicantList = applicantData);
      },
      sort(evt) {
          console.log('EVENT VALUE: ' + evt);
          this.filters.sortAsc = !this.filters.sortAsc;
          this.filters.sortTarget = evt;
      }
   },
  created() {
          this.getApplicants();
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
