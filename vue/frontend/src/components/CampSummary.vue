<template>
    <div class="row">
        <a href="#"><router-link tag="p" class="camp-name" v-bind:to="{name: 'campdetails', params:{campdetailsdata: campdata}} ">
                    {{campdata.name}}</router-link></a>
            <div class="camp-img" >
                <img :src="campdata.image" :style="campImageStyle"/>
            </div>
            <p>Location: {{campdata.location}}</p>
            <p>When: {{campdata.dateRange}}</p>
            <p>Ages: {{campdata.minAge}} - {{campdata.maxAge}}</p>
            <p>Capacity: {{campdata.totalCapacity}}</p>
            <p>{{campdata.description}}</p>
            
            <div class="button">
                <router-link v-bind:to="{name: 'campregistration'}">
                    <button>Enroll</button>
                </router-link>
            </div>
    </div>
</template>

<script>
export default {
    name: 'camp-summary',
    props: ['campdata'],
    data() {
        return {
            campImageStyle: {
                 maxWidth: '90%'
            }
        }
    }
}
</script>

<style scoped>
    .row{
        width: 100%;
        min-height: 80%;
        max-height: 80%;
        display: inline-block;
        vertical-align: top;
        text-align: center;
        justify-content: center;
    }
    .row > a:link,
    .row > a:visited {
        text-decoration: none;
    }
    .row > a:hover {
        text-decoration: underline;
        color: #792359;
    }
    .camp-image {
        overflow: hidden;
        width: 60%;
        display: inline-block;
    }
    .camp-image > img {
        object-fit: cover;
    }
    .camp-name {
        font-size: 2em;
        font-family: 'Playfair Display', serif;
        /* font-style: italic; */
    }
    .button button{
        font-size: 20px;
        border-radius: 20px;
        background-color:#112F40;
        color: white;
        padding: 5px 10px 5px 10px;
    }
</style>