<script setup lang="ts">
import { InputComponent } from '@/shared/UIKit/input'
import { ButtonComponent } from '@/shared/UIKit/button'
import { ref } from 'vue'
import axios from 'axios'
import { useAuthStore } from '@/app/stores/AuthStore'

const authStore = useAuthStore()

const username = ref<String>('')
const password = ref<String>('')
const invalid = ref<Boolean>(false)

const auth = async () => {
  localStorage.removeItem('token')

  try {
    const response = await axios.post('http://localhost:8080/admin/login', {
      username: username.value,
      password: password.value
    })
    const token = response.data.token
    localStorage.setItem('token', token)
    authStore.checkAdmin()
  } catch (err) {
    invalid.value = true
  }
}
</script>

<template>
  <form class="login-form" @submit.prevent="auth">
    <h2 class="login-form__title">Вход в админ-панель</h2>
    <div class="login-form__input-box">
      <label for="username">Логин:</label>
      <InputComponent
        id="username"
        type="text"
        required
        placeholder="Логин"
        class="login-form__input"
        :class="[{ 'input--invalid': invalid }]"
        :value="username"
        @input="[(username = $event.target.value), (invalid = false)]"
      />
    </div>

    <div class="login-form__input-box">
      <label for="password">Пароль:</label>
      <InputComponent
        id="password"
        type="password"
        required
        placeholder="Пароль"
        class="login-form__input"
        :class="[{ 'input--invalid': invalid }]"
        :value="password"
        @input="[(password = $event.target.value), (invalid = false)]"
      />
    </div>
    <div v-if="invalid" class="login-form__invalid">Неверный логин или пароль!</div>
    <ButtonComponent type="submit">
      <template v-slot:button-text> Войти </template>
    </ButtonComponent>
  </form>
</template>

<style lang="scss" scoped>
.login-form {
  @include flex-center;
  @include fluid-text(22, 20);
  flex-direction: column;
  padding: 40px;
  gap: 40px;
  width: 100%;
  min-height: 700px;

  &__invalid {
    color: #ff6e6e;
  }

  &__input-box {
    display: flex;
    flex-direction: column;
    justify-content: start;
    width: 50%;
    max-width: 800px;
    gap: 10px;

    @include tablet {
      width: 70%;
    }

    @include mobile {
      width: 90%;
    }
  }

  &__input,
  &__select {
    width: 100%;
  }
}
</style>
