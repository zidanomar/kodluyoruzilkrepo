import React, { useContext } from 'react';
import cities from '../../utility/cities.json';
import { Select } from '@chakra-ui/react';
import { WeatherContext } from '../../context/WeatherContext';

function Dropdown() {
  const { changeCityHandler } = useContext(WeatherContext);

  const handleChange = (e) => {
    changeCityHandler(cities.filter((x) => x.id === +e.target.value)[0]);
  };

  return (
    <Select
      backgroundColor='teal.50'
      placeholder='Select City'
      onChange={handleChange}
    >
      {cities.map((c) => {
        return (
          <option key={c.id} value={c.id}>
            {c.name}
          </option>
        );
      })}
    </Select>
  );
}

export default Dropdown;
