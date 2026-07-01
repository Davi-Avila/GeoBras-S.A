<script setup lang="ts">
import type Obra  from '@/interfaces/Obra';
import { type PropType } from 'vue';
defineProps({
    obra: {
        type: Object as PropType<Obra>,
        required: true
    }
})
</script>
<template>
    <div style="width: 15% ;height: 200px;">

        <div class="card h-100 shadow border-0">
          <div class="card-body col d-flex flex-column justify-content-center text-start">
            <h6 class="card-title fw-bold ">Id - {{ obra.idObra }}</h6>
            
            <p class="text small mb-0">
              <i class="bi bi-building "> Nome da Obra - {{ obra.nomeObra }}</i>
            </p>
            <p class="text small mb-0">
              <i class="bi bi-house "> Endereço - {{ obra.endereco }}</i>
            </p>
            <p class="text small mb-0">
              <i class="bi bi-calendar "> Data inicial - {{ obra.dataInicio }}</i>
            </p>
            <p class="text small mb-0">
              <i class="bi bi-calendar-check "> Data final - {{ obra.dataFimPrevisto }}</i>
            </p>
            <p class="text small mb-0">
              <i class="bi bi-clipboard "> Etapa - {{ obra.etapa }}</i>
            </p>
            <p class="text small mb-0">
              <i class="bi bi-person "> Nome do cliente - {{ obra.nomeCliente }}</i>
            </p>
            <p class="text small mb-0">
              <i class="bi bi-at "> Email - {{ obra.email }}</i>
            </p>

              
          </div>
        </div>
    </div>

</template>
   