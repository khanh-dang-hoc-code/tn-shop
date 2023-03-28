import React from 'react';
import './navbar.scss';

const Navbar = () => {
  const navbarItemArrays = [
    { label: 'shop', link: '#' },
    { label: 'product', link: '#' },
    { label: 'blog', link: '#' },
    { label: 'pages', link: '#' },
    { label: 'new in', link: '#' },
    { label: 'trend', link: '#' },
    { label: 'collections', link: '#' }
  ];
  const renderNavbarContent = navbarItemArrays.map((item, index) => (
    <li key={index}>
      <a href={item.link}>
        <span>{item.label}</span>
      </a>
    </li>
  ));

  return (
    <div className="navbar-container">
      <div className="navbar-content">
        <ul>{renderNavbarContent}</ul>
      </div>
    </div>
  );
};

export default Navbar;
