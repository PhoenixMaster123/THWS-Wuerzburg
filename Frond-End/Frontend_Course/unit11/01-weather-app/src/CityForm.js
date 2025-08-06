import React, { useState } from "react";

const CityForm = ({ setCity, addFavorite }) => {
  const [input, setInput] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    const cityName = input.trim();
    if (cityName !== "") {
      setCity(cityName);
      addFavorite(cityName);
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
