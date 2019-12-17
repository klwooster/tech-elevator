<template>
    <div>
        <div v-for="attendee in attendees" :key="attendee.personId">
            <p>{{attendee.firstName}} {{attendee.lastName}}</p>
        </div>
        <p>hello</p>
    </div>    
</template>

<script>
//import APIService from '@/service/APIService';

export default {
    name: 'camp-attendees',
    props: {
        'attendees': []

    }
    // data() {
    //     return {
    //         attendees: []
    //     }
    // },
    // methods: {
    //     getAttendees(campname){
    //         APIService.getAttendeesByCamp(campname)
    //         .then((attendees) => {
    //             this.attendees = attendees
    //         });
    //     }
    // },
    // created() {
    //     this.getAttendees(this.campname);
    // }
}
</script>

<style>
</style>