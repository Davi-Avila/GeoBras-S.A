<script setup lang="ts">
import type { Obra } from '@/interfaces/Obra';
import { type PropType } from 'vue';
defineProps({
    obra: {
        type: Object as PropType<Obra>,
        required: true
    }
})
</script>
<template>
    <div style="width: 100% ;">

        <div class="card h-100 shadow border-0" >
          <div style="width: 100%; font-size: 1.1rem;">

            <h6 class="card-title fw-bold ">Id - {{ obra.idObra }}</h6>

            <div style="margin-bottom: 5px;justify-content: start; display: flex;">
            <p class="text small mb-0">
              <i class="bi bi-building "> Nome da Obra - {{ obra.nomeObra }}</i>
            </p>
            </div>
            
            <div style="margin-bottom: 5px;justify-content: start; display: flex;">
            <p class="text small mb-0">
              <i class="bi bi-house "> Endereço - {{ obra.endereco }}</i>
            </p>
            </div>

            <div style="margin-bottom: 5px;justify-content: start; display: flex;">
            <p class="text small mb-0">
              <i class="bi bi-calendar "> Data inicial - {{ obra.dataInicio }}</i>
            </p>
            </div>
            
            <div style="margin-bottom: 5px;justify-content: start; display: flex;">
            <p class="text small mb-0">
              <i class="bi bi-calendar-check "> Data final - {{ obra.dataFimPrevisto }}</i>
            </p>
            </div>
            
            <div style="margin-bottom: 5px;justify-content: start; display: flex;">
            <p class="text small mb-0">
              <i class="bi bi-clipboard "> Etapa - {{ obra.etapa }}</i>
            </p>
            </div>

            <div style="margin-bottom: 5px;justify-content: start; display: flex;">
            <p class="text small mb-0">
              <i class="bi bi-person "> Nome do cliente - {{ obra.nomeCliente }}</i>
            </p>
            </div>
           
            <div style="margin-bottom: 5px;justify-content: start; display: flex;">
            <p class="text small mb-0">
              <i class="bi bi-at "> Email - {{ obra.email }}</i>
            </p>
            </div>

            <div style="margin-bottom: 5px;justify-content: start; display: flex;">
            <p class="text small mb-0">
              <i class="bi bi-cash "> Orçamento total - R${{ obra.orcamentoTotal }}</i>
            </p>
            </div>
            
             <div style="justify-content: start; display: flex;">
              <RouterLink :to="`/alterar-obras/${obra.idObra}`" class="btn btn-primary btn-lg mt-2 " type="button">Alterar</RouterLink>
            </div>


              
          </div>
        </div>
    </div>

</template>
   