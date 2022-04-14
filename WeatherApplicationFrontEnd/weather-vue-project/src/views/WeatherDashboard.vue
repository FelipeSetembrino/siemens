<template>
    <div>
        <h1>Current Weather</h1>
        <div class="card-body">
            <WeatherIformation />
        </div>
    </div>
</template>

<script>
import WeatherIformation from '../components/WeatherInformation.vue'
export default {
    components: {
        WeatherIformation
    }
}
</script>