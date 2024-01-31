<template>
  <v-container>
    <v-row>
      <v-col cols="12">
        <v-card class="mb-4" color="light-blue lighten-4" dark>
          <v-card-title class="headline">詳細表示</v-card-title>
          <v-card-text>
            <v-list dense>
              <v-list-item>
                <v-list-item-icon>
                  <v-icon>mdi-account-card-details-outline</v-icon>
                </v-list-item-icon>
                <v-list-item-content>
                  <v-list-item-title><strong>ID: </strong>{{ person.id }}</v-list-item-title>
                </v-list-item-content>
              </v-list-item>
              <v-list-item>
                <v-list-item-icon>
                  <v-icon>mdi-account</v-icon>
                </v-list-item-icon>
                <v-list-item-content>
                  <v-list-item-title><strong>名前: </strong>{{ person.name }}</v-list-item-title>
                </v-list-item-content>
              </v-list-item>
              <v-list-item>
                <v-list-item-icon>
                  <v-icon>mdi-calendar</v-icon>
                </v-list-item-icon>
                <v-list-item-content>
                  <v-list-item-title><strong>年齢: </strong>{{ person.age }}</v-list-item-title>
                </v-list-item-content>
              </v-list-item>
              <v-list-item>
                <v-list-item-icon>
                  <v-icon>mdi-gender-male-female</v-icon>
                </v-list-item-icon>
                <v-list-item-content>
                  <v-list-item-title><strong>性別: </strong>{{ person.gender }}</v-list-item-title>
                </v-list-item-content>
              </v-list-item>
              <v-list-item>
                <v-list-item-icon>
                  <v-icon>mdi-briefcase-outline</v-icon>
                </v-list-item-icon>
                <v-list-item-content>
                  <v-list-item-title><strong>職業: </strong>{{ person.occupation }}</v-list-item-title>
                </v-list-item-content>
              </v-list-item>
            </v-list>
          </v-card-text>
        </v-card>
        <v-btn color="primary" @click="goBack">一覧に戻る</v-btn>
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
      }
    }
  },
  methods: {
    goBack() {
      this.$router.push('/list');
    }
  },
  created() {
    axios.get(`http://localhost:8081/person/${this.$route.params.personId}`)
      .then(response => {
        this.person = response.data;
      })
      .catch(error => {
        console.error(error);
      });
  }
}
</script>
