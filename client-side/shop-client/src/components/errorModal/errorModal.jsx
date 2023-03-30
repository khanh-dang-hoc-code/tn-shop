import React from 'react';
import './errormodal.scss';
import PropTypes from 'prop-types';
import { Button } from '@mui/material';

const errorModal = (props) => {
  return (
    <>
      {props.isShowModal && (
        <div className="error-modal-wrapper">
          <div className="error-modal-content">
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

export default errorModal;
errorModal.propTypes = {
  message: PropTypes.string,
  isShowModal: PropTypes.bool,
  onClick: PropTypes.func
};
