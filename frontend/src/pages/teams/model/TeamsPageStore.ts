import { type TeamCardType } from '@/entities/team-card/model/TeamCard'
import axios from 'axios'
import { defineStore } from 'pinia'
import { computed, ref } from 'vue'

export const useTeamsPageStore = defineStore('teamsPageStore', () => {
  const game = ref<'ALL' | 'CS2' | 'DOTA' | 'VLR' | 'LOL' | 'SC2' | 'TEKKEN'>('ALL')
  const teams = ref<TeamCardType[]>([])
  const isLoading = ref<boolean>(false)

  const getTeams = async () => {
    isLoading.value = true
    const response = await axios.get('http://localhost:8080/api/teams')
    teams.value = response.data
    isLoading.value = false
  }

  const filteredTeams = computed<TeamCardType[]>(() => {
    if (game.value === 'ALL') return teams.value
    return teams.value.filter((team) => team.game === game.value)
  })

  return {
    game,
    teams,
    getTeams,
    filteredTeams,
    isLoading
  }
})
