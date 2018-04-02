import React,{Component} from 'react'

const PLACES = [
    {name: 'Hyderabad', zip: 123},
    {name: 'Karachi', zip: 13},
    {name: 'Dadu', zip: 12}
];

class WeatherDisplay extends Component {
    render() {
        return <h3>Hello {this.props.zipcode}</h3>
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