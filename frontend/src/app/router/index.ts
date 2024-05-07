import { ApplicationPage } from '@/pages/application'
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
  },
  {
    path: '/application',
    component: ApplicationPage
  }
]

const router = createRouter({
  routes,
  history: createWebHistory()
})

export default router
