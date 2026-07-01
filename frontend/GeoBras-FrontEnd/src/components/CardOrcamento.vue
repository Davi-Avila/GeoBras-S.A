<script setup lang="ts">
import type { Orcamento } from '@/interfaces/Orcamento';
import { type PropType } from 'vue';
defineProps({
    orcamento: {
        type: Object as PropType<Orcamento>,
        required: true
    }
})
</script>

<template>
    <div style="width: 100% ;">

        <div class="card h-80 shadow border-0">
          <div style="width: 100%;height: 250px; font-size: 1.1rem;" >
            
            <h6 class="card-title fw-bold " style="margin-bottom: 5px;justify-self: start;">Id - {{orcamento.idOrcamento}}</h6>
            <div style="margin-bottom: 5px;justify-content: start; display: flex;">
            <p class="text small mb-0">
              <i class="bi bi-person "> Deslocamento - {{ orcamento.deslocamento }}</i>
            </p>
            </div>
            <div style="margin-bottom: 5px;justify-content: start; display: flex;">
              <p class="text small mb-0">
              <i class="bi bi-hammer "> Mão de obra - {{ orcamento.maoDeObra }}</i>
            </p>
            </div>
            <div style="margin-bottom: 5px;justify-content: start; display: flex;">
              <p class="text small mb-0">
              <i class="bi bi-mortarboard "> Serviço - {{ orcamento.servico }}</i>
            </p>
            </div>
            
            <div style="margin-bottom: 5px;justify-content: start; display: flex;">
              <p class="text small mb-0">
              <i class="bi bi-cash "> Imposto  R$ {{ orcamento.imposto }}</i>
            </p>
            </div>
            <div style="margin-bottom: 5px;justify-content: start; display: flex;">
              <p class="text small mb-0">
              <i class="bi bi-cash "> Soma dos Materiais  R$ {{ orcamento.somaMateriais }}</i>
            </p>
            </div>
            
            
            <div style="margin-bottom: 5px;justify-content: start; display: flex;border-bottom: 1px solid #ccc; padding-bottom: 15px;">
              <p class="text small mb-0">
              <i class="bi bi-cash "> Aluguel de equipamento  R$ {{ orcamento.aluguelDeEquipamento }}</i>
            </p>
            </div>
            <div style="justify-content: start; display: flex;">
              <p class="text medium mb-0">
              <i class="bi bi-cash "> Orçamento total  R$ {{ orcamento.orcamentoTotal }}</i>
            </p>
            </div>
            

              
          </div>
        </div>
    </div>

</template>