<template>
    <div>
        <LocationsDropdown v-on:selected-location="changeLocation" />
        <div v-if="currentWeather !== null" class="row card-body mt-3">
            <ul>
                <li>Temperature: {{Math.round(currentWeather.main.temp - 273)}}℃</li>
                <li>Description: {{currentWeather.weather[0].description}}</li>
                <li>Humidity: {{currentWeather.main.humidity}}</li>
                <li>Wind: {{currentWeather.wind.speed}} m/s</li>
            </ul>
        </div>
    </div>
</template>

<script>
import LocationsDropdown from './LocationsDropdown.vue'
import CurrentWeatherDataService from '../services/CurrentWeatherDataService';
export default {
    components: {
        LocationsDropdown
    },
    data() {
        return {
            locationInfo: null,
            currentWeather: null
        }
    },
    methods: {
        changeLocation(selectedLocation){
            this.locationInfo = selectedLocation;
            CurrentWeatherDataService.getByLatAndLon(
                this.locationInfo.lat,
                this.locationInfo.lon
            ).then(response => {this.currentWeather = response.data}).catch(e => alert(e));
        }
    }
}
</script>