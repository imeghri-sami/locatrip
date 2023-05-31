import React from "react";
import { Paper, Typography } from "@mui/material";
import { makeStyles } from "@mui/styles";

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
    margin: theme.spacing(2),
  },
  section: {
    padding: theme.spacing(2),
    marginBottom: theme.spacing(2),
  },
  imageContainer: {
    display: "grid",
    gridTemplateColumns: "repeat(auto-fit, minmax(200px, 1fr))",
    gridGap: theme.spacing(2),
  },
  image: {
    width: "100%",
    height: "100%",
    objectFit: "cover",
    cursor: "pointer",
  },
}));

const PropertyImages = ({ images = [] }) => {
  const classes = useStyles();

  return (
    <Paper className={classes.section}>
      <Typography variant="h6" gutterBottom>
        Images
      </Typography>
      <div className={classes.imageContainer}>
        {images.map((image, index) => (
          <img
            key={index}
            src={image}
            alt={`Image ${index + 1}`}
            className={classes.image}
          />
        ))}
      </div>
    </Paper>
  );
};

export default PropertyImages;
