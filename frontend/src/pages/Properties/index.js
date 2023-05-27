import { CircularProgress } from "@mui/material";
import { useState } from "react";

export const Properties = function () {
  // Display the list of properties
  const [properties, setProperties] = useState([]);
  const [loading, setLoading] = useState(true);

  return loading ? <CircularProgress /> : properties.map((p) => p.name);
};
