<script setup lang="ts">
import geobras_remove from '@/img/geobras_remove.png';
</script>
<template>
    <nav style="background-color: #0047AB; ; display: flex;color: white; flex-direction: row; align-items: center; padding: 0.5rem 1rem; height: 30%;">
      
    

      <RouterLink to="/" style="color: white; text-decoration: none; font-size: 1.5rem; font-weight: bold;">
        
        <img :src="geobras_remove" alt="Logo" class="logo">
      </RouterLink>


            <RouterLink to="/" style="color: white; text-decoration: none; font-size: 1.2rem; margin-left: 1rem;">
              <button typeof="/">home </button>
              
            </RouterLink>
     
        <i class="bi bi-list" style="font-size: 250%; margin-left: auto;" @click=""/>


    

  </nav>
</template>
<style >
li {
  list-style: none;
  text-decoration: none;

}
.logo{
   width: 20%;  
  height: auto; 
}
</style>