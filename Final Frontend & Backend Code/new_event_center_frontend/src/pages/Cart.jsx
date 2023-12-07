import React from 'react';
import { useNavigate } from 'react-router-dom'; // Import useNavigate
import NavBar from '../components/NavBar';
import Footer from '../components/Footer';
import { useCart } from '../Services/CartContext'; // Import useCart hook
import { useUser } from '../UserContext';
import UserService from '../Services/UserService';

const Cart = () => {
  const navigate = useNavigate(); // Initialize the navigate function
  const { cartItems , clearCart} = useCart(); // Access cart items from the context
  const { user } = useUser();

  // Calculate totals
  const subtotal = cartItems.reduce((total, item) => total + item.price, 0);
  const discount = 0; // You can implement discount logic here if needed
  const total = subtotal - discount;

  const handleCheckoutClick = async () => {
    // Check if the user is logged in before proceeding to checkout
    if (user) {
      const userId = user.userId;
      console.log(user);
      try {
        // Loop through cart items and call buyTicket for each item
        for (const item of cartItems) {
          await UserService.buyTicket(item.id, userId); // Pass eventId and userId
        }

        // Clear the cart after successful purchase
        clearCart();

        // Navigate to the ticket-success page
        navigate('/ticket-success');
      } catch (error) {
        console.error('Failed to buy tickets:', error.message);
      }
    } else {
      // If the user is not logged in, navigate to the login page
      navigate('/login');
    }
  };

  const handleContinueShoppingClick = () => {
    // Navigate to the home page when Continue Shopping is clicked
    navigate('/');
  };

  return (
    <div>
      <NavBar />
      <div className="p-3">
        <div className="flex justify-center text-5xl mt-5 mb-10">Cart</div>

        {/* Upper buttons div */}
        <div className="flex items-center justify-between mt-4 mobile:flex-col">
          <button
            className="btn bg-white text-[#8a4af3] border-2 border-[#8a4af3] mt-0"
            onClick={handleContinueShoppingClick} // Handle Continue Shopping button click
          >
            Continue Shopping
          </button>
          <button
            className="btn mt-0"
            onClick={handleCheckoutClick} // Handle Checkout Now button click
          >
            Checkout Now
          </button>
        </div>

        {/* Vertically center parent div */}
        <div className="flex flex-row mt-7 mobile:flex-col">
          {/* Products div */}
          <div className="flex flex-col flex-1">
            {cartItems.map((item) => (
              <div key={item.id} className="flex flex-col">
                {/* product div */}
                <div className="flex w-[100%] h-auto items-center mobile:flex-col">
                  <div className=" product flex pl-5 self-start">
                    <img
                      className="product_img w-[7rem]"
                      src={item.imageUrl} // Replace with the actual image URL
                      alt={item.name}
                    />

                    <div className="disc flex items-start justify-between h-auto flex-col ml-6">
                      <p>
                        <b className="mr-2">ID:</b> {item.id}
                      </p>
                      <p>
                        <b className="mr-2">Product:</b> {item.name}
                      </p>
                    </div>
                  </div>

                  {/* Price and Quantity Div */}
                  <div className="flex-auto flex flex-col justify-center items-center mobile:mt-7 mobile:mb-7">
                    <p className="flex items-center justify-center text-4xl mt-3">
                      <b>${item.price}</b>
                    </p>
                  </div>
                </div>

                <hr className="mb-7 mt-7 mobile:mt-0" />
              </div>
            ))}
          </div>
          {/* Summary div */}
          <div className="Summary flex-[0.4] flex flex-col items-center w-auto h-[40vh] border-2 border-[#8a4af3] rounded-md shadow-lg p-5 text-lg mobile:mb-6">
            <h1 className="text-[2rem]">SUMMARY</h1>
            <div className="SummaryItem flex justify-between mt-3 w-[100%]">
              <p>SubTotal:</p>
              <p>${subtotal}</p>
            </div>
            <div className="SummaryItem flex justify-between mt-3 w-[100%]">
              <p>Discount:</p>
              <p>${discount}</p>
            </div>
            <div className="SummaryItem text-3xl font-bold flex justify-between mt-3 w-[100%]">
              <p>Total:</p>
              <p>${total}</p>
            </div>
          </div>
        </div>
        <Footer />
      </div>
    </div>
  );
};

export default Cart;