import React from 'react';
import NavBar from '../components/NavBar';

function TicketSuccess() {
  return<div> 
    <NavBar/>
    <div className="bg-blue-800 p-4 rounded-md shadow-md text-white">
      Ticket purchased Successfully
    </div>
    </div>
}

export default TicketSuccess;