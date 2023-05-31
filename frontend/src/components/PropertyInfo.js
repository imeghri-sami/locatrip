import React from "react";
import {
  Paper,
  Typography,
  List,
  ListItem,
  ListItemText,
  Divider,
} from "@mui/material";
import { makeStyles } from "@mui/styles";
import { formatDate } from "../Utils";

const useStyles = makeStyles((theme) => ({
  section: {
    padding: theme.spacing(2),
    marginBottom: theme.spacing(2),
  },
}));

const PropertyInfo = ({
  name,
  description,
  guests,
  beds,
  bedrooms,
  endDate,
  startDate,
  type,
  price,
}) => {
  const classes = useStyles();

  return (
    <Paper className={classes.section}>
      <Typography variant="h6" gutterBottom>
        Property Information
      </Typography>
      <List>
        <ListItem>
          <ListItemText primary="Name" secondary={name} />
        </ListItem>
        <Divider />
        <ListItem>
          <ListItemText primary="Description" secondary={description} />
        </ListItem>
        <Divider />
        <ListItem>
          <ListItemText primary="Guests" secondary={guests} />
        </ListItem>
        <Divider />
        <ListItem>
          <ListItemText primary="Bedrooms" secondary={bedrooms} />
        </ListItem>
        <Divider />
        <ListItem>
          <ListItemText primary="Beds" secondary={beds} />
        </ListItem>
        <Divider />
        <ListItem>
          <ListItemText primary="Price" secondary={price} />
        </ListItem>
        <Divider />
        <ListItem>
          <ListItemText primary="Type" secondary={type} />
        </ListItem>
        <ListItem>
          <ListItemText
            primary="availability Start Date"
            secondary={formatDate(startDate)}
          />
        </ListItem>
        <ListItem>
          <ListItemText
            primary="availability End Date"
            secondary={formatDate(endDate)}
          />
        </ListItem>
      </List>
    </Paper>
  );
};

export default PropertyInfo;
