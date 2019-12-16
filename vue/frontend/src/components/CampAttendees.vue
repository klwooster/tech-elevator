<template>
    <div>
        <div v-for="attendee in attendees" :key="attendee.personId">
            <p>{{attendee.firstName}}</p>
            <p>{{attendee.lastName}}</p>
        </div>
        <p>hello</p>
    </div>    
</template>

<script>
import APIService from '@/service/APIService';

export default {
    name: 'camp-attendees',
    props: {
        'campname': String

    },
    data() {
        return {
            attendees: {}
        }
    },
    methods: {
        getAttendees(campname){
            APIService.getAttendeesByCamp(campname)
            .then((attendees) => {
                this.attendees = attendees
            });
        }
    },
    created() {
        this.getAttendees('camp1');
    }
}
</script>

<style>
</style>