import React from "react";

const Filter = ({ icon, title }) => {
  return (
    <div
      className="flex items-center text-white
     bg-[#FACC2E] hover:bg-white hover:text-[#FACC2E]
     duration-200 ease-out gap-2 py-1 px-7 rounded-full "
    >
      {icon}
      {title}
    </div>
  );
};
export default Filter;
