<script lang="ts">
import { defineComponent } from 'vue'
import { AppHeader } from '@/widgets/header'
import { AppFooter } from '@/widgets/footer'
import { MobileOverlay } from '@/widgets/overlay'

export default defineComponent({
  components: {
    AppHeader,
    AppFooter,
    MobileOverlay
  }
})
</script>

<template>
  <AppHeader />
  <main class="main"></main>
  <RouterView />
  <AppFooter />
  <MobileOverlay />
</template>

<style lang="scss">
.main {
  min-height: 100%;
}
</style>
