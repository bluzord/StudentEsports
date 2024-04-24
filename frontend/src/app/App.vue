<script lang="ts">
import { defineComponent } from 'vue'
import { AppHeader } from '@/widgets/header'
import { AppFooter } from '@/widgets/footer'

import './styles/index.scss'

export default defineComponent({
  components: {
    AppHeader,
    AppFooter
  }
})
</script>

<template>
  <AppHeader />
  <RouterView />
  <AppFooter />
</template>

<style scoped lang="scss"></style>
