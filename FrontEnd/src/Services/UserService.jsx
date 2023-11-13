import axios from "axios";

const EVENT_API_BASE_URL = "http://localhost:8084/user";

class UserService {

    getUsers(){
        return axios.get(EVENT_API_BASE_URL + "/get/all")
    }

    deleteEvent(userId) {
        return axios.delete(EVENT_API_BASE_URL + "/delete/" + userId);
      }
}

export default new UserService();