<template>
       <div class="noteDetails">
            <div>
                <h2>Notes</h2>
                <div class="row">
                <p class="title"><b>Note Change Id</b></p>
                <hr>
                <p class="form">{{noterecord.noteId}}</p>
                <p class="form">{{noterecord.noteBody}}</p>
                <p class="form">{{noterecord.createDate}}</p>
                <p class="form">{{noterecord.applicationId}}</p>
            </div>
            </div>
       </div>
</template>

<script>
export default {
    name: 'note-details',
    props: {
        noterecord: {}
    },
    data() {
        return {
            
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