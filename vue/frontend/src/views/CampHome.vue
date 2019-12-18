<template>
  <div id="main">
      <div id="first-panel">
                <div id="splash-text">
                    "At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat."
                </div>
            <div id="arrowlink">
                    <i class="fas fa-angle-down fa-7x" @click="scrollMeTo('summer-camp-overview')"></i>
            </div>
      </div>
      <div class="panel" ref="summer-camp-overview">
        <h1>Summer Camps in 2020</h1>
        <div v-for="camp in camps" v-bind:key="camp.campId" style="width: 33.3%; padding:10px; display: inline-block">
            <camp-summary v-bind:campdata="camp" />
        </div>
      </div>
    <!-- <camp-chart v-bind:data-to-render="chartData"/> -->
    <!-- <total-registration-metrics v-bind:allcamps="camps"/> -->
  </div>
</template>

<script>
import APIService from '@/service/APIService';
import CampSummary from '@/components/CampSummary.vue'

export default {
  name: 'camp-home',
  components: {
      CampSummary
  },
  data() {
    return {
        camps: [ ]
    } 
  },
  methods: {
        getAllCamps() {
            APIService.getCamps().then(campData => this.camps = campData);
        },
        scrollMeTo(refName) {
            var element = this.$refs[refName];
            var top = element.offsetTop;

            window.scrollTo(0, top);
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
        padding: 5% 0px 10px 10px;
        border-bottom: 2px solid #fb8124;
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
</style>