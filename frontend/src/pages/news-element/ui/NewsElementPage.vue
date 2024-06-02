<script setup lang="ts">
import { type NewsElementType, NewsElement } from '@/widgets/news-element'
import axios from 'axios'
import { onMounted, ref } from 'vue'
import { useRoute } from 'vue-router'

const route = useRoute()
const isSuccess = ref<boolean>(true)
const newsEl = ref<NewsElementType>({
  id: 0,
  title: '',
  content: '',
  date: '',
  image: ''
})

const getPost = async () => {
  try {
    const response = await axios.get(`http://localhost:8080/api/news/${route.params.id}`)
    newsEl.value = response.data
  } catch (err) {
    isSuccess.value = false
  }
}

onMounted(() => {
  getPost()
})
</script>

<template>
  <section class="news-element-id">
    <NewsElement v-if="isSuccess" :newsElement="newsEl" />
    <div v-else class="news-element-id__not-found">Новость не найдена</div>
  </section>
</template>

<style lang="scss" scoped>
.news-element-id {
  padding: 50px;
  min-height: 700px;

  &__not-found {
    @include fluid-text(60, 40);
  }
}
</style>
