import { Button, Checkbox, Form, Input } from 'antd';
import React from 'react';
import './account.scss';
import Login from '../../components/login/Login';
import Register from '../../components/register/Register';
import ForgotPassword from '../../components/forgot-password/ForgotPassword';

const Account = () => {
  return (
    <div className="login-register-container">
      <Login isLogin={true} />
      <Register isRegister={false} />
      <ForgotPassword isForgotPassword={false} />
    </div>
  );
};

export default Account;
