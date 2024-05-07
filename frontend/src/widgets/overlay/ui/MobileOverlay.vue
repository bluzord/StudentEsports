<script setup lang="ts">
const closeDialog = function () {
  let mobileOverlay = document.getElementById('mobileOverlay') as HTMLDialogElement
  if (mobileOverlay) mobileOverlay.close()
}
</script>

<template>
  <dialog class="mobile-overlay visible-mobile" id="mobileOverlay">
    <form method="dialog" class="mobile-overlay__close-button-wrapper">
      <button class="mobile-overlay__close-button cross-button" type="submit">
        <span class="visually-hidden">Закрыть меню</span>
      </button>
    </form>
    <ul class="mobile-overlay__list">
      <li class="mobile-overlay__item">
        <router-link to="/news" class="mobile-overlay__link" @click="closeDialog">
          Новости
        </router-link>
      </li>
      <li class="mobile-overlay__item">
        <router-link to="/teams" class="mobile-overlay__link" @click="closeDialog">
          Составы
        </router-link>
      </li>
      <li class="mobile-overlay__item">
        <router-link to="/players" class="mobile-overlay__link" @click="closeDialog">
          Игроки
        </router-link>
      </li>
      <li class="mobile-overlay__item">
        <router-link to="/application" class="mobile-overlay__link" @click="closeDialog">
          Подать заявку
        </router-link>
      </li>
    </ul>
  </dialog>
</template>

<style lang="scss" scoped>
.mobile-overlay {
  background-color: var(--color-dark);

  width: 100%;
  height: 100%;
  margin: 0;
  padding: 20px;
  border: none;

  &:modal {
    max-width: 100%;
    max-height: 100%;
  }

  &__close-button-wrapper {
    display: flex;
    justify-content: end;
  }

  &__list {
    @include flex-center;
    flex-direction: column;
    gap: 50px;
    min-height: 80vh;
  }

  &__link {
    @include reset-link;

    color: var(--color-light);
    font-size: 30px;

    @include hover {
      color: var(--color-accent);
      outline: none;
      border: none;
    }
  }
}

.cross-button {
  @include reset-button;
  height: 48px;
  width: 48px;

  position: relative;
  border-radius: var(--border-radius-small);

  @include hover {
    background-color: var(--color-accent);
  }

  &::after,
  &::before {
    content: '';
    position: absolute;
    top: 45%;
    left: 5px;
    width: 80%;
    height: 3px;
    background-color: var(--color-light);
    border-radius: 5px;
  }

  &::after {
    rotate: 45deg;
  }

  &::before {
    rotate: -45deg;
  }
}
</style>
