<script setup lang="ts">
import { ref, onMounted } from 'vue'
import http from '@/http'
import type Obra from '@/interfaces/Obra'
import CardDaObra from '@/components/CardDaObra.vue'

const obras = ref([] as Obra[])
const id = ref<number | null>(null)
const carregando = ref(true)

async function pesquisarObra() {
    const response = await http.get(`/obra/${id}`)
    obras.value = [response.data]
    carregando.value = false
}
</script>

<template>

<div style="display: flex;flex-direction: row;width: 100%;margin-top: 20px;">
    <div style="display: flex;width: 100%;justify-content: center;">
        <h1 >Obras</h1>
    </div>
      <div style="display: flex;justify-content: end;margin-right: 20px;width: 100%;position: absolute;">
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

    <div class="row g-4">
      <div v-for="obra in obras" :key="obra.idObra" class="col-12 col-sm-6 col-lg-3">
        <CardDaObra :obra="obra"/>
      </div>
    </div>
    
   
</template>

<style>
</style>