import { Heading, Image, Text, VStack } from '@chakra-ui/react';
import React, { useContext } from 'react';
import { WeatherContext } from '../../context/WeatherContext';
import timeParser from '../../utility/timeParser';
import Dropdown from './Dropdown';

function Sidebar() {
  const { weather, currentCity, isLoading } = useContext(WeatherContext);
  const { day, date, month, year, time } = timeParser(weather.dt);

  let description;
  let icon;

  if (!isLoading) {
    description = weather.weather[0].description.replace(
      /(^\w{1})|(\s+\w{1})/g,
      (letter) => letter.toUpperCase()
    );
    icon = weather.weather[0].icon;
  }
  return (
    <VStack w='25%' h='100vh' background='white' p='10' spacing={8}>
      {isLoading ? (
        <Text>Loading...</Text>
      ) : (
        <>
          <VStack w='100%' spacing={6} align='flex-start'>
            <Dropdown />
          </VStack>
          <VStack w='100%' align='flex-start'>
            <Heading>{currentCity.name}</Heading>
            <Text>{`${day}, ${date} ${month} ${year}`}</Text>
            <Text>{`Last update: ${time}`}</Text>
          </VStack>
          <VStack w='100%' align='flex-start'>
            <Image
              src={`http://openweathermap.org/img/w/${icon}.png`}
              alt='weather'
            />
            <Text>{description}</Text>
            <Text>Lowest Temp : {weather?.temp?.min} °c</Text>
            <Text>High Temp : {weather?.temp?.max} °c</Text>
          </VStack>
        </>
      )}
    </VStack>
  );
}

export default Sidebar;
