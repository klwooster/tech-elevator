<template>
    <div id="filter" class="list">
        <h1>Applicants</h1>
        <hr>
        <div class="sidebar">
            <p class="title">Search: </p>
                <input type="text" v-model="filterProperties.filterData">
                <select v-model="filterProperties.filterType">
                    <option disabled value="">Select...</option>
                    <option value="applicantId">Applicant ID</option> 
                    <option value="firstName">First Name</option>
                    <option value="lastName">Last Name</option>
                    <option value="accountId">Account #</option>
                </select>
        </div>
        <hr>
        <div class="row">
            <span class="title">Applicant ID <i class="fas fa-sort" id="applicantId" v-on:click="$emit('sort-applicants', 'applicantId')"></i></span>
            <span class="title">First Name <i class="fas fa-sort" id="firstName" v-on:click="$emit('sort-applicants', 'firstName')"></i></span>
            <span class="title">Last Name <i class="fas fa-sort" id="lastName" v-on:click="$emit('sort-applicants', 'lastName')"></i></span>
            <span class="title">Account # <i class="fas fa-sort" id="accountId" v-on:click="$emit('sort-applicants', 'accountId')"></i></span>
        </div>
    </div>
</template>

<script>
export default {
    name: 'applicant-filters',
    props: [ 'filterProperties' ]
  };
</script>

<style scoped>
        .sidebar {
            background: #71C4C1;
            padding: 15px;
            margin-bottom: 15px;
        }

        .list {
            flex-basis: 100%;
        }

        .list>h1 {
            font-family: 'Playfair Display', serif;
            font-style: italic;
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
        }

        .sidebar > select {
            margin: 0px 10px 0px 5px;
            display: inline-block;
            border: 1px solid #792359;
            width: 15%;
            font-size: 1em;
        }
</style>
