import { Box } from '@chakra-ui/react';
import React from 'react';
import { Routes, Route } from 'react-router-dom';

import Footer from './components/Footer';
import Header from './components/Header';
import { FetchAssignment, Home, TodoList } from './pages';

function Router() {
  return (
    <Box backgroundColor='gray.50'>
      <Header />
      <Routes>
        <Route path='/' element={<Home />} />
        <Route path='/fetchAssignment' element={<FetchAssignment />} />
        <Route path='/todolist' element={<TodoList />} />
      </Routes>
      <Footer />
    </Box>
  );
}

export default Router;
