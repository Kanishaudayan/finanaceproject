import React, {Component} from 'react'
import { Link } from 'react-router-dom';
import InstrumentApiService from '../services/InstrumentApiService';

const divStyle = {
  margin: '40px',
  border: '1px solid black '
  
};
const thstyle={
	background: 'green',
	border: '1px solid black',
	align:'center',
	padding: '15px'
}
const tdstyle={
	border: '1px solid black',
	align:'center',
	padding: '15px'
};
class InstrumentComponent extends Component{

	
	constructor(props){
		super(props);
		
		this.state = {
			instruments: [],
			instrument:''
		}
		this.getInstruments = this.getInstruments.bind(this);
	}
	componentDidMount(){
		this.getInstruments();
	}
	
	
	
	getInstruments(){
				
		InstrumentApiService.getInstruments()
							.then( res => {
								
								this.setState({instruments: res.data})
								
							}
		
			)	
		}
	
	
	render(){
		
		return (
		
		<div >
		<center>
			<table style={divStyle}>
			
			
			  <thead>
				
				<th style={thstyle}> Instrument Id </th>
				<th style={thstyle}> Instrument Name</th>
				<th style={thstyle}> MarketCap</th>
				<th style={thstyle}> Instrument Price</th>
				<th style={thstyle}> Select Instrument</th>
			  
			  </thead>
			  
			  <tbody>
			  
			  {
				  
				this.state.instruments.map(
					instrument =>
					
						<tr key={instrument.instrumentId}>
						
						
							<td style={tdstyle}> {instrument.instrumentId} </td>
							<td style={tdstyle}> {instrument.instrumentName} </td>
							<td style={tdstyle}> {instrument.marketCap} </td>
							<td style={tdstyle}> {instrument.price}</td>
							<td style={tdstyle}><Link
									to={{
										pathname: "/newOrder",
										state:{
											instrument: instrument.instrumentId 
										}
										}}
									><button className="btn btn-submit">Select</button></Link></td>

						</tr>
					
									  
				 ) 
			  }
				
			  
			  </tbody>
			
			
			</table>
		
		</center>
		</div>
		
		
		
	   )
		
		
	}
	
	


}

export default InstrumentComponent;