<script setup lang="ts">
import { type NewsElementType, NewsElement } from '@/widgets/news-element'
import axios from 'axios'
import { onMounted, ref } from 'vue'
import { useRoute } from 'vue-router'

const route = useRoute()
const newsEl = ref<NewsElementType>({
  id: 0,
  title: '',
  content: [],
  date: '',
  image: ''
})

const getPost = async () => {
  const response = await axios.get(`http://localhost:8080/api/news/${route.params.id}`)
  newsEl.value = response.data
}

onMounted(() => {
  getPost()
})
</script>

<template>
  <section class="news-element-id">
    <NewsElement :newsElement="newsEl" />
  </section>
</template>

<style lang="scss" scoped>
.news-element-id {
  padding: 50px;
}
</style>
