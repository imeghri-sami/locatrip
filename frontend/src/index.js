import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter as Router } from "react-router-dom";
import App from "./App";
import axios from "axios";

// Config the base URl
axios.defaults.baseURL = "http://localhost:8080/locatrip-1.0-SNAPSHOT/api/v1";

const root = ReactDOM.createRoot(document.getElementById("root"));

root.render(
  <Router>
    <App />
  </Router>
);
