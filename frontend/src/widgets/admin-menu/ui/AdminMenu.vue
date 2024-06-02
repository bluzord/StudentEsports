<script setup lang="ts"></script>

<template>
  <nav class="admin-menu">
    <ul class="admin-menu__items">
      <li class="admin-menu__item">
        <router-link to="/admin" class="admin-menu__link">Заявки</router-link>
      </li>
      <li class="admin-menu__item">
        <router-link to="/admin/news" class="admin-menu__link">Новости</router-link>
      </li>
      <li class="admin-menu__item">
        <router-link to="/admin/news/create" class="admin-menu__link"
          >Публикация новостей</router-link
        >
      </li>
      <li class="admin-menu__item">
        <router-link to="/admin/teams" class="admin-menu__link">Составы</router-link>
      </li>
      <li class="admin-menu__item">
        <router-link to="/admin/players" class="admin-menu__link">Игроки</router-link>
      </li>
    </ul>
  </nav>
</template>

<style lang="scss" scoped>
.admin-menu {
  -webkit-box-shadow: 21px -2px 20px -3px rgba(0, 0, 0, 0.09);
  -moz-box-shadow: 21px -2px 20px -3px rgba(0, 0, 0, 0.09);
  box-shadow: 21px -2px 20px -3px rgba(0, 0, 0, 0.09);

  min-height: 700px;
  @include flex-center;
  justify-content: flex-start;
  padding: 30px;

  background-color: #363636;

  &__items {
    @include flex-center;
    @include fluid-text(30, 25);
    flex-direction: column;
    align-items: start;
    gap: 30px;
  }

  &__link {
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
}
</style>
