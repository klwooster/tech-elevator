<template>
  <div id="main">
    <div class="panel">
      <h1>Application History - {{displayName}}</h1>
      <div v-for="(historyRec, key) in historyData" v-bind:key="historyRec.historyId">
        <hr v-if="key !== 0" style="border-top: 1px solid #792359;border-radius: 5px; width:95%;">
        <history-details v-bind:historyrecord="historyRec" source="Application"/>
      </div>
    </div>
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
            flex-basis: 85%;
            flex-shrink: 0;
            flex-grow: 0;
            /* padding: 5% 0px 20px 0px;
            margin-left: auto;
            margin-right: auto;
            display: flex;
            flex-direction: row;
            flex-wrap: wrap;
            justify-content: space-between; */
        }
    .panel {
        min-height: 100vh;
        min-width: 85%;
        max-width: 85%;
        margin-left: auto;
        margin-right: auto;
        /* padding-top: 10%; */
    }

    .panel > h1 {
        font-family: 'Playfair Display', serif;
        font-size: 3em;
        padding: 4% 0px 10px 10px;
        border-bottom: 2px solid #fb8124;
    }
</style>