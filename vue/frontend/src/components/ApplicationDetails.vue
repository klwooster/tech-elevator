<template>
    <div class="sidebar">
            <div class="row">
                <p class="title">Guardian</p>
                <div v-if="isInEditMode" class="subdata form">
                    <input id="guardian.firstName" v-model="applicationdata.guardian.firstName" />
                    <input id="guardian.lastName" v-model="applicationdata.guardian.lastName" />
                    <input id="guardian.email" v-model="applicationdata.guardian.email" />
                    <input id="guardian.phone" v-model="applicationdata.guardian.phone" />
                </div>
                <div v-else class="subdata">
                    {{applicationdata.guardian.firstName}} {{applicationdata.guardian.lastName}}<br> 
                    {{applicationdata.guardian.email}}<br>
                    {{applicationdata.guardian.phone}}
                </div>
            </div>
            <div class="row">
                <p class="title">Emergency Contact</p>
                <div v-if="isInEditMode" class="subdata form">
                    <input id="emergencyContact.firstName" v-model="applicationdata.emergencyContact.firstName" />
                    <input id="emergencyContact.lastName" v-model="applicationdata.emergencyContact.lastName" />
                    <input id="emergencyContact.email" v-model="applicationdata.emergencyContact.email" />
                    <input id="emergencyContact.phone" v-model="applicationdata.emergencyContact.phone" />
                </div>
                <div v-else class="subdata">
                    {{applicationdata.emergencyContact.firstName}} {{applicationdata.emergencyContact.lastName}}<br> 
                    {{applicationdata.emergencyContact.email}}<br>
                    {{applicationdata.emergencyContact.phone}}
                </div>
            </div>
            <div class="row">
                <p class="title">Program</p>
                <div v-if="isInEditMode" class="subdata form">
                    <input id="program" v-model="applicationdata.program" />
                </div>
                <div v-else class="subdata">
                    {{applicationdata.program}}
                </div>
            </div>
            <!-- <div class="row">
                <p class="title">Workshop Preferences</p>
                <div class="subdata">
                    1st Choice - Workshop A<br> 2nd Choice - Workshop B
                </div>
            </div> -->
            <div class="row">
                <p class="title">Dorm Assignment</p>
                <div v-if="isInEditMode" class="subdata form">
                    <input id="dormAssignment" v-model="applicationdata.dormAssignment" />
                </div>
                <div v-else class="subdata">
                    {{applicationdata.dormAssignment}}
                </div>
            </div>
            <div class="row">
                <p class="title">Meal Plan</p>
                <div v-if="isInEditMode" class="subdata form">
                    <input id="mealPlan" v-model="applicationdata.mealPlan" />
                </div>
                <div v-else class="subdata">
                    {{applicationdata.mealPlan}}
                </div>
            </div>
        </div>
</template>

<script scoped>
export default {
    name: 'application-details',
    props: {
        applicationdata: null,
        isInEditMode: false
    }
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