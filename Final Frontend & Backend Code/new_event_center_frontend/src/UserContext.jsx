import { createContext, useContext, useState } from 'react';


const UserContext = createContext();

export const UserProvider = ({ children }) => {
    const [user, setUser] = useState(() => {
      // Retrieve user from storage if available
      const storedUser = localStorage.getItem('user');
      return storedUser ? JSON.parse(storedUser) : null;
    });
  
    const login = (userData) => {
      // Store user in localStorage
      localStorage.setItem('user', JSON.stringify(userData));
      setUser(userData);
    };

    const logout = () => {
        // Remove user from localStorage
        localStorage.removeItem('user');
        setUser(null);
      };

  return (
    <UserContext.Provider value={{ user, login, logout }}>
      {children}
    </UserContext.Provider>
  );
};

export const useUser = () => {
  return useContext(UserContext);
};


