import React, { useEffect, useState } from 'react';
import UserService from '../Services/UserService';
import PendingUser from './PendingUser';

function DataGridForPendingUsers() {
  const [loading, setLoading] = useState(true);
  const [users, setUsers] = useState([]);

  const fetchData = async () => {
    setLoading(true);
    try {
      const response = await UserService.getPendingUsers();
      setUsers(Array.isArray(response.data) ? response.data : []);
    } catch (error) {
      console.log(error);
    }
    setLoading(false);
  };

  useEffect(() => {
    fetchData();
  }, []); // Fetch data on component mount

  const approveUser = async (e, userId) => {
    e.preventDefault();
    try {
      // Call the UserService.approveUser method to handle user approval
      const response = await UserService.approveUser(userId);
      // Handle success or update the UI accordingly
      console.log('User approved successfully:', response);

      // Fetch data again after approval to refresh the table
      fetchData();
    } catch (error) {
      console.error('Error during user approval:', error);
    }
  };

  return (
    <div className="container mx-auto my-8">
      <div className="flex shadow border-b">
        <table className="min-w-full">
          <thead className="bg-gray-50">
            <tr>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                User Id
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                User Name
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Role
              </th>
              <th className="text-right font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Actions
              </th>
            </tr>
          </thead>
          {!loading && (
            <tbody className="bg-white">
              {users.map((user) => (
                <PendingUser
                  key={user.userId}
                  user={user}
                  approveUser={approveUser}
                />
              ))}
            </tbody>
          )}
        </table>
      </div>
    </div>
  );
}

export default DataGridForPendingUsers;
