import React, { useState } from 'react';
import './index.scss';
import MenuIcon from '@mui/icons-material/Menu';
import FullscreenIcon from '@mui/icons-material/Fullscreen';
import screenfull from 'screenfull';
import { Avatar, Badge, Divider, Popover, Typography } from '@mui/material';
import NotificationsIcon from '@mui/icons-material/Notifications';
import GridViewIcon from '@mui/icons-material/GridView';
import PersonIcon from '@mui/icons-material/Person';
import WalletIcon from '@mui/icons-material/Wallet';
import SettingsIcon from '@mui/icons-material/Settings';
import LockOpenIcon from '@mui/icons-material/LockOpen';
import PowerSettingsNewIcon from '@mui/icons-material/PowerSettingsNew';
import GitHubIcon from '@mui/icons-material/GitHub';
import Dribble from '../../assets/static-images/dribbble-icon.svg';
import Bitbucket from '../../assets/static-images/bitbucket-icon.svg';
import Dropbox from '../../assets/static-images/dropbox-1.svg';
import Mailchimp from '../../assets/static-images/mailchimp-freddie-icon.svg';
import Slack from '../../assets/static-images/slack-new-logo.svg';

const Header = () => {
  const handleFullScreenButton = () => {
    if (screenfull.isEnabled) {
      if (screenfull.isFullscreen) {
        screenfull.exit();
        return;
      }
      screenfull.request();
    }
  };

  return (
    <section className="header">
      <div className="header-content flex-h100">
        <div className="header-left flex-h100">
          <div className="menu-icon">
            <MenuIcon />
          </div>
        </div>
        <div className="header-right flex-h100">
          <div className="grid-icon flex-h100 cursor-pointer">
            <div className="grid-main-group">
              <GridViewIcon />
            </div>
            <ul className="grid-sub-group">
              <li className="grid-sub-item row">
                <div className="row">
                  <a href="">
                    <GitHubIcon />
                    <span>Github</span>
                  </a>
                </div>

                <div className="row">
                  <a href="">
                    <img className="image-custom" src={Bitbucket} />
                    <span>Bitbucket</span>
                  </a>
                </div>

                <div className="row">
                  <a href="">
                    <img className="image-custom" src={Dribble} />
                    <span>Dribble</span>
                  </a>
                </div>
              </li>
              <li className="grid-sub-item row">
                <div className="row">
                  <a href="">
                    <img className="image-custom" src={Dropbox} />
                    <span>Dropbox</span>
                  </a>
                </div>

                <div className="row">
                  <a href="">
                    <img className="image-custom" src={Mailchimp} />
                    <span>Mail Chimp</span>
                  </a>
                </div>

                <div className="row">
                  <a href="">
                    <img className="image-custom" src={Slack} />
                    <span>Slack</span>
                  </a>
                </div>
              </li>
            </ul>
          </div>
          <div className="full-screen-icon cursor-pointer" onClick={handleFullScreenButton}>
            <FullscreenIcon />
          </div>
          <div className="notification-icon cursor-pointer">
            <Badge color="secondary" badgeContent={10} max={999}>
              <NotificationsIcon className="notification-header-icon" />
            </Badge>
          </div>
          <div className="user-group flex-h100 cursor-pointer">
            <div className="user-main-group flex">
              <Avatar
                className="header-user-image"
                alt="Admin"
                src="https://tnshop-resource-storage.s3.ap-northeast-1.amazonaws.com/0d75108c-0ac4-48dd-9f56-e009d4ac9107-nike.png"
              />

              <div className="user-profile-button">Admin</div>
            </div>
            <ul className="user-sub-group">
              <li className="sub-group-item">
                <a href="">
                  <PersonIcon fontSize={'small'} />
                  <span>Profile </span>
                </a>
              </li>
              <li className="sub-group-item">
                <a href="">
                  <WalletIcon fontSize={'small'} /> <span>My Wallet</span>
                </a>
              </li>
              <li className="sub-group-item">
                <a href="">
                  <SettingsIcon fontSize={'small'} /> <span>Settings</span>
                </a>
              </li>
              <li className="sub-group-item">
                <a href="">
                  <LockOpenIcon fontSize={'small'} />
                  <span>Lock screen</span>
                </a>
              </li>
              <Divider className="logout-divider" />
              <li className="sub-group-item">
                <a href="">
                  <PowerSettingsNewIcon fontSize={'small'} />
                  <span>Log out</span>
                </a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </section>
  );
};

export default Header;
