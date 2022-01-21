import { Flex, Image, Text, VStack } from '@chakra-ui/react';
import React from 'react';

function WeatherCard({ day, date, month, image, description, min, max }) {
  return (
    <VStack backgroundColor='white' borderRadius='8' spacing='4' py='6'>
      <Flex flexDirection='column' alignItems='center'>
        <Text>{day}</Text>
        <Text>
          {date}, {month}
        </Text>
      </Flex>
      <Flex>
        <Image
          src={`http://openweathermap.org/img/w/${image}.png`}
          alt='weather'
        />
      </Flex>
      <Flex>
        <Text fontWeight='bold'>{description}</Text>
      </Flex>
      <Flex gap='6'>
        <Text color='teal.300'>{max} °c</Text>
        <Text color='blue.300'>{min} °c</Text>
      </Flex>
    </VStack>
  );
}

export default WeatherCard;
