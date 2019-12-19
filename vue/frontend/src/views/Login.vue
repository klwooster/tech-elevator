<template>
  <div id="login">
    <form class="form-signin" @submit.prevent="login">
      <h1>Please Sign In</h1>
      <div class="alert" role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div class="success" role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
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
      <router-link :to="{ name: 'register' }">Need an account?</router-link>
      <button type="submit">Sign in</button>
    </form>
  </div>
</template>

<script>
import auth from '../auth';

export default {
  name: 'login',
  props: {
    'userStatus' : Boolean
  },
  components: {},
  data() {
    return {
      invalidCredentials: false,
      user: {
        username: '',
        password: ''
      }
    };
  },
  methods: {
    login() {
      fetch(`${process.env.VUE_APP_REMOTE_API}/login`, {
        method: 'POST',
        headers: {
          Accept: 'application/json',
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(this.user),
      })
        .then((response) => {
          if (response.ok) {
            this.userStatus = true;
            return response.text();
          } else {
            this.invalidCredentials = true;
          }
        })
        .then((token) => {
          if (token != undefined) {
            if (token.includes('"')) {
              token = token.replace(/"/g, '');
            }
            auth.saveToken(token);
            this.$router.push({ name: 'camphome' });
          }
        })
        .catch((err) => console.error(err));
    },
  },
  created() {
    this.userStatus = false;
  }
};
</script>

<style scoped>
        h1{
            font-family: 'Playfair Display', serif;
        }

        #login {
          width: 100%;
          padding: 15%;
          margin: 0;
          height: 100vh;
          background: url("http://localhost:8081/mountains.jpg") no-repeat center;
          background-size: cover;
        }

        .form-signin {
            width: 45%;
            min-height: 50%;
            margin-left: auto;
            margin-right: auto;
            padding: 40px;
            background: rgba(255, 255, 255, 0.7);
            border: 1px solid white;
            text-align: center;
            border-radius: 4px;
        }

        .form-signin>textarea,
        .form-signin>button,
        .form-signin>input {
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

        .form-signin>button {
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
