import React, { useState } from 'react';
import PropTypes from 'prop-types';
import './forgotPassword.scss';
import { Button, Form, Input } from 'antd';

const ForgotPassword = () => {
  const [account, setAccount] = useState({
    userName: ''
  });

  const onFinish = () => {
    console.log('success');
  };
  const onFinishFailed = (e) => {
    console.log('123');
  };

  //   console.log(process.env.BASE_URL);

  const renderForgotPassword = () => {
    return (
      <>
        <div className="forgot-password-heading">Reset your password</div>
        <div className="forgot-password-subheading">
          We will send you OTP to your phone number to reset your password
        </div>
        <Form
          className="forgot-password-form"
          name="forgot-password-form"
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
                userName: allvalue.phoneNumber
              };
            });
          }}
          autoComplete="off">
          <Form.Item
            label="Phone number"
            name="phoneNumber"
            rules={[
              {
                required: true,
                message: 'Please input your phone number!'
              },
              {
                pattern: /^(\+84|0)(3[2-9]|5[6|8|9]|7[0|6-9]|8[1-5|8|9]|9[0-4|6-9])(\d{7})$/,
                message: 'User name is not valid'
              }
            ]}>
            <Input />
          </Form.Item>

          <Form.Item>
            <Button
              className="login-form-button"
              type="primary"
              htmlType="submit"
              onClick={() => {
                console.log('submit');
              }}>
              Submit
            </Button>
          </Form.Item>
        </Form>
      </>
    );
  };

  return <div className="forgot-password-container">{renderForgotPassword()}</div>;
};

export default ForgotPassword;
