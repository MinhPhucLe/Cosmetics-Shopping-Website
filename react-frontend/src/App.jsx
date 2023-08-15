import { Routes, Route } from "react-router-dom";
// Home Pages
import Home from "./pages/Home/Home";
import HomeLayout from "./pages/Home/Layout";
import AllProducts from "./pages/Home/AllProducts";
import ProductDetail from "./pages/Home/ProductDetail";
// Login pages
import Login from "./pages/LoginForm/Login";
import LoginLayout from "./pages/LoginForm/Layout";
import Register from "./pages/LoginForm/Register";
import ForgotPassword from "./pages/LoginForm/ForgotPassword";
import ResetPassword from "./pages/LoginForm/ResetPassword";
// User pages
import UserLayout from "./pages/User/Layout";
import MyProfile from "./pages/User/MyProfile";
import Settings from "./pages/User/Settings";
// Customer pages
import MyFavorites from "./pages/User/Customer/MyFavorites";
import MyOrders from "./pages/User/Customer/MyOrders";
import SavedCoupons from "./pages/User/Customer/SavedCoupons";
// Admin pages
import Manage from "./pages/User/Admin/Manage";
import Orders from "./pages/User/Admin/Orders";
import Users from "./pages/User/Admin/Users";
// Error page
import NotFoundPage from "./pages/NotFoundPage";
// Utils
import Wrapper from "./utils/Wrapper";
import ProtectedRoute from "./utils/ProtectedRoute";
const App = () => {
  const USER = "ROLE_USER";
  const ADMIN = "ROLE_ADMIN";
  return (
    <Wrapper>
      <Routes>
        <Route path="/" element={<HomeLayout />}>
          <Route index element={<Home />} />
          <Route path="products" element={<AllProducts />} />
          <Route path="products/:id" element={<ProductDetail />} />
        </Route>
        <Route path="/" element={<LoginLayout />}>
          <Route path="/" element={<ProtectedRoute isLoggedIn={false} />}>
            <Route path="login" element={<Login />} />
          </Route>
          <Route path="register" element={<Register />} />
          <Route path="forgot-password" element={<ForgotPassword />} />
          <Route path="reset-password" element={<ResetPassword />} />
        </Route>
        <Route element={<ProtectedRoute isLoggedIn={true} />}>
          <Route path="/" element={<UserLayout />}>
            <Route path="my-profile" element={<MyProfile />} />
            <Route
              element={<ProtectedRoute isLoggedIn={true} allowedRole={USER} />}
            >
              <Route path="my-orders" element={<MyOrders />} />
              <Route path="my-coupons" element={<SavedCoupons />} />
              <Route path="my-favorites" element={<MyFavorites />} />
            </Route>
            <Route
              element={<ProtectedRoute isLoggedIn={true} allowedRole={ADMIN} />}
            >
              <Route path="manage" element={<Manage />} />
              <Route path="orders" element={<Orders />} />
              <Route path="users" element={<Users />} />
            </Route>
            <Route path="settings" element={<Settings />} />
          </Route>
        </Route>
        <Route path="/*" element={<NotFoundPage />} />
      </Routes>
    </Wrapper>
  );
};
export default App;
