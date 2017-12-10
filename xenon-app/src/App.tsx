import * as React from 'react';
import './App.css';

const logo = require('./assets/xe-logo.svg');

import { Navbar, NavbarDivider, NavbarGroup, NavbarHeading } from '@blueprintjs/core';

export default function App() {
  return (
    <div>
      <Navbar>
        <NavbarGroup align="left">
          <NavbarHeading>
            <img src={logo} style={{width: '48px'}} alt="logo" />
          </NavbarHeading>
          <NavbarDivider />
          <button className="pt-button pt-minimal">
            Tab
          </button>
        </NavbarGroup>

        <NavbarGroup align="right">
          <button className="pt-button pt-minimal">
            Tab
          </button>
        </NavbarGroup>
      </Navbar>
    </div>
  );
}
