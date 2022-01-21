import { HStack } from '@chakra-ui/react';
import React from 'react';
import MainContent from '../../components/Weather/MainContent';
import Sidebar from '../../components/Weather/Sidebar';
import WeatherContextProvider from '../../context/WeatherContext';

function Weather() {
  return (
    <WeatherContextProvider>
      <HStack minH={'100vh'}>
        {/* Left */}
        <Sidebar />

        {/* Right */}
        <MainContent />
      </HStack>
    </WeatherContextProvider>
  );
}

export default Weather;
