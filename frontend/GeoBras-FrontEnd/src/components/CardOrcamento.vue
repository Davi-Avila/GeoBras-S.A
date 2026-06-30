<script setup lang="ts">
import Orcamento  from '@/interfaces/Orcamento';
import { type PropType } from 'vue';
defineProps({
    orcamento: {
        type: Object as PropType<Orcamento>,
        required: true
    }
})
</script>

<template>
    <div style="width: 15% ;height: 200px;">

        <div class="card h-100 shadow border-0">
          <div class="card-body col d-flex flex-column justify-content-center text-start">
            <h6 class="card-title fw-bold ">Id - {{orcamento.idOrcamento}}</h6>
            
            <p class="text small mb-0">
              <i class="bi bi-person "> Deslocamento - {{ orcamento.deslocamento }}</i>
            </p>
            <p class="text small mb-0">
              <i class="bi bi-hammer "> Mão de obra - {{ orcamento.maoDeObra }}</i>
            </p>
            <p class="text small mb-0">
              <i class="bi bi-mortarboard "> Serviço - {{ orcamento.servico }}</i>
            </p>
            <p class="text small mb-0">
              <i class="bi bi-cash text-success"> Imposto - {{ orcamento.imposto }}</i>
            </p>
            <p class="text small mb-0">
              <i class="bi bi-cash text-success"> Aluguel de equipamento - {{ orcamento.aluguelDeEquipamento }}</i>
            </p>
            <p class="text small mb-0">
              <i class="bi bi-cash text-success"> Orçamento total - {{ orcamento.orcamentoTotal }}</i>
            </p>

              
          </div>
        </div>
    </div>

</template>