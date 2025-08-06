import React from "react";
import { useSelector, useDispatch } from "react-redux";
import { increment } from "./store";

const OnlyDisplayComponent = () => {
  const { count, text } = useSelector((state) => state.demo);

  return (
    <div>
      <h1>Inner Component</h1>
      <p>Count: {count}</p>
      <p>Text: {text}</p>
    </div>
  );
};

const OnlyEditComponent = () => {
  const dispatch = useDispatch();

  const handleIncrease = () => {
    dispatch(increment(5));
  };

  return (
    <div>
      <h1>Edit Component</h1>
      <button onClick={handleIncrease}>Increase Count</button>
    </div>
  );
};

export { OnlyDisplayComponent, OnlyEditComponent };
