import React, { Component } from 'react';
import {BrowserRouter as Router, Route, Link} from 'react-router-dom';
import WeatherDisplay, {Weather} from './components/weather/WeatherDisplay'

const Header = () => (<h1>This is a header</h1>);

class TwoWayBinding extends Component {
    constructor(props){
        super(props);
        this.state = {
            value: ''
        }

        this.handleChange = this.handleChange.bind(this);
    }

    handleChange = (e) => {
        console.log(e.target.value)
        this.state( { value: e.target.value });
    };

    render() {
        return <div style={{margin: '10px'}}>
            <h2>Two way binding demo</h2>
            <input type="text" onChange={this.handleChange}/>
            <div>
                {this.state.value}
            </div>
        </div>
    }
}

class Home extends Component {

    render() {
        const divStyle = {
            display: 'inline',
            margin: '2px'
        };

        return <div>
            <div style={divStyle}><Link to={"/twowaybinding"} activeStyle={ {color: 'red'} }>Two way binding</Link></div>
            <div style={divStyle}><Link to={"/weather"} activeStyle={ {color: 'red'} }>Weather Component</Link></div>
        </div>
    }
}

const App = () => (
    <Router>
        <div>
            <Route path="/" component={Home}/>
            {/*<Route exact path="/" component={Home}/>*/}
            <Route path="/header" component={Header}/>
            <Route path="/twowaybinding" component={TwoWayBinding}/>
            <Route path="/weather" component={Weather}/>
        </div>
    </Router>
);

export default App;
