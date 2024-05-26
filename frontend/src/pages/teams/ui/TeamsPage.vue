<script setup lang="ts">
import { TeamsList } from '@/widgets/teams-list'
import { FilterComponent } from '@/shared/UIKit/filter'
import { LoaderComponent } from '@/shared/UIKit/loader'

import { useTeamsPageStore } from '../model/TeamsPageStore'
import { onMounted } from 'vue'

const teamsPageStore = useTeamsPageStore()

onMounted(() => {
  teamsPageStore.getTeams()
})
</script>

<template>
  <section class="teams">
    <h1 class="teams__title">Составы</h1>
    <nav class="teams__filters">
      <FilterComponent
        class="teams__filter"
        :color="'#b5ffbe'"
        :is-active="teamsPageStore.game === 'ALL'"
        @click="teamsPageStore.game = 'ALL'"
      >
        <template v-slot:filter-name>ALL</template>
      </FilterComponent>
      <FilterComponent
        class="teams__filter"
        :color="'#b5fff5'"
        :is-active="teamsPageStore.game === 'CS2'"
        @click="teamsPageStore.game = 'CS2'"
      >
        <template v-slot:filter-name>CS2</template>
      </FilterComponent>
      <FilterComponent
        class="teams__filter"
        :color="'#ff6e6e'"
        :is-active="teamsPageStore.game === 'DOTA'"
        @click="teamsPageStore.game = 'DOTA'"
      >
        <template v-slot:filter-name>DOTA</template>
      </FilterComponent>
      <FilterComponent
        class="teams__filter"
        :color="'#ffb5f5'"
        :is-active="teamsPageStore.game === 'VLR'"
        @click="teamsPageStore.game = 'VLR'"
      >
        <template v-slot:filter-name>VLR</template>
      </FilterComponent>
      <FilterComponent
        class="teams__filter"
        :color="'#f8ffb5'"
        :is-active="teamsPageStore.game === 'LOL'"
        @click="teamsPageStore.game = 'LOL'"
      >
        <template v-slot:filter-name>LOL</template>
      </FilterComponent>
      <FilterComponent
        class="teams__filter"
        :color="'#b8b5ff'"
        :is-active="teamsPageStore.game === 'SC2'"
        @click="teamsPageStore.game = 'SC2'"
      >
        <template v-slot:filter-name>SC2</template>
      </FilterComponent>
      <FilterComponent
        class="teams__filter"
        :color="'#cccccc'"
        :is-active="teamsPageStore.game === 'TEKKEN'"
        @click="teamsPageStore.game = 'TEKKEN'"
      >
        <template v-slot:filter-name>TEKKEN</template>
      </FilterComponent>
    </nav>

    <TeamsList
      :teamsList="teamsPageStore.filteredTeams"
      v-if="!teamsPageStore.isLoading && teamsPageStore.isSuccess"
    />
    <LoaderComponent v-if="teamsPageStore.isLoading" />
    <div
      v-if="
        (teamsPageStore.filteredTeams.length < 0 || !teamsPageStore.isSuccess) &&
        !teamsPageStore.isLoading
      "
      class="teams__not-found"
    >
      Ничего не найдено
    </div>
  </section>
</template>

<style lang="scss" scoped>
.teams {
  @include flex-center;

  min-height: 700px;

  flex-direction: column;
  justify-content: start;
  align-items: center;
  gap: 30px;
  padding: 50px;

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

  &__not-found {
    @include fluid-text(22, 20);
    font-weight: bold;
  }
}
</style>
