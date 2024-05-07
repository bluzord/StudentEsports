<script setup lang="ts"></script>

<template>
  <input class="input" />
</template>

<style lang="scss" scoped>
.input {
  border: none;
  border-bottom: 2px solid var(--color-light);
  outline: none;

  background: none;
  color: var(--color-light);
  padding: 10px;

  @include hover {
    cursor: pointer;
    border-bottom: 2px solid var(--color-accent);
  }

  &:focus {
    border-bottom: 2px solid var(--color-accent-alt);
  }
}
</style>
