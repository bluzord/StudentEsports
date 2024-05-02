import { HomePage } from '@/pages/home'
import { NewsPage } from '@/pages/news'
import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    component: HomePage
  },
  {
    path: '/news',
    component: NewsPage
  }
]

const router = createRouter({
  routes,
  history: createWebHistory()
})

export default router
