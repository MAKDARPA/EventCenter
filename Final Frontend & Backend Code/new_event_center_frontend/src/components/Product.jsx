import {
  ShoppingCartOutlined,
} from "@mui/icons-material";
import { useNavigate } from 'react-router-dom';
import React from "react";

const iconStyle = 'h-[30px] w-[30px] rounded-full bg-white flex items-center justify-center m-3 hover:bg-[#894af3] hover:text-white hover:scale-[1.1] ease-in duration-100 cursor-pointer'

const Product = ({ item }) => {

  const navigate = useNavigate();

  const handleViewDetails = () => {
    const eventId = item.eventId;
    navigate(`event-detail/${eventId}`);
  };

  return (
    <div className="flex-1 min-w-[280px] min-h-[350px] m-2 overflow-hidden rounded-md shadow-lg">
      <img src={item.imageUrl} alt={item.eventName} />
      <h3 className="text-center text-xl font-semibold mt-2">{item.eventName}</h3>
      <h2 className="text-center text-gray-600 font-bold pl-5 pr-5">Price: {item.price}</h2>
      <div className="flex justify-between m-5">
        <div className={iconStyle}>
          <ShoppingCartOutlined />
        </div>
        <button className="bg-blue-500 hover:bg-blue-600 text-white m-2 px-4 py-2 rounded" onClick={handleViewDetails}>
          View Details
        </button>
      </div>
    </div>
  );
};

export default Product;
