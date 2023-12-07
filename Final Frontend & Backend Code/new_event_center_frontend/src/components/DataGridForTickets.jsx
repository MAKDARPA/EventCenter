import React, { useEffect, useState } from 'react';
import UserService from '../Services/UserService';
import { useUser } from '../UserContext';
import Ticket from './Ticket';

function DataGridForTickets() {
  const [loading, setLoading] = useState(true);
  const [events, setEvents] = useState([]);

  const { user } = useUser();
  const userId = user.userId;

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      try {
        const response = await UserService.getTicketsDetails(userId);
        console.log(response);
        // Assuming response.data is an array of events
        setEvents(Array.isArray(response.data) ? response.data : []);
      } catch (error) {
        console.log(error);
      }
      setLoading(false);
    };

    fetchData();
  }, [userId]);

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
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Ticket Price
              </th>
            </tr>
          </thead>
          {!loading && (
            <tbody className="bg-white">
              {events.map((event) => (
                <Ticket
                  event={event}
                  key={event.eventId}
                />
              ))}
            </tbody>
          )}
        </table>
      </div>
    </div>
  );
}

export default DataGridForTickets;
