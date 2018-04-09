import React,{Component} from 'react';
import {Route, BrowserRouter as Router, Link, Switch} from "react-router-dom";

export const Settings = (props) => {
    return <div>
        <h2>Settings ....</h2>
    </div>
};

export function Profile(props){
    return <div>
        <h2>Profile ....</h2>
    </div>
};

const NestedRouter = () => {
    return <div>
        <h1>Nested component routing ...</h1>
        <div>
            <Link to={`/nestedRouter/settings`}>Settings</Link> | <Link to={`/nestedRouter/profile`}>Profiles</Link>
        </div>
        <Switch>
            <div>
                <Route path="/nestedRouter/settings" component={Settings}/>
                <Route path="/nestedRouter/profile" component={Profile}/>
            </div>
        </Switch>
    </div>
};

export default NestedRouter;