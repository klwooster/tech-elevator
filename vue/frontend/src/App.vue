<template>
  <div id="app">
    <div id="test">
      <navigation v-bind:user-status="checkStatus"/>
    </div>
    <router-view v-bind:user-status="checkStatus"/>
  </div>
</template>

<script>
import Navigation from '@/components/Navigation.vue';
import auth from './auth'

export default {
  name: 'app',
  components: {
    Navigation
  },
  data() {
    return {
      isLoggedIn: false
    }
  },
  computed: {
    checkStatus() {
      return auth.getUser();
    }
  }
}
</script>

<style>
         * {
            box-sizing: border-box;
            font-family: 'Open Sans Condensed', sans-serif;
            color: #112F40;
        }
        
        #app {
            margin: 0px;
            padding: 0px;
            font-size: 16px;
        }
        #test {
          position: fixed;
          width: 100%;
          box-shadow: 0px 2px 10px 1px darkgray;
        }
</style>