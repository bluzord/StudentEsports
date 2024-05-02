<script lang="ts">
import { defineComponent } from 'vue'
import { LogoComponent } from '@/shared/UIKit/logo'
import { ButtonComponent } from '@/shared/UIKit/button'

export default defineComponent({
  name: 'AppHeader',
  components: {
    LogoComponent,
    ButtonComponent
  }
})
</script>

<template>
  <header class="header">
    <div class="header__inner">
      <LogoComponent class="header__logo"></LogoComponent>
      <nav class="header__menu hidden-mobile">
        <ul class="header__menu-list">
          <li class="header__menu-item">
            <router-link to="/news" class="header__menu-link">Новости</router-link>
          </li>
          <li class="header__menu-item">
            <router-link to="/" class="header__menu-link">Составы</router-link>
          </li>
          <li class="header__menu-item">
            <router-link to="/" class="header__menu-link">Игроки</router-link>
          </li>
          <router-link
            to="/news"
            class="header__menu-button hidden-mobile"
            v-slot="{ href, navigate }"
            tabindex="-1"
          >
            <ButtonComponent :href="href" @click="navigate">
              <template v-slot:button-text> Отправить заявку </template>
            </ButtonComponent>
          </router-link>
        </ul>
      </nav>
    </div>
  </header>
</template>

<style lang="scss">
.header {
  -webkit-box-shadow: -2px 21px 22px -3px rgba(0, 0, 0, 0.09);
  -moz-box-shadow: -2px 21px 22px -3px rgba(0, 0, 0, 0.09);
  box-shadow: -2px 21px 22px -3px rgba(0, 0, 0, 0.09);

  &__inner {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 30px;
  }

  &__menu-list {
    font-size: 22px;
    display: flex;
    gap: 30px;
    @include flex-center;
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
}
</style>
