import React, { useEffect } from 'react';
import { selectToken } from '../../store/authSlice';
import { useSelector } from 'react-redux';
import AppDrawer from '../../components/app-drawer/AppDrawer';
import './app.scss';
import Header from '../../components/header/Header';
import Navbar from '../../components/navbar/Navbar';
import Footer from '../../components/footer/Footer';

const App = () => {
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
