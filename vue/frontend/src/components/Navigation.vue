<template>
    <header>
        <nav>
            <ul>
                <router-link tag="li" active-class="selected" v-bind:to="{name: 'camphome'}" exact>
                    <i class="fas fa-campground transparent"></i> Home
                </router-link>
                <router-link tag="li" v-show="localStatus && !isAdmin()" active-class="selected" v-bind:to="{name: 'campregistration'}">
                    <i class="fas fa-campground transparent"></i> Enroll Now!
                </router-link>
                <router-link tag="li" v-show="localStatus && isAdmin()" active-class="selected" v-bind:to="{name: 'campregistration'}">
                    <i class="fas fa-campground transparent"></i> New Application
                </router-link>
                <router-link tag="li" v-show="localStatus && isAdmin()" active-class="selected" v-bind:to="{name: 'applicantlist'}">
                    <i class="fas fa-campground transparent"></i> View Applicants
                </router-link>
                <router-link tag="li" v-show="localStatus && !isAdmin()" active-class="selected" v-bind:to="{name: 'accounthistory'}">
                    <i class="fas fa-campground transparent"></i> My Applications
                </router-link>
                <router-link tag="li" v-show="!localStatus" active-class="selected" v-bind:to="{name: 'login'}">
                    <i class="fas fa-campground transparent"></i> Log In
                </router-link>
                <router-link tag="li" v-show="!localStatus" active-class="selected" v-bind:to="{name: 'register'}">
                    <i class="fas fa-campground transparent"></i> Create New Account
                </router-link>
                <router-link tag="li" v-show="localStatus" active-class="selected" v-bind:to="{name: 'login'}">
                    <a @click="signOut()" ><i class="fas fa-campground transparent"></i> Log Out</a>
                </router-link>
            </ul>
        </nav>
    </header>
</template>

<script>
import auth from '../auth';
import router from '@/router';

export default {
    name: 'navigation',
    props: ['userStatus'],
    data() {
        return {
            localStatus: this.userStatus
        }
    },
    methods: {
        signOut() {
            this.localStatus = null;
            auth.logout();
        },
        isAdmin() {
          this.user = auth.getUser();
          if(auth.getUser().rol == 'admin') {
              return true;
          } else {
              return false;
          }
      }
    }
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
            position: static;
            box-shadow: 0 1 2px 5px #c9d750;
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