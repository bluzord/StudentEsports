<script setup lang="ts">
import { LoginForm } from '@/widgets/login-form'
import { AdminMenu } from '@/widgets/admin-menu'
import { onMounted, ref } from 'vue'
import { useAuthStore } from '@/app/stores/AuthStore'
import { FilterComponent } from '@/shared/UIKit/filter'
import axios from 'axios'

const authStore = useAuthStore()

const game = ref<String>('CS2')

type playerCS2Type = {
  id: number
  name: string
  surname: string
  patronymic: string
  vk: string
  nickname: string
  game: string
  steamURL: string
  faceitELO: number
  faceitURL: string
  team: string
  teamId: number
}

const playersCS2 = ref<playerCS2Type[]>([])

type playerDOTAType = {
  id: number
  name: string
  surname: string
  patronymic: string
  vk: string
  nickname: string
  game: string
  steamURL: string
  dotaMMR: number
  dotaPos: string
  dotaBuff: string
  team: string
  teamId: number
}

const playersDOTA = ref<playerDOTAType[]>([])

type playerLOLType = {
  id: number
  name: string
  surname: string
  patronymic: string
  vk: string
  nickname: string
  game: string
  riotID: string
  lolPos: string
  lolRank: string
  team: string
  teamId: number
}

const playersLOL = ref<playerLOLType[]>([])

type playerSCType = {
  id: number
  name: string
  surname: string
  patronymic: string
  vk: string
  nickname: string
  game: string
  scLeague: string
  scAPM: number
  team: string
  teamId: number
}

const playersSC = ref<playerSCType[]>([])

type playerVLRType = {
  id: number
  name: string
  surname: string
  patronymic: string
  vk: string
  nickname: string
  game: string
  riotID: string
  vlrRole: string
  vlrRank: string
  team: string
  teamId: number
}

const playersVLR = ref<playerVLRType[]>([])

type playerTekkenType = {
  id: number
  name: string
  surname: string
  patronymic: string
  vk: string
  nickname: string
  game: string
  tekkenRank: string
  team: string
  teamId: number
}

const playersTEKKEN = ref<playerTekkenType[]>([])

const getCS2 = async () => {
  try {
    const response = await axios.get('http://localhost:8080/admin/api/players/cs2', {
      headers: {
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + localStorage.getItem('token')
      }
    })
    playersCS2.value = response.data
  } catch (err) {
    playersCS2.value = []
  }
}

const getDOTA = async () => {
  try {
    const response = await axios.get('http://localhost:8080/admin/api/players/dota', {
      headers: {
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + localStorage.getItem('token')
      }
    })
    playersDOTA.value = response.data
  } catch (err) {
    playersDOTA.value = []
  }
}

const getLOL = async () => {
  try {
    const response = await axios.get('http://localhost:8080/admin/api/players/lol', {
      headers: {
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + localStorage.getItem('token')
      }
    })
    playersLOL.value = response.data
  } catch (err) {
    playersLOL.value = []
  }
}

const getSC = async () => {
  try {
    const response = await axios.get('http://localhost:8080/admin/api/players/sc', {
      headers: {
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + localStorage.getItem('token')
      }
    })
    playersSC.value = response.data
  } catch (err) {
    playersSC.value = []
  }
}

const getVLR = async () => {
  try {
    const response = await axios.get('http://localhost:8080/admin/api/players/vlr', {
      headers: {
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + localStorage.getItem('token')
      }
    })
    playersVLR.value = response.data
  } catch (err) {
    playersVLR.value = []
  }
}

const getTEKKEN = async () => {
  try {
    const response = await axios.get('http://localhost:8080/admin/api/players/tekken', {
      headers: {
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + localStorage.getItem('token')
      }
    })
    playersTEKKEN.value = response.data
  } catch (err) {
    playersTEKKEN.value = []
  }
}

onMounted(() => {
  authStore.checkAdmin()
  getCS2()
})
</script>

