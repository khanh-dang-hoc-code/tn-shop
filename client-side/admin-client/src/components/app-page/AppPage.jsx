import React from 'react';
import './index.scss';
import propTypes from 'prop-types';
import { Breadcrumbs } from '@material-ui/core';

const AppPage = ({ renderChild, title, pathLocation }) => {
  const pathLocationString = pathLocation.join(' / ');

  return (
    <section className="app-page">
      <div className="app-page--header flex">
        <div className="title">{title}</div>
        <div className="location-path">
          <Breadcrumbs aria-label="breadcrumb">
            <span>{pathLocationString}</span>
          </Breadcrumbs>
        </div>
      </div>

      <div className="app-page--content">{renderChild()}</div>
    </section>
  );
};

AppPage.propTypes = {
  renderChild: propTypes.node,
  title: propTypes.string,
  pathLocation: propTypes.array
};

export default AppPage;
