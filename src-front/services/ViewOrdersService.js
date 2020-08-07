import axios from 'axios';

class ViewOrdersService {

    getOrders(userId) {
        return axios.get("http://localhost:8085/getOrders", userId);
    }
}

export default new ViewOrdersService();