import { useState } from "react";

const CityForm = ({ onCityChange }) => {
  const [input, setInput] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    if (input.trim()) {
      onCityChange(input.trim());
    }
  };

  return (
    <form onSubmit={handleSubmit} style={{ marginBottom: "1em" }}>
      <label>
        Enter city:
        <input
          type="text"
          value={input}
          onChange={(e) => setInput(e.target.value)}
          style={{
            padding: "0.5em",
            margin: "0.5em",
            fontSize: "1em",
            fontWeight: "bold",
          }}
        />
      </label>
      <button type="submit" style={{ marginLeft: "1em", padding: "0.5em" }}>
        Search
      </button>
    </form>
  );
};

export default CityForm;
