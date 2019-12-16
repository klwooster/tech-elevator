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
  name: 'application-notes',
  components: {
    NoteDetails
  },
  props: ['id'] ,
  data() {
    return {
      noteData: [{}]
    }
  },
  methods: { 
    getNotes() {
      APIService.getNotesByApplication(this.id)
      .then((noteData) => {
        this.noteData = noteData
      });
    }
  },
  created() {
    this.$watch(this.id, id => {
       this.getNotes();
    })
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