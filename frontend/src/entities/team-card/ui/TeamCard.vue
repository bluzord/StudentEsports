<script setup lang="ts">
import { TeamCard } from '..'
import { type TeamCardType } from '../model/TeamCard'

interface Props {
  team: TeamCardType
  link: string
}

defineProps<Props>()
</script>

<template>
  <router-link :to="link + team.id" class="team-card-link">
    <article class="team-card">
      <img
        :src="`../src/app/images/team-logo/${team.logo}`"
        :alt="`${team.name}`"
        loading="lazy"
        class="team-card__logo"
      />
      <h3 class="team-card__name">{{ team.name }}</h3>
      <h4 class="team-card__game">{{ team.game }}</h4>
      <div class="team-card__players">
        <div
          :class="[
            'team-card__player',
            { 'team-card__player--captain': index === team.captainIndex }
          ]"
          v-for="(player, index) in team.players"
          :key="index"
        >
          {{ player }}
        </div>
      </div>
    </article>
  </router-link>
</template>

<style lang="scss" scoped>
.team-card-link {
  @include reset-link;
  border: 2px solid var(--color-light);
  border-radius: var(--border-radius);
  outline: none;
  height: 385px;

  @include hover {
    border: 2px solid var(--color-accent-alt);
  }

  &:focus {
    border: 2px solid var(--color-accent-alt);
  }

  &:active {
    border: 2px solid var(--color-accent);
  }
}

.team-card {
  padding: 15px 30px 15px 30px;
  height: 100%;
  width: 280px;

  @include flex-center;
  flex-direction: column;
  justify-content: flex-start;
  gap: 10px;

  &__logo {
    border: 2px solid var(--color-light);
    border-radius: 50%;
    width: 100px;
    height: 100px;
  }

  &__game {
    font-weight: bold;
  }

  &__players {
    @include fluid-text(22, 20);
    @include flex-center;
    flex-direction: column;
    width: 100%;
    height: 160px;
    gap: 5px;
  }

  &__player {
    max-width: 100%;
    max-height: 26px;
    text-overflow: ellipsis;
    overflow: hidden;
  }

  &__player--captain {
    color: var(--color-accent);
    display: flex;
    align-items: center;
    gap: 10px;

    &::after {
      content: '';
      background-image: url('../../../app/images/crown.svg');
      background-size: 12px 12px;
      display: inline-block;
      width: 12px;
      height: 12px;
      margin-top: -4px;
    }
  }
}
</style>
