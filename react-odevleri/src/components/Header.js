import React from 'react';
import { Container, HStack, Link } from '@chakra-ui/react';
import { Link as ReachLink } from 'react-router-dom';

function Header() {
  return (
    <HStack py='5' boxShadow='sm' bg='white'>
      <Container
        display='flex'
        maxW={'container.xl'}
        alignItems='center'
        justifyContent='space-between'
      >
        <div>Home</div>
        <HStack spacing={10}>
          <ReachLink to='/'>
            <Link>Home</Link>
          </ReachLink>
          <ReachLink to='/1'>
            <Link>Odev 1</Link>
          </ReachLink>
          <ReachLink to='/2'>
            <Link>Odev 2</Link>
          </ReachLink>
        </HStack>
      </Container>
    </HStack>
  );
}

export default Header;
