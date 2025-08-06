import React, { useState, useEffect } from "react";
import CityForm from "./CityForm";
import FavoritesList from "./FavoritesList";

const API_KEY = "5e0d1720deb6453e9b6160442252605";

const WeatherApp = () => {
  const [city, setCity] = useState("Würzburg");
  const [weather, setWeather] = useState(null);
  const [error, setError] = useState(null);
  const [favorites, setFavorites] = useState(["Berlin", "München"]);

  const fetchWeather = async (cityName) => {
    try {
      const response = await fetch(
        `https://api.weatherapi.com/v1/current.json?key=${API_KEY}&q=${encodeURIComponent(
          cityName
        )}&lang=en`
      );
      if (!response.ok) throw new Error("City not found");
      const data = await response.json();
      setWeather(data);
      setError(null);
    } catch (err) {
      setError(err.message);
      setWeather(null);
    }
  };

  useEffect(() => {
    fetchWeather(city);
  }, [city]);

  const addFavorite = (cityName) => {
    if (!favorites.includes(cityName)) {
      setFavorites([...favorites, cityName]);
    }
  };

  return (
    <div style={{ textAlign: "center", fontFamily: "Arial" }}>
      <h1>Weather in {city}</h1>

      {error && <p style={{ color: "red" }}>{error}</p>}

      {weather && (
        <div>
          <h2>{weather.current.temp_c.toFixed(1)}°C</h2>
          <img
            src={weather.current.condition.icon}
            alt=""
            style={{ width: 50, height: 50 }}
          />
        </div>
      )}

      <CityForm setCity={setCity} addFavorite={addFavorite} />
      <FavoritesList favorites={favorites} setCity={setCity} />
    </div>
  );
};

export default WeatherApp;
