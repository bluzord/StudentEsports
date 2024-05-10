<script setup lang="ts">
import { NewsCard, type NewsCardType } from '@/entities/news-card'

defineProps<{
  newsList: NewsCardType[]
}>()
</script>

<template>
  <section class="news-list">
    <NewsCard v-for="newsEl in newsList" :key="newsEl.id" :newsElement="newsEl" />
  </section>
</template>

<style scoped lang="scss">
.news-list {
  @include flex-center;
  flex-direction: column;
  gap: 30px;
}
</style>
