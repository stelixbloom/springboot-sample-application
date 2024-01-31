<template>
  <v-container>
    <v-row>
      <v-col cols="12">
        <h1>新規Personの追加</h1>

        <form @submit.prevent="addPerson">
          <v-text-field
            label="名前"
            type="text"
            id="name"
            v-model="person.name"
            required
          ></v-text-field>

          <v-text-field
            label="年齢(半角整数)"
            type="number"
            id="age"
            v-model="person.age"
            required
          ></v-text-field>

          <v-select
            label="性別"
            id="gender"
            v-model="person.gender"
            :items="['男', '女']"
            required
          ></v-select>

          <v-text-field
            label="職業"
            type="text"
            id="occupation"
            v-model="person.occupation"
            required
          ></v-text-field>

          <v-btn type="submit" color="success">追加</v-btn>
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
        name: '',
        age: '',
        gender: '',
        occupation: ''
      }
    }
  },
  methods: {
    addPerson() {
      axios.post('http://localhost:8081/person/register', this.person)
          .then(response => {
            console.log(response.data);
            this.goBack();
          })
          .catch(error => {
            console.error(error);
          });
    },
    goBack() {
      this.$router.push('list');
    }
  }
}
</script>
