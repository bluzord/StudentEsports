<script setup lang="ts">
import { LoginForm } from '@/widgets/login-form'
import { AdminMenu } from '@/widgets/admin-menu'
import { onMounted, ref } from 'vue'
import { useAuthStore } from '@/app/stores/AuthStore'
import { FilterComponent } from '@/shared/UIKit/filter'
import axios from 'axios'

const authStore = useAuthStore()

const game = ref<String>('CS2')

const applicationsCS2 = ref<
  {
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
  }[]
>([])

const applicationsDOTA = ref<
  {
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
  }[]
>([])

const applicationsLOL = ref<
  {
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
  }[]
>([])

const applicationsSC = ref<
  {
    id: number
    name: string
    surname: string
    patronymic: string
    vk: string
    nickname: string
    game: string
    scLeague: string
    scAPM: number
  }[]
>([])

const applicationsVLR = ref<
  {
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
  }[]
>([])

const applicationsTEKKEN = ref<
  {
    id: number
    name: string
    surname: string
    patronymic: string
    vk: string
    nickname: string
    game: string
    tekkenRank: string
  }[]
>([])

const getCS2 = async () => {
  try {
    const response = await axios.get('http://localhost:8080/admin/api/applications/cs2', {
      headers: {
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + localStorage.getItem('token')
      }
    })
    applicationsCS2.value = response.data
  } catch (err) {
    applicationsCS2.value = []
  }
}

const getDOTA = async () => {
  try {
    const response = await axios.get('http://localhost:8080/admin/api/applications/dota', {
      headers: {
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + localStorage.getItem('token')
      }
    })
    applicationsDOTA.value = response.data
  } catch (err) {
    applicationsDOTA.value = []
  }
}

const getLOL = async () => {
  try {
    const response = await axios.get('http://localhost:8080/admin/api/applications/lol', {
      headers: {
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + localStorage.getItem('token')
      }
    })
    applicationsLOL.value = response.data
  } catch (err) {
    applicationsLOL.value = []
  }
}

const getSC = async () => {
  try {
    const response = await axios.get('http://localhost:8080/admin/api/applications/sc', {
      headers: {
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + localStorage.getItem('token')
      }
    })
    applicationsSC.value = response.data
  } catch (err) {
    applicationsSC.value = []
  }
}

const getVLR = async () => {
  try {
    const response = await axios.get('http://localhost:8080/admin/api/applications/vlr', {
      headers: {
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + localStorage.getItem('token')
      }
    })
    applicationsVLR.value = response.data
  } catch (err) {
    applicationsVLR.value = []
  }
}

const getTEKKEN = async () => {
  try {
    const response = await axios.get('http://localhost:8080/admin/api/applications/tekken', {
      headers: {
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + localStorage.getItem('token')
      }
    })
    applicationsTEKKEN.value = response.data
  } catch (err) {
    applicationsTEKKEN.value = []
  }
}

onMounted(() => {
  authStore.checkAdmin()
  getCS2()
})
</script>

