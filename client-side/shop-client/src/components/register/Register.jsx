import React, { useState } from 'react';
import PropTypes from 'prop-types';
import { Button, Checkbox, Form, Input } from 'antd';
import './register.scss';
import { useDispatch } from 'react-redux';
import { setRegisterData } from '../../store/registerSlice';

const Register = () => {
  const [account, setAccount] = useState({
    userName: '',
    password: '',
    firstName: '',
    lastName: ''
  });

  const dispatch = useDispatch();

  const submitRegister = () => {
    dispatch(setRegisterData(account));
  };

  const onFinish = () => {
    console.log('success');
  };
  const onFinishFailed = (e) => {
    console.log('123');
  };

  const renderRegister = () => {
    return (
      <>
        <div className="register-heading">REGISTER</div>
        <Form
          className="register-form"
          name="register"
          labelCol={{
            span: 8
          }}
          wrapperCol={{
            span: 16
          }}
          style={{
            maxWidth: 600
          }}
          initialValues={{}}
          onFinish={onFinish}
          onFinishFailed={onFinishFailed}
          onValuesChange={(e, allvalue) => {
            setAccount((pre) => {
              return {
                ...pre,
                userName: allvalue.email,
                password: allvalue.password,
                firstName: allvalue.firstName,
                lastName: allvalue.lastName
              };
            });
          }}
          autoComplete="off">
          <Form.Item
            label="First Name"
            name="firstName"
            rules={[
              {
                required: true,
                message: 'Please input your first name!'
              }
            ]}>
            <Input />
          </Form.Item>
          <Form.Item
            label="Last Name"
            name="lastName"
            rules={[
              {
                required: true,
                message: 'Please input your last name!'
              }
            ]}>
            <Input />
          </Form.Item>

          <Form.Item
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
              },
              {
                pattern: /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/,
                message:
                  'Your password is not strong! Please input the password min length is 8, at least 1 uppercase, at least 1 lowercase, at least 1 number, at least 1 spical character '
              }
            ]}>
            <Input.Password />
          </Form.Item>

          <Form.Item>
            <Button
              className="login-form-button"
              type="primary"
              htmlType="submit"
              onClick={submitRegister}>
              Submit
            </Button>
          </Form.Item>
        </Form>
      </>
    );
  };

  return <div className="register-container">{renderRegister()}</div>;
};

export default Register;
