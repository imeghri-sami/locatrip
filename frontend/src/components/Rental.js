import { Typography } from "@mui/material";
import React from "react";
import { BsFillTreeFill } from "react-icons/bs";

const Rental = ({
  id,
  title,
  image,
  price,
  description,
  avaDateStart,
  avaDateEnd,
}) => {
  function formatDate(timestamp) {
    const date = new Date(timestamp);

    const options = {
      weekday: "short",
      year: "numeric",
      month: "long",
      day: "numeric",
    };

    return date.toLocaleDateString("en-US", options);
  }

  return (
    <div className="">
      <div className="relative">
        <div className="grad absolute w-full h-full rou-b-[1.3rem]"></div>
        <div className="flex">
          {/*background*/}
          <img
            src={image}
            alt=""
            className="object-cover
                    rounded-[1.3rem] sm:max-h-[18.5rem] md:h-[15rem] w-full"
          />
          {/*title */}
          <div
            className="absolute text-white 
                        font-bold bottom-6 left-6 text-[22px] flex 
                        items-center gap-2"
          >
            {title}
            <p className="text-[18px] text-slate-200 mr-8">${price}</p>
          </div>
        </div>
      </div>

      {/*description*/}
      <div className="pt-3 flex justify-between items-start">
        {/*Left*/}
        <div className="">
          <Typography className="max-w-[17rem] font-semibold text-[17px]">
            {description.length > 20
              ? description.substring(0, 20) + "..."
              : description}
          </Typography>
          <p className="max-w-[17rem] text-[16px] text-gray-500 -mt-1">
            {formatDate(avaDateStart)}
            <br />
            {formatDate(avaDateEnd)}
          </p>
          <p className="max-w-[17rem] text-[16px] --mt-1"> ${price} </p>
        </div>
        {/*Right*/}
        <div className="flex items-center space-x-1">
          <BsFillTreeFill />
          <p className="text-[15px]">5.0</p>
        </div>
      </div>
    </div>
  );
};

export default Rental;
