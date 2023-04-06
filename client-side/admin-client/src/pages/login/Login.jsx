import React, { useState } from 'react';
import './index.scss';
import { useLoginMutation } from '../../services/authService';
import { saveItemInStorage } from '../../helper/tokenUtils';
import { useNavigate } from 'react-router-dom';
import { useDispatch } from 'react-redux';
import { setToken } from '../../store/authSlice';
import '../../common.scss';
import LoginImage from '../../assets/static-images/login.jpeg';
import FacebookIcon from '../../assets/static-images/facebook.svg';
import GoogleIcon from '../../assets/static-images/google.svg';
import { TextField, Button, makeStyles } from '@material-ui/core';
import { Divider } from '@mui/material';

const Login = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const [login, isLoading] = useLoginMutation();

  const dispatch = useDispatch();

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
        // @ts-ignore
        let token = res?.data?.token;
        if (token) {
          saveItemInStorage('crm-tnshop-token', token);
          dispatch(setToken(token));
        }
      })
      .then(() => {
        navigate('/dash-board');
      })
      .catch((err) => {
        console.log(err);
      });
  };

  const useStyles = makeStyles((theme) => ({
    form: {
      display: 'flex',
      flexDirection: 'column',
      alignItems: 'center',
      marginTop: theme.spacing(8)
    },
    input: {
      width: '100%',
      marginBottom: theme.spacing(4),
      backgroundColor: 'rgb(36, 38, 45)',
      fontSize: 14
    },
    button: {
      width: '100%',
      backgroundColor: 'rgba(5,122,85)',
      color: '#FFF',
      minHeight: 30
    },
    social: {
      width: '100%',
      backgroundColor: '#FFF',
      color: '#000',
      minHeight: 30,
      marginBottom: theme.spacing(4)
    }
  }));

  const classes = useStyles();

  return (
    <div className="login-section flex min-h-screen p-24 items-center">
      <div className="login-wrapper shadow-xl mx-auto h-full flex-1 rounded-lg overflow-hidden">
        <div className="login-content flex h-full">
          <img src={LoginImage} className="left img-asb col-6 h-full" alt="Login" />

          <div className="right col-6 h-full p-48">
            <div className="heading mb-24 fz-24 fw-600">Login</div>
            <form className={classes.form} onSubmit={handleSubmit}>
              <TextField
                className={classes.input}
                inputProps={{
                  placeholder: 'Your phone number',
                  style: {
                    color: '#FFF'
                  }
                }}
                InputLabelProps={{
                  style: {
                    color: '#9E9E9E'
                  }
                }}
                label="Email"
                variant="outlined"
                value={username}
                onChange={handleUsernameChange}
              />
              <TextField
                className={classes.input}
                inputProps={{
                  placeholder: 'Your password',
                  style: {
                    color: '#FFF'
                  }
                }}
                InputLabelProps={{
                  style: {
                    color: '#9E9E9E'
                  }
                }}
                label="Password"
                variant="outlined"
                type="password"
                value={password}
                onChange={handlePasswordChange}
              />
              <Button className={classes.button} variant="contained" color="inherit" type="submit">
                Login
              </Button>
            </form>

            <Divider color="#FFF" sx={{ marginBottom: 4, marginTop: 4 }} />

            <Button className={classes.social} variant="contained" color="inherit" type="submit">
              <img className="img-asb col-1 flex items-center" src={FacebookIcon} /> Facebook
            </Button>

            <Button className={classes.social} variant="contained" color="inherit" type="submit">
              <img className="img-asb col-1 flex items-center" src={GoogleIcon} /> Google
            </Button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Login;
