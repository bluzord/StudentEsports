<script setup lang="ts">
import { LoginForm } from '@/widgets/login-form'
import { AdminMenu } from '@/widgets/admin-menu'
import { onMounted, ref, computed } from 'vue'
import { useAuthStore } from '@/app/stores/AuthStore'
import { ButtonComponent } from '@/shared/UIKit/button'
import { TeamsList } from '@/widgets/teams-list'
import { FilterComponent } from '@/shared/UIKit/filter'
import { type TeamCardType } from '@/entities/team-card/model/TeamCard'

import axios from 'axios'

const authStore = useAuthStore()
const game = ref<'ALL' | 'CS2' | 'DOTA' | 'VLR' | 'LOL' | 'SC2' | 'TEKKEN'>('ALL')
const teams = ref<TeamCardType[]>([])

const getTeams = async () => {
  const response = await axios.get('http://localhost:8080/api/teams')
  teams.value = response.data
}

const filteredTeams = computed<TeamCardType[]>(() => {
  if (game.value === 'ALL') return teams.value
  return teams.value.filter((team) => team.game === game.value)
})

const redirect = () => {
  window.location.href = '/admin/teams/create'
}

onMounted(() => {
  authStore.checkAdmin()
  getTeams()
})
</script>

<template>
  <LoginForm v-if="!authStore.isAuthAsAdmin" />
  <div v-else class="admin-teams-container">
    <AdminMenu />
    <section class="admin-teams">
      <h1 class="admin-teams__title">Составы</h1>
      <div class="admin-teams__button-group">
        <ButtonComponent @click.prevent="getTeams()">
          <template v-slot:button-text> Обновить </template>
        </ButtonComponent>
        <ButtonComponent @click.prevent="redirect()">
          <template v-slot:button-text> Создать </template>
        </ButtonComponent>
      </div>

      <nav class="admin-teams__filters">
        <FilterComponent
          class="admin-teams__filter"
          :color="'#b5ffbe'"
          :is-active="game === 'ALL'"
          @click="game = 'ALL'"
        >
          <template v-slot:filter-name>ALL</template>
        </FilterComponent>
        <FilterComponent
          class="admin-teams__filter"
          :color="'#b5fff5'"
          :is-active="game === 'CS2'"
          @click="game = 'CS2'"
        >
          <template v-slot:filter-name>CS2</template>
        </FilterComponent>
        <FilterComponent
          class="admin-teams__filter"
          :color="'#ff6e6e'"
          :is-active="game === 'DOTA'"
          @click="game = 'DOTA'"
        >
          <template v-slot:filter-name>DOTA</template>
        </FilterComponent>
        <FilterComponent
          class="admin-teams__filter"
          :color="'#ffb5f5'"
          :is-active="game === 'VLR'"
          @click="game = 'VLR'"
        >
          <template v-slot:filter-name>VLR</template>
        </FilterComponent>
        <FilterComponent
          class="admin-teams__filter"
          :color="'#f8ffb5'"
          :is-active="game === 'LOL'"
          @click="game = 'LOL'"
        >
          <template v-slot:filter-name>LOL</template>
        </FilterComponent>
        <FilterComponent
          class="admin-teams__filter"
          :color="'#b8b5ff'"
          :is-active="game === 'SC2'"
          @click="game = 'SC2'"
        >
          <template v-slot:filter-name>SC2</template>
        </FilterComponent>
        <FilterComponent
          class="admin-teams__filter"
          :color="'#cccccc'"
          :is-active="game === 'TEKKEN'"
          @click="game = 'TEKKEN'"
        >
          <template v-slot:filter-name>TEKKEN</template>
        </FilterComponent>
      </nav>
      <TeamsList :teamsList="filteredTeams" :link="`/admin/teams/`" />
    </section>
  </div>
</template>

<style lang="scss" scoped>
.admin-teams-container {
  width: 100%;

  @include flex-center;
  justify-content: start;
  gap: 10px;
}

.admin-teams {
  @include flex-center;

  min-height: 700px;

  flex-direction: column;
  justify-content: start;
  align-items: center;
  gap: 30px;
  padding: 50px;

  &__button-group {
    display: flex;
    gap: 30px;

    button {
      min-width: 102px;
    }
  }

  &__title {
    @include fluid-text(60, 30);
    text-align: center;
  }

  &__filters {
    display: flex;
    gap: 10px;
    justify-content: end;
    flex-wrap: wrap;
  }

  &__filter {
    width: 120px;
  }
}
</style>
