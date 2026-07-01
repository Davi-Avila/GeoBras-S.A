<script setup lang="ts">
import { ref, onMounted } from 'vue'
import http from '@/http'
import CardOrcamento from '@/components/CardOrcamento.vue'
import { RouterLink } from 'vue-router'
import { getOrcamentos } from '@/service/api'
import type { Orcamento } from '@/interfaces/Orcamento'

const orcamentos = ref([] as Orcamento[])
const id = ref<number | null>(null)
const carregando = ref(true)

async function pesquisarOrcamento() {
    const response = await http.get(`/orcamento/${id}`)
    orcamentos.value = [response.data]
    carregando.value = false
}
onMounted(async () => {
  const response = await getOrcamentos()
  orcamentos.value = response
  carregando.value = false
})

</script>
<template>
  <div style="display: flex;flex-direction: row;width: 100%;margin-top: 20px;">
    <div style="display: flex;width: 100%;justify-content: center;">
        <h1 >Orçamento</h1>
    </div>
      <div style="display: flex;justify-content: end;margin-right: 20px;width: 100%;position: absolute;">
          <RouterLink to="/orcamento/novo" class="btn btn-primary" style="background-color: #302c9b;">
        + Novo Orçamento
        </RouterLink>
      </div>
  </div>
      
      
      

        
    <div style="display: flex; justify-content: center; align-items: center; width: 100%;">
        <div class="input-group mb-5" style="width: 50%">
            <input v-model="id" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" placeholder="Digite o id do Orçamento">
            <button @click="pesquisarOrcamento()" class="btn btn-outline-secondary" type="button">Pesquisar</button>
        </div>
    </div>

    <div style="display: flex;flex-direction: row;width: 100%;justify-content: center; gap: 10px;height: 100%;flex-wrap: wrap;">
      <div v-for="orcamento in orcamentos" :key="orcamento.idOrcamento" class="col-12 col-md-4 col-lg-3">
        <CardOrcamento :orcamento="orcamento"/>
      </div>
    </div>
    
    
</template>
<style>
</style>