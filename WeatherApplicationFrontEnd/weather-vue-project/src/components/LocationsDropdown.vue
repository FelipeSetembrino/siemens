<template>

        <div class="row">
            <div class="col-4">
                <span style="margin-right: 10px; font-weight: bold;">Select a location</span>
                <select v-model="selectedLocation">
                    <option v-for="location in locations" :value="location" :key="location.id">{{location.locationName}}</option>
                </select>
            </div>
        </div>

</template>

<script>
    import LocationDataService from '../services/LocationDataService';
    export default {
        components: {
            
        },
        data() {
            return {
                locations: null,
                selectedLocation: null
            }
        },
        methods: {
            getAllLocations() {
                LocationDataService.getAll().then(response => {this.locations = response.data}).catch(e => alert(e));
            }
        },
        mounted() {
            this.getAllLocations()
        },
        watch: {
            selectedLocation(){
                this.$emit('selected-location', this.selectedLocation);
            }
        }
    }

</script>