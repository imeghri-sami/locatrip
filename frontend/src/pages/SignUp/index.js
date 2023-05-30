import React, { useState } from "react";
import {
  Stepper,
  Step,
  StepLabel,
  Button,
  TextField,
  Typography,
  Container,
  Box,
} from "@mui/material";
import axios from "axios";
import { makeStyles } from "@mui/styles";
import ManageSearchIcon from "@mui/icons-material/ManageSearch";
import LocalOfferIcon from "@mui/icons-material/LocalOffer";

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

const SignupForm = () => {
  const classes = useStyles();
  const [activeStep, setActiveStep] = useState(0);
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [birthdate, setBirthdate] = useState("");
  const [aboutMe, setAboutMe] = useState("");
  const [isLookingForRentals, setIsLookingForRentals] = useState(false);
  const [isOfferingRentals, setIsOfferingRentals] = useState(false);
  const [type, setType] = useState(undefined);

  const handleNext = () => {
    setActiveStep((prevActiveStep) => prevActiveStep + 1);
  };

  const handleBack = () => {
    setActiveStep((prevActiveStep) => prevActiveStep - 1);
  };

  const handleSignup = async () => {
    try {
      // Send signup request to the server
      const response = await axios.post("users/register", {
        email,
        password,
        firstName,
        lastName,
        birthdate,
        aboutMe,
        type: type == "looking" ? 1 : 0,
      });
      // Handle successful signup
      // ...
    } catch (error) {
      // Handle signup error
      // ...
    }
  };
  const handleButtonClick = (selectedType) => {
    setType(selectedType);
  };

  const steps = ["Email & Password", "Personal Information", "Preferences"];

  const getStepContent = (stepIndex) => {
    switch (stepIndex) {
      case 0:
        return (
          <div>
            <TextField
              label="Email"
              type="email"
              fullWidth
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
              margin="normal"
            />
            <TextField
              label="Password"
              type="password"
              fullWidth
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
              margin="normal"
            />
          </div>
        );
      case 1:
        return (
          <div>
            <TextField
              label="First Name"
              value={firstName}
              onChange={(e) => setFirstName(e.target.value)}
              required
              fullWidth
              margin="normal"
            />
            <TextField
              label="Last Name"
              value={lastName}
              onChange={(e) => setLastName(e.target.value)}
              required
              fullWidth
              margin="normal"
            />
            <TextField
              label="Birthdate"
              type="date"
              value={birthdate}
              onChange={(e) => setBirthdate(e.target.value)}
              required
              InputLabelProps={{
                shrink: true,
              }}
              fullWidth
              margin="normal"
            />
          </div>
        );
      case 2:
        return (
          <div>
            <TextField
              label="About Me"
              value={aboutMe}
              onChange={(e) => setAboutMe(e.target.value)}
              multiline
              rows={4}
              fullWidth
              margin="normal"
            />
            <Box mt={2}>
              <Button
                sx={{ mx: 0.5 }}
                size="small"
                startIcon={<ManageSearchIcon />}
                variant={
                  type === undefined || type === "offering"
                    ? "outlined"
                    : "contained"
                }
                color={"info"}
                onClick={() => handleButtonClick("looking")}
              >
                Looking for rentals
              </Button>
              <Button
                size="small"
                startIcon={<LocalOfferIcon />}
                variant={
                  type === undefined || type === "looking"
                    ? "outlined"
                    : "contained"
                }
                color={"info"}
                onClick={() => handleButtonClick("offering")}
              >
                Offering rentals
              </Button>
            </Box>
          </div>
        );
      default:
        return null;
    }
  };

  return (
    <Container component="main" maxWidth="xs" className={classes.container}>
      <Typography component="h1" variant="h5" align="center" mb={2}>
        Locatrip | <small>signup</small>
      </Typography>
      <Stepper activeStep={activeStep}>
        {steps.map((label, index) => (
          <Step key={index}>
            <StepLabel>{label}</StepLabel>
          </Step>
        ))}
      </Stepper>
      <div>
        {activeStep === steps.length ? (
          <div>
            <Box
              display="flex"
              width="100%"
              alignItems="center"
              justifyContent="center"
              mt={2}
            >
              <Typography mx={1}>All steps completed</Typography>
              <Button
                onClick={handleSignup}
                variant="contained"
                color="primary"
              >
                Signup
              </Button>
            </Box>
          </div>
        ) : (
          <div>
            {getStepContent(activeStep)}
            <Box
              display="flex"
              width="100%"
              alignItems="center"
              justifyContent="center"
              mt={2}
            >
              <Button disabled={activeStep === 0} onClick={handleBack}>
                Back
              </Button>
              <Button variant="contained" color="success" onClick={handleNext}>
                {activeStep === steps.length - 1 ? "Finish" : "Next"}
              </Button>
            </Box>
          </div>
        )}
      </div>
    </Container>
  );
};

export default SignupForm;
