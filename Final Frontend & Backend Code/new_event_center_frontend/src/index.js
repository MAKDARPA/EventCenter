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
import { UserProvider } from './UserContext';
import TicketDetails from './pages/TicketDetails';
import EventForm from './pages/EventForm';
import BoothRequestManagement from './pages/BoothRequestManagement';
import UserSignUp from './pages/UserSignUp';
import PendingUserManagementPage from './pages/PendingUserManagementPage';


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
    path: "ticket-details",
    element: <TicketDetails/>,
  },
  {
    path: "booth-requests",
    element: <BoothRequestManagement/>,
  },
  {
    path: "pending-users",
    element: <PendingUserManagementPage/>,
  },
  {
    path: "signup",
    element: <UserSignUp/>,
  },
  {
    path: "add-event",
    element: <EventForm/>,
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
    <UserProvider>
      <CartProvider>
        <RouterProvider router={router} />
      </CartProvider>
    </UserProvider>
  </React.StrictMode>
);
