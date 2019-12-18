<template>
  <div id="main">
    <!-- <splash-crystal-lake v-show="isCampCrystalLake()" class="splash"/>
    <splash-anawanna v-show="isCampAnawanna()" class="splash"/>
    <splash-north-star v-show="isCampNorthStar()" class="splash"/> -->
    <camp-splash v-bind:imgurl="splash" />
    <div class="row">
        <p>{{camp.name}}</p>
        <p>{{camp.location}}</p>
        <p>{{camp.description}}</p>
        <p>Next Session: {{camp.dateRange}}</p>
        <p>Ages: {{camp.minAge}} - {{camp.maxAge}}</p>
        <p>Total Capacity: {{camp.capacity}}</p>
        <div class="camp-img">
            <img :src="camp.image"/>
        </div>
        <registration-metrics v-bind:campers="camp"/>
        <camp-attendees v-bind:attendees="camp.attendees" v-show="isAdmin()" />
    </div>
  </div>
</template>

<script>
import CampAttendees from '@/components/CampAttendees.vue'
import RegistrationMetrics from '@/components/RegistrationMetrics.vue'
// import SplashCrystalLake from '@/components/CampSplashCrystalLake.vue'
// import SplashNorthStar from '@/components/CampSplashNorthStar.vue'
// import SplashAnawanna from '@/components/CampSplashAnawanna.vue'
import CampSplash from '@/components/CampSplash.vue'
import auth from '../auth'


export default {
  name: 'camp-details',
  components: {
    //   SplashCrystalLake,
    //   SplashNorthStar,
    //   SplashAnawanna,
      CampSplash,
      CampAttendees,
      RegistrationMetrics
  },
  data() {
    return {
        camp: {},
        user: {},
        splash: 'http://localhost:8081/camp-north-star-splash.jpg'
    } 
  },
  methods: {
      isAdmin() {
          this.user = auth.getUser();
          if(auth.getUser().rol == 'admin') {
              return true;
          } else {
              return false;
          }
      },
      isCampNorthStar() {
          console.log('CAMP: ' + this.camp.campId);
          if(this.camp.campId === 1) {
              return true;
          } else {
              return false;
          }
      },
      isCampCrystalLake() {
          if(this.camp.campId === 2) {
              return true;
          } else {
              return false;
          }
      },
      isCampAnawanna() {
          if(this.camp.campId === 3) {
              return true;
          } else {
              return false;
          }
      }
  },
  created() {
      this.camp = this.$route.params.campdetailsdata;
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
        flex-wrap: nowrap;
        justify-content: stretch;
        align-items: stretch;
    }
    .row{
        flex-basis: 65%;
        flex-grow: 0;
        flex-shrink: 0;
        justify-content: center;
        text-align: center;
    }
    .splash{
        flex-basis: 35%;
        flex-grow: 0;
        flex-shrink: 0;
    }
    .camp-image {
        display: block;
        max-height: 20%;
        max-width: 30%;
        overflow: hidden;
    }
    .camp-image > img {
        object-fit: cover;
    }
    .button button{
        font-size: 20px;
        border-radius: 20px;
        width: 6%;
        background-color:#112F40;
        color: white;
        padding: 3px;
    }