export interface TeamCardType {
  id: number
  name: string
  game: 'CS2' | 'DOTA' | 'VLR' | 'LOL' | 'SC2' | 'TEKKEN'
  captainIndex: number
  players: string[]
  logo: string
}
