<template>
    <div class="details">
        <div class="details-top">
            <h1 v-if="applicationdata.applicationId > 0">{{applicationdata.applicant.firstName}} {{applicationdata.applicant.lastName}}</h1>
            <h1 v-else>New Camper Registration</h1>
            <div class="control">
                <button v-show="!isInEditMode" 
                    v-on:click="$emit('toggle-edit-mode')" 
                    v-on:mouseenter.stop="toggleFocus($event)" 
                    v-on:mouseleave="toggleFocus($event)" >Edit</button>
                <router-link v-show="!isInEditMode" v-bind:to="{name: 'applicationhistory', params: {id: applicationdata.applicationId, fname: applicationdata.applicant.firstName, lname: applicationdata.applicant.lastName}}">
                    <button  
                        v-on:mouseenter.stop="toggleFocus($event)" 
                        v-on:mouseleave="toggleFocus($event)" >View History</button> 
                </router-link>
            </div>
        </div>
        <h3 v-show="!isInEditMode">Application #{{applicationdata.applicationId}}<br>Account #{{applicationdata.accountId}}</h3>
        <div class="row">
            <p class="title">First Name</p>
            <hr>
            <p v-if="isInEditMode" class="form">
                <input id="firstName" 
                    v-model="applicationdata.applicant.firstName" 
                    v-on:mouseenter.stop="toggleFocus($event)" 
                    v-on:mouseleave="toggleFocus($event)" />
            </p>
            <p v-else>{{applicationdata.applicant.firstName}}</p>
        </div>
        <div class="row">
            <p class="title">Last Name</p>
            <hr>
            <p v-if="isInEditMode" class="form">
                <input id="lastName" 
                    v-model="applicationdata.applicant.lastName"  
                    v-on:mouseenter.stop="toggleFocus($event)" 
                    v-on:mouseleave="toggleFocus($event)" />
            </p>
            <p v-else>{{applicationdata.applicant.lastName}}</p>
        </div>
        <div class="row">
            <p class="title">Preferred Name</p>
            <hr>
            <p v-if="isInEditMode" class="form">
                <input id="preferredName" 
                    v-model="applicationdata.applicant.preferredName"  
                    v-on:mouseenter.stop="toggleFocus($event)" 
                    v-on:mouseleave="toggleFocus($event)" />
            </p>
            <p v-else>{{applicationdata.applicant.preferredName}}</p>
        </div>
        <div class="row">
            <p class="title">Date of Birth</p>
            <hr>
            <p v-if="isInEditMode" class="form">
                <input id="dateOfBirth" 
                    v-model="applicationdata.applicant.dateOfBirth"  
                    v-on:mouseenter.stop="toggleFocus($event)" 
                    v-on:mouseleave="toggleFocus($event)" 
                    placeholder="YYYY-MM-DD">
            </p>
            <p v-else>{{applicationdata.applicant.dateOfBirth}}</p>
        </div>
        <div class="row">
            <p class="title">Email</p>
            <hr>
            <p v-if="isInEditMode" class="form">
                <input id="email" 
                    v-model="applicationdata.applicant.email"  
                    v-on:mouseenter.stop="toggleFocus($event)" 
                    v-on:mouseleave="toggleFocus($event)" />
            </p>
            <p v-else>{{applicationdata.applicant.email}}</p>
        </div>
        <div class="row">
            <p class="title">Phone Number</p>
            <hr>
            <p v-if="isInEditMode" class="form">
                <input id="phone" 
                    v-model="applicationdata.applicant.phone"  
                    v-on:mouseenter.stop="toggleFocus($event)" 
                    v-on:mouseleave="toggleFocus($event)" />
                </p>
            <p v-else>{{applicationdata.applicant.phone}}</p>
        </div>
        <div class="row">
            <p class="title">T-Shirt Size</p>
            <hr>
            <p v-if="isInEditMode" class="form">
                <input id="tshirtSize" 
                    v-model="applicationdata.tshirtSize"  
                    v-on:mouseenter.stop="toggleFocus($event)" 
                    v-on:mouseleave="toggleFocus($event)" />
            </p>
            <p v-else>{{applicationdata.tshirtSize}}</p>
        </div>
        <div class="row">
            <p class="title">Dietary Preference</p>
            <hr>
            <p v-if="isInEditMode" class="form">
                <input id="dietaryPreference" 
                    placeholder="Omnivore, Vegetarian, Vegan, Gluten Free, etc." 
                    v-model="applicationdata.dietaryPreference"  
                    v-on:mouseenter.stop="toggleFocus($event)" 
                    v-on:mouseleave="toggleFocus($event)" />
            </p>
            <p v-else>{{applicationdata.dietaryPreference}}</p>
        </div>
        <div class="row">
            <p class="title">Dietary Restrictions</p>
            <hr>
            <p v-if="isInEditMode" class="form">
                <input id="dietaryRestrictions" 
                    v-model="applicationdata.dietaryRestrictions"  
                    v-on:mouseenter.stop="toggleFocus($event)" 
                    v-on:mouseleave="toggleFocus($event)" />
            </p>
            <p v-else>{{applicationdata.dietaryRestrictions}}</p>
        </div>
        <div class="row">
            <p class="title">Mobility Issues</p>
            <hr>
            <p v-if="isInEditMode" class="form">
                <input id="mobilityIssues" 
                    v-model="applicationdata.mobilityIssues"  
                    v-on:mouseenter.stop="toggleFocus($event)" 
                    v-on:mouseleave="toggleFocus($event)" />
            </p>
            <p v-else>{{applicationdata.mobilityIssues}}</p>
        </div>
        <div class="row">
            <p class="title">Medical Concerns</p>
            <hr>
            <p v-if="isInEditMode" class="form">
                <input id="medicalConcerns" 
                    v-model="applicationdata.medicalConcerns"  
                    v-on:mouseenter.stop="toggleFocus($event)" 
                    v-on:mouseleave="toggleFocus($event)" />
            </p>
            <p v-else>{{applicationdata.medicalConcerns}}</p>
        </div>
        <div v-show="isInEditMode" class="control">
            <button v-show="!isNewApp" 
                v-on:click="$emit('discard-changes')" 
                v-on:mouseenter.stop="toggleFocus($event)" 
                v-on:mouseleave="toggleFocus($event)">Cancel</button> 
            <button v-if="applicationdata.applicationId > 0" 
                v-on:click="$emit('save-changes')" 
                v-on:mouseenter.stop="toggleFocus($event)" 
                v-on:mouseleave="toggleFocus($event)" >Save Changes</button>
            <button v-else 
                v-on:click="$emit('create-application')" 
                v-on:mouseenter.stop="toggleFocus($event)" 
                v-on:mouseleave="toggleFocus($event)" >Submit</button>
        </div>
    </div>
