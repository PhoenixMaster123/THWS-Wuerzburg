import React from "react";

const ChildComponent = ({ onMessageChange }) => {
  const handleInput = (e) => {
    onMessageChange(e.target.value);
  };

  return (
    <div>
      <h3>Child Component</h3>
      <input
        type="text"
        placeholder="Type something"
        onChange={handleInput}
        style={{ padding: "0.5em", fontSize: "1em" }}
      />
    </div>
  );
};

export default ChildComponent;
