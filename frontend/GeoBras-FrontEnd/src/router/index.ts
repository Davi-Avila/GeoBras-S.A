import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import ObraView from '@/views/ObraView.vue'
import OrcamentoView from '@/views/OrcamentoView.vue'
import ClientesView from '@/views/ClientesView.vue'
import NovaObraPage from '@/views/NovaObraPage.vue'

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
      name: 'clientes',
      path: '/clientes',
      component: ClientesView
    },
    {
      name: 'novaObra',
      path: '/obra/nova',
      component: NovaObraPage
    }

  ],
})

export default router
