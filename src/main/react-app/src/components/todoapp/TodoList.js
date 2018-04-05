import React, {Component} from 'react';
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
        return
        <Grid container spacing={24}>
            <Grid item xs={12}>
                <div style={ {width: '100%', display: 'flex', justifyContent: 'center'} }>
                    <div>
                        <h3>Todo App</h3>
                    </div>
                </div>
            </Grid>
        </Grid>
    }
}

export default TodoList;