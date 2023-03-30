import React, { useState } from 'react';
import './account.scss';
import Login from '../../components/login/Login';
import Register from '../../components/register/Register';
import VerifyOTP from '../../components/verifyOTP/VerifyOTP';
import ForgotPassword from '../../components/forgot-password/ForgotPassword';
import { useSelector } from 'react-redux';
import { selectRegisterData } from '../../store/registerSlice';
import SuccessModal from '../../components/successModal/SuccessModal';

const Account = () => {
  const [isVerifyOtp, setIsVerifyOtp] = useState(false);

  const switchOTPCallback = () => {
    setIsVerifyOtp((pre) => !pre);
  };

  const verifyOTP = () => {
    console.log('verify otp');
  };

  const registerData = useSelector(selectRegisterData);

  return (
    <div className="login-register-container">
      {isVerifyOtp ? (
        <VerifyOTP verifyOTP={verifyOTP} />
      ) : (
        <>
          <Login />
          <Register />
          <ForgotPassword />
          <SuccessModal
            isShowModal={false}
            message={'conguralation'}
            onClick={() => {
              console.log('close ');
            }}
          />
        </>
      )}
    </div>
  );
};

export default Account;
