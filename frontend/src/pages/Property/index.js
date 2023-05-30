import React, { useState } from "react";
import {
  Paper,
  Typography,
  List,
  ListItem,
  ListItemText,
  Divider,
  Avatar,
  TextField,
  Button,
} from "@mui/material";
import { makeStyles } from "@mui/styles";
import AccountCircleIcon from "@mui/icons-material/AccountCircle";
import PropertyImages from "../../components/PropertyImages";

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
    margin: theme.spacing(2),
  },
  section: {
    padding: theme.spacing(2),
    marginBottom: theme.spacing(2),
  },
  commentSection: {
    padding: theme.spacing(2),
    marginBottom: theme.spacing(2),
    display: "flex",
    flexDirection: "column",
  },
  commentTextField: {
    marginBottom: theme.spacing(2),
  },
}));

const Page = () => {
  const classes = useStyles();
  const [property, setProperty] = useState(undefined);
  const [comments, setComments] = useState([]);

  return (
    <div className={classes.root}>
      <PropertyImages />

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

      <Paper className={classes.section}>
        <Typography variant="h6" gutterBottom>
          Property Information
        </Typography>
        <List>
          <ListItem>
            <ListItemText primary="Name" secondary="Property Name" />
          </ListItem>
          <Divider />
          <ListItem>
            <ListItemText
              primary="Description"
              secondary="Property Description"
            />
          </ListItem>
          <Divider />
          <ListItem>
            <ListItemText primary="Guests" secondary="Number of Guests" />
          </ListItem>
          <Divider />
          <ListItem>
            <ListItemText primary="Bedrooms" secondary="Number of Bedrooms" />
          </ListItem>
          <Divider />
          <ListItem>
            <ListItemText primary="Beds" secondary="Number of Beds" />
          </ListItem>
          <Divider />
          <ListItem>
            <ListItemText primary="Price" secondary="Property Price" />
          </ListItem>
          <Divider />
          <ListItem>
            <ListItemText primary="Type" secondary="Property Type" />
          </ListItem>
        </List>
      </Paper>

      <Paper className={classes.commentSection}>
        <Typography variant="h6" gutterBottom>
          Comments
        </Typography>
        <TextField
          label="Leave a comment"
          multiline
          rows={4}
          variant="outlined"
          className={classes.commentTextField}
        />
        <Button variant="contained" color="primary">
          Submit
        </Button>
        <List>
          {comments.map((comment, index) => (
            <React.Fragment key={index}>
              <ListItem>
                <ListItemText
                  primary={comment.author}
                  secondary={comment.text}
                />
              </ListItem>
              <Divider />
            </React.Fragment>
          ))}
        </List>
      </Paper>
    </div>
  );
};

export default Page;
