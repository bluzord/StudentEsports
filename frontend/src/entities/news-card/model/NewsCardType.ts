export interface NewsCardType {
  id: number
  title: string
  date: string
  image: string
}

export interface NewsCardResponse {
  content: NewsCardType[]
  pageNumber: number
  pageSize: number
  totalNews: number
  totalPages: number
}
