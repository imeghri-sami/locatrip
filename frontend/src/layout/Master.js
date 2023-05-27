import Navbar from "./Navbar";
import Filters from "./Filters";
import Footer from "./Footer";
import Properties from "../pages/Properties";

export const Master = function () {
  return (
    <div>
      {/**Navbar */}
      <Navbar />
      {/**Filters */}
      <div className="sm:mx-6 md:mx-10 lg:mx-12 px-3">
        <Filters />
        {/* Rentals */}
        <Properties />
      </div>
      {/**Footer */}
      <Footer />
    </div>
  );
};
