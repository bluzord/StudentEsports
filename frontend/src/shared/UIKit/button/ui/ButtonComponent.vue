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

  font-weight: bold;

  border: var(--border);
  border-radius: var(--border-radius);
  background:
    linear-gradient(var(--color-dark), var(--color-dark)) padding-box,
    var(--gradient) border-box;

  padding: 10px;

  &:hover,
  &:focus {
    background: var(--gradient) border-box;
    color: var(--color-dark);
    outline: none;
  }

  &:active {
    background: var(--color-accent);
  }
}
</style>
