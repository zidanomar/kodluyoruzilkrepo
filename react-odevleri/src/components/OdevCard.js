import { Badge, Box, Image } from '@chakra-ui/react';
import { StarIcon } from '@chakra-ui/icons';
import React from 'react';
import { Link } from 'react-router-dom';

function OdevCard({ assignment }) {
  const { path, imageUrl, title, level = 1 } = assignment;

  let difficulty;

  switch (level) {
    case 1:
      difficulty = 'Super Easy';
      break;
    case 2:
      difficulty = 'Easy';
      break;
    case 3:
      difficulty = 'Medium';
      break;
    case 4:
      difficulty = 'Hard';
      break;
    case 5:
      difficulty = 'Hell';
      break;
    default:
      difficulty = 'Super easy';
  }

  return (
    <Link to={path}>
      <Box
        width='100%'
        maxW='sm'
        backgroundColor='white'
        borderRadius='lg'
        overflow='hidden'
        transition='200ms all ease-in-out'
        _hover={{
          cursor: 'pointer',
          transform: 'scale(1.05)',
        }}
      >
        <Image src={imageUrl} alt='card image' />

        <Box p='6'>
          <Box display='flex' alignItems='baseline'>
            <Badge borderRadius='full' px='2' colorScheme='teal'>
              React
            </Badge>
          </Box>

          <Box mt='1' fontWeight='semibold' as='h4' lineHeight='tight'>
            {title}
          </Box>

          <Box mt='2' isTruncated>
            <Box as='span' color='gray.600' fontSize='sm'>
              {difficulty}
            </Box>
          </Box>

          <Box display='flex' mt='' alignItems='center'>
            {Array(5)
              .fill('')
              .map((_, i) => (
                <StarIcon key={i} color={i < level ? 'teal.500' : 'gray.300'} />
              ))}
          </Box>
        </Box>
      </Box>
    </Link>
  );
}

export default OdevCard;
