import React from 'react';
import Product from './Product';
import { useState } from 'react';
import { useEffect } from 'react';
import EventService from '../Services/EventService'

const Products = () => {

    const [events, setEvents] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
 
          try {
            const response = await EventService.getEvents();
            // Check if response.data.events is an array or default to an empty array
            setEvents(Array.isArray(response.data.events) ? response.data.events : []);
          } catch (error) {
            console.log(error);
          }

        };
        fetchData();
      }, []);


  return( 
  
        <div className='p-5 flex flex-wrap'>
            {
                
                events.map((event, index)=>(
                    <Product
                    key={index}
                    item={{
                    eventId: event.eventId,
                    eventName: event.name,
                    price: event.price,
                    imageUrl: event.imageUrl
                    }}
                />
                ))
                
            }
        </div>

  );
};

export default Products;
