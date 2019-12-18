<template>
        <div class="historyDetails">
                <table>
                    <tr class="top-row">
                        <td colspan="3">
                            <b>Record #{{historyrecord.historyId}}</b><br>
                            <b>{{historyrecord.dateOfChange.monthValue}}/{{historyrecord.dateOfChange.dayOfMonth}}/{{historyrecord.dateOfChange.year}}</b> by User ID {{historyrecord.updateMadeById}}<br>
                            <b>STATUS:</b> {{historyrecord.status}}
                        </td>
                    </tr>
                    <tr class="header-row">
                        <td>Data Changed</td>
                        <td>Old Value</td>
                        <td>New Value</td>
                    </tr>
                    <tr v-for="update in historyrecord.updatesMade" v-bind:key="update.historyId" class="update-row">
                        <td>{{update.dataElementChanged}}</td>
                        <td>{{update.oldValue}}</td>
                        <td>{{update.newValue}}</td>
                    </tr>
                </table>
        </div>
</template>

<script>
export default {
    name: 'history-details',
    props: [ 'historyrecord', 'source' ]
};
</script>

<style scoped>        
    table {
        width: 95%;
        margin-left: auto;
        margin-right: auto;
        /* border: 1px solid #fb8124; */
        border-radius: 4px;
        padding: 10px;
        margin-bottom: 15px;
        margin-top: 5px;
    }
    .top-row > td {
        font-size: 25px;
        padding-bottom: 15px;
        /* border-bottom: 1px solid red; */
    }
    .header-row > td {
        font-size: 24px;
        text-transform: uppercase;
        background-color: #792359;
        color: white;
    }
    .update-row > td {
        border: 1px solid #792359;
    }
</style>