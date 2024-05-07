<script setup lang="ts">
import { LogoComponent } from '@/shared/UIKit/logo'
</script>

<template>
  <footer class="footer">
    <div class="footer__inner">
      <LogoComponent class="footer__logo" />
      <nav class="footer__menu">
        <ul class="footer__menu-list">
          <li class="footer__menu-item">
            <a href="https://vk.com/bluzord" class="footer__menu-link">
              <img src="@/app/images/socials/vk.svg" alt="Telegram" class="footer__menu-img" />
            </a>
          </li>
          <li class="footer__menu-item">
            <a href="https://t.me/bluzord" class="footer__menu-link">
              <img src="@/app/images/socials/tg.svg" alt="Telegram" class="footer__menu-img" />
            </a>
          </li>
        </ul>
      </nav>
    </div>
  </footer>
</template>

<style lang="scss" scoped>
.footer {
  flex: 0 0 auto;
  -webkit-box-shadow: -2px -21px 22px -3px rgba(0, 0, 0, 0.09);
  -moz-box-shadow: -2px -21px 22px -3px rgba(0, 0, 0, 0.09);
  box-shadow: -2px -21px 22px -3px rgba(0, 0, 0, 0.09);

  height: 110px;

  &__inner {
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 30px;

    @include mobile {
      flex-direction: column;
      gap: 10px;
      padding: 10px;
    }
  }

  &__menu-item {
    @include mobile {
      height: 30px;
    }
  }

  &__menu-link svg {
    @include mobile {
      height: 30px;
    }
  }

  &__logo {
    @include tablet {
      padding: 5px;
      width: 220px;
    }
  }

  &__menu-list {
    @include flex-center;
    gap: 20px;
  }

  &__menu-img {
    height: 40px;
  }
}
</style>
