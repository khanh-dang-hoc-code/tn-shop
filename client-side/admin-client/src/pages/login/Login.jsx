import React, { useState } from 'react';
import './index.scss';
import LoginHeadingImage from '../../assets/static-images/login-form-heading.png';
import { TextField, Button } from '@material-ui/core';
import { useLoginMutation } from '../../services/authService';
import { saveItemInStorage } from '../../helper/tokenUtils';
import { useNavigate } from 'react-router-dom';

const Login = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const [login, isLoading] = useLoginMutation();

  const navigate = useNavigate();

  const handleUsernameChange = (event) => {
    setUsername(event.target.value);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  const handleSubmit = (event) => {
    event.preventDefault();

    console.log({
      userName: username,
      password: password
    });
    login({
      userName: username,
      password: password
    })
      .then((res) => {
        saveItemInStorage('crm-tnshop-token', res?.data?.token);
        navigate('/admin');
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return (
    <div className="login">
      <div className="login-form-wrapper">
        <div className="header">
          <div className="heading">
            <div className="heading-text">Welcome Back !</div>
            <div className="message-text">Sign in to continue to TNShop.</div>
          </div>
          <div className="header-image">
            <img src={LoginHeadingImage} alt="login-form" />
          </div>
        </div>
        <form onSubmit={handleSubmit} className="form-content">
          <TextField
            id="username"
            label="Username"
            variant="outlined"
            value={username}
            onChange={handleUsernameChange}
            margin="normal"
            fullWidth
          />
          <TextField
            id="password"
            label="Password"
            type="password"
            variant="outlined"
            value={password}
            onChange={handlePasswordChange}
            margin="normal"
            fullWidth
          />
          <Button
            className="submit-button"
            type="submit"
            variant="contained"
            color="primary"
            fullWidth>
            Login
          </Button>
        </form>
      </div>
    </div>
  );
};

export default Login;
