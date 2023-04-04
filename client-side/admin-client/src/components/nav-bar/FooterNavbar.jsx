import React from 'react';
import './footerNavbar.scss';
import HomeIcon from '@mui/icons-material/Home';
import SearchIcon from '@mui/icons-material/Search';
import AppsIcon from '@mui/icons-material/Apps';
import AccountCircleIcon from '@mui/icons-material/AccountCircle';
import LocalMallIcon from '@mui/icons-material/LocalMall';

const FooterNavBar = () => {
  return (
    <div className="navbar-footer-container">
      <div className="navbar-footer-content">
        <ul className="footer-navbar-item">
          <li>
            <a href="#">
              <HomeIcon />
              <span>Home</span>
            </a>
          </li>
          <li>
            <a href="#">
              <SearchIcon />
              <span>Search</span>
            </a>
          </li>
          <li>
            <a href="#">
              <AppsIcon />
              <span>Collection</span>
            </a>
          </li>
          <li>
            <a href="#">
              <AccountCircleIcon />
              <span>Account</span>
            </a>
          </li>
          <li>
            <a href="#">
              <LocalMallIcon />
              <span>Cart</span>
            </a>
          </li>
        </ul>
      </div>
    </div>
  );
};

export default FooterNavBar;
