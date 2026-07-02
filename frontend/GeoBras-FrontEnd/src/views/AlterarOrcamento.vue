<script setup lang="ts">
import type { Orcamento } from '@/interfaces/Orcamento';
import { deleteOrcamento, getOrcamentoById, postOrcamento, putOrcamento } from '@/service/api';
import { onMounted, ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import { Toast } from "bootstrap"

const route = useRoute()
const orcamento = ref<Orcamento | null>(null)

const router = useRouter()
let toast: any = null
let toastExcluir: any = null

async function carregaOrcamento() {
    const idOrcamento = route.params.idOrcamento as string
    if (Number.isNaN(idOrcamento)) {
        console.error("ID do orçamento inválido")
        return
    }

    const response = await getOrcamentoById(idOrcamento)
    orcamento.value = response
    form.value = { ...response }

}

onMounted(() => {
    const toastLiveExample = document.getElementById('toast')
    toast = Toast.getOrCreateInstance(toastLiveExample!)

    const toastLiveExampleExcluir = document.getElementById('toastExcluir')
    toastExcluir = Toast.getOrCreateInstance(toastLiveExampleExcluir!)

    carregaOrcamento()

})


const form = ref<Orcamento>({} as Orcamento)

async function alterar(): Promise<void> {
    try {
        await putOrcamento(form.value)

        toast.show()
        setTimeout(() => { router.push("/orcamento") }, 2000)

    } catch {
        alert("Erro ao alterar orçamento!")
    }

}

async function excluir() {
    const confirmar = confirm("Tem certeza que deseja excluir este orçamento?")

    if (!confirmar) {
        return
    }

    try {
        await deleteOrcamento(form.value.idOrcamento)

        toastExcluir.show()
        setTimeout(() => {router.push("/orcamento") }, 2000)

    } catch {
        alert("Erro ao excluir orçamento!")
    }
}


</script>
<template>
    <div class="container">
        <div class="card mt-5">

            <div class="card-header">
                <h4 class="mb-0">Alteração de Orçamento</h4>
            </div>

            <div class="card-body">
                <form @submit.prevent="alterar">

                    <!-- Nome -->
                    <div class="mb-3">
                        <label for="nomeOrcamento" class="form-label">Nome</label>
                        <input id="nomeOrcamento" v-model="form.nomeOrcamento" type="text"
                            class="form-control bg-light text-dark" placeholder="Digite o nome do orçamento" required />
                    </div>

                    <!-- Valores -->
                    <div class="row">

                        <div class="col-md-6 mb-3">
                            <label for="deslocamento" class="form-label">
                                Deslocamento (KM)
                            </label>
                            <input id="deslocamento" v-model.number="form.deslocamento" type="number"
                                class="form-control bg-light text-dark" placeholder="0,00" required min="0" />
                        </div>

                        <div class="col-md-6 mb-3">
                            <label for="maoDeObra" class="form-label">
                                Mão de obra (R$)
                            </label>
                            <input id="maoDeObra" v-model.number="form.maoDeObra" type="number"
                                class="form-control bg-light text-dark" placeholder="0,00" required min="0" />
                        </div>

                        <div class="col-md-6 mb-3">
                            <label for="servico" class="form-label">
                                Serviço
                            </label>
                            <input id="servico" v-model="form.servico" type="text"
                                class="form-control bg-light text-dark" placeholder="Tipo de Serviço" required
                                min="0" />
                        </div>

                        <div class="col-md-6 mb-3">
                            <label for="aluguelDeEquipamento" class="form-label">
                                Aluguel de Equipamento (R$)
                            </label>
                            <input id="aluguelDeEquipamento" v-model.number="form.aluguelDeEquipamento" type="number"
                                class="form-control bg-light text-dark" placeholder="0,00" required min="0" />
                        </div>

                        <div class="col-md-6 mb-3">
                            <label for="somaMateriais" class="form-label">
                                Custo de Materiais (R$)
                            </label>
                            <input id="somaMateriais" v-model.number="form.somaMateriais" type="number"
                                class="form-control bg-light text-dark" placeholder="0,00" required min="0" />
                        </div>

                        <div class="col-md-6 mb-3">
                            <label for="imposto" class="form-label">
                                Imposto (%)
                            </label>
                            <input id="imposto" v-model.number="form.imposto" type="number"
                                class="form-control bg-light text-dark" placeholder="0,00" required min="0" />
                        </div>

                    </div>

                    <div class="d-flex justify-content-between">
                        <RouterLink to="/orcamento" type="button" class="btn btn-outline-secondary px-4">
                            Cancelar
                        </RouterLink>

                        <button type="button" class="btn btn-danger px-4" @click="excluir">
                            Excluir
                        </button>

                        <button type="submit" class="btn btn-primary px-4">
                            Alterar
                        </button>

                    </div>

                </form>
            </div>
        </div>
    </div>

    <div class="toast-container position-fixed bottom-0 end-0 p-3">
        <div id="toast" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="toast-header text-bg-success">
                <strong class="me-auto">Concluído</strong>
                <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
            </div>
            <div class="toast-body">
                Orçamento cadastrado com sucesso!
            </div>
        </div>
    </div>

    <div class="toast-container position-fixed bottom-0 end-0 p-3">
        <div id="toastExcluir" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="toast-header text-bg-danger">
                <strong class="me-auto">Concluído</strong>
                <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
            </div>
            <div class="toast-body">
                Orçamento excluído com sucesso!
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
