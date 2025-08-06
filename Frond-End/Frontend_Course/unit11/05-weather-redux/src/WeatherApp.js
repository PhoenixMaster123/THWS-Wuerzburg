import React, { useEffect } from "react";
import { Provider, useDispatch, useSelector } from "react-redux";
import store from "./store";
import CityForm from "./CityForm";
import FavoritesList from "./FavoriteCities";
import { setWeather, setError } from "./store";

const API_KEY = "5e0d1720deb6453e9b6160442252605";

const WeatherContent = () => {
  const dispatch = useDispatch();
  const { city, weather, error } = useSelector(state => state.weather);

  useEffect(() => {
    const fetchWeather = async () => {
      try {
        const response = await fetch(
          `https://api.weatherapi.com/v1/current.json?key=${API_KEY}&q=${encodeURIComponent(city)}&lang=en`
        );
        if (!response.ok) throw new Error("City not found");
        const data = await response.json();
        dispatch(setWeather(data));
      } catch (err) {
        dispatch(setError(err.message));
      }
    };

    fetchWeather();
  }, [city, dispatch]);

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
  <Provider store={store}>
    <WeatherContent />
  </Provider>
);

export default WeatherApp;