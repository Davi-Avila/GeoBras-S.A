<script setup lang="ts">



defineProps(["titulo", "icone"])
</script>
<template>

    <div class="card" style="width: 18% ">
  <div class="card-body">
    <h5 class="card-title">{{ titulo }}</h5>
   
    <i :class="icone"></i>
  </div>
</div>

</template>