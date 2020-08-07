import axios from 'axios';

class LoginService{

	getLoginStatus(user){
		return axios.post("http://localhost:8085/verifyLogin",user);	
	}
	
}
export default new LoginService();