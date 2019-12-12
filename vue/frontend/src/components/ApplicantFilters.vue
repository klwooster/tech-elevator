<template>
    <div id="filter" class="list">
        <h1>Applicants</h1>
        <hr>
        <div class="sidebar">
            <p class="title">Filters</p>
                <input type="text" id="filter-input" v-on:change="$emit('filter-data')">
                <input type="radio" id="applicantId" value="Applicant ID" v-on:change="changeFilter($event.target)" selected>
                <input type="radio" id="firstName" value="First Name" v-on:change="changeFilter($event.target)" >
                <input type="radio" id="lastName" value="Last Name" v-on:change="changeFilter($event.target)" >
                <input type="radio" id="accountId" value="Account #" v-on:change="changeFilter($event.target)" >
        </div>
        <div class="row">
            <span class="title">Applicant ID <i class="fas fa-sort"></i></span>
            <span class="title">First Name <i class="fas fa-sort"></i></span>
            <span class="title">Last Name <i class="fas fa-sort"></i></span>
            <span class="title">Account # <i class="fas fa-sort"></i></span>
        </div>
    </div>
</template>

<script>
export default {
    name: 'applicant-filters',
    data() {
        return {
            selectedFilter: 'applicantId'
        }
    },
    methods: {
        changeFilter(newFilter) {
            this.selectedFilter = newFilter;
        }
    }
  };
</script>

<style scoped>
        .sidebar {
            display: block;
            width: 90%;
            margin-left: auto;
            margin-right: auto;
            background: #71C4C1;
            padding: 60px 15px 15px 15px;
        }

        .list {
            flex-basis: 100%;
        }

        .list>h1 {
            font-family: 'Playfair Display', serif;
            font-style: italic;
            font-size: 2.3em;
            margin: 5px 0px 20px -15px;
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
</style>
