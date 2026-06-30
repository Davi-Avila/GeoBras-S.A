<script setup lang="ts">
import { ref, onMounted } from "vue";
import http from "@/http";
import type Obra from "@/interfaces/Obra";
import CardHome from "@/components/CardHome.vue";

const obra = ref([] as Obra[]);
</script>

<template>
  <div class="container">
    <CardHome titulo="obra" />
  </div>
</template>
<style></style>
