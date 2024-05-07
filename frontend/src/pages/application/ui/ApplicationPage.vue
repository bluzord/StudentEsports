<script setup lang="ts">
import { ApplicationForm } from '@/widgets/application-form'
</script>

<template>
  <section class="application">
    <h1 class="application__title">Подать заявку</h1>
    <ApplicationForm class="application__form" />
  </section>
</template>

<style lang="scss" scoped>
.application {
  @include flex-center;
  flex-direction: column;
  width: 100%;
  padding: 30px;

  &__title {
    @include fluid-text(60, 30);
    text-align: center;
  }

  &__form {
    margin-top: 20px;
  }
}
</style>
