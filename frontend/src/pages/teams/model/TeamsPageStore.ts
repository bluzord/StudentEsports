import { type TeamCardType } from '@/entities/team-card/model/TeamCard'
import { defineStore } from 'pinia'
import { computed, ref } from 'vue'

export const useTeamsPageStore = defineStore('teamsPageStore', () => {
  const game = ref<'ALL' | 'CS2' | 'DOTA' | 'VLR' | 'LOL' | 'SC2' | 'TEKKEN'>('ALL')

  const teams = ref<TeamCardType[]>([
    {
      id: 1,
      name: 'team',
      game: 'CS2',
      captainIndex: 3,
      players: ['player1', 'player2', 'player3', 'player4', 'player5'],
      logo: 'SE.svg'
    },
    {
      id: 2,
      name: 'team',
      game: 'DOTA',
      captainIndex: 3,
      players: ['player1', 'player2', 'player3', 'player4', 'player5'],
      logo: 'SE.svg'
    },
    {
      id: 3,
      name: 'team',
      game: 'VLR',
      captainIndex: 3,
      players: ['player1', 'player2', 'player3', 'player4', 'player5'],
      logo: 'SE.svg'
    },
    {
      id: 4,
      name: 'team',
      game: 'LOL',
      captainIndex: 3,
      players: ['player1', 'player2', 'player3', 'player4', 'player5'],
      logo: 'SE.svg'
    },
    {
      id: 5,
      name: 'team',
      game: 'LOL',
      captainIndex: 3,
      players: ['player1', 'player2', 'player3', 'player4', 'player5'],
      logo: 'SE.svg'
    },
    {
      id: 6,
      name: 'team',
      game: 'VLR',
      captainIndex: 0,
      players: ['s1mple', 'player2', 'player3', 'player4', 'player5'],
      logo: 'navi.svg'
    },
    {
      id: 7,
      name: 'team',
      game: 'TEKKEN',
      captainIndex: 3,
      players: ['player1'],
      logo: 'SE.svg'
    },
    {
      id: 8,
      name: 'team',
      game: 'SC2',
      captainIndex: 3,
      players: ['player1', 'player2'],
      logo: 'SE.svg'
    }
  ])

  const getTeams = async () => {}

  const filteredTeams = computed<TeamCardType[]>(() => {
    if (game.value === 'ALL') return teams.value
    return teams.value.filter((team) => team.game === game.value)
  })

  return {
    game,
    teams,
    getTeams,
    filteredTeams
  }
})
