import { Grid, Heading, Text, VStack } from '@chakra-ui/react';
import React, { useContext } from 'react';
import { WeatherContext } from '../../context/WeatherContext';
import timeParser from '../../utility/timeParser';
import WeatherCard from './WeatherCard';

function MainContent() {
  const { forecast, isLoading } = useContext(WeatherContext);

  return (
    <VStack w='75%' minH='100vh' p='10' spacing={8}>
      <Heading textAlign='center'>7 Days Forecast</Heading>
      {isLoading ? (
        <Text>Loading...</Text>
      ) : (
        <Grid w='100%' templateColumns='repeat(4, 1fr)' gap={6} margin='auto'>
          {forecast.map((f) => {
            const { day, date, month } = timeParser(f.dt);

            const description = f.weather[0].description.replace(
              /(^\w{1})|(\s+\w{1})/g,
              (letter) => letter.toUpperCase()
            );

            const image = f.weather[0].icon;
            const min = f.temp.min;
            const max = f.temp.max;

            return (
              <WeatherCard
                key={f.dt}
                day={day}
                date={date}
                month={month}
                image={image}
                description={description}
                min={min}
                max={max}
              />
            );
          })}
        </Grid>
      )}
    </VStack>
  );
}

export default MainContent;
