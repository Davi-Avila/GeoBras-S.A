<script setup lang="ts">
import { ref, onMounted } from 'vue'
import http from '@/http'
import type Obra from '@/interfaces/Obra';
import CardObra from '@/components/CardObra.vue';

const obra = ref ([] as Obra[])
 




</script>

<template>
    <div class="container py-5">
        <h1 class="fw-bold mb-1">
            <i class="bi bi-houses"></i>Home
        </h1>
    </div>
    <div>
        <CardObra titulo="obra" icone="bi bi-css"></CardObra>
    </div>
</template>