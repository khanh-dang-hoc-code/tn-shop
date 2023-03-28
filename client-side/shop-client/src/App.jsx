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

const App = () => {
  return (
    <div id="container">
      <Header />
      <div className="content">
        <Account />
      </div>
      <Footer />
      <FooterNavBar />
    </div>
  );
};

export default App;
