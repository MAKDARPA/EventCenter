import axios from "axios";

const EVENT_API_BASE_URL = "http://localhost:8084/event";

class EventService {

    getEvents(){
        return axios.get(EVENT_API_BASE_URL + "/get/all/events")
    }

    getEventById(eventId){
        return axios.get(EVENT_API_BASE_URL + "/get/event/byid/" + eventId)
    }

    deleteEvent(eventId) {
        return axios.delete(EVENT_API_BASE_URL + "/delete/" + eventId);
      }


}

export default new EventService();