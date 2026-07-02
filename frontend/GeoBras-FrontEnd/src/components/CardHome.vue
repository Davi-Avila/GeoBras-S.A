<script setup lang="ts">
defineProps(["titulo", "icone"]);
</script>
<template>
  <div class="row">
    <div class="col-sm-4 mb-3 mb-sm-0">
      <RouterLink :to="`/obra`">
        <div class="card">
          <div class="card-body">
            <i class="card-title bi bi-buildings"></i>
            <p class="card-text" style="color: white">Obras</p>
          </div>
        </div>
      </RouterLink>
    </div>
    <div class="col-sm-4">
      <RouterLink :to="`/orcamento`">
        <div class="card">
          <div class="card-body">
            <i class="card-title bi bi-coin"></i>
            <p class="card-text" style="color: white">Orçamento</p>
          </div>
        </div>
      </RouterLink>
    </div>
    <div class="col-sm-4">
      <RouterLink :to="`/clientes`">
        <div class="card">
          <div class="card-body">
            <i class="card-title bi bi-person"></i>
            <p class="card-text">Clientes</p>
          </div>
        </div>
      </RouterLink>
    </div>
  </div>
</template>
<style>
.card {
  background-color: #0047ab;
  text-align: center;
  padding: 10%;
  margin-top: 10%;
}

.card-title,p {
  color: white;
}
</style>
