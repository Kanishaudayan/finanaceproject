import React, {Component} from 'react'
import OrderBookApiService from '../services/OrderBookApiService';

const divStyle = {
  margin: '40px 0px 40px 120px',
  border: '1px solid black',
  float:'left'
  
};
const divStyle1 = {
  margin: '40px 40px 40px 0px',
  border: '1px solid black',	
  float:'left'
  
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

class OrderBookComponent extends Component{

	constructor(props){
		super(props);
		this.state = {
			buyOrders:[],
			sellOrders:[],
			instrument:{},
			result:'',
			instrumentId: this.props.location.state.instrument
		}

		this.getAllBuyerOrders = this.getAllBuyerOrders.bind(this);
		this.getAllSellerOrders = this.getAllSellerOrders.bind(this);
		this.pushToAlgo=this.pushToAlgo.bind(this);
		this.getInstrument=this.getInstrument.bind(this);

	}
	componentDidMount(){
		console.log(this.state.instrumentId);
		let instru={instrumentId:this.state.instrumentId};
		this.getAllBuyerOrders(instru);
		this.getAllSellerOrders(instru);
		this.getInstrument(instru);
		
	}
	getAllBuyerOrders(instrumentId){

		OrderBookApiService.getBuyerOrders(instrumentId)
					.then(res =>{this.setState({buyOrders:res.data})})

	}
	
	getAllSellerOrders(instrumentId){

		OrderBookApiService.getSellerOrders(instrumentId)
					.then(res =>{this.setState({sellOrders:res.data})})
	}
	getInstrument(instrumentId){
		OrderBookApiService.getInstrument(instrumentId)
					.then(res =>{this.setState({instrument:res.data})})
	
	}
	pushToAlgo(orderId){
		console.log(orderId);
		let order={orderId:orderId};
		OrderBookApiService.pushToAlgo(order)
	}
	render(){
	
		return(
			
			<div className="orderBook">
				<p>InstrumentId :{this.state.instrument.instrumentName}</p>
				<p>MIC : {this.state.instrument.mic}</p>
				<p>Current price : {this.state.instrument.price}</p>

				<table style={divStyle}>
					<thead>
						
						<th style={thstyle}> order status</th>
						<th style={thstyle}> Total stocks</th>
						<th style={thstyle}> stocks left</th>
						<th style={thstyle}> bid price</th>
						<th style={thstyle}> push    </th>
						
					</thead>
					
					<tbody>
					{
						this.state.buyOrders.map(
							buyOrder =>
								<tr key={buyOrder.orderId}>
					
									<td style={tdstyle}> {buyOrder.status}         </td>
									<td style={tdstyle}> {buyOrder.quantity}        </td>
									<td style={tdstyle}> {buyOrder.stocksToBeTraded}</td>
									<td style={tdstyle}> Rs. {buyOrder.price}          </td>
									{buyOrder.status==='new' && <td style={tdstyle}><button onClick={() => this.pushToAlgo(buyOrder.orderId)}>push to algo engine </button></td>}

								</tr>
						)
					}
					</tbody>
				</table>
				
				<table style={divStyle1}>
					<thead>
						<th style={thstyle}> ask price 	    </th>
						<th style={thstyle}> stocks left    </th>
						<th style={thstyle}> Total stocks    </th>
						<th style={thstyle}> order status </th>
						<th style={thstyle}> push    </th>
					</thead>
					
					<tbody>
					{
						this.state.sellOrders.map(
							sellOrder =>
								<tr key={sellOrder.orderId}>
									<td style={tdstyle}> Rs. {sellOrder.price}           </td>
									<td style={tdstyle}> {sellOrder.stocksToBeTraded} </td>
									<td style={tdstyle}> {sellOrder.quantity} </td>
									<td style={tdstyle}> {sellOrder.status}	 </td>
									{sellOrder.status==='new' && <td style={tdstyle}><button onClick={() => this.pushToAlgo(sellOrder.orderId)}>push to algo engine </button></td>}
								</tr>
						)
					}
					</tbody>
				</table>
			</div>
				
		)
	}
}
export default OrderBookComponent;




