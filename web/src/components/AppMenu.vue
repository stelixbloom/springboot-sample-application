<template>
  <div>
    <h1>管理メニューTop画面</h1>

    <div style="margin-top: 15px;">
      <p>Personの一覧を表示する</p>
      <v-btn @click="goToList" style="margin-top: 15px;">表示</v-btn>
    </div>
  </div>
</template>

<script>
import { useRouter } from 'vue-router'; // vue-routerのuseRouterをインポート

export default {
  setup() {
    const router = useRouter(); // ルーターインスタンスを取得
    const goToList = () => {
      router.push({ name: 'list' }); // リストページに遷移
    };
    return { goToList }; // goToList関数をテンプレートで利用可能にするために返す
  }
}
</script>
