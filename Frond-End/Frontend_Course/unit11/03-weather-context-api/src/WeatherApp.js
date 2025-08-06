import React, { useContext } from "react";
import { WeatherContext, WeatherProvider } from "./WeatherContext";
import CityForm from "./CityForm";
import FavoritesList from "./FavoriteCities";

const WeatherContent = () => {
  const { city, weather, error } = useContext(WeatherContext);

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
      <CityForm />
      <FavoritesList />
    </div>
  );
};

const WeatherApp = () => (
  <WeatherProvider>
    <WeatherContent />
  </WeatherProvider>
);

export default WeatherApp;
