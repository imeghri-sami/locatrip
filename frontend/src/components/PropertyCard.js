import React from "react";
import {
  Card,
  CardActionArea,
  CardContent,
  CardMedia,
  Typography,
} from "@mui/material";
import { useNavigate } from "react-router-dom";

const PropertyCard = ({
  id,
  image,
  address,
  title,
  price,
  description,
  startDate,
  endDate,
}) => {
  const navigate = useNavigate();
  const handleClick = () => {
    // Handle card click
    navigate(`/properties/${id}`);
  };

  function formatDate(timestamp) {
    const date = new Date(timestamp);

    const options = {
      weekday: "short",
      year: "numeric",
      month: "long",
      day: "numeric",
    };

    return date.toLocaleDateString("en-US", options);
  }

  return (
    <Card sx={{ mb: 2, mr: 1 }} onClick={handleClick}>
      <CardActionArea>
        <CardMedia
          component="img"
          alt={title}
          height="200"
          image={image}
          title={title}
        />
        <CardContent>
          <Typography variant="h5" component="h2">
            {title}
          </Typography>
          <Typography variant="h6" color="textSecondary" component="p">
            ${price}
          </Typography>
          <Typography variant="body2" color="textSecondary" component="p">
            {address}
          </Typography>
          <Typography variant="body2" color="textSecondary" component="p">
            {formatDate(startDate)}
          </Typography>
          <Typography variant="body2" color="textSecondary" component="p">
            {formatDate(endDate)}
          </Typography>
        </CardContent>
      </CardActionArea>
    </Card>
  );
};

export default PropertyCard;
