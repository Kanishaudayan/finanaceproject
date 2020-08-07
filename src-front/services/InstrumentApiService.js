import axios from 'axios';
class InstrumentApiService{
	
	
	getInstruments(){
		
		return axios.get("http://localhost:8085/instruments");
	}
	

}


export default new InstrumentApiService();