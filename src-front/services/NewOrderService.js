import axios from 'axios';

class NewOrderService {

    addOrder(order) {
        return axios.post("http://localhost:8085/placeOrder", order);
    }
}
export default new NewOrderService();