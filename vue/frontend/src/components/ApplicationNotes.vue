<template>
  <div id="main">
    <div v-for="note in noteData" v-bind:key="note.noteId">
      <p class="title"><b>Note Change Id</b></p>
        <hr>
          <p class="form">{{note.noteId}}</p>
          <p class="form">{{note.noteBody}}</p>
          <p class="form">{{note.createDate}}</p>
          <p class="form">{{note.applicationId}}</p>
    </div>
  </div>
</template>

<script>

import APIService from '@/service/APIService';


export default {
  name: 'application-notes',
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
      })
      .catch(err => console.error(err));
    }
  },
  created() {
       this.getNotes();
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