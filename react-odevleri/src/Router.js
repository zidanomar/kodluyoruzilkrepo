import React from 'react';
import { Routes, Route, Link } from 'react-router-dom';
import Footer from './components/Footer';
import Header from './components/Header';
import { FetchOdevi, Home } from './pages';

function Router() {
  return (
    <React.Fragment>
      <Header />
      <Routes>
        <Route path='/' element={<Home />} />
        <Route path='/odev1' element={<FetchOdevi />} />
      </Routes>
      <Footer />
    </React.Fragment>
  );
}

export default Router;
