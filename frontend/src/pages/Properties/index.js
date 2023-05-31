import React, { useEffect, useState } from "react";
import { CircularProgress, Stack } from "@mui/material";
import axios from "axios";
import PropertyCard from "../../components/PropertyCard";

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
    <>
      {loading ? (
        <div className="flex justify-center">
          <CircularProgress />
        </div>
      ) : (
        <Stack direction="row" justifyContent="center" flexWrap="wrap">
          {properties.map((rental) => (
            <PropertyCard
              key={rental.id}
              id={rental.id}
              title={rental.name}
              address={rental.address}
              image={rental.images[0]}
              price={rental.price}
              description={rental.description}
              endDate={rental.availabilityEndDate}
              startDate={rental.availabilityStartDate}
            />
          ))}
        </Stack>
      )}
    </>
  );
}

export default Properties;
