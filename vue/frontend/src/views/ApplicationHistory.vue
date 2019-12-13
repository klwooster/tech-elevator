<template>
  <div id="main">
    <div v-for="history in historyData" v-bind:key="history.historyId">

    <history-details v-bind:historyrecord="history"/>
    </div>
  </div>
</template>

<script>

import HistoryDetails from '@/components/HistoryDetails.vue'


export default {
name: 'application-history',
components: {
HistoryDetails
},
data() {
return {
historyData: [{
historyId: "1",
dateOfChange: "asa",
updateMadeById: "qwq",
changesMadeToId: "qwqw",
updatesMade: [
{
historyId: "1",
oldValue: "qwwq",
newValue: "qwqw",
dataElementChanged: "qwqw"
}]
}]
}
},
methods: { 

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