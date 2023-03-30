import { Button, Checkbox, Form, Input } from 'antd';
import React, { useEffect, useState } from 'react';
import PropTypes from 'prop-types';
import './login.scss';
import { useLoginMutation } from '../../services/authService';
import { useDispatch } from 'react-redux';
import { setToken } from '../../store/authSlice';
import { getItemInStorage, saveItemInStorage } from '../../helper/tokenUtils';
import { NavLink } from 'react-router-dom';
const Login = () => {
  const dispatch = useDispatch();
  const [data, isLoading] = useLoginMutation();

  useEffect(() => {}, []);

  const login = () => {
    data({ userName: account.userName, password: account.password })
      .then((res) => {
        let token = res?.data?.token;
        saveItemInStorage('accessToken', token);
      })
      .catch((err) => console.log(err));
  };

  const [account, setAccount] = useState({
    userName: '',
    password: '',
    rememberMe: false
  });

  const onFinish = () => {
    if (account.rememberMe) {
      saveItemInStorage('usernameTNShop', account.userName);
      saveItemInStorage('passwordTNShop', account.password);
    }
    console.log('success');
  };
  const onFinishFailed = (e) => {
    console.log('123');
  };

  useEffect(() => {
    const username = getItemInStorage('usernameTNShop') || '';
    const password = getItemInStorage('passwordTNShop') || '';

    setAccount((pre) => {
      return {
        ...pre,
        userName: username,
        password: password
      };
    });
  }, []);

  const renderLogin = () => {
    return (
      <>
        <div className="login-heading">LOGIN</div>
        <Form
          className="login-form"
          name="login"
          labelCol={{
            span: 8
          }}
          wrapperCol={{
            span: 16
          }}
          style={{
            maxWidth: 600
          }}
          initialValues={{
            email: getItemInStorage('usernameTNShop') || '',
            password: getItemInStorage('passwordTNShop') || '',
            remember: true
          }}
          onFinish={onFinish}
          onFinishFailed={onFinishFailed}
          onValuesChange={(e, allvalue) => {
            console.log(allvalue);
            setAccount((pre) => {
              return {
                ...pre,
                userName: allvalue.email,
                password: allvalue.password,
                rememberMe: allvalue.remember
              };
            });
          }}
          autoComplete="off">
          <Form.Item
            rootClassName="email-input"
            className="login-input"
            label="Email Address"
            name="email"
            rules={[
              {
                required: true,
                message: 'Please input your email!'
              },
              {
                pattern:
                  /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,
                message: 'Email is not correct'
              }
            ]}>
            <Input />
          </Form.Item>

          <Form.Item
            label="Password"
            name="password"
            rules={[
              {
                required: true,
                message: 'Please input your password!'
              }
            ]}>
            <Input.Password />
          </Form.Item>

          <Form.Item name="remember" valuePropName="checked">
            <Checkbox>Remember me</Checkbox>
          </Form.Item>

          <div className="forgot-password">
            <NavLink to={'/forgot-password'}>
              <span>Forgot password ?</span>
            </NavLink>
          </div>

          <Form.Item>
            <Button className="login-form-button" type="primary" htmlType="submit" onClick={login}>
              Submit
            </Button>
          </Form.Item>
        </Form>
      </>
    );
  };

  return <div className="login-container">{renderLogin()}</div>;
};

export default Login;
