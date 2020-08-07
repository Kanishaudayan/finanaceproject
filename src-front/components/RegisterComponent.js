import React, {Component} from 'react'
import { Link } from 'react-router-dom';
import RegisterService from '../services/RegisterService';

class RegisterComponent extends Component{
constructor(props){
   super(props);
   this.state = {
	   userName: '',
	   email:'',
	   password: ''
	   }
   this.register = this.register.bind(this);
 }
 
 register = (e) => {
        e.preventDefault();
		let registerUser={userName :this.state.userName,email:this.state.email,password:this.state.password};
        RegisterService.register(registerUser)
            .then(res => {
				console.log("success");
                //this.setState({ message: 'Order added successfully.' });
               
            });
    }

    onChange = (e) =>
        this.setState({ [e.target.name]: e.target.value });


 render() {
	 return(
	 <form>
	 <h3> Welcome to Register page</h3>
	 <label>Username:</label>
         <input
           type="text"
           name="userName"
           value={this.state.userName} onChange={this.onChange}
         />
		 <br></br>
		 <label>Email:</label>
         <input
           type="text"
           name="email"
           value={this.state.email} onChange={this.onChange}
         />
		 <br></br>
		
         <label>Password:</label>
         <input
           type="password"
           name="password"
          value={this.state.password} onChange={this.onChange}
         /><br></br>
		 
		 <button className="btn btn-success" onClick={this.register} >Register</button>
		 <Link to={{
			 pathname: "/login",
		 }}><button className="btn btn-success">Login</button></Link>
		 
       </form>
	 );
 }
}
export default  RegisterComponent;