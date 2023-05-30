import { ThemeProvider, createTheme } from "@mui/material";
import Master from "./layout/Master";
import SignIn from "./pages/SignIn";
import SignUp from "./pages/SignUp";
import Property from "./pages/Property";
import { Route, Routes } from "react-router-dom";
import PropertyCard from "./components/PropertyCard";

const theme = createTheme({
  //here you set palette, typography ect...
});

function App() {
  return (
    <ThemeProvider theme={theme}>
      <Routes>
        <Route exact path="/login" element={<SignIn />} />
        <Route exact path="/signup" element={<SignUp />} />
        <Route exact path="/" element={<Master />} />
        <Route
          exact
          path="/test"
          element={
            <PropertyCard
              image="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Image_created_with_a_mobile_phone.png/800px-Image_created_with_a_mobile_phone.png"
              title="test"
              price="tetsdf"
              description="test tes"
              startDate="tes"
              endDate="tsets"
            />
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
    </ThemeProvider>
  );
}

export default App;
