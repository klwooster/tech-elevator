<template>
  <div class="chart">
    <h1>Current Session Enrollment</h1>
    <pie-chart :data="chartData" :options="chartOptions"></pie-chart>
  </div>
</template>

<script>
import PieChart from "./PieChart.js";

export default {
  name: "registration-metrics",
  props: ['campers'],
  components: {
    PieChart
  },
  data() {
    return {
      chartOptions: {
        hoverBorderWidth: 20
      },
      chartData: {
        hoverBackgroundColor: "red",
        hoverBorderWidth: 10,
        labels: [ "Total Enrolled", "Remaining Spaces Available"],
        datasets: [
          {
            label: "Registration",
            backgroundColor: ["#792359","#DAC3D1"],
            data: [(this.campers.totalCapacity - this.campers.remainingSpaces), this.campers.remainingSpaces]
          }
        ]
      }
    };
  }
};
</script>

<style scoped>
  .chart {
    margin-left: 15%;
    margin-right: auto;
    text-align: center;
  }
  h1 {
    font-size: 1.3em;
            font-family: 'Playfair Display', serif;
  }
</style>
