import React from 'react';
import { Routes, Route } from 'react-router-dom';
import App from './App';

import { FetchAssignment, Home, TodoList, Weather } from './pages';

function Router() {
  return (
    <Routes>
      <Route path='/' element={<App />}>
        <Route index element={<Home />} />
        <Route path='fetchAssignment' element={<FetchAssignment />} />
        <Route path='todolist' element={<TodoList />} />
        <Route path='weather' element={<Weather />} />
      </Route>
    </Routes>
  );
}

export default Router;
