import React from 'react';
import './sucessmodal.scss';
import PropTypes from 'prop-types';
import { Button } from '@mui/material';

const SuccessModal = (props) => {
  return (
    <>
      {props.isShowModal && (
        <div className="success-modal-wrapper">
          <div className="success-modal-content">
            <div className="modal-text">
              <div className="header">Success</div>
              <div className="message">{props.message}</div>
            </div>
            <div className="modal-button">
              <Button onClick={props.onClick}>Click me !!!</Button>
            </div>
          </div>
        </div>
      )}
    </>
  );
};

export default SuccessModal;

SuccessModal.propTypes = {
  message: PropTypes.string,
  isShowModal: PropTypes.bool,
  onClick: PropTypes.func
};
