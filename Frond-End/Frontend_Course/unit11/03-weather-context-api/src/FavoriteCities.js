import React, { useContext } from "react";
import { WeatherContext } from "./WeatherContext";

const FavoritesList = () => {
  const { favorites, setCity } = useContext(WeatherContext);

  return (
    <div style={{ marginTop: "2em" }}>
      <h3>Favoriten</h3>
      {favorites.map((favCity) => (
        <button
          key={favCity}
          onClick={() => setCity(favCity)}
          style={{ margin: "0.2em", padding: "0.5em 1em" }}
        >
          {favCity}
        </button>
      ))}
    </div>
  );
};

export default FavoritesList;