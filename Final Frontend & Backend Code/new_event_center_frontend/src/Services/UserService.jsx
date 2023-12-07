import axios from "axios";

const USER_API_BASE_URL = "http://localhost:8084/user";

class UserService {

    getUsers(){
        return axios.get(USER_API_BASE_URL + "/get/all")
    }

    deleteUser(userId) {
        return axios.delete(USER_API_BASE_URL + "/delete/" + userId);
    }

    // buy/ticket?eventId=4&userId=1
    
    buyTicket(eventId, userId){
        return axios.post(USER_API_BASE_URL + "/buy/ticket" + "?eventId=" + eventId + "&userId=" + userId );
    }

    getTicketsDetails(userId){
        return axios.get(USER_API_BASE_URL + "/get/tickets?userId=" + userId );
    }

    requestForBooth(eventId, userId){
        return axios.post(USER_API_BASE_URL + "/request/booth" + "?eventId=" + eventId + "&userId=" + userId );
    }

    getBoothRequests(userId){
        return axios.get(USER_API_BASE_URL + "/get/booth/requests?userId=" + userId );
    }

    signup(formData){
        return axios.post(USER_API_BASE_URL + "/signup", formData);
    }

    getPendingUsers(){
        return axios.get(USER_API_BASE_URL + "/findAll/pending/users");
    }

    approveUser(userId){
        return axios.put(USER_API_BASE_URL + "/approve/user/" + userId);
    }

    deleteBooth(eventId){

    }
}

export default new UserService();