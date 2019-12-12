<template>
    <div class="sidebar">
        <p class="title">Filters</p>
        <ul>
            <li>Group by Account</li>
            <li>Age Group 6-8</li>
            <li>Age Group 9-11</li>
            <li>Age Group 12-14</li>
        </ul>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
    </div>
</template>

<script>
export default {
  name: 'applicant-filters',

  };
</script>

<style scoped>
        .sidebar {
            flex-basis: 25%;
            flex-grow: 0;
            flex-shrink: 0;
            background: #71C4C1;
            padding: 60px 15px 15px 15px;
        }
</style>
