import CityForm from "./CityForm";
import { useState } from "react";
import { useEffect } from "react";

const API_KEY = "160df069de0f4703947102403250306";

const WeatherApp = () => {
  const [city, setCity] = useState("Würzburg");
  const [input, setInput] = useState("");
  const [weather, setWeather] = useState(null);
  const [error, setError] = useState(null);

  // Fetch weather data
  const fetchWeather = async (cityName) => {
    try {
       let response = await fetch(
      `https://api.weatherapi.com/v1/current.json?key=${API_KEY}&q=${cityName}`);

      let data = await response.json()

      setWeather(data);
      setCity(cityName);
      setError(null);
    } catch(err) {
      setWeather("")
      setCity("")
      setError(err)
    }
  }

  useEffect(() => {
   fetchWeather(city)
  }, [])
  
  return (
    <div style={{ fontFamily: "Arial", textAlign: "center", marginTop: "2em" }}>
      <h1>Weather in {city}</h1>

      <CityForm onCityChange={setCity} />

      {error && <p style={{ color: "red" }}>{error}</p>}

      {weather && (
        <div style={{ marginTop: "1em" }}>
          <p>
            <strong>Temperature:</strong> {weather.current.temp_c} °C
          </p>
          <p>
            <strong>Condition:</strong> {weather.current.condition.text}
          </p>
          <img src={weather.current.condition.icon} alt="weather icon" />
        </div>
      )}
    </div>
  );
};

export default WeatherApp;
