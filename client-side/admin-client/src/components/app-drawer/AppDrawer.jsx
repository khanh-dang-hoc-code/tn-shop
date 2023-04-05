import React from 'react';
import PropTypes from 'prop-types';
import './index.scss';

const AppDrawer = ({ isOpen, ...rest }) => {
  return (
    <>
      {isOpen ? (
        <div className="drawer-container--open">TNSHOp</div>
      ) : (
        <div className="drawer-container--close"></div>
      )}
    </>
  );
};

AppDrawer.propTypes = {
  isOpen: PropTypes.bool.isRequired
};

export default AppDrawer;
