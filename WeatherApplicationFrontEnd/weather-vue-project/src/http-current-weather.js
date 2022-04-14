import axios from "axios";
export default axios.create({
  baseURL: "https://weather-interface-service.herokuapp.com/api/current-weather",
  headers: {
    'Content-Type': 'application/json',
  }
});