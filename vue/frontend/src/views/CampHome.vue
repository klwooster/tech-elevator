<template>
  <div id="main">
      <div id="first-panel">
                <div id="splash-text">
                    "Welcome! Thanks for stopping by to check out all of the amazing summer camps we put on each year! We offer three different summer camps that cater to different age groups, so we hope you find one that suits you! Each summer camp offers endless activities, state-of-the-art lodging, trained and skilled staff, and immaculate views of the gorgeous surrounding landscapes. Whether you're a child looking for a summer filled with fun and adventure or an adult looking for the perfect mix of relaxation AND excitement, we have the perfect getaway for you. Check out our three camps below, we know you'll love what you see."
                </div>
            <div id="arrowlink">
                    <i class="fas fa-angle-down fa-7x" @click="scrollMeTo('summer-camp-overview')"></i>
            </div>
      </div>
      <div class="panel" ref="summer-camp-overview">
        <h1>Summer Camps in 2020</h1>
        <div v-for="camp in camps" v-bind:key="camp.campId" style="width: 33.3%; padding:0px 10px 10px 10px; display: inline-block">
            <camp-summary v-bind:campdata="camp" />
        </div>
            <i class="fas fa-angle-double-up fa-lg" v-on:click="refreshHome()" v-show="!isTop"></i>
      </div>
    <!-- <camp-chart v-bind:data-to-render="chartData"/> -->
    <!-- <total-registration-metrics v-bind:allcamps="camps"/> -->
  </div>
</template>

<script>
import APIService from '@/service/APIService';
import CampSummary from '@/components/CampSummary.vue';
import router from '@/router';

export default {
  name: 'camp-home',
  components: {
      CampSummary
  },
  data() {
    return {
        camps: [ ],
        isTop: true
    } 
  },
  methods: {
        getAllCamps() {
            APIService.getCamps().then(campData => this.camps = campData);
        },
        scrollMeTo(refName) {
            var element = this.$refs[refName];
            var top = element.offsetTop;
            this.isTop = !this.isTop;
            window.scrollTo(0, top);
        },
        refreshHome() {
            this.$forceUpdate();
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
        flex-shrink: 0;
        flex-grow: 0;
    }
    .panel {
        min-height: 100vh;
        min-width: 85%;
        max-width: 85%;
        margin-left: auto;
        margin-right: auto;
    }

    .panel > h1 {
        font-family: 'Playfair Display', serif;
        font-size: 3em;
        padding: 6% 0px 10px 10px;
        border-bottom: 2px solid #c9d750;
    }

    #first-panel {
        min-height: 100vh;
        min-width: 100%;
        max-width: 100%;
        margin-left: auto;
        margin-right: auto;
        background-image: url("http://localhost:8081/welcome.jpg");
        background-repeat: no-repeat;
        background-attachment: fixed;
        background-position: top left;
        background-size: cover;
        padding-top: 10%;
    }

    #splash-text {
        background-color: rgba(255, 255, 255, 0.5);
        width: 55%;
        height: 45%;
        margin-left: auto;
        margin-right: auto;
        margin-top: auto;
        margin-bottom: auto;
        padding: 20px;
        font-size: 25px;
        font-weight: 400;
        color: #000000;
        border-radius: 4px;
    }

    #arrowlink {
        height:6%;
        width:10%;
        margin-left: auto;
        margin-right: auto;
    }

    #arrowlink > i {
        color: white;
    }

    .panel > i {
        position: fixed;
        right: 50px;
        bottom: 50px;
        color: darkgray;
    }
</style>