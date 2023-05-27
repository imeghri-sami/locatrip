import { Master } from "./layout/Master";
import SignIn from "./pages/SignIn";
import SignUp from "./pages/SignUp";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";

function App() {
  //const ENDPOINT = "http://localhost:8080/locatrip-v0.0.1/Hello";

  return (
    <div className="App">
      <Router>
        <Switch>
          <Route exact path="/login">
            <SignIn />
          </Route>
          <Route exact path="/register">
            <SignUp />
          </Route>
          <Route exact path="/">
            <Master />
          </Route>
        </Switch>
      </Router>
      {/*Routing*/}
    </div>
  );
}

export default App;
