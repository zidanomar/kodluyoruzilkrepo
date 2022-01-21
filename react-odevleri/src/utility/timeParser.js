const timeParser = (currentTime = Date.now() / 1000) => {
  const timezone = 10800; // FUTURE UPDATE: TIMEZONE BASED ON PARAM
  const options = {
    weekday: 'long',
    year: 'numeric',
    month: 'long',
    day: 'numeric',
  };

  const parseTime = new Date(currentTime + timezone).toString().split(' ')[4];

  const parseDate = new Date(currentTime * 1000 + timezone)
    .toLocaleString('en-US', options)
    .toString();

  const day = parseDate.split(',')[0];
  const date = parseDate.split(',')[1].trim().split(' ')[1];
  const month = parseDate.split(',')[1].trim().split(' ')[0];
  const year = parseDate.split(',')[2];

  const obj = {
    day,
    date,
    month,
    year,
    time: parseTime,
  };

  return obj;
};

export default timeParser;