<template>
  <LoginForm v-if="!authStore.isAuthAsAdmin" />
  <div v-else class="admin-players-container">
    <AdminMenu />
    <section class="admin-players">
      <h1 class="admin-players__title">Игроки</h1>
      <nav class="admin-players__filters">
        <FilterComponent
          class="admin-players__filter"
          :color="'#b5fff5'"
          :is-active="game === 'CS2'"
          @click="[(game = 'CS2'), getCS2()]"
        >
          <template v-slot:filter-name>CS2</template>
        </FilterComponent>
        <FilterComponent
          class="admin-players__filter"
          :color="'#ff6e6e'"
          :is-active="game === 'DOTA'"
          @click="[(game = 'DOTA'), getDOTA()]"
        >
          <template v-slot:filter-name>DOTA</template>
        </FilterComponent>
        <FilterComponent
          class="admin-players__filter"
          :color="'#ffb5f5'"
          :is-active="game === 'VLR'"
          @click="[(game = 'VLR'), getVLR()]"
        >
          <template v-slot:filter-name>VLR</template>
        </FilterComponent>
        <FilterComponent
          class="admin-players__filter"
          :color="'#f8ffb5'"
          :is-active="game === 'LOL'"
          @click="[(game = 'LOL'), getLOL()]"
        >
          <template v-slot:filter-name>LOL</template>
        </FilterComponent>
        <FilterComponent
          class="admin-players__filter"
          :color="'#b8b5ff'"
          :is-active="game === 'SC2'"
          @click="[(game = 'SC2'), getSC()]"
        >
          <template v-slot:filter-name>SC2</template>
        </FilterComponent>
        <FilterComponent
          class="admin-players__filter"
          :color="'#cccccc'"
          :is-active="game === 'TEKKEN'"
          @click="[(game = 'TEKKEN'), getTEKKEN()]"
        >
          <template v-slot:filter-name>TEKKEN</template>
        </FilterComponent>
      </nav>

      <table v-if="game === 'CS2'" class="table">
        <tr>
          <th>Номер игрока</th>
          <th>Имя</th>
          <th>Фамилия</th>
          <th>Отчество</th>
          <th>ВК</th>
          <th>Ник</th>
          <th>Аккаунт Steam</th>
          <th>FaceIT ELO</th>
          <th>Аккаунт FaceIT</th>
          <th>Команда</th>
        </tr>
        <tr v-for="player in playersCS2" :key="player.id">
          <td>{{ player.id }}</td>
          <td>{{ player.name }}</td>
          <td>{{ player.surname }}</td>
          <td>{{ player.patronymic }}</td>
          <td>
            <a :href="player.vk">Ссылка</a>
          </td>
          <td>{{ player.nickname }}</td>
          <td>
            <a :href="player.steamURL">Ссылка</a>
          </td>
          <td>{{ player.faceitELO }}</td>
          <td>
            <a :href="player.faceitURL">Ссылка</a>
          </td>
          <td>
            <a :href="`/admin/teams/${player.teamId}`">{{ player.team }}</a>
          </td>
        </tr>
      </table>

      <table v-if="game === 'DOTA'" class="table">
        <tr>
          <th>Номер игрока</th>
          <th>Имя</th>
          <th>Фамилия</th>
          <th>Отчество</th>
          <th>ВК</th>
          <th>Ник</th>
          <th>Аккаунт Steam</th>
          <th>MMR</th>
          <th>Позиция</th>
          <th>Dota BUFF</th>
          <th>Команда</th>
        </tr>
        <tr v-for="player in playersDOTA" :key="player.id">
          <td>{{ player.id }}</td>
          <td>{{ player.name }}</td>
          <td>{{ player.surname }}</td>
          <td>{{ player.patronymic }}</td>
          <td>
            <a :href="player.vk">Ссылка</a>
          </td>
          <td>{{ player.nickname }}</td>
          <td>
            <a :href="player.steamURL">Ссылка</a>
          </td>
          <td>{{ player.dotaMMR }}</td>
          <td>{{ player.dotaPos }}</td>
          <td>
            <a :href="player.dotaBuff">Ссылка</a>
          </td>
          <td>
            <a :href="`/admin/teams/${player.teamId}`">{{ player.team }}</a>
          </td>
        </tr>
      </table>

      <table v-if="game === 'LOL'" class="table">
        <tr>
          <th>Номер игрока</th>
          <th>Имя</th>
          <th>Фамилия</th>
          <th>Отчество</th>
          <th>ВК</th>
          <th>Ник</th>
          <th>Riot ID</th>
          <th>Позиция</th>
          <th>Ранг</th>
          <th>Команда</th>
        </tr>
        <tr v-for="player in playersLOL" :key="player.id">
          <td>{{ player.id }}</td>
          <td>{{ player.name }}</td>
          <td>{{ player.surname }}</td>
          <td>{{ player.patronymic }}</td>
          <td>
            <a :href="player.vk">Ссылка</a>
          </td>
          <td>{{ player.nickname }}</td>
          <td>
            {{ player.riotID }}
          </td>
          <td>{{ player.lolPos }}</td>
          <td>{{ player.lolRank }}</td>
          <td>
            <a :href="`/admin/teams/${player.teamId}`">{{ player.team }}</a>
          </td>
        </tr>
      </table>

      <table v-if="game === 'SC2'" class="table">
        <tr>
          <th>Номер игрока</th>
          <th>Имя</th>
          <th>Фамилия</th>
          <th>Отчество</th>
          <th>ВК</th>
          <th>Ник</th>
          <th>Лига</th>
          <th>APM</th>
          <th>Команда</th>
        </tr>
        <tr v-for="player in playersSC" :key="player.id">
          <td>{{ player.id }}</td>
          <td>{{ player.name }}</td>
          <td>{{ player.surname }}</td>
          <td>{{ player.patronymic }}</td>
          <td>
            <a :href="player.vk">Ссылка</a>
          </td>
          <td>{{ player.nickname }}</td>
          <td>
            {{ player.scLeague }}
          </td>
          <td>{{ player.scAPM }}</td>
          <td>
            <a :href="`/admin/teams/${player.teamId}`">{{ player.team }}</a>
          </td>
        </tr>
      </table>

      <table v-if="game === 'VLR'" class="table">
        <tr>
          <th>Номер игрока</th>
          <th>Имя</th>
          <th>Фамилия</th>
          <th>Отчество</th>
          <th>ВК</th>
          <th>Ник</th>
          <th>Riot ID</th>
          <th>Роль</th>
          <th>Ранг</th>
          <th>Команда</th>
        </tr>
        <tr v-for="player in playersVLR" :key="player.id">
          <td>{{ player.id }}</td>
          <td>{{ player.name }}</td>
          <td>{{ player.surname }}</td>
          <td>{{ player.patronymic }}</td>
          <td><a :href="player.vk">Ссылка</a></td>
          <td>{{ player.nickname }}</td>
          <td>{{ player.riotID }}</td>
          <td>{{ player.vlrRole }}</td>
          <td>{{ player.vlrRank }}</td>
          <td>
            <a :href="`/admin/teams/${player.teamId}`">{{ player.team }}</a>
          </td>
        </tr>
      </table>

      <table v-if="game === 'TEKKEN'" class="table">
        <tr>
          <th>Номер игрока</th>
          <th>Имя</th>
          <th>Фамилия</th>
          <th>Отчество</th>
          <th>ВК</th>
          <th>Ник</th>
          <th>Ранг</th>
          <th>Команда</th>
        </tr>
        <tr v-for="player in playersTEKKEN" :key="player.id">
          <td>{{ player.id }}</td>
          <td>{{ player.name }}</td>
          <td>{{ player.surname }}</td>
          <td>{{ player.patronymic }}</td>
          <td><a :href="player.vk">Ссылка</a></td>
          <td>{{ player.nickname }}</td>
          <td>{{ player.tekkenRank }}</td>
          <td>
            <a :href="`/admin/teams/${player.teamId}`">{{ player.team }}</a>
          </td>
        </tr>
      </table>
    </section>
  </div>
</template>

<style lang="scss" scoped>
.admin-players-container {
  width: 100%;

  @include flex-center;
  justify-content: start;
  gap: 10px;
}

.admin-players {
  @include flex-center;

  min-height: 700px;

  flex-direction: column;
  justify-content: start;
  align-items: center;
  gap: 30px;
  padding: 50px;

  &__title {
    @include fluid-text(60, 30);
    text-align: center;
  }

  &__filters {
    display: flex;
    gap: 10px;
    justify-content: end;
    flex-wrap: wrap;
  }

  &__filter {
    width: 120px;
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

    a {
      color: var(--color-light);
      text-decoration: underline;

      @include hover {
        color: var(--color-accent);
      }
    }
  }

  tbody tr:nth-child(odd) {
    background: #525252;
  }

  tbody tr:nth-child(even) {
    background: #525252;
  }
}
</style>
