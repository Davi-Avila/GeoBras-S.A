<script setup lang="ts">
import { ref, onMounted } from 'vue'
import http from '@/http'
import { RouterLink } from 'vue-router'
import type Cliente from '@/interfaces/Cliente'
import { getClientes } from '@/service/api'
import CardCliente from '@/components/Cardcliente.vue'

const clientes = ref([] as Cliente[])
const id = ref<number | null>(null)
const carregando = ref(true)

async function carregarClientes() {
  carregando.value = true
  clientes.value = await getClientes()
  carregando.value = false
}

async function pesquisarCliente() {
  if (id.value == null || id.value === 0) {
    await carregarClientes()
    return
  }
    try {
      const response = await http.get(`/clientes/${id.value}`)
      clientes.value = [response.data]
    } catch (error) {
      console.log('Erro ao buscar cliente')
      clientes.value = []
    }
}

async function limparPesquisa() {
  id.value = null
  await carregarClientes()
}

onMounted(async () => {
  carregarClientes()
})
</script>

<template>

  <div style="display: flex;flex-direction: row;width: 100%;margin-top: 2%;">
    <div style="display: flex;justify-content: end;margin-left: 85%;position: absolute;">
      <RouterLink to="/clientes/novo" class="btn btn-primary" style=" background-color: #302c9b;">
        + Novo Cliente
      </RouterLink>
    </div>
    <div style="display: flex;width: 100%;justify-content: center;">
      <h1></h1>
    </div>
  </div>


  <div style="display: flex; justify-content: center; align-items: center; width: 100%;">
    <div class="input-group mb-5" style="width: 50%">
      <input v-model="id" type="text" class="form-control" aria-label="Sizing example input"
        aria-describedby="inputGroup-sizing-default" placeholder="Digite o id do Cliente">
      <button @click="pesquisarCliente()" class="btn btn-outline-secondary" type="button">Pesquisar</button>
      <button @click="limparPesquisa" class="btn btn-outline-danger">Limpar</button>
    </div>
  </div>

  <div
    style="display: flex;flex-direction: row;width: 100%;justify-content: center; gap: 10px;height: 100%;flex-wrap: wrap;">

  </div>
  <div v-if="clientes && clientes.length > 0"
    style="display: flex;flex-direction: row;width: 100%;justify-content: center; gap: 10px;height: 100%;flex-wrap: wrap;"
    class="row ps-4">
    <div v-for="cliente in clientes" :key="cliente.idCliente" class="col-12 col-md-4 col-lg-3">
      <CardCliente :cliente="cliente" />
    </div>
  </div>
  <div v-else style="display: flex; justify-content: center; align-items: center; width: 100%;">
    <p class="text-dark">Nenhum cliente encontrado.</p>
  </div>


</template>

<style></style>