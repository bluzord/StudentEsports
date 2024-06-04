<script setup lang="ts">
import { TeamCard } from '@/entities/team-card'
import { type TeamCardType } from '@/entities/team-card/model/TeamCard'

defineProps<{
  teamsList: TeamCardType[]
  link: string
}>()
</script>

<template>
  <section class="teams-list">
    <TeamCard v-for="team in teamsList" :key="team.id" :team="team" :link="link"></TeamCard>
  </section>
</template>

<style lang="scss" scoped>
.teams-list {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 30px;

  @include desktop {
    grid-template-columns: repeat(3, 1fr);
  }

  @include tablet {
    grid-template-columns: repeat(2, 1fr);
  }

  @include mobile {
    grid-template-columns: repeat(1, 1fr);
  }
}
</style>
