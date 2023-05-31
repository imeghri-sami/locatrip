import React from "react";
import { List, ListItem, ListItemText, Divider } from "@mui/material";
import { formatDate } from "../Utils";

const Comments = ({ comments = [] }) => {
  return (
    <List>
      {comments.map((comment, index) => (
        <React.Fragment key={index}>
          <ListItem>
            <ListItemText
              primary={`${comment.user.firstName} ${
                comment.user.lastName
              } - ${formatDate(comment.added)}`}
              secondary={comment.comment}
            />
          </ListItem>
          <Divider />
        </React.Fragment>
      ))}
    </List>
  );
};

export default Comments;
