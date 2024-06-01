import axios from 'axios'
import { defineStore } from 'pinia'
import { ref } from 'vue'

export const useAuthStore = defineStore('authStore', () => {
  const isAuthAsAdmin = ref<Boolean>(false)

  async function checkAdmin() {
    if (localStorage.getItem('token')) {
      try {
        const response = await axios.get('http://localhost:8080/admin/api/check', {
          headers: {
            'Content-Type': 'application/json',
            Authorization: 'Bearer ' + localStorage.getItem('token')
          }
        })
        if (response.status === 200) {
          isAuthAsAdmin.value = true
        }
      } catch (err) {
        isAuthAsAdmin.value = false
      }
    } else {
      isAuthAsAdmin.value = false
    }
  }

  return {
    isAuthAsAdmin,
    checkAdmin
  }
})
