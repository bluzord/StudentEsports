<script lang="ts">
import { defineComponent } from 'vue'

export default defineComponent({
  name: 'ButtonComponent'
})
</script>

<template>
  <button class="button">
    <slot name="button-text"></slot>
  </button>
</template>

<style lang="scss" scoped>
.button {
  @include reset-button;

  color: var(--color-white);

  border: 4px solid var(--color-accent-alt);
  border-radius: var(--border-radius);

  padding: 10px;

  transition:
    border 0.3s ease,
    background-color 0.3s ease;

  &:hover,
  &:focus {
    background-color: var(--color-accent-alt);
    color: var(--color-dark);
    outline: none;
    cursor: pointer;
  }

  &:active {
    background-color: var(--color-accent);
    color: var(--color-dark);
    border: 4px solid var(--color-accent);
    cursor: pointer;
  }
}
</style>
