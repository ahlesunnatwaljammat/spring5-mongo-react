import React, {Component} from 'react';
import {Grid, Paper} from 'material-ui'
class ParentComponent extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <Grid container spacing={24}>
                <Grid item xs={12}>
                    <Paper>
                        <div style={{padding: '25px'}}>
                            <div style={{margin: '10px'}}>
                                Please enter color name: <input ref="txtColor"/>
                            </div>
                            <div style={{margin: '10px'}}>
                                <ChildComponent ref={instance => { this.child = instance; }} />
                                <button onClick={() => { this.child.getAlert(this.refs.txtColor.value); }}>Click</button>
                            </div>
                        </div>
                    </Paper>
                </Grid>
            </Grid>
        );
    }
}

export class ChildComponent extends Component {
    constructor(props){
        super(props);
        this.state = {
            color: ''
        }
    }

    getAlert(value) {
        this.setState({color: value})
    }

    render() {
        return (
            <h4 style={{color: this.state.color}}>Hello</h4>
        );
    }
}

export default ParentComponent;