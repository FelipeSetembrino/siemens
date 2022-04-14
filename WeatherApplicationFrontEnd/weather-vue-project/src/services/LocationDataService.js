import http from '../http-common'

class LocationServiceData {
    getAll() {
        return http.get("/getAllLocations")
    }

    getById(id) {
        return http.get("/getLocationInfo/${id}")
    }

    create(data){
        return http.post("/createLocation", data)
    }

} 

export default new LocationServiceData();