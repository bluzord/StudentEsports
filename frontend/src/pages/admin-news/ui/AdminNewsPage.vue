<script setup lang="ts">
import { LoginForm } from '@/widgets/login-form'
import { AdminMenu } from '@/widgets/admin-menu'
import { onMounted, ref } from 'vue'
import { useAuthStore } from '@/app/stores/AuthStore'
import { ButtonComponent } from '@/shared/UIKit/button'

import axios from 'axios'

const authStore = useAuthStore()

const newsList = ref<
  {
    id: number
    title: string
    image: string
    date: string
  }[]
>([])

const getNews = async () => {
  try {
    const response = await axios.get('http://localhost:8080/admin/api/news', {
      headers: {
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + localStorage.getItem('token')
      }
    })
    newsList.value = response.data
  } catch (err) {
    newsList.value = []
  }
}

const deleteNews = async (id: number) => {
  try {
    const response = await axios.delete(`http://localhost:8080/admin/api/news/${id}/delete`, {
      headers: {
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + localStorage.getItem('token')
      }
    })
    if (response.status === 200) {
      getNews()
    }
  } catch (err) {
    getNews()
  }
}

onMounted(() => {
  authStore.checkAdmin()
})
</script>

<template>
  <LoginForm v-if="!authStore.isAuthAsAdmin" />
  <div v-else class="admin-news-container">
    <AdminMenu />
    <section class="admin-news">
      <h1 class="admin-news__title">Новости</h1>
      <ButtonComponent @click.prevent="getNews()">
        <template v-slot:button-text> Обновить </template>
      </ButtonComponent>
      <table class="table">
        <tr>
          <th>Номер</th>
          <th>Заголовок</th>
          <th>Дата</th>
          <th></th>
        </tr>
        <tr v-for="news in newsList" :key="news.id">
          <td>{{ news.id }}</td>
          <td>{{ news.title }}</td>
          <td>{{ news.date }}</td>
          <td>
            <button class="table__delete-btn" @click="deleteNews(news.id)">Удалить</button>
          </td>
        </tr>
      </table>
    </section>
  </div>
</template>

<style lang="scss" scoped>
.admin-news-container {
  width: 100%;

  @include flex-center;
  justify-content: start;
  gap: 10px;
}

.admin-news {
  @include flex-center;

  min-height: 700px;

  flex-direction: column;
  justify-content: start;
  align-items: center;
  gap: 30px;
  padding: 50px;

  &__title {
    @include fluid-text(60, 30);
    text-align: center;
  }
}

.table {
  border: 1px solid #525252;
  table-layout: fixed;
  width: 100%;
  margin-bottom: 20px;

  th {
    font-weight: bold;
    padding: 5px;
    background: #525252;
    border: 1px solid #525252;
  }

  td {
    padding: 5px 10px;
    border: 1px solid #525252;
    text-align: left;
  }

  tbody tr:nth-child(odd) {
    background: #525252;
  }

  tbody tr:nth-child(even) {
    background: #525252;
  }
}
</style>
