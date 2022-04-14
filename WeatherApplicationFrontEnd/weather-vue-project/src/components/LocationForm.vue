<template>
    <div class="card-body">
        <form class="container">
            <div class="row">
                <div class="form-group col">
                    <label for="locationInput">Location</label>
                    <input type="text" class="form-control" id="locationInput" placeholder="Enter location" required v-model="locationName">
                </div>
                <div class="form-group col">
                    <label for="inputLatitude">Latitude</label>
                    <input type="number" step="0.00000001" class="form-control" id="inputLatitude" placeholder="Latitude" required v-model="lat">
                </div>
                <div class="form-group col">
                    <label for="inputLongitude">Longitude</label>
                    <input type="number" step="0.00000001" class="form-control" id="inputLongitude" placeholder="Longitude" required v-model="lon">
                </div>
            </div>
            <button type="submit" class="btn btn-primary mt-2" @click.prevent="addLocation">Save</button>
        </form>
    </div>
</template>

<script>
    import LocationDataService from '../services/LocationDataService'
    export default {
        data() {
            return {
                locationName: '',
                lat: '',
                lon: ''
            }
        },
        methods: {
            addLocation() {
                if(this.locationName === '' || this.lat === '' || this.lon === '') return;
                createLocationService(this.locationName, this.lat, this.lon);
                this.$emit('add-location', {
                    locationName: this.locationName,
                    lat: this.lat,
                    lon: this.lon
                })
                this.locationName = '';
                this.lat = '';
                this.lon = '';
            }
        }

    }

    function createLocationService(locationName, lat, lon){
        // Simple POST request with a JSON body using fetch
        var data = {
            id: 0,
            locationName: locationName,
            lat: lat,
            lon: lon
        };
        LocationDataService.create(data).catch(e => alert(e));
    }
    
</script>
