<script setup lang="ts">
import { ref, onMounted } from 'vue'
import http from '@/http'
import type Obra from '@/interfaces/Obra'
import CardDaObra from '@/components/CardDaObra.vue'
import { RouterLink } from 'vue-router'
import { getObras } from '@/service/api'

const obras = ref([] as Obra[])
const id = ref<number | null>(null)
const carregando = ref(true)

async function pesquisarObra() {
    if(id.value) {
    try{
      const response = await http.get(`/obras/${id.value}`)
      obras.value = [response.data]
    } catch (error) {
      console.log('Erro ao buscar orçamento:')
      obras.value = []
    }
  }else {
    const response = await getObras()
    obras.value = response
    carregando.value = false
  }
}

onMounted(async () => {
  const response = await getObras()
  obras.value = response
  carregando.value = false
})
</script>

<template>

<div style="display: flex;flex-direction: row;width: 100%;margin-top: 2%;">
    <div style="display: flex;width: 100%;justify-content: center;">
        <h1 >Obras</h1>
    </div>
      <div style="display: flex;justify-content: end;margin-left: 90%;position: absolute;">
          <RouterLink to="/obra/nova" class="btn btn" style="background-color: #302c9b;">
        + Nova Obra
      </RouterLink>
      </div>
  </div>


    <div style="display: flex; justify-content: center; align-items: center; width: 100%;">
        <div class="input-group mb-5" style="width: 50%">
            <input v-model="id" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" placeholder="Digite o id da Obra">
            <button @click="pesquisarObra()" class="btn btn-outline-secondary" type="button">Pesquisar</button>
        </div>
    </div>

    <div style="display: flex;flex-direction: row;width: 100%;justify-content: center; gap: 2%;height: 100%;flex-wrap: wrap;">
      
    </div>
    <div v-if="obras && obras.length > 0" style="display: flex;flex-direction: row;width: 100%;justify-content: center; gap: 3%;height: 100%;flex-wrap: wrap;" class="row ps-4" >
        <div v-for="obra in obras" :key="obra.idObra" class="col-12 col-md-4 col-lg-3">
        <CardDaObra :obra="obra"/>
      </div>
      </div>
      <div v-else style="display: flex; justify-content: center; align-items: center; width: 100%;">
        <p class="text-dark">Nenhuma obra encontrada.</p>
      </div>
    
   
</template>

<style>
</style>
