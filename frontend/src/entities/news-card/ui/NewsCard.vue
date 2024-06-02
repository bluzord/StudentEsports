<script setup lang="ts">
import { type NewsCardType } from '../model/NewsCardType'

interface Props {
  newsElement: NewsCardType
}

defineProps<Props>()
</script>

<template>
  <router-link :to="`/news/${newsElement.id}`" class="news-card-link">
    <article class="news-card">
      <img
        :src="`src/app/images/news/${newsElement.image}`"
        :alt="newsElement.title"
        class="news-card__image"
      />
      <h2 class="news-card__title">{{ newsElement.title }}</h2>
      <div class="news-card__date">{{ newsElement.date }}</div>
    </article>
  </router-link>
</template>

<style lang="scss" scoped>
.news-card-link {
  @include reset-link;
  border: 2px solid var(--color-light);
  border-radius: var(--border-radius);
  outline: none;

  @include hover {
    border: 2px solid var(--color-accent-alt);
  }

  &:focus {
    border: 2px solid var(--color-accent-alt);
  }

  &:active {
    border: 2px solid var(--color-accent);
  }
}

.news-card {
  @include flex-center;
  flex-direction: column;
  gap: 30px;
  padding: 30px;
  max-width: 860px;

  @include tablet {
    padding: 20px;
  }

  @include mobile {
    padding: 10px;
  }

  &__image {
    width: 800px;
  }

  &__title {
    @include fluid-text(60, 24);
    text-align: center;
  }

  &__date {
    @include fluid-text(30, 16);
    text-align: center;
  }
}
</style>
