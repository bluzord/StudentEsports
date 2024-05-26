import { type PlayerCardType } from '@/entities/player-card'
import axios from 'axios'
import { defineStore } from 'pinia'
import { computed, ref } from 'vue'

export const usePlayersPageStore = defineStore('playersPageStore', () => {
  const players = ref<PlayerCardType[]>([])
  const search = ref<string>('')
  const isLoading = ref<boolean>(false)
  const isSuccess = ref<boolean>(true)

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

  const getPlayers = async () => {
    isLoading.value = true
    try {
      const response = await axios.get('http://localhost:8080/api/players')
      players.value = response.data
    } catch (err) {
      isSuccess.value = false
    } finally {
      isLoading.value = false
    }
  }

  return { players, search, filteredPlayers, isLoading, getPlayers, isSuccess }
})
