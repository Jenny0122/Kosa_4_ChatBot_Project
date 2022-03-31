<template>
  <div id="container">
    <form @submit.prevent="submitForm">
      <div>
        <label for="id">id</label>
        <input type="text" id="id" v-model="id" />
      </div>
      <div>
        <label for="email">email</label>
        <input type="email" id="email" v-model="email" />
      </div>
      <div>
        <label for="password">비밀번호</label>
        <input type="password" id="password" v-model="password" />
      </div>
      <div>
        <label for="passwordConfirm">비밀번호 확인</label>
        <input type="password" id="passwordConfirm" v-model="passwordConfirm" />
      </div>
      <button type="submit">회원가입</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'SignUp',
  data: function() {
    return {
      id: '',
      email: '',
      password: '',
      passwordConfirm: ''
    }
  },
  methods: {
    submitForm: function() {
      console.log(this.id, this.email, this.password)
      var url = 'localhost:8080/signup/user'
      var data = {
        id: this.id,
        password: this.password
      }
      axios.post(url, data)
        .then(function(response) {
          console.log(response)
        })
        .catch(function(error) {
          console.log(error)
        })
    }
  }
}
</script>