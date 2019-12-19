<template>
  <div id="main">
    <!-- <div class="panel"> -->
      <div class="title">
        <h1>Application History - </h1><h2>{{displayName}}</h2>
      </div>
      <div v-for="historyRec in historyData" v-bind:key="historyRec.historyId">
        <history-details v-bind:historyrecord="historyRec" source="Application"/>
      </div>
    <!-- </div> -->
  </div>
</template>

<script>
  import HistoryDetails from '@/components/HistoryDetails.vue'
  import APIService from '@/service/APIService';

  export default {
      name: 'application-history',
      components: {
        HistoryDetails
      },
      data() {
        return {
          historyData: [],
          displayName: ''
        }
      },
      methods: {
        showHistory(id) {
          console.log("Before Fetch");
          APIService.getHistoryById(id)
            .then(history => {
              this.historyData = history
              console.log("HISTORY: " + history);
              console.log("HISTORYDATA: " + this.historyData);
            });

          
        }
      },
      created() {
        this.showHistory(this.$route.params.id);
        this.displayName = this.$route.params.fname + ' ' + this.$route.params.lname;
      }
  }
</script>

<style scoped>
   #main {
            width: 85%;
            padding: 5% 0px 20px 0px;
            margin-left: auto;
            margin-right: auto;
        }
    .title {
        padding: 20px 0px 20px 10px;
        border-bottom: 2px solid #c9d750;
    }

    h1 {
        font-family: 'Playfair Display', serif;
        font-size: 2.3em;
        display: inline;
    }

    h2 {
        font-family: 'Playfair Display', serif;
        font-size: 1.9em;
        display: inline;
        /* color: #0b6e4f; */
    }

</style>