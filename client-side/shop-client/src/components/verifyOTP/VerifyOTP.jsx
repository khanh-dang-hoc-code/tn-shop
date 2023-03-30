import { Button } from '@mui/material';
import React, { useState } from 'react';
import OtpInput from 'react-otp-input';
import './VerifyOTP.scss';
import PropTypes from 'prop-types';

const VerifyOTP = (props) => {
  const [OTPValue, setOTPValue] = useState('');

  return (
    <div className="otp-wrapper">
      <div className="otp-header">Verify OTP</div>
      <OtpInput
        value={OTPValue}
        onChange={setOTPValue}
        numInputs={6}
        renderSeparator={<span> </span>}
        shouldAutoFocus
        containerStyle={{ minWidth: 40 }}
        inputStyle={{ minWidth: 40, minHeight: 40, padding: 12, margin: 12, textAlign: 'center' }}
        renderInput={(props) => <input {...props} />}
      />
      <Button className="otp-button" variant="contained" onClick={props.verifyOTP}>
        Verify
      </Button>
    </div>
  );
};

export default VerifyOTP;

VerifyOTP.propTypes = {
  verifyOTP: PropTypes.func
};
