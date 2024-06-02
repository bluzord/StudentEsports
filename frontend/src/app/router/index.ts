import { ApplicationPage } from '@/pages/application'
import { HomePage } from '@/pages/home'
import { NewsPage } from '@/pages/news'
import { TeamsPage } from '@/pages/teams'
import { PlayersPage } from '@/pages/players'
import { createRouter, createWebHistory } from 'vue-router'
import { NewsElementPage } from '@/pages/news-element'
import { NotFoundPage } from '@/pages/not-found'
import { AdminApplicationsPage } from '@/pages/admin-applications'
import { AdminNewsPage } from '@/pages/admin-news'
import { AdminNewsCreatePage } from '@/pages/admin-news-create'

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
  },
  {
    path: '/:pathName(.*)',
    component: NotFoundPage
  },
  {
    path: '/admin',
    component: AdminApplicationsPage
  },
  {
    path: '/admin/news',
    component: AdminNewsPage
  },
  {
    path: '/admin/news/create',
    component: AdminNewsCreatePage
  }
]

const router = createRouter({
  routes,
  history: createWebHistory()
})

export default router
