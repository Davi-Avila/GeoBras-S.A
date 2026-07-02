<script setup lang="ts">
import geobras_remove from "@/img/geobras_remove.png";
import {ref} from 'vue';
import { RouterLink } from "vue-router";

const isDark = ref(false)

function toggleTheme() {
  isDark.value = !isDark.value
  document.body.classList.toggle('dark')
}
</script>
<template>
  <nav class="navbar navbar-dark sticky-top" style="background-color: #0047ab;">
  <div class="container-fluid">

    <!-- Botão do menu -->
    <button
      class="navbar-toggler me-3"
      type="button"
      data-bs-toggle="offcanvas"
      data-bs-target="#offcanvasNavbar"
      aria-controls="offcanvasNavbar"
    >
      <span class="navbar-toggler-icon"></span>
    </button>

    <!-- Logo -->
    <RouterLink to="/" class="navbar-brand">
      <img :src="geobras_remove" alt="Logo" class="logo" />
    </RouterLink>

    <!-- Botão tema -->
    <button class="btn text-white" @click="toggleTheme">
      <i :class="isDark ? 'bi bi-sun-fill' : 'bi bi-moon-fill'"></i>
    </button>

    <!-- Menu lateral -->
    <div
      class="offcanvas offcanvas-start text-bg-dark"
      tabindex="-1"
      id="offcanvasNavbar"
      aria-labelledby="offcanvasNavbarLabel"
    >
      <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasNavbarLabel">
          Menu
        </h5>

        <button
          type="button"
          class="btn-close btn-close-white"
          data-bs-dismiss="offcanvas"
        ></button>
      </div>

      <div class="offcanvas-body">
        <ul class="navbar-nav">

          <li class="nav-item">
            <RouterLink
              class="nav-link"
              to="/obra"
            >
              Obra
            </RouterLink>
          </li>

          <li class="nav-item">
            <RouterLink
              class="nav-link"
              to="/orcamento"
            >
              Orçamento
            </RouterLink>
          </li>

          <li class="nav-item">
            <RouterLink
              class="nav-link"
              to="/clientes"
            >
              Clientes
            </RouterLink>
          </li>
        </ul>
      </div>
    </div>

  </div>
</nav>
</template>
<style>
.logo {
  width: 120px;
  height: auto;
}

body .offcanvas{
  background-color: #052c65 !important;
}

body.dark {
  background-color: #1a1a1a !important;
  color: white !important;
}

body.dark .navbar {
  background-color: #111 !important;
}

body.dark .offcanvas {
  background-color: #052c65 !important;
}

body.dark .nav-link {
  color: #fff !important;
}

body.dark .form-control {
  background-color: #2d2d2d !important;
  color: white;
  border-color: #555 !important;
}

body.dark .card{
  background-color: #2d2d2d !important;
  color: white !important;
  border-color: #555 !important;
}
body.dark .charts-frame{
   background-color: #2d2d2d !important;
  color: white !important;
  border-color: #555 !important; 
}
body.dark .chart-card h3 {
  color: #e0e0e0 !important;
}

body.dark .bar-wrapper {
  background-color: #1f1f1f !important;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.3);
}

body.dark .chart-value {
  color: #4d90fe !important;
}

body.dark .charts-title {
  color: #4d90fe !important;
}

body.dark .form-control-light {
    background: white !important;
    color: black !important;
    border-color: #ced4da !important;
}

.card-header,
.card-header h4 {
    color: white !important;
}

</style>
