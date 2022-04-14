import {createRouter, createWebHistory} from 'vue-router'
import WeatherDashboard from '../views/WeatherDashboard.vue'
import Backoffice from '../views/Backoffice.vue'

const routes = [
    {
        path: '/',
        name: 'Weather',
        component: WeatherDashboard
    },
    {
        path: '/backoffice',
        name: 'Backoffice',
        component: Backoffice
    }
]

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes
})

export default router