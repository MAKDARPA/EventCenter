import React, { useState } from 'react';
import UserService from '../Services/UserService';
import NavBar from '../components/NavBar';
import Footer from '../components/Footer';

const UserSignUp = () => {
  const [formData, setFormData] = useState({
    userName: '',
    email: '',
    password: '',
  });
  const [isPending, setIsPending] = useState(false);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleSignup = async (e) => {
    e.preventDefault();

    try {
      const response = await UserService.signup(formData);

      if (response.data.code === '200') {
        // Account is in a pending state
        setIsPending(true);
      } else {
        // Handle other cases or redirect to login page
        console.log('User registered successfully:', response);
      }
    } catch (error) {
      console.error('Error during user registration:', error);
    }
  };

  const closePopup = () => {
    setIsPending(false);
    // Redirect to login page or perform other actions
  };

  return (
    <div>
      <NavBar />
      <div className="flex justify-center items-center h-screen bg-gray-100">
        <div className="bg-white shadow-lg rounded-md p-8 max-w-md w-full">
          <h2 className="text-2xl font-semibold mb-4">User Signup</h2>
          <form onSubmit={handleSignup}>
            <div className="mb-4">
              <label htmlFor="userName" className="block text-gray-600 text-sm font-medium mb-2">
                Username:
              </label>
              <input
                type="text"
                id="userName"
                name="userName"
                value={formData.userName}
                onChange={handleChange}
                className="w-full border-2 border-gray-300 rounded-md py-2 px-3 focus:outline-none focus:border-[#8a4af3]"
              />
            </div>
            <div className="mb-4">
              <label htmlFor="email" className="block text-gray-600 text-sm font-medium mb-2">
                Email:
              </label>
              <input
                type="email"
                id="email"
                name="email"
                value={formData.email}
                onChange={handleChange}
                className="w-full border-2 border-gray-300 rounded-md py-2 px-3 focus:outline-none focus:border-[#8a4af3]"
              />
            </div>
            <div className="mb-4">
              <label htmlFor="password" className="block text-gray-600 text-sm font-medium mb-2">
                Password:
              </label>
              <input
                type="password"
                id="password"
                name="password"
                value={formData.password}
                onChange={handleChange}
                className="w-full border-2 border-gray-300 rounded-md py-2 px-3 focus:outline-none focus:border-[#8a4af3]"
              />
            </div>
            <button
              type="submit"
              className="bg-[#8a4af3] text-white rounded-md p-2 hover:bg-white hover:text-[#8a4af3] hover:shadow-md transition duration-200"
              disabled={!formData.userName || !formData.email || !formData.password}
            >
              Sign Up
            </button>
          </form>
        </div>
      </div>

      {isPending && (
        <div className="fixed inset-0 flex items-center justify-center bg-black bg-opacity-50">
          <div className="bg-white p-8 rounded-md text-center">
            <p>Your account is in a pending state. Please wait for approval.</p>
            <button
              className="mt-4 bg-[#8a4af3] text-white rounded-md p-2 hover:bg-white hover:text-[#8a4af3] hover:shadow-md transition duration-200"
              onClick={closePopup}
            >
              OK
            </button>
          </div>
        </div>
      )}

      <Footer />
    </div>
  );
};

export default UserSignUp;
