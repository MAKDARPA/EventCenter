import React from "react";

const PendingUser = ({ user, approveUser }) => {
  return (
    <tr key={user.userId}>
      <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-500">{user.userId}</div>
      </td>
      <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-500">{user.userName}</div>
      </td>
      <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-500">{user.role}</div>
      </td>
      <td className="text-right px-6 py-4 whitespace-nowrap font-medium text-sm">
        <a
          onClick={(e) => approveUser(e, user.userId)}
          className="text-indigo-600 hover:text-indigo-800 cursor-pointer"
        >
          Approve
        </a>
      </td>
    </tr>
  );
};

export default PendingUser;
