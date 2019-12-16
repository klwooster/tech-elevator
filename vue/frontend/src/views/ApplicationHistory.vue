<template>
  <div id="main">
    <div v-for="history in historyData" v-bind:key="history.historyId">
      <history-details v-bind:historyrecord="history"/>
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
historyData: [{
historyId: "",
dateOfChange: "",
updateMadeById: "",
changesMadeToId: "",
updatesMade: [
{
historyId: "",
oldValue: "",
newValue: "",
dataElementChanged: ""
}]
}]
}
},
methods: { 
  showHistory(applicantId) {
    APIService.getHistoryById(applicantId)
    .then(historyrecord => this.historyrecord = historyrecord); 
  }
},
created() {
  this.showHistory(this.$route.params.applicationId);
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