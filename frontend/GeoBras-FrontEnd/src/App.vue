<script setup lang="ts">
import Navbar from './components/Navbar.vue'
</script>

<template>
  <Navbar />
<RouterView />

 
</template>

<style >

body {
  background-color: #f8f9fa;
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}

/* Estilo da rota ativa — adicionado ao vivo para explicar router-link-active */
.navbar-nav .router-link-active {
  color: #ffc107 !important;
  font-weight: bold;
  border-bottom: 2px solid #ffc107;
}
</style>
