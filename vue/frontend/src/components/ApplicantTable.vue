<template>
            <div class="list">
                <h1>Applicants</h1>
                <div class="row">
                    <p class="title">Applicant ID</p>
                    <p class="title">First Name</p>
                    <p class="title">Last Name</p>
                    <p class="title">Account #</p>
                </div>
                <hr>
                <div class="row" v-for="applicant in applicants" :key="applicant.personId">
                    <p>{{applicant.personId}}</p>
                    <p>{{applicant.firstName}}</p>
                    <p>{{applicant.lastName}}</p>
                    <p>{{applicant.accountId}}</p>
                </div>
            </div>
</template>

<script>
export default {
  name: 'applicant-table',
//   props: {
//       api_url: String
//   },
  data() {
    return {
        applicants: [],
        api_url: 'http://localhost:8080/AuthenticationApplication/api/applicants'
        /*moved the api link here instead of ApplicantList because the browser was showing the api_url as undefinied*/
    };
  },
  methods: { 
      showApplicants() {
          console.log('getting ready to get applicants');
          fetch(this.api_url)
          .then(response => response.json())
          .then(data => (this.applicants = data))
          .catch(err => console.error(err));
      },

      
  },
  created() {
          this.showApplicants();
  }
};
</script>

<style>
        .list {
            flex-basis: 70%;
        }
        
        .list>h1 {
            font-family: 'Playfair Display', serif;
            font-style: italic;
            font-size: 2.3em;
            margin: 5px 0px 20px -15px;
        }
        
        .row:nth-of-type(even) {
            background-color: #DAC3D1;
        }
        
        .row>p {
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
