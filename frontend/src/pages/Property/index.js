import React, { useContext, useState } from "react";
import { Paper, Typography, TextField, Button } from "@mui/material";
import { makeStyles } from "@mui/styles";
import PropertyImages from "../../components/PropertyImages";
import PropertyInfo from "../../components/PropertyInfo";
import { useParams } from "react-router-dom";
import UserCard from "../../components/UserCard";
import { useEffect } from "react";
import axios from "axios";
import Comments from "../../components/Comments";
import { UserContext } from "../../context/UserContext";

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
  const [property, setProperty] = useState({});
  const [comments, setComments] = useState([]);
  const params = useParams();
  const [comment, setComment] = useState("");
  const [loading, setLoading] = useState(false);
  const [user, setUser] = useContext(UserContext);

  useEffect(() => {
    // Retrieve property
    axios
      .get(`properties/${params.id}`) // Replace with your API endpoint
      .then((response) => {
        console.log(response.data);
        setProperty(response.data);
      })
      .catch((error) => {
        console.error("Error retrieving property:", error);
      });

    // Retrieve comments
    axios
      .get("comments", { params: { propertyId: params.id } }) // Replace with your API endpoint
      .then((response) => {
        setComments(response.data);
      })
      .catch((error) => {
        console.error("Error retrieving comments:", error);
      });
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();
    // Send comment using Axios POST request
    const data = {
      comment: comment,
      rating: 3,
      property: { id: params.id },
      user: { id: 1, firstName: "test", lastName: "test" },
      added: new Date(),
    };

    setComments((prevComments) => {
      console.log([...prevComments, data]);
      return [...prevComments, data];
    });
    setComment("");
    setLoading(!loading);
    /*axios
      .post("/comments", data, {
        headers: {
          "Access-Control-Allow-Origin": "*",
          "Access-Control-Allow-Methods": "GET, POST, PUT, DELETE",
          "Access-Control-Allow-Headers":
            "Origin, X-Requested-With, Content-Type, Accept",
        },
      })
      .then((response) => {
        console.log("Comment submitted:", response.data);
        setLoading(!loading);
        setComment("");
      })
      .catch((error) => {
        console.error("Error submitting comment:", error);
      });*/
  };

  const handleCommentChange = (e) => {
    setComment(e.target.value);
  };

  return property === undefined ? (
    ""
  ) : (
    <div className={classes.root}>
      <PropertyImages images={property.images} />
      <UserCard user={property.user} />
      <PropertyInfo
        name={property.name}
        description={property.description}
        guests={property.guestCount}
        beds={property.bedCount}
        bedrooms={property.bedroomCount}
        endDate={property.availabilityStartDate}
        startDate={property.availabilityEndDate}
        type={property.type}
        price={property.price}
      />

      <Paper className={classes.commentSection}>
        <Typography variant="h6" gutterBottom>
          Comments
        </Typography>
        <form onSubmit={handleSubmit}>
          <TextField
            fullWidth
            label="Leave a comment"
            multiline
            rows={4}
            variant="outlined"
            className={classes.commentTextField}
            value={comment}
            onChange={handleCommentChange}
          />
          <Button type="submit" fullWidth variant="contained" color="primary">
            Submit
          </Button>
        </form>
        <Comments comments={comments} />
      </Paper>
    </div>
  );
};

export default Page;
