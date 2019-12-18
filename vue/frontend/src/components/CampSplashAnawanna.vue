<template>
    <div class="camp-splash-img"></div>
</template>

<script>
export default {
    name: 'splash-anawanna'
}
</script>

<style scoped>
    .camp-splash-img {
        flex-basis: 35%;
        flex-grow: 0;
        flex-shrink: 0;
        background-image: url("http://localhost:8081/camp-anawanna-splash.jpg");
        background-repeat: norepeat;
        background-attachment: fixed;
        background-position: top left;
        background-size: cover;
    }
</style>