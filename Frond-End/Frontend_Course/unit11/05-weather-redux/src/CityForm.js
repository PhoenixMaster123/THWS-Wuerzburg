import React, { useState } from "react";
import { useDispatch } from "react-redux";
import { setCity, addFavorite } from "./store";

const CityForm = () => {
  const [input, setInput] = useState("");
  const dispatch = useDispatch();

  const handleSubmit = (e) => {
    e.preventDefault();
    const cityName = input.trim();
    if (cityName !== "") {
      dispatch(setCity(cityName));
      dispatch(addFavorite(cityName));
      setInput("");
    }
  };

  return (
    <form onSubmit={handleSubmit} style={{ marginTop: "2em" }}>
      <input
        type="text"
        value={input}
        placeholder="Enter city"
        onChange={(e) => setInput(e.target.value)}
        style={{ padding: "0.5em", fontSize: "1em" }}
      />
      <button type="submit" style={{ marginLeft: "0.5em", padding: "0.5em 1em" }}>
        Search
      </button>
    </form>
  );
};

export default CityForm;