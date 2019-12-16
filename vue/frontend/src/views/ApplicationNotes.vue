<template>
  <div id="main">
    <div v-for="note in noteData" v-bind:key="note.noteId">
      <note-details v-bind:noterecord="note"/>
    </div>
  </div>
</template>

<script>

import NoteDetails from '@/components/NoteDetails.vue';
import APIService from '@/service/APIService';


export default {
name: 'application-note',
components: {
  NoteDetails
},
props: {
  id: {},
  isInEditMode: false
},
data() {
return {
  noteData: [{
    noteId: "",
    noteBody: "",
    createDate: "",
    applicationId: ""
  }]
}
},
methods: { 
  getNotes(id) {
    APIService.getNotesByApplication(id);
    // .then(applicationdata => this.applicationdata = applicationdata);
  }
},
created() {
  getNotes(this.id);
}
};
</script>

<style scoped>
   #main {
            flex-basis: 85%;
            width: 85%;
            flex-shrink: 0;
            flex-grow: 0;
            padding: 20px 0px 20px 0px;
            margin-left: auto;
            margin-right: auto;
            display: flex;
            flex-direction: row;
            flex-wrap: wrap;
            justify-content: space-between;
        }
</style>