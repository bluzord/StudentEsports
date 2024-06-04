<script setup lang="ts">
import { LoginForm } from '@/widgets/login-form'
import { AdminMenu } from '@/widgets/admin-menu'
import { InputComponent } from '@/shared/UIKit/input'
import { ButtonComponent } from '@/shared/UIKit/button'
import { SelectComponent } from '@/shared/UIKit/select'
import { type Option } from '@/shared/UIKit/select'
import { useAuthStore } from '@/app/stores/AuthStore'
import { ref, onMounted } from 'vue'
import axios from 'axios'

const games = ref<Option[]>([
  {
    value: 'CS2',
    name: 'Counter Strike 2'
  },
  {
    value: 'DOTA',
    name: 'Dota 2'
  },
  {
    value: 'VLR',
    name: 'Valorant'
  },
  {
    value: 'LOL',
    name: 'League Of Legends'
  },
  {
    value: 'SC2',
    name: 'StarCraft II'
  },
  {
    value: 'TEKKEN',
    name: 'Tekken 7'
  }
])

const authStore = useAuthStore()
const teamName = ref<string>('')
const game = ref<string>('')

const createTeam = async () => {
  const formData = new FormData()
  const inputFile = document.getElementById('image') as HTMLInputElement
  if (inputFile.files) {
    formData.append('logo', inputFile.files[0])
  }
  formData.append('name', teamName.value)
  formData.append('game', game.value)
  const response = axios.post(`http://localhost:8080/admin/api/teams/create`, formData, {
    headers: {
      Authorization: 'Bearer ' + localStorage.getItem('token')
    }
  })
  window.location.href = '/admin/teams'
}

onMounted(() => {
  authStore.checkAdmin()
})
</script>

<template>
  <LoginForm v-if="!authStore.isAuthAsAdmin" />
  <div v-else class="admin-teams-create-container">
    <AdminMenu />
    <form class="teams-form" @submit.prevent="createTeam()">
      <h2 class="teams-form__title">Создание команды</h2>
      <div class="teams-form__input-box">
        <label for="team-name">Название:</label>
        <InputComponent
          id="team-name"
          type="text"
          required
          placeholder="Название"
          class="teams-form__input"
          :value="teamName"
          @input="teamName = $event.target.value"
        />
      </div>

      <div class="teams-form__input-box">
        <label for="image">Изображение:</label>
        <InputComponent
          id="image"
          type="file"
          required
          placeholder="Заголовок"
          class="teams-form__input"
          accept="image/jpeg, image/png, image/jpg, image/svg"
        />
      </div>
      <div class="teams-form__input-box">
        <label for="game">Дисциплина:</label>
        <SelectComponent
          id="game"
          :options="games"
          :value="game"
          @change="game = $event.target.value"
          required
          class="teams-form__select"
        >
          <template v-slot:default-select>Выберите игру</template>
        </SelectComponent>
      </div>
      <ButtonComponent type="submit">
        <template v-slot:button-text> Создать </template>
      </ButtonComponent>
    </form>
  </div>
</template>

<style lang="scss" scoped>
.admin-teams-create-container {
  width: 100%;

  @include flex-center;
  justify-content: start;
  gap: 10px;
}

.teams-form {
  @include flex-center;
  @include fluid-text(22, 16);
  flex-direction: column;
  gap: 40px;
  min-height: 700px;
  width: 100%;

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
</style>
