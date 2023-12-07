import React, { createContext, useContext, useState } from 'react';

const CartContext = createContext();

export function useCart() {
  return useContext(CartContext);
}

export function CartProvider({ children }) {
  const [cartItems, setCartItems] = useState([]);

  // const addToCart = (item) => {
  //   // Assuming `item` has an `eventId` property
  //   if (item && item.eventId) {
  //     setCartItems([...cartItems, item]);
  //   } else {
  //     console.error('Item is missing eventId property:', item);
  //   }
  // };

  const addToCart = (item) => {
    // Log the item object to the console
    console.log('Item to add to cart:', item);
  
    // Assuming `item` has an `eventId` property
    if (item && item.eventId) {
      setCartItems([...cartItems, item]);
    } else {
      console.error('Item is missing eventId property:', item);
    }
  };

  const removeFromCart = (itemId) => {
    const updatedCart = cartItems.filter((item) => item.id !== itemId);
    setCartItems(updatedCart);
  };

  const clearCart = () => {
    setCartItems([]);
  };

  return (
    <CartContext.Provider
      value={{ cartItems, addToCart, removeFromCart, clearCart }}
    >
      {children}
    </CartContext.Provider>
  );
}
