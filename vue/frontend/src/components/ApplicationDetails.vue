<template>
    <div class="sidebar">
            <div class="row">
                <p class="title">Guardian</p>
                <div v-if="isInEditMode" class="subdata form">
                    <input id="guardian.firstName" placeholder="First Name" v-model="applicationdata.guardian.firstName" />
                    <input id="guardian.lastName" placeholder="Last Name" v-model="applicationdata.guardian.lastName" />
                    <input id="guardian.email" placeholder="Email" v-model="applicationdata.guardian.email" />
                    <input id="guardian.phone" placeholder="Phone Number" v-model="applicationdata.guardian.phone" />
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
                    <input id="emergencyContact.firstName" placeholder="First Name" v-model="applicationdata.emergencyContact.firstName" />
                    <input id="emergencyContact.lastName" placeholder="Last Name" v-model="applicationdata.emergencyContact.lastName" />
                    <input id="emergencyContact.email" placeholder="Email" v-model="applicationdata.emergencyContact.email" />
                    <input id="emergencyContact.phone" placeholder="Phone Number" v-model="applicationdata.emergencyContact.phone" />
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
                    <!-- <input id="program" v-model="applicationdata.program" /> -->
                    <select id ="program" v-model="applicationdata.program">
                        <option value="northstar">Camp North Star</option>
                        <option value="wanahockaloogi">Camp Wanahockaloogi</option>
                        <option value="anawanna">Camp Anawanna</option>
                    </select>
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
                    <select id ="mealPlan" v-model="applicationdata.mealPlan">
                        <option value="standard">Standard</option>
                        <option value="light">Light</option>
                        <option value="delux">Delux</option>
                    </select>
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

        .form>textarea,
        .form>button,
        .form>input,
        .form>select,
        .subdata>input {
            margin-left: auto;
            margin-right: auto;
            display: block;
            margin: 5px;
            border: 1px solid #792359;
            width: 95%;
            font-size: 0.9em;
        }

        .control>* {
            border: 1px solid #792359;
            background-color: #DAC3D1;
            color: #792359;
            font-size: 1.1em;
            margin: 5px;
        }
</style>