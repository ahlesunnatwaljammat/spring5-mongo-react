1.  npm install create-react-app -g
2.  create-react-app react-app
3.  To add routing support please install the following
        a. npm install react-router-dom@next --save-dev
        b. import {BrowserRouter as Router, Route} from 'react-router-dom';
        const App = () => (
            <Router>
                <Route path="/" component={Home}/>
            </Router>
        )

4.  Now add the some component in App.js
    const Header = () => (<h1>This is a header</h1>);

    class Home extends Component {
        render() {
            return <div>
                <h1>This is a home component</h1>
            </div>
        }
    }

    const App = () => (
        <Router>
            <Route path="/" component={Home}/>
            <Route path="/header" component={Header}/>
        </Router>
    )

5. After adding components in Route you will get the following error
    Error: A <Router> may have only one child element
    To resolve the issue wrap Route in Div
    const App = () => (
        <Router>
            <div>
                <Route path="/" component={Home}/>
                <Route path="/header" component={Home}/>
            </div>
        </Router>
    );

6. When you define route and change path from / to header in browser then both components will be render
   to resolve this issue add exact in root router
    const App = () => (
        <Router>
            <div>
                <Route exact path="/" component={Home}/>
                <Route path="/header" component={Header}/>
            </div>
        </Router>
    );

===================================================
const Weather = () => (
    <h2>Testing .....</h2>
);

Error does not contain an export named 'Weather'.
To resolve add export before const
export const Weather = () => (
    <h2>Testing .....</h2>
);

To import in a component
1.  import {Weather} from './components/weather/WeatherDisplay'
2.  import in curly braces because component is exporting with export instead of export default
    e.g. see WeatherDisplay class in components folder

=====================================================
To add material suport in react, install the following packages

1.  npm install material-ui@next
2.  npm install material-ui-icons

=====================================================
To add file upload in react, download the react-dropzone dependencies

1. npm install --save react-dropzone

Demo : class Basic extends React.Component {
  constructor() {
    super()
    this.state = { files: [] }
  }

  onDrop(files) {
    this.setState({
      files
    });
  }

  render() {
    return (
      <section>
        <div className="dropzone">
          <Dropzone onDrop={this.onDrop.bind(this)}>
            <p>Try dropping some files here, or click to select files to upload.</p>
          </Dropzone>
        </div>
        <aside>
          <h2>Dropped files</h2>
          <ul>
            {
              this.state.files.map(f => <li key={f.name}>{f.name} - {f.size} bytes</li>)
            }
          </ul>
        </aside>
      </section>
    );
  }
}
<Basic />