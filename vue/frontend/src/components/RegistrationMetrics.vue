<template>
  <div>
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
        labels: [ "Total Number of Campers", "Remaining Spaces Available"],
        datasets: [
          {
            label: "Registration",
            backgroundColor: ["#E46651", "#00D8FF"],
            data: [(this.campers.totalCapacity - this.campers.remainingSpaces), this.campers.remainingSpaces]
          }
        ]
      }
    };
  }
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
