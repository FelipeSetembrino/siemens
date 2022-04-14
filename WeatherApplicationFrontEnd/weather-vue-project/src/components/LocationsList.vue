<template>

    <div>
        <LocationForm v-on:add-location="addLocation"></LocationForm>
        <div class="card-body">
                <table class="table table-striped table-borderless">
                <thead>
                    <tr>
                        <th>Location</th>
                        <th>Latitude</th>
                        <th>Longitude</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="(location, index) in locations" v-bind:key="index">
                        <td>{{ location.locationName }}</td>
                        <td>{{ location.lat }}</td>
                        <td>{{ location.lon }}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>

</template>

<script>
    import LocationForm from './LocationForm.vue'
    import LocationDataService from '../services/LocationDataService'
    export default {
        components: {
            LocationForm
        },
        data() {
            return {
                locations: null
            }
        },
        methods: {
            addLocation(location) {
                this.locations.push(location);
            },
            getAllLocations() {
                LocationDataService.getAll().then(response => {this.locations = response.data}).catch(e => alert(e));
            }
        },
        mounted() {
            this.getAllLocations()
        }
    }

</script>