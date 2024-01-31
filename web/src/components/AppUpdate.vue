<template>
  <v-container>
    <v-row>
      <v-col cols="12">
        <h1>更新画面</h1>
        <form @submit.prevent="submitForm" style="margin-top: 15px;">
          <p>各情報を更新してください。</p>

          <p style="margin-top: 15px;">
            <v-text-field
              label="名前"
              type="text"
              id="name"
              v-model="person.name"
              required
            ></v-text-field>
          </p>

          <p>
            <v-text-field
              label="年齢(半角整数)"
              type="number"
              id="age"
              v-model="person.age"
              required
            ></v-text-field>
          </p>

          <p>
            <v-select
              label="性別"
              id="gender"
              v-model="person.gender"
              :items="['男', '女']"
              required
            ></v-select>
          </p>

          <p>
            <v-text-field
              label="職業"
              type="text"
              id="occupation"
              v-model="person.occupation"
              required
            ></v-text-field>
          </p>

          <v-btn type="submit" color="info">更新</v-btn>
        </form>
        <v-btn @click="goBack" color="primary" style="margin-top: 15px;">一覧に戻る</v-btn>
      </v-col>
    </v-row>
  </v-container>
</template>


<script>
import axios from 'axios';

export default {
  data() {
    return {
      person: {
        id: '',
        name: '',
        age: '',
        gender: '',
        occupation: ''
      },
      persons: []
    }
  },
  methods: {
    submitForm() {
      axios.put('http://localhost:8081/person/update', this.person)
          .then(response => {
            console.log(response.data);
            this.goBack();
          })
          .catch(error => {
            console.error(error);
          });
    },
    goBack() {
      this.$router.push('/list');
    }
  },
  mounted() {
    axios.get(`http://localhost:8081/person/${this.$route.params.personId}`)
        .then((response) => {
          this.person = response.data;
        })
        .catch((error) => {
          console.error(error);
        });
  }
}
</script>
