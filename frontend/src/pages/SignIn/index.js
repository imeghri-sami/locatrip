import React, { useContext, useState } from "react";
import { TextField, Button, Container, Grid, Typography } from "@mui/material";
import { makeStyles } from "@mui/styles";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import { UserContext } from "../../context/UserContext";

const useStyles = makeStyles((theme) => ({
  container: {
    marginTop: theme.spacing(8),
  },
  form: {
    width: "100%",
    marginTop: theme.spacing(1),
  },
  submit: {
    margin: theme.spacing(3, 0, 2),
  },
}));

const LoginForm = () => {
  const classes = useStyles();
  const navigate = useNavigate();
  const [user, setUser] = useContext(UserContext);
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState(false);

  const handleLogin = async (e) => {
    e.preventDefault();

    try {
      // Perform login request using Axios
      const response = await axios.post("users/authenticate", {
        email,
        password,
      });

      // Handle successful login
      console.log("Logged in successfully!", response.data);

      localStorage.setItem("token", response.data);

      try {
        const response = await axios.get("/users", { params: { email } });
        setUser(response.data);
        navigate("/");
      } catch (error) {}

      // Redirect to home page or dashboard
    } catch (error) {
      // Handle login error
      setError(true);
      console.error("Login failed!", error);
    }
  };

  const handleSignup = () => {
    navigate("/signup");
  };

  return (
    <Container component="main" maxWidth="xs" className={classes.container}>
      <Typography component="h1" variant="h5" align="center">
        Locatrip | <small>Login</small>
      </Typography>
      <form className={classes.form} onSubmit={handleLogin}>
        <Grid container spacing={2}>
          <Grid item xs={12}>
            <TextField
              variant="outlined"
              required
              fullWidth
              id="email"
              label="Email Address"
              name="email"
              autoComplete="email"
              value={email}
              error={error}
              onChange={(e) => setEmail(e.target.value)}
            />
          </Grid>
          <Grid item xs={12}>
            <TextField
              variant="outlined"
              required
              fullWidth
              name="password"
              label="Password"
              type="password"
              id="password"
              autoComplete="current-password"
              value={password}
              error={error}
              onChange={(e) => setPassword(e.target.value)}
            />
            {error && (
              <p style={{ color: "red" }}>Email or Password is incorrect</p>
            )}
          </Grid>
        </Grid>
        <Button
          type="submit"
          fullWidth
          variant="contained"
          color="primary"
          className={classes.submit}
          sx={{ mt: 2 }}
        >
          Login
        </Button>
        <Button
          fullWidth
          variant="contained"
          color="error"
          className={classes.submit}
          onClick={handleSignup}
          sx={{ mt: 2 }}
        >
          Sign Up
        </Button>
      </form>
    </Container>
  );
};

export default LoginForm;
