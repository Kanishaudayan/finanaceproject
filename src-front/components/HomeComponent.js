import React, {Component} from 'react'
import { Link } from 'react-router-dom';

class HomeComponent extends Component{


 

 render() {
   return (
   
       <form>
	   <h3> Welcome to Online Trading</h3>
	   <div>
         <Link to={{
			 pathname: "/register",
			 }}>
		<button className="btn btn-submit">Register</button></Link>
		</div>
		<div>
         <Link to={{
			 pathname: "/login",
			 }}>
		<button className="btn btn-submit">Login</button></Link>
		</div>
		
       </form>

       
   );
 }
}
export default HomeComponent;