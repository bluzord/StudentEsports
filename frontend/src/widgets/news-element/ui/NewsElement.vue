<script setup lang="ts">
import { type NewsElementType } from '../model/NewsElementType'

defineProps<{
  newsElement: NewsElementType
}>()
</script>

<template>
  <article class="news-element">
    <div class="news-element__top">
      <h1 class="news-element__title">{{ newsElement.title }}</h1>
      <div class="news-element__date">{{ newsElement.date }}</div>
    </div>
    <img
      :src="`../src/app/images/news/${newsElement.image}`"
      :alt="newsElement.title"
      class="news-element__image"
    />
    <div class="news-element__content">
      <p
        class="news-element__paragraph"
        v-for="(paragraph, index) in newsElement.content"
        :key="index"
      >
        {{ paragraph }}
      </p>
    </div>
  </article>
</template>

<style lang="scss" scoped>
.news-element {
  @include flex-center;
  flex-direction: column;
  gap: 30px;

  &__top {
    @include flex-center;
    flex-direction: column;
    gap: 10px;
  }

  &__image {
    width: 50%;

    @include tablet {
      width: 100%;
    }
  }

  &__content {
    @include fluid-text(22, 18);
    display: flex;
    flex-direction: column;
    gap: 30px;
  }
}
</style>
