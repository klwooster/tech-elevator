<template>
  <div id="main">
    <div class="row" v-for="camp in camps" v-bind:key="camp.name">
         <p> <router-link v-bind:to="{name: 'campdetails', params:{camp:camps[0]}} ">
            {{camp.name}}</router-link></p>
        <div class="camp-img" >
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
  name: 'camp-home',
  data() {
    return {
        camps: [
            {
                'name': 'Camp Wanankeekee',
                'location': 'Seattle, WA',
                'date': 'June 7th - July 2nd',
                'ageRange': '7-12',
                'description': 'A fun getaway for your kids to get out of your hair',
                'image': '../best-family-summer-camp-canoeing.jpg'
            },
            {
                'name': 'Camp Wannahockaloogi',
                'location': 'Bend, OR',
                'date': 'July 10th - July 31st',
                'ageRange': '13-20',
                'description': 'A fun getaway for your teen/ young adult to buzz off to',
                'image': '../webcover.jpg'
            },
            {
                'name': 'Camp Wanadrinkaton',
                'location': 'Portland, OR',
                'date': 'July 10th - July 31st',
                'ageRange': '21+',
                'description': 'A fun getaway for the grownups to have grownup time',
                'image': '../Camp-grown-ups-MAIN.jpg'
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