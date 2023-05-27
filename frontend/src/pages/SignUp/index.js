import React, { useCallback } from "react";
//import ReactDOM from "react-dom";
import "./Signup.css";
import IconButton from "@mui/material/IconButton";
import OutlinedInput from "@mui/material/OutlinedInput";
import InputLabel from "@mui/material/InputLabel";
import InputAdornment from "@mui/material/InputAdornment";
import FormControl from "@mui/material/FormControl";
import TextField from "@mui/material/TextField";
import Visibility from "@mui/icons-material/Visibility";
import VisibilityOff from "@mui/icons-material/VisibilityOff";
//import App from '../App';

function SignUp(props) {
  const handleBirthDateChange = useCallback((date) => {
    setBirthDate(date);
  }, []);

  const handleSubmit = (event) => {
    //const rootElement=document.getElementById("containerForm");
    //ReactDOM.createRoot(rootElement).render(<App/>);
  };

  const [showPassword, setShowPassword] = React.useState(false);
  const [birthDate, setBirthDate] = React.useState(false);
  const [showPasswordConfirm, setShowPasswordConfirm] = React.useState(false);

  const handleClickShowPassword = () => setShowPassword((show) => !show);
  const handleClickShowPasswordConfirm = () =>
    setShowPasswordConfirm((show) => !show);

  const handleMouseDownPassword = (event) => {
    event.preventDefault();
  };

  const handleGoLogin = (event) => {
    //const rootElement = document.getElementById("container forms");
    //ReactDOM.createRoot(rootElement).render(<App />);
  };

  return (
    <>
      <section id="containerForm">
        <div class="form signup">
          <div class="form-content">
            <header className="signupHeader">Sign up</header>
            <form action="#">
              <TextField
                sx={{ marginTop: "5px", width: "100%" }}
                id="outlined-basic"
                label="email"
                variant="outlined"
              />
              <TextField
                sx={{ width: "100%", marginTop: "5px" }}
                id="outlined-basic"
                label="username"
                variant="outlined"
              />

              <FormControl
                sx={{ marginTop: "5px", width: "100%" }}
                variant="outlined"
              >
                <InputLabel htmlFor="outlined-adornment-password">
                  Password
                </InputLabel>
                <OutlinedInput
                  id="outlined-adornment-password"
                  type={showPassword ? "text" : "password"}
                  endAdornment={
                    <InputAdornment position="end">
                      <IconButton
                        aria-label="toggle password visibility"
                        onClick={handleClickShowPassword}
                        onMouseDown={handleMouseDownPassword}
                        edge="end"
                      >
                        {showPassword ? <VisibilityOff /> : <Visibility />}
                      </IconButton>
                    </InputAdornment>
                  }
                  label="Password"
                />
              </FormControl>

              <FormControl
                sx={{ marginTop: "5px", width: "100%" }}
                variant="outlined"
              >
                <InputLabel htmlFor="outlined-adornment-password">
                  Confirm Password
                </InputLabel>
                <OutlinedInput
                  id="outlined-adornment-password"
                  type={showPasswordConfirm ? "text" : "password"}
                  endAdornment={
                    <InputAdornment position="end">
                      <IconButton
                        aria-label="toggle password visibility"
                        onClick={handleClickShowPasswordConfirm}
                        onMouseDown={handleMouseDownPassword}
                        edge="end"
                      >
                        {showPasswordConfirm ? (
                          <VisibilityOff />
                        ) : (
                          <Visibility />
                        )}
                      </IconButton>
                    </InputAdornment>
                  }
                  label="Confirm Password"
                />
              </FormControl>

              <div class="field button-field">
                <button onClick={handleSubmit} id="sign_bottomm">
                  {" "}
                  SignUp
                </button>
              </div>
            </form>
          </div>
        </div>
      </section>
    </>
  );
}

export default SignUp;
