import axios from 'axios';

class OrderBookApiService{
	
	getBuyerOrders(instrument1){
		console.log(instrument1);
		return axios.post("http://localhost:8085/getBuyOrders",instrument1);
	}
	getSellerOrders(instrument1){
		console.log(instrument1);
		return axios.post("http://localhost:8085/getSellOrders",instrument1);
	}
	pushToAlgo(order){
		console.log(order);
		return axios.post("http://localhost:8085/pushToAlgo",order);
	}
	getInstrument(instrument1){
		console.log(instrument1);
		return axios.post("http://localhost:8085/getInstrument",instrument1);
	}
}

export default new OrderBookApiService();