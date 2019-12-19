<template>
    <div class="attendees">
        <h1>Registered Campers</h1>
        <div v-for="attendee in attendees" :key="attendee.personId">
            <p class="name">{{attendee.firstName}} {{attendee.lastName}}</p>
        </div>
    </div>    
</template>

<script>
export default {
    name: 'camp-attendees',
    props: {
        'attendees': []

    }
}
</script>

<style scoped>
  h1 {
    text-align: center;
            font-family: 'Playfair Display', serif;
    font-size: 1.3em;
  }
  .attendees {
      padding-left: 25px;
  }

  .name {
        background-color: #DAC3D1;
        padding: 5px 10px 5px 10px;
        border-radius: 4px;
        width: 75%;
        margin-left: auto;
        margin-right: auto;
        text-align: center;
        color: #792359;
        font-weight: bold;
    }
</style>