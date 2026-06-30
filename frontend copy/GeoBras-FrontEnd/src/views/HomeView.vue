<script setup lang="ts">
import { ref, onMounted } from 'vue'
import http from '@/http'
import type Obra from '@/interfaces/Obra';
import CardObra from '@/components/CardObra.vue';

const obra = ref ([] as Obra[])
 




</script>

<template>
    
    <div class="container ">
        <CardObra titulo="obra"/>
        
    </div>
</template>
<style>
.container {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 3%;
  padding: 10%;
}
</style>