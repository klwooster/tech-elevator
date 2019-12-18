
<template>
    <canvas ref="chart"> </canvas>
</template>

<script>
import Chart from 'chart.js';

export default {
    name: 'camp-chart',
    props: [ 'dataToRender' ],
    methods: {
        createChart(chartData) {
            var chart = this.$refs.chart;
            var ctx = chart.getContext("2d");
            const myChart = new Chart(ctx, {
                type: this.dataToRender.type,
                data: this.dataToRender.data,
                options: this.dataToRender.options,
            });
        }
    },
    created() {
        this.createChart(this.dataToRender);
    }
}
</script>