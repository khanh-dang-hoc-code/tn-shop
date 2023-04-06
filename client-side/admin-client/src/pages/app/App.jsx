import React from 'react';
import './app.scss';
import Header from '../../components/header/Header';
import { Route, Routes } from 'react-router-dom';
import Dashboard from '../dashboard/Dashboard';
import Login from '../login/Login';

const App = () => {
  return (
    <div id="container">
      {/* <Header /> */}
      {/* <div className="container-left">
        <AppDrawer isOpen={false} />
      </div> */}
      {/* <div className="content">
        <Routes>
          <Route path="/dash-board" element={<Dashboard />} />
        </Routes>
      </div> */}

      <Login />
    </div>
  );
};

export default App;
