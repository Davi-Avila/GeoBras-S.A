<script setup lang="ts">
import { ref, onMounted } from 'vue';
import { getClientes, getOrcamentos, getOrcamentosDisponiveis, postObra } from '../service/api';
import { useRouter } from 'vue-router'
import type { Orcamento } from '@/interfaces/Orcamento';
import type { Obra } from '@/interfaces/Obra';
import type Cliente from '@/interfaces/Cliente';

const router = useRouter()

const orcamentos = ref<Orcamento[]>([])
const clientes = ref<Cliente[]>([])

const form = ref<Obra>({} as Obra)

// Carrega os orçamentos disponíveis assim que a página abre, pra popular o select
onMounted(async () => {
  try {
    orcamentos.value = await getOrcamentosDisponiveis()
    clientes.value = await getClientes()
  } catch (error) {
    console.error(error)
    alert('Erro ao carregar orçamentos ou clientes.')
  }
})


function dataFinalValida(dataInicio: string, dataFim: string): boolean {
  if (!dataInicio || !dataFim) return true
  return new Date(dataFim) >= new Date(dataInicio)
}

function validarData(): boolean{
  if (!dataFinalValida(form.value.dataInicio, form.value.dataFimPrevisto)) {
    alert('A data final não pode ser anterior à data inicial.')
    return false
  }
  return true
}


async function salvar(): Promise<void> {

  // Busca o orçamento selecionado para obter o valor total correspondente,
  // já que o formulário não guarda esse valor diretamente
  const orcamentoSelecionado = orcamentos.value.find(
    o => o.idOrcamento === form.value.idOrcamento
  )
  const clienteSelecionado = clientes.value.find(
    c => c.idCliente === form.value.idCliente
  )

  if (!validarData()){
    return
  }


  try {
    await postObra(form.value)

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
    nomeObra: "",
    endereco: "",
    dataInicio: "",
    dataFimPrevisto: "",
    etapa: "",
    orcamentoTotal: 0,
    nomeCliente: "",
    email: "",
    idCliente: 0,
    idOrcamento: 0
  }
}

</script>

<template>

  <div class="container">
    <div class="card mt-5">

      <div class="card-header">
        <h4 class="mb-0">Cadastro de Obra</h4>
      </div>

      <div class="card-body">
        <form @submit.prevent="salvar">

          <div class="mb-3">
            <label for="nomeObra" class="form-label">Nome da Obra</label>
            <input id="nomeObra" v-model="form.nomeObra" type="text" class="form-control form-control-light"
              placeholder="Digite o nome da obra" required />
          </div>

          <div class="row">

            <div class="col-md-6 mb-3">
              <label for="endereco" class="form-label">Endereço</label>
              <input type="text" class="form-control form-control-light" v-model="form.endereco" placeholder="Rua Sete de Setembro, 123" required/>
            </div>

            <div class="col-md-6 mb-3">
              <label for="etapa" class="form-label">Status</label>
              <select class="form-select" v-model="form.etapa" required>
                <option value="" disabled>Selecione o status</option>
                <option>Aguardando</option>
                <option>Em andamento</option>
                <option>Concluído</option>
              </select>
            </div>

            <div class="col-md-6 mb-3">
              <label for="dataInicio" class="form-label">Data inicial</label>
              <input class="form-control form-control-light" id="dataInicio" type="date" v-model="form.dataInicio" required/>
            </div>

            <div class="col-md-6 mb-3">
              <label for="dataFimPrevisto" class="form-label">Data final prevista</label>
              <input class="form-control form-control-light" id="dataFim" type="date" v-model="form.dataFimPrevisto" required/>
            </div>

            <div class="col-md-6 mb-3">
              <label for="idOrcamento" class="form-label">Orçamento</label>
              <select class="form-select" v-model.number="form.idOrcamento" required>
                <option :value="0" disabled>Selecione um orçamento</option>
                <option v-for="orcamento in orcamentos" :key="orcamento.idOrcamento" :value="orcamento.idOrcamento">
                  {{ orcamento.nomeOrcamento }} — R$ {{ orcamento.orcamentoTotal }}
                </option>
              </select>
            </div>

            <div class="col-3 mb-3">
              <label for="idCliente" class="form-label">Cliente</label>
              <select class="form-select" v-model.number="form.idCliente" required>
                <option :value="0" disabled>Selecione um cliente</option>
                <option v-for="cliente in clientes" :key="cliente.idCliente" :value="cliente.idCliente">
                  {{ cliente.nomeCliente }} — {{ cliente.email }}
                </option>
              </select>
            </div>
          </div>


          <div class="d-flex justify-content-between">
            <RouterLink to="/obra" type="button" class="btn btn-secondary px-4">
              Cancelar
            </RouterLink>

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
  background-color: 13, 110, 253, .25;
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

.container {
  display: block !important;
}
</style>
