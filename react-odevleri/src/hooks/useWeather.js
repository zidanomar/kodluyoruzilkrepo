import axios from 'axios';
import { useEffect, useState } from 'react';

function useWeather(city) {
  // gün adı, hava durumu görseli(güneşli, yağmurlu, karlı, parçalı bulutlu), en yüksek ve en düşük sıcaklık gösterilmelidir.
  const [weather, setWeather] = useState({});
  const [forecast, setForecast] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  const latitude = city.length > 0 ? city[0]?.latitude : 40.694;
  const longitude = city.length > 0 ? city[0]?.longitude : 30.4358;

  useEffect(() => {
    setIsLoading(true);
    axios
      .get(
        `https://api.openweathermap.org/data/2.5/onecall?lat=${city?.latitude}&lon=${city?.longitude}&units=metric&appid=${process.env.REACT_APP_OPENWEATHER_KEY}`
      )
      .then(({ data }) => {
        const array = data.daily.slice(1);

        setWeather(data.daily[0]);
        setForecast(array);
        setIsLoading(false);
      })
      .catch((error) => {
        console.error(error);
        setIsLoading(false);
      });
  }, [city, latitude, longitude]);

  return { weather, forecast, isLoading };
}

export default useWeather;
