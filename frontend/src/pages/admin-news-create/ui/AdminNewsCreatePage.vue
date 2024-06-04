<script setup lang="ts">
import { LoginForm } from '@/widgets/login-form'
import { AdminMenu } from '@/widgets/admin-menu'
import { InputComponent } from '@/shared/UIKit/input'
import { ButtonComponent } from '@/shared/UIKit/button'
import { useAuthStore } from '@/app/stores/AuthStore'
import { MdEditor } from 'md-editor-v3'
import 'md-editor-v3/lib/style.css'
import { ref } from 'vue'
import { onMounted } from 'vue'
import axios from 'axios'

const authStore = useAuthStore()
const title = ref<string>('')
const text = ref<string>('')

onMounted(() => {
  authStore.checkAdmin()
})

const postNewsEl = async () => {
  const formData = new FormData()
  const inputFile = document.getElementById('image') as HTMLInputElement
  if (inputFile.files) {
    formData.append('image', inputFile.files[0])
  }
  formData.append('title', title.value)
  formData.append('content', text.value)
  const response = axios.post(`http://localhost:8080/admin/api/news/create`, formData, {
    headers: {
      Authorization: 'Bearer ' + localStorage.getItem('token')
    }
  })
  window.location.href = '/admin/news'
}
</script>

<template>
  <LoginForm v-if="!authStore.isAuthAsAdmin" />
  <div v-else class="admin-news-create-container">
    <AdminMenu />
    <form class="news-form" @submit.prevent="postNewsEl()">
      <h2 class="news-form__title">Публикация новости</h2>
      <div class="news-form__input-box">
        <label for="title">Заголовок:</label>
        <InputComponent
          id="title"
          type="text"
          required
          placeholder="Заголовок"
          class="news-form__input"
          :value="title"
          @input="title = $event.target.value"
        />
      </div>

      <div class="news-form__input-box">
        <label for="image">Изображение:</label>
        <InputComponent
          id="image"
          type="file"
          required
          placeholder="Заголовок"
          class="news-form__input"
          accept="image/jpeg, image/png, image/jpg"
        />
      </div>
      <MdEditor v-model="text" language="en-US" theme="dark" />
      <ButtonComponent type="submit">
        <template v-slot:button-text> Опубликовать </template>
      </ButtonComponent>
    </form>
  </div>
</template>

<style lang="scss" scoped>
.admin-news-create-container {
  width: 100%;

  @include flex-center;
  justify-content: start;
  gap: 10px;
}

.news-form {
  @include flex-center;
  @include fluid-text(18, 16);
  flex-direction: column;
  gap: 10px;

  &__title {
    margin-top: 10px;
  }

  &__input-box {
    display: flex;
    justify-content: start;
    align-items: center;
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

  &__input {
    width: 100%;
  }
}

.md-editor-dark {
  --md-color: var(--color-light);
  --md-hover-color: var(--color-light);
  --md-bk-color: var(--color-dark);
  --md-bk-color-outstand: var(--color-dark);
  --md-bk-hover-color: #3d3d3d;
  --md-border-color: var(--color-accent);
  --md-border-hover-color: var(--color-accent-alt);
  --md-border-active-color: var(--color-accent-alt);
  --md-modal-mask: #00000073;
  --md-scrollbar-bg-color: var(--color-accent);
  --md-scrollbar-thumb-color: var(--color-accent);
  --md-scrollbar-thumb-hover-color: var(--color-accent-alt);
  --md-scrollbar-thumb-active-color: var(--color-accent-alt);
}
</style>
