<script setup lang="ts">
import type Cliente  from '@/interfaces/Cliente';
import { type PropType } from 'vue';
defineProps({
    cliente: {
        type: Object as PropType<Cliente>,
        required: true
    }
})
</script>
<template>
    <div style="width: 100% ;">

        <div class="card h-100 shadow border-0" >
          <div style="width: 100%; font-size: 1.1rem;">

            <h6 class="card-title fw-bold ">Id - {{ cliente.idCliente }}</h6>

            <div style="margin-bottom: 5px;justify-content: start; display: flex;">
            <p class="text small mb-0">
              <i class="bi bi-person "> Nome do Cliente - {{ cliente.nomeCliente }}</i>
            </p>
            </div>
            
            <div style="margin-bottom: 5px;justify-content: start; display: flex;">
            <p class="text small mb-0">
              <i class="bi bi-envelope "> Endereço - {{ cliente.email }}</i>
            </p>
            </div>

            <div style="margin-bottom: 5px;justify-content: start; display: flex;">
            <p class="text small mb-0">
              <i class="bi bi-map "> Pais - {{ cliente.pais }}</i>
            </p>
            </div>
            
            <div style="margin-bottom: 5px;justify-content: start; display: flex;">
            <p class="text small mb-0">
              <i class="bi bi-geo-alt-fill "> CEP - {{ cliente.CEP }}</i>
            </p>
            </div>
            
            <div v-if="cliente.CPF" style="margin-bottom: 5px;justify-content: start; display: flex;">
            <p class="text small mb-0">
              <i class="bi bi-clipboard "> CPF - {{ cliente.CPF }}</i>
            </p>
            </div>


            <div v-if="cliente.CNPJ" style="margin-bottom: 5px;justify-content: start; display: flex;">
            <p class="text small mb-0">
              <i class="bi bi-clipboard "> CNPJ - {{ cliente.CNPJ }}</i>
            </p>
            </div>
            
             <div style="justify-content: start; display: flex;">
              <RouterLink :to="`/alterar-cliente/${cliente.idCliente}`" class="btn btn-primary btn-lg mt-2 " type="button">Alterar</RouterLink>
            </div>

           
          </div>
        </div>
    </div>

</template>
   