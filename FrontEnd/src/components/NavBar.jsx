import { Search, ShoppingCartOutlined } from '@mui/icons-material'
import { Badge } from '@mui/material'
import React, {useState, useRef, useEffect} from 'react'
import { Link, useNavigate } from "react-router-dom";
import axios from 'axios';

function NavBar() {

    const navigate = useNavigate();
    const [searchTerm, setSearchTerm] = useState('');
    const [searchResult, setSearchResult] = useState([]);
    const [searchError, setSearchError] = useState('');
    const [showDropdown, setShowDropdown] = useState(false);
    const dropdownRef = useRef(null);
    const inputRef = useRef(null);
    const rightDivStyle = "text-[14px] cursor-pointer ml-[25px]";


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

      const navigateToEventDetail = (eventId) => {
        navigate(`event-detail/${eventId}`);
      };

      const handleClick = (event) => {
        if (dropdownRef.current && !dropdownRef.current.contains(event.target) && inputRef.current && !inputRef.current.contains(event.target)) {
          setShowDropdown(false); 
        }
      };
    
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
                
                <div className={rightDivStyle}> <Link to="/vendor-booths"> VendorBooths </Link> </div>
                <div className={rightDivStyle}> <Link to="/event-management"> EventManagement </Link> </div>
                <div className={rightDivStyle}> <Link to="/user-management"> UserManagement </Link> </div>
                <div className={rightDivStyle}> <Link to="/login">SignIn</Link> </div>
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