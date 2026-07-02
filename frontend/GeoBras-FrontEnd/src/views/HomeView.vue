<script setup lang="ts">
import { ref, onMounted } from "vue";
import http from "@/http";
import type Obra from "@/interfaces/Obra";
import CardHome from "@/components/CardHome.vue";
import CardBoasVindas from "@/components/CardBoasVindas.vue";
import GraficoEscala from "@/components/GraficoEscala.vue";

const obra = ref([] as Obra[]);
</script>

<template>
<div class="container">
  <CardBoasVindas titulo="boasVindas"/>
</div>

  <div class="container">
    <CardHome titulo="obra" />
  </div>

  <div class="container">
    <GraficoEscala titulo="graficoE"/>
  </div>
</template>
<style></style>
