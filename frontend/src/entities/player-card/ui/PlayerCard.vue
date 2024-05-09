<script setup lang="ts">
import { type PlayerCardType } from '../model/PlayerCardType'

interface Props {
  player: PlayerCardType
}

defineProps<Props>()
</script>

<template>
  <router-link :to="`/players/${player.id}`" class="player-card-link">
    <article class="player-card">
      <img
        :src="`src/app/images/player/${player.avatar}`"
        :alt="`${player.nickname}`"
        loading="lazy"
        class="player-card__img"
      />
      <div class="player-card__info">
        <h3 class="player-card__name">
          {{ player.name }} "{{ player.nickname }}" {{ player.surname }}
        </h3>
        <h4 class="player-card__game">{{ player.game }}</h4>
        <h4 class="player-card__team">{{ player.team }}</h4>
      </div>
    </article>
  </router-link>
</template>

<style lang="scss" scoped>
.player-card-link {
  @include reset-link;
  border: 2px solid var(--color-light);
  border-radius: var(--border-radius);
  padding: 30px;
  max-width: 720px;
}

.player-card {
  @include flex-center;
  gap: 30px;
  width: 500px;

  @include desktop {
    width: 400px;
  }

  @include mobile {
    width: 250px;
  }

  &__img {
    width: 100px;
    height: 100px;
    border: 2px solid var(--color-light);
    border-radius: 50%;
  }

  &__info {
    @include flex-center;
    flex-direction: column;
    overflow: hidden;
    gap: 10px;
  }

  &__name {
    @include fluid-text(24, 22);
    text-overflow: ellipsis;
    overflow: hidden;
    max-height: 32px;
    text-align: center;

    @include desktop {
      min-height: 64px;
    }
    @include mobile {
      min-height: 96px;
    }
  }
}
</style>
