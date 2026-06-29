<script setup lang="ts">
defineProps(["titulo", "icone"]);
</script>
<template>
<!--<div class="container">
  <div class="row align-items-stretch" >
    <div class="col-sm-4 mb-4 mb-sm-4">
     
    <RouterLink :to="`/obra`">
      <div class="card" style=" background-color: #0047ab;">
        <div class="card-body " style="text-align: center">
          <i class="bi bi-buildings" style="color: white;"></i>
          <P style="color: white;">Obras</P>
         
        </div>
      </div>
    </RouterLink>
  </div>

  <div class="col-sm-4 ">
    
    <RouterLink :to="`/obra`">
     <div class="card" style=" background-color: #0047ab;">
        <div class="card-body" style="text-align: center">
         <i class="bi bi-coin" style="color: white;"></i>
          <P style="color: white;">Orçamento</P>
          
        </div>
      </div>
    </RouterLink>
  </div>
  <div class="col-sm-4 ">
    <RouterLink :to="`/obra`">
      <div class="card" style=" background-color: #0047ab;">
        <div class="card-body" style="text-align: center; height: 30%;">
         <i class="bi bi-coin" style="color: white;"></i>
          <P style="color: white;">Clientes</P>
         
        </div>
      </div>
    </RouterLink>
    </div>
   
  </div> 
  </div>-->
  
  <div class="row">
  <div class="col-sm-4 mb-3 mb-sm-0">
    <RouterLink :to="`/obra`">
    <div class="card ">
      <div class="card-body " style="background-color: #0047ab; text-align: center;">
          <i class="card-title bi bi-buildings" style="color: white;"></i>
          <P class="card-text" style="color: white;">Obras</P>
      </div>
    </div>
  </RouterLink>
  
  </div>
  <div class="col-sm-4">
     <RouterLink :to="`/orcamento`">
    <div class="card">
      <div class="card-body" style="background-color: #0047ab; text-align: center;">
        <i class="card-title bi bi-coin" style="color: white;"></i>
          <P class="card-text" style="color: white;">Orçamento</P>
      </div>
    </div>
  </RouterLink>
  </div>
  <div class="col-sm-4">
    <RouterLink :to="`/clientes`">
    <div class="card">
      <div class="card-body" style="background-color: #0047ab; text-align: center;">
         <i class="card-title bi bi-coin" style="color: white;"></i>
          <P class="card-text" style="color: white;">Clientes</P>
      </div>
    </div>
  </RouterLink>
  </div>
</div>
</template>
