import { CartProvider } from './Services/CartContext';
import { UserProvider } from './UserContext';
import Home from './pages/Home';

function App() {
  return (
    <div className="App">
      <UserProvider>
        <CartProvider>
        <Home />
        </CartProvider>
      </UserProvider>
    </div>
  );
}

export default App;
