<script setup lang="ts">
defineProps<{
  color?: string
  isActive: boolean
}>()
</script>

<template>
  <button :class="['filter', { 'filter--active': isActive }]">
    <slot name="filter-name"></slot>
  </button>
</template>

<style lang="scss" scoped>
.filter {
  background: none;
  border: 2px solid v-bind(color);
  border-radius: var(--border-radius);
  color: var(--color-light);
  padding: 5px;
  font-weight: bold;

  @include hover {
    color: var(--color-dark);
    background: v-bind(color);
  }

  &:focus {
    outline: none;
    color: var(--color-dark);
    background: v-bind(color);
  }

  &--active {
    color: var(--color-dark);
    background: v-bind(color);
  }
}
</style>
