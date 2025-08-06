import React, { createContext, useState, useEffect } from "react";

export const WeatherContext = createContext();

const API_KEY = "5e0d1720deb6453e9b6160442252605";

export const WeatherProvider = ({ children }) => {
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
    <WeatherContext.Provider value={{ city, setCity, weather, error, favorites, addFavorite }}>
      {children}
    </WeatherContext.Provider>
  );
};
