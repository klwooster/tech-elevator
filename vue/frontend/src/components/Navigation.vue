<template>
    <header>
        <nav>
            <ul>
                <li>
                    <i class="fas fa-campground transparent"></i>
                    <router-link v-bind:to="{name: 'home'}">Dashboard</router-link>
                </li>
                <li>
                    <i class="fas fa-campground transparent"></i> 
                    <router-link v-bind:to="{name: 'applicantlist'}">Applicants</router-link>
                </li>
                <!-- <li>
                    <i class="fas fa-campground transparent"></i> 
                    Communication Center
                </li>
                <li>
                    <i class="fas fa-campground transparent"></i> 
                    Invoicing
                </li> -->
            </ul>
        </nav>
    </header>
</template>

<script>
export default {
    name: 'navigation'
}
</script>

<style>
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
        
        #selected,
        #selected i,
        li:hover,
        li:hover i {
            background: #792359 !important;
            color: #ffffff !important;
        }
</style>