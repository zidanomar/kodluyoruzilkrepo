import { Container, Grid, Text } from '@chakra-ui/react';
import React from 'react';
import OdevCard from '../../components/OdevCard';
import { assignments } from '../../utility/assignments';

function Home() {
  return (
    <Container maxW='container.xl' minH='100vh' py='10'>
      {!assignments ? (
        <Text>Loading...</Text>
      ) : (
        <Grid
          templateColumns={{
            sm: 'repeat(1, 1fr)',
            md: 'repeat(3, 1fr)',
            lg: 'repeat(4, 1fr)',
          }}
          gap={6}
          justifyItems='center'
          alignItems='center'
        >
          {assignments.map((assignment) => (
            <OdevCard key={assignment.id} assignment={assignment} />
          ))}
        </Grid>
      )}
    </Container>
  );
}

export default Home;
