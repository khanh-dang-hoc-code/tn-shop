import { Modal, Box, Typography } from '@material-ui/core';
import { style } from '@mui/system';
import React from 'react';
import './index.scss';

const SuccessModal = () => {
  return (
    <div className="success-modal">
      <Modal
        open={true}
        onClose={() => {}}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description">
        <Box>
          <Typography id="modal-modal-title" variant="h6" component="h2">
            Text in a modal
          </Typography>
        </Box>
      </Modal>
    </div>
  );
};

export default SuccessModal;
