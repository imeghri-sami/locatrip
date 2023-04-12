
import './App.css';
import {useEffect, useState} from "react";

function App() {

  const [message, setMessage] = useState();

  const ENDPOINT = 'http://localhost:8080/locatrip-v0.0.1/Hello';

  useEffect(() => {
      fetchData();
  }, [])
  function fetchData() {
    fetch(ENDPOINT)
        .then(response => response.json())
        .then(data => setMessage(data.message))
        .catch(error => console.log(error));
  }

  return (
    <div className="App">
      <p>
        received message : {message}
      </p>
    </div>
  );
}

export default App;
