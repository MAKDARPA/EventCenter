import { EmailOutlined, Facebook, Instagram, LocalPhoneOutlined, LocationOnOutlined, Phone, Pinterest, Twitter } from "@mui/icons-material";
import React from "react";

const Footer = () => {
    const socialStyle = 'm-3 rounded-full cursor-pointer p-2 text-white';
  return (

    <div className="flex items-center justify-around p-2 mt-10 mobile:flex-col mobile:items-start bg-black">
      <div className="flex-1 flex flex-col flex-wrap p-2 text-white">
        <h1 className="text-[24px]">EVENTS CENTER</h1>
        <p className="text-[12px]">
          Effortless Event Discovery
          Simplifying Your Search, 
          Amplifying Your Experience
        </p>
        <div className="flex items-center justify-center mt-3 self-start">
          <div className={socialStyle + ` bg-blue-700`}>
            <Facebook />
          </div>
          <div className={socialStyle + ` bg-orange-500`}>
            <Instagram />
          </div>
          <div className={socialStyle + ` bg-sky-400`}>
            <Twitter />
          </div>
          <div className={socialStyle + ` bg-red-600`}>
            <Pinterest/>
          </div>
        </div>
      </div>


      <div className="flex-1 flex flex-col p-2">
        <div className="flex m-3">
            <LocationOnOutlined className="text-[#b73232]"/>
            <p className='pl-3 text-white'>State of North Carolina</p>
        </div>
        <div className="flex m-3">
            <LocalPhoneOutlined className="text-[#b73232]"/>
            <p className='pl-3 text-white'>+1 336-905-3454</p>
        </div>
        <div className="flex m-3">
            <EmailOutlined className="text-[#b73232]"/>
            <p className='pl-3 text-white'>info@eventscenter.com</p>
        </div>
      </div>
    </div>
  );
};

export default Footer;
