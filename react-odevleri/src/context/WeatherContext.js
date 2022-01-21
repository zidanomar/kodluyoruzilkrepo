import React, { createContext, useState } from 'react';
import useWeather from '../hooks/useWeather';

export const WeatherContext = createContext({
  weather: {},
  forecast: [],
  isLoading: false,
  currentCity: {},
  changeCityHandler: (city) => {},
});

const WeatherContextProvider = ({ children }) => {
  const [city, setCity] = useState({
    id: 54,
    name: 'Sakarya',
    latitude: '40.6940',
    longitude: '30.4358',
    population: 953181,
    region: 'Marmara',
  });

  const { weather, forecast, isLoading } = useWeather(city);

  const changeCityHandler = (city) => {
    setCity(city);
  };

  const weatherContext = {
    weather,
    forecast,
    isLoading,
    currentCity: city,
    changeCityHandler,
  };
  return (
    <WeatherContext.Provider value={weatherContext}>
      {children}
    </WeatherContext.Provider>
  );
};

export default WeatherContextProvider;
