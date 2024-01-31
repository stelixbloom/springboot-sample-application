<template>
  <div>
    <h1>一覧表示</h1>
    <v-data-table :headers="headers" :items="persons" item-key="id">
      <template v-slot:[`item.actions`]="{ item }">
        <div style="display: flex; justify-content: flex-end; gap: 20px;">
          <v-btn @click="selectPerson(item.id)" color="primary" small>詳細</v-btn>
          <v-btn @click="updatePerson(item.id)" color="info" small>更新</v-btn>
          <v-btn @click="deletePerson(item.id)" color="error" small>削除</v-btn>
        </div>
      </template>
    </v-data-table>

    <p>{{ message }}</p>

    <v-btn @click="registerNew" color="success" style="margin-right: 10px;">新規追加</v-btn>
    <v-btn @click="returnToMenu" color="primary" style="margin-right: 10px;">Topに戻る</v-btn>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      persons: [], // Person一覧を格納
      message: '', // 何かあればのメッセージを格納
      headers: [
        { text: 'id', value: 'id' },
        { text: '名前', value: 'name' },
        { text: '操作', value: 'actions', sortable: false },
      ],
    };
  },
  created() {
    axios.get('http://localhost:8081/person/list')
      .then(response => {
        this.persons = response.data;
      })
      .catch(error => {
        console.error(error);
      });
  },

  methods: {
    registerNew() {
      this.$router.push({ name: 'register' });
    },
    selectPerson(id) {
      this.$router.push({ name: 'person', params: { personId: id } });
    },
    updatePerson(id) {
      this.$router.push({ name: 'update', params: { personId: id } });
    },
    deletePerson(id) {
      this.$router.push({ name: 'delete', params: { personId: id } });
    },
    returnToMenu() {
      this.$router.push({ name: 'menu' });
    },
  },
};
</script>
