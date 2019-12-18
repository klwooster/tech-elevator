<template>
    <header>
        <nav>
            <ul>
                <router-link tag="li" active-class="selected" v-bind:to="{name: 'camphome'}">
                    <i class="fas fa-campground transparent"></i> Home
                </router-link>
                <!-- <router-link tag="li" active-class="selected" v-bind:to="{name: 'home'}" exact>
                    <i class="fas fa-campground transparent"></i> Dashboard
                </router-link> -->
                <router-link tag="li" active-class="selected" v-bind:to="{name: 'campregistration'}">
                    <i class="fas fa-campground transparent"></i> Register Now!
                </router-link>
                <router-link tag="li" active-class="selected" v-bind:to="{name: 'applicantlist'}">
                    <i class="fas fa-campground transparent"></i> View Applicants
                </router-link>
                <router-link tag="li" active-class="selected" v-bind:to="{name: 'login'}">
                    <i class="fas fa-campground transparent"></i> Log In
                </router-link>
            </ul>
        </nav>
    </header>
</template>

<script>
export default {
    name: 'navigation'
}
</script>

<style scoped>
        header {
            flex-basis: 15%;
            flex-grow: 0;
            flex-shrink: 0;
            display: flex;
            flex-direction: row;
            flex-wrap: wrap;
        }

        nav {
            flex-basis: 100%;
            flex-shrink: 0;
            flex-grow: 0;
            display: flex;
            flex-direction: row;
            justify-content: center;
            background: #112F40;
        }
        
        nav ul {
            list-style-type: none;
            margin: 0px;
            width: 90%;
        }
        
        nav ul li {
            display: inline-block;
            font-size: 200%;
            text-transform: uppercase;
            color: #ffffff;
            padding: 10px 25px 10px 25px;
            margin: 0px;
            height: 100%;
            width: auto;
        }

        nav ul li a {
            color: #ffffff;
            text-decoration: none;
        }
        
        nav ul li i.transparent {
            display: inline-block;
            color: transparent;
        }
        
        nav ul li i {
            padding-right: 5px;
        }
        
        .selected,
        .selected i,
        li:hover,
        li:hover i {
            background: #792359 !important;
            color: #ffffff !important;
        }
</style>