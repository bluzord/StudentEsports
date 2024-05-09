<script setup lang="ts">
import { PlayerCard, type PlayerCardType } from '@/entities/player-card'

defineProps<{
  players: PlayerCardType[]
}>()
</script>

<template>
  <div class="players-list">
    <PlayerCard v-for="player in players" :key="player.id" :player="player" />
  </div>
</template>

<style lang="scss" scoped>
.players-list {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 20px;
  width: 100%;

  @include desktop {
    @include flex-center;
    flex-direction: column;
  }
}
</style>
