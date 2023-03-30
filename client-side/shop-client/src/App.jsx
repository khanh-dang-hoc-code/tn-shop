import React, { useEffect } from 'react';
import Footer from './components/footer/Footer';
import Header from './components/header/Header';

import './app.scss';
import FooterNavBar from './components/nav-bar/FooterNavbar';
import Introduce from './pages/introduce/Introduce';
import Account from './pages/account/Account';
import { selectToken } from './store/authSlice';
import { useSelector } from 'react-redux';
import { useLoginMutation } from './services/authService';
import { Route, Routes } from 'react-router-dom';
import Login from './components/login/Login';
import Register from './components/register/Register';
import ForgotPassword from './components/forgot-password/ForgotPassword';

const App = () => {
  return (
    <div id="container">
      <Header />
      <div className="content">
        {
          <Routes>
            <Route path="/login" element={<Login />} />
            <Route path="/register" element={<Register />} />
            <Route path="/forgot-password" element={<ForgotPassword />} />
          </Routes>
        }
      </div>
      <Footer />
      <FooterNavBar />
    </div>
  );
};

export default App;
