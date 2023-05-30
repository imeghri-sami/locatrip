import React from "react";
import { Route, Routes } from "react-router-dom";
import Properties from "../pages/Properties";
import { Box } from "@mui/material";
import Property from "../pages/Property";

const Main = () => {
  return (
    <Box my={12} width={"100%"}>
      <Routes>
        <Route exact path="/properties/:id" element={<Property />} />
      </Routes>
    </Box>
  );
};

export default Main;
