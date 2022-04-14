import http from '../http-current-weather'

class LocationServiceData {
    getByLatAndLon(lat, lon) {
        return http.get("", {
            params:{
                lat: lat,
                lon: lon
            }
        })
    }
} 

export default new LocationServiceData();