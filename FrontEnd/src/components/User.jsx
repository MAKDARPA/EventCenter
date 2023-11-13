import React from "react";


const User = ({ user, deleteUser }) => {


  return (
    <tr key={user.id}>
      <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-500">{user.userId}</div>
      </td>
      <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-500">{user.username}</div>
      </td>
      <td className="text-right px-6 py-4 whitespace-nowrap font-medium text-sm">
        {/* <a
          onClick={(e, id) => deleteEvent(e, user.id)}
          className="text-indigo-600 hover:text-indigo-800 hover:cursor-pointer">
          Delete
        </a> */}
      </td>
    </tr>
  );
};

export default User;