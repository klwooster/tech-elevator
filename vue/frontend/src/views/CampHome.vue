<template>
  <div id="main">
    <div v-for="camp in camps" v-bind:key="camp.campId" style="width: 30%; display: inline-block">
        <camp-summary v-bind:campdata="camp" />
    </div>
    <!-- <camp-chart v-bind:data-to-render="chartData"/> -->

    <!-- <total-registration-metrics v-bind:allcamps="camps"/> -->
  </div>
</template>

<script>
import APIService from '@/service/APIService';
//import TotalRegistrationMetrics from '@/components/TotalRegistrationMetrics.vue'
// import CampChart from '@/components/CampChart.vue'
import CampSummary from '@/components/CampSummary.vue'

export default {
  name: 'camp-home',
  components: {
      CampSummary
  },
  data() {
    return {
        camps: [ ]
    //     chartData: {
    //         type: 'bar',
    //         data: {
    //             labels: [ 'Camp North Star', 'Camp Wanahockaloogi', 'Camp Anawanna' ],
    //             datasets: [
    //                 {
    //                     label: 'Total Enrolled in Camp',
    //                     backgroundColor: ['#EC7063','#EC7063','#EC7063'],
    //                     data: [
    //                         (this.campdata[0].totalCapacity - this.campdata[0].remainingSpaces),
    //                         (this.campdata[1].totalCapacity - this.campdata[1].remainingSpaces),
    //                         (this.campdata[2].totalCapacity - this.campdata[2].remainingSpaces)
    //                     ]
    //                 },
    //                 {
    //                     label: 'Remaining Spaces',
    //                     backgroundColor: ['#58D68D','#58D68D','#58D68D'],
    //                     data: [
    //                         (this.campdata[0].remainingSpaces),
    //                         (this.campdata[1].remainingSpaces),
    //                         (this.campdata[2].remainingSpaces)
    //                     ]
    //                 }
    //             ]
    //         },
    //         options: {
    //             scales: {
    //                 yAxes: [{
    //                     stacked: true,
    //                     ticks: {
    //                         beginAtZero: true
    //                     },
    //                     gridLines: {
    //                         display: true
    //                     }
    //                 }]
    //             },
    //             legend: {
    //                 display: false
    //             },
    //             responsive: true,
    //             maintainAspectRatio: false
    //         }
    //     }
    } 
  },
  methods: {
      getAllCamps() {
          APIService.getCamps().then(campData => this.camps = campData);
      }
  },
  created() {
      this.getAllCamps();
  }
};
</script>

<style scoped>
   #main {
        flex-basis: 85%;
        width: 85%;
        flex-shrink: 0;
        flex-grow: 0;
        /* padding: 20px 0px 20px 0px; */
        margin-left: auto;
        margin-right: auto;
    }
    
</style>