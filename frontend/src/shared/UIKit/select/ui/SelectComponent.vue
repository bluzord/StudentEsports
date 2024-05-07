<script setup lang="ts">
import { type Option } from '../model/Option'

interface Props {
  options: Option[]
}

defineProps<Props>()
</script>

<template>
  <select class="select">
    <option disabled value="" class="select__option" selected>
      <slot name="default-select"></slot>
    </option>
    <option
      v-for="option in options"
      :key="option.value"
      :value="option.value"
      class="select__option"
    >
      {{ option.name }}
    </option>
  </select>
</template>

<style lang="scss" scoped>
.select {
  border: 2px solid var(--color-light);
  border-radius: var(--border-radius-small);
  outline: none;

  padding: 10px;

  color: var(--color-light);
  background: none;

  width: 50%;
  text-align: center;

  @include hover {
    border: 2px solid var(--color-accent);
  }

  &:focus {
    border: 2px solid var(--color-accent-alt);
  }

  &__option {
    background: var(--color-dark);
    text-align: center;

    &:hover {
      background: red;
    }
  }
}
</style>
