<template>
  <v-app>
    <v-main>
      <v-toolbar color="cyan">
        <v-toolbar-title>Person管理アプリケーション</v-toolbar-title>
        <v-spacer></v-spacer>
        <v-toolbar-items>
          <v-btn text to="/menu">Home</v-btn>
          <v-btn text to="/menu">Information</v-btn>
        </v-toolbar-items>
      </v-toolbar>
      <div style="display: flex; height: 100%;">
        <v-col cols="2" style="border-right: 1px solid black;">
          <div style="background-color: lightblue; height: 100%;">
            <!-- 左側のコンテンツ -->
          </div>
        </v-col>
        <v-col cols="8" style="border-right: 1px solid black;">
          <router-view />
        </v-col>
        <v-col cols="2">
          <div style="background-color: lightblue; height: 100%;">
            <!-- 右側のコンテンツ -->
          </div>
        </v-col>
      </div>
      <v-footer color="cyan" app>
        <span class="white--text">&copy; 2023</span>
      </v-footer>
    </v-main>
  </v-app>
</template>

<script>
export default {
  name: 'App',

  data: () => ({
    //
  }),
}
</script>
