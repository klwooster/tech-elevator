<template>
       <div class="row">
           <h3>{{title}}</h3>
            <p>{{noterecord.noteBody}}</p>
        </div>
</template>

<script>
export default {
    name: 'note-details',
    props: {
        noterecord: {}
    },
    computed: {
        title() {
            return this.noterecord.createDate.monthValue + '/' + this.noterecord.createDate.dayOfMonth + '/' + this.noterecord.createDate.year + 
            ' at ' + this.noterecord.createDate.hour + ':' + this.noterecord.createDate.minute + ', by ' + '[NAME PLACEHOLDER]';
        }
    }
};
</script>

<style scoped>        
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