import React from 'react'
import { BsTwitter,BsInstagram,BsFacebook } from 'react-icons/bs';

const Footer = () => {
    const icons = [<BsTwitter/>,<BsInstagram/>,<BsFacebook/>];
  return ( <div className="bg-white border-t-2 shadow-md  shadow-gray-300 sticky bottom-0 h-20 w-full flex items-center justify-center gap-6">
  {icons.map((icon) => (
    <div className="text-[30px] text-gray-600 hover:text-black duration-100 ease-out ">
      {icon}
    </div>
  ))}
</div>


  );
};

export default Footer;