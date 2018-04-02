import React, { Component } from 'react';
import { NavLink } from 'react-router-dom'
import {BrowserRouter as Router, Route, Link} from 'react-router-dom';
import WeatherDisplay, {Weather} from './components/weather/WeatherDisplay'

import PropTypes from 'prop-types';
import { withStyles } from 'material-ui/styles';
import AppBar from 'material-ui/AppBar';
import Toolbar from 'material-ui/Toolbar';
import Typography from 'material-ui/Typography';
import Button from 'material-ui/Button';
import IconButton from 'material-ui/IconButton';
import MenuIcon from 'material-ui-icons/Menu';
import AccountCircle from 'material-ui-icons/AccountCircle';
import Menu, { MenuItem } from 'material-ui/Menu';
import Paper from 'material-ui/Paper';
import Grid from 'material-ui/Grid';
import ParentComponent from "./components/parentchild/ParentComponent";

const styles = theme => ({
    root: {
        flexGrow: 1,
    },
    flex: {
        flex: 1,
    },
    menuButton: {
        marginLeft: -12,
        marginRight: 20,
    },
    paper: {
        padding: theme.spacing.unit * 2,
        textAlign: 'center',
        color: theme.palette.text.secondary,
    },
});

const divStyle = {
    display: 'inline',
    margin: '2px'
};

const Header = () => (<h1>This is a header</h1>);

class TwoWayBinding extends Component {
    constructor(props){
        super(props);
        this.handleChange = this.handleChange.bind(this);
    }

    componentWillMount() {
        //The only place where you can assign this.state is the constructor.
        this.state = {
            value: ''
        };
    }

    /**
     * Error: _this2.SetState is not a function
     * use this.setState instead of this.state, this.state is immutable so you can't modify it
     */
     handleChange = (e) => {
        this.setState( {value: e.target.value} );
    };

    render() {
        return <div style={{margin: '10px'}}>
            <h2>Two way binding demo</h2>
            <input type="text" value={this.state.value} onChange={this.handleChange}/>
            <div>
                {this.state.value}
            </div>
        </div>
    }
}

class Home extends Component {
    constructor(props){
        super(props);
        this.state = {
            open: false,
        };
    }

    render() {
        return <div>
            <AppBar position="static">
                <Toolbar>
                    <IconButton className={styles.menuButton} color="inherit" aria-label="Menu">
                        <MenuIcon />
                    </IconButton>
                    <Typography variant="title" color="inherit" className={styles.flex}>
                        Title
                    </Typography>
                    <div style={{textAlign: 'right', width: '100%'}}>
                        <NavLink to="/"><Button color="inherit">Login</Button></NavLink>
                    </div>
                    <IconButton>
                        <AccountCircle />
                    </IconButton>
                    <Menu>
                        <MenuItem>Profile</MenuItem>
                        <MenuItem>My account</MenuItem>
                    </Menu>
                </Toolbar>
            </AppBar>
            <Grid container spacing={24}>
                <Grid item xs={12}>
                    <Paper className={styles.paper}>
                        <div style={divStyle}><Link to={"/twowaybinding"}>Two way binding</Link></div>
                        <div style={divStyle}><Link to={"/parentChild"}>Parent Child</Link></div>
                        <div style={divStyle}><Link to={"/weather"}>Weather Component</Link></div>
                    </Paper>
                </Grid>
            </Grid>
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
            <Route path="/parentChild" component={ParentComponent}/>
        </div>
    </Router>
);

export default App;
