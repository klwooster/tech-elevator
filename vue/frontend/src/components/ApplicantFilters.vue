<template>
    <div id="filter" class="list">
        <h1>{{heading}}</h1>
        <hr>
        <div class="sidebar">
            <p class="title">Search: </p>
                <input type="text" 
                    v-model="currentfilter.filterData"
                    v-on:mouseenter.stop="toggleFocus($event)" 
                    v-on:mouseleave="toggleFocus($event)" >
                <select v-model="currentfilter.filterType"
                    v-on:mouseenter.stop="toggleFocus($event)" 
                    v-on:mouseleave="toggleFocus($event)" >
                    <option disabled value="">Select...</option>
                    <option value="applicantId">Applicant ID</option> 
                    <option value="firstName">First Name</option>
                    <option value="lastName">Last Name</option>
                    <option value="accountId">Account #</option>
                </select>
        </div>
        <hr>
        <div class="row">
            <span class="title">Applicant ID <i class="fas fa-sort" v-on:click="sort('applicantId')"></i></span>
            <span class="title">First Name <i class="fas fa-sort" v-on:click="sort('firstName')"></i></span>
            <span class="title">Last Name <i class="fas fa-sort" v-on:click="sort('lastName')"></i></span>
            <span class="title">Account # <i class="fas fa-sort" v-on:click="sort('accountId')"></i></span>
        </div>
    </div>
</template>

<script>
export default {
    name: 'applicant-filters',
    props: [ 'currentfilter','header' ],
    methods: {
        sort(column) {
            this.currentfilter.sortTarget = column;
            this.currentfilter.sortAsc = !this.currentfilter.sortAsc;
        },
        toggleFocus(evt) {
            evt.target.classList.toggle('focused');
        }
    },
    computed: {
        heading() {
            if(this.header !== null && this.header !== undefined) {
                return this.header;
            } else {
                return "Applicants";
            }
        }
    }
  };
</script>

<style scoped>
        .sidebar {
            background: #71C4C1;
            padding: 15px;
            margin-bottom: 15px;
            border-radius: 4px;
        }

        .list {
            flex-basis: 100%;
        }

        .list>h1 {
            font-family: 'Playfair Display', serif;
            font-size: 2.3em;
            margin: 5px 0px 20px 5px;
        }
        
        .row>span {
            display: inline-block;
            font-size: 1.2em;
            width: 24%;
            margin: auto;
            padding: 4px;
            font-size: 1.2em;
            text-transform: uppercase;
        }
        
        .list hr {
            border-top: 1px solid #792359;
            margin: 10px 0px 15px 0px;
        }

        .title {
            display: inline-block;
            font-weight: 700;
            font-size: 1.2em;
        }

        .sidebar > input {
            margin: 0px 10px 0px 5px;
            display: inline-block;
            border: 1px solid #792359;
            width: 25%;
            font-size: 1em;
            border-radius: 4px;
        }

        .sidebar > select {
            margin: 0px 10px 0px 5px;
            display: inline-block;
            border: 1px solid #792359;
            width: 15%;
            font-size: 1em;
        }
        .focused {
            box-shadow: 0px 0px 7px 0px #C9D750;
        }
</style>
