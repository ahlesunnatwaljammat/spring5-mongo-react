import React,{Component} from 'react'

const PLACES = [
    {name: 'Hyderabad', zip: 123},
    {name: 'Karachi', zip: 13},
    {name: 'Dadu', zip: 12}
];

class WeatherDisplay extends Component {
    constructor(props){
        super(props);

        this.state = {
          mongoUsers: [],
          jpaUsers: []
        };

        fetch('/api/users/mongo')
            .then(result => result.json())
            .then(json => {
                this.setState( {mongoUsers: json} );
            });

        fetch('/api/users/jpa')
            .then(result => result.json())
            .then(json => {
                this.setState( {jpaUsers: json} );
            });
    }


    render() {
        return <div>
            <h3>Hello {this.props.zipcode}</h3>
            <hr/>
            <h3>Mongo Users</h3>
            {this.state.mongoUsers.map((user,index) => (
                <div key={index} style={{margin: '10px'}}>
                    {user.userId}, {user.username}
                </div>
            ))}

            <hr/>
            <h3>Jpa Users</h3>
            {this.state.jpaUsers.map((user,index) => (
                <div key={index} style={{margin: '10px'}}>
                    {user.userId}, {user.username}
                </div>
            ))}
        </div>
    }
}

export const Weather = () => (
    <div>
        <h2>Props demo</h2>
        <WeatherDisplay zipcode={"1234"}/>
        {PLACES.map((place, index) => (
            <button key={index} onClick={()=>{console.log('Click index: ' + index + ', ' + place.name)}}>{place.name}</button>
            ))
        }
    </div>
);

export default WeatherDisplay;