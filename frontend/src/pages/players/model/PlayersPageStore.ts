import { type PlayerCardType } from '@/entities/player-card'
import { defineStore } from 'pinia'
import { computed, ref } from 'vue'

export const usePlayersPageStore = defineStore('playersPageStore', () => {
  const players = ref<PlayerCardType[]>([
    {
      id: 1,
      name: 'Данил',
      surname: 'Проскурин',
      nickname: 'bluzord',
      game: 'CS2',
      team: 'TEAM',
      avatar: 'SE.svg'
    },
    {
      id: 2,
      name: 'Андрей',
      surname: 'Курлыкин',
      nickname: 'blumberg',
      game: 'CS2',
      team: 'TEAM',
      avatar: 'SE.svg'
    },
    {
      id: 3,
      name: 'Александр',
      surname: 'Костылев',
      nickname: 's1mple',
      game: 'CS2',
      team: 'TEAM',
      avatar: 'SE.svg'
    }
  ])
  const search = ref<string>('')

  const filteredPlayers = computed<PlayerCardType[]>(() => {
    if (search.value !== '') {
      return players.value.filter(
        (player) =>
          player.name.toLowerCase().includes(search.value.toLowerCase()) ||
          player.surname.toLowerCase().includes(search.value.toLowerCase()) ||
          player.nickname.toLowerCase().includes(search.value.toLowerCase())
      )
    }
    return players.value
  })

  return { players, search, filteredPlayers }
})
