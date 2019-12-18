<template>
  <div id="main">
    <div class="row" v-for="camp in camps" v-bind:key="camp.campId">
         <p> <router-link v-bind:to="{name: 'campdetails', params:{campdata: camp}} ">
            {{camp.name}}</router-link></p>
        <div class="camp-img-div" >
            <img class="camp-img" :src="camp.image"/>
        </div>
        <p>Location: {{camp.location}}</p>
        <p>When: {{camp.dateRange}}</p>
        <p>Ages: {{camp.minAge}} - {{camp.maxAge}}</p>
        <p>Capacity: {{camp.capacity}}</p>
        <p>{{camp.description}}</p>
        
        <div class="button">
            <router-link v-bind:to="{name: 'campregistration'}">
                <button>Enroll</button>
            </router-link>
        </div>
    </div>
    <!-- <camp-chart v-bind:data-to-render="chartData"/> -->

    <!-- <total-registration-metrics v-bind:allcamps="camps"/> -->
  </div>
</template>

<script>
import APIService from '@/service/APIService';
//import TotalRegistrationMetrics from '@/components/TotalRegistrationMetrics.vue'
import CampChart from '@/components/CampChart.vue'

export default {
  name: 'camp-home',
  components: {
      CampChart
  },
  data() {
    return {
        camps: [ ],
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
        padding: 20px 0px 20px 0px;
        margin-left: auto;
        margin-right: auto;
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
        justify-content: space-between;
    }
    .row{
        justify-content: center;
        text-align: center;
        flex-basis: 25%;
        flex-shrink: 0;
        flex-grow: 0;
    }
    .camp-image {
        display: block;
        height: 20%;
        width: 30%;
    }
    .camp-image-div {
        object-fit: cover;
         overflow: hidden;
    }
    .button button{
        font-size: 20px;
        border-radius: 20px;
        background-color:#112F40;
        color: white;
        padding: 5px 10px 5px 10px;
    }
</style>