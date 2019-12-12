<template>
            <div class="details">
            <div class="details-top">
                <h1>{{applicationdata.applicant.firstName}} {{applicationdata.applicant.lastName}}</h1>
                <div class="control">
                    <button v-show="!isInEditMode" v-on:click="$emit('toggle-edit-mode')">Edit</button>
                    <!-- <button>Recent Changes</button> -->
                </div>
            </div>
            <h3>Application #{{applicationdata.applicationId}}<br>Account #{{applicationdata.accountId}}</h3>
            <div class="row">
                <p class="title"><b>First Name</b></p>
                <hr>
                <p v-if="isInEditMode" class="form"><input id="firstName" v-model="applicationdata.applicant.firstName" /></p>
                <p v-else>{{applicationdata.applicant.firstName}}</p>
            </div>
            <div class="row">
                <p class="title"><b>Last Name</b></p>
                <hr>
                <p v-if="isInEditMode" class="form"><input id="lastName" v-model="applicationdata.applicant.lastName" /></p>
                <p v-else>{{applicationdata.applicant.lastName}}</p>
            </div>
            <div class="row">
                <p class="title"><b>Preferred Name</b></p>
                <hr>
                <p v-if="isInEditMode" class="form"><input id="preferredName" v-model="applicationdata.applicant.preferredName" /></p>
                <p v-else>{{applicationdata.applicant.preferredName}}</p>
            </div>
            <div class="row">
                <p class="title"><b>Date of Birth</b></p>
                <hr>
                <p v-if="isInEditMode" class="form"><input id="dateOfBirth" v-model="applicationdata.applicant.dateOfBirth" /></p>
                <p v-else>{{applicationdata.applicant.dateOfBirth}}</p>
            </div>
            <div class="row">
                <p class="title">Email</p>
                <hr>
                <p v-if="isInEditMode" class="form"><input id="email" v-model="applicationdata.applicant.email" /></p>
                <p v-else>{{applicationdata.applicant.email}}</p>
            </div>
            <div class="row">
                <p class="title">Phone Number</p>
                <hr>
                <p v-if="isInEditMode" class="form"><input id="phone" v-model="applicationdata.applicant.phone" /></p>
                <p v-else>{{applicationdata.applicant.phone}}</p>
            </div>
            <div class="row">
                <p class="title">T-Shirt Size</p>
                <hr>
                <p v-if="isInEditMode" class="form"><input id="tshirtSize" v-model="applicationdata.tshirtSize" /></p>
                <p v-else>{{applicationdata.tshirtSize}}</p>
            </div>
            <div class="row">
                <p class="title">Dietary Preference</p>
                <hr>
                <p v-if="isInEditMode" class="form"><input id="dietaryPreference" placeholder="Omnivore, Vegetarian, Vegan, Gluten Free, etc." v-model="applicationdata.dietaryPreference" /></p>
                <p v-else>{{applicationdata.dietaryPreference}}</p>
            </div>
            <div class="row">
                <p class="title">Dietary Restrictions</p>
                <hr>
                <p v-if="isInEditMode" class="form"><input id="dietaryRestrictions" v-model="applicationdata.dietaryRestrictions" /></p>
                <p v-else>{{applicationdata.dietaryRestrictions}}</p>
            </div>
            <div class="row">
                <p class="title">Mobility Issues</p>
                <hr>
                <p v-if="isInEditMode" class="form"><input id="mobilityIssues" v-model="applicationdata.mobilityIssues" /></p>
                <p v-else>{{applicationdata.mobilityIssues}}</p>
            </div>
            <div class="row">
                <p class="title">Medical Concerns</p>
                <hr>
                <p v-if="isInEditMode" class="form"><input id="medicalConcerns" v-model="applicationdata.medicalConcerns" /></p>
                <p v-else>{{applicationdata.medicalConcerns}}</p>
            </div>
            <div v-show="isInEditMode" class="control">
                <button v-on:click="$emit('discard-changes')">Cancel</button> 
                <button v-on:click="$emit('save-changes')">Sumbit</button>
            </div>
        </div>
</template>

<script>
export default {
    name: 'applicant-info',
    props: {
        applicationdata: null,
        isInEditMode: false
    },
    data() {
        return {
            editButtonText: 'Edit'
        }
    }
};
</script>

<style scoped>        
        .details-top>h1 {
            font-family: 'Playfair Display', serif;
            font-style: italic;
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
            font-family: 'Playfair Display', serif;
            font-style: italic;
            font-size: 1em;
            margin-top: -10px;
        }
        
        .details .row {
            display: inline-block;
            width: 40%;
            margin: 0px 10px 15px 0px;
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
        .subdata>input {
            margin-left: auto;
            margin-right: auto;
            display: block;
            margin: 5px;
            border: 1px solid #792359;
            width: 98%;
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