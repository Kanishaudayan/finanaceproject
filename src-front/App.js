import React from 'react';
import './App.css';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import NewOrderComponent from './components/NewOrderComponent'
import OrderBookComponent from './components/OrderBookComponent'
import InstrumentComponent from './components/InstrumentComponent'
import HomeComponent from './components/HomeComponent'
import LoginComponent from './components/LoginComponent'
import RegisterComponent from './components/RegisterComponent'

function App() {
  return (
      <div className="App">
          <div className="container">
              <Router>
                  <Switch>
		      <Route path="/" exact component={HomeComponent} />
		      <Route path="/register" exact component={RegisterComponent} />
		      <Route path="/login" exact component={LoginComponent} />s
                      <Route path="/instrument" exact component={InstrumentComponent}/>
                      <Route path="/newOrder" exact component={NewOrderComponent} />
                      <Route path="/orders" component={OrderBookComponent}/>
                  </Switch>
              </Router>
          </div>
    </div>
  );
}

export default App;
