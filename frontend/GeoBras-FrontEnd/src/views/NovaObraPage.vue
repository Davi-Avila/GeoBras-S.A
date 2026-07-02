<script setup lang="ts">
import type Obra from '@/interfaces/Obra';
import {ref} from 'vue'; 
import { postObra } from '../service/api';
import { useRouter } from 'vue-router'

const router = useRouter()

const form = ref({
  idObra: 0,
  nomeObra: '',
  endereco: '',
  nomeCliente: '',
  email: '',
  dataInicio: '',
  dataFimPrevisto: '',
  etapa: '',
  orcamentoTotal: 0
})



function validarFormulario(): boolean {
  if (!form.value.nomeObra || !form.value.endereco || !form.value.nomeCliente) {
    alert('Preencha todos os campos obrigatórios.')
    return false
  }
  return true
}

async function salvar(): Promise<void> {
  if (!validarFormulario()) return

  try {
   
    const obra: Obra = {
      idObra:          form.value.idObra,
      nomeObra:        form.value.nomeObra,
      endereco:        form.value.endereco,
      nomeCliente:     form.value.nomeCliente,
      email:           form.value.email,
      dataInicio:      new Date(form.value.dataInicio),
      dataFimPrevisto: new Date(form.value.dataFimPrevisto),
      etapa:           form.value.etapa,
      orcamentoTotal:  Number(form.value.orcamentoTotal)
    }

    await postObra(obra)

    alert('Obra cadastrada com sucesso!')
    limparFormulario()
    router.push({ name: 'obra' })
  } catch (error) {
    console.error(error)
    alert('Erro ao cadastrar obra.')
  }
}


function limparFormulario(): void {
  form.value = {
    idObra: 0,
    nomeObra: '',
    endereco: '',
    nomeCliente: '',
    email: '',
    dataInicio: '',
    dataFimPrevisto: '',
    etapa: '',
    orcamentoTotal: 0
  }
}

function cancelar(): void {
  router.push({ name: 'obra' })
}
</script>

<template>
  
  <div class="conatiner-central">
  <form class="form-container" @submit.prevent="salvar">
   
    
    <div class="row">
    <div class="col-3 mb-3 ">
      <label  class="form-label"> Nome da Obra </label>
      <input type="text" class="form-control " v-model="form.nomeObra" />
     
    </div>
    <div class=" col-3 mb-3">
      <label class="form-label">Endereço</label>
      <input type="text" class="form-control" v-model="form.endereco"  />
    </div>
    </div>

    <div class="row">
      <div class="col-3 mb-3">
      <label class="form-label">Cliente</label>
      <input type="text" class="form-control " v-model="form.nomeCliente" />
    </div>
    <div class="col-3 mb-3">
      <label class="form-label">E-mail</label>
      <input type="Email" class="form-control " v-model="form.email" />
    </div>
    </div>

<div class="row g-3">
    <div class="col-3 mb-3">
      <label class="form-label">Data inicial</label>
      <input class="form-control " id="date" type="date" v-model="form.dataInicio" />
    </div>
    <div class="col-3 mb-3">Data final
    <input class="form-control " id="date" type="date" v-model="form.dataFimPrevisto" />
</div>

</div>
<div class="col-4">
          <label class="form-label">Status</label>
          <select class="form-select" v-model="form.etapa" >
            <option value="" disabled>Selecione o status</option>
            <option>Aguardando</option>
            <option>Em andamento</option>
            <option>Concluído</option>
          </select>
        </div>
 
      
    <div class="col-2 mb-3">
      <label class="form-label">Orçamento total</label>
      <input type="number" class="form-control" v-model="form.orcamentoTotal"  />
    </div>
     <div class="row">
    <button class="btn btn-secondary col-1" type="button" @click="cancelar">Cancelar</button>
    <button class="cadastro btn btn-primary col-1"   type="submit" >Cadastrar</button>
   
  </div>
  </form>
  </div>
</template>
<style>

.form-container{
  padding-top: 5%;
  padding-left: 30%;
}
.cadastro{
  margin-left: 33%;
}

</style>
