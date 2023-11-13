import React from "react";
import { useParams } from "react-router-dom";
import { useState, useEffect } from "react";
import NavBar from "../components/NavBar";
import Announce from "../components/Announce";
import Footer from "../components/Footer";
import EventService from "../Services/EventService";
import { useCart } from '../Services/CartContext';

function EventDetail() {

  const { eventId } = useParams();

  const { addToCart } = useCart();

  const [eventDetails, setEventDetails] = useState({});

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

  if (!eventDetails) {
    return <div>Loading...</div>;
  }

  return<div>
    <Announce />
    <NavBar />
    <div className="flex justify-center m-6 mobile:flex-col mobile:mt-4 mobile:p-3">
      <div className="flex-[1.1] flex items-center justify-center ">
          {eventDetails.imageBeans && eventDetails.imageBeans.length > 0 ? (
            <img src={eventDetails.imageBeans[4].url} alt={eventDetails.name} />
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
        <p className="location pr-[4rem] text-justify mt-4 mobile:pr-0">
          Type {eventDetails.classificationBean ? (
                      <>
                        <p>Segment: {eventDetails.classificationBean[0].segment.name}</p>
                        <p>Genre: {eventDetails.classificationBean[0].genre.name}</p>
                      </>
                    ) : (
                      <p>Classification data not available</p>
                    )}
        </p>
        <p className="location pr-[4rem] text-justify mt-4 mobile:pr-0">
          location: {eventDetails.embeddedBean && eventDetails.embeddedBean.venuesBeans ? (
                      <>
                        <p>Name: {eventDetails.embeddedBean.venuesBeans[0].name}</p>
                        <p>City: {eventDetails.embeddedBean.venuesBeans[0].city.name}</p>
                        <p>State: {eventDetails.embeddedBean.venuesBeans[0].state.name}</p>
                      </>
                    ) : (
                      <p>Venue data not available</p>
                    )}
        </p>
        <p className="date pr-[4rem] text-justify mt-4 mobile:pr-0">
          Date:{eventDetails.salesBean && eventDetails.salesBean.pobj ? (
                 <>
                  <p>Start Date: {eventDetails.salesBean.pobj.startDateTime}</p>
                  <p>End Date: {eventDetails.salesBean.pobj.endDateTime}</p>
                 </>
                ) : (
                    <p>Sales information not available</p>
                )}
        </p>
        <div className="flex flex-col place-self-start">
          <p className="mt-7 text-3xl">
            Price: <b>{eventDetails.price}</b>
          </p>

        </div>

        <button
        className="text-white bg-[#8a4af3] rounded-md shadow-md mt-[30px] p-3"
          onClick={() => {
            const item = {
              id: eventId,
              name: eventDetails.name,
              price: eventDetails.price,
            };
            addToCart(item);
          }}
        >
        Add to Cart
      </button>

        <button className="text-white bg-[#249149] rounded-md shadow-md mt-[30px] p-3">
          Request for Stall
        </button>
      </div>
    </div>
    <Footer />

  </div>;

}

    export default EventDetail;






