import { defineStore } from 'pinia'
import { ref } from 'vue'
import { type Option } from '@/shared/UIKit/select'
import axios from 'axios'

export const useApplicationStore = defineStore('applicationStore', () => {
  const patronymic = ref<string>('')
  const name = ref<string>('')
  const surname = ref<string>('')
  const vk = ref<string>('')
  const nickname = ref<string>('')

  const steamURL = ref<string>('')

  const faceitELO = ref<number>()
  const faceitURL = ref<string>('')

  const dotaMMR = ref<number>()
  const dotaPos = ref<string>('')
  const dotaBuff = ref<string>('')

  const riotID = ref<string>('')

  const vlrRole = ref<string>('')
  const vlrRank = ref<string>('')

  const lolPos = ref<string>('')
  const lolRank = ref<string>('')

  const tekkenRank = ref<string>('')

  const SCLeague = ref<string>('')
  const SCAPM = ref<number>()

  const games = ref<Option[]>([
    {
      value: 'CS2',
      name: 'Counter Strike 2'
    },
    {
      value: 'DOTA',
      name: 'Dota 2'
    },
    {
      value: 'VLR',
      name: 'Valorant'
    },
    {
      value: 'LOL',
      name: 'League Of Legends'
    },
    {
      value: 'SC',
      name: 'StarCraft II'
    },
    {
      value: 'TEKKEN',
      name: 'Tekken 7'
    }
  ])

  const success = ref<boolean>(false)

  const postApplication = async () => {
    const response = await axios.post('http://localhost:8080/api/application/create', {
      name: name.value,
      surname: surname.value,
      patronymic: patronymic.value,
      vk: vk.value,
      nickname: nickname.value,
      steamURL: steamURL.value,
      faceitELO: faceitELO.value,
      faceitURL: faceitURL.value,
      dotaMMR: dotaMMR.value,
      dotaPos: dotaPos.value,
      dotaBuff: dotaBuff.value,
      riotID: riotID.value,
      vlrRole: vlrRole.value,
      vlrRank: vlrRank.value,
      lolPos: lolPos.value,
      lolRank: lolRank.value,
      tekkenRank: tekkenRank.value,
      SCLeague: SCLeague.value,
      SCAPM: SCAPM.value
    })
    if (response.status === 201) success.value = true
  }

  return {
    games,
    postApplication,
    patronymic,
    name,
    surname,
    vk,
    nickname,
    steamURL,
    faceitELO,
    faceitURL,
    dotaMMR,
    dotaPos,
    dotaBuff,
    riotID,
    vlrRole,
    vlrRank,
    lolPos,
    lolRank,
    tekkenRank,
    SCLeague,
    SCAPM,
    success
  }
})
