<script setup lang="ts">
import { InputComponent } from '@/shared/UIKit/input'
import { ButtonComponent } from '@/shared/UIKit/button'
import { SelectComponent } from '@/shared/UIKit/select'
import { ref } from 'vue'
import { useApplicationStore } from '../model/ApplicationStore'
import {
  dotaPositions,
  valorantRanks,
  valorantRoles,
  lolPositions,
  lolRanks,
  SCLeagues
} from '@/app/stores/GamesInfo'

import { SuccessComponent } from '@/shared/UIKit/success'

const game = ref<string>('')

const applicationStore = useApplicationStore()
</script>

<template>
  <form
    class="application-form"
    @submit.prevent="applicationStore.postApplication()"
    v-if="!applicationStore.success"
  >
    <div class="application-form__input-box">
      <label for="surname">Фамилия:</label>
      <InputComponent
        id="surname"
        type="text"
        required
        placeholder="Фамилия"
        class="application-form__input"
        :value="applicationStore.surname"
        @input="applicationStore.surname = $event.target.value"
      />
    </div>

    <div class="application-form__input-box">
      <label for="name">Имя:</label>
      <InputComponent
        id="name"
        type="text"
        required
        placeholder="Имя"
        class="application-form__input"
        :value="applicationStore.name"
        @input="applicationStore.name = $event.target.value"
      />
    </div>

    <div class="application-form__input-box">
      <label for="patronymic">Отчество:</label>
      <InputComponent
        id="patronymic"
        type="text"
        required
        placeholder="Отчество"
        class="application-form__input"
        :value="applicationStore.patronymic"
        @input="applicationStore.patronymic = $event.target.value"
      />
    </div>

    <div class="application-form__input-box">
      <label for="vk">Страница ВК:</label>
      <InputComponent
        id="vk"
        type="url"
        required
        placeholder="https://vk.com/id"
        class="application-form__input"
        :value="applicationStore.vk"
        @input="applicationStore.vk = $event.target.value"
      />
    </div>

    <div class="application-form__input-box">
      <label for="nickname">Игровой никнейм:</label>
      <InputComponent
        id="nickname"
        type="text"
        required
        placeholder="nickname"
        class="application-form__input"
        :value="applicationStore.nickname"
        @input="applicationStore.nickname = $event.target.value"
      />
    </div>

    <div class="application-form__input-box">
      <label for="game">Дисциплина:</label>
      <SelectComponent
        id="game"
        :options="applicationStore.games"
        :value="game"
        @change="game = $event.target.value"
        required
        class="application-form__select"
      >
        <template v-slot:default-select>Выберите игру</template>
      </SelectComponent>
    </div>

    <div class="application-form__input-box" v-if="game === `DOTA` || game === `CS2`">
      <label for="steam">Профиль Steam:</label>
      <InputComponent
        id="steam"
        type="url"
        required
        placeholder="https://steamcommunity.com/id/..."
        class="application-form__input"
        :value="applicationStore.steamURL"
        @input="applicationStore.steamURL = $event.target.value"
      />
    </div>

    <div class="application-form__input-box" v-if="game === `CS2`">
      <label for="faceit-elo">FaceIt ELO:</label>
      <InputComponent
        id="faceit-elo"
        type="number"
        required
        placeholder="0000"
        class="application-form__input"
        :value="applicationStore.faceitELO"
        @input="applicationStore.faceitELO = $event.target.value"
      />
    </div>

    <div class="application-form__input-box" v-if="game === `CS2`">
      <label for="faceit">Профиль FaceIt:</label>
      <InputComponent
        id="faceit"
        type="url"
        required
        placeholder="https://www.faceit.com/ru/players/..."
        class="application-form__input"
        :value="applicationStore.faceitURL"
        @input="applicationStore.faceitURL = $event.target.value"
      />
    </div>

    <div class="application-form__input-box" v-if="game === `DOTA`">
      <label for="dota-mmr">MMR:</label>
      <InputComponent
        id="dota-mmr"
        type="number"
        required
        placeholder="0000"
        class="application-form__input"
        :value="applicationStore.dotaMMR"
        @input="applicationStore.dotaMMR = $event.target.value"
      />
    </div>

    <div class="application-form__input-box" v-if="game === `DOTA`">
      <label for="dota-pos">Позиция:</label>
      <SelectComponent
        id="dota-pos"
        :options="dotaPositions"
        :value="applicationStore.dotaPos"
        @change="applicationStore.dotaPos = $event.target.value"
        required
        class="application-form__select"
      >
        <template v-slot:default-select>Выберите позицию</template>
      </SelectComponent>
    </div>

    <div class="application-form__input-box" v-if="game === `DOTA`">
      <label for="dotabuff">Профиль DotaBuff:</label>
      <InputComponent
        id="dotabuff"
        type="url"
        required
        placeholder="https://ru.dotabuff.com/players/..."
        class="application-form__input"
        :value="applicationStore.dotaBuff"
        @input="applicationStore.dotaBuff = $event.target.value"
      />
    </div>

    <div class="application-form__input-box" v-if="game === `VLR`">
      <label for="vlr-rank">Ранг:</label>
      <SelectComponent
        id="vlr-rank"
        :options="valorantRanks"
        :value="applicationStore.vlrRank"
        @change="applicationStore.vlrRank = $event.target.value"
        required
        class="application-form__select"
      >
        <template v-slot:default-select>Выберите ранг</template>
      </SelectComponent>
    </div>

    <div class="application-form__input-box" v-if="game === `VLR`">
      <label for="vlr-role">Роль:</label>
      <SelectComponent
        id="vlr-role"
        :options="valorantRoles"
        :value="applicationStore.vlrRole"
        @change="applicationStore.vlrRole = $event.target.value"
        required
        class="application-form__select"
      >
        <template v-slot:default-select>Выберите роль</template>
      </SelectComponent>
    </div>

    <div class="application-form__input-box" v-if="game === `LOL`">
      <label for="lol-rank">Ранг:</label>
      <SelectComponent
        id="lol-rank"
        :options="lolRanks"
        :value="applicationStore.lolRank"
        @change="applicationStore.lolRank = $event.target.value"
        required
        class="application-form__select"
      >
        <template v-slot:default-select>Выберите ранг</template>
      </SelectComponent>
    </div>

    <div class="application-form__input-box" v-if="game === `LOL`">
      <label for="lol-pos">Позиция:</label>
      <SelectComponent
        id="lol-pos"
        :options="lolPositions"
        :value="applicationStore.lolPos"
        @change="applicationStore.lolPos = $event.target.value"
        required
        class="application-form__select"
      >
        <template v-slot:default-select>Выберите позицию</template>
      </SelectComponent>
    </div>

    <div class="application-form__input-box" v-if="game === `LOL` || game === `VLR`">
      <label for="riot-id">Riot ID:</label>
      <InputComponent
        id="riot-id"
        type="text"
        required
        placeholder="nickname#0000"
        class="application-form__input"
        :value="applicationStore.riotID"
        @input="applicationStore.riotID = $event.target.value"
      />
    </div>

    <div class="application-form__input-box" v-if="game === `TEKKEN`">
      <label for="tekken-rank">Ранг:</label>
      <InputComponent
        id="tekken-rank"
        type="text"
        required
        placeholder="Ранг"
        class="application-form__input"
        :value="applicationStore.tekkenRank"
        @input="applicationStore.tekkenRank = $event.target.value"
      />
    </div>

    <div class="application-form__input-box" v-if="game === `SC`">
      <label for="sc-league">Лига:</label>
      <SelectComponent
        id="sc-league"
        :options="SCLeagues"
        :value="applicationStore.SCLeague"
        @change="applicationStore.SCLeague = $event.target.value"
        required
        class="application-form__select"
      >
        <template v-slot:default-select>Выберите лигу</template>
      </SelectComponent>
    </div>

    <div class="application-form__input-box" v-if="game === `SC`">
      <label for="sc-apm">APM:</label>
      <InputComponent
        id="sc-apm"
        type="number"
        required
        placeholder="100"
        class="application-form__input"
        :value="applicationStore.SCAPM"
        @input="applicationStore.SCAPM = $event.target.value"
      />
    </div>

    <ButtonComponent type="submit">
      <template v-slot:button-text> Отправить </template>
    </ButtonComponent>
  </form>
  <SuccessComponent v-else />
</template>

<style lang="scss" scoped>
.application-form {
  @include flex-center;
  @include fluid-text(22, 20);
  flex-direction: column;
  gap: 40px;
  width: 100%;

  &__input-box {
    display: flex;
    flex-direction: column;
    justify-content: start;
    width: 50%;
    max-width: 800px;
    gap: 10px;

    @include tablet {
      width: 70%;
    }

    @include mobile {
      width: 90%;
    }
  }

  &__input,
  &__select {
    width: 100%;
  }

  &__select {
    margin-top: 16px;

    option {
      max-width: 800px;
    }
  }
}
</style>
