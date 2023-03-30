import { Button, Checkbox, Form, Input } from 'antd';
import React, { useEffect, useState } from 'react';
import PropTypes from 'prop-types';
import './login.scss';
import { useLoginMutation } from '../../services/authService';
import { useDispatch } from 'react-redux';
import { setToken } from '../../store/authSlice';
import { getItemInStorage, saveItemInStorage } from '../../helper/tokenUtils';
import { NavLink, useNavigate } from 'react-router-dom';
const Login = () => {
  const dispatch = useDispatch();
  const [login, isLoading] = useLoginMutation();

  useEffect(() => {}, []);

  const navigate = useNavigate();

  const handleLogin = () => {
    login({ userName: account.userName, password: account.password })
      .then((res) => {
        let token = res?.data?.token;
        saveItemInStorage('accessToken', token);
        navigate('/');
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
            label="User name"
            name="email"
            rules={[
              {
                required: true,
                message: 'Please input your user name!'
              },
              {
                pattern: /^(\+84|0)(3[2-9]|5[6|8|9]|7[0|6-9]|8[1-5|8|9]|9[0-4|6-9])(\d{7})$/,
                message: 'User name is not valid'
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
            <Button
              className="login-form-button"
              type="primary"
              htmlType="submit"
              onClick={handleLogin}>
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
