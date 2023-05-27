import React, { useEffect, useState } from "react";
import Rental from "../../components/Rental";
import { CircularProgress } from "@mui/material";
import axios from "axios";

function Properties() {
  const [properties, setProperties] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    // Fetch properties from API
    axios
      .get("/properties")
      .then((data) => {
        setProperties(data.data);
        setLoading(false);
        console.log(data.data);
      })
      .catch((err) => console.log(err));
  }, []);

  return (
    <div className="pt-3 sm:pt-5">
      <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 xl:grid-cols-7 gap-4">
        {loading ? (
          <div className="flex justify-center">
            <CircularProgress />
          </div>
        ) : (
          properties.map((rental) => (
            <Rental
              title={rental.name}
              image={
                "http://localhost:8080/locatrip-1.0-SNAPSHOT/api/v1/" +
                rental.images[0].imagePath
              }
              price={rental.price}
              description={rental.description}
              avaDateEnd={rental.availabilityEndDate}
              avaDateStart={rental.availabilityStartDate}
            />
          ))
        )}
      </div>
    </div>
  );
}

export default Properties;
