import { useState, useEffect } from 'react';
import getData from './getData';

function FetchOdevi() {
  const [userData, setUserData] = useState(null);

  useEffect(() => {
    const fetched = getData(1);
    setUserData(fetched);
    console.log(userData);
  }, []);

  return <div>fetch</div>;
}

export default FetchOdevi;
