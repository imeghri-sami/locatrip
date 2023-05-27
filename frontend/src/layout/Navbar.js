import React from "react";
import logo from "../assets/loogo.jpg";
//import Login from "./Login";
import ReactDOM from "react-dom";
import { BiWorld, BiUser } from "react-icons/bi";
import { FiSearch } from "react-icons/fi";
import { useHistory } from "react-router-dom";
import { Link } from "react-router-dom";

function Navbar() {
  const history = useHistory();
  const authenticated = false;

  return (
    <div id="navbar">
      <div>
        <div className="flex justify-between items-center my-6 sm:mx-6 lg:mx-12 md:mx-10">
          {/*Left */}
          <div className="bg-red-400 h-20 flex">
            <img src={logo} className="object-cover -my-5 " />
          </div>
          {/*MIDDLE */}
          <div className="flex relative justify-center items-center shadow-sm shadow-gray-400 border rounded-full">
            <input
              type="search"
              placeholder=""
              className="py-2.5 w-[20rem] rounded-full outline-0"
            />
            <div className="flex justify-between absolute w-full pr-16 p1-6 font-semibold text-gray-600">
              <button className=" w-full">Place</button>
              <button className="border-1 border-x px-6 ">Time</button>
              <button className=" w-full text-gray-600/60 p1-2">
                Group Size
              </button>
            </div>
            <div className="flex bg-[#FACC2E] p-2 rounded-full mr-2">
              <FiSearch className="text-white" />
            </div>
          </div>
          {/*Right */}
          <div className="flex  items-center pr-3 font-semibold text-gray-600">
            <p className="text-[17px]">Rent House</p>

            <div className="flex items-center mx-4 gap-1">
              <BiWorld className="mx-4" />
              <div className="">EN</div>
            </div>
            {authenticated ? (
              <button
                className="flex items-center  border px-4 py-2 rounded-full gap-3 bg-[#FACC2E]
                text-white font-bold shadow-lg
                 shadow-gray-300 hover:bg-[#FACC2E] duration-100 ease-out"
                onClick={() => history.push("/")}
              >
                <p>Sign out</p>
                <BiUser className="text-[19px]" />
              </button>
            ) : (
              <button
                className="flex items-center  border px-4 py-2 rounded-full gap-3 bg-[#FACC2E]
                 text-white font-bold shadow-lg
                  shadow-gray-300 hover:bg-[#FACC2E] duration-100 ease-out"
              >
                <Link to="login">
                  {" "}
                  <p>Sign in</p>
                </Link>
                <BiUser className="text-[19px]" />
              </button>
            )}
          </div>
        </div>
      </div>
    </div>
  );
}

export default Navbar;
