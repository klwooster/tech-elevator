<template>
  <div id="main">
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
        <camp-attendees v-bind:attendees="camp.attendees" />
    </div>
  </div>
</template>

<script>
import CampAttendees from '@/components/CampAttendees.vue'

export default {
  name: 'camp-details',
  components: {
      CampAttendees
  },
  data() {
    return {
        camp:{}
    } 
  },
  methods: {
      
  },
  created() {
      this.camp = this.$route.params.campdata;
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