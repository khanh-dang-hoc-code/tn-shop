import React, { useEffect } from 'react';
import { useSelector } from 'react-redux';
import { Navigate, Route, Routes } from 'react-router-dom';
import App from '../pages/app/App';
import Login from '../pages/login/Login';
import { selectToken } from '../store/authSlice';

const BrowserFilter = () => {
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
    <div>
      <Routes>
        <Route path="/" element={isLogin ? <App /> : <Navigate to={'/login'} />} />
        <Route path="/login" element={<Login />} />
      </Routes>
    </div>
  );
};

export default BrowserFilter;
