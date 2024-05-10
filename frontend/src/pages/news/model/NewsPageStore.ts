import axios from 'axios'
import { defineStore } from 'pinia'
import { ref } from 'vue'
import { type NewsCardType } from '@/entities/news-card'

export const useNewsPageStore = defineStore('newsPageStore', () => {
  const page = ref<number>(0)
  const limit = ref<number>(2)
  const news = ref<NewsCardType[]>([])
  const totalNews = ref<number>()
  const totalPages = ref<number>()
  const isLoading = ref<boolean>(false)

  const getNews = async () => {
    isLoading.value = true
    const response = await axios.get('http://localhost:8080/api/news', {
      params: {
        pageNumber: page.value,
        pageSize: limit.value
      }
    })
    news.value = response.data.content
    totalNews.value = response.data.totalNews
    totalPages.value = response.data.totalPages
    isLoading.value = false
  }

  const loadMoreNews = async () => {
    page.value++
    const response = await axios.get('http://localhost:8080/api/news', {
      params: {
        pageNumber: page.value,
        pageSize: limit.value
      }
    })
    news.value = [...news.value, ...response.data.content]
  }

  return {
    page,
    limit,
    getNews,
    news,
    totalNews,
    totalPages,
    isLoading,
    loadMoreNews
  }
})
