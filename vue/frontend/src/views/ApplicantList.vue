<template>
  <div>
      <applicant-table/>
  </div>
</template>

<script>
import ApplicantTable from '@/components/ApplicantTable.vue'

export default {
  name: 'applicant-list',
  components: {
      ApplicantTable
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
  
</style>
