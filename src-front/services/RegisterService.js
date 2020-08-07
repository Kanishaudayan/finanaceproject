import axios from 'axios';
class RegisterService{
	
	register(user){
		
		return axios.post("http://localhost:8085/register",user);
	}
	
	
	

}


export default new RegisterService();