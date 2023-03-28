import { Button, Input } from 'antd';
import React, { useEffect, useState } from 'react';
import FacebookIcon from '@mui/icons-material/Facebook';
import InstagramIcon from '@mui/icons-material/Instagram';
import PinterestIcon from '@mui/icons-material/Pinterest';
import YouTubeIcon from '@mui/icons-material/YouTube';
import TwitterIcon from '@mui/icons-material/Twitter';
import Amex from '../../assets/static-images/payments/amex.svg';
import Vias from '../../assets/static-images/payments/visa.svg';
import Mastercard from '../../assets/static-images/payments/mastercard.svg';
import ApplePay from '../../assets/static-images/payments/applepay.svg';
import Paypal from '../../assets/static-images/payments/paypal.svg';
import AddIcon from '@mui/icons-material/Add';
import RemoveIcon from '@mui/icons-material/Remove';
import $ from 'jquery';

import './footer.scss';

const Footer = () => {
  const [email, setEmail] = useState('');
  const [isValidEmail, setIsValidEmail] = useState(true);
  const [shoChildren, setShowChildren] = useState({
    c1: false,
    c2: false,
    c3: false
  });

  const inputEmail = (e) => {
    setEmail(e.target.value);
  };

  const submidEmail = () => {
    let isValidEmail = validateEmail();
    if (!isValidEmail) {
      setIsValidEmail(false);
      return;
    }
    setIsValidEmail(true);
  };

  const validateEmail = () => {
    return email.match(
      /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
    )
      ? true
      : false;
  };

  const handleShowChild = (rowLindex) => {
    let container = $('.footer-container .column');
    let currentDom = container[rowLindex];

    if ($(currentDom).children()[1].classList.contains('active')) {
      $(currentDom).children()[1].classList.remove('active');
    } else {
      $(currentDom).children()[1].classList.add('active');
    }
    switch (rowLindex) {
      case 0:
        setShowChildren((pre) => {
          return {
            ...pre,
            c1: !pre.c1
          };
        });
        break;
      case 1:
        setShowChildren((pre) => {
          return {
            ...pre,
            c2: !pre.c2
          };
        });
        break;
      case 2:
        setShowChildren((pre) => {
          return {
            ...pre,
            c3: !pre.c3
          };
        });
        break;
    }
  };

  const shopColumn = [
    { label: 'New In', link: '#' },
    { label: 'Women', link: '#' },
    { label: 'Men', link: '#' },
    { label: 'Shoes', link: '#' },
    { label: 'Bags & Accessories', link: '#' },
    { label: 'Top Brands', link: '#' },
    { label: 'Sale & Special Offers', link: '#' }
  ];

  const infomationColumn = [
    { label: 'About', link: '#' },
    { label: 'Customer Service', link: '#' },
    { label: 'Reward Program', link: '#' },
    { label: 'Shipping & Returns', link: '#' },
    { label: 'Privacy Policy', link: '#' },
    { label: 'Terms & Conditions', link: '#' },
    { label: 'Blog', link: '#' }
  ];

  const customerServiceColumn = [
    { label: 'Search Terms', link: '#' },
    { label: 'Advanced Search', link: '#' },
    { label: 'Orders And Returns', link: '#' },
    { label: 'Contact Us', link: '#' },
    { label: 'Theme FAQs', link: '#' },
    { label: 'Consultant', link: '#' },
    { label: 'Store Locations', link: '#' }
  ];

  const renderColumn = (arrItems) => {
    return arrItems.map((item, index) => (
      <li key={index}>
        <div>
          <a href={item.link}>
            <span>{item.label}</span>
          </a>
        </div>
      </li>
    ));
  };

  return (
    <div className="footer-container">
      <div className="footer-top">
        <div className="container flex">
          <div className="column">
            <div className="heading" onClick={() => handleShowChild(0)}>
              <div>Shop</div>

              {shoChildren.c1 ? (
                <RemoveIcon className="minus-icon" />
              ) : (
                <AddIcon className="plus-icon" />
              )}
            </div>
            <ul>{renderColumn(shopColumn)}</ul>
          </div>
          <div className="column">
            <div className="heading" onClick={() => handleShowChild(1)}>
              <div> INFORMATION</div>
              {shoChildren.c2 ? (
                <RemoveIcon className="minus-icon" />
              ) : (
                <AddIcon className="plus-icon" />
              )}
            </div>
            <ul>{renderColumn(infomationColumn)}</ul>
          </div>
          <div className="column">
            <div className="heading" onClick={() => handleShowChild(2)}>
              <div>CUSTOMER SERVICE</div>
              {shoChildren.c3 ? (
                <RemoveIcon className="minus-icon" />
              ) : (
                <AddIcon className="plus-icon" />
              )}
            </div>
            <ul>{renderColumn(customerServiceColumn)}</ul>
          </div>
          <div className="column flex-2 bottom-input">
            <div className="heading">NEWSLETTER SIGN UP</div>
            <div>
              <span>Sign up for exclusive updates, new arrivals & insider only discounts</span>
              <div className="input flex">
                <Input
                  status={'error'}
                  onPressEnter={submidEmail}
                  onChange={inputEmail}
                  style={!isValidEmail ? { borderColor: 'red' } : { borderColor: 'white' }}
                />
                <Button onClick={submidEmail} size="small">
                  SUBMIT
                </Button>
              </div>
            </div>
            <ul className="social-list flex">
              <li>
                <a href="#" className="flex">
                  <FacebookIcon />
                </a>
              </li>
              <li>
                <a href="#" className="flex">
                  <InstagramIcon />
                </a>
              </li>
              <li>
                <a href="#" className="flex">
                  <PinterestIcon />
                </a>
              </li>
              <li>
                <a href="#" className="flex">
                  <YouTubeIcon />
                </a>
              </li>
              <li>
                <a href="#" className="flex">
                  <TwitterIcon />
                </a>
              </li>
            </ul>
          </div>
        </div>
      </div>
      <div className="footer-bottom">
        <div className="container flex">
          <div className="left">
            <div>Ella Demo. All Rights Reserved. Powered By Shopify.</div>
            <div>Shopify Themes By HaloThemes.Com</div>
          </div>
          <div className="right">
            <ul className="payment-lists flex">
              <li>
                <img src={Vias} alt="visa" />
              </li>
              <li>
                <img src={Mastercard} alt="mastercard" />
              </li>
              <li>
                <img src={Amex} alt="amex" />
              </li>
              <li>
                <img src={ApplePay} alt="appelpay" />
              </li>
              <li>
                <img src={Paypal} alt="paypal" />
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Footer;
