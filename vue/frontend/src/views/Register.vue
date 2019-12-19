<template>
  <div id="register">
    <form class="form-register" @submit.prevent="register">
      <h1>Create Account</h1>
      <div class="alert" role="alert" v-if="registrationErrors">
        There were problems registering this user.
      </div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="registration.user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="registration.user.password"
        required
      />
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="registration.user.confirmPassword"
        required
      />
      <label for="firstName" class="sr-only">First Name</label>
      <input
        type="first_name"
        id="firstName"
        class="form-control"
        placeholder="First Name"
        v-model="registration.person.firstName"
        required
      />
      <label for="lastName" class="sr-only">Last Name</label>
      <input
        type="last_name"
        id="lastName"
        class="form-control"
        placeholder="Last Name"
        v-model="registration.person.lastName"
        required
      />
      <label for="preferredName" class="sr-only">Preferred Name</label>
      <input
        type="preferred_name"
        id="preferredName"
        class="form-control"
        placeholder="Preferred Name"
        v-model="registration.person.preferredName"
        required
      />
      <label for="dateOfBirth" class="sr-only">Date Of Birth</label>
      <input
        type="date_of_birth"
        id="dateOfBirth"
        class="form-control"
        placeholder="Date Of Birth"
        v-model="registration.person.dateOfBirth"
        required
      />
      <label for="email" class="sr-only">Email</label>
      <input
        type="email"
        id="email"
        class="form-control"
        placeholder="Email"
        v-model="registration.person.email"
        required
      />
      <label for="phone" class="sr-only">Phone</label>
      <input
        type="phone"
        id="phone"
        class="form-control"
        placeholder="Phone"
        v-model="registration.person.phone"
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
      registration: {
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
      }},
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
        body: JSON.stringify(this.registration),
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

<style scoped>
h1{
            font-family: 'Playfair Display', serif;
        }

        #register {
          width: 100%;
          padding: 8%;
          margin: 0;
          height: 100vh;
          background: url("http://localhost:8081/mountains.jpg") no-repeat center;
          background-size: cover;
        }

        .form-register {
            width: 45%;
            min-height: 50%;
            margin-left: auto;
            margin-right: auto;
            padding: 40px;
            background: rgba(255, 255, 255, 0.7);
            border: 1px solid white;
            text-align: center;
        }

        .form-register>textarea,
        .form-register>button,
        .form-register>input {
            margin-left: auto;
            margin-right: auto;
            margin-top: 10px;
            margin-bottom: 10px;
            display: block;
            border: 1px solid #792359;
            width: 60%;
            font-size: 0.9em;
            border-radius: 4px;
        }

        .form-register>button {
            border: 1px solid #DAC3D1;
            background-color: #792359;
            color: #ffffff;
            font-size: 1.5em;
            text-transform: uppercase;
            margin-left: auto;
            margin-right: auto;
            border-radius: 4px;
            padding: 0px 15px 0px 15px;
            box-shadow: 0px 0px 5px 1px darkgray;    
        }

        .focused {
            box-shadow: 0px 0px 7px 0px #C9D750;
        }
</style>
