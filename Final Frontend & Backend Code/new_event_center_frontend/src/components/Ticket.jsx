import React from "react";


const Ticket = ({ event }) => {


  return (
    <tr key={event.id}>
      <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-500">{event.eventId}</div>
      </td>
      <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-500">{event.name}</div>
      </td>
      <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-500">{event.price}</div>
      </td>
    </tr>
  );
};

export default Ticket;