import React, { useEffect, useRef } from "react";

const CapturingExample = () => {
  const outerRef = useRef(null);
  const innerRef = useRef(null);

  useEffect(() => {
    const handleOuterCapture = () => {
      console.log("Outer div captured click");
    };

    const handleInnerCapture = () => {
      console.log("Inner div captured click");
    };

    const outer = outerRef.current;
    const inner = innerRef.current;

    // Register listeners in capturing phase
    outer.addEventListener("click", handleOuterCapture, true);
    inner.addEventListener("click", handleInnerCapture, true);

    // Clean up
    return () => {
      outer.removeEventListener("click", handleOuterCapture, true);
      inner.removeEventListener("click", handleInnerCapture, true);
    };
  }, []);

  return (
    <div
      ref={outerRef}
      style={{
        padding: "40px",
        backgroundColor: "#f5f5dc",
        textAlign: "center",
      }}
    >
      Outer Div
      <div
        ref={innerRef}
        style={{
          margin: "20px auto",
          padding: "20px",
          width: "200px",
          backgroundColor: "#90ee90",
        }}
      >
        Inner Div
      </div>
    </div>
  );
};

export default CapturingExample;
