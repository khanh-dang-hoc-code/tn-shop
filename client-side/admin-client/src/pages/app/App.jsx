import React, { useEffect } from 'react';
import { selectToken } from '../../store/authSlice';
import { useSelector } from 'react-redux';
import AppDrawer from '../../components/app-drawer/AppDrawer';
import './app.scss';
import Header from '../../components/header/Header';
import Navbar from '../../components/navbar/Navbar';
import Footer from '../../components/footer/Footer';
import { Route, Routes } from 'react-router-dom';
import Dashboard from '../dashboard/Dashboard';
import Ecommerce from '../ecommerce/Ecommerce';

const App = () => {
  return (
    <div id="container">
      <Header />
      <Navbar />
      {/* <div className="container-left">
        <AppDrawer isOpen={false} />
      </div> */}
      <div className="content">
        <Routes>
          <Route path="/dash-board" element={<Dashboard />} />
          <Route path="/ecommerce" element={<Ecommerce />} />
        </Routes>
      </div>
      <Footer />
    </div>
  );
};

export default App;
