import React, { useState, useEffect } from 'react';
import Footer from './components/footer/Footer';
import Header from './components/header/Header';

import './app.scss';
import FooterNavBar from './components/nav-bar/FooterNavbar';
import { selectToken } from './store/authSlice';
import { useSelector } from 'react-redux';
import { Navigate, Route, Routes } from 'react-router-dom';
import Login from './components/login/Login';
import Register from './components/register/Register';
import ForgotPassword from './components/forgot-password/ForgotPassword';

const App = () => {
  const accessToken = useSelector(selectToken);
  const isLogin = accessToken !== null && accessToken.length !== 0;

  useEffect(() => {
    const handleWindowFocus = () => {
      document.title = 'TN Shop';
    };
    const handleWindowBlur = () => {
      document.title = 'Come back ~~~';
    };

    window.addEventListener('focus', handleWindowFocus);
    window.addEventListener('blur', handleWindowBlur);

    return () => {
      window.removeEventListener('focus', handleWindowFocus);
      window.removeEventListener('blur', handleWindowBlur);
    };
  }, []);

  return (
    <div id="container">
      <Header />
      <div className="content">
        <Routes>
          <Route path="/login" element={!isLogin ? <Login /> : <Navigate to={''} />} />
          <Route path="/register" element={<Register />} />
          <Route
            path="/forgot-password"
            element={isLogin ? <ForgotPassword /> : <Navigate to={'/login'} />}
          />
        </Routes>
      </div>
      <Footer />
      <FooterNavBar />
    </div>
  );
};

export default App;