</template>

<script>
import auth from '../auth'
export default {
    name: 'applicant-info',
    props: {
        applicationdata: {},
        isInEditMode: false,
        isNewApp: false
    },
    data() {
        return {
            editButtonText: 'Edit'
        }
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
};
</script>

<style scoped>        
        .details-top>h1 {
            font-family: 'Playfair Display', serif;
            font-weight: bold;
            font-size: 2.3em;
            margin: 5px 0px 20px -15px;
        }
        
        .details {
            flex-basis: 70%;
        }
        
        .details-top>h1 {
            display: inline-block;
            width: 65%;
        }
        
        .details-top .control {
            display: inline-block;
            width: auto;
            margin-right: 20px;
        }
        
        .details>h3 {
            font-family: 'Open Sans Condensed', sans-serif;
            font-size: 1em;
            margin-top: -10px;
            text-transform: uppercase;
        }
        
        .details .row {
            display: inline-block;
            width: 40%;
            margin: 0px 10px 5px 0px;
        }
        
        .details .row>p {
            display: block;
        }
        
        .details hr {
            border-top: 1px solid #792359;
            margin: 10px 0px 15px 0px;
        }
        
        .details>h3,
        .row>h3 {
            font-size: 1em;
            font-family: 'Open Sans Condensed', sans-serif;
        }
        
        .row>p {
            font-size: 1.2em;
            margin: auto;
            padding: 4px;
        }
        
        .row .title {
            font-size: 1.2em;
            font-family: 'Playfair Display', serif;
            font-weight: bold;
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
        .subdata>input,
        .my-date-picker {
            margin-left: auto;
            margin-right: auto;
            display: block;
            margin: 5px;
            border: 1px solid #792359;
            width: 98%;
            font-size: 0.9em;
            border-radius: 4px;
        }

        .control>button,
        .control>a>button {
            border: 1px solid #DAC3D1;
            background-color: #792359;
            color: #ffffff;
            font-size: 1.5em;
            text-transform: uppercase;
            margin: 0px 5px 0px 15px;
            border-radius: 4px;
            padding: 0px 15px 0px 15px;
            box-shadow: 0px 0px 5px 1px darkgray;    
        }

        .focused {
            box-shadow: 0px 0px 7px 0px #C9D750;
        }
</style>