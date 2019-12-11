<template>
  <div id="app">
    <navigation/>
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
            display: flex;
            flex-direction: column;
            flex-wrap: nowrap;
            align-items: stretch;
            justify-content: stretch;
            font-size: 16px;
        }
</style>