import { Carousel } from 'antd';
import React, { useState } from 'react';
import Logo from '../../assets/static-images/NK-logo.png';
import Locale from '../../assets/static-images/locale.png';
import './header.scss';
import LocalPhoneIcon from '@mui/icons-material/LocalPhone';
import ShoppingBagIcon from '@mui/icons-material/ShoppingBag';
import FavoriteBorderIcon from '@mui/icons-material/FavoriteBorder';
import Navbar from '../nav-bar/Navbar';

const Header = () => {
  const headerLable = [
    'Special offer - big deal ',
    'Special offer - big deal ',
    'Special offer - big deal ',
    'Special offer - big deal ',
    'Special offer - big deal ',
    'Special offer - big deal ',
    'Special offer - big deal ',
    'Special offer - big deal '
  ];
  const renderHeaderSlider = headerLable.map((item, index) => (
    <div key={index} className="slider-scroll child">
      <span>{item}</span>
    </div>
  ));
  return (
    <div className="header-container">
      <div className="header-slider">{renderHeaderSlider}</div>
      <div className="header-center">
        <div className="header-content">
          <div className="header-left">
            <img src={Logo} alt="logo" />
          </div>
          <div className="header-right">
            <div className="top">
              <div>
                <LocalPhoneIcon /> <span> +84 343 513 613 - NK Store</span>
              </div>
              <div className="local">
                <img src={Locale} alt="locale" />
              </div>
            </div>

            <div className="center flex">
              <div>FREE SHIPPING ON ALL ORDERS. NO MINIMUM PURCHASE</div>
            </div>

            <div className="bottom flex">
              <div className="header-cart flex">
                <ShoppingBagIcon />
                <div>Shopping Cart</div>
                <div className="number-cart">0</div>
              </div>

              <div className="header-wish-list flex">
                <FavoriteBorderIcon />
                <span>My Wish List</span>
              </div>

              <div className="header-signup flex">Sign In or Create an Account</div>
            </div>
          </div>
        </div>
      </div>
      <div className="header-navbar">
        <Navbar />
      </div>
    </div>
  );
};

export default Header;
