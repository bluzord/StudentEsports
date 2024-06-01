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

  &--invalid {
    color: #ff6e6e;
    border-bottom: 2px solid #ff6e6e;

    @include hover {
      cursor: pointer;
      border-bottom: 2px solid #ff6e6e;
    }

    &:focus {
      border-bottom: 2px solid #ff6e6e;
    }

    ::placeholder {
      color: #ff6e6e;
    }
  }
}
</style>
