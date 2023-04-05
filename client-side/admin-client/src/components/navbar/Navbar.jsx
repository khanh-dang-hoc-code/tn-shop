import React from 'react';
import './index.scss';
import KeyboardArrowDownIcon from '@mui/icons-material/KeyboardArrowDown';
import HomeIcon from '@mui/icons-material/Home';
import GridViewIcon from '@mui/icons-material/GridView';

const Navbar = () => {
  return (
    <section className="navbar">
      <div className="navbar-content">
        <div className="nav-dashboard">
          <div className="dash-board-main-group flex-h100">
            <HomeIcon />
            <span> Dashboard</span>
            <KeyboardArrowDownIcon />
          </div>
          <ul className="dash-board-sub-group">
            <li className="subgroup-item">
              <a href="">Default</a>
            </li>
            <li className="subgroup-item">
              <a href="">Saas</a>
            </li>
            <li className="subgroup-item">
              <a href="">Blog</a>
            </li>
          </ul>
        </div>

        <div className="nav-app">
          <div className="app-main-group flex-h100">
            <GridViewIcon />
            <span> App</span>
            <KeyboardArrowDownIcon />
          </div>
          <ul className="app-sub-group">
            <li className="subgroup-item">
              <a href="">Ecomerce</a>
            </li>
            <li className="subgroup-item">
              <a href="">Blog</a>
            </li>
            <li className="subgroup-item">
              <a href="">Contact</a>
            </li>
            <li className="subgroup-item">
              <a href="">Email</a>
            </li>
          </ul>
        </div>
      </div>
    </section>
  );
};

export default Navbar;
