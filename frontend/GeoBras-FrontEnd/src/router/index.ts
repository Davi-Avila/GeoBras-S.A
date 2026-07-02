import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import ObraView from '@/views/ObraView.vue'
import OrcamentoView from '@/views/OrcamentoView.vue'
import ClientesView from '@/views/MaterialView.vue'
import NovaObraPage from '@/views/NovaObraPage.vue'
import MaterialView from '@/views/MaterialView.vue'
import NovoOrcamento from '@/views/NovoOrcamento.vue'

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
      name: 'materiais',
      path: '/materiais',
      component: MaterialView
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
    }

  ],
})

export default router
