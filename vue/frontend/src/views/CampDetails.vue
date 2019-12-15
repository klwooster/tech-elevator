<template>
  <div id="main">
    <div class="row">
        <p>{{camp.name}}</p>
        <div class="camp-img">
            <img :src="camp.image"/>
        </div>
        <p>Location: {{camp.location}}</p>
        <p>When: {{camp.date}}</p>
        <p>Ages: {{camp.ageRange}}</p>
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

export default {
  name: 'camp-details',
  data() {
    return {
        camp: null
    } 
  },
  methods: {
      
  },
  created() {
      this.$route.params.campName;
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