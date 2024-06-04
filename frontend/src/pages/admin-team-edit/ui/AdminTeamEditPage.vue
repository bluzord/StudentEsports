<script setup lang="ts">
import { LoginForm } from '@/widgets/login-form'
import { AdminMenu } from '@/widgets/admin-menu'
import { SelectComponent } from '@/shared/UIKit/select'
import { ButtonComponent } from '@/shared/UIKit/button'
import { onMounted, ref } from 'vue'
import { useAuthStore } from '@/app/stores/AuthStore'
import { useRoute } from 'vue-router'
import { type Option } from '@/shared/UIKit/select'

const route = useRoute()
import axios from 'axios'
const authStore = useAuthStore()

type FreePlayerType = {
  id: number
  nickname: string
}

interface TeamCompositionType {
  id: number
  name: string
  game: string
  players: FreePlayerType[]
}

const team = ref<TeamCompositionType>({
  id: 0,
  name: '',
  game: '',
  players: []
})
const freePlayers = ref<FreePlayerType[]>([])
const pickedPlayer = ref<string>('')

function castToOptions(players: FreePlayerType[]): Option[] {
  const options = []
  for (let i = 0; i < players.length; i++) {
    options.push({
      value: players[i].id + '',
      name: players[i].nickname
    })
  }
  return options
}

const getTeam = async () => {
  const response = await axios.get(`http://localhost:8080/admin/api/teams/${route.params.id}`, {
    headers: {
      Authorization: 'Bearer ' + localStorage.getItem('token')
    }
  })
  if (response.status === 200) {
    team.value = response.data
    getFreePlayers(team.value?.game)
  }
}

const getFreePlayers = async (game: string) => {
  const response = await axios.get(`http://localhost:8080/admin/api/players/${game}/free`, {
    headers: {
      Authorization: 'Bearer ' + localStorage.getItem('token')
    }
  })
  if (response.status === 200) {
    freePlayers.value = response.data
  }
}

const addPlayer = async () => {
  const player = freePlayers.value.filter((x) => {
    return x.id === Number(pickedPlayer.value)
  })
  console.log(player)
  team.value.players.push(player[0])
  const response = await axios.put(
    `http://localhost:8080/admin/api/teams/update-players`,
    team.value,
    {
      headers: {
        Authorization: 'Bearer ' + localStorage.getItem('token')
      }
    }
  )
  if (response.status === 200) {
    getTeam()
    pickedPlayer.value = ''
  }
}

const removePlayer = async (id: number) => {
  team.value.players = team.value.players.filter((x) => {
    return x.id != id
  })
  const response = await axios.put(
    `http://localhost:8080/admin/api/teams/update-players`,
    team.value,
    {
      headers: {
        Authorization: 'Bearer ' + localStorage.getItem('token')
      }
    }
  )
  if (response.status === 200) {
    getTeam()
  }
}

function isFree(): boolean {
  if (
    team.value?.game === 'CS2' ||
    team.value?.game === 'DOTA' ||
    team.value?.game === 'VLR' ||
    team.value?.game === 'LOL'
  ) {
    if (team.value.players.length < 5) return true
  }
  if (team.value?.game === 'SC2' || team.value?.game === 'TEKKEN') {
    if (team.value.players.length < 1) return true
  }
  return false
}

onMounted(() => {
  authStore.checkAdmin()
  getTeam()
})
</script>

<template>
  <LoginForm v-if="!authStore.isAuthAsAdmin" />
  <div v-else class="admin-edit-container">
    <AdminMenu />
    <section class="admin-edit">
      <h1 class="admin-edit__title">Редактирование состава</h1>
      <h3 class="admin-edit__team-name">{{ team?.name }}</h3>
      <h4 class="admin-edit__team-game">{{ team?.game }}</h4>
      <form class="admin-edit__form" v-if="isFree()" @submit.prevent="addPlayer()">
        <label for="add-player">Добавить игрока:</label>
        <SelectComponent
          id="add-player"
          :options="castToOptions(freePlayers)"
          :value="pickedPlayer"
          @change="pickedPlayer = $event.target.value"
          required
          class="application-form__select"
        >
          <template v-slot:default-select>Выберите игрока</template>
        </SelectComponent>
        <ButtonComponent type="submit">
          <template v-slot:button-text> Добавить </template>
        </ButtonComponent>
      </form>
      <table class="table">
        <tr>
          <th>Номер игрока</th>
          <th>Никнейм</th>
          <th></th>
        </tr>
        <tr v-for="player in team?.players" :key="player.id">
          <td>{{ player.id }}</td>
          <td>{{ player.nickname }}</td>
          <td>
            <button @click="removePlayer(player.id)">Удалить</button>
          </td>
        </tr>
      </table>
    </section>
  </div>
</template>

<style lang="scss" scoped>
.admin-edit-container {
  width: 100%;

  @include flex-center;
  justify-content: start;
  gap: 10px;
}

.admin-edit {
  @include flex-center;

  min-height: 700px;

  flex-direction: column;
  justify-content: start;
  align-items: center;
  gap: 30px;
  padding: 50px;

  &__form {
    @include flex-center;
    gap: 30px;
  }

  &__title {
    @include fluid-text(60, 30);
    text-align: center;
  }

  &__team-name {
    text-align: center;
  }

  &__team-game {
    text-align: center;
  }
}

.table {
  border: 1px solid #525252;
  table-layout: fixed;
  width: 100%;
  margin-bottom: 20px;

  th {
    font-weight: bold;
    padding: 5px;
    background: #525252;
    border: 1px solid #525252;
  }

  td {
    padding: 5px 10px;
    border: 1px solid #525252;
    text-align: left;
  }

  tbody tr:nth-child(odd) {
    background: #525252;
  }

  tbody tr:nth-child(even) {
    background: #525252;
  }
}
</style>
