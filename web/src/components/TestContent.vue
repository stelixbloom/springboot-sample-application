<template>
  <p>{{ dataTest }}</p>
  <p>{{ text }}</p>
</template>

<script setup>
import { defineProps } from 'vue';

const dataTest = "defineProps！！！！！";

defineProps({
  text: String,
})
</script>