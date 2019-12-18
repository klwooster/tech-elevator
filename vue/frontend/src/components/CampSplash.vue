<template>
    <div v-bind:class="classToBind" ></div>
</template>

<script>
export default {
    name: 'camp-splash',
    props: ['classToBind']
}
</script>

<style scoped>
    .splash-north-star,
    .splash-crystal-lake,
    .splash-anawanna  {
        flex-basis: 35%;
        flex-grow: 0;
        flex-shrink: 0;
        background-repeat: norepeat;
        background-attachment: fixed;
        background-position: top left;
        background-size: cover;
    }
    .splash-crystal-lake {
        background-image: url("https://http://localhost:8081/camp-north-star-splash.jpg");
    }
    .splash-anawanna {
        background-image: url("https://http://localhost:8081/camp-north-star-splash.jpg");
    }
    .splash-north-star  {
        background-image: url("https://http://localhost:8081/camp-north-star-splash.jpg");
    }
</style>