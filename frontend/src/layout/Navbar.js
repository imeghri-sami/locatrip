import React from "react";
import {
  AppBar,
  Toolbar,
  Typography,
  Button,
  InputBase,
  IconButton,
} from "@mui/material";
import { useNavigate } from "react-router-dom";
import { makeStyles } from "@mui/styles";
import AccountBoxIcon from "@mui/icons-material/AccountBox";
import LogoutIcon from "@mui/icons-material/Logout";
import HomeIcon from "@mui/icons-material/Home";
import { useContext } from "react";
import { UserContext } from "../context/UserContext";

const useStyles = makeStyles((theme) => ({
  appBar: {
    zIndex: theme.zIndex.drawer + 1,
  },
  title: {
    flexGrow: 1,
  },
  search: {
    position: "relative",
    borderRadius: theme.shape.borderRadius,
    backgroundColor: theme.palette.common.white,
    marginRight: theme.spacing(2),
    marginLeft: 0,
    width: "100%",
    [theme.breakpoints.up("sm")]: {
      marginLeft: theme.spacing(3),
      width: "auto",
    },
  },
  searchIcon: {
    padding: theme.spacing(0, 2),
    height: "100%",
    position: "absolute",
    pointerEvents: "none",
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
  },
  inputRoot: {
    color: "inherit",
  },
  inputInput: {
    padding: theme.spacing(1, 1, 1, 0),
    paddingLeft: `calc(1em + ${theme.spacing(4)}px)`,
    transition: theme.transitions.create("width"),
    width: "100%",
    [theme.breakpoints.up("sm")]: {
      width: "12ch",
      "&:focus": {
        width: "20ch",
      },
    },
  },
}));

const Header = () => {
  const { user, setUser } = useContext(UserContext);
  const classes = useStyles();
  const navigate = useNavigate();

  const handleSearch = (event) => {
    event.preventDefault();
    // Handle search logic
    // ...
  };

  const handleSignIn = () => {
    navigate("/login"); // Assuming '/signin' is the path for the signin page
  };

  const handleProfile = () => {
    // Handle profile logic
    // ...
  };

  const handleLogout = () => {
    localStorage.removeItem("token");
    setUser(undefined);
    navigate("/");
  };

  const handleHome = () => {
    navigate("/");
  };

  return (
    <AppBar color="default" position="fixed" className={classes.appBar}>
      <Toolbar>
        <Typography variant="h6" className={classes.title}>
          Locatrip
        </Typography>
        <div className={classes.search}>
          <form onSubmit={handleSearch}>
            <InputBase
              sx={{ p: 1 }}
              placeholder="Search..."
              classes={{
                root: classes.inputRoot,
                input: classes.inputInput,
              }}
              inputProps={{ "aria-label": "search" }}
            />
          </form>
        </div>
        {user === undefined && (
          <Button
            size="small"
            sx={{ mx: 1 }}
            variant="contained"
            color="warning"
            onClick={handleSignIn}
          >
            Sign In
          </Button>
        )}
        {user !== undefined && (
          <Button
            size="small"
            sx={{ mx: 1 }}
            startIcon={<AccountBoxIcon />}
            variant="outlined"
            color="info"
            onClick={handleProfile}
          >
            Profile
          </Button>
        )}
        {user !== undefined && (
          <Button
            size="small"
            sx={{ mx: 1 }}
            startIcon={<LogoutIcon />}
            variant="contained"
            color="error"
            onClick={handleLogout}
          >
            Logout
          </Button>
        )}
        <Button
          size="small"
          sx={{ mx: 1 }}
          startIcon={<HomeIcon />}
          variant="outlined"
          onClick={handleHome}
        >
          Home
        </Button>
      </Toolbar>
    </AppBar>
  );
};

export default Header;
