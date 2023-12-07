import { Search, ShoppingCartOutlined } from '@mui/icons-material'
import { Badge } from '@mui/material'
import React, {useState, useRef, useEffect} from 'react'
import { Link, useNavigate } from "react-router-dom";
import axios from 'axios';
import { useUser } from '../UserContext';

function NavBar() {

    const navigate = useNavigate();
    const [searchTerm, setSearchTerm] = useState('');
    const [searchResult, setSearchResult] = useState([]);
    const [searchError, setSearchError] = useState('');
    const [showDropdown, setShowDropdown] = useState(false);
    const dropdownRef = useRef(null);
    const inputRef = useRef(null);
    const rightDivStyle = "text-[14px] cursor-pointer ml-[25px]";
    const { user , logout } = useUser();

    const handleSearch = async () => {
        try {
          const response = await axios.get(`http://localhost:8084/event/get/event/byname?name=${searchTerm}`);
          if (response.data.code === '200') {
            setSearchResult(response.data.events);
            setSearchError('');
          } else {
            setSearchResult([]);
            setSearchError(response.data.message);
          }
        } catch (error) {
          console.error('Error fetching data:', error);
          setSearchResult([]);
          setSearchError('Error fetching data');
        }
      };


      // const navigateToEventDetail = (eventId) => {
      //   navigate(`/event-detail/${eventId}`, { replace: true });
      // };

      const navigateToEventDetail = (eventId) => {
        setShowDropdown(false);
        navigate(`/event-detail/${eventId}`, { replace: true });
      };


      const handleClick = (event) => {
        if (dropdownRef.current && !dropdownRef.current.contains(event.target) && inputRef.current && !inputRef.current.contains(event.target)) {
          setShowDropdown(false); 
        }
      };


      const handleSignOut = () => {

        logout();

        navigate('/login');
      };
      
      // const handleClick = (event) => {
      //   if (inputRef.current && !inputRef.current.contains(event.target)) {
      //     setShowDropdown(false);
      //   }
      
      //   if (dropdownRef.current && !dropdownRef.current.contains(event.target)) {
      //     setShowDropdown(false);
      //   }
      // };

      useEffect(() => {
        document.addEventListener('click', handleClick);
        return () => {
          document.removeEventListener('click', handleClick);
        };
      }, []);






  return (
    <div className='navbar h-[60px] shadow-md relative z-10'>
        <div className='wrapper pl-[20px] pr-[20px] pt-[10px] pb-[10px] flex justify-between items-center'>

            {/* Left div */}
            <div className="left flex flex-1 items-center">
                <div className="language cursor-pointer text-[16px]">En</div>
                <div className="searchInput flex border-[2px] border-solid border-lightgrey rounded-md items-center ml-[10px] p-[5px] focus-within:border-[#8a4af3] transition-all">
                <input
                    ref={inputRef}
                    className="input outline-none"
                    type="text"
                    value={searchTerm}
                    onChange={(e) => setSearchTerm(e.target.value)}
                    placeholder="Search events"
                    onClick={() => setShowDropdown(true)}
                />
                <Search className="" style={{ fontSize: '16px' }} onClick={handleSearch} />


                {/* Display search results in dropdown */}
                {searchError && <p>{searchError}</p>}
                {showDropdown && searchResult.length > 0 && (
                    <div className="absolute top-full mt-1 w-fit bg-white border border-gray-300 rounded-md">
                    {searchResult.map((event) => (
                        // <div key={event.eventId} className="p-2 hover:bg-gray-100 cursor-pointer" onClick={() => navigateToEventDetail(event.eventId)}>
                        // {event.name}
                        // </div>
                        <div key={event.eventId} className="p-2 hover:bg-gray-100 cursor-pointer" onClick={() => navigateToEventDetail(event.eventId)}>
                          {event.name}
                        </div>

                    ))}
                    </div>
                )}

                </div>
            </div>


            {/* Logo */}
            <div className='center flex-1 text-center'>
                <div className='logo font-bold text-lg'><Link to="/"> Events Center </Link></div>
            </div>

            {/* Right div */}
            <div className = 'right flex flex-1 items-center justify-end'>
                
                {/* <div className={rightDivStyle}> <Link to="/vendor-booths"> VendorBooths </Link> </div>
                <div className={rightDivStyle}> <Link to="/event-management"> EventManagement </Link> </div>
                <div className={rightDivStyle}> <Link to="/user-management"> UserManagement </Link> </div>
                <div className={rightDivStyle}> <Link to="/login">SignIn</Link> </div> */}
                
                {/* Common links for all roles */}
                {/* <div className={rightDivStyle}>
                  <Link to="/event-management"> EventManagement </Link>
                </div> */}

                {/* Conditional rendering based on user's role ADMIN */}
                {user && user.role === 'ADMIN' && (
                  <>
                    <div className={rightDivStyle}>
                      <Link to="/user-management"> UserManagement </Link>
                    </div>
                  </>
                )}
                {user && user.role === 'ADMIN' && (
                  <>
                    <div className={rightDivStyle}>
                      <Link to="/event-management"> EventManagement </Link>
                    </div>
                  </>
                )}
                {user && user.role === 'ADMIN' && (
                  <>
                    <div className={rightDivStyle}>
                      <Link to="/pending-users"> Pending Users </Link>
                    </div>
                  </>
                )}

                
                {/* Conditional rendering based on user's role USER */}
                {user && user.role === 'USER' && (
                  <>
                    <div className={rightDivStyle}>
                      <Link to="/ticket-details"> Tickets Purchased </Link>
                    </div>
                  </>
                )}

                {/* Conditional rendering based on user's role MANAGER */}
                {user && user.role === 'MANAGER' && (
                  <>
                    <div className={rightDivStyle}>
                      <Link to="/add-event"> Add Event </Link>
                    </div>
                  </>
                )}
                {user && user.role === 'MANAGER' && (
                  <>
                    <div className={rightDivStyle}>
                      <Link to="/booth-requests"> View Booth Requests </Link>
                    </div>
                  </>
                )}


                
                {/* Conditionally render sign-in or sign-out based on user's authentication status */}
                {user ? (
                  <div className={rightDivStyle} onClick={handleSignOut}>
                    Sign Out
                  </div>
                ) : (
                  <div className={rightDivStyle}>
                    <Link to="/login"> Sign In </Link>
                  </div>
                )}

                
                {!user && (
                  <div className={rightDivStyle}>
                    <Link to="/signup"> SignUp </Link>
                  </div>
                )}

                <div className={rightDivStyle}>
                <Link to="/cart">
                    <Badge badgeContent={1} color='primary'>
                        <ShoppingCartOutlined/>
                    </Badge>
                </Link>
                </div>
            </div>
        </div>

    </div>
  )
}

export default NavBar