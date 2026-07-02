<script setup lang="ts">
import { ref, onMounted, computed } from 'vue'
import { getObras } from '../service/api'
import type Obra from '@/interfaces/Obra'

const obras = ref<Obra[]>([])

onMounted(async () => {
  try {
    obras.value = await getObras()
  } catch (error) {
    console.error(error)
  }
})

const totalConcluidas = computed(() => obras.value.filter(o => o.etapa === 'Concluído').length)
const totalAndamento = computed(() => obras.value.filter(o => o.etapa === 'Em andamento').length)
const totalAguardando = computed(() => obras.value.filter(o => o.etapa === 'Aguardando').length)

// Usado pra calcular a altura proporcional das barras (a maior quantidade vira 100%)
const maiorValor = computed(() =>
  Math.max(totalConcluidas.value, totalAndamento.value, totalAguardando.value, 1)
)

function porcentagem(valor: number): number {
  return (valor / maiorValor.value) * 100
}
</script>

<template>
   <div class="charts-frame">
    <h2 class="charts-title">Status Geral das Obras</h2>

    <div class="charts-container">
      <div class="chart-card">
        <h3>Concluídas</h3>
        <div class="bar-wrapper">
          <div class="bar bar-concluida" :style="{ height: porcentagem(totalConcluidas) + '%' }"></div>
        </div>
        <p class="chart-value">{{ totalConcluidas }}</p>
      </div>

      <div class="chart-card">
        <h3>Em andamento</h3>
        <div class="bar-wrapper">
          <div class="bar bar-andamento" :style="{ height: porcentagem(totalAndamento) + '%' }"></div>
        </div>
        <p class="chart-value">{{ totalAndamento }}</p>
      </div>

      <div class="chart-card">
        <h3>Aguardando</h3>
        <div class="bar-wrapper">
          <div class="bar bar-aguardando" :style="{ height: porcentagem(totalAguardando) + '%' }"></div>
        </div>
        <p class="chart-value">{{ totalAguardando }}</p>
      </div>
    </div>
  </div>
</template>

<style>
.charts-frame {
  max-width: 1150px;
  margin: 40px auto;
  padding: 24px 32px 32px;
  border: 1px solid #e0e0e0;
  border-radius: 12px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.06);
  background-color: #fff;
}

.charts-title {
  text-align: center;
  font-size: 1.3rem;
  font-weight: 700;
  color: #1447a3;
  margin-bottom: 24px;
}

.charts-container {
  display: flex;
  gap: 32px;
  justify-content: center;
}

.chart-card {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 160px;
}

.chart-card h3 {
  font-size: 1rem;
  margin-bottom: 12px;
  color: #333;
}

.bar-wrapper {
  width: 60px;
  height: 200px;
  background-color: #f0f0f0;
  border-radius: 8px;
  display: flex;
  align-items: flex-end;
  overflow: hidden;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.08);
}

.bar {
  width: 100%;
  border-radius: 8px 8px 0 0;
  transition: height 0.6s ease;
}

.bar-concluida  { background-color: #2e7d32; }
.bar-andamento  { background-color: #f9a825; }
.bar-aguardando { background-color: #c62828; }

.chart-value {
  margin-top: 12px;
  font-size: 1.5rem;
  font-weight: 700;
  color: #1447a3;
}
</style>
