<script setup lang="ts">
import { LogoComponent } from '@/shared/UIKit/logo'
import { ButtonComponent } from '@/shared/UIKit/button'
</script>

<template>
  <header class="header">
    <div class="header__inner">
      <LogoComponent class="header__logo" />
      <nav class="header__menu hidden-mobile">
        <ul class="header__menu-list">
          <li class="header__menu-item">
            <router-link to="/news" class="header__menu-link">Новости</router-link>
          </li>
          <li class="header__menu-item">
            <router-link to="/teams" class="header__menu-link">Составы</router-link>
          </li>
          <li class="header__menu-item">
            <router-link to="/players" class="header__menu-link">Игроки</router-link>
          </li>
          <router-link
            to="/application"
            class="header__menu-button hidden-mobile"
            v-slot="{ href, navigate }"
            tabindex="-1"
          >
            <ButtonComponent :href="href" @click="navigate">
              <template v-slot:button-text> Подать заявку </template>
            </ButtonComponent>
          </router-link>
        </ul>
      </nav>
      <button
        class="header__burger-button visible-mobile"
        type="button"
        onclick="mobileOverlay.showModal()"
      >
        <span class="visually-hidden">Открыть меню</span>
      </button>
    </div>
  </header>
</template>

<style lang="scss">
.header {
  -webkit-box-shadow: -2px 21px 22px -3px rgba(0, 0, 0, 0.09);
  -moz-box-shadow: -2px 21px 22px -3px rgba(0, 0, 0, 0.09);
  box-shadow: -2px 21px 22px -3px rgba(0, 0, 0, 0.09);

  @include fluid-text(18, 16);

  @include desktop-above {
    height: 110px;
  }

  &__inner {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 30px;

    @include tablet {
      padding: 20px;
    }
  }

  &__logo {
    @include tablet {
      width: 220px;
    }
  }

  &__menu-list {
    display: flex;
    gap: 30px;
    @include flex-center;

    @include tablet {
      gap: 20px;
    }
  }

  &__menu-link {
    @include reset-link;

    &:hover,
    &:focus {
      color: var(--color-accent-alt);
      outline: none;
    }

    &:active {
      color: var(--color-accent);
      outline: none;
    }
  }
  &__menu-button {
    @include reset-link;
    outline: none;
  }

  &__burger-button {
    @include reset-button;
    height: 48px;
    width: 48px;

    position: relative;
    border-radius: var(--border-radius-small);

    @include hover {
      background-color: var(--color-accent);
    }

    &::after {
      @include abs-center;

      content: '';
      width: 50%;
      height: 3px;
      background-color: var(--color-light);
      border-radius: 5px;

      box-shadow:
        0 -8px var(--color-light),
        0 8px var(--color-light);
    }
  }
}
</style>
