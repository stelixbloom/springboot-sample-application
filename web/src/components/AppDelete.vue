<template>
  <v-container>
    <v-row>
      <v-col cols="12">
        <h1>選択されたPersonの削除</h1>
        <p style="margin-top: 15px;">本当に削除しますか？</p>
        <v-btn color="red" dark @click="deletePerson" class="mr-2" style="margin-top: 15px;">削除する</v-btn>
        <v-btn color="primary" @click="goBack" style="margin-top: 15px;">一覧に戻る</v-btn>
      </v-col>
    </v-row>
  </v-container>
</template>


<script>
import axios from 'axios';

export default {
  data() {
    return {
      id: ''
    };
  },
  methods: {
    deletePerson() {
      axios.delete('http://localhost:8081/person/delete/' + this.$route.params.personId)
          .then(() => {
            this.$router.push({ name: 'list' });
          })
          .catch(error => {
            console.error(error);
          });
    },
    goBack() {
      this.$router.push('/list');
    }
  },
}
</script>