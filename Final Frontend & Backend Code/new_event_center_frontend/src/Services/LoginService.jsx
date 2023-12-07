import axios from "axios";

const LOGIN_API_BASE_URL = "http://localhost:8084/auth";

class LoginService {

    authenticateUser(credentials) {
        return axios.post(LOGIN_API_BASE_URL + "/login", credentials);
    }
}

export default new LoginService();