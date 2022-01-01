import React from 'react';
import { Container, Heading, HStack } from '@chakra-ui/react';
import { Link } from 'react-router-dom';

function Header() {
  return (
    <HStack py='5' boxShadow='sm' bg='white'>
      <Container
        display='flex'
        maxW={'container.xl'}
        alignItems='center'
        justifyContent='space-between'
      >
        <Link to='/'>
          <Heading as='h3' size='md' color='teal.300'>
            Home
          </Heading>
        </Link>
      </Container>
    </HStack>
  );
}

export default Header;
