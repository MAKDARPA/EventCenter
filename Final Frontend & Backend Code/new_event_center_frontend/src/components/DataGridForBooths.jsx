import React, { useEffect, useState } from 'react';
import UserService from '../Services/UserService'; 
import { useUser } from '../UserContext';

function DataGridForBooths() {
  const [loading, setLoading] = useState(true);
  const [events, setEvents] = useState([]);

  const { user } = useUser();
  const userId = user.userId;

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      try {
        const response = await UserService.getBoothRequests(userId);
        setEvents(Array.isArray(response.data) ? response.data : []);
        console.log('Response Data:', response.data);

      } catch (error) {
        console.log(error);
      }
      setLoading(false);
    };
    fetchData();
  }, []);


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
                UserName
              </th>
            </tr>
          </thead>
          {!loading && (
            <tbody className="bg-white">
              {events.map((event) => (
                <tr key={event.eventId}>
                  <td className="py-3 px-6">{event.eventId}</td>
                  <td className="py-3 px-6">{event.name}</td>
                  <td className="py-3 px-6">
                    {event.boothRequestBy && event.boothRequestBy.length > 0 ? (
                      event.boothRequestBy.map((user) => (
                        <div key={user.userId}>{user.userName}</div>
                      ))
                    ) : (
                      <div>No user data available</div>
                    )}
                    
                  </td>
                </tr>
              ))}
            </tbody>
          )}
        </table>
      </div>
    </div>
  );
}

export default DataGridForBooths;
