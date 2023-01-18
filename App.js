import logo from './logo.svg';
import './App.css';
import ListEmployeeComponent from './components/ListEmployeeComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import CreateEmployeeComponent from './components/CreateEmployeeComponent';
import UpdateEmployeeComponent from './components/UpdateEmployeeComponent';
import ViewEmployeeComponent from './components/ViewEmployeeComponent';
import React from 'react';

function App() {
  return (
    <div>
      <Router>
          <HeaderComponent />
            <div className="container">
              <Switch>
                <Route exact path='/' component={ListEmployeeComponent}></Route>
                <Route path='/employees' component={ListEmployeeComponent}></Route>
                <Route path='/add-employee/:id' component={CreateEmployeeComponent}></Route>
                <Route path='/view-employee/:id' component={ViewEmployeeComponent}></Route>
              </Switch>
            </div>
          <FooterComponent />
      </Router>
    </div>
    
  );
}

export default App;
