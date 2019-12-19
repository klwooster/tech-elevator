<template>
    <div class="sidebar">
            <div class="row">
                <p class="title">Guardian</p>
                <div v-if="isInEditMode" class="subdata form">
                    <input id="guardian.firstName" 
                        placeholder="First Name" 
                        v-model="applicationdata.guardian.firstName"  
                        v-on:mouseenter.stop="toggleFocus($event)" 
                        v-on:mouseleave="toggleFocus($event)" />
                    <input id="guardian.lastName" 
                        placeholder="Last Name" 
                        v-model="applicationdata.guardian.lastName"  
                        v-on:mouseenter.stop="toggleFocus($event)" 
                        v-on:mouseleave="toggleFocus($event)" />
                    <input id="guardian.email" 
                        placeholder="Email" 
                        v-model="applicationdata.guardian.email"  
                        v-on:mouseenter.stop="toggleFocus($event)" 
                        v-on:mouseleave="toggleFocus($event)" />
                    <input id="guardian.phone" 
                        placeholder="Phone Number" 
                        v-model="applicationdata.guardian.phone"  
                        v-on:mouseenter.stop="toggleFocus($event)" 
                        v-on:mouseleave="toggleFocus($event)" />
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
                    <input id="emergencyContact.firstName" 
                        placeholder="First Name" 
                        v-model="applicationdata.emergencyContact.firstName"  
                        v-on:mouseenter.stop="toggleFocus($event)" 
                        v-on:mouseleave="toggleFocus($event)" />
                    <input id="emergencyContact.lastName" 
                        placeholder="Last Name" 
                        v-model="applicationdata.emergencyContact.lastName"  
                        v-on:mouseenter.stop="toggleFocus($event)" 
                        v-on:mouseleave="toggleFocus($event)" />
                    <input id="emergencyContact.email" 
                        placeholder="Email" 
                        v-model="applicationdata.emergencyContact.email"  
                        v-on:mouseenter.stop="toggleFocus($event)" 
                        v-on:mouseleave="toggleFocus($event)" />
                    <input id="emergencyContact.phone" 
                        placeholder="Phone Number" 
                        v-model="applicationdata.emergencyContact.phone"  
                        v-on:mouseenter.stop="toggleFocus($event)" 
                        v-on:mouseleave="toggleFocus($event)" />
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
                    <select id ="program" 
                        v-model="applicationdata.program" 
                        v-on:mouseenter.stop="toggleFocus($event)" 
                        v-on:mouseleave="toggleFocus($event)" >
                            <option value="north">Camp North Star</option>
                            <option value="crystal">Camp Crystal Lake</option>
                            <option value="anawanna">Camp Anawanna</option>
                    </select>
                </div>
                <div v-else class="subdata">
                    {{applicationdata.program}}
                </div>
            </div>
            <div class="row" v-show="isAdmin()">
                <p class="title">Dorm Assignment</p>
                <div v-if="isInEditMode" class="subdata form">
                    <input id="dormAssignment" 
                        v-model="applicationdata.dormAssignment"  
                        v-on:mouseenter.stop="toggleFocus($event)" 
                        v-on:mouseleave="toggleFocus($event)" />
                </div>
                <div v-else class="subdata">
                    {{applicationdata.dormAssignment}}
                </div>
            </div>
            <div class="row">
                <p class="title">Meal Plan</p>
                <div v-if="isInEditMode" class="subdata form">
                    <select id ="mealPlan" 
                        v-model="applicationdata.mealPlan" 
                        v-on:mouseenter.stop="toggleFocus($event)" 
                        v-on:mouseleave="toggleFocus($event)" >
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
import auth from '../auth'

export default {
    name: 'application-details',
    props: {
        applicationdata: null,
        isInEditMode: false
    },
    methods: {
        isAdmin() {
            this.user = auth.getUser();
            if(auth.getUser().rol == 'admin') {
                return true;
            } else {
                return false;
            }
        },
        toggleFocus(evt) {
            evt.target.classList.toggle('focused');
        }
    }
}
</script>

<style scoped>
        .sidebar {
            flex-basis: 25%;
            flex-grow: 0;
            flex-shrink: 0;
            background: #71C4C1;
            padding: 15px 15px 15px 15px;
            border-radius: 4px;
        }
        .sidebar .row {
            display: block;
            width: 95%;
            margin: 5px 0px 15px 0px;
        }
        
        .sidebar .row .title {
            font-size: 1.2em;
            font-family: 'Playfair Display', serif;
            font-weight: bold;
        }
        
        .sidebar .row>p {
            display: block;
        }

        .row>p {
            font-size: 1.2em;
            margin: auto;
            padding: 4px;
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
            border-radius: 4px;
        }

        .control>* {
            border: 1px solid #792359;
            background-color: #DAC3D1;
            color: #792359;
            font-size: 1.1em;
            margin: 5px;
        }
        .focused {
            box-shadow: 0px 0px 7px 0px #C9D750;
        }
</style>