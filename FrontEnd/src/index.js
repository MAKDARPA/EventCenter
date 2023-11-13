import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import EventManagementPage from "./pages/EventManagementPage"
import UserManagementPage from './pages/UserManagementPage';
import EventDetail from './pages/EventDetail';
import Cart from './pages/Cart';
import { CartProvider } from './Services/CartContext';
import Login from './pages/Login';
import VendorBooths from './pages/VendorBooths';
import TicketSuccess from './pages/TicketSuccess';


const router = createBrowserRouter([
  {
    path: "/",
    element: <App/>,
  },
  {
    path: "event-management",
    element: <EventManagementPage/>,
  },
  {
    path: "user-management",
    element: <UserManagementPage/>,
  },
  {
    path: "event-detail/:eventId",
    element: <EventDetail/>,
  },
  {
    path: "cart",
    element: <Cart/>,
  },
  {
    path: "login",
    element: <Login/>,
  },
  {
    path: "vendor-booths",
    element: <VendorBooths/>,
  },
  {
    path: "ticket-success",
    element: <TicketSuccess/>,
  }

]);


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <CartProvider>
      <RouterProvider router={router} />
    </CartProvider>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals

