<template>
    <div class="sidebar">
            <div class="row">
                <p class="title">Guardian</p>
                <div class="subdata">
                    Tech Elevator<br> (614) 555-1234
                </div>
            </div>
            <div class="row">
                <p class="title">Emergency Contact</p>
                <div class="subdata">
                    Tyler Kendall<br> (614) 843-1234
                </div>
            </div>
            <div class="row">
                <p class="title">Program</p>
                <div class="subdata">
                    Super Fun Workshop!
                </div>
            </div>
            <div class="row">
                <p class="title">Workshop Preferences</p>
                <div class="subdata">
                    1st Choice - Workshop A<br> 2nd Choice - Workshop B
                </div>
            </div>
            <div class="row">
                <p class="title">Dorm Assignment</p>
                <div class="subdata">
                    Taylor Tower
                </div>
            </div>
            <div class="row">
                <p class="title">Meal Plan</p>
                <div class="subdata">
                    All lunch and dinner to be provided.
                </div>
            </div>
        </div>
</template>

<script>
export default {
    name: 'application-details'
}
</script>

<style>
        .sidebar {
            flex-basis: 25%;
            flex-grow: 0;
            flex-shrink: 0;
            background: #71C4C1;
            padding: 15px 15px 15px 15px;
        }
        .sidebar .row {
            display: block;
            width: 95%;
            margin: 5px 0px 15px 0px;
        }
        
        .sidebar .row .title {
            font-family: 'Playfair Display', serif;
            font-style: italic;
            text-transform: capitalize;
        }
        
        .sidebar .row>p {
            display: block;
        }
    .row>h3 {
            font-family: 'Playfair Display', serif;
            font-style: italic;
            font-size: 1em;
        }
        
        .row>p {
            font-size: 1.2em;
            margin: auto;
            padding: 4px;
        }
        
        .row .title {
            font-size: 1.2em;
            text-transform: uppercase;
        }
        
        .row hr {
            border-top: 1px solid #792359;
            margin: 0px 0px 0px 0px;
        }
        
        .row>h3 {
            margin-bottom: -4px;
        }
        
        .subdata {
            padding-left: 15px;
        }
</style>