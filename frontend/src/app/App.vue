<script setup lang="ts">
import { AppHeader } from '@/widgets/header'
import { AppFooter } from '@/widgets/footer'
import { MobileOverlay } from '@/widgets/overlay'
</script>

<template>
  <AppHeader />
  <main class="main">
    <RouterView />
  </main>
  <AppFooter />
  <MobileOverlay />
</template>

<style lang="scss">
.main {
  @include flex-center;
  padding: 0;
  margin: 0;
  width: 100%;
}
</style>
