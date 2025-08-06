import React from "react";

const BubblingExample = () => {
  const handleOuterClick = () => {
    console.log("Outer div clicked");
  };

  const handleInnerClick = () => {
    console.log("Inner div clicked");
  };

  return (
    <div
      onClick={handleOuterClick}
      style={{
        padding: "40px",
        backgroundColor: "#f0f0f0",
        textAlign: "center",
      }}
    >
      Outer Div
      <div
        onClick={handleInnerClick}
        style={{
          margin: "20px auto",
          padding: "20px",
          width: "200px",
          backgroundColor: "#add8e6",
        }}
      >
        Inner Div
      </div>
    </div>
  );
};

export default BubblingExample;
