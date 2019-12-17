<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        There were problems registering this user.
      </div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      <label for="firstName" class="sr-only">First Name</label>
      <input
        type="first_name"
        id="firstName"
        class="form-control"
        placeholder="First Name"
        v-model="person.firstName"
        required
      />
      <label for="lastName" class="sr-only">Last Name</label>
      <input
        type="last_name"
        id="lastName"
        class="form-control"
        placeholder="Last Name"
        v-model="person.lastName"
        required
      />
      <label for="preferredName" class="sr-only">Preferred Name</label>
      <input
        type="preferred_name"
        id="preferredName"
        class="form-control"
        placeholder="Preferred Name"
        v-model="person.preferredName"
        required
      />
      <label for="dateOfBirth" class="sr-only">Date Of Birth</label>
      <input
        type="date_of_birth"
        id="dateOfBirth"
        class="form-control"
        placeholder="Date Of Birth"
        v-model="person.dateOfBirth"
        required
      />
      <label for="email" class="sr-only">Email</label>
      <input
        type="email"
        id="email"
        class="form-control"
        placeholder="Email"
        v-model="person.email"
        required
      />
      <label for="phone" class="sr-only">Phone</label>
      <input
        type="phone"
        id="phone"
        class="form-control"
        placeholder="Phone"
        v-model="person.phone"
        required
      />
      <router-link :to="{ name: 'login' }">
        Have an account?
      </router-link>
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
    </form>
  </div>
</template>

<script>
export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      person: {
            firstName: '',
            lastName: '',
            preferredName: '',
            dateOfBirth: '',
            email: '',
            phone: ''
      },
      registrationErrors: false,
    };
  },
  methods: {
    register() {
      fetch(`${process.env.VUE_APP_REMOTE_API}/register`, {
        method: 'POST',
        headers: {
          Accept: 'application/json',
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(this.user, this.person),
      })
        .then((response) => {
          if (response.ok) {
            this.$router.push({ path: '/login', query: { registration: 'success' } });
          } else {
            this.registrationErrors = true;
          }
        })

        .then((err) => console.error(err));
    },
  },
};
</script>

<style>
</style>
