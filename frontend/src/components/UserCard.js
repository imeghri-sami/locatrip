import React from "react";
import { Paper, Typography, Avatar } from "@mui/material";
import { makeStyles } from "@mui/styles";
import AccountCircleIcon from "@mui/icons-material/AccountCircle";

const useStyles = makeStyles((theme) => ({
  section: {
    padding: theme.spacing(2),
    marginBottom: theme.spacing(2),
  },
}));

const UserCard = () => {
  const classes = useStyles();

  return (
    <Paper className={classes.section}>
      <Typography variant="h6" gutterBottom>
        User Information
      </Typography>
      <Avatar>
        <AccountCircleIcon />
      </Avatar>
      <Typography variant="h6" gutterBottom>
        First Name Last Name
      </Typography>
      <Typography variant="body1" gutterBottom>
        About Text
      </Typography>
    </Paper>
  );
};

export default UserCard;
