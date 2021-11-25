let username = document.getElementById('username');
let clock = document.getElementById('clock');
let time;

username.innerHTML = prompt('username : ');

function twoDigit(val) {
  return ('0' + val).slice(-2);
}

function getTime() {
  var date = new Date();
  var hour = date.getHours();
  var minute = date.getMinutes();
  var second = date.getSeconds();

  var days = [
    'Sunday',
    'Monday',
    'Tuesday',
    'Wednesday',
    'Thursday',
    'Friday',
    'Saturday',
  ];
  var day = days[date.getDay()];

  time = `${twoDigit(hour)} : ${twoDigit(minute)} : ${twoDigit(second)} ${day}`;

  clock.innerHTML = time;

  setTimeout('getTime()', 1000);
}

getTime();
