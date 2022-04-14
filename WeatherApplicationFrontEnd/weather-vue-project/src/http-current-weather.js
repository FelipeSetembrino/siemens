import axios from "axios";
export default axios.create({
  baseURL: "http://localhost:8088/api/current-weather",
  headers: {
    'Content-Type': 'application/json',
  }
});