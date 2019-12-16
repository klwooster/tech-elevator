<template>
    <div>
        <div v-for="attendee in attendees" :key="attendee.personId">
            <p>{{attendee.firstName}}</p>
        </div>
    </div>    
</template>

<script>
import APIService from '@/service/APIService';

export default {
    name: 'camp-attendees',
    props: {
        campName
    },
    data() {
        attendees: []
    },
    methods: {
        getAttendees(campName){
            APIService.getAttendeesByCamp(campName)
            .then(data = this.attendees = attendees);
        }
    },
    created() {
        getAttendees();
    }
}
</script>

<style>
</style>