import axios from "axios";

const VENDOR_API_BASE_URL = "http://localhost:8084/vendor";

class VendorService {

    getAllEventApplications(){
        return axios.get(VENDOR_API_BASE_URL + "/get/all/event/applications");
    }

    submitStallRequest(eventId) {
        return axios.post(VENDOR_API_BASE_URL + "/submit/stall/application/" + eventId);
    }

    deleteEvent(eventId){
        return axios.delete(VENDOR_API_BASE_URL + "/events/delete/" + eventId);
    }

}

export default new VendorService();