<script setup lang="ts">
import type Obra from '@/interfaces/Obra';
import {ref} from 'vue'; 
  

const form = ref({} as Obra)

</script>

<template>
  
  <div class="conatiner-central">
  <form class="form-container">
   
    
    <div class="row">
    <div class="col-3 mb-3 ">
      <label  class="form-label"> Nome da Obra </label>
      <input type="text" class="form-control " v-model="form.nomeObra" required/>
     
    </div>
    <div class=" col-3 mb-3">
      <label class="form-label">Endereço</label>
      <input type="number" class="form-control" v-model="form.endereco"  required/>
    </div>
    </div>

    <div class="row">
      <div class="col-3 mb-3">
      <label class="form-label">Cliente</label>
      <input type="text" class="form-control " v-model="form.nomeCliente" required/>
    </div>
    <div class="col-3 mb-3">
      <label class="form-label">E-mail</label>
      <input type="Email" class="form-control " v-model="form.email" required/>
    </div>
    </div>

<div class="row g-3">
    <div class="col-3 mb-3">
      <label class="form-label">Data inicial</label>
      <input class="form-control " id="date" type="date" v-model="form.dataInicio" required/>
    </div>
    <div class="col-3 mb-3">Data final
    <input class="form-control " id="date" type="date" v-model="form.dataFimPrevisto" required/>
</div>

</div>
<div class="col-4">
          <label class="form-label">Status</label>
          <select class="form-select" v-model="form.etapa" required>
            <option value="" disabled>Selecione o status</option>
            <option>Aguardando</option>
            <option>Em andamento</option>
            <option>Concluído</option>
          </select>
        </div>
 
      
    <div class="col-2 mb-3">
      <label class="form-label">Orçamento total</label>
      <input type="number" class="form-control" v-model="form.orcamentoTotal"  required/>
    </div>
     
    <button class="cadastro btn btn-primary"   type="submit" >Cadastrar</button>
  </form>
  </div>
</template>
<style>

.form-container{
  padding-top: 5%;
  padding-left: 30%;
}
.cadastro{
  margin-left: 40%;
}
</style>
