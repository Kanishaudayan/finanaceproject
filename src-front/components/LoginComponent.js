import React, {Component} from 'react'
import { Link } from 'react-router-dom';
//import LoginService from '../services/LoginService';
//import { Redirect } from "react-router-dom";

class LoginComponent extends Component {

 /*constructor(props){
   super(props);
   this.state = {
	   userName: '',
	   password: '',
	   name:'',
	   pass:'',
	  id:0,
	   user:{},
	   error:false
	   }
   this.login = this.login.bind(this);
 }
 
 login = (e) => {
        e.preventDefault();
		let user={userName :this.state.userName,password:this.state.password};
        LoginService.verifyLogin(user)
            .then(res => {
				//console.log(res);
				this.setState({user: res.data});
				
				this.setState({name:user.userName});
				this.setState({pass:user.password});
				this.setState({id:user.userId});
				
				 if (!(this.state.name === this.state.userName && this.state.pass === this.state.password)) {
						return this.setState({ error: true });
					}
					
					
					if (this.state.error) {
							return <Redirect to="/login" />;
					}
					if (!this.state.error) {
							return <Redirect to="/instrument" />;
					}
            });
    }

    onChange = (e) =>
        this.setState({ [e.target.name]: e.target.value });
*/
 

 render() {
	 
   return (
   
       <form>
	   <h3> LOGIN</h3>
         <label>username:</label>
         <input
           type="text"
          // name="userName"
          // value={this.state.userName} onChange={this.onChange}
         />
		 <br></br>

         <label>password:</label>
         <input
           type="password"
           //name="password"
         // value={this.state.password} onChange={this.onChange}
         /><br></br>
		 <Link to={{
			 pathname: "/instrument",
			 }}>
		 <button className="btn btn-success" onClick={this.login} >Login</button></Link>
       </form>

       
   );
 }
}
export default LoginComponent;