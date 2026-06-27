<script setup lang="ts">
defineProps(["titulo", "icone"]);
</script>
<template>
  <div class="card-group" style="gap: 1rem;">
    <RouterLink :to="`/obra`">
      <div class="card  ">
        <div class="card-body" style="text-align: center">
          <i class="bi bi-buildings"></i>
          <P></P>
          <a typeof="/obra">Obras</a>
        </div>
      </div>
    </RouterLink>
    <RouterLink :to="`/obra`">
      <div class="card">
        <div class="card-body" style="text-align: center">
         <i class="bi bi-coin"></i>
          <P></P>
          <a typeof="/obra">Orçamento</a>
        </div>
      </div>
    </RouterLink>
    <RouterLink :to="`/obra`">
      <div class="card">
        <div class="card-body" style="text-align: center">
         <i class="bi bi-coin"></i>
          <P></P>
          <a typeof="/obra">Clientes</a>
        </div>
      </div>
    </RouterLink>
    
  </div>
</template>
