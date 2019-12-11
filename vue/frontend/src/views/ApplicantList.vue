<template>
  <div id="main">
      <applicant-filters/>
      <applicant-table/>
  </div>
</template>

<script>
import ApplicantTable from '@/components/ApplicantTable.vue';
import ApplicantFilters from '@/components/ApplicantFilters.vue';

export default {
  name: 'applicant-list',
  components: {
      ApplicantTable,
      ApplicantFilters
  },
  data() {
      return {
          //apiurl: 'http://localhost:8080/AuthenticationApplication/api/applicants'
      }
  },
  methods: { }
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