<template>
  <LoginForm v-if="!authStore.isAuthAsAdmin" />
  <div v-else class="admin-applications-container">
    <AdminMenu />
    <section class="admin-applications">
      <h1 class="admin-applications__title">Заявки</h1>
      <nav class="admin-applications__filters">
        <FilterComponent
          class="admin-applications__filter"
          :color="'#b5fff5'"
          :is-active="game === 'CS2'"
          @click="[(game = 'CS2'), getCS2()]"
        >
          <template v-slot:filter-name>CS2</template>
        </FilterComponent>
        <FilterComponent
          class="admin-applications__filter"
          :color="'#ff6e6e'"
          :is-active="game === 'DOTA'"
          @click="[(game = 'DOTA'), getDOTA()]"
        >
          <template v-slot:filter-name>DOTA</template>
        </FilterComponent>
        <FilterComponent
          class="admin-applications__filter"
          :color="'#ffb5f5'"
          :is-active="game === 'VLR'"
          @click="[(game = 'VLR'), getVLR()]"
        >
          <template v-slot:filter-name>VLR</template>
        </FilterComponent>
        <FilterComponent
          class="admin-applications__filter"
          :color="'#f8ffb5'"
          :is-active="game === 'LOL'"
          @click="[(game = 'LOL'), getLOL()]"
        >
          <template v-slot:filter-name>LOL</template>
        </FilterComponent>
        <FilterComponent
          class="admin-applications__filter"
          :color="'#b8b5ff'"
          :is-active="game === 'SC2'"
          @click="[(game = 'SC2'), getSC()]"
        >
          <template v-slot:filter-name>SC2</template>
        </FilterComponent>
        <FilterComponent
          class="admin-applications__filter"
          :color="'#cccccc'"
          :is-active="game === 'TEKKEN'"
          @click="[(game = 'TEKKEN'), getTEKKEN()]"
        >
          <template v-slot:filter-name>TEKKEN</template>
        </FilterComponent>
      </nav>

      <table v-if="game === 'CS2'" class="table">
        <tr>
          <th>Номер заявки</th>
          <th>Имя</th>
          <th>Фамилия</th>
          <th>Отчество</th>
          <th>ВК</th>
          <th>Ник</th>
          <th>Аккаунт Steam</th>
          <th>FaceIT ELO</th>
          <th>Аккаунт FaceIT</th>
          <th></th>
          <th></th>
        </tr>
        <tr v-for="application in applicationsCS2" :key="application.id">
          <td>{{ application.id }}</td>
          <td>{{ application.name }}</td>
          <td>{{ application.surname }}</td>
          <td>{{ application.patronymic }}</td>
          <td>
            <a :href="application.vk">Ссылка</a>
          </td>
          <td>{{ application.nickname }}</td>
          <td>
            <a :href="application.steamURL">Ссылка</a>
          </td>
          <td>{{ application.faceitELO }}</td>
          <td>
            <a :href="application.faceitURL">Ссылка</a>
          </td>
          <td></td>
          <td></td>
        </tr>
      </table>

      <table v-if="game === 'DOTA'" class="table">
        <tr>
          <th>Номер заявки</th>
          <th>Имя</th>
          <th>Фамилия</th>
          <th>Отчество</th>
          <th>ВК</th>
          <th>Ник</th>
          <th>Аккаунт Steam</th>
          <th>MMR</th>
          <th>Позиция</th>
          <th>Dota BUFF</th>
          <th></th>
          <th></th>
        </tr>
        <tr v-for="application in applicationsDOTA" :key="application.id">
          <td>{{ application.id }}</td>
          <td>{{ application.name }}</td>
          <td>{{ application.surname }}</td>
          <td>{{ application.patronymic }}</td>
          <td>
            <a :href="application.vk">Ссылка</a>
          </td>
          <td>{{ application.nickname }}</td>
          <td>
            <a :href="application.steamURL">Ссылка</a>
          </td>
          <td>{{ application.dotaMMR }}</td>
          <td>{{ application.dotaPos }}</td>
          <td>
            <a :href="application.dotaBuff">Ссылка</a>
          </td>
          <td></td>
          <td></td>
        </tr>
      </table>

      <table v-if="game === 'LOL'" class="table">
        <tr>
          <th>Номер заявки</th>
          <th>Имя</th>
          <th>Фамилия</th>
          <th>Отчество</th>
          <th>ВК</th>
          <th>Ник</th>
          <th>Riot ID</th>
          <th>Позиция</th>
          <th>Ранг</th>
          <th></th>
          <th></th>
        </tr>
        <tr v-for="application in applicationsLOL" :key="application.id">
          <td>{{ application.id }}</td>
          <td>{{ application.name }}</td>
          <td>{{ application.surname }}</td>
          <td>{{ application.patronymic }}</td>
          <td>
            <a :href="application.vk">Ссылка</a>
          </td>
          <td>{{ application.nickname }}</td>
          <td>
            {{ application.riotID }}
          </td>
          <td>{{ application.lolPos }}</td>
          <td>{{ application.lolRank }}</td>
          <td></td>
          <td></td>
        </tr>
      </table>

      <table v-if="game === 'SC2'" class="table">
        <tr>
          <th>Номер заявки</th>
          <th>Имя</th>
          <th>Фамилия</th>
          <th>Отчество</th>
          <th>ВК</th>
          <th>Ник</th>
          <th>Лига</th>
          <th>APM</th>
          <th></th>
          <th></th>
        </tr>
        <tr v-for="application in applicationsSC" :key="application.id">
          <td>{{ application.id }}</td>
          <td>{{ application.name }}</td>
          <td>{{ application.surname }}</td>
          <td>{{ application.patronymic }}</td>
          <td>
            <a :href="application.vk">Ссылка</a>
          </td>
          <td>{{ application.nickname }}</td>
          <td>
            {{ application.scLeague }}
          </td>
          <td>{{ application.scAPM }}</td>
          <td></td>
          <td></td>
        </tr>
      </table>

      <table v-if="game === 'VLR'" class="table">
        <tr>
          <th>Номер заявки</th>
          <th>Имя</th>
          <th>Фамилия</th>
          <th>Отчество</th>
          <th>ВК</th>
          <th>Ник</th>
          <th>Riot ID</th>
          <th>Роль</th>
          <th>Ранг</th>
          <th></th>
          <th></th>
        </tr>
        <tr v-for="application in applicationsVLR" :key="application.id">
          <td>{{ application.id }}</td>
          <td>{{ application.name }}</td>
          <td>{{ application.surname }}</td>
          <td>{{ application.patronymic }}</td>
          <td><a :href="application.vk">Ссылка</a></td>
          <td>{{ application.nickname }}</td>
          <td>{{ application.riotID }}</td>
          <td>{{ application.vlrRole }}</td>
          <td>{{ application.vlrRank }}</td>
          <td></td>
          <td></td>
        </tr>
      </table>

      <table v-if="game === 'TEKKEN'" class="table">
        <tr>
          <th>Номер заявки</th>
          <th>Имя</th>
          <th>Фамилия</th>
          <th>Отчество</th>
          <th>ВК</th>
          <th>Ник</th>
          <th>Ранг</th>
          <th></th>
          <th></th>
        </tr>
        <tr v-for="application in applicationsTEKKEN" :key="application.id">
          <td>{{ application.id }}</td>
          <td>{{ application.name }}</td>
          <td>{{ application.surname }}</td>
          <td>{{ application.patronymic }}</td>
          <td><a :href="application.vk">Ссылка</a></td>
          <td>{{ application.nickname }}</td>
          <td>{{ application.tekkenRank }}</td>
          <td></td>
          <td></td>
        </tr>
      </table>
    </section>
  </div>
</template>

<style lang="scss" scoped>
.admin-applications-container {
  width: 100%;

  @include flex-center;
  justify-content: start;
  gap: 10px;
}

.admin-applications {
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
  }

  tbody tr:nth-child(odd) {
    background: #525252;
  }

  tbody tr:nth-child(even) {
    background: #525252;
  }
}
</style>
