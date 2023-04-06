import React from 'react';
import AppPage from '../../components/app-page/AppPage';
import './index.scss';
import WorkingImage from '../../assets/static-images/login-form-heading.png';
import { Avatar, Box, Button, CircularProgress, Typography } from '@mui/material';
import NorthIcon from '@mui/icons-material/North';

const Dashboard = () => {
  const renderChild = () => {
    return (
      <div className="dashboard-wrapper">
        <div className="monthly-section row">
          <div className="left-col col-4">
            <div className="left-top card">
              <div className="left-top--row row">
                <div className="left col-7">
                  <div className="text">
                    <div className="text-top">Welcome back !</div>
                    <div className="text-bottom">TNShop admin dashboard !</div>
                  </div>
                </div>
                <div className="right col-5">
                  <img src={WorkingImage} alt="working" />
                </div>
              </div>
              <div className="left-bottom--row row">
                <div className="left col-4">
                  <div className="user-avatar">
                    <img
                      alt="user-avatar"
                      src="https://tnshop-resource-storage.s3.ap-northeast-1.amazonaws.com/0d75108c-0ac4-48dd-9f56-e009d4ac9107-nike.png"
                    />
                  </div>
                  <div className="user-name">Ngoc Khanh</div>
                  <div className="user-level">Admin Managament</div>
                </div>

                <div className="right col-8">
                  <div className="top">
                    <div className="text row">
                      <div className="text-content col-6">
                        <div>125</div>
                        <p>Projects</p>
                      </div>
                      <div className="text-content col-6">
                        <div>$1245</div>
                        <p>Revenue</p>
                      </div>
                    </div>
                  </div>
                  <div className="bottom">
                    <a href="/">View Profile</a>
                  </div>
                </div>
              </div>
            </div>
            <div className="left-bottom card">
              <div className="heading">Monthly Earning</div>
              <div className="earn-content row">
                <div className="col-6 earn-monthly">
                  <p>This month</p>
                  <h3>$34,252</h3>
                  <p>
                    <span>
                      {' '}
                      12% <NorthIcon />{' '}
                    </span>{' '}
                    From previous period
                  </p>
                  <a href=""></a>
                </div>
                <div className="col-6 progress-monthly flex">
                  <CircularProgress variant="determinate" size={50} color="success" value={80} />
                  <Box>
                    <Typography variant="caption" component="div" color="white">{`${Math.round(
                      80
                    )}%`}</Typography>
                  </Box>
                </div>
              </div>
              <div className="left-bottom--text">
                We craft digital, graphic and dimensional thinking.
              </div>
            </div>
          </div>
          <div className="right-col">
            <div className="right-top--row"></div>
            <div className="right-bottom-row"></div>
          </div>
        </div>
        <section className="social-section"></section>
        <section className="payment-section"></section>
      </div>
    );
  };

  return (
    <section className="dashboard">
      <AppPage
        title={'Dashboard'}
        pathLocation={['admin', 'dash-board']}
        // @ts-ignore
        renderChild={() => renderChild()}></AppPage>
    </section>
  );
};

export default Dashboard;
