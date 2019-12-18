<template>
  <div>
    <bar-chart v-bind:a="alloptions" v-bind:b="alldata"/>
  </div>
</template>

<script>
import BarChart from "./BarChart.js";

export default {
  name: "total-registration-metrics",
  props: ['allcamps'],
  components: {
    BarChart
  },
  data() {
    return {
      alloptions: {
          scales: {
              yAxes: [{
                  stacked: true,
                  ticks: {
                      beginAtZero: true
                  },
                  gridLines: {
                      display: true
                  }
              }]
          },
          legend: {
              display: false
          },
          responsive: true,
          maintainAspectRatio: false
      },
      alldata: {
        labels: ['Camp North Star', 'Camp Wanahockaloogi', 'Camp Anawanna'],
        datasets: [
          {
            label: 'Total Enrolled',
            backgroundColor: '#EC7063',
            data: [
                (this.campdata[0].totalCapacity - this.campdata[0].remainingSpaces),
                (this.campdata[1].totalCapacity - this.campdata[1].remainingSpaces),
                (this.campdata[2].totalCapacity - this.campdata[2].remainingSpaces)
            ]
          },
          {
            label: 'Remaining Spaces',
            backgroundColor: '#58D68D',
            data: [
                (this.campdata[0].remainingSpaces),
                (this.campdata[1].remainingSpaces),
                (this.campdata[2].remainingSpaces)
            ]
          }
        ]
      }
    }
  }
}
</script>
