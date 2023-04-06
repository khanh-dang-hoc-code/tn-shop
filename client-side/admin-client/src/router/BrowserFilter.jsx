import React, { useEffect } from 'react';
import { useSelector } from 'react-redux';
import { Navigate, Route, Routes, useLocation } from 'react-router-dom';
import App from '../pages/app/App';
import Login from '../pages/login/Login';
import { selectToken } from '../store/authSlice';
import NotFoundPage from '../pages/404Page/NotFoundPage';

const BrowserFilter = () => {
  const accessToken = useSelector(selectToken);
  const isLogin = accessToken !== null && accessToken.length !== 0;
  const location = useLocation();

  useEffect(() => {
    const handleWindowFocus = () => {
      document.title = 'TN Shop Admin Dashboard';
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

  useEffect(() => {
    console.log('is login', isLogin);
  }, [isLogin]);

  return (
    <div>
      <Routes>
        <Route path="/admin/*" element={isLogin ? <App /> : <Navigate to={'/login'} />} />
        <Route
          path="/login"
          element={
            isLogin ? (
              <Navigate to={location.state?.from || '/admin/dash-board'} replace />
            ) : (
              <Login />
            )
          }
        />
        <Route path="/*" element={<NotFoundPage />} />
      </Routes>
    </div>
  );
};

export default BrowserFilter;
