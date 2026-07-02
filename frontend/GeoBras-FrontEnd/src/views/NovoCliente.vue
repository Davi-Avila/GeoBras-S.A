<script setup lang="ts">
import type Cliente from '@/interfaces/Cliente';
import { postCliente } from '@/service/api';
import { Toast } from 'bootstrap';
import { onMounted, ref } from 'vue';
import { useRouter } from 'vue-router';




const router = useRouter()
let toast: any = null

onMounted(() => {
    const toastLiveExample = document.getElementById('toast')
    toast = Toast.getOrCreateInstance(toastLiveExample!)
})

const form = ref<Cliente>({} as Cliente)

async function salvar(): Promise<void> {
    try {
        await postCliente({
            nomeCliente: form.value.nomeCliente,
            email: form.value.email,
            pais: form.value.pais,
            CEP: form.value.CEP,
            CPF: form.value.CPF,
            CNPJ: form.value.CNPJ,
            idCliente: 0
        })
        toast.show()
        setTimeout(() => { router.push("/clientes") }, 2500)
    }
    catch {
        alert("Erro ao cadastrar Cliente!")
    }
}


</script>

<template>
    <div class="container">
        <div class="card mt-5">

            <div class="card-header">
                <h4 class="mb-0">Cadastro de Cliente</h4>
            </div>

            <div class="card-body">
                <form @submit.prevent="salvar">

                    <!-- Nome -->
                    <div class="mb-3">
                        <label for="nomeCliente" class="form-label">Nome</label>
                        <input id="nomeCliente" v-model="form.nomeCliente" type="text" class="form-control"
                            placeholder="Digite o nome do cliente" required />
                    </div>

                    <!-- Valores -->
                    <div class="row">

                        <div class="col-md-6 mb-3">
                            <label for="email" class="form-label">
                                Email
                            </label>
                            <input id="email" v-model.number="form.email" type="email" class="form-control"
                                placeholder="@gmail.com" required />
                        </div>

                        <div class="col-md-6 mb-3">
                            <label for="pais" class="form-label">
                                País
                            </label>
                            <input id="pais" v-model.number="form.pais" type="text" class="form-control"
                                placeholder="Brasil" required />
                        </div>

                        <div class="col-md-6 mb-3">
                            <label for="CPF" class="form-label">
                                CPF (apenas números)
                            </label>
                            <input id="CPF" v-model.number="form.CPF" type="text" class="form-control"
                                placeholder="00000000000" required />
                        </div>

                        <div class="col-md-6 mb-3">
                            <label for="CNPJ" class="form-label">
                                CNPJ (apenas números)
                            </label>
                            <input id="CNPJ" v-model.number="form.CNPJ" type="number" class="form-control"
                                placeholder="00000000000000" />
                        </div>

                        <div class="col-md-6 mb-3">
                            <label for="CEP" class="form-label">
                                CEP (apenas números)
                            </label>
                            <input id="CEP" v-model="form.CEP" type="text" class="form-control" placeholder="00000000"
                                required />
                        </div>

                        
                        

                    </div>

                    <div class="d-flex justify-content-between">
                        <RouterLink to="/clientes" type="button" class="btn btn-outline-secondary px-4">
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

    <div class="toast-container position-fixed bottom-0 end-0 p-3">
        <div id="toast" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="toast-header text-bg-success">
                <strong class="me-auto">Concluído</strong>
                <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
            </div>
            <div class="toast-body">
                Cliente cadastrado com sucesso!
            </div>
        </div>
    </div>


</template>