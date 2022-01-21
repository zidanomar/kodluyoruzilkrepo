import * as React from 'react';
import { ChakraProvider } from '@chakra-ui/react';
import theme from './utility/theme';
import Header from './components/Header';
import { Outlet } from 'react-router-dom';
import Footer from './components/Footer';

function App() {
  return (
    <ChakraProvider theme={theme}>
      <Header />
      <Outlet />
      <Footer />
    </ChakraProvider>
  );
}

export default App;
