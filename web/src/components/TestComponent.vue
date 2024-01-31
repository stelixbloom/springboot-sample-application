<template>
  <button @click="sendMessage">メッセージを送る</button>
</template>

<script>
export default {
  methods: {
    sendMessage() {
      this.$emit("message", "$emit！！！！！")
    }
  }
}
</script>