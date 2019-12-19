<template>
  <div id="main">
        <camp-splash v-bind:classToBind="camp.splashClass" />
        <div class="row">
                <p class="camp-name">{{camp.name}}</p>
                <p class="about">{{camp.about}}</p>
                <p>Where: {{camp.location}}</p>
                <p>Next Session: {{camp.dateRange}}</p>
                <p>Ages: {{camp.minAge}} - {{camp.maxAge}}</p>
                <p>Total Capacity: {{camp.totalCapacity}}</p>
            <div class="data">
                <div class="charts">
                    <registration-metrics v-bind:campers="camp" />
                </div>
                <div class="attendees">
                    <camp-attendees v-bind:attendees="camp.attendees" v-show="isAdmin()" />
                </div>
            </div>
        </div>
  </div>
</template>

<script>
import CampAttendees from '@/components/CampAttendees.vue'
import RegistrationMetrics from '@/components/RegistrationMetrics.vue'
import CampSplash from '@/components/CampSplash.vue'
import auth from '../auth'


export default {
  name: 'camp-details',
  components: {
      CampSplash,
      CampAttendees,
      RegistrationMetrics
  },
  data() {
    return {
        camp: {},
        user: {}
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
      }
  },
  created() {
      this.camp = this.$route.params.campdetailsdata;
  }
};
</script>

<style scoped>
   #main {
        flex-basis: 100%;
        flex-shrink: 0;
        flex-grow: 0;
            /* padding: 5% 0px 20px 0px; */
        margin: 0;
    }
    .row{
        width: 60%;
        display: inline-block;
        margin-left: 38%;
        vertical-align: top;
        padding-top: 4%;
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
    .data {
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        align-items: stretch;
    }
    .charts,
    .attendees {
        flex-basis: 45%;
    }
    #main .splash-anawanna,
    #main .splash-crystal-lake,
    #main .splash-north-star {
        position: fixed;
        z-index: -1;
    }
    .camp-name {
        font-size: 32px;
            font-family: 'Playfair Display', serif;
    }
    .about{
        font-size: 20px;
    }
 </style>