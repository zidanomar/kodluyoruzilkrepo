import { Box, Container, Text } from '@chakra-ui/react';
import axios from 'axios';
import React, { useEffect, useState } from 'react';

function FetchAssignment() {
  const [fetchedData, setFetchedData] = useState(null);
  useEffect(() => {
    const fetchData = async () => {
      const { data: user } = await axios.get(
        'https://jsonplaceholder.typicode.com/users/1'
      );
      const { data: posts } = await axios.get(
        'https://jsonplaceholder.typicode.com/posts?userId=1'
      );
      setFetchedData({ ...user, posts });
    };
    fetchData();
  }, []);

  return (
    <Container maxW='container.xl' minH='100vh' py='10'>
      {fetchedData ? (
        <Box maxW='xs' padding={6} backgroundColor='white'>
          <Text color='teal.400'>{fetchedData.name}</Text>
          <Text color='teal.400'>{`Total Post: ${fetchedData.posts.length}`}</Text>
        </Box>
      ) : (
        <Text>Loading...</Text>
      )}
    </Container>
  );
}

export default FetchAssignment;
