import { ApplicationPage } from '@/pages/application'
import { HomePage } from '@/pages/home'
import { NewsPage } from '@/pages/news'
import { TeamsPage } from '@/pages/teams'
import { PlayersPage } from '@/pages/players'
import { createRouter, createWebHistory } from 'vue-router'
import { NewsElementPage } from '@/pages/news-element'

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
    path: '/news/:id',
    component: NewsElementPage
  },
  {
    path: '/application',
    component: ApplicationPage
  },
  {
    path: '/teams',
    component: TeamsPage
  },
  {
    path: '/players',
    component: PlayersPage
  }
]

const router = createRouter({
  routes,
  history: createWebHistory()
})

export default router
