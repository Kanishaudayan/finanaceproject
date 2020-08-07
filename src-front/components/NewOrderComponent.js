import React, { Component } from 'react'
import { Link } from 'react-router-dom'
import NewOrderService from '../services/NewOrderService';

class NewOrderComponent extends Component {

    constructor(props) {
        super(props);
        this.state = {
            orderType: '',
            quantity: '',
            price:'',
            message: null,
            instrument: this.props.location.state.instrument
        }
        this.saveOrder = this.saveOrder.bind(this);
    }
    componentDidMount() {
        console.log(this.state.instrument);
    }

    saveOrder = (e) => {
        e.preventDefault();
        let order = {
            orderType: this.state.orderType, quantity: this.state.quantity, price: this.state.price, instrumentId: this.state.instrument,
        userId:1};
       
        NewOrderService.addOrder(order)
            .then(res => {
                this.setState({ message: 'Order added successfully' });

            });
    }

    onChange = (e) =>
        this.setState({ [e.target.name]: e.target.value });
    render() {
        return (
            <div>
                <h2 className="text-center">Add order</h2>
                <form>
                    <div className="form-group">
                        <label>Order Type:</label>
                        <input type="text" placeholder="orderType" name="orderType" className="form-control" value={this.state.orderType} onChange={this.onChange} />
                    </div>
                    <div className="form-group">
                        <label>Quantity:</label>
                        <input type="text" placeholder="quantity" name="quantity" className="form-control" value={this.state.quantity} onChange={this.onChange} />
                    </div>
                    <div className="form-group">
                        <label>Price:</label>
                        <input type="text" placeholder="price" name="price" className="form-control" value={this.state.price} onChange={this.onChange} />
                    </div>
                    <button className="btn btn-success" onClick={this.saveOrder}>Add order</button>
                </form>
                <div className="orderbooks">
                    <Link to={{
                        pathname: "/orders",
                        state: {
                           
                            instrument: this.state.instrument
                        }
                        
                    }}>
                        <button>Get orderbooks</button>
                    </Link>
                </div>


            </div>
        );
    }
}

export default NewOrderComponent;