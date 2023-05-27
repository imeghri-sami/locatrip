import React from "react";
import { ImKey } from "react-icons/im";
import { RiAliensFill } from "react-icons/ri";
import { AiFillAmazonSquare, AiFillAlert } from "react-icons/ai";
import { BsFillTreeFill } from "react-icons/bs";
import Filter from "../components/Filter";

const Filters = () => {
  const sorting = [
    { title: "Boat", icon: <AiFillAlert /> },
    { title: "New", icon: <AiFillAmazonSquare /> },
    { title: "Unique", icon: <RiAliensFill /> },
    { title: "Private", icon: <ImKey /> },
    { title: "Public", icon: <BsFillTreeFill /> },
  ];
  return (
    <div className="sm:mx-6 lg:mx-12 md:mx-10">
      <div className="flex justify-center gap-4 mt-4 mx-4">
        {sorting.map((obg) => (
          <Filter title={obg.title} icon={obg.icon} />
        ))}
      </div>
    </div>
  );
};

export default Filters;
