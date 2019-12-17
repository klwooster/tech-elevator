<template>
  <div id="main">
    <div class="row" v-for="camp in camps" v-bind:key="camp.campId">
         <p> <router-link v-bind:to="{name: 'campdetails', params:{campdata: camp}} ">
            {{camp.name}}</router-link></p>
        <div class="camp-img" >
            <img :src="camp.image"/>
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
  </div>
</template>

<script>
import APIService from '@/service/APIService';

export default {
  name: 'camp-home',
  data() {
    return {
        camps: [ ]
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
</style>