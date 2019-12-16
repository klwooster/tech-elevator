<template>
  <div id="main">
    <div class="row">
        <p>{{name}}</p>
        <p>{{location}}</p>
        <p>{{date}}</p>
        <p>{{ageRange}}</p>
        <p>{{description}}</p>
        <div class="camp-img">
            <img :src="image"/>
        </div>
        <camp-attendees v-bind:campName="name" />
    </div>
  </div>
</template>

<script>
import CampAttendees from '@/components/CampAttendees.vue'

export default {
  name: 'camp-details',
  data() {
    return {
        name: '',
        image: '',
        location: '',
        date: '',
        ageRange: '',
        description: ''
    } 
  },
  methods: {
      
  },
  created() {
      this.name = this.$route.params.campName;
      this.image = this.$route.params.image;
      this.location = this.$route.params.location;
      this.date = this.$route.params.date;
      this.ageRange = this.$route.params.ageRange;
      this.description = this.$route.params.description;
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