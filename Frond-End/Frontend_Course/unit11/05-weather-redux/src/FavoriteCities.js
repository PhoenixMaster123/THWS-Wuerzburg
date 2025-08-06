import React from "react";
import { useSelector, useDispatch } from "react-redux";
import { setCity } from "./store";

const FavoritesList = () => {
  const { favorites } = useSelector(state => state.weather);
  const dispatch = useDispatch();

  return (
    <div style={{ marginTop: "2em" }}>
      <h3>Favoriten</h3>
      {favorites.map((favCity) => (
        <button
          key={favCity}
          onClick={() => dispatch(setCity(favCity))}
          style={{ margin: "0.2em", padding: "0.5em 1em" }}
        >
          {favCity}
        </button>
      ))}
    </div>
  );
};

export default FavoritesList;