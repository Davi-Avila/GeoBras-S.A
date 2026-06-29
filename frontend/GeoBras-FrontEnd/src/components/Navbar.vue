<script setup lang="ts">
import geobras_remove from "@/img/geobras_remove.png";
import {ref} from 'vue';

const isDark = ref(false)

function toggleTheme() {
  isDark.value = !isDark.value
  document.body.classList.toggle('dark')
}
</script>
<template>
  <nav class="navbar" style="background-color: #0047ab;padding: 0.5% 1%;height: 30%; ">
 <div class="container-fluid py-1 px-3">
  <div class="img_botao">
  <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#menuNavbar"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
    <RouterLink to="/">
      <img :src="geobras_remove" alt="Logo" class="logo" />
    </RouterLink>
</div>
    <div class="collapse navbar-collapse" id="menuNavbar">
        <ul class="navbar-nav ms-auto">
          <li class="nav-item">
            <RouterLink class="nav-link" to="/obra">Obra</RouterLink>
          </li>
          <li class="nav-item">
            <RouterLink class="nav-link" to="/orcamento">Orçamento</RouterLink>
          </li>
          <li class="nav-item">
            <RouterLink class="nav-link" to="/clientes">Clientes</RouterLink>
          </li>
        </ul>
      </div>
   
     <button class="btn ms-auto" style="color: white;" @click="toggleTheme">
      <i :class="isDark ? 'bi bi-sun-fill' : 'bi bi-moon-fill'"></i>
    </button>
  
  <div class="texto" margin-left: auto;>
    
      <input type="text" placeholder="Search..." 
      style="border-radius: 5cap; background-color:aliceblue ;border: none;">
   <i class="bi bi-search"></i>
  </div>
    </div>
  </nav>
</template>
<style>
body.dark {
  background-color: #1a1a1a !important;
  color: white !important;
}

body.dark .card {
  background-color: #2d2d2d !important;
  color: white !important;
  border-color: #444 !important;
}

body.dark .navbar {
  background-color: #111 !important;
}

body.dark .cards-wrapper {
  background-color: #1a1a1a !important;
}

body.dark a {
  color: #aaa !important;
}
li {
  list-style: none;
  text-decoration: none;
}
.logo {
  width: 20%;
  height: auto;
}
</style>
