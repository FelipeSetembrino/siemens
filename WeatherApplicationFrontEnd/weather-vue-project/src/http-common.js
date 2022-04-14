import axios from "axios";
export default axios.create({
  baseURL: "https://weather-core-service.herokuapp.com/api/location/",
  headers: {
    'Content-Type': 'application/json',
  }
});