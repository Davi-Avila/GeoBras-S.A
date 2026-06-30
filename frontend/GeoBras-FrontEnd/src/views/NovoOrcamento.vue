<script setup lang="ts">
import type Material from '@/interfaces/Material';
import { ref } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter ()

const materiais = ref<Material>({} as Material)

</script>
<template>
  <form>
    <div class="mb-3">
      <label class="form-label">$ Nome $ </label>
      <input type="text" class="form-control" />
    </div>
    <div class="mb-3">
      <label class="form-label">$ deslocamento $</label>
      <input type="number" class="form-control" />
    </div>

<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
  Material
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Materiais</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div class="row">
        <div class="col-5">
        <input class="form-control" type="text" v-model="materiais.nomeMaterial">
    </div>
    <div class="col-3">
        <input class="form-control"  step="" type="number" v-model="materiais.quantidade">
    </div>
    <div class="col-3">
        <input class="form-control" step="0.1" type="number" v-model="materiais.valorMaterial">
    </div>
        <button class="btn btn-primary col-1">+</button>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save</button>
      </div>
    </div>
  </div>
</div>

    <div class="mb-3">
      <label class="form-label">$ mão de obra $</label>
      <input type="number" class="form-control" />
    </div>
    <div class="mb-3">
      <label class="form-label">$ serviço $</label>
      <input type="number" class="form-control" />
    </div>
    <div class="mb-3">
      <label class="form-label">$ aluguel equipamento $</label>
      <input type="number" class="form-control" />
    </div>
    <div class="mb-3">
      <label class="form-label">$ Imposto $</label>
      <input type="number" class="form-control" />
    </div>
    <button type="submit" class="btn btn-primary">Cadastrar</button>
  </form>
</template>
<style></style>
