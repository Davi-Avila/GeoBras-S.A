<script setup lang="ts">
import { ref, onMounted } from 'vue'
import http from '@/http'
import type Orcamento from '@/interfaces/Orcamento'
import CardOrcamento from '@/components/CardOrcamento.vue'

const orcamentos = ref([] as Orcamento[])
const carregando = ref(true)

async function carregaOrcamentos() {
    const response = await http.get('/orcamento')
    orcamentos.value = response.data
    carregando.value = false
}

onMounted(carregaOrcamentos)
</script>
<template>
        <h1 style="display: flex; justify-content: center;margin-top: 20px;margin-bottom: 20px;">Orçamento</h1>

    <div style="display: flex; justify-content: center; align-items: center; width: 100%;">
        <div class="input-group mb-5" style="width: 50%">
            <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" placeholder="Digite o id do Orçamento">
            <button class="btn btn-outline-secondary" type="button">Pesquisar</button>
        </div>
    </div>

    <div class="row g-4">
      <div v-for="orcamento in orcamentos" :key="orcamento.idOrcamento" class="col-12 col-sm-6 col-lg-3">
        <CardOrcamento :orcamento="orcamento"/>
      </div>
    </div>
    
    
</template>
<style>
</style>