<script setup lang="ts"></script>

<template>
  <section class="not-found">
    <div class="not-found__error">404</div>
    <div class="not-found__text">Страница не найдена</div>
  </section>
</template>

<style lang="scss" scoped>
.not-found {
  height: 700px;
  @include flex-center;
  flex-direction: column;
  gap: 40px;

  &__error {
    @include fluid-text(100, 60);
  }
  &__text {
    @include fluid-text(60, 40);
  }
}
</style>
