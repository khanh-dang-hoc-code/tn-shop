import React, { useEffect } from 'react';
import { selectToken } from './store/authSlice';
import { useSelector } from 'react-redux';
import AppDrawer from './components/app-drawer/AppDrawer';
import './app.scss';
import Header from './components/header/Header';
import Navbar from './components/navbar/Navbar';
import Footer from './components/footer/Footer';

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
      <Navbar />
      {/* <div className="container-left">
        <AppDrawer isOpen={false} />
      </div> */}
      <div className="container-right"></div>
      <Footer />
    </div>
  );
};

export default App;
