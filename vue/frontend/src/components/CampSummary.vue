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
                 maxWidth: '90%',
                 borderRadius: '4px'
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
        margin-top: -20px;
    }
    .row > a:link,
    .row > a:visited {
        text-decoration: none;
    }
    .row > .camp-name:hover {
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
    button {
            margin-left: auto;
            margin-right: auto;
            margin-top: 10px;
            margin-bottom: 10px;
            display: block;
            width: 60%;
            border-radius: 4px;
            border: 1px solid #DAC3D1;
            background-color: #792359;
            color: #ffffff;
            font-size: 1.5em;
            text-transform: uppercase;
            padding: 0px 15px 0px 15px;
            box-shadow: 0px 0px 5px 1px darkgray;
        }
    
    .button > *, .button a {
        text-decoration: none;
    }
</style>