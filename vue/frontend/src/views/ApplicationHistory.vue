<template>
  <div id="main">
    <div v-for="historyRec in historyData" v-bind:key="historyRec.historyId">
      <history-details v-bind:historyrecord="historyRec" source="Application"/>
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
          historyData: []
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
      }
  }
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