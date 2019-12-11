<template>
            <div class="details">
            <div class="details-top">
                <h1>{{applicationdata.applicant.firstName}} {{applicationdata.applicant.lastName}}</h1>
                <!-- <div class="control">
                    <button>Edit</button>
                    <button>Recent Changes</button>
                </div> -->
            </div>
            <h3>Application #{{applicationdata.applicationId}}<br>Account #{{applicationdata.accountId}}</h3>
            <div class="row">
                <p class="title"><b>Preferred Name</b></p>
                <hr>
                <p>{{applicationdata.applicant.preferredName}}</p>
            </div>
            <div class="row">
                <p class="title"><b>Date of Birth</b></p>
                <hr>
                <p>{{applicationdata.applicant.dateOfBirth}}</p>
            </div>
            <div class="row">
                <p class="title">Email</p>
                <hr>
                <p>{{applicationdata.applicant.email}}</p>
            </div>
            <div class="row">
                <p class="title">Phone Number</p>
                <hr>
                <p>{{applicationdata.applicant.phone}}</p>
            </div>
            <div class="row">
                <p class="title">T-Shirt Size</p>
                <hr>
                <p>{{applicationdata.tshirtSize}}</p>
            </div>
            <div class="row">
                <p class="title">Dietary Preference</p>
                <hr>
                <p>{{applicationdata.dietaryPreference}}</p>
            </div>
            <div class="row">
                <p class="title">Dietary Restrictions</p>
                <hr>
                <p>{{applicationdata.dietaryRestrictions}}</p>
            </div>
            <div class="row">
                <p class="title">Mobility Issues</p>
                <hr>
                <p>{{applicationdata.mobilityIssues}}</p>
            </div>
            <div class="row">
                <p class="title">Medical Concerns</p>
                <hr>
                <p>{{applicationdata.medicalConcerns}}</p>
            </div>
        </div>
</template>

<script>
export default {
  name: 'applicant-info',
    props: [ 'applicationdata' ]
};
</script>

<style>        
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
</style>