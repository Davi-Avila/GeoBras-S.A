<script setup lang="ts">
import type { Orcamento } from '@/interfaces/Orcamento';
import { postOrcamento } from '@/service/api';
import { ref } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter()
const mensagem = ref("")


const form = ref<Orcamento>({
  idOrcamento: 0,
  nome: "",
  deslocamento: 0,
  maoDeObra: 0,
  servico: "",
  aluguelDeEquipamento: 0,
  somaMateriais: 0,
  imposto: 0,
  orcamentoTotal: 0
})

async function salvar(): Promise<void> {
  try {
    await postOrcamento({
      nome: form.value.nome,
      deslocamento: form.value.deslocamento,
      maoDeObra: form.value.maoDeObra,
      servico: form.value.servico,
      aluguelDeEquipamento: form.value.aluguelDeEquipamento,
      somaMateriais: form.value.somaMateriais,
      imposto: form.value.imposto,
      idOrcamento: 0,
      orcamentoTotal: 0
    })

    mensagem.value = "Orçamento cadastrado com sucesso!"
    setTimeout(() => {
      router.push("/orcamento")
    }, 1500)

  } catch {
    mensagem.value = "Erro ao cadastrar orçamento."
  }

}


</script>
<template>
  <div class="container mt-4">
    <div class="card shadow-sm">
      <div v-if="mensagem" class="alert alert-sucess" role="alert">
        {{ mensagem }}
      </div>

      <div class="card-header">
        <h4 class="mb-0">Cadastro de Orçamento</h4>
      </div>

      <div class="card-body">
        <form @submit.prevent="salvar">

          <!-- Nome -->
          <div class="mb-3">
            <label for="nome" class="form-label">Nome</label>
            <input id="nome" v-model="form.nome" type="text" class="form-control"
              placeholder="Digite o nome do orçamento" required/>
          </div>

          <!-- Valores -->
          <div class="row">

            <div class="col-md-6 mb-3">
              <label for="deslocamento" class="form-label">
                Deslocamento (KM)
              </label>
              <input id="deslocamento" v-model.number="form.deslocamento" type="number" class="form-control"
                placeholder="0,00" required/>
            </div>

            <div class="col-md-6 mb-3">
              <label for="maoDeObra" class="form-label">
                Mão de obra (R$)
              </label>
              <input id="maoDeObra" v-model.number="form.maoDeObra" type="number" class="form-control"
                placeholder="0,00" required/>
            </div>

            <div class="col-md-6 mb-3">
              <label for="servico" class="form-label">
                Serviço
              </label>
              <input id="servico" v-model="form.servico" type="text" class="form-control"
                placeholder="Tipo de Serviço" required/>
            </div>

            <div class="col-md-6 mb-3">
              <label for="aluguelDeEquipamento" class="form-label">
                Aluguel de Equipamento (R$)
              </label>
              <input id="aluguelDeEquipamento" v-model.number="form.aluguelDeEquipamento" type="number"
                class="form-control" placeholder="0,00" required/>
            </div>

            <div class="col-md-6 mb-3">
              <label for="somaMateriais" class="form-label">
                Custo de Materiais (R$)
              </label>
              <input id="somaMateriais" v-model.number="form.somaMateriais" type="number" class="form-control"
                placeholder="0,00" required/>
            </div>

            <div class="col-md-6 mb-3">
              <label for="imposto" class="form-label">
                Imposto (%)
              </label>
              <input id="imposto" v-model.number="form.imposto" type="number" class="form-control" placeholder="0,00" required/>
            </div>

          </div>

          <div class="d-flex justify-content-end">
            <button type="submit" class="btn btn-primary px-4">
              Cadastrar
            </button>
          </div>

        </form>
      </div>
    </div>
  </div>
</template>
<style>
.form-label {
  font-weight: 600;
  color: #dee1e4;
}

.card-header {
  background-color: #1e6ee6;
  color: white;
}

.card-header h4 {
  margin: 0;
}

.card {
  border: none;
  border-radius: 12px;
}

.form-control {
  border-radius: 8px;
}

.form-control:focus {
  box-shadow: 0 0 0 .2rem rgba(13, 110, 253, .25);
}
</style>
