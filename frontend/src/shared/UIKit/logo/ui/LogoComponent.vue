<script setup lang="ts"></script>

<template>
  <router-link to="/" class="logo">
    <img
      class="logo__image"
      src="@/app/images/StudentEsports.svg"
      alt="StudentEsports"
      loading="lazy"
    />
  </router-link>
</template>

<style lang="scss" scoped>
.logo {
  &__image {
    width: 320px;
  }
}
</style>
