import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import ObraView from '@/views/ObraView.vue'
import OrcamentoView from '@/views/OrcamentoView.vue'
import ClientesView from '@/views/ClientesView.vue'
import NovaObraPage from '@/views/NovaObraPage.vue'
import NovoOrcamento from '@/views/NovoOrcamento.vue'
import NovoCliente from '@/views/NovoCliente.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      name: 'home',
      path: '/',
      component: HomeView
    },
    {
      name: 'obra',
      path: '/obra',
      component: ObraView
    },
    {
      name: 'orcamento',
      path: '/orcamento',
      component: OrcamentoView
    },
    {
      name: 'novaObra',
      path: '/obra/nova',
      component: NovaObraPage
    },
    {
      name: 'novaOrcamento',
      path: '/orcamento/novo',
      component: NovoOrcamento
    },
    {
      name: 'clientes',
      path: '/clientes',
      component: ClientesView
    },
    {
      name: 'novoCliente',
      path: '/clientes/novo',
      component: NovoCliente
    },
    {
      name: 'editarCliente',
      path: '/clientes/editar/:id',
      component: NovoCliente
    }

  ],
})

export default router
