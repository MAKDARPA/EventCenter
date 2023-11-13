import React, {useEffect, useState} from 'react';
import Event from './Event';
import EventService from '../Services/EventService';

function DataGridForBooths() {

  const [loading, setLoading] = useState(true)
  const [events, setEvents] = useState([])


  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      try {
        const response = await EventService.getEvents();
        // Check if response.data.events is an array or default to an empty array
        setEvents(Array.isArray(response.data.events) ? response.data.events : []);
      } catch (error) {
        console.log(error);
      }
      setLoading(false);
    };
    fetchData();
  }, []);

  const deleteEvent = (e, eventId) => {
    e.preventDefault();
    EventService.deleteEvent(eventId).then((res) => {
      if (events) {
        setEvents((prevElement) => {
          return prevElement.filter((event) => event.eventId !== eventId);
        });
      }
    });
  };

  return (
    <div className="container mx-auto my-8">
      <div className="flex shadow border-b">
        <table className="min-w-full">
          <thead className="bg-gray-50">
            <tr>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Event Id
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Event Name
              </th>
              <th className="text-right font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Actions
              </th>
            </tr>
          </thead>
          {!loading && (
            <tbody className="bg-white">
              {events.map((event) => (
                <Event event={event}
                  deleteEvent={deleteEvent}
                  key={event.id}></Event>
              ))}
            </tbody>
          )}
        </table>
      </div>
    </div>
  );
};


export default DataGridForBooths