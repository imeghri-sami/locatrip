import React from "react";
import Header from "./Navbar";
import Main from "./Main";
import { Route, Routes } from "react-router-dom";
import Properties from "../pages/Properties";
import { Box } from "@mui/material";
import Property from "../pages/Property";

const Master = ({ children }) => {
  return (
    <>
      <Header />
      <Box my={12} width={"100%"}>
        {children}
      </Box>
    </>
  );
};

export default Master;
