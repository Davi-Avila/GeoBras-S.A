<script setup lang="ts">
import type Cliente from '@/interfaces/Cliente';
import type { Obra } from '@/interfaces/Obra';
import type { Orcamento } from '@/interfaces/Orcamento';
import { deleteObra, getClientes, getObraById, getOrcamentosDisponiveis, putObra } from '@/service/api';
import { onMounted, ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';



const route = useRoute()
const router = useRouter()

const obra = ref<Obra | null>(null)
const form = ref<Obra>({} as Obra)

const orcamentos = ref<Orcamento[]>([])
const clientes = ref<Cliente[]>([])

async function carregaObra() {
    const idObra = Number(route.params.idObra)
    if (Number.isNaN(idObra)) {
        console.error("ID da obra inválido")
        return
    }

    const response = await getObraById(idObra)
    obra.value = response
    form.value = { ...response }

}

function dataFinalValida(dataInicio: string, dataFim: string): boolean {
    if (!dataInicio || !dataFim) return true
    return new Date(dataFim) >= new Date(dataInicio)
}

function validarData(): boolean {
    if (!dataFinalValida(form.value.dataInicio, form.value.dataFimPrevisto)) {
        alert('A data final não pode ser anterior à data inicial.')
        return false
    }
    return true
}

async function alterar(): Promise<void> {
    const orcamentoSelecionado = orcamentos.value.find(
        o => o.idOrcamento === form.value.idOrcamento
    )
    const clienteSelecionado = clientes.value.find(
        c => c.idCliente === form.value.idCliente
    )

    if (!validarData()) {
        return
    }

    try {
        await putObra(form.value)

        alert('Obra alterada com sucesso!')
        router.push("/obra")
    } catch {
        alert("Erro ao alterar orçamento!")
    }

}

async function excluir() {
    const confirmar = confirm("Tem certeza que deseja excluir esta obra?")

    if (!confirmar) {
        return
    }

    try {
        await deleteObra(form.value.idObra)

        alert('Obra excluída com sucesso!')
        router.push("/obra")

    } catch {
        alert("Erro ao excluir obra!")
    }
}




onMounted(async () => {
    try {
        orcamentos.value = await getOrcamentosDisponiveis()
        clientes.value = await getClientes()
    } catch (error) {
        console.error(error)
        alert('Erro ao carregar orçamentos ou clientes.')
    }
    carregaObra()
})

</script>

<template>

    <div class="container">
        <div class="card mt-5">

            <div class="card-header">
                <h4 class="mb-0">Alteração de Obra</h4>
            </div>

            <div class="card-body">
                <form @submit.prevent="alterar">

                    <div class="mb-3">
                        <label for="nomeObra" class="form-label">Nome da Obra</label>
                        <input id="nomeObra" v-model="form.nomeObra" type="text" class="form-control form-control-light"
                            placeholder="Digite o nome da obra" required />
                    </div>

                    <div class="row">

                        <div class="col-md-6 mb-3">
                            <label for="endereco" class="form-label">Endereço</label>
                            <input type="text" class="form-control form-control-light" v-model="form.endereco"
                                placeholder="Rua Sete de Setembro, 123" required />
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
                            <input class="form-control form-control-light" id="dataInicio" type="date"
                                v-model="form.dataInicio" required />
                        </div>

                        <div class="col-md-6 mb-3">
                            <label for="dataFimPrevisto" class="form-label">Data final prevista</label>
                            <input class="form-control form-control-light" id="dataFim" type="date"
                                v-model="form.dataFimPrevisto" required />
                        </div>

                        <div class="col-md-6 mb-3">
                            <label for="idOrcamento" class="form-label">Orçamento</label>
                            <select class="form-select" v-model.number="form.idOrcamento" required>
                                <option :value="0" disabled>Selecione um orçamento</option>
                                <option v-for="orcamento in orcamentos" :key="orcamento.idOrcamento"
                                    :value="orcamento.idOrcamento">
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

</template>