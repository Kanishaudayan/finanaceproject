import React, { Component } from 'react'

class ViewOrderComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            userId: this.props.location.state.userId
        }
        this.getOrders = this.getOrders.bind(this);
    }

    getOrders(userId) {

    }

    render() {
        return (

               
        )
    }


}
export default ViewOrdersComponent;