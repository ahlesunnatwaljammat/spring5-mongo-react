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
          users: []
        };

        fetch('/api/users')
            .then(result => result.json())
            .then(json => {
                console.log(json)
                this.setState( {users: json} );
            });
    }


    render() {
        return <div>
            <h3>Hello {this.props.zipcode}</h3>
            <hr/>
            {this.state.users.map((user,index) => (
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