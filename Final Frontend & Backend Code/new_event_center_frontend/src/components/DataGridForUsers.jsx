import React, {useEffect, useState} from 'react';
import UserService from '../Services/UserService';
import User from './User';

function DataGridForUsers() {

  const [loading, setLoading] = useState(true)
  const [users, setUsers] = useState([])


  useEffect(() => {

      const fetchData = async () => {
        setLoading(true);
        try {
          const response = await UserService.getUsers();
          setUsers(response.data);
        } catch (error) {
          console.log(error);
        }
        setLoading(false);
      };
    fetchData();
  }, []);

  const deleteUser = (e, userId) => {
    e.preventDefault();
    UserService.deleteUser(userId).then((res) => {
      if (users) {
        setUsers((prevElement) => {
          return prevElement.filter((user) => user.userId !== userId);
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
                <User user={user}
                deleteUser={deleteUser}
                key={user.id}         
                ></User>
              ))}
            </tbody>
          )}
        </table>
      </div>
    </div>
  );
};


export default DataGridForUsers