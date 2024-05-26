<script setup lang="ts">
import { InputComponent } from '@/shared/UIKit/input'
import { usePlayersPageStore } from '../model/PlayersPageStore'
import { PlayersList } from '@/widgets/players-list'
import { LoaderComponent } from '@/shared/UIKit/loader'
import { onMounted } from 'vue'

const playersPageStore = usePlayersPageStore()

onMounted(() => {
  playersPageStore.getPlayers()
})
</script>

<template>
  <section class="players">
    <h1 class="players__title">Игроки</h1>
    <InputComponent
      class="players__search"
      type="text"
      required
      placeholder="Поиск..."
      :value="playersPageStore.search"
      @input="playersPageStore.search = $event.target.value"
    />
    <PlayersList
      v-if="
        playersPageStore.filteredPlayers.length > 0 &&
        !playersPageStore.isLoading &&
        playersPageStore.isSuccess
      "
      :players="playersPageStore.filteredPlayers"
      class="players__list"
    />
    <div
      class="players__not-found"
      v-if="
        (playersPageStore.filteredPlayers.length < 0 || !playersPageStore.isSuccess) &&
        !playersPageStore.isLoading
      "
    >
      Ничего не найдено
    </div>
    <LoaderComponent v-if="playersPageStore.isLoading" />
  </section>
</template>

<style lang="scss" scoped>
.players {
  @include flex-center;

  flex-direction: column;
  justify-content: start;
  align-items: center;

  min-height: 700px;

  gap: 30px;
  padding: 50px;

  &__search {
    @include fluid-text(22, 20);
  }

  &__not-found {
    @include fluid-text(22, 20);
    font-weight: bold;
  }
}
</style>
