<script setup lang="ts">
import { ButtonComponent } from '@/shared/UIKit/button'
</script>

<template>
  <section class="hero">
    <h1 class="hero__title">StudentEsports</h1>
    <div class="hero__info">
      <div class="hero__text-and-button">
        <p class="hero__text">Мы — <strong>студенческий киберспортивный клуб</strong>.</p>
        <p class="hero__text">
          Наши игроки участвуют в разнообразных турнирах по нескольким дисциплинам: CS2, Dota 2,
          League of Legends, Valorant и другие.
        </p>
        <p class="hero__text">
          <strong>Оставляй заявку</strong>, и возможно именно ты станешь частью нашего клуба!
        </p>
        <router-link to="/application" v-slot="{ href, navigate }" tabindex="-1" class="hero__link">
          <ButtonComponent :href="href" @click="navigate" class="hero__button">
            <template v-slot:button-text> Подать заявку </template>
          </ButtonComponent>
        </router-link>
      </div>

      <img src="@/app/images/players.png" alt="" class="hero__img" loading="lazy" />
    </div>
  </section>
</template>

<style lang="scss" scoped>
.hero {
  padding: 30px 30px 0 30px;

  &__title {
    @include fluid-text(60, 30);
    text-align: center;
    font-weight: bold;
  }

  &__info {
    margin-top: 26px;
    display: flex;
    align-items: center;
    justify-content: space-around;

    height: 100%;

    @include desktop {
      flex-direction: column;
    }

    @include mobile {
      gap: 60px;
    }

    @include tablet {
      gap: 60px;
    }
  }

  &__text-and-button {
    @include flex-center;
    flex-direction: column;
    gap: 30px;
  }

  &__text {
    text-align: center;
    max-width: 600px;
  }

  &__img {
    height: 540px;

    @include desktop {
      height: 440px;
    }

    @include tablet {
      height: 340px;
    }

    @include mobile {
      height: 220px;
    }
  }

  &__link {
    @include reset-link;
  }

  &__button {
    margin-top: 26px;
    width: 300px;
  }
}
</style>
