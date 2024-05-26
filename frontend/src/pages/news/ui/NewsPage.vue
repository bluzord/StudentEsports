<script setup lang="ts">
import { onMounted, onUnmounted, ref } from 'vue'
import { useNewsPageStore } from '../model/NewsPageStore'
import { LoaderComponent } from '@/shared/UIKit/loader'
import { NewsList } from '@/widgets/news-list'

const newsPageStore = useNewsPageStore()
const obs = ref()

onMounted(() => {
  newsPageStore.getNews()

  let options = {
    rootMargin: '0px',
    threshold: 1.0
  }

  const callback = (entries: any, observer: any) => {
    if (entries[0].isIntersecting) {
      newsPageStore.loadMoreNews()
    }
  }

  let observer = new IntersectionObserver(callback, options)
  observer.observe(obs.value)
})

onUnmounted(() => {
  newsPageStore.page = 0
})
</script>

<template>
  <section class="news">
    <h1 class="news__title">Новости</h1>
    <NewsList
      class="news__list"
      v-if="!newsPageStore.isLoading && newsPageStore.isSuccess"
      :newsList="newsPageStore.news"
      ref="scrollComponent"
    />
    <LoaderComponent v-if="newsPageStore.isLoading" />
    <div v-if="!newsPageStore.isLoading && !newsPageStore.isSuccess" class="news__not-found">
      Новости не найдены
    </div>
    <div ref="obs" class="observer"></div>
  </section>
</template>

<style lang="scss" scoped>
.news {
  @include flex-center;
  flex-direction: column;
  justify-content: start;
  gap: 30px;
  padding: 50px;
  min-height: 700px;

  &__not-found {
    @include fluid-text(22, 20);
    font-weight: bold;
  }

  &__title {
    @include fluid-text(60, 30);
    text-align: center;
  }
}
</style>
