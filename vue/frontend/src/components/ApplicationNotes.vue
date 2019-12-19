<template>
    <div class="notes">
        <div>
            <h2>Notes</h2>
            <div class="form">
                <label for="new-note">Add a new note:</label>
                <textarea id="new-note" v-model="newNote.noteBody"></textarea>
                <button @click="createNote">Submit</button>
            </div>
            <div v-for="note in allnotes.notes" v-bind:key="note.noteId" class="row">
                <h3>{{note.createDate}}</h3>
                <p>{{note.noteBody}}</p>
            </div>
        </div>
    </div>
</template>

<script>
import APIService from '@/service/APIService';

export default {
  name: 'application-notes',
  props: ['allnotes'],
  data() {
    return {
        newNote: {
            noteId: "",
	        noteBody: "",
	        createDate: null,
	        applicationId: this.allnotes.applicationId
        },
        responseObject: ""
    }
  },
  computed: {
        title(noterecord) {
            return noterecord.createDate.substr(0, 10) + ', by ' + '[NAME PLACEHOLDER]';
        }
    },
    methods: {
        createNote() {
            APIService.createNotes(this.allnotes.applicationId, this.newNote)
            .then(response => response.json())
            .then(result => {
                this.responseObject = result;
                console.log('Creation was successful' + this.responseObject);
            })
            .catch(err => console.error(err))
        }
    }
};
</script>

<style scoped>
        .notes {
            flex-basis: 90%;
            flex-grow: 0;
            flex-shrink: 0;
        }
        
        .notes>div {
            background-color: #F7F0C2;
            margin: 20px 0x 20px 0px;
            padding: 0px 20px 20px 20px;
            border-radius: 4px;
        }
        
        .notes h2 {
            font-family: 'Playfair Display', serif;
            font-size: 1.8em;
            padding: 10px 0px 10px 0px;
            color: #792359;
        }
        
        .form {
            border-bottom: 1px solid #792359;
            padding: 0px 0px 15px 0px;
            margin-top: -15px;
        }
        
        .form>textarea,
        .form>button,
        .form>label {
            width: 98%;
            margin-left: auto;
            margin-right: auto;
            display: block;
            margin: 5px;
        }
        
        .form>textarea,
        .form>button {
            border: 1px solid #792359;
            border-radius: 4px;
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
</style>