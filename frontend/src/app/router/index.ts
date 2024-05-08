import { ApplicationPage } from '@/pages/application'
import { HomePage } from '@/pages/home'
import { NewsPage } from '@/pages/news'
import { TeamsPage } from '@/pages/teams'
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
  },
  {
    path: '/teams',
    component: TeamsPage
  }
]

const router = createRouter({
  routes,
  history: createWebHistory()
})

export default router
