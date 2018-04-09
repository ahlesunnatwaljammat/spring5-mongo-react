import React, {Component} from 'react';
import {BrowserRouter as Router, Route, Link, withRouter} from 'react-router-dom';
import {Grid, Paper} from 'material-ui';

class TodoList extends Component {
    constructor(props){
        super(props);

        this.state = {
          todos : []
        };
    }

    componentWillMount(){

    }

    render() {
        return <div>
            <Grid container spacing={24}>
                <Grid item xs={8}>
                    <Paper>
                        <div style={ {width: '100%', display: 'flex', justifyContent: 'center'} }>
                            <h3>Todo App</h3>
                        </div>
                    </Paper>
                </Grid>
                <Grid item xs={4}>
                    <Paper>
                        <div style={ {width: '100%', display: 'flex', justifyContent: 'center'} }>
                            <h3>Todo App</h3>
                        </div>
                    </Paper>
                </Grid>
            </Grid>

            <Router>
                <div>
                    <Route path="/todoss" render={(props)=> {TodoList(...props)}}/>
                </div>
            </Router>
        </div>
    }
}

export default withRouter(TodoList);