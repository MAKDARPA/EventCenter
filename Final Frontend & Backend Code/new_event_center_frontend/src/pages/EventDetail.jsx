import React from "react";
import { useParams } from "react-router-dom";
import { useState, useEffect } from "react";
import NavBar from "../components/NavBar";
import Announce from "../components/Announce";
import Footer from "../components/Footer";
import EventService from "../Services/EventService";
import VendorService from "../Services/VendorService";
import { useCart } from '../Services/CartContext';
import { useUser } from '../UserContext';
import UserService from "../Services/UserService";

function EventDetail() {

  const { eventId } = useParams();
  const { addToCart } = useCart();

  const { user } = useUser();
  const userId = user?.userId;

  const [eventDetails, setEventDetails] = useState({});
  const [addToCartMessage, setAddToCartMessage] = useState("");
  const [stallRequestMessage, setStallRequestMessage] = useState("");

  useEffect(() => {
    const fetchEventDetails = async () => {
      try {
        const response = await EventService.getEventById(eventId);
        if (response.status >= 400) {
          throw new Error(`Failed to fetch event details: ${response.status} ${response.statusText}`);
        }
        setEventDetails(response.data.eventBean);
      } catch (error) {
        console.error(error.message);
        // Handle the error gracefully, such as displaying an error message to the user.
      }
    };
    fetchEventDetails();
  }, [eventId]);

  const handleStallRequest = async () => {
    try {

      if (!user) {
        setStallRequestMessage("Please log in to request for Stall.");
        return;
      }

      // Check user role before allowing the stall request
      if (user.role === 'MANAGER' || user.role === 'ADMIN') {
        setStallRequestMessage("MANAGER and ADMIN roles are not allowed to request a stall.");
        return;
      }
  
      // If the user has a different role, proceed with the stall request
      await UserService.requestForBooth(eventId, userId);
      setStallRequestMessage("Request Sent");
    } catch (error) {
      console.error(`Failed to submit stall request: ${error.message}`);
    }
  };
  

  const handleAddToCart = () => {
    
    if (!user) {
      setAddToCartMessage("Please log in to add items to the cart.");
      return;
    }

    if (user.role === 'MANAGER' || user.role === 'ADMIN') {
      setAddToCartMessage("MANAGER and ADMIN roles are not allowed to add to cart .");
      return;
    }
    // Check if eventDetails and eventId are present before adding to cart
    if (eventDetails && eventId) {
      const item = {
        id: parseInt(eventId),
        eventId: parseInt(eventId),
        name: eventDetails.name,
        price: eventDetails.price,
      };
      addToCart(item);
      setAddToCartMessage("Item added to cart");
    } else {
      console.error("Event details or eventId not available.");
    }
  };

  if (!eventDetails) {
    return <div>Loading...</div>;
  }

  return<div>
    <Announce />
    <NavBar />
    <div className="flex justify-center m-6 mobile:flex-col mobile:mt-4 mobile:p-3">
      <div className="flex-[1.1] flex items-center justify-center ">
          {eventDetails.imageUrl && eventDetails.imageUrl.length > 0 ? (
            <img src={eventDetails.imageUrl} alt={eventDetails.name} />
          ) : (
            <p>Image not available</p>
          )}
      </div>
      <div className="flex-[1] flex flex-col items-start ml-10 justify-items-center mt-5 mobile:items-center">
        <h1 className="title text-[30px] mobile:text-[0px]">
          {eventDetails.name}
        </h1>
        <p className="discription pr-[4rem] text-justify mt-4 mobile:pr-0">
          {eventDetails.info || 'No description available'}
        </p>

        <div className="flex flex-col place-self-start">
          <p className="mt-7 text-3xl">
            Price: <b>{eventDetails.price}</b>
          </p>
        </div>

        <button
          className="text-white bg-[#8a4af3] rounded-md shadow-md mt-[30px] p-3"
          onClick={handleAddToCart}
        >
          Add to Cart
        </button>
        <div>{addToCartMessage}</div>
        <button
          className="text-white bg-[#249149] rounded-md shadow-md mt-[30px] p-3"
          onClick={handleStallRequest}
        >
          Request for Stall
        </button>
        <div>{stallRequestMessage}</div>
      </div>
    </div>
    <Footer />

  </div>;

}

    export default EventDetail;






