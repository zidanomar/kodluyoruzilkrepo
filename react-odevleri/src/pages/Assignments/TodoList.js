import {
  Box,
  Button,
  Flex,
  Input,
  List,
  ListIcon,
  ListItem,
  Text,
} from '@chakra-ui/react';
import { MdDone, MdDoneAll } from 'react-icons/md';
import React, { useState } from 'react';

const taskList = [
  {
    id: 1,
    task: 'Learn Web Development',
    finnished: true,
  },
  {
    id: 2,
    task: 'Finish Patika Frontend Courses',
    finnished: false,
  },
  {
    id: 3,
    task: 'Join Kodluyoruz Bootcamp',
    finnished: false,
  },
];

function TodoList() {
  const [newTask, setNewTask] = useState('');
  const [tasks, setTasks] = useState(taskList);
  const [filterState, setFilterState] = useState('all');

  const taskLeft = tasks.filter((t) => !t.finnished).length;

  const addTaskHandler = () => {
    if (newTask) {
      const newTaskObj = {
        id: Date.now(),
        task: newTask,
        finnished: false,
      };
      setTasks((prevValue) => [...prevValue, newTaskObj]);
    }
    setNewTask('');
  };

  const togleTaskHandler = (taskId) => {
    const updatedTodo = tasks.map((t) => {
      if (t.id === taskId) t.finnished = !t.finnished;
      return t;
    });

    setTasks(updatedTodo);
  };

  const todoList =
    filterState === 'all'
      ? tasks
      : filterState === 'done'
      ? tasks.filter((t) => t.finnished === true)
      : tasks.filter((t) => t.finnished === false);

  const stateHandler = (state) => {
    setFilterState(state);
  };

  const deleteTaskHandler = () => {
    setTasks((prevValue) => prevValue.filter((val) => !val.finnished));
  };

  return (
    <Flex h='100vh' alignItems='center' py='16' flexDirection='column'>
      <Text as='h1' color='teal.300' fontSize='4xl' fontWeight='bold'>
        Todo List
      </Text>
      <Box
        w='lg'
        maxW='100%'
        backgroundColor='white'
        borderRadius={8}
        mt={8}
        p={8}
      >
        <Flex gap={4} mb={8}>
          <Input value={newTask} onChange={(e) => setNewTask(e.target.value)} />
          <Button
            onClick={addTaskHandler}
            variant='solid'
            backgroundColor='teal.300'
            color='white'
            _hover={{ color: 'teal.300', backgroundColor: 'teal.500' }}
          >
            add
          </Button>
        </Flex>
        <List spacing={3}>
          {/* filtered to do */}
          {todoList?.map((task) => {
            return (
              <ListItem
                key={task.id}
                display='inline-flex'
                width='100%'
                padding='4'
                borderRadius='4'
                color={task.finnished ? 'gray.200' : 'teal.300'}
                alignItems='center'
                transition='300ms all ease-in-out'
                _hover={{
                  cursor: 'pointer',
                  backgroundColor: 'gray.100',
                  '> div .finnish-btn ': {
                    color: 'purple.500',
                    backgroundColor: 'pink.500',
                    opacity: '1',
                  },
                }}
              >
                <Flex alignItems='center' width='100%'>
                  <ListIcon as={task.finnished ? MdDoneAll : MdDone} mr={4} />
                  <Text
                    as='p'
                    mr='auto'
                    textDecoration={task.finnished ? 'line-through' : 'none'}
                  >
                    {task.task}
                  </Text>
                  <Box
                    w='25%'
                    className='finnish-btn'
                    padding='2'
                    borderRadius='4'
                    backgroundColor='purple.300'
                    opacity='0'
                    transition='300ms all ease-in-out'
                    onClick={() => togleTaskHandler(task.id)}
                  >
                    <Text fontSize='sm' textAlign='center' color='white'>
                      {task.finnished ? 'restore' : 'done'}
                    </Text>
                  </Box>
                </Flex>
              </ListItem>
            );
          })}
        </List>
        {/* action */}
        <Flex marginTop='8' justifyContent='center'>
          <Text as='h5'>
            {taskLeft > 1
              ? `${taskLeft} tasks left`
              : taskLeft === 1
              ? `${taskLeft} task left`
              : 'all done'}
          </Text>
        </Flex>
        <Flex
          marginTop='4'
          alignItems='center'
          flexWrap='wrap'
          justifyContent='space-around'
        >
          <Flex gap='4'>
            <Box
              onClick={() => stateHandler('all')}
              padding='2'
              borderRadius='4'
              backgroundColor='teal.50'
              transition='300ms all ease-in-out'
              _hover={{
                cursor: 'pointer',
                background: 'teal.100',
                color: 'teal.500',
              }}
            >
              <Text>All</Text>
            </Box>
            <Box
              onClick={() => stateHandler('done')}
              padding='2'
              borderRadius='4'
              backgroundColor='teal.50'
              transition='300ms all ease-in-out'
              _hover={{
                cursor: 'pointer',
                background: 'teal.100',
                color: 'teal.500',
              }}
            >
              <Text>Finished</Text>
            </Box>
            <Box
              onClick={() => stateHandler('todo')}
              padding='2'
              borderRadius='4'
              backgroundColor='teal.50'
              transition='300ms all ease-in-out'
              _hover={{
                cursor: 'pointer',
                background: 'teal.100',
                color: 'teal.500',
              }}
            >
              <Text>To Do</Text>
            </Box>
          </Flex>
          {tasks.filter((t) => t.finnished).length > 0 && (
            <Box
              onClick={deleteTaskHandler}
              padding='2'
              borderRadius='4'
              backgroundColor='red.300'
              transition='300ms all ease-in-out'
              _hover={{
                cursor: 'pointer',
                background: 'red.500',
                color: 'red.300',
              }}
            >
              <Text fontSize='sm' textAlign='center' color='white'>
                Delete Completed
              </Text>
            </Box>
          )}
        </Flex>
      </Box>
    </Flex>
  );
}

export default TodoList;
