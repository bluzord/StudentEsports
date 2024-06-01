<script setup lang="ts">
import { LoginForm } from '@/widgets/login-form'
import { onMounted } from 'vue'
import { useAuthStore } from '@/app/stores/AuthStore'

const authStore = useAuthStore()

onMounted(() => {
  authStore.checkAdmin()
})
</script>

<template>
  <LoginForm v-if="!authStore.isAuthAsAdmin" />
  <div v-else>Вы вошли</div>
</template>

<style lang="scss" scoped></style>
