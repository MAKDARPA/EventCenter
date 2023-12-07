import React, { useState } from 'react';
import NavBar from '../components/NavBar';
import Footer from '../components/Footer';
import LoginService from '../Services/LoginService';
import { useUser } from '../UserContext';
import { useNavigate } from 'react-router-dom';

const Login = ({ history }) => {
  const inputStyle =
    "border-[2px] border-silver rounded-lg outline-[#8a4af3] p-2 focus:border-[#8a4af3] ease-linear duration-200 ";

  const [userName, setUserName] = useState('');
  const [password, setPassword] = useState('');

  const navigate = useNavigate();
  
  const isFormValid = () => {
    return userName.trim() !== '' && password.trim() !== '';
  };

  // Use the `useUser` hook here to get the `login` function
  const { login } = useUser() || {};

  const handleLogin = () => {
    const credentials = {
      userName,
      password,
    };

    LoginService.authenticateUser(credentials)
      .then((response) => {
        const loginResponseDTO = response.data;

        if (loginResponseDTO.code === '200') {
          // Check if `login` function is defined before calling it
          if (login) {
            login({ userId: loginResponseDTO.userId, 
              role: loginResponseDTO.role, });
            
          }

          navigate(`/`);
        } else {
          alert('Login failed: ' + loginResponseDTO.message);
        }
      })
      .catch((error) => {
        console.error(error);
        alert('An error occurred during login. Please try again.');
      });
  };


  return (
    <div>
      <NavBar />
      <div className="flex justify-center w-[100%] h-[100vh] ">
        <div className="flex flex-col absolute top-[30%] bg-white shadow-lg border-silver border-[2px] rounded-lg p-5 w-[40%] mobile:w-[90%]">
          <h1 className="text-2xl">Log in</h1>

          <div className="flex mt-7">
            <input
              className={inputStyle + ` mt-2 w-[100%]`}
              name="userName"
              type="userName"
              placeholder="userName"
              onChange={(e) => setUserName(e.target.value)}
              value={userName}
              required
            />
          </div>

          <div className="flex mt-7">
            <input
              className={inputStyle + ` w-[100%]`}
              name="password"
              type="password"
              placeholder="Password"
              onChange={(e) => setPassword(e.target.value)}
              value={password}
              required
            />
          </div>

          <input
            type="button"
            className={`mt-5 flex justify-center bg-[#8a4af3] text-white font-medium rounded-md p-2 hover:bg-white hover:text-[#8a4af3] hover:scale-[1.0.5] hover:border-[2px] hover:shadow-md hover:border-[#8a4af3] ease-linear duration-200`}
            value="Log in"
            disabled={!isFormValid()}
            onClick={handleLogin}
          />
        </div>
      </div>
      <Footer />
    </div>
  );
};

export default Login;
