import { ThemeProvider, createTheme } from "@mui/material";
import Master from "./layout/Master";
import SignIn from "./pages/SignIn";
import SignUp from "./pages/SignUp";
import Property from "./pages/Property";
import { Route, Routes } from "react-router-dom";
import PropertyCard from "./components/PropertyCard";
import Properties from "./pages/Properties";
import { UserProvider } from "./context/UserContext";

const theme = createTheme({
  //here you set palette, typography ect...
});

function App() {
  return (
    <ThemeProvider theme={theme}>
      <UserProvider>
        <Routes>
          <Route exact path="/login" element={<SignIn />} />
          <Route exact path="/signup" element={<SignUp />} />
          <Route
            exact
            path="/"
            element={
              <Master>
                <Properties />
              </Master>
            }
          />
          <Route
            exact
            path="/properties/:id"
            element={
              <Master>
                <Property />
              </Master>
            }
          />
          {/* <Route exact path="/register">
              <SignUp />
            </Route>
            <Route exact path="/">
              <Master />
            </Route> */}
        </Routes>
      </UserProvider>
    </ThemeProvider>
  );
}

export default App;
