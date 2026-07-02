<script setup lang="ts">
import { ref, onMounted } from 'vue'

const saudacao = ref('Olá')

onMounted(() => {
  const hora = new Date().getHours()
  if (hora >= 5 && hora < 12) {
    saudacao.value = 'Bom dia'
  } else if (hora >= 12 && hora < 18) {
    saudacao.value = 'Boa tarde'
  } else {
    saudacao.value = 'Boa noite'
  }
})
</script>
<template>
    <div class="welcome-card">
  <h2 class="welcome-title">{{ saudacao }}! 👋</h2>
  <p class="welcome-subtitle">Bem-vindo ao GeObras. Selecione uma opção abaixo para começar.</p>
</div>
</template>
<style>
.welcome-card {
  background-color: transparent;
  color: #1447a3;
  border: 1px solid #e0e0e0;
  border-radius: 12px;
  padding: 40px 32px;
  margin: 24px auto 40px auto;
  max-width: 1100px;
  text-align: left;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.08);
}

.welcome-title {
  margin: 0 0 8px 0;
  font-size: 2.5rem;
  font-weight: 700;
}

.welcome-subtitle {
  margin: 0;
  font-size: 1.2rem;
  opacity: 0.75;
  color: #333;
}
</style>
