<template>
  <div id="main">
    <div class="row" v-for="camp in camps" v-bind:key="camp.name">
        <p>{{camp.name}}</p>
        <img :src="camp.image"/>
        <p>Location: {{camp.location}}</p>
        <p>When: {{camp.date}}</p>
        <p>Ages: {{camp.ageRange}}</p>
        <p>{{camp.description}}</p>
    </div>
    <div>
        <router-link v-bind:to="{name: 'campregistration'}">
            <button>Sign Up Now!</button>
        </router-link>
    </div>
  </div>
</template>

<script>

export default {
  name: 'camp-home',
  components: {

  },
  data() {
    return {
        camps: [
            {
                'name': 'Camp Wanankeekee',
                'location': 'Seattle, WA',
                'date': 'June 7th - July 2nd',
                'ageRange': '7-12',
                'description': 'A fun getaway for your kids to get out of your hair',
                'image': './best-family-summer-camp-canoeing.jpg'
            },
            {
                'name': 'Camp Wannahockaloogi',
                'location': 'Bend, OR',
                'date': 'July 10th - July 31st',
                'ageRange': '13-20',
                'description': 'A fun getaway for your teen/ young adult to buzz off to',
                'image': './webcover.jpg'
            },
            {
                'name': 'Camp Wanadrinkaton',
                'location': 'Portland, OR',
                'date': 'July 10th - July 31st',
                'ageRange': '21+',
                'description': 'A fun getaway for the grownups to have grownup time',
                'image': './Camp-grown-ups-MAIN.jpg'
            }
        ]
        

    }
        
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
</style>