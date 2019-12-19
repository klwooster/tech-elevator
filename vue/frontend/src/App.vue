<template>
  <div id="app">
    <div id="test">
      <navigation/>
    </div>
    <router-view/>
  </div>
</template>

<script>
import Navigation from '@/components/Navigation.vue';

export default {
  name: 'app',
  components: {
    Navigation
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