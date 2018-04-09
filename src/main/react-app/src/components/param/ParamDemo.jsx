import React,{Component} from 'react';

class ParamDemo extends Component {
    constructor(props){
        super(props);
    }

    render(){
        return <div>
            User from param: {this.props.match.params.username || "us"}
        </div>
    }
}

export default ParamDemo;