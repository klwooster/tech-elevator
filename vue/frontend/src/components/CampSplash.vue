<template>
    <div v-bind:class="classToBind"> </div>
</template>

<script>
export default {
    name: 'camp-splash',
    props: ['classToBind']
}
</script>

<style scoped>
    .splash-crystal-lake {
        display: inline-block;
        background-image: url("http://localhost:8081/camp-crystal-lake-splash.jpg");
        min-height: 100vh;
        width: 35%;
        background-repeat: no-repeat;
        background-attachment: fixed;
        background-position: top left;
        background-size: contain;
    }
    .splash-anawanna {
        display: inline-block;
        background-image: url("http://localhost:8081/camp-anawanna-splash.jpg");
        min-height: 100vh;
        width: 35%;
        background-repeat: no-repeat;
        background-attachment: fixed;
        background-position: top left;
        background-size: contain;
    }
    .splash-north-star  {
        display: inline-block;
        background-image: url("http://localhost:8081/camp-north-star-splash.jpg");
        min-height: 100vh;
        width: 35%;
        background-repeat: no-repeat;
        background-attachment: fixed;
        background-position: top left;
        background-size: cover;
    }
</style>